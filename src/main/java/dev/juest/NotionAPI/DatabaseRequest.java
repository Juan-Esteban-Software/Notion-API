package dev.juest.NotionAPI;

import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;

import java.io.IOException;

public class DatabaseRequest implements IDatabaseRequest{

    @Override
    public String createDatabase(String json) {
        return "";
    }

    @Override
    public String filterDatabase(String json) {
        return "";
    }

    @Override
    public String sortDatabase(String json) {
        return "";
    }

    @Override
    public String queryDatabase() {
        return "";
    }

    @Override
    public String retrieveDatabase() {
        return "";
    }

    @Override
    public String updateDatabase(String json) {
        return "";
    }

    @Override
    public String updateDatabaseProperties() {
        return "";
    }
}
