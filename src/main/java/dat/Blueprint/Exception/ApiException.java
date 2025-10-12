package dat.Exception;

import dat.Enum.ErrorTypes;

public class ApiException extends RuntimeException {
    private final int code;
    private final ErrorTypes errorType;
    private static String errorMsg;

    public ApiException(int code, String msg) {
        super(msg);
        this.code = code;
        this.errorType = ErrorTypes.getType(code);
        this.errorMsg = errorType.getErrorMessage() + "\n";
    }

    public ApiException(ErrorTypes errorType, String msg) {
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
    public static ApiException badRequest (String msg) {
        return new ApiException(ErrorTypes.BAD_REQUEST, msg + errorMsg);
    }

    //TODO: 401 Unauthorized
    public static ApiException unauthorized (String msg) {
        return new ApiException(ErrorTypes.UNAUTHORIZED, msg + errorMsg);
    }

    //TODO: 403 Forbidden Access
    public static ApiException forbidden (String msg) {
        return new ApiException(ErrorTypes.FORBIDDEN, msg + errorMsg);
    }

    //TODO: 404 not found
    public static ApiException notFound(String msg) {
        return new ApiException(ErrorTypes.NOT_FOUND, msg + errorMsg);
    }

    //TODO: 405 conflict
    public static ApiException conflict (String msg) {
        return new ApiException(ErrorTypes.METHOD_NOT_ALLOWED, msg + errorMsg);
    }

    //TODO: 406 Not Acceptable
    public static ApiException  notAcceptable (String msg) {
        return new ApiException(ErrorTypes.NOT_ACCEPTABLE, msg + errorMsg);
    }

    //TODO: 409 already exists
    public static ApiException alreadyExists(String msg) {
        return new ApiException(ErrorTypes.ALREADY_EXISTS, msg + errorMsg);

    }

    //TODO: 413 Payload too large
    public static ApiException payloadTooLarge(String msg){
        return new ApiException(ErrorTypes.PAYLOAD_TOO_LARGE, msg + errorMsg);
    }

    //TODO: 429 Too many requests
    public static ApiException tooManyRequests(String msg){
        return new ApiException(ErrorTypes.TOO_MANY_REQUESTS, msg + errorMsg);
    }

    /* |----------------------|
       |     SERVER ERRORS    |
       |----------------------|
    */

    //TODO: 500 server error
    public static ApiException serverError (String msg) {
        return new ApiException(ErrorTypes.SERVER_ERROR, msg + errorMsg);
    }

    //TODO: 501 Not implemented
    public static ApiException notImplemented(String msg){
        return new ApiException(ErrorTypes.NOT_IMPLEMENTED, msg + errorMsg);
    }

    //TODO: 502 Bad Gateway
    public static ApiException badGateway(String msg){
        return new ApiException(ErrorTypes.BAD_GATEWAY, msg + errorMsg);
    }

    //TODO: 503 Service Unavailable
    public static ApiException serviceUnavailable(String msg){
        return new ApiException(ErrorTypes.SERVICE_UNAVAILABLE, msg + errorMsg);
    }

    //TODO: 504 Gateway Timeout
    public static ApiException gatewayTimeout(String msg){
        return new ApiException(ErrorTypes.GATEWAY_TIMEOUT, msg + errorMsg);
    }

    //TODO: 505 HTTP Version not supported
    public static ApiException versionNotSupported(String msg){
        return new ApiException(ErrorTypes.HTTP_VERSION_NOT_SUPPORTED, msg + errorMsg);
    }

    //TODO: 506 Variant also negotiates
    public static ApiException variantNegotiates(String msg){
        return new ApiException(ErrorTypes.VARIANT_ALSO_NEGOTIATES, msg + errorMsg);
    }

    //TODO: 507 Insufficient storage
    public static ApiException insufficientStorage(String msg){
        return new ApiException(ErrorTypes.INSUFFICIENT_STORAGE, msg + errorMsg);
    }

    //TODO: 508 Loop detected
    public static ApiException loopDetected(String msg){
        return new ApiException(ErrorTypes.LOOP_DETECTED, msg + errorMsg);
    }

    //TODO: 510 Not extended
    public static ApiException notExtended(String msg){
        return new ApiException(ErrorTypes.NOT_EXTENDED, msg + errorMsg);
    }

    //TODO: 511 Network Authentication Required
    public static ApiException authenticationRequired(String msg){
        return new ApiException(ErrorTypes.NETWORK_AUTHENTICATION_REQUIRED, msg + errorMsg);
    }

    public int getStatusCode() {
        return code;
    }
}




