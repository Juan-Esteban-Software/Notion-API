package dev.juest;

import dev.juest.NotionAPI.PageRequest;
import dev.juest.httprequest.HttpsRequestManager;

public class Main {

    private final String NOTION_VERSION= "2022-06-28";

    public static void main(String[] args) {
        PageRequest notionApi = new PageRequest(new HttpsRequestManager("2022-06-28"));


        String hola = notionApi.getPageJson("aca8199f3dbe45eab98694a6a38ceb97");
        String adio = notionApi.deletePage("aca8199f3dbe45eab98694a6a38ceb97");



        String json = read.leer("paginaNueva.json");
        String crear = notionApi.createPage(json);

        System.out.println(hola);
        System.out.println(adio);
        System.out.println(crear);
    }

}