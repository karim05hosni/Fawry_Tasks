package org.Fawry.BookStore;
import java.util.HashMap;
import java.util.LinkedList;


public class Inventory {
    private HashMap<Book, Integer> books;

    public Inventory() {
        this.books = new HashMap<>();
    }

    public void add(Book book, int quantity) {
        books.put(book, quantity);
    }
    public LinkedList<Book> remove(int expire_year) {
        LinkedList<Book> removedBooks = new LinkedList<>(); 
        for (Book book : books.keySet()) {
            if (book.getPublishYear() < expire_year) {
                books.remove(book);
                removedBooks.add(book);
            }
        }
        return removedBooks;
    }
    public Book getBook(String ISBN) {
        for (Book book : books.keySet()) {
            if (book.getISBN().equals(ISBN)) {
                return book;
            }
        }
        return null;
    }
    public void reduceStock(Book book, int quantity){
        int q = books.get(book);
        books.put(book, q - quantity);
    }
}
