
package org.Fawry.BookStore.Books;
import org.Fawry.BookStore.Book;
public class DemoBook extends Book {

    public DemoBook(String ISBN, String title, int publish_year, double price) {
        super(ISBN, title, publish_year, price);
    }

    @Override
    public double buy(String ISBN, int quantity, String email, String address) {
        throw new Error("Demo books cannot be purchased");
    }
    
}
