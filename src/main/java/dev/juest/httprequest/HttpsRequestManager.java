package dev.juest.httprequest;

import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.classic.methods.HttpUriRequestBase;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;

import java.io.IOException;
import java.util.Map;

public class HttpsRequestManager {

    //------------------------------------------------------------------------------------------------------------------

    public HttpsResponse request(String url, Map<String, String> headers, String body){

        HttpUriRequestBase request = this.initializeRequest(url, headers, body);
        return this.sendRequest(request);
    }

    //------------------------------------------------------------------------------------------------------------------

    private void initializeHeaders(HttpUriRequestBase request, Map<String, String> headers) {
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            request.addHeader(entry.getKey(), entry.getValue());
        }
    }

    //------------------------------------------------------------------------------------------------------------------

    private HttpUriRequestBase initializeRequest(String url, Map<String, String> headers, String body) {

        HttpPost postRequest = new HttpPost(url);
        this.initializeHeaders(postRequest, headers);

        //In case the body is empty from a GET request.
        if(body != null) {
            postRequest.setEntity(new StringEntity(body));
        }

        return postRequest;
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

}
