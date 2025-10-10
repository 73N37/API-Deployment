package dat.controllers.impl;
import dat.controllers.InterfaceController;
import dat.dtos.AbstractDTO;
import dat.entities.AbstractEntity;
import dat.factories.AbstractClass;
import dat.services.InterfaceService;
import io.javalin.http.Context;
import io.javalin.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.Set;

public abstract class AbstractController<   Entity  extends AbstractEntity,
                                            DTO     extends AbstractDTO,
                                            ID      extends Serializable>
                                                    extends AbstractClass<Entity, DTO, ID>
                                            implements InterfaceController< Entity, DTO, ID> {

    private static final Logger logger = LoggerFactory.getLogger(AbstractController.class);
    protected final InterfaceService<Entity, DTO, ID> service;
    //protected abstract Class<DTO> getDTOClass();

    protected AbstractController(InterfaceService< Entity, DTO, ID> service,
                                 Class<Entity>                      entityClass,
                                 Class<DTO>                         dtoClass,
                                 Class<ID>                          idClass) {
        super(entityClass, dtoClass, idClass);
        this.service = service;

    }

    @Override
    public void read(Context ctx) {
        ID id =  parseId(ctx.pathParam("id"));
        logger.info("GET request for {} with ID: {} from IP: {}", dtoClass.getSimpleName(), id, ctx.ip());
        try {
            DTO dto = service.read(id);
            if (dto != null) {
                logger.debug("Received DTO= {} from service",dto.getClass());
                ctx.json(dto);
            } else {
                logger.warn("{} not found with ID: {}", dtoClass.getSimpleName(), id);
                ctx.status(HttpStatus.NOT_FOUND).json("Resource not found");
            }
        } catch (Exception e){
            logger.error("Error retrieving {} with ID: {}: {}", dtoClass.getSimpleName(), id, e.getMessage(), e);
            ctx.status(HttpStatus.BAD_REQUEST).json("Error retrieving resource: " + e.getMessage());
        }
    }

    @Override
    public void readAll(Context ctx) {
        logger.info("GET request for {} from IP: {}", dtoClass.getSimpleName(), ctx.ip());
        try {
            Set<DTO> data = service.readAllDTO();
            logger.debug("Retrieved {} data from service", data.size());
            ctx.json(data);
        } catch (Exception e) {
            logger.error("Error retrieving {} from IP: {}", dtoClass.getSimpleName(), ctx.ip(), e);
            ctx.status(HttpStatus.BAD_REQUEST).json("Error retrieving resource: " + e.getMessage());
        }
    }

    @Override
    public void create(Context ctx) {
        logger.info("POST request to create {} from IP: {}",  dtoClass.getSimpleName(), ctx.ip());
        try {
            DTO dto = ctx.bodyAsClass(dtoClass);
            logger.debug("Parsed request body for {} creation", dtoClass.getSimpleName());
            DTO createdDTO = service.create(dto);
            logger.info("Successfully created {} with service", dtoClass.getSimpleName());
            ctx.status(HttpStatus.CREATED).json(createdDTO);
        } catch (Exception e) {
            logger.error("Failed to create {}: in service {}", dtoClass.getSimpleName(), e.getMessage(), e);
            ctx.status(HttpStatus.BAD_REQUEST).json("Error creating resource: " + e.getMessage());
        }
    }

    @Override
    public void update(Context ctx) {
        ID id = parseId(ctx.pathParam("id"));
        logger.info("PUT request to update {} with ID: {} from IP: {}", dtoClass.getSimpleName(), id, ctx.ip());
        try{
            DTO dto = ctx.bodyAsClass(dtoClass);
            logger.debug("Parsed request body for {} update with ID: {}", dtoClass.getSimpleName(), id);
            DTO dataEntry = service.update(id, dto);
            if (dataEntry != null) {
                logger.info("Successfully updated {} with ID: {}", dtoClass.getSimpleName(), id);
                ctx.json(dataEntry);
            } else {
                logger.warn("{} not found for update with ID: {}", dtoClass.getSimpleName(), id);
                ctx.status(HttpStatus.NOT_FOUND).json("Resource not found");
            }
        } catch (Exception e){
            logger.error("Error updating {} with ID: {}: {}", dtoClass.getSimpleName(), id, e.getMessage(), e);
            ctx.status(HttpStatus.BAD_REQUEST).json("Error updating resource: " + e.getMessage());
        }
    }

    @Override
    public void delete(Context ctx) {
        ID id = parseId(ctx.pathParam("id"));
        logger.info("DELETE request for {} with ID: {} from IP: {}", dtoClass.getSimpleName(), id, ctx.ip());
        try{
            service.delete(id);
            logger.info("Successfully deleted {} with ID: {}", dtoClass.getSimpleName(), id);
            ctx.status(HttpStatus.NO_CONTENT).json("Successfully deleted resource");
        } catch (Exception e){                                                                                          // Since 'service.delete(ID id)' returns void this method can only throw an exception if the ID (parameter) isn't part of the DB.
            logger.error("Error deleting {} with ID: {} from IP: {}", dtoClass.getSimpleName(), id, e.getMessage(), e);
            ctx.status(HttpStatus.INTERNAL_SERVER_ERROR).json("Unable too delete an entry in the database, based ond the Context-Object provided");
        }


    }

    @Override
    public boolean validatePrimaryKey(Context ctx) {
        try {
            ID id = parseId(ctx.pathParam("id"));
            logger.info("Validating primary key {} from IP: {}", id, ctx.ip());
            DTO dto = service.read(id);                                                                                 // Only equal to NULL if there doesn't exist an entry in the database with the given ID
            if (dto != null) {
                logger.debug("Validating primary key {} from DTO: {}", id, ctx.ip());
                return true;
            } else {
                logger.warn("{} not found for primary key {}", dtoClass.getSimpleName(), id);
                ctx.status(HttpStatus.NOT_FOUND).json("Resource not found");
                return false;
            }
        } catch (Exception e){
            logger.error("Error validating primary key: {}", e.getMessage(), e);
            ctx.status(HttpStatus.BAD_REQUEST).json("Invalid ID format");
            return false;
        }
    }

    @Override
    public DTO validateEntity(Context ctx) {
        try {
            DTO dto = ctx.bodyAsClass(dtoClass);
            logger.debug("Validating entity {} from DTO: {}", dtoClass.getSimpleName(), dto);
            return dto;
        } catch (Exception e){
            logger.error("");
            ctx.status(HttpStatus.BAD_REQUEST).json("Error validating entity");
            return null;
        }
    }
}
