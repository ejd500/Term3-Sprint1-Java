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

    public void addAuthor(Author a) {
        // If authors list does NOT contain author, ADD AUTHOR.
        if (!authors.contains(a)) {
            authors.add(a);
        }
    }

    public void removeAuthor(Author a) {
        // If authors list contains author, REMOVE AUTHOR and BOOKS BY AUTHOR
        if (authors.contains(a)) {
            authors.remove(a);
            for (Book book : a.getBooksList()) {
                books.remove(book);
            }
        }

    }

    public void addPatron(Patron p) {
        // If patrons does NOT contain patron, add patron to patrons list.
        if (!patrons.contains(p)) {
            patrons.add(p);
        }

    }

    public void removePatron(Patron p) {
        // If patron in patrons list, remove patron.
        if (patrons.contains(p)) {
            patrons.remove(p);
        } else {
            System.out.println("The patron you are trying to remove does not exist.");
        }
    }

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

    public void returnBooks(Book b, Patron p, int numCopies) {
        p.returnBooks(b, numCopies);
    }

    public String toString() {
        return ("BOOKS: " + this.books + "\n" +
                "\nAUTHORS: " + this.authors + "\n" +
                "\nPATRONS: " + this.patrons);
    }

}
