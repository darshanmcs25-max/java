class Book {
       private int bookId;
    private String title;
    private String author;
    private double price;
    
        private static int totalBooksCount = 0;

        public Book(int bookId, String title, String author, double price) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.price = price;
                totalBooksCount++;
    }

    
    public void displayInfo() {
        System.out.println("Book ID : " + bookId);
        System.out.println("Title : " + title);
        System.out.println("Author : " + author);
        System.out.println("Price : $" + price);
        System.out.println("-----------------------------");
    }

  
    public boolean search(int searchId) {
        return this.bookId == searchId;
    }

    
    public boolean search(String searchTitle) {
        return this.title.equalsIgnoreCase(searchTitle);
    }

        public Book getCostlierBook(Book otherBook) {
        if (this.price >= otherBook.price) {
            return this;
        } else {
            return otherBook;
        }
    }

   
    public static int getTotalBooksCount() {
        return totalBooksCount;
    }

        public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }
}

public class Main {
    public static void main(String[] args) {
               Book book1 = new Book(101, "Effective Java", "Joshua Bloch", 45.50);
        Book book2 = new Book(102, "Clean Code", "Robert C. Martin", 39.99);
        Book book3 = new Book(103, "Head First Java", "Kathy Sierra", 42.00);

                System.out.println("--- Displaying All Books ---");
        book1.displayInfo();
        book2.displayInfo();
        book3.displayInfo();

                System.out.println("Total Books Created: " + Book.getTotalBooksCount());
        System.out.println("-----------------------------\n");

       
        int targetId = 102;
        System.out.println("Searching for Book ID " + targetId + " in book2...");
        if (book2.search(targetId)) {
            System.out.println("Match Found! The book title is: " + book2.getTitle());
        } else {
            System.out.println("No Match Found.");
        }
        System.out.println("-----------------------------\n");

        
        String targetTitle = "effective java";
        System.out.println("Searching for Title '" + targetTitle + "' in book1...");
        if (book1.search(targetTitle)) {
            System.out.println("Match Found! The Book ID is matching.");
        } else {
            System.out.println("No Match Found.");
        }
        System.out.println("-----------------------------\n");

                System.out.println("Comparing prices of '" + book1.getTitle() + "' and '" + book2.getTitle() + "'...");
        Book costlier = book1.getCostlierBook(book2);
        System.out.println("The costlier book is: '" + costlier.getTitle() + "' ($" + costlier.getPrice() + ")");
        System.out.println("-----------------------------");
    }
}