/**
 * Created by jessicahuffstutler on 10/14/15.
 */
public class Responder {
    String title;
    String author;
    String type; //fiction or non fiction
    int pageNumbers; //how many page numbers does the book have?
    int yearPublished; //what year was the book published?

    public Responder() { //we may not need this
    } //we may not need this

    void enterTitle() {
        System.out.println("What is the title of the book?");
        title = Serializer.nextLine();
        System.out.println(String.format("The title is %s.", title));
    }

    void enterAuthor() {
        System.out.println("What is the name of the Author?");
        author = Serializer.nextLine();
        System.out.println(String.format("%s wrote %s.", author, title));
    }

    void enterType() {
        System.out.println("Is the book fiction or non-fiction?");
        type = Serializer.nextLine();
        System.out.println(String.format("%s is a %s book.", title, type));
    }

    void enterPageNumbers() {
        System.out.println("How many page numbers does the book have?");
        String pageNum = Serializer.nextLine();
        pageNumbers = Integer.valueOf(pageNum);
        System.out.println(String.format("%s has %d pages.", title, pageNumbers));
    }

    void enterYearPublished() {
        System.out.println("What year was the book published?");
        String yearPub = Serializer.nextLine();
        yearPublished = Integer.valueOf(yearPub);
        System.out.println(String.format("%s was published in %d", title, yearPublished));
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getType() {
        return type;
    }

    public int getPageNumbers() {
        return pageNumbers;
    }

    public int getYearPublished() {
        return yearPublished;
    }
}
