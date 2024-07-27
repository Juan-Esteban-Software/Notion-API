package dev.juest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class read {

    public static String leer(String direccion){
        String content = "";
        try {
            // Leer el contenido del archivo en una cadena
             content = new String(Files.readAllBytes(Paths.get(direccion)));

            // Imprimir el contenido del archivo
        } catch (IOException e) {
            // Manejo de errores
            System.err.println("Error reading file: " + e.getMessage());
        }
        return content;
    }




}
