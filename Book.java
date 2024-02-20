public class Book implements Borrowable {
    private static int lastISBN = 1234;
    private int isbn;
    private String title;
    private Author author;
    private String publisher;
    private int numCopies;

    public Book(String title, Author author, String publisher, int numCopies) {
        this.isbn = ++lastISBN;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.numCopies = numCopies;
        author.addBookToAuthor(this);
    }

    public Book(Book b) {
        this.isbn = ++lastISBN;
        this.title = b.title;
        this.author = b.author;
        this.publisher = b.publisher;
        this.numCopies = b.numCopies;
        author.addBookToAuthor(this);
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;

    }

    public Author getAuthor() {
        return this.author;
    }

    public void setAuthor(Author author) {
        this.author = author;
        author.addBookToAuthor(this);
    }

    public int getISBN() {
        return this.isbn;
    }

    public void setISBN(int isbn) {
        this.isbn = isbn;
    }

    public String getPublisher() {
        return this.publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getNumCopies() {
        return this.numCopies;
    }

    public void setNumCopies(int numCopies) {
        this.numCopies = numCopies;
    }

    @Override
    public void returnBooks(int numCopies) {
        // Increase the number of copies available when the book is returned
        this.numCopies = this.numCopies + numCopies;
    }

    @Override
    public void borrowBooks(int numCopies) {
        if (this.numCopies >= numCopies) {
            // Decrease the number of copies available when the book is borrowed
            this.numCopies = this.numCopies - numCopies;
        } else {
            System.out.println(this.numCopies + " copies are available for borrowing.");
        }
    }

    public String toString() {
        return ("\n" + this.title + " (ISBN: " + this.isbn + ") \nby " + this.author + "\n(Copies on Hand: "
                + this.numCopies
                + ")\n");
        // " / By: " + this.author.getName() +
        // " / ISBN: " + this.isbn +
        // " / Publisher: " + this.publisher +
        // " / Copies on Hand: " + this.numCopies);
    }
}