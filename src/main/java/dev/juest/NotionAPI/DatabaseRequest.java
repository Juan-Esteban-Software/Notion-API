package dev.juest.NotionAPI;


import dev.juest.NotionAPI.interfaces.IDatabaseRequest;
import dev.juest.httprequest.HttpsRequestManager;
import dev.juest.httprequest.HttpsResponse;

public class DatabaseRequest implements IDatabaseRequest {

    HttpsRequestManager requestManager;

    //------------------------------------------------------------------------------------------------------------------

    public DatabaseRequest(HttpsRequestManager requestManager) {
        this.requestManager = requestManager;
    }

    //------------------------------------------------------------------------------------------------------------------

    @Override
    public String createDatabase(String json) {
        String url = "https://api.notion.com/v1/databases";
        HttpsResponse response = this.requestManager.request(url,json,"POST");
        return response.getMessage();
    }

    //------------------------------------------------------------------------------------------------------------------

    @Override
    public String filterDatabase(String dataBaseID, String jsonFilter) {
        return this.queryDatabase(dataBaseID, jsonFilter);

    }

    //------------------------------------------------------------------------------------------------------------------

    @Override
    public String sortDatabase(String dataBaseID, String jsonSort) {
        return this.queryDatabase(dataBaseID, jsonSort);
    }

    //------------------------------------------------------------------------------------------------------------------

    @Override
    public String queryDatabase(String dataBaseID, String jsonQuery) {
        String url = "https://api.notion.com/v1/databases/"+ dataBaseID + "/query";
        HttpsResponse response = this.requestManager.request(url, jsonQuery,"POST");
        return response.getMessage();
    }

    //------------------------------------------------------------------------------------------------------------------

    @Override
    public String retrieveDatabase(String dataBaseID) {
        String url = "https://api.notion.com/v1/databases/" + dataBaseID;
        HttpsResponse response = this.requestManager.request(url, null, "GET");
        return response.getMessage();
    }

    //------------------------------------------------------------------------------------------------------------------

    @Override
    public String updateDatabase(String dataBaseID, String jsonUpdate) {
        String url = "https://api.notion.com/v1/databases/" + dataBaseID;
        HttpsResponse response = this.requestManager.request(url,jsonUpdate, "PATCH");
        return response.getMessage();
    }

    //------------------------------------------------------------------------------------------------------------------

    @Override
    public String updateDatabaseProperties(String dataBaseID, String jsonPropertiesUpdate ) {
        return this.updateDatabase(dataBaseID, jsonPropertiesUpdate);
    }

    //------------------------------------------------------------------------------------------------------------------

}
