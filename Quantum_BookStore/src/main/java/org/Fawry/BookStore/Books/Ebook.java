// package BookStore.Books;
package org.Fawry.BookStore.Books;
import org.Fawry.BookStore.Book;
import org.Fawry.BookStore.Inventory;
import org.Fawry.BookStore.Services.MailService;

public class Ebook extends Book {

    public Ebook(String ISBN, String title, int publish_year, double price) {
        super(ISBN, title, publish_year, price);
    }
    @Override
    public double buy(String ISBN, int quantity, String email, String address) {
        Inventory inventory = new Inventory();
        Book book = inventory.getBook(ISBN);
        if (book == null) {
            throw new Error("your book not found");
        }
        inventory.reduceStock(book, quantity);
        MailService MailService = new MailService();
        MailService.sendEmail(email);
        return book.getPrice() * quantity;
    }
}
