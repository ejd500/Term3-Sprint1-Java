import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a library. It includes a list of books, a list of
 * authors, and a list of patrons.
 * 
 * @author Ellen Dalton
 */
public class Library {
    private List<Book> books;
    private List<Author> authors;
    private List<Patron> patrons;

    /**
     * Constructs a new library object.
     * 
     */
    public Library() {
        this.books = new ArrayList<>();
        this.authors = new ArrayList<>();
        this.patrons = new ArrayList<>();
    }

    /**
     * A method to add a book to the library. IF the author is not already in the
     * authors list,
     * add the books author to the list.
     * 
     * @param book
     */
    public void addBook(Book book) {
        books.add(book);
        if (!authors.contains(book.getAuthor())) {
            authors.add(book.getAuthor());
        }
    }

    /**
     * A method to remove a book from the library.
     * Method also removes author from the library IF the author has no other books.
     * 
     * @param book
     */
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

    /**
     * A method to add an author to the library.
     * 
     * @param a
     */
    public void addAuthor(Author a) {
        // If authors list does NOT contain author, ADD AUTHOR.
        if (!authors.contains(a)) {
            authors.add(a);
        } else {
            System.out.println("Author is already in the library.");
        }
    }

    /**
     * A method to remove an author from the library.
     * This also removes any books written by that author.
     * 
     * @param a
     */
    public void removeAuthor(Author a) {
        // If authors list contains author, REMOVE AUTHOR and BOOKS BY AUTHOR
        if (authors.contains(a)) {
            authors.remove(a);
            for (Book book : a.getBooksList()) {
                books.remove(book);
            }
        }

    }

    /**
     * A method to add a patron to the library.
     * 
     * @param p
     */
    public void addPatron(Patron p) {
        // If patrons does NOT contain patron, add patron to patrons list.
        if (!patrons.contains(p)) {
            patrons.add(p);
        } else {
            System.out.println("The patron you are trying to add already exists.");
        }

    }

    /**
     * A method to remove a patron from the library.
     * 
     * @param p
     */
    public void removePatron(Patron p) {
        // If patron in patrons list, remove patron.
        if (patrons.contains(p)) {
            patrons.remove(p);
        } else {
            System.out.println("The patron you are trying to remove does not exist.");
        }
    }

    /**
     * A method to search for a book by using the title.
     * It retrieves a string representation of the number of copies available.
     * 
     * @param title
     * @return Returns a string representation of the number of copies available of
     *         a certain title.
     */
    public String searchByTitle(String title) {
        if (books.size() > 0) {
            for (Book book : books) {
                if (book.getTitle().equals(title)) {
                    return ("There are " + book.getNumCopies() + " copies of " + book.getTitle() + " available.");
                }
            }
            return ("The book you are searching for is not in the library.");
        } else {
            return ("There are no books currently in the library.");
        }

    }

    /**
     * A method to search for an author.
     * It retrieves a string representation of whether or not the author was found
     * in the library and if found, also displays his/her book list.
     * 
     * @param a
     * @return Returns a string representation of whether or not the author was
     *         found in the library. If found, his/her book list is also displayed.
     */
    public String searchByAuthor(Author a) {
        if (authors.size() > 0) {
            for (Author author : authors) {
                if (author.equals(a)) {
                    return (author.getName() + " was found in the library! \nHis book list is: "
                            + author.getBooksList());
                }
            }
            return ("The author you are searching for is not in the library.");
        } else {
            return ("There are no authors currently in the library.");
        }
    }

    /**
     * A method to search for a book by using the isbn.
     * It retrieves a string representation of wheather or not the isbn was found in
     * the library. If found, it also displays the book title and author.
     * 
     * @param isbn
     * @return Returns a string representation of wheather or not the isbn was found
     *         in the library. If found, it also displays the book title and author.
     */
    public String searchByISBN(int isbn) {
        if (books.size() > 0) {
            for (Book book : books) {
                if (book.getISBN() == isbn) {
                    return ("ISBN " + book.getISBN() + " was found in the library! The book title is: "
                            + book.getTitle() + " by " + book.getAuthor());
                }
            }
            return ("The ISBN you are searching for is not in the library.");
        } else {
            return ("There are no books currently in the library.");
        }
    }

    /**
     * A method to allow a patron to borrow a certain number of copies of a book
     * from the library. This method calls the borrowBooks method in the patron
     * class, which updates the number of copies available and also updates the
     * patrons borrowed book list.
     * 
     * @param b
     * @param p
     * @param numCopies
     */
    public void borrowBooks(Book b, Patron p, int numCopies) {
        boolean found = false;
        for (Book book : books) {
            if (book.equals(b)) {
                found = true;
                p.borrowBooks(b, numCopies);
                break; // Exit the loop once the book is found and borrowed
            }
        }
        if (!found) {
            System.out.println("The book you are looking to borrow is not in the library.");
        }
    }

    /**
     * A method to allow a patron to return a certain number of copies of a book to
     * the library.
     * IF the book title is in the patrons borrowed book list, then this method
     * calls the returnBooks method in the patron class, which updates the number of
     * copies available and also updates
     * the patrons borrowed book list. IF the book title is not in the patrons
     * borrowed book list, a message is returned to the console indicating that the
     * title you are trying to return was not borrowed.
     * 
     * @param b
     * @param p
     * @param numCopies
     */
    public void returnBooks(Book b, Patron p, int numCopies) {
        if (p.getBorrowedBookList().contains(b.getTitle())) {
            p.returnBooks(b, numCopies);
        } else {
            System.out.println("Sorry, you have not borrowed the title you are trying to return.");
        }

    }

    /**
     * Returns a string representation of the library.
     * The string representation includes a list of books, a list of authors, and a
     * list of patrons.
     *
     * @return Returns a string representation of the library. This includes a list
     *         of books, a list of authors, and a list of patrons.
     */
    public String toString() {
        return ("BOOKS: " + this.books + "\n" +
                "\nAUTHORS: " + this.authors + "\n" +
                "\nPATRONS: " + this.patrons);
    }

}
