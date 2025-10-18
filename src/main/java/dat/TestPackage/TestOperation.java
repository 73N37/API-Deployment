package dat.TestPackage;

/* TODO:    Notice that all my classes are private except for my 'Methods' class.
            This ensures that the ONLY way to manipulate private classes & fields,
            is through my Methods class
 */

import java.util.Set;

public final class TestOperation<   Entity extends dat.TestPackage.TestData.Entity,
                                    Record extends dat.TestPackage.TestData.Record,
                                    Id extends java.io.Serializable>
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


        private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(TestOperation.class);
        public jakarta.persistence.EntityManagerFactory emf;

        public class Factory<   Entity  extends dat.TestPackage.TestData.Entity,
                                Record  extends dat.TestPackage.TestData.Record,
                                Id      extends java.io.Serializable>
        {   // Factory [class] begins
            public static dat.TestPackage.TestOperation.Factory ResourceFactory()
            {   // ResourceFactory [method] begins

            }   // ResourceFactory [method] ends

            interface Interface
            {   // Interface begins
                dat.TestPackage.TestOperation.DAO.Interface createDAO(jakarta.persistence.EntityManagerFactory emf);

                dat.TestPackage.TestOperation.Service.Interface createService(DAO.Interface dao);

                dat.TestPackage.TestOperation.Controller.Interface createController(Service.Interface service);

                dat.TestPackage.TestOperation.Routes.Interface createRoutes(Controller.Interface routes);

                dat.TestPackage.TestOperation.Factory createFactory(io.javalin.Javalin app);
            }   // Interface [class] ends
        }   // Factory [class] ends


    static class DAO<   Entity  extends dat.TestPackage.TestData.Entity,
                        Id      extends java.io.Serializable>
    {   // DAO [class] begins
        private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(DAO.class);
         interface Interface<   Entity  extends dat.TestPackage.TestData.Entity,
                                Id      extends java.io.Serializable>
         {  // Interface [class] begins
             Entity read(Id id);
             java.util.List<Entity> readAll();
             Entity create(Entity entity);
             Entity update(Entity entity, Id id);
             void delete(Id id);
             boolean validatePrimaryKey(Id id);
        }   // Interface [class] ends

        public abstract static class
        Methods <   Entity  extends dat.TestPackage.TestData.Entity,
                    Id      extends java.io.Serializable>
                implements dat.TestPackage.TestOperation.DAO.Interface
        {   // Methods class begins

        }   // Method class begins
    }

    static class Service<   Entity  extends dat.TestPackage.TestData.Entity,
                            Record  extends dat.TestPackage.TestData.Record,
                            Id      extends java.io.Serializable>
    {
        private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(Service.class);
        interface Interface<Entity  extends dat.TestPackage.TestData.Entity,
                            Record  extends dat.TestPackage.TestData.Record,
                            Id      extends java.io.Serializable>
        {
            Record create(Record dto);
            Record read(Id id);
            Record update(Id id, Record dto);
            void delete(Id id);
            void delete(Entity entity);
            java.util.Set<Record> readAllDTOs();
            java.util.Set<Entity> readAllEntities();
            Entity dtoToEntity(Record dto);
            Record entityToDTO(Entity entity);
        }

            public dat.TestPackage.TestData.Record entityToDTO(dat.TestPackage.TestData.Entity entity)
            {
                if(entity != null)
                {
                    return dat.     // return something that lives in 'dat' (super-package).
                                TestPackage.    // return something that lives in 'dat.TestPackage' (sub-package).
                                            TestData.   // return something that lives in 'dat.TestPackage.TestData'.
                                                    Methods.    // find a method within 'dat.TestPackage.TestData.Methods'.
                                                            entityToRecord(entity); // Use 'entityToRecord' method which lives in 'dat.TestPackage.TestData.Methods' to @return a new instance of 'dat.TestPackage.TestData.Record' based on @param.
                }
                else return null;   // return null if @param is null OR any of the steps above fail
            }

            public dat.TestPackage.TestData.Entity dtoToEntity(dat.TestPackage.TestData.Record record)
            {
                if(record != null)
                {
                    return dat.     // return something that lives in 'dat' (super-package).
                                TestPackage.    // return something that lives in 'dat.TestPackage' (sub-package).
                                            TestData.   // return something that lives in 'dat.TestPackage.TestData'.
                                                    Methods.   // find a method within 'dat.TestPackage.TestData.Methods'.
                                                            recordToEntity(record); // Use 'recordToEntity' method which lives in 'dat.TestPackage.TestData.Methods' to @return a new instance of 'dat.TestPackage.TestData.Entity' based on @param.
                }
                else return null; // return null if @param is null OR any of the steps above fail
            }
        }

    static class Controller
    {
        private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(Controller.class);
        interface Interface
        {
            void read(io.javalin.http.Context ctx);
            void readALL(io.javalin.http.Context ctx);
            void create (io.javalin.http.Context ctx);
            void update(io.javalin.http.Context ctx);
            void delete(io.javalin.http.Context ctx);
            boolean validatePrimaryKey(java.lang.Integer id);
            dat.TestPackage.TestData.Entity validateEntity(io.javalin.http.Context ctx);
        }
    }

    static class Routes
    {
        private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(Routes.class);

        interface Interface
        {
            void AddRoutes(io.javalin.Javalin app);
        }
    }



    static class ApiException extends RuntimeException
    {
        private final int code;
        private final TestOperation.TestErrorTypes errorType;
        private static String errorMsg;

        public ApiException(int code, String msg)
        {
            super(msg);
            this.code = code;
            this.errorType = TestOperation.TestErrorTypes.getType(code);
            this.errorMsg = errorType.getErrorMessage() + "\n";
        }

        public ApiException(TestOperation.TestErrorTypes errorType, String msg)
        {
            super(msg);
            this.errorType = errorType;
            this.code = errorType.getErrorCode();
            this.errorMsg = errorType.getErrorMessage() + "\n";
        }

    /* |----------------------|
       |     CLIENT ERRORS    |
       |----------------------|
    */

        //TODO: 400 bad request
        public static TestOperation.ApiException badRequest (String msg) {
            return new TestOperation.ApiException(TestOperation.TestErrorTypes.BAD_REQUEST, msg + errorMsg);
        }

        //TODO: 401 Unauthorized
        public static TestOperation.ApiException unauthorized (String msg) {
            return new TestOperation.ApiException(TestOperation.TestErrorTypes.UNAUTHORIZED, msg + errorMsg);
        }

        //TODO: 403 Forbidden Access
        public static TestOperation.ApiException forbidden (String msg) {
            return new TestOperation.ApiException(TestOperation.TestErrorTypes.FORBIDDEN, msg + errorMsg);
        }

        //TODO: 404 not found
        public static TestOperation.ApiException notFound(String msg) {
            return new TestOperation.ApiException(TestOperation.TestErrorTypes.NOT_FOUND, msg + errorMsg);
        }

        //TODO: 405 conflict
        public static TestOperation.ApiException conflict (String msg) {
            return new TestOperation.ApiException(TestOperation.TestErrorTypes.METHOD_NOT_ALLOWED, msg + errorMsg);
        }

        //TODO: 406 Not Acceptable
        public static TestOperation.ApiException notAcceptable (String msg) {
            return new TestOperation.ApiException(TestOperation.TestErrorTypes.NOT_ACCEPTABLE, msg + errorMsg);
        }

        //TODO: 409 already exists
        public static TestOperation.ApiException alreadyExists(String msg) {
            return new TestOperation.ApiException(TestOperation.TestErrorTypes.ALREADY_EXISTS, msg + errorMsg);

        }

        //TODO: 413 Payload too large
        public static TestOperation.ApiException payloadTooLarge(String msg){
            return new TestOperation.ApiException(TestOperation.TestErrorTypes.PAYLOAD_TOO_LARGE, msg + errorMsg);
        }

        //TODO: 429 Too many requests
        public static TestOperation.ApiException tooManyRequests(String msg){
            return new TestOperation.ApiException(TestOperation.TestErrorTypes.TOO_MANY_REQUESTS, msg + errorMsg);
        }

    /* |----------------------|
       |     SERVER ERRORS    |
       |----------------------|
    */

        //TODO: 500 server error
        public static TestOperation.ApiException serverError (String msg) {
            return new TestOperation.ApiException(TestOperation.TestErrorTypes.SERVER_ERROR, msg + errorMsg);
        }

        //TODO: 501 Not implemented
        public static TestOperation.ApiException notImplemented(String msg){
            return new TestOperation.ApiException(TestOperation.TestErrorTypes.NOT_IMPLEMENTED, msg + errorMsg);
        }

        //TODO: 502 Bad Gateway
        public static TestOperation.ApiException badGateway(String msg){
            return new TestOperation.ApiException(TestOperation.TestErrorTypes.BAD_GATEWAY, msg + errorMsg);
        }

        //TODO: 503 Service Unavailable
        public static TestOperation.ApiException serviceUnavailable(String msg){
            return new TestOperation.ApiException(TestOperation.TestErrorTypes.SERVICE_UNAVAILABLE, msg + errorMsg);
        }

        //TODO: 504 Gateway Timeout
        public static TestOperation.ApiException gatewayTimeout(String msg){
            return new TestOperation.ApiException(TestOperation.TestErrorTypes.GATEWAY_TIMEOUT, msg + errorMsg);
        }

        //TODO: 505 HTTP Version not supported
        public static TestOperation.ApiException versionNotSupported(String msg){
            return new TestOperation.ApiException(TestOperation.TestErrorTypes.HTTP_VERSION_NOT_SUPPORTED, msg + errorMsg);
        }

        //TODO: 506 Variant also negotiates
        public static TestOperation.ApiException variantNegotiates(String msg){
            return new TestOperation.ApiException(TestOperation.TestErrorTypes.VARIANT_ALSO_NEGOTIATES, msg + errorMsg);
        }

        //TODO: 507 Insufficient storage
        public static TestOperation.ApiException insufficientStorage(String msg){
            return new TestOperation.ApiException(TestOperation.TestErrorTypes.INSUFFICIENT_STORAGE, msg + errorMsg);
        }

        //TODO: 508 Loop detected
        public static TestOperation.ApiException loopDetected(String msg)
        {   // loopDetected(String) [method] begins
            return new TestOperation.ApiException(TestOperation.TestErrorTypes.LOOP_DETECTED, msg + errorMsg);
        }   // loopDetected(String) [method] ends

        //TODO: 510 Not extended
        public static TestOperation.ApiException notExtended(String msg)
        {   // notExtended(String) [method] begins
            return new TestOperation.ApiException(TestOperation.TestErrorTypes.NOT_EXTENDED, msg + errorMsg);
        }   // notExtended(String) [method] ends

        //TODO: 511 Network Authentication Required
        public static TestOperation.ApiException authenticationRequired(String msg)
        {   // authenticationRequired(String) [method] begins
            return new dat.TestPackage.TestOperation.ApiException(TestOperation.TestErrorTypes.NETWORK_AUTHENTICATION_REQUIRED, msg + errorMsg);
        }   // authenticationRequired(String) [method] ends

        public int getStatusCode()
        {   // getStatusCode() [method] begins
            return this.code;
        }   // getStatusCode() [method] ends
    }

    enum TestErrorTypes
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

        TestErrorTypes(int errorCode, java.lang.String errorMsg)
        {   // TestErrorTypes(int, String) [constructor] begins
            this.errorCode = errorCode;
            this.errorMessage = errorMsg;
        }   // TestErrorTypes(int, String) [constructor] ends

        public int getErrorCode()
        {   // getErrorCode() [method] begins
            return errorCode;
        }   // getErrorCode() [method] ends


        public static dat.TestPackage.TestOperation.TestErrorTypes getType(int errorCode)
        {   // getType(int) [method] begins
            for (dat.TestPackage.TestOperation.TestErrorTypes type : dat.TestPackage.TestOperation.TestErrorTypes.values())
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


