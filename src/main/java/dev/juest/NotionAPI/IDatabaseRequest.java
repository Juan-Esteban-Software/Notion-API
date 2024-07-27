package dev.juest.NotionAPI;

public interface IDatabaseRequest {

    String createDatabase(String json);
    String filterDatabase(String json);
    String sortDatabase(String json);
    String queryDatabase();
    String retrieveDatabase();
    String updateDatabase(String json);
    String updateDatabaseProperties();


}
