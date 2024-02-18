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

    public String getFname() {
        return this.fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return this.lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public Address getAddress() {
        return this.address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhoneNum() {
        return this.phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getBorrowedBooksList() {
        StringBuilder sb = new StringBuilder();
        sb.append("Borrowed Book List: ");
        if (borrowedBooksArr.length > 0) {
            for (Book book : borrowedBooksArr) {
                if (book != null) { // Check if the book is not null
                    sb.append("\n   ");
                    sb.append(book.getTitle());
                } else {
                    sb.append("\n   You have no borrowed books!");
                }
            }
        } else {
            sb.append("\n   You have no borrowed books!");
        }
        return sb.toString();
    }

    public void setBorrowedBooksList(Book b1, Book b2, Book b3, Book b4) {
        if (b1 == null) {
            Book[] newBorrowedBooksArr = new Book[0];
            System.out.println("Your borrowed books list has been reset!");
            // Update the array of borrowed books
            this.borrowedBooksArr = newBorrowedBooksArr;
        } else {
            Book[] newBorrowedBooksArr = new Book[1];
            newBorrowedBooksArr[0] = b1;
            // Update the array of borrowed books
            this.borrowedBooksArr = newBorrowedBooksArr;
        }
        if (b2 != null) {
            Book[] newBorrowedBooksArr = new Book[2];
            newBorrowedBooksArr[0] = b1;
            newBorrowedBooksArr[1] = b2;
            // Update the array of borrowed books
            this.borrowedBooksArr = newBorrowedBooksArr;
        }
        if (b3 != null) {
            Book[] newBorrowedBooksArr = new Book[3];
            newBorrowedBooksArr[0] = b1;
            newBorrowedBooksArr[1] = b2;
            newBorrowedBooksArr[2] = b3;
            // Update the array of borrowed books
            this.borrowedBooksArr = newBorrowedBooksArr;
        }
        if (b4 != null) {
            Book[] newBorrowedBooksArr = new Book[4];
            newBorrowedBooksArr[0] = b1;
            newBorrowedBooksArr[1] = b2;
            newBorrowedBooksArr[2] = b3;
            newBorrowedBooksArr[3] = b4;
            // Update the array of borrowed books
            this.borrowedBooksArr = newBorrowedBooksArr;
        }
    }

    public void returnBooks(Book b, int numCopiesToReturn) {
        if (borrowedBooksArr.length == 0) {
            System.out.println("Can't return book... Zero books were borrowed!");
        }
        try {
            int numCopiesBorrowed = 0;
            for (Book borrowedBook : borrowedBooksArr) {
                if (borrowedBook.getTitle().equals(b.getTitle())) {
                    numCopiesBorrowed++;
                }
            }
            if (numCopiesToReturn > numCopiesBorrowed) {
                System.out.println("The number of copies to return exceeds the number of copies borrowed.");
                return;
            }
            boolean found = false; // Flag to track if the book has been found
            Book[] newBorrowedBooksArr = new Book[borrowedBooksArr.length - numCopiesToReturn];
            int index = 0;
            // Iterate over borrowedBooksArr to find the book to return
            for (Book borrowedBook : borrowedBooksArr) {
                if (borrowedBook.getTitle().equals(b.getTitle())) {
                    if (!found) {
                        found = true;
                        b.returnBooks(numCopiesToReturn);
                    }
                    // Skip adding the book to the new array if all copies are returned
                    if (numCopiesBorrowed > numCopiesToReturn) {
                        newBorrowedBooksArr[index++] = borrowedBook;
                    }
                    numCopiesBorrowed--;

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

    public void borrowBooks(Book b, int numCopiesToBorrow) {
        if (numCopiesToBorrow <= 0) {
            System.out.println("Invalid number of copies to borrow.");
            return;
        }

        if (b.getNumCopies() >= numCopiesToBorrow) {
            b.borrowBooks(numCopiesToBorrow);
            Book[] newBorrowedBooksArr = new Book[borrowedBooksArr.length + numCopiesToBorrow];
            System.arraycopy(this.borrowedBooksArr, 0, newBorrowedBooksArr, 0, this.borrowedBooksArr.length);
            for (int i = 0; i < numCopiesToBorrow; i++) {
                newBorrowedBooksArr[this.borrowedBooksArr.length + i] = b;
            }
            this.borrowedBooksArr = newBorrowedBooksArr;
            return;
        } else {
            System.out.println("Sorry, insufficient copies available at this time - There are " + b.getNumCopies()
                    + " copies available.");
            return;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Patron Name: ").append(this.fname + " " + this.lname);
        sb.append("\nPhone: ").append(this.phoneNum);
        sb.append("\nAddress: ").append(this.address);
        sb.append("\nBorrowed Book List: ");
        if (borrowedBooksArr.length > 0) {
            for (Book book : borrowedBooksArr) {
                if (book != null) { // Check if the book is not null
                    sb.append("\n   ");
                    sb.append(book.getTitle());
                } else {
                    sb.append("\n   You have no borrowed books!");
                }
            }
        } else {
            sb.append("\n   You have no borrowed books!");
        }
        return sb.toString();
    }

}
