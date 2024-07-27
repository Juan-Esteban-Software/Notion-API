package dev.juest.httprequest;

public class HttpsResponse {

    int statusCode;
    String message;

    //------------------------------------------------------------------------------------------------------------------

    public HttpsResponse(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    //------------------------------------------------------------------------------------------------------------------

    public int getStatusCode() {
        return statusCode;
    }

    //------------------------------------------------------------------------------------------------------------------

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    //------------------------------------------------------------------------------------------------------------------

    public String getMessage() {
        return message;
    }

    //------------------------------------------------------------------------------------------------------------------

    public void setMessage(String message) {
        this.message = message;
    }

    //------------------------------------------------------------------------------------------------------------------

}
