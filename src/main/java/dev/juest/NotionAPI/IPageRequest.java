package dev.juest.NotionAPI;

public interface IPageRequest {

    public String createPage(String dataBaseId);
    public String deletePage(String pageId);
    public String updatePage(String pageId, String dataBaseId, String newPageJson);
    public String getPageJson(String pageId);

}
