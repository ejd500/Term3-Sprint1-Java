/**
 * An interface representing an object that's borrowable.
 */
public interface Borrowable {
    /**
     * A method that allows an object (in this case, a book) to be borrowed.
     * 
     * @param numCopies
     */
    public void borrowBooks(int numCopies);

    /**
     * A method that allows an object (in this case, a book) to be returned.
     * 
     * @param numCopies
     */
    public void returnBooks(int numCopies);
}
