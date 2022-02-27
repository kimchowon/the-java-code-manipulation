package chapter04.chapter04_3;

import chapter04.chapter04_1.Book;

public class BookService {

    public void rent(Book book) {
        System.out.println("rent : " + book.getTitle());
    }

    public void returnEBook(Book book) {
        System.out.println("return : " + book.getTitle());
    }
}
