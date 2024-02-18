public class Book implements Borrowable {
    private String title;
    private Author author;
    private String isbn;
    private String publisher;
    private int numCopies;

    public Book(String title, Author author, String isbn, String publisher, int numCopies) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publisher = publisher;
        this.numCopies = numCopies;
        author.addBookToAuthor(this);
    }

    public Book(Book b) {
        this.title = b.title;
        this.author = b.author;
        this.isbn = b.isbn;
        this.publisher = b.publisher;
        this.numCopies = b.numCopies;
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
    }

    public String getISBN() {
        return this.isbn;
    }

    public void setISBN(String isbn) {
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
    public void returnBook() {
        // Increase the number of copies available when the book is returned
        this.numCopies = this.numCopies + 1;
    }

    @Override
    public void borrowBook() {
        if (this.numCopies >= 1) {
            // Decrease the number of copies available when the book is borrowed
            this.numCopies = this.numCopies - 1;
        } else {
            System.out.println(this.numCopies + " copies are available for borrowing.");
        }
    }

    public String toString() {
        return ("Title: " + this.title +
                "\nAuthor: " + this.author.getName() +
                "\nISBN: " + this.isbn +
                "\nPublisher: " + this.publisher +
                "\nCopies on Hand: " + this.numCopies);
    }
}