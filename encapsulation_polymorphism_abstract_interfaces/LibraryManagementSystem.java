import java.util.*;

interface Reservable {
    boolean reserveItem(String userId);
    boolean checkAvailability();
}

abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;
    private boolean available = true;

    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    public String getItemId() { return itemId; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }

    public boolean isAvailable() { return available; }
    protected void setAvailable(boolean available) { this.available = available; }

    public abstract int getLoanDuration(); // days

    public void getItemDetails() {
        System.out.println("ItemId: " + itemId + ", Title: " + title + ", Author: " + author + ", Available: " + available);
    }
}

class Book extends LibraryItem implements Reservable {
    public Book(String id, String title, String author) { super(id, title, author); }

    @Override
    public int getLoanDuration() { return 21; }

    @Override
    public boolean reserveItem(String userId) {
        if (isAvailable()) {
            setAvailable(false);
            return true;
        }
        return false;
    }

    @Override
    public boolean checkAvailability() { return isAvailable(); }
}

class Magazine extends LibraryItem {
    public Magazine(String id, String title, String author) { super(id, title, author); }

    @Override
    public int getLoanDuration() { return 7; }
}

class DVD extends LibraryItem implements Reservable {
    public DVD(String id, String title, String author) { super(id, title, author); }

    @Override
    public int getLoanDuration() { return 3; }

    @Override
    public boolean reserveItem(String userId) {
        if (isAvailable()) { setAvailable(false); return true; }
        return false;
    }

    @Override
    public boolean checkAvailability() { return isAvailable(); }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        List<LibraryItem> items = Arrays.asList(
            new Book("B101", "Java Programming", "Author A"),
            new Magazine("M201", "Tech Monthly", "Editor X"),
            new DVD("D301", "Learning Java DVD", "Producer Y")
        );

        System.out.println("---- Library Items ----");
        for (LibraryItem it : items) {
            it.getItemDetails();
            System.out.println("Loan Duration (days): " + it.getLoanDuration());
            if (it instanceof Reservable) {
                Reservable r = (Reservable)it;
                System.out.println("Reserve attempt: " + r.reserveItem("user123"));
            }
            System.out.println();
        }
    }
}
