import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<Author> authors;
    private List<Patron> patrons;

    public Library() {
        this.books = new ArrayList<>();
        this.authors = new ArrayList<>();
        this.patrons = new ArrayList<>();
    }

    // Add a book to the library, and add author IF author is not already in author
    // list.
    public void addBook(Book book) {
        books.add(book);
        // If book author is not in authors list, add book author.
        if (!authors.contains(book.getAuthor())) {
            authors.add(book.getAuthor());
        }
    }

    // Remove a book from the library, and remove author IF author has no other
    // books.
    public void removeBook(Book book) {
        books.remove(book);
        // If books list has only one of that author, remove author from library.
        // Check if the author of the removed book has no other books in the library
        Author author = book.getAuthor();
        boolean hasOtherBooks = false;
        for (Book b : books) {
            if (b.getAuthor().equals(author)) {
                hasOtherBooks = true;
                break;
            }
        }
        // If the author does NOT have other books in the library, remove the author
        // from the authors list
        if (!hasOtherBooks) {
            authors.remove(author);
        }
    }

}
