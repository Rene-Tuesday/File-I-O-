import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by renecortez on 5/25/17.
 */
public class Contacts {

    private String name;
    private String number;
    static Scanner input = new Scanner(System.in);


    public Contacts(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }


    public static void displayMenuForUser(){


    }



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


        List<String > contactList = new ArrayList<>();

        System.out.println("Welcome to your Contacts List\n" +
                "1. View contacts.\n" +
                "2. Add a new contact.\n" +
                "3. Search a contact by name.\n" +
                "4. Delete an existing contact.\n" +
                "5. Exit.");
        System.out.println("Enter an option (1, 2, 3, 4 or 5):");
        int userChoice = input.nextInt();

        switch (userChoice){
            case 1:
                List<String> lines = Files.readAllLines(dataFile);
                for (String line : lines){
                    System.out.println(line);
                }
                break;
            case 2:
                System.out.println("Enter new contact name and number: (name|number)");
                input.nextLine();
                String newContact = input.nextLine();
                Files.write(
                        Paths.get("data", "contact.txt"),
                        Arrays.asList(newContact),
                        StandardOpenOption.APPEND);
                break;
            case 3:
                System.out.println("Enter name of contact you want to see:");
                input.nextLine();
                String contactSearch = input.nextLine().trim();
                FileSearch fileSearch = new FileSearch();
                fileSearch.parseFile("src/contact.txt", contactSearch);
                System.out.println();

        }








//
//        public static void main(String[] args) throws FileNotFoundException{
//            FileSearch fileSearch = new FileSearch();
//            fileSearch.parseFile("src/main/resources/test.txt", "am");
//        }

        }

    }

}
