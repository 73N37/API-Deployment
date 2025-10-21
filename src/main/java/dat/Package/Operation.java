package dat.Package;

/* TODO:    Notice that all my classes are private except for my 'Methods' class.
            This ensures that the ONLY way to manipulate private classes & fields,
            is through my Methods class
 */

public class Operation extends dat.Package.Utilization
{   // TestOperation [super-class] begins
    /*      TODO:   HVIS DU VIL HAVE 12, SÅ SKAL DU LAVE TESTS AF ALLE DINE KLASSER!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            TODO:   HVIS DU VIL HAVE 12, SÅ SKAL DU LAVE TESTS AF ALLE DINE KLASSER!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            TODO:   HVIS DU VIL HAVE 12, SÅ SKAL DU LAVE TESTS AF ALLE DINE KLASSER!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            TODO:   HVIS DU VIL HAVE 12, SÅ SKAL DU LAVE TESTS AF ALLE DINE KLASSER!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            TODO:   HVIS DU VIL HAVE 12, SÅ SKAL DU LAVE TESTS AF ALLE DINE KLASSER!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            TODO:   HVIS DU VIL HAVE 12, SÅ SKAL DU LAVE TESTS AF ALLE DINE KLASSER!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            TODO:   HVIS DU VIL HAVE 12, SÅ SKAL DU LAVE TESTS AF ALLE DINE KLASSER!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            TODO:   HVIS DU VIL HAVE 12, SÅ SKAL DU LAVE TESTS AF ALLE DINE KLASSER!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            TODO:   HVIS DU VIL HAVE 12, SÅ SKAL DU LAVE TESTS AF ALLE DINE KLASSER!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            TODO:   HVIS DU VIL HAVE 12, SÅ SKAL DU LAVE TESTS AF ALLE DINE KLASSER!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            TODO:   HVIS DU VIL HAVE 12, SÅ SKAL DU LAVE TESTS AF ALLE DINE KLASSER!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            TODO:   HVIS DU VIL HAVE 12, SÅ SKAL DU LAVE TESTS AF ALLE DINE KLASSER!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            TODO:   HVIS DU VIL HAVE 12, SÅ SKAL DU LAVE TESTS AF ALLE DINE KLASSER!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            TODO:   HVIS DU VIL HAVE 12, SÅ SKAL DU LAVE TESTS AF ALLE DINE KLASSER!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            TODO:   HVIS DU VIL HAVE 12, SÅ SKAL DU LAVE TESTS AF ALLE DINE KLASSER!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            TODO:   HVIS DU VIL HAVE 12, SÅ SKAL DU LAVE TESTS AF ALLE DINE KLASSER!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            TODO:   HVIS DU VIL HAVE 12, SÅ SKAL DU LAVE TESTS AF ALLE DINE KLASSER!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            TODO:   HVIS DU VIL HAVE 12, SÅ SKAL DU LAVE TESTS AF ALLE DINE KLASSER!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            TODO:   HVIS DU VIL HAVE 12, SÅ SKAL DU LAVE TESTS AF ALLE DINE KLASSER!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            TODO:   HVIS DU VIL HAVE 12, SÅ SKAL DU LAVE TESTS AF ALLE DINE KLASSER!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            TODO:   HVIS DU VIL HAVE 12, SÅ SKAL DU LAVE TESTS AF ALLE DINE KLASSER!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            TODO:   HVIS DU VIL HAVE 12, SÅ SKAL DU LAVE TESTS AF ALLE DINE KLASSER!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            TODO:   HVIS DU VIL HAVE 12, SÅ SKAL DU LAVE TESTS AF ALLE DINE KLASSER!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            TODO:   HVIS DU VIL HAVE 12, SÅ SKAL DU LAVE TESTS AF ALLE DINE KLASSER!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 */


        private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(Operation.class);
        protected static jakarta.persistence.EntityManagerFactory emf = dat.Config.HibernateConfig.createEMF(true);

        public static class Factory
        {   // Factory [middle-class] begins

                protected static java.lang.Class<? extends Information.Entity>  entityClass;
                protected static java.lang.Class<? extends Information.DTO>     dtoClass;
                protected static java.lang.Class<? extends java.io.Serializable>                    idClass;
                protected static Operation.DAO                                  dao;
                protected static Operation.Service                              service;
                protected static Operation.Controller                           controller;
                protected static Operation.Route                                route;

            protected Factory() {}   // Factory [constructor] begins & ends


            public Factory forEntity(
                    java.lang.Class<? extends Information.Entity>   entityClass,
                    java.lang.Class<? extends java.io.Serializable>                     idClass)
            {
                Factory result      = new Factory();    // create a new instance of Factory
                result.entityClass  = entityClass;      // assigns entityClass to the Factory instance
                result.idClass      = idClass;          // assigns idClass to the Factory instance
                return result;                          // returns the Factory which now has an idClass & entityClass, as global Fields
            }

            public Factory forDTO(
                     java.lang.Class<? extends Information.DTO>   dtoClass,
                    java.lang.Class<? extends java.io.Serializable>                     idClass)
            {
                Factory result      = new Factory ();       // create a new instance of Factory
                result.dtoClass     = dtoClass;             // assigns dtoClass to the Factory instance
                result.idClass      = idClass;              // assigns idClass to the factory instance
                return result;                              // returns the Factory which now has idClass & dtoClass, as global Fields
            }   // Factory [constructor] ends

            public Factory
                    (
                    java.lang.Class<? extends Information.Entity>   entityClass,
                    java.lang.Class<? extends Information.DTO>      dtoClass,
                    java.lang.Class<? extends java.io.Serializable> idClass
                    )
            {
                this.entityClass    = entityClass;
                this.dtoClass       = dtoClass;
                this.idClass        = idClass;
            }

            public static jakarta.persistence.EntityManagerFactory
            getEMF()
            {
                return emf; // return EntityManagerFactory [object] that gets instantiated on initialization of Factory [class]
            }

            public Operation.DAO
            getDAO()
            {
                return dao; // return Test.Operation.DAO [class]
            }

            public  Operation.Service
            getService()
            {
                return service;
            }

            public  Operation.Controller
            getController()
            {
                return controller;
            }

            public  Operation.Route
            getRoute()
            {
                return route;
            }
        }


    static class DAO<   Entity  extends Information.Entity,
                        Id      extends java.io.Serializable>
        extends Operation.Factory
    {

        public DAO( java.lang.Class<Entity> entityClass,
                    java.lang.Class<Id>     idClass)
        {
            super();
            super.dao = this;
            forEntity(entityClass, idClass);
        }
        private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(DAO.class);
         interface Interface<   Entity  extends Information.Entity,
                                Id      extends java.io.Serializable>
         {
             Entity get(Id id);
             java.util.Set<Entity> getAll();
             Entity put(Entity entity);
             Entity patch(Entity entity, Id id);
             void delete(Id id);
             boolean validatePrimaryKey(Id id);
        }

        public abstract static class
        Methods <   Entity  extends Information.Entity,
                    Id      extends java.io.Serializable>
        {
            Entity get(Id id)
            {
                log.debug("Reading/finding entity with id {}", id);
                try (jakarta.persistence.EntityManager em = emf.createEntityManager())
                {
                    java.lang.String jpql = "SELECT e FROM " + entityClass.getSimpleName() + " e WHERE e.id = :id";
                    jakarta.persistence.TypedQuery<Entity> query =  em.createQuery(jpql, (java.lang.Class<Entity>) entityClass);
                    query.setParameter("id", id);
                    log.debug("Found entity with id {}", id);
                    return query.getSingleResult();
                } catch (Exception e)
                {
                    log.error("(get(id)) Was unable to retrieve an entity with ID={}", id, e);
                    throw new ApiException(ErrorTypes.NOT_FOUND, "(get(id)) Was not able to find and entity with id="+id);
                }
            }

            java.util.Set<Entity> getAll()
            {
                log.debug("Attempting to read/find entities");
                try (jakarta.persistence.EntityManager em = emf.createEntityManager())
                {
                    java.lang.String jpql = "SELECT e FROM " + entityClass.getSimpleName() + " e";
                    jakarta.persistence.TypedQuery<Entity> query =  em.createQuery(jpql, (java.lang.Class<Entity>) entityClass);
                    log.debug("Found all entities and created added them to a List");
                    return new java.util.HashSet<>(query.getResultList());
                } catch (Exception e)
                {
                    log.error("(get(id)) An error happen while trying to retrieve {}", entityClass, e);
                    throw new ApiException(ErrorTypes.NOT_FOUND, "(getAll) An error happen while trying to retrieve entities");
                }

            }

            Entity put(Entity entity)
            {
                log.debug("Attempting to create a database entry with this entity={}", entity);
                try(jakarta.persistence.EntityManager em = emf.createEntityManager()){
                    java.lang.String jpql = "INSERT e " + entityClass.getSimpleName() + " e";
                    jakarta.persistence.TypedQuery<Entity> query = em.createQuery(jpql, (java.lang.Class<Entity>) entityClass);
                    log.debug("Successfully added entity={} to database", entity);
                    return entity;
                } catch(Exception e){
                    log.error("(put(entity)) An error happen while trying to create a database entry of this={}",entity, e );
                    throw new ApiException(ErrorTypes.NOT_FOUND, "(put(entity)) An error happen");
                }
            }

            Entity patch(Entity entity, Id id)
            {
                try(jakarta.persistence.EntityManager em = emf.createEntityManager()){
                    log.debug("(patch(entity, id)) Attempting to update an entity by ID={}", entity.getId());
                    java.lang.String jpql = "UPDATE e " + entityClass.getSimpleName() + " e WHERE e.id = :id";
                    jakarta.persistence.TypedQuery<Entity> query = em.createQuery(jpql, (java.lang.Class<Entity>) entityClass);
                    query.setParameter("id", id);
                    log.debug("(patch(entity,id)) Found and updated entity by id={}", entity.getId());
                    return entity;
                } catch(Exception e){
                    log.error("(patch(entity, id)) An error happen while try to update en entity by this Id={}", entity.getId(),e);
                    throw new ApiException(ErrorTypes.NOT_FOUND, "(patch(entity,id)) An error happen while trying to update en entity with id={}"+ entity.getId());
                }
            }
        }
    }

    static class Service<   Entity  extends Information.Entity,
                            DTO     extends Information.DTO,
                            Id      extends java.io.Serializable>
    {
        private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(Service.class);
        interface Interface<Entity  extends Information.Entity,
                            DTO     extends Information.DTO,
                            Id      extends java.io.Serializable>
        {
            DTO create(DTO dto);
            DTO read(Id id);
            DTO update(Id id, DTO dto);
            void delete(Id id);
            void delete(Entity entity);
            java.util.Set<DTO> readAllDTOs();
            java.util.Set<Entity> readAllEntities();
        }

        public Information.DTO entityToDTO(Information.Entity entity)
        {
            if(entity != null)
            {
                return new Information.   // return something that lives in 'dat.TestPackage.TestData'.
                                            Data().    // find a method within 'dat.TestPackage.TestData.Methods'.
                                                    entityToDTO(entity); // Use 'entityToDTO' method which lives in 'dat.TestPackage.TestData.Methods' to @return a new instance of 'dat.TestPackage.TestData.DTO' based on @param.
            }
                else return null;   // return null if @param is null OR any of the steps above fail
        }

        public Information.Entity dtoToEntity(Information.DTO dto)
        {
            return (dto != null) ? new Information.Data().dtoToEntity(dto) : null;
        }
    }

    static class Controller
    {   // Controller [middle-class] begins
        private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(Controller.class);
        interface Interface
        {   // interface [sub-class]
            void read(io.javalin.http.Context ctx);
            void readALL(io.javalin.http.Context ctx);
            void create (io.javalin.http.Context ctx);
            void update(io.javalin.http.Context ctx);
            void delete(io.javalin.http.Context ctx);
            boolean validatePrimaryKey(java.lang.Integer id);
            Information.Entity validateEntity(io.javalin.http.Context ctx);
        }   // Interface [sub-class] ends
    }   // Controller [middle-class] ends

    static class Route
    {   // Route [middle-lass] begins
        private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(Route.class);

        interface Interface
        {   // Interface [sub-class] begins
            void AddRoutes(io.javalin.Javalin app);
        }   // Interface [sub-class] ends
    }   // Route [middle-class] ends

    static class ApiException extends RuntimeException
    {   // ApiException [class] begins
        private final int code;
        private final ErrorTypes errorType;
        private static String errorMsg;

        public ApiException(int code, String msg)
        {   // ApiException(int, string) [constructor] begins
            super(msg); // relay msg to 'RuntimeException'
            this.code = code;
            this.errorType = ErrorTypes.getType(code);
            this.errorMsg = errorType.getErrorMessage() + "\n";
        }   // ApiException(int, string) [constructor]

        public ApiException(ErrorTypes errorType, String msg)
        {   // ApiException(TestErrorTypes, String) [constructor] begins
            super(msg); // relay msg to 'RuntimeException'
            this.errorType = errorType;
            this.code = errorType.getErrorCode();
            this.errorMsg = errorType.getErrorMessage() + "\n";
        }   // ApiException(TestErrorTypes, String) [constructor] ends

    /* |----------------------|
       |     CLIENT ERRORS    |
       |----------------------|
    */

        //TODO: 400 bad request
        public static Operation.ApiException badRequest(String msg)
        {   // badRequest(String msg) [method] begins
            return new Operation.ApiException(ErrorTypes.BAD_REQUEST, msg + errorMsg);
        }   // badRequest(String msg) [method] ends

        //TODO: 401 Unauthorized
        public static Operation.ApiException unauthorized(String msg)
        {   // unauthorized(String) [method] begins
            return new Operation.ApiException(ErrorTypes.UNAUTHORIZED, msg + errorMsg);
        }   // unauthorized(String) [method] ends

        //TODO: 403 Forbidden Access
        public static Operation.ApiException forbidden(String msg)
        {   // forbidden(String) [method] begins
            return new Operation.ApiException(ErrorTypes.FORBIDDEN, msg + errorMsg);
        }   // forbidden(String) [method] ends

        //TODO: 404 not found
        public static Operation.ApiException notFound(String msg)
        {   // notFound(String) [method] begins
            return new Operation.ApiException(ErrorTypes.NOT_FOUND, msg + errorMsg);
        }   // notFound(String) [method] ends

        //TODO: 405 conflict
        public static Operation.ApiException conflict(String msg)
        {   // conflict(String) [method] begins
            return new Operation.ApiException(ErrorTypes.METHOD_NOT_ALLOWED, msg + errorMsg);
        }   // conflict(String) [method] ends

        //TODO: 406 Not Acceptable
        public static Operation.ApiException notAcceptable (String msg)
        {   // notAcceptable (String) [method] begins
            return new Operation.ApiException(ErrorTypes.NOT_ACCEPTABLE, msg + errorMsg);
        }   // notAcceptable (String) [method] ends

        //TODO: 409 already exists
        public static Operation.ApiException alreadyExists(String msg)
        {   // alreadyExists(String) [method] begins
            return new Operation.ApiException(ErrorTypes.ALREADY_EXISTS, msg + errorMsg);

        }   // alreadyExists(String) [method] ends

        //TODO: 413 Payload too large
        public static Operation.ApiException payloadTooLarge(String msg)
        {   // payloadTooLarge(String) [method] begins
            return new Operation.ApiException(ErrorTypes.PAYLOAD_TOO_LARGE, msg + errorMsg);
        }   // payloadTooLarge(String) [method] ends

        //TODO: 429 Too many requests
        public static Operation.ApiException tooManyRequests(String msg)
        {   // tooManyRequests(String) [method] begins
            return new Operation.ApiException(ErrorTypes.TOO_MANY_REQUESTS, msg + errorMsg);
        }   // tooManyRequests(String) [method] ends



    /* |----------------------|
       |     SERVER ERRORS    |
       |----------------------|
    */
        //TODO: 500 server error
        public static Operation.ApiException serverError (String msg)
        {   // serverError (String) [method] begins
            return new Operation.ApiException(ErrorTypes.SERVER_ERROR, msg + errorMsg);
        }   // serverError (String) [method] ends

        //TODO: 501 Not implemented
        public static Operation.ApiException notImplemented(String msg)
        {   // notImplemented(String) [method] begins
            return new Operation.ApiException(ErrorTypes.NOT_IMPLEMENTED, msg + errorMsg);
        }   // notImplemented(String) [method] ends

        //TODO: 502 Bad Gateway
        public static Operation.ApiException badGateway(String msg)
        {   // badGateway(String) [method] begins
            return new Operation.ApiException(ErrorTypes.BAD_GATEWAY, msg + errorMsg);
        }   // badGateway(String) [method] ends

        //TODO: 503 Service Unavailable
        public static Operation.ApiException serviceUnavailable(String msg)
        {   // serviceUnavailable(String) [method] begins
            return new Operation.ApiException(ErrorTypes.SERVICE_UNAVAILABLE, msg + errorMsg);
        }   // serviceUnavailable(String) [method] ends

        //TODO: 504 Gateway Timeout
        public static Operation.ApiException gatewayTimeout(String msg)
        {   // gatewayTimeout(String) [method] begins
            return new Operation.ApiException(ErrorTypes.GATEWAY_TIMEOUT, msg + errorMsg);
        }   // gatewayTimeout(String) [method] ends

        //TODO: 505 HTTP Version not supported
        public static Operation.ApiException versionNotSupported(String msg)
        {   // versionNotSupported(String) [method] begins
            return new Operation.ApiException(ErrorTypes.HTTP_VERSION_NOT_SUPPORTED, msg + errorMsg);
        }   // versionNotSupported(String) [method] ends

        //TODO: 506 Variant also negotiates
        public static Operation.ApiException variantNegotiates(String msg)
        {   // variantNegotiates(String) [method] begins
            return new Operation.ApiException(ErrorTypes.VARIANT_ALSO_NEGOTIATES, msg + errorMsg);
        }   // variantNegotiates(String) [method] ends

        //TODO: 507 Insufficient storage
        public static Operation.ApiException insufficientStorage(String msg)
        {   // insufficientStorage(String= [method] begins
            return new Operation.ApiException(ErrorTypes.INSUFFICIENT_STORAGE, msg + errorMsg);
        }   // insufficientStorage(String= [method] ends

        //TODO: 508 Loop detected
        public static Operation.ApiException loopDetected(String msg)
        {   // loopDetected(String) [method] begins
            return new Operation.ApiException(ErrorTypes.LOOP_DETECTED, msg + errorMsg);
        }   // loopDetected(String) [method] ends

        //TODO: 510 Not extended
        public static Operation.ApiException notExtended(String msg)
        {   // notExtended(String) [method] begins
            return new Operation.ApiException(ErrorTypes.NOT_EXTENDED, msg + errorMsg);
        }   // notExtended(String) [method] ends

        //TODO: 511 Network Authentication Required
        public static Operation.ApiException authenticationRequired(String msg)
        {   // authenticationRequired(String) [method] begins
            return new Operation.ApiException(ErrorTypes.NETWORK_AUTHENTICATION_REQUIRED, msg + errorMsg);
        }   // authenticationRequired(String) [method] ends

        public int getStatusCode()
        {   // getStatusCode() [method] begins
            return this.code;
        }   // getStatusCode() [method] ends
    }   // ApiException [class] ends

    enum ErrorTypes
    {   // TestErrorTypes [enum] begins
        BAD_REQUEST(400, "Bad request"),
        UNAUTHORIZED(401, "Unauthorized Access"),
        FORBIDDEN(403, "Forbidden Access"),
        NOT_FOUND(404, "Resource not found"),
        METHOD_NOT_ALLOWED(405, "Method Not Allowed"),
        NOT_ACCEPTABLE(406, "Not Acceptable"),
        ALREADY_EXISTS(409, "Resource already exists"),
        PAYLOAD_TOO_LARGE(413, "Payload Too Large"),
        TOO_MANY_REQUESTS(429, "Too Many Requests"),
        SERVER_ERROR(500, "Internal server error"),
        NOT_IMPLEMENTED(501, "Not Implemented"),
        BAD_GATEWAY(502, "Bad Gateway"),
        SERVICE_UNAVAILABLE(503, "Service Unavailable"),
        GATEWAY_TIMEOUT(504, "Gateway Timeout"),
        HTTP_VERSION_NOT_SUPPORTED(505, "HTTP Version Not Supported"),
        VARIANT_ALSO_NEGOTIATES(506, "Variant Also Negotiates"),
        INSUFFICIENT_STORAGE(507, "Insufficient Storage"),
        LOOP_DETECTED(508, "Loop Detected"),
        NOT_EXTENDED(509, "Not Extended"),
        NETWORK_AUTHENTICATION_REQUIRED(510, "Network Authentication Required");

        private final int errorCode;
        private final java.lang.String errorMessage;

        ErrorTypes(int errorCode, java.lang.String errorMsg)
        {   // TestErrorTypes(int, String) [constructor] begins
            this.errorCode = errorCode;
            this.errorMessage = errorMsg;
        }   // TestErrorTypes(int, String) [constructor] ends

        public int getErrorCode()
        {   // getErrorCode() [method] begins
            return errorCode;
        }   // getErrorCode() [method] ends


        public static ErrorTypes getType(int errorCode)
        {   // getType(int) [method] begins
            for (ErrorTypes type : ErrorTypes.values())
            {   // TestErrorType [for-each] begins
                if (type.getErrorCode() == errorCode)
                {   // getErrorCode [if] begins
                    return type;
                }   // getErrorCode [if] ends
            }   // TestErrorType [for-each] ends
            return null; // or throw an exception if no match found
        }   // getType(int) [method] ends

        public java.lang.String getErrorMessage()
        {   // getErrorMessage() [method] begins
            return errorMessage;
        }   // getErrorMessage() [method] ends
    }   // TestErrorType [enum] ends
}   // TestOperation [super-class] ends


