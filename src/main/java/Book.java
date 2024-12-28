// Book.java
public class Book {
    // Attributes of the book
    private String title;
    private String author;
    private String ISBN;
    private double price;
    private int yearPublished;

    // Constructor
    public Book(String title, String author, String ISBN, double price, int yearPublished) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.price = price;
        this.yearPublished = yearPublished;
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    // Method to display book details
    public void displayBookDetails() {
        System.out.println("Book Details:");
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + ISBN);
        System.out.println("Price: $" + price);
        System.out.println("Year Published: " + yearPublished);
    }

    // Main method for testing
    public static void main(String[] args) {
        // Creating a book object
        Book book = new Book("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565", 10.99, 1925);
        
        // Displaying the book details
        book.displayBookDetails();
        
        // Updating some attributes
        book.setPrice(12.99);
        book.setYearPublished(1926);

        // Displaying updated details
        System.out.println("\nUpdated Book Details:");
        book.displayBookDetails();
    }
}
