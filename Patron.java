public class Patron {
    private String fname;
    private String lname;
    private Address address;
    private String phoneNum;
    private Book[] borrowedBooksArr;

    public Patron(String fname, String lname, Address address, String phoneNum){
        this.fname = fname;
        this.lname = lname;
        this.address = address;
        this.phoneNum = phoneNum;
        this.borrowedBooksArr = new Book[0];
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Patron Name: ").append(this.fname + " " + this.lname);
        sb.append("\nPhone: ").append(this.phoneNum);
        sb.append("\nAddress: ").append(this.address);
        sb.append("\nBorrowed Book List: ");
        if(borrowedBooksArr.length > 0){
            for (Book book : borrowedBooksArr) {
                sb.append("\n   " + book.getTitle());
            }
        } else {
            sb.append("You have no borrowed books!");
        }
        
        return sb.toString();       
    }


    public void returnBook(Book b, int numCopies) {
        b.returnBooks(numCopies);
        Book[] newBorrowedBooksArr;
        if (borrowedBooksArr.length > 0) {
            newBorrowedBooksArr = new Book[borrowedBooksArr.length - 1];
            int index = 0;
            // Iterate through the borrowedBooksArr to find the book to return
            for (Book borrowedBook : borrowedBooksArr) {
                // If the book matches the one to return, increase the number of copies
                // and skip adding it to the new array
                if (!borrowedBook.getTitle().equals(b.getTitle())) {
                    newBorrowedBooksArr[index] = borrowedBook;
                    index++;
                }
            }
        } else {
            newBorrowedBooksArr = new Book[0];
            System.out.println("Can't return " + numCopies + " copies... Zero books were borrowed!");
        }
        
        // Update the borrowedBooksArr with the new array of borrowed books
        this.borrowedBooksArr = newBorrowedBooksArr;
    }

    public void borrowBook(Book b, int numCopies) {
        Book[] newBorrowedBooksArr = new Book[borrowedBooksArr.length + numCopies];
        System.arraycopy(this.borrowedBooksArr, 0, newBorrowedBooksArr, 0, this.borrowedBooksArr.length);
        newBorrowedBooksArr[this.borrowedBooksArr.length] = b;
        this.borrowedBooksArr = newBorrowedBooksArr;
        b.borrowBooks(numCopies);

    }

}
