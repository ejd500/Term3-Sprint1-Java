
public class Author {
    private String name;
    private String dob;
    private Book[] booksArr;

    public Author(String name, String dob){
        this.name = name;
        this.dob = dob;
        this.booksArr = new Book[0];
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
    public Book[] getBooksArr() {
        return this.booksArr;
    }

    // Method to add a book to the author's collection
    public void addBookToAuthor(Book b) {
        Book[] newBooksArr = new Book[booksArr.length + 1];
        System.arraycopy(this.booksArr, 0, newBooksArr, 0, this.booksArr.length);
        newBooksArr[this.booksArr.length] = b;
        this.booksArr = newBooksArr;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Author Name: ").append(this.name);
        sb.append("\nAuthor DOB: ").append(this.dob);
        sb.append("\nAuthor's Book List: ");
        for (Book book : booksArr) {
            sb.append("\n   " + book.getTitle());
        }
        return sb.toString();
    }


}
