package examseating.fileio;

import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {
    public static void writeToFile(String content, String filePath) {
        try {
            FileWriter writer = new FileWriter(filePath);
            writer.write(content);
            writer.close();
            System.out.println("Data written to file successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to file: " + e.getMessage());
        }
    }
}
