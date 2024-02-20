import java.util.ArrayList;
import java.util.List;

public class Patron {
    private static int lastId = 0;
    private int id = 0;
    private String fname;
    private String lname;
    private Address address;
    private String phoneNum;
    private List<Book> borrowedBookList;
    // private Book[] borrowedBooksArr;

    public Patron(String fname, String lname, Address address, String phoneNum) {
        this.id = ++lastId;
        this.fname = fname;
        this.lname = lname;
        this.address = address;
        this.phoneNum = phoneNum;
        this.borrowedBookList = new ArrayList<>();
    }

    public int getID() {
        return this.id;
    }

    public void setID(int id) {
        this.id = id;
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

    public String getBorrowedBookList() {
        StringBuilder sb = new StringBuilder();
        sb.append("Borrowed Book List: ");
        if (borrowedBookList.size() > 0) {
            for (Book book : borrowedBookList) {
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

    public void setBorrowedBookList(Book b1, Book b2, Book b3, Book b4) {
        if (b1 == null) {
            for (Book book : borrowedBookList) {
                borrowedBookList.remove(book);
            }
            System.out.println("Your borrowed books list is now empty!");
        } else {
            for (Book book : borrowedBookList) {
                borrowedBookList.remove(book);
            }
            borrowedBookList.add(b1);
        }
        if (b2 != null) {
            borrowedBookList.add(b2);
        }
        if (b3 != null) {
            borrowedBookList.add(b3);
        }
        if (b4 != null) {
            borrowedBookList.add(b4);
        }
        System.out.println("Your borrowed books list has now been reset!");
    }

    public void returnBooks(Book b, int numCopiesToReturn) {

        // If borrowed books list is empty, you cannot return the book.
        if (borrowedBookList.isEmpty()) {
            System.out.println("Can't return book... Zero books were borrowed!");
            return;
        }

        // Iterate through the borrowed book list to find the number of copies borrowed.
        int numCopiesBorrowed = 0;
        for (Book borrowedBook : borrowedBookList) {
            if (borrowedBook.getTitle().equals(b.getTitle())) {
                numCopiesBorrowed = numCopiesBorrowed + 1;
            }
        }

        // If borrowed book list contains the book you want to return and the
        // number of copies borrowed is greater than or equal to the number you want to
        // return,
        // then RETURN BOOKS and remove it from the borrowed book list...
        // Print a message to show success... and if number of copies borrowed
        // is greater than the number being returneda then print a message
        // indicating how many copies you have left to return.
        if (borrowedBookList.contains(b) && numCopiesBorrowed >= numCopiesToReturn) {
            if (numCopiesToReturn == 1) {
                borrowedBookList.remove(b); // Remove the book from the list
                b.returnBooks(numCopiesToReturn);
                System.out.println("Thank you for returning " + numCopiesToReturn + " copies of " + b.getTitle());
                if (numCopiesBorrowed > numCopiesToReturn) {
                    System.out.println("You still have to return " + (numCopiesBorrowed - numCopiesToReturn)
                            + " copies of this book!");
                }
            }
            if (numCopiesToReturn == 2) {
                borrowedBookList.remove(b); // Remove the book from the list
                borrowedBookList.remove(b); // Remove the book from the list
                b.returnBooks(numCopiesToReturn);
                System.out.println("Thank you for returning " + numCopiesToReturn + " copies of " + b.getTitle());
                if (numCopiesBorrowed > numCopiesToReturn) {
                    System.out.println("You still have to return " + (numCopiesBorrowed - numCopiesToReturn)
                            + " copies of this book!");
                }
            }
            if (numCopiesToReturn == 3) {
                borrowedBookList.remove(b); // Remove the book from the list
                borrowedBookList.remove(b); // Remove the book from the list
                borrowedBookList.remove(b); // Remove the book from the list
                b.returnBooks(numCopiesToReturn);
                System.out.println("Thank you for returning " + numCopiesToReturn + " copies of " + b.getTitle());
                if (numCopiesBorrowed > numCopiesToReturn) {
                    System.out.println("You still have to return " + (numCopiesBorrowed - numCopiesToReturn)
                            + " copies of this book!");
                }
            }
            if (numCopiesToReturn > 3) {
                System.out.println("Sorry, you cannot borrow/return more than 3 copies of a book.");
                return;
            }
        } else {
            System.out.println("Sorry, you can only return borrowed books.");
            return;
        }
    }

    public void borrowBooks(Book b, int numCopiesToBorrow) {
        if (numCopiesToBorrow <= 0) {
            System.out.println("Invalid number of copies to borrow.");
            return;
        }

        if (b.getNumCopies() >= numCopiesToBorrow) {
            if (numCopiesToBorrow == 1) {
                b.borrowBooks(numCopiesToBorrow);
                System.out.println(numCopiesToBorrow + " copies of " + b.getTitle() + " were borrowed!");
                borrowedBookList.add(b);
            }
            if (numCopiesToBorrow == 2) {
                b.borrowBooks(numCopiesToBorrow);
                System.out.println(numCopiesToBorrow + " copies of " + b.getTitle() + " were borrowed!");
                borrowedBookList.add(b);
                borrowedBookList.add(b);
            }
            if (numCopiesToBorrow == 3) {
                b.borrowBooks(numCopiesToBorrow);
                System.out.println(numCopiesToBorrow + " copies of " + b.getTitle() + " were borrowed!");
                borrowedBookList.add(b);
                borrowedBookList.add(b);
                borrowedBookList.add(b);
            }
            if (numCopiesToBorrow > 3) {
                System.out.println("Sorry, you are only allowed to borrow 3 copies of the same book.");
            }
        } else {
            System.out.println("Sorry, insufficient copies available at this time - There are " + b.getNumCopies()
                    + " copies available.");
            return;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.fname + " " + this.lname + " (Library ID: " + this.id + ")");
        // sb.append("\nPhone: ").append(this.phoneNum);
        // sb.append("\nAddress: ").append(this.address);
        // sb.append("\nBorrowed Book List: ");
        // if (borrowedBooksArr.length > 0) {
        // for (Book book : borrowedBooksArr) {
        // if (book != null) { // Check if the book is not null
        // sb.append("\n ");
        // sb.append(book.getTitle());
        // } else {
        // sb.append("\n You have no borrowed books!");
        // }
        // }
        // } else {
        // sb.append("\n You have no borrowed books!");
        // }
        return sb.toString();
    }

}
