package dat.TestPackage;

/* TODO:    Notice that all my classes are private except for my 'Methods' class.
            This ensures that the ONLY way to manipulate private classes & fields,
            is through my Methods class
 */


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class TestDAO {
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


        //private static final Logger log = LoggerFactory.getLogger(dat.TestPackage.TestDAO);
        public EntityManagerFactory emf;
        Object entityClass = dat.TestPackage.TestData.Methods.getEntity();



    public enum TestErrorTypes {
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

        TestErrorTypes(int errorCode, java.lang.String errorMsg) {
            this.errorCode = errorCode;
            this.errorMessage = errorMsg;
        }

        public int getErrorCode() {
            return errorCode;
        }


        public static dat.TestPackage.TestDAO.TestErrorTypes getType(int errorCode) {
            for (dat.TestPackage.TestDAO.TestErrorTypes type : dat.TestPackage.TestDAO.TestErrorTypes.values()) {
                if (type.getErrorCode() == errorCode) {
                    return type;
                }
            }
            return null; // or throw an exception if no match found
        }

        public String getErrorMessage() {
            return errorMessage;
        }
    }


    private static class ApiException extends RuntimeException {
        private final int code;
        private final dat.TestPackage.TestDAO.TestErrorTypes errorType;
        private static String errorMsg;

        public ApiException(int code, String msg) {
            super(msg);
            this.code = code;
            this.errorType = dat.TestPackage.TestDAO.TestErrorTypes.getType(code);
            this.errorMsg = errorType.getErrorMessage() + "\n";
        }

        public ApiException(dat.TestPackage.TestDAO.TestErrorTypes errorType, String msg) {
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
        public static dat.TestPackage.TestDAO.ApiException badRequest (String msg) {
            return new dat.TestPackage.TestDAO.ApiException(dat.TestPackage.TestDAO.TestErrorTypes.BAD_REQUEST, msg + errorMsg);
        }

        //TODO: 401 Unauthorized
        public static dat.TestPackage.TestDAO.ApiException unauthorized (String msg) {
            return new dat.TestPackage.TestDAO.ApiException(dat.TestPackage.TestDAO.TestErrorTypes.UNAUTHORIZED, msg + errorMsg);
        }

        //TODO: 403 Forbidden Access
        public static dat.TestPackage.TestDAO.ApiException forbidden (String msg) {
            return new dat.TestPackage.TestDAO.ApiException(dat.TestPackage.TestDAO.TestErrorTypes.FORBIDDEN, msg + errorMsg);
        }

        //TODO: 404 not found
        public static dat.TestPackage.TestDAO.ApiException notFound(String msg) {
            return new dat.TestPackage.TestDAO.ApiException(dat.TestPackage.TestDAO.TestErrorTypes.NOT_FOUND, msg + errorMsg);
        }

        //TODO: 405 conflict
        public static dat.TestPackage.TestDAO.ApiException conflict (String msg) {
            return new dat.TestPackage.TestDAO.ApiException(dat.TestPackage.TestDAO.TestErrorTypes.METHOD_NOT_ALLOWED, msg + errorMsg);
        }

        //TODO: 406 Not Acceptable
        public static dat.TestPackage.TestDAO.ApiException notAcceptable (String msg) {
            return new dat.TestPackage.TestDAO.ApiException(dat.TestPackage.TestDAO.TestErrorTypes.NOT_ACCEPTABLE, msg + errorMsg);
        }

        //TODO: 409 already exists
        public static dat.TestPackage.TestDAO.ApiException alreadyExists(String msg) {
            return new dat.TestPackage.TestDAO.ApiException(dat.TestPackage.TestDAO.TestErrorTypes.ALREADY_EXISTS, msg + errorMsg);

        }

        //TODO: 413 Payload too large
        public static dat.TestPackage.TestDAO.ApiException payloadTooLarge(String msg){
            return new dat.TestPackage.TestDAO.ApiException(dat.TestPackage.TestDAO.TestErrorTypes.PAYLOAD_TOO_LARGE, msg + errorMsg);
        }

        //TODO: 429 Too many requests
        public static dat.TestPackage.TestDAO.ApiException tooManyRequests(String msg){
            return new dat.TestPackage.TestDAO.ApiException(dat.TestPackage.TestDAO.TestErrorTypes.TOO_MANY_REQUESTS, msg + errorMsg);
        }

    /* |----------------------|
       |     SERVER ERRORS    |
       |----------------------|
    */

        //TODO: 500 server error
        public static dat.TestPackage.TestDAO.ApiException serverError (String msg) {
            return new dat.TestPackage.TestDAO.ApiException(dat.TestPackage.TestDAO.TestErrorTypes.SERVER_ERROR, msg + errorMsg);
        }

        //TODO: 501 Not implemented
        public static dat.TestPackage.TestDAO.ApiException notImplemented(String msg){
            return new dat.TestPackage.TestDAO.ApiException(dat.TestPackage.TestDAO.TestErrorTypes.NOT_IMPLEMENTED, msg + errorMsg);
        }

        //TODO: 502 Bad Gateway
        public static dat.TestPackage.TestDAO.ApiException badGateway(String msg){
            return new dat.TestPackage.TestDAO.ApiException(dat.TestPackage.TestDAO.TestErrorTypes.BAD_GATEWAY, msg + errorMsg);
        }

        //TODO: 503 Service Unavailable
        public static dat.TestPackage.TestDAO.ApiException serviceUnavailable(String msg){
            return new dat.TestPackage.TestDAO.ApiException(dat.TestPackage.TestDAO.TestErrorTypes.SERVICE_UNAVAILABLE, msg + errorMsg);
        }

        //TODO: 504 Gateway Timeout
        public static dat.TestPackage.TestDAO.ApiException gatewayTimeout(String msg){
            return new dat.TestPackage.TestDAO.ApiException(dat.TestPackage.TestDAO.TestErrorTypes.GATEWAY_TIMEOUT, msg + errorMsg);
        }

        //TODO: 505 HTTP Version not supported
        public static dat.TestPackage.TestDAO.ApiException versionNotSupported(String msg){
            return new dat.TestPackage.TestDAO.ApiException(dat.TestPackage.TestDAO.TestErrorTypes.HTTP_VERSION_NOT_SUPPORTED, msg + errorMsg);
        }

        //TODO: 506 Variant also negotiates
        public static dat.TestPackage.TestDAO.ApiException variantNegotiates(String msg){
            return new dat.TestPackage.TestDAO.ApiException(dat.TestPackage.TestDAO.TestErrorTypes.VARIANT_ALSO_NEGOTIATES, msg + errorMsg);
        }

        //TODO: 507 Insufficient storage
        public static dat.TestPackage.TestDAO.ApiException insufficientStorage(String msg){
            return new dat.TestPackage.TestDAO.ApiException(dat.TestPackage.TestDAO.TestErrorTypes.INSUFFICIENT_STORAGE, msg + errorMsg);
        }

        //TODO: 508 Loop detected
        public static dat.TestPackage.TestDAO.ApiException loopDetected(String msg){
            return new dat.TestPackage.TestDAO.ApiException(dat.TestPackage.TestDAO.TestErrorTypes.LOOP_DETECTED, msg + errorMsg);
        }

        //TODO: 510 Not extended
        public static dat.TestPackage.TestDAO.ApiException notExtended(String msg){
            return new dat.TestPackage.TestDAO.ApiException(dat.TestPackage.TestDAO.TestErrorTypes.NOT_EXTENDED, msg + errorMsg);
        }

        //TODO: 511 Network Authentication Required
        public static dat.TestPackage.TestDAO.ApiException authenticationRequired(String msg){
            return new dat.TestPackage.TestDAO.ApiException(dat.TestPackage.TestDAO.TestErrorTypes.NETWORK_AUTHENTICATION_REQUIRED, msg + errorMsg);
        }

        public int getStatusCode() {
            return code;
        }
    }
}


