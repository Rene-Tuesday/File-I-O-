import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by canidmars on 5/30/17.
 */

public class FileSearch {

    public void parseFile(String filename, String searchStr) throws FileNotFoundException {
        Scanner scan = new Scanner(new File(String.valueOf(filename)));
        while (scan.hasNext()) {
            String line = scan.nextLine().toLowerCase().toString();
            if (line.contains(searchStr)) {
                System.out.println(line);
            }
        }
    }
}
