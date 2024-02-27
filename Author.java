import java.util.ArrayList;
import java.util.List;

/**
 * This class represents an author. It includes the authors name, date of birth,
 * and his/her book list.
 * 
 * @author Ellen Dalton
 */
public class Author {
    /**
     * Fields of an author.
     * 
     */
    private String name;
    private String dob;
    private List<Book> authorBooksList;

    /**
     * Constructs a new author object.
     * 
     * @param name
     * @param dob
     */
    public Author(String name, String dob) {
        this.name = name;
        this.dob = dob;
        this.authorBooksList = new ArrayList<>();
    }

    /**
     * Constructs a new author object.
     * 
     * @param a
     */
    public Author(Author a) {
        this.name = a.name;
        this.dob = a.dob;
        this.authorBooksList = a.authorBooksList;
    }

    /**
     * Retrieves the authors name.
     * 
     * @return Returns the authors name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the authors name.
     * 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the authors date of birth.
     * 
     * @return Returns the authors date of birth.
     */
    public String getDOB() {
        return this.dob;
    }

    /**
     * Sets the authors date of birth.
     * 
     * @param dob
     */
    public void setDOB(String dob) {
        this.dob = dob;
    }

    /**
     * Retrieves the authors book list.
     * 
     * @return Returns the authors book list.
     */
    public List<Book> getBooksList() {
        return this.authorBooksList;
    }

    /**
     * Sets the authors book list.
     * 
     * @param b1
     * @param b2
     * @param b3
     * @param b4
     */
    public void setBooksList(Book b1, Book b2, Book b3, Book b4) {
        this.authorBooksList = new ArrayList<>();
        if (b1 != null) {
            this.authorBooksList.add(b1);
            b1.setAuthor(this);
        }
        if (b2 != null) {
            this.authorBooksList.add(b2);
            b2.setAuthor(this);
        }
        if (b3 != null) {
            this.authorBooksList.add(b3);
            b3.setAuthor(this);
        }
        if (b4 != null) {
            this.authorBooksList.add(b4);
            b4.setAuthor(this);
        }
    }

    /**
     * Method to add a book to the authors collection.
     * 
     * @param b
     */
    public void addBookToAuthor(Book b) {
        this.authorBooksList.add(b);
    }

    /**
     * Method to remove a book from the authors collection.
     * 
     * @param b
     */
    public void removeBookFromAuthor(Book b) {
        this.authorBooksList.remove(b);
    }

    /**
     * Returns a string representation of the author.
     * The string representation includes the authors name.
     *
     * @return Returns a string representation of the book.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name);
        return sb.toString();
    }

}
