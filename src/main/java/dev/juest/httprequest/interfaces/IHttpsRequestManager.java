package dev.juest.httprequest.interfaces;

import dev.juest.httprequest.HttpsResponse;

public interface IHttpsRequestManager {

    HttpsResponse request(String url, String body, String type);
}
