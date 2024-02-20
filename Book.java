/**
 * This class represents a book. It includes the books isbn, title, author,
 * publisher, and number of copies available.
 * 
 * @author Ellen Dalton
 */
public class Book implements Borrowable {
    private static int lastISBN = 1234;
    private int isbn;
    private String title;
    private Author author;
    private String publisher;
    private int numCopies;

    /**
     * Constructs a new book object.
     * 
     * @param title
     * @param author
     * @param publisher
     * @param numCopies
     * 
     */
    public Book(String title, Author author, String publisher, int numCopies) {
        this.isbn = ++lastISBN;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.numCopies = numCopies;
        author.addBookToAuthor(this);
    }

    /**
     * Constructs a new book object.
     * 
     * @param b
     */
    public Book(Book b) {
        this.isbn = ++lastISBN;
        this.title = b.title;
        this.author = b.author;
        this.publisher = b.publisher;
        this.numCopies = b.numCopies;
        author.addBookToAuthor(this);
    }

    /**
     * Retrives the title of the book.
     * 
     * @return Returns the title of the book.
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Sets the title of the book.
     * 
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;

    }

    /**
     * Retrieves the author of the book.
     * 
     * @return Returns the author of the book.
     */
    public Author getAuthor() {
        return this.author;
    }

    /**
     * Sets the author of the book.
     * 
     * @param author
     */
    public void setAuthor(Author author) {
        this.author = author;
        author.addBookToAuthor(this);
    }

    /**
     * Retrieves the isbn of the book.
     * 
     * @return Returns the isbn of the book.
     */
    public int getISBN() {
        return this.isbn;
    }

    /**
     * Sets the isbn of the book.
     * 
     * @param isbn
     */
    public void setISBN(int isbn) {
        this.isbn = isbn;
    }

    /**
     * Retrieves the publisher of the book.
     * 
     * @return Returns the publisher of the book.
     */
    public String getPublisher() {
        return this.publisher;
    }

    /**
     * Sets the publisher of the book.
     * 
     * @param publisher
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     * Retrieves the number of copies of the book that are available.
     * 
     * @return Returns the number of copies of the book are available.
     */
    public int getNumCopies() {
        return this.numCopies;
    }

    /**
     * Sets the number of copies that are available of the book.
     * 
     * @param numCopies
     */
    public void setNumCopies(int numCopies) {
        this.numCopies = numCopies;
    }

    /**
     * Sets the new number of copies available when a certain number of copies of a
     * book are returned.
     * 
     * @param numCopies
     */
    @Override
    public void returnBooks(int numCopies) {
        // Increase the number of copies available when the book is returned
        this.numCopies = this.numCopies + numCopies;
    }

    /**
     * Sets the new number of copies available when a certain number of copies of a
     * book are borrowed.
     * 
     * @param numCopies
     */
    @Override
    public void borrowBooks(int numCopies) {
        if (this.numCopies >= numCopies) {
            // Decrease the number of copies available when the book is borrowed
            this.numCopies = this.numCopies - numCopies;
        } else {
            System.out.println(this.numCopies + " copies are available for borrowing.");
        }
    }

    /**
     * Returns a string representation of the book.
     * The string representation includes it's title, the isbn, the author, and the
     * number of copies on hand.
     * 
     *
     * @return Returns a string representation of the book.
     */
    public String toString() {
        return ("\n" + this.title + " (ISBN: " + this.isbn + ") \nby " + this.author + "\n(Copies on Hand: "
                + this.numCopies
                + ")\n");
    }
}