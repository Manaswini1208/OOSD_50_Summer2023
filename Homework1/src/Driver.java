import java.util.ArrayList;

public class Driver {
    public static int testAdd() {
        Catalog catalog = new Catalog();
        int numErrors = 0;

        Book book1 = new Book("Introduction to Java", "Kate", "Holdener");
        String book1Id = catalog.add(book1);
        ArrayList<String> foundBooks1 = catalog.search("Kate");

        if (foundBooks1.size() != 1) {
            System.out.println("Error: Should have found one book");
            numErrors++;
        }

        Book book2 = new Book("C++", "James", "Colloum");
        String book2Id = catalog.add(book2);
        ArrayList<String> foundBooks2 = catalog.search("James");

        if (foundBooks2.size() != 1) {
            System.out.println("Error:Found one book");
            numErrors++;
        }

        Book book3 = new Book("Python", "Kate", "Holdener");
        String book3Id = catalog.add(book3);
        ArrayList<String> foundBooks3 = catalog.search("Holdener");

        if (foundBooks3.size() != 2) {
            System.out.println("Error: Found Two books");
            numErrors++;
        }

        return numErrors;
    }

    public static int testCheckoutAndCheckin() {
        Catalog catalog = new Catalog();
        int numErrors = 0;

        Book book1 = new Book("Introduction to Java", "Kate", "Holdener");
        String book1Id = catalog.add(book1);

        // Test checkout
        boolean checkoutStatus = catalog.checkout(book1Id);
        if (!checkoutStatus) {
            System.out.println("Error: Cannot checkout");
            numErrors++;
        }

        // Test checkin
        boolean checkinStatus = catalog.checkin(book1Id);
        if (!checkinStatus) {
            System.out.println("Error: Cannot checkin");
            numErrors++;
        }

        return numErrors;
    }

    public static int testRemove() {
        Catalog catalog = new Catalog();
        int numErrors = 0;

        Book book1 = new Book("Introduction to Java", "Kate", "Holdener");
        String book1Id = catalog.add(book1);

        // Test remove
        boolean removeStatus1 = catalog.remove(book1Id);
        if (!removeStatus1) {
            System.out.println("Error: Remove cannot be performed");
            numErrors++;
        }

        // Try to remove the same book again (should fail)
        boolean removeStatus2 = catalog.remove(book1Id);
        if (removeStatus2) {
            System.out.println("Error: Removing same book again");
            numErrors++;
        }

        return numErrors;
    }

    public static int testGetBook() {
        Catalog catalog = new Catalog();
        int numErrors = 0;

        Book book1 = new Book("Introduction to Java", "Kate", "Holdener");
        String book1Id = catalog.add(book1);

        // Test getBook
        Book foundBook = catalog.getBook(book1Id);
        if (foundBook == null) {
            System.out.println("Error: Book not found");
            numErrors++;
        } else if (!foundBook.getTitle().equals("Introduction to Java")) {
            System.out.println("Error: Incorrect book");
            numErrors++;
        }

        // Try to get a book with invalid id (should return null)
        Book invalidBook = catalog.getBook("8");
        if (invalidBook != null) {
            System.out.println("Error: Null returned");
            numErrors++;
        }

        return numErrors;
    }
    
    
    public static int testSearch() {
        Catalog catalog = new Catalog();
        int numErrors = 0;

        Book book1 = new Book("Introduction to Java", "Kate", "Holdener");
        String book1Id = catalog.add(book1);

        Book book2 = new Book("Python Basics", "John", "Smith");
        String book2Id = catalog.add(book2);

        Book book3 = new Book("C++ Programming", "Alice", "Johnson");
        String book3Id = catalog.add(book3);

        // Search by title
        ArrayList<String> searchByTitle = catalog.search("Kate");
        if (searchByTitle.size() != 1 || !searchByTitle.contains(book1Id)) {
            System.out.println("Error: Book not found by title");
            numErrors++;
        }
        ArrayList<String> searchByAuthorFirstName = catalog.search("Smith");
        if (searchByAuthorFirstName.size() != 1 || !searchByAuthorFirstName.contains(book2Id)) {
            System.out.println("Error: Book NOt found by Author First Name ");
            numErrors++;
        }

        // Search by author last name
        ArrayList<String> searchByAuthorLastName = catalog.search("Alice");
        if (searchByAuthorLastName.size() != 1 || !searchByAuthorLastName.contains(book3Id)) {
            System.out.println("Error: Book NOt found by Author Last Name ");
            numErrors++;
        }
        return numErrors;
    }
    

    public static void main(String[] args) {
        int numErrors = 0;
        numErrors += testAdd();
        numErrors += testCheckoutAndCheckin();
        numErrors += testRemove();
        numErrors += testGetBook();
        numErrors += testSearch();

        if (numErrors > 0) {
            System.out.println("Fix your errors");
        } else {
            System.out.println("No errors were found");
        }
    }
}
