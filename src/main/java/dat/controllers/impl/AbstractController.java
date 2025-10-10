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
    protected abstract Class<DTO> getDTOClass();

    protected AbstractController(InterfaceService< Entity, DTO, ID>  service,
                                 Class<Entity>                      entityClass,
                                 Class<DTO>                         dtoClass,
                                 Class<ID>                          idClass) {
        super(entityClass, dtoClass, idClass);
        this.service = service;

    }

    @Override
    public void read(Context ctx) {
        ID id =  parseId(ctx.pathParam("id"));
        logger.info("GET request for {} with Object: {} from IP: {}", getDTOClass().getSimpleName(), id, ctx.ip());
        try {
            DTO dto = service.read(id);
            if (dto != null) {
                logger.debug("Received DTO= {} from service",dto.getClass());
                ctx.json(dto);
            } else {
                logger.warn("{} not found with Object: {}", getDTOClass().getSimpleName(), id);
                ctx.status(HttpStatus.NOT_FOUND).json("Resource not found");
            }
        } catch (Exception e){
            logger.error("Error retrieving {} with Object: {}: {}", getDTOClass().getSimpleName(), id, e.getMessage(), e);
            ctx.status(HttpStatus.BAD_REQUEST).json("Error retrieving resource: " + e.getMessage());
        }
    }

    @Override
    public void readAll(Context ctx) {
        logger.info("GET request for {} from IP: {}", getDTOClass().getSimpleName(), ctx.ip());
        try {
            Set<DTO> data = service.readAllDTO();
            logger.debug("Retrieved {} data from service", data.size());
            ctx.json(data);
        } catch (Exception e) {
            logger.error("Error retrieving {} from IP: {}", getDTOClass().getSimpleName(), ctx.ip(), e);
            ctx.status(HttpStatus.BAD_REQUEST).json("Error retrieving resource: " + e.getMessage());
        }
    }

    @Override
    public void create(Context ctx) {
        logger.info("POST request to create {} from IP: {}",  getDTOClass().getSimpleName(), ctx.ip());
        try {
            DTO dto = ctx.bodyAsClass(getDTOClass());
            logger.debug("Parsed request body for {} creation", getDTOClass().getSimpleName());
            DTO createdDTO = service.create(dto);
            logger.info("Successfully created {} with service", getDTOClass().getSimpleName());
            ctx.status(HttpStatus.CREATED).json(createdDTO);
        } catch (Exception e) {
            logger.error("Failed to create {}: in service {}", getDTOClass().getSimpleName(), e.getMessage(), e);
            ctx.status(HttpStatus.BAD_REQUEST).json("Error creating resource: " + e.getMessage());
        }
    }

    @Override
    public void update(Context ctx) {
        ID id = parseId(ctx.pathParam("id"));
        logger.info("PUT request to update {} with Object: {} from IP: {}", getDTOClass().getSimpleName(), id, ctx.ip());
        try{
            DTO dto = ctx.bodyAsClass(getDTOClass());
            logger.debug("Parsed request body for {} update with Object: {}", getDTOClass().getSimpleName(), id);
            DTO dataEntry = service.update(id, dto);
            if (dataEntry != null) {
                logger.info("Successfully updated {} with Object: {}", getDTOClass().getSimpleName(), id);
                ctx.json(dataEntry);
            } else {
                logger.warn("{} not found for update with Object: {}", getDTOClass().getSimpleName(), id);
                ctx.status(HttpStatus.NOT_FOUND).json("Resource not found");
            }
        } catch (Exception e){
            logger.error("Error updating {} with Object: {}: {}", getDTOClass().getSimpleName(), id, e.getMessage(), e);
            ctx.status(HttpStatus.BAD_REQUEST).json("Error updating resource: " + e.getMessage());
        }
    }

    @Override
    public void delete(Context ctx) {
        ID id = parseId(ctx.pathParam("id"));
        logger.info("DELETE request for {} with Object: {} from IP: {}", getDTOClass().getSimpleName(), id, ctx.ip());
        try{
            DTO dto = ctx.bodyAsClass(getDTOClass());

            service.delete(service.dtoToEntity(dto));
        }


    }

    @Override
    public boolean validatePrimaryKey(Context ctx) {
        ID id = parseId(ctx.pathParam("id"));
        logger.info("GET request for {} from IP: {}", getDTOClass().getSimpleName(), id);

    }

    @Override
    public DTO validateEntity(Context ctx) {

    }
}
