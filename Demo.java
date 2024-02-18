public class Demo {
    public static void main(String[] args) {
        Author a1 = new Author("Ellen Dalton", "April 24, 1990");
        // System.out.println(a1);

        Book b1 = new Book("Title1", a1, "1234", "Books Inc.", 4);
        Book b2 = new Book("Title2", a1, "2435", "Books Inc.", 2);

        // System.out.println(a1);
        // System.out.println(b1);

        Patron p = new Patron("Elizabeth", "Connors", null, "17097462252");

        // System.out.println();
        // System.out.println(p);

        // p.borrowBook(b2, 1);

        // System.out.println(b2);

        // p.borrowBooks(b2, 0);
        p.borrowBooks(b2, 2);
        p.returnBooks(b2, 2);

        // p.returnBooks(b2, 1);
        // p.borrowBooks(b2, 2);
        // p.returnBooks(b2, 2);
        // p.returnBooks(b2, 1);
        // p.returnBook(b2);
        // p.returnBook(b2);
        // p.returnBook(b2);
        // System.out.println(b2.getNumCopies());
        // p.borrowBook(b2);
        // p.borrowBook(b2);
        System.out.println(p);
        // System.out.println(p.getPhoneNum());
        // System.out.println(p);
        // p.setBorrowedBooksList(null, null, null, null);
        // System.out.println(p);

        // p.returnBook(b2, 1);

        // System.out.println(b2);
        // System.out.println(b2.getNumCopies());
        // System.out.println(p);

        // p.borrowBook(b2, 1);
        // System.out.println(b2.getNumCopies());
        // p.borrowBook(b2, 1);
        // p.returnBook(b2, 2);
        // System.out.println(b2);

        // a1.addBookToAuthor(b1);
        // a1.addBookToAuthor(b2);

    }
}
