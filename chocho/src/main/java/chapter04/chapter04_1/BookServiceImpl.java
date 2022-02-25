package chapter04.chapter04_1;

/**
 * Real Subject
 */
public class BookServiceImpl implements BookService {

    @Override
    public void rent(Book book) {
        System.out.println("rent : " + book.getTitle());
    }
}
