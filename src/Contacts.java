import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * Created by renecortez on 5/25/17.
 */
public class Contacts {
    public static void main(String[] args) throws IOException {
        String directory = "data";
        String filename = "contact.txt";

        Path dataDirectory = Paths.get(directory);
        Path dataFile = Paths.get(directory, filename);

        if (Files.notExists(dataDirectory)) {
            Files.createDirectories(dataDirectory);
        }
        if (Files.notExists(dataFile)) {
            Files.createFile(dataFile);
        }

        List<String> contactList = Arrays.asList("Tuesday|2105555555", "Rene|2106458394", "John Doe|2236475746", "Jane Doe|2344325643");
        Files.write(Paths.get("data", "contact.txt"), contactList);

        List<String> lines = Files.readAllLines(dataFile);
        for (String line : lines){
            System.out.println(line);
        }
    }

}
