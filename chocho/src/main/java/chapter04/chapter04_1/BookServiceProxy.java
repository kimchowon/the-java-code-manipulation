package chapter04.chapter04_1;

public class BookServiceProxy implements BookService {

    BookService bookService; // 리얼 서브젝트를 참조

    public BookServiceProxy(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public void rent(Book book) {
        System.out.println("Start");
        bookService.rent(book);
        System.out.println("End");
    }

    @Override
    public void returnEBook(Book book) {
        System.out.println("return: " + book.getTitle());
    }
}
