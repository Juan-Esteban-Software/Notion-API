package dev.juest;

import dev.juest.NotionAPI.DatabaseRequest;
import dev.juest.NotionAPI.PageRequest;
import dev.juest.httprequest.HttpsRequestManager;

public class Main {

    private final String NOTION_VERSION= "2022-06-28";

    public static void main(String[] args) {
        PageRequest notionApiPage = new PageRequest(new HttpsRequestManager("2022-06-28"));
        DatabaseRequest notionApiDatabase = new DatabaseRequest(new HttpsRequestManager("2022-06-28"));

      String page =  notionApiPage.getPageJson("e1cbeb77d7c446ad9e0d2dc305b0a5a0");
        System.out.println(page);
    }

}