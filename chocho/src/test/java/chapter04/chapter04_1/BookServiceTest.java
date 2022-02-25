package chapter04.chapter04_1;

import org.junit.jupiter.api.Test;

class BookServiceTest {

    BookService bookService = new BookServiceProxy(new BookServiceImpl());

    @Test
    public void proxy_test() {
        Book book = new Book("달러구트 꿈 백화점");
        bookService.rent(book);
    }
}