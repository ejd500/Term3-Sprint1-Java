public class LibraryTest {
    public static void main(String[] args) {
        System.out.println();
        System.out.println("First, I initialize the library instance...");
        Library library = new Library();
        System.out.println();
        System.out.println(library);
        System.out.println();

        System.out.println("In order to populate the library, I must first create new Authors.");
        Author a1 = new Author("Janet O'Rielly", "February 12, 1982");
        Author a2 = new Author("Patrick Hann", "April 22, 1950");
        Author a3 = new Author("Harry Dobbin", "June 16, 1967");
        Author a4 = new Author("Suzy Crawley", "September 30, 1977");

        System.out.println();
        System.out.println("The library is still empty at this point until authors or books are added... ");
        System.out.println();
        System.out.println(library);
        System.out.println();

        System.out.println("The authors that were created have written a number of books...");
        Book b1 = new Book("The Running Room", a1, "Books Inc.", 4);
        Book b2 = new Book("Fishing Fun", a2, "Books Inc.", 5);
        Book b3 = new Book("Along Came A Spider", a3, "Random Inc.", 10);
        Book b4 = new Book("The Helping Hand", a2, "Random Inc.", 20);

        System.out.println("    " + b1);
        System.out.println("    " + b2);
        System.out.println("    " + b3);
        System.out.println("    " + b4);
        System.out.println();

        System.out.println("I will then add these books to my library!");
        System.out.println();
        library.addBook(b1);
        library.addBook(b2);
        library.addBook(b3);
        library.addBook(b4);
        System.out.println("As you can see below, the books and authors are now added to the library lists...");
        System.out.println();
        System.out.println(library);

        System.out.println();
        System.out.println("Furthermore, I must create patron accounts so they can borrow and return books...");
        Patron p1 = new Patron("Jenny", "Dwyer", null, "709-453-2637");
        Patron p2 = new Patron("Jack", "Crawford", null, "709-772-5427");
        Patron p3 = new Patron("Kevin", "Mallard", null, "709-229-3378");

        System.out.println("    " + p1);
        System.out.println("    " + p2);
        System.out.println("    " + p3);

        System.out.println();
        System.out.println("These patrons must also be added to the library...");
        library.addPatron(p1);
        library.addPatron(p2);
        library.addPatron(p3);
        System.out.println();
        System.out.println(library);
        System.out.println();

        System.out.println("Now I can demonstrate the many methods of each class... ");
        System.out.println();
        System.out.println("I can find any information about the books, authors, or patrons... (i.e. GET methods)");
        System.out.println();

        System.out.println("Example 1: Book 1...");
        System.out.println();
        System.out.println("Title: " + b1.getTitle());
        System.out.println("Author: " + b1.getAuthor());
        System.out.println("ISBN: " + b1.getISBN());
        System.out.println("Number of copies on hand: " + b1.getNumCopies());
        System.out.println("Publisher: " + b1.getPublisher());

        System.out.println();
        System.out.println("Example 2: Author 1...");
        System.out.println();
        System.out.println("Name: " + a1.getName());
        System.out.println("Date of Birth: " + a1.getDOB());
        System.out.println("Author Book List: \n" + a1.getBooksList());
        System.out.println();

        System.out.println();
        System.out.println("Example 3: Patron 1...");
        System.out.println();
        System.out.println("Name: " + p1.getFname() + " " + p1.getLname());
        System.out.println("Library ID: " + p1.getID());
        System.out.println("Phone Number: " + p1.getPhoneNum());
        System.out.println("Address: " + p1.getAddress());
        System.out.println(p1.getBorrowedBookList());
        System.out.println();

        System.out.println("I can also SET any of the information... ");
        System.out.println();

        System.out.println(
                "To demonstrate this, I have created a new instance of b1, called b5... Now, when I print b5, it is the same as b1... ");
        Book b5 = new Book(b1);
        System.out.println();
        System.out.println("Title: " + b5.getTitle());
        System.out.println("Author: " + b5.getAuthor());
        System.out.println("ISBN: " + b5.getISBN());
        System.out.println("Number of copies on hand: " + b5.getNumCopies());
        System.out.println("Publisher: " + b5.getPublisher());

        System.out.println();
        System.out.println(
                "However, I can now change the values associated with b5 to be something different using SET methods...");

        System.out.println();
        b5.setTitle("Lovin Larry");
        b5.setAuthor(a4);
        b5.setNumCopies(9);
        b5.setPublisher("Rad Reads");
        b5.setISBN(9876);
        System.out.println();
        System.out.println("Title: " + b5.getTitle());
        System.out.println("Author: " + b5.getAuthor());
        System.out.println("ISBN: " + b5.getISBN());
        System.out.println("Number of copies on hand: " + b5.getNumCopies());
        System.out.println("Publisher: " + b5.getPublisher());

        System.out.println();
        System.out.println("This new information needs to now be added to the library... ");
        library.addBook(b5);

        System.out.println();
        System.out.println(
                "As you can see below, the library information is now updated.");
        System.out.println();
        System.out.println(library);
        System.out.println();

        System.out.println("The same can be done for Authors and Patrons...");
        System.out.println();

        System.out.println("SEARCHING BY TITLE...");
        System.out.println();
        String searchResult1 = library.searchByTitle("Rum Ragged");
        System.out.println("Search for Rum Ragged: " + searchResult1);
        String searchResult2 = library.searchByTitle("Fishing Fun");
        System.out.println("Search for Fishing Fun: " + searchResult2);

        System.out.println();
        System.out.println("SEARCHING BY AUTHOR...");
        System.out.println();
        System.out.println("Search for Suzy Crawley: " + library.searchByAuthor(a4));
        System.out.println("Search for Patrick Hann: " + library.searchByAuthor(a2));
        System.out.println("Search for James Cantwell: " + library.searchByAuthor(new Author("James Cantwell", null)));

        System.out.println();
        System.out.println("SEARCHING BY ISBN...");
        System.out.println();
        System.out.println("Search for 4827: " + library.searchByISBN(4827));
        System.out.println("Search for 1238: " + library.searchByISBN(1238));

        System.out.println();
        System.out.println("BORROWING BOOKS...");
        System.out.println();
        System.out.println(
                "Patron 1 (" + p1.getFname() + " " + p1.getLname() + ") will borrow the following book: " + b1);

        library.borrowBooks(b1, p1, 1);
        // library.borrowBooks(b1, p1, 2);
        library.borrowBooks(b1, p1, 4);

        System.out.println();
        System.out.println("GET Patron1 " + p1.getBorrowedBookList());
        System.out.println(b1);

        System.out.println();
        System.out.println(
                "As you can see the patron's borrowed book list has been updated, as well as the number of copies available to borrow.");
        System.out.println();
        System.err.println("Now, another patron cannot borrow that book... UNTIL it is RETURNED...");

        System.out.println();
        library.returnBooks(b1, p1, 2);
        System.out.println();
        System.out.println("GET Patron1 " + p1.getBorrowedBookList());
        // System.out.println(b1);
        System.out.println();
        System.out.println("As you can see, there is only one copy of The Running Room that was borrowed, not two.");
        System.out.println("Therefore, I will return 1 copy...");
        System.out.println();
        library.returnBooks(b1, p1, 1);
        System.out.println();
        System.out.println("GET Patron1 " + p1.getBorrowedBookList());
        System.out.println(b1);
        System.out.println(
                "The patron's borrowed book list was updated when the books were returned, along with the number of copies on hand...");
    }
}
