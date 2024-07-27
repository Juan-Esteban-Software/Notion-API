package dev.juest;

import dev.juest.NotionAPI.PageRequest;
import dev.juest.httprequest.HttpsRequestManager;

public class Main {

    private final String NOTION_VERSION= "2022-06-28";

    public static void main(String[] args) {
        PageRequest notionApi = new PageRequest(new HttpsRequestManager(),"2022-06-28");


        //String hola = notionApi.getPageJson("c518c3e2af154c5abccb686e4eb794a9");
        //String adio = notionApi.deletePage("c518c3e2af154c5abccb686e4eb794a9");



        String json = read.leer("paginaNueva.json");
        String crear = notionApi.createPage(json);

        //System.out.println(hola);
        //System.out.println(adio);
        System.out.println(crear);
    }

}