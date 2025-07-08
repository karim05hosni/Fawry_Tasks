package org.Fawry.BookStore;

public class Book {
    private String ISBN;
    private String title;
    private int publish_year;
    private double price; 
    

    public Book(String ISBN, String title, int publish_year, double price) {
        this.ISBN = ISBN;
        this.title = title;
        this.publish_year = publish_year;
        this.price = price;
    }

    public int getPublishYear() {
        return publish_year;
    }

    public String getISBN() {
        return ISBN;
    }
    public double getPrice(){
        return price;
    }

    public double buy(String ISBN, int quantity, String email, String address) {
        Inventory inventory = new Inventory();
        Book book = inventory.getBook(ISBN);
        if (book == null) {
            throw new Error("your book not found");
        }
        inventory.reduceStock(book, quantity);
        return price * quantity;
    }
}
