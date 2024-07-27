package dev.juest.httprequest;

import dev.juest.httprequest.interfaces.IHttpsRequestManager;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPatch;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.classic.methods.HttpUriRequestBase;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class HttpsRequestManager implements IHttpsRequestManager {

    private final String notionVersion;

    public HttpsRequestManager(String notionVersion) {
        this.notionVersion = notionVersion;
    }


    //------------------------------------------------------------------------------------------------------------------

    @Override
    public HttpsResponse request(String url, String body, String type){
        HttpUriRequestBase request = switch (type) {

            case "GET" -> this.initializeRequest(url, assembleGet(), body,"GET");
            case "POST" -> this.initializeRequest(url, assemblePost(), body,"POST");
            case "PATCH" -> this.initializeRequest(url, assemblePatch(), body,"PATCH");
            default -> null;

        };

        return this.sendRequest(request);
    }

    //------------------------------------------------------------------------------------------------------------------

    private void initializeHeaders(HttpUriRequestBase request, Map<String, String> headers) {
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            request.addHeader(entry.getKey(), entry.getValue());
        }
    }

    //------------------------------------------------------------------------------------------------------------------

    private HttpUriRequestBase initializeRequest(String url, Map<String, String> headers, String body,String type) {

        HttpUriRequestBase newRequest = switch (type) {
            case "GET" -> new HttpGet(url);
            case "POST" -> new HttpPost(url);
            case "PATCH" -> new HttpPatch(url);
            default -> null;
        };

        this.initializeHeaders(newRequest, headers);

        //In case the body is empty from a GET request.
        if(body != null) {
            newRequest.setEntity(new StringEntity(body));
        }

        return newRequest;
    }

    //------------------------------------------------------------------------------------------------------------------

    private HttpsResponse sendRequest(HttpUriRequestBase request) {

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {


            try (CloseableHttpResponse response = httpClient.execute(request)) {

                int statusCode = response.getCode();
                String responseBody = EntityUtils.toString(response.getEntity());

                return new HttpsResponse(statusCode, responseBody);

            } catch (ParseException e) {
                return new HttpsResponse(400, null);
            }

        }  catch (IOException e) {
            return new HttpsResponse(500, null);
        }

    }

    //------------------------------------------------------------------------------------------------------------------


    //------------------------------------------------------------------------------------------------------------------

    private Map<String,String> assembleGet(){
        Map<String,String> request = new HashMap<>();
        request.put("Authorization", System.getenv("API_KEY"));
        request.put("Notion-Version", notionVersion);
        request.put("method","GET");
        return request;
    }

    //------------------------------------------------------------------------------------------------------------------

    private Map<String,String> assemblePost(){
        Map<String,String> request = this.assembleGet();
        request.put("Content-Type", "application/json");
        return request;
    }

    //------------------------------------------------------------------------------------------------------------------

    private Map<String,String> assemblePatch(){
        return assemblePost();
    }

    //------------------------------------------------------------------------------------------------------------------

}
