package dev.juest.NotionAPI;

import dev.juest.NotionAPI.interfaces.IPageRequest;
import dev.juest.httprequest.HttpsRequestManager;
import dev.juest.httprequest.HttpsResponse;
import dev.juest.httprequest.interfaces.IHttpsRequestManager;


public class PageRequest implements IPageRequest {

    private final IHttpsRequestManager requestManager;

    //------------------------------------------------------------------------------------------------------------------

    public PageRequest(HttpsRequestManager requestManager) {
        this.requestManager = requestManager;
    }


    //------------------------------------------------------------------------------------------------------------------

    @Override
    public String createPage(String newPageJson) {
        String url = "https://api.notion.com/v1/pages";
        HttpsResponse response = this.requestManager.request(url,newPageJson,"POST");
        return response.getMessage();
    }

    //------------------------------------------------------------------------------------------------------------------

    @Override
    public String deletePage(String pageId) {

        String jsonBody = "{ \"archived\": true }";
        return this.updatePage(pageId,jsonBody);
    }

    //------------------------------------------------------------------------------------------------------------------

    @Override
    public String updatePage(String pageId, String changesJson) {

        String url ="https://api.notion.com/v1/pages/";
        String requestURL = url + pageId;

        HttpsResponse response = this.requestManager.request(requestURL,changesJson,"PATCH");

        return response.getMessage();
    }

    //------------------------------------------------------------------------------------------------------------------

    @Override
    public String getPageJson(String pageId) {


        String url ="https://api.notion.com/v1/pages/";
        String requestURL = url + pageId;

        HttpsResponse response = this.requestManager.request(requestURL, null,"GET");
        return response.getMessage();
    }

    //------------------------------------------------------------------------------------------------------------------


}
