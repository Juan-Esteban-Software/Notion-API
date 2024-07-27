package dev.juest.httprequest;

public enum HttpStatusCode {

    OK(200, "OK"),
    CREATED(201, "Created"),
    NO_CONTENT(204, "No Content"),
    BAD_REQUEST(400, "Bad Request: The request was invalid or cannot be otherwise served."),
    UNAUTHORIZED(401, "Unauthorized: Access token is missing or invalid."),
    FORBIDDEN(403, "Forbidden: The request is understood, but it has been refused or access is not allowed."),
    NOT_FOUND(404, "Not Found: The resource could not be found."),
    CONFLICT(409, "Conflict: Request could not be processed because of conflict."),
    TOO_MANY_REQUESTS(429, "Too Many Requests: Rate limit exceeded."),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error: An error occurred on the server.");

    private final int code;
    private final String message;


    //------------------------------------------------------------------------------------------------------------------

    HttpStatusCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    //------------------------------------------------------------------------------------------------------------------

    public int getCode() {
        return code;
    }

    //------------------------------------------------------------------------------------------------------------------

    public String getMessage() {
        return message;
    }

    //------------------------------------------------------------------------------------------------------------------

    public static String getMessageByCode(int code) {
        for (HttpStatusCode status : values()) {
            if (status.code == code) {
                return status.message;
            }
        }
        return "Unknown HTTP status code: " + code;
    }

    //------------------------------------------------------------------------------------------------------------------

}

