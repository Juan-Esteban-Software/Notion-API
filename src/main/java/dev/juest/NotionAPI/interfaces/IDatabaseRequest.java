package dev.juest.NotionAPI.interfaces;

public interface IDatabaseRequest {

    String createDatabase(String json);

    String filterDatabase(String dataBaseID, String jsonFilter);

    String sortDatabase(String dataBaseID, String jsonSort);

    String queryDatabase(String dataBaseID, String jsonQuery);

    String retrieveDatabase(String dataBas eID);

    String updateDatabase(String dataBaseID, String jsonUpdate);

    String updateDatabaseProperties(String dataBaseID, String jsonPropertiesUpdate);
}
