import java.util.ArrayList;
import java.util.List;

public class Author {
    private String name;
    private String dob;
    private List<Book> authorBooksList;
    // private Book[] booksArr;

    public Author(String name, String dob) {
        this.name = name;
        this.dob = dob;
        this.authorBooksList = new ArrayList<>();
        // this.booksArr = new Book[0];
    }

    public Author(Author a) {
        this.name = a.name;
        this.dob = a.dob;
        this.authorBooksList = a.authorBooksList;
    }

    // Getter and setter methods for name
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and setter methods for date of birth (dob)
    public String getDOB() {
        return this.dob;
    }

    public void setDOB(String dob) {
        this.dob = dob;
    }

    // Getter method for books array
    public List<Book> getBooksList() {
        return this.authorBooksList;
        // return this.booksArr;
    }

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

    // Method to add a book to the author's collection
    public void addBookToAuthor(Book b) {
        this.authorBooksList.add(b);
        // Book[] newBooksArr = new Book[booksArr.length + 1];
        // System.arraycopy(this.booksArr, 0, newBooksArr, 0, this.booksArr.length);
        // newBooksArr[this.booksArr.length] = b;
        // this.booksArr = newBooksArr;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name);
        // sb.append(" / DOB: ").append(this.dob);
        // sb.append(" / Author's Book List: ");
        // if (authorBooksList.size() > 0) {
        // for (Book book : authorBooksList) {
        // sb.append("\n " + book);
        // }
        // } else {
        // sb.append("\n Author's book list is empty!");
        // }

        return sb.toString();
    }

}
