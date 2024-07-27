package dev.juest.NotionAPI;

import dev.juest.httprequest.HttpsRequestManager;
import dev.juest.httprequest.HttpsResponse;

import java.util.HashMap;
import java.util.Map;

public class PageRequest implements IPageRequest {

    private final HttpsRequestManager requestManager;
    private final String notionVersion;

    //------------------------------------------------------------------------------------------------------------------

    public PageRequest(HttpsRequestManager requestManager,String notionVersion ) {
        this.requestManager = requestManager;
        this.notionVersion = notionVersion;
    }


    //------------------------------------------------------------------------------------------------------------------

    @Override
    public String createPage(String newPageJson) {
        String url = "https://api.notion.com/v1/pages";
        HttpsResponse response = this.requestManager.request(url,this.assemblePost(),newPageJson);
        return response.getMessage();
    }

    //------------------------------------------------------------------------------------------------------------------

    @Override
    public String deletePage(String pageId) {

        String url ="https://api.notion.com/v1/pages/";
        String requestURL = url + pageId;
        String jsonBody = "{ \"archived\": true }";

        HttpsResponse response = this.requestManager.request(requestURL,this.assemblePatch(),jsonBody);

        return response.getMessage();
    }

    //------------------------------------------------------------------------------------------------------------------

    @Override
    public String updatePage(String pageId, String dataBaseId, String changesJson) {

        String url ="https://api.notion.com/v1/pages/";
        String requestURL = url + pageId;

        HttpsResponse response = this.requestManager.request(requestURL,this.assemblePatch(),changesJson);

        return response.getMessage();
    }

    //------------------------------------------------------------------------------------------------------------------

    @Override
    public String getPageJson(String pageId) {


        String url ="https://api.notion.com/v1/pages/";
        String requestURL = url + pageId;

        HttpsResponse response = this.requestManager.request(requestURL, this.assembleGet(),null);
        return response.getMessage();
    }

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
