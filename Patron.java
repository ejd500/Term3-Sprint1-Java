public class Patron {
    private String fname;
    private String lname;
    private Address address;
    private String phoneNum;
    private Book[] borrowedBooksArr;

    public Patron(String fname, String lname, Address address, String phoneNum) {
        this.fname = fname;
        this.lname = lname;
        this.address = address;
        this.phoneNum = phoneNum;
        this.borrowedBooksArr = new Book[0];
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Patron Name: ").append(this.fname + " " + this.lname);
        sb.append("\nPhone: ").append(this.phoneNum);
        sb.append("\nAddress: ").append(this.address);
        sb.append("\nBorrowed Book List: ");
        if (borrowedBooksArr != null && borrowedBooksArr.length > 0) {
            for (Book book : borrowedBooksArr) {
                sb.append("\n   ");
                if (book != null) {
                    sb.append(book.getTitle());
                } else {
                    sb.append("Unknown Title (Book is null)");
                }
            }
        } else {
            sb.append("You have no borrowed books!");
        }

        // if(borrowedBooksArr.length > 0){
        // for (Book book : borrowedBooksArr) {
        // sb.append("\n " + book.getTitle());
        // }
        // } else {
        // sb.append("You have no borrowed books!");
        // }

        return sb.toString();
    }

    public void returnBook(Book b) {
        if (borrowedBooksArr.length == 0) {
            System.out.println("Can't return book... Zero books were borrowed!");
        }
        try {
            int index = 0;
            Book[] newBorrowedBooksArr = new Book[borrowedBooksArr.length - 1];
            boolean returned = false; // Flag to track if the book has been returned
            // Iterate over borrowedBooksArr to find the book to return
            for (Book borrowedBook : borrowedBooksArr) {
                if (!returned && borrowedBook.getTitle().equals(b.getTitle())) {
                    b.returnBook();
                    returned = true; // Set the flag to true to indicate that the book has been returned
                } else {
                    // If the book is not the one being returned, add it to the new array
                    newBorrowedBooksArr[index] = borrowedBook;
                    index++;
                }
            }
            // Update the array of borrowed books
            this.borrowedBooksArr = newBorrowedBooksArr;
        } catch (Exception e) {
            System.out.println("The title you are trying to return was not borrowed!");
        }
    }

    public void borrowBook(Book b) {
        if (b.getNumCopies() > 0) {
            b.borrowBook();
            Book[] newBorrowedBooksArr = new Book[borrowedBooksArr.length + 1];
            System.arraycopy(this.borrowedBooksArr, 0, newBorrowedBooksArr, 0, this.borrowedBooksArr.length);
            newBorrowedBooksArr[this.borrowedBooksArr.length] = b;
            this.borrowedBooksArr = newBorrowedBooksArr;
        } else {
            System.out.println("Sorry, no copies available at this time.");
        }

    }

}
