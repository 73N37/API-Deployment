//package dat.controllers.impl;
//import dat.controllers.IController;
//import io.javalin.http.Context;
//import io.javalin.http.HttpStatus;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//public abstract class AbstractController<DTO,ID> implements IController<DTO,ID> {
//
//    private static final Logger logger = LoggerFactory.getLogger(AbstractController.class);
//    protected final InterfaceService<DTO> service;
//    protected abstract Class<DTO> getDTOClass();
//    protected abstract <ReturnType> ReturnType convertId(String idString, Class<ReturnType> target);
//
//    protected AbstractController(InterfaceService<DTO> service) {
//        this.service = service;
//    }
//
//
//    @Override
//    public void read(Context ctx) {
//
//    }
//
//    @Override
//    public void readAll(Context ctx) {
//
//    }
//
//    @Override
//    public void create(Context ctx) {
//        logger.info("POST request to create {} from IP: {}",
//                getDTOClass().getSimpleName(), ctx.ip());
//        try {
//            DTO dto = ctx.bodyAsClass(getDTOClass());
//            logger.debug("Parsed request body for {} creation", getDTOClass().getSimpleName());
//            DTO createdDTO = service.createDTO(dto);
//            logger.info("Successfully created {} with result", getDTOClass().getSimpleName());
//            ctx.status(HttpStatus.CREATED).json(createdDTO);
//        } catch (Exception e) {
//            logger.error("Failed to create {}: {}", getDTOClass().getSimpleName(), e.getMessage(), e);
//            ctx.status(HttpStatus.BAD_REQUEST).json("Error creating resource: " + e.getMessage());
//        }
//    }
//
//    @Override
//    public void update(Context ctx) {
//
//    }
//
//    @Override
//    public void delete(Context ctx) {
//
//    }
//
//    @Override
//    public boolean validatePrimaryKey(Object o) {
//        return false;
//    }
//
//    @Override
//    public Object validateEntity(Context ctx) {
//        return null;
//    }
//}
