import jodd.json.JsonParser;
import jodd.json.JsonSerializer;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

/**
 * Created by jessicahuffstutler on 10/14/15.
 */
public class Serializer {
    static Responder responder;

    public static void main(String[] args) {
        responder = loadSerializer();

        if(responder == null) {
            responder = new Responder();
            System.out.println("Please answer the questions below:");
            responder.enterTitle(); //title
            responder.enterAuthor(); //author
            responder.enterType(); //fiction/nonfiction
            responder.enterPageNumbers(); //page numbers
            responder.enterYearPublished(); //year published
        } else {
            System.out.println(String.format("Title: %s | Author: %s | Type: %s | Number of Pages: %d | Year Published: %d", responder.title, responder.author, responder.type, responder.pageNumbers, responder.yearPublished));
            System.out.println("Review your answers above and update your answers to the questions below:");
            responder.enterTitle(); //title
            responder.enterAuthor(); //author
            responder.enterType(); //fiction/nonfiction
            responder.enterPageNumbers(); //page numbers
            responder.enterYearPublished(); //year published
        }

        saveResponder();
    }

    static String nextLine() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        return s;
    }

        static void saveResponder() {
        File f = new File("save.json"); //json library wants you to set getters for anything you want to save
        JsonSerializer serializer = new JsonSerializer();
        String contentToSave = serializer.serialize(responder);

        try {
            FileWriter fw = new FileWriter(f);
            fw.write(contentToSave);
            fw.close();
        } catch (Exception e) {
            System.out.println("Save not successful.");
        }
    }

    static Responder loadSerializer() {
        try {
            File f = new File("save.json");
            FileReader fr = new FileReader(f);
            int fileSize = (int) f.length();
            char[] contents = new char[fileSize];
            fr.read(contents);
            String fileContents = new String(contents);
            //System.out.println(fileContents); ->this shows the contents exactly as they appear in the save.json file. commenting out to create better viewability above.
            JsonParser parser = new JsonParser();
            return parser.parse(fileContents, Responder.class);
        } catch (Exception e) {
            //System.out.println("No previous file was found."); -> this prints every time it runs for the first time.
            return null;
        }

    }
}
