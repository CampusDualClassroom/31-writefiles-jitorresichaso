package com.campusdual.classroom;

import com.campusdual.Utils;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Exercise {

    public static void main(String[] args) {
        String textToSave = generateStringToSave(null);
        printToFile(textToSave);
    }

    public static String generateStringToSave(String string) {
        if (string != null) {
            return string;
        } else {
            return generateUserInputToSave();
        }
    }

    private static String generateUserInputToSave() {
        StringBuilder sb = new StringBuilder();
        System.out.println("Escribe debajo el texto que quieras. Pulsa \"ENTER\" 2 veces seguidas para finalizar:");
        String string;
        while (!(string = Utils.string()).isEmpty()) {
            sb.append(string).append(System.lineSeparator());
        }
        return sb.toString();
    }

    public static void printToFile(String string) {
        File file = new File("src/main/resources/data.txt");
        File parentDir = file.getParentFile();

        if (!parentDir.exists()) {
            parentDir.mkdirs(); // crea el directorio si no existe
        }

        try (FileWriter writer = new FileWriter(file)) {
            writer.write(string);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
