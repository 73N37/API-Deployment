package dat.Controllers.impl;
import dat.Annotations.RouteHandler;
import dat.Controllers.InterfaceController;
import dat.DTOs.AbstractDTO;
import dat.Entities.AbstractEntity;
import dat.Factories.AbstractFactory;
import dat.Services.InterfaceService;
import io.javalin.http.Context;
import io.javalin.http.HandlerType;
import io.javalin.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.Set;

public abstract class AbstractController<   Entity  extends AbstractEntity,
                                            DTO     extends AbstractDTO,
                                            ID      extends Serializable>
                                                    extends AbstractFactory<  Entity, DTO, ID>
                                            implements InterfaceController< Entity, DTO, ID> {

    private static final Logger log = LoggerFactory.getLogger(AbstractController.class);
    protected final InterfaceService<Entity, DTO, ID> service;

    protected AbstractController(InterfaceService< Entity, DTO, ID> service,
                                 Class<Entity>                      entityClass,
                                 Class<DTO>                         dtoClass,
                                 Class<ID>                          idClass) {
        super(entityClass, dtoClass, idClass);
        this.service = service;

    }

    @Override
    @RouteHandler(HandlerType.GET)
    public void read(Context ctx) {
        if (!validatePrimaryKey(ctx)) {
            return;
        }
        DTO dto = validateEntity(ctx);
        if (dto == null) {
            return;
        }
        ID id =  parseId(ctx.pathParam("id"));
        log.info("GET request for {} with ID: {} from IP: {}", dtoClass.getSimpleName(), id, ctx.ip());
        try {
            dto = service.read(id);
            if (dto != null) {
                log.debug("Received DTO= {} from service",dto.getClass());
                ctx.json(dto);
            } else {
                log.warn("{} not found with ID: {}", dtoClass.getSimpleName(), id);
                ctx.status(HttpStatus.NOT_FOUND).json("Resource not found");
            }
        } catch (Exception e){
            log.error("Error retrieving {} with ID: {}: {}", dtoClass.getSimpleName(), id, e.getMessage(), e);
            ctx.status(HttpStatus.BAD_REQUEST).json("Error retrieving resource: " + e.getMessage());
        }
    }

    @Override
    @RouteHandler(HandlerType.GET)
    public void readAll(Context ctx) {
        log.info("GET request for {} from IP: {}", dtoClass.getSimpleName(), ctx.ip());
        try {
            Set<DTO> data = service.readAllDTO();
            log.debug("Retrieved {} data from service", data.size());
            ctx.json(data);
        } catch (Exception e) {
            log.error("Error retrieving {} from IP: {}", dtoClass.getSimpleName(), ctx.ip(), e);
            ctx.status(HttpStatus.BAD_REQUEST).json("Error retrieving resource: " + e.getMessage());
        }
    }

    @Override
    @RouteHandler(HandlerType.POST)
    public void create(Context ctx) {
        DTO dto = validateEntity(ctx);
        if (dto == null) {
            return;
        }
        log.info("POST request to create {} from IP: {}",  dtoClass.getSimpleName(), ctx.ip());
        try {
            dto = ctx.bodyAsClass(dtoClass);
            log.debug("Parsed request body for {} creation", dtoClass.getSimpleName());
            DTO createdDTO = service.create(dto);
            log.info("Successfully created {} with service", dtoClass.getSimpleName());
            ctx.status(HttpStatus.CREATED).json(createdDTO);
        } catch (Exception e) {
            log.error("Failed to create {}: in service {}", dtoClass.getSimpleName(), e.getMessage(), e);
            ctx.status(HttpStatus.BAD_REQUEST).json("Error creating resource: " + e.getMessage());
        }
    }

    @Override
    @RouteHandler(HandlerType.PUT)
    public void update(Context ctx) {
        if (!validatePrimaryKey(ctx)) {
            return;
        }
        DTO dto = validateEntity(ctx);
        if (dto == null) {
            return;
        }
        ID id = parseId(ctx.pathParam("id"));
        log.info("PUT request to update {} with ID: {} from IP: {}", dtoClass.getSimpleName(), id, ctx.ip());
        try{
            dto = ctx.bodyAsClass(dtoClass);
            log.debug("Parsed request body for {} update with ID: {}", dtoClass.getSimpleName(), id);
            DTO dataEntry = service.update(id, dto);
            if (dataEntry != null) {
                log.info("Successfully updated {} with ID: {}", dtoClass.getSimpleName(), id);
                ctx.json(dataEntry);
            } else {
                log.warn("{} not found for update with ID: {}", dtoClass.getSimpleName(), id);
                ctx.status(HttpStatus.NOT_FOUND).json("Resource not found");
            }
        } catch (Exception e){
            log.error("Error updating {} with ID: {}: {}", dtoClass.getSimpleName(), id, e.getMessage(), e);
            ctx.status(HttpStatus.BAD_REQUEST).json("Error updating resource: " + e.getMessage());
        }
    }

    @Override
    @RouteHandler(HandlerType.DELETE)
    public void delete(Context ctx) {
        ID id = null;
        try{
            id = parseId(ctx.pathParam("id"));
        } catch (ClassCastException e){
            log.error("Was unable to parse id to either String, Integer or LONG");
        }
        log.info("DELETE request for {} with ID: {} from IP: {}", dtoClass.getSimpleName(), id, ctx.ip());
        try{
            service.delete(id);
            log.info("Successfully deleted {} with ID: {}", dtoClass.getSimpleName(), id);
            ctx.status(HttpStatus.NO_CONTENT).json("Successfully deleted resource");
        } catch (Exception e){                                                                                          // Since 'service.delete(ID id)' returns void this method can only throw an exception if the ID (parameter) isn't part of the DB.
            log.error("Error deleting {} with ID: {} from IP: {}", dtoClass.getSimpleName(), id, e.getMessage(), e);
            ctx.status(HttpStatus.INTERNAL_SERVER_ERROR).json("Unable too delete an entry in the database, based ond the Context-Object provided");
        }
    }

    private boolean validatePrimaryKey(Context ctx) {
        try {
            ID id = null;
            try {
                id = parseId(ctx.pathParam("id"));
            } catch (ClassCastException e){
                log.error("Was unable to parse id to either String, Integer or LONG");
            }
            log.info("Validating primary key {} from IP: {}", id, ctx.ip());
            DTO dto = service.read(id);                                                                                 // Only equal to NULL if there doesn't exist an entry in the database with the given ID
            if (dto != null) {
                log.debug("Validating primary key {} from DTO: {}", id, ctx.ip());
                return true;
            } else {
                log.warn("{} not found for primary key {}", dtoClass.getSimpleName(), id);
                ctx.status(HttpStatus.NOT_FOUND).json("Resource not found");
                return false;
            }
        } catch (Exception e){
            log.error("Error validating primary key: {}", e.getMessage(), e);
            ctx.status(HttpStatus.BAD_REQUEST).json("Invalid ID format");
            return false;
        }
    }

    private DTO validateEntity(Context ctx) {
        try {
            DTO dto = ctx.bodyAsClass(dtoClass);
            log.debug("Validating entity {} from DTO: {}", dtoClass.getSimpleName(), dto);
            return dto;
        } catch (Exception e){
            log.error("Error parsing request body as {}: {}", dtoClass.getSimpleName(), e.getMessage(), e);
            ctx.status(HttpStatus.BAD_REQUEST).json("Error validating entity");
            return null;
        }
    }
}
