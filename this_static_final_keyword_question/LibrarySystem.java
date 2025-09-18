class Book {
    private static String libraryName = "Central Library";
    private final String isbn;
    private String title, author;

    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    public static void displayLibraryName() {
        System.out.println("Library: " + libraryName);
    }

    public void displayBookDetails() {
        if (this instanceof Book) {
            System.out.println("ISBN: " + isbn);
            System.out.println("Title: " + title);
            System.out.println("Author: " + author);
        }
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Book.displayLibraryName();
        Book b1 = new Book("ISBN001", "Java Basics", "James Gosling");
        b1.displayBookDetails();
    }
}