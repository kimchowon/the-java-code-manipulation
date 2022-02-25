package chapter04.chapter04_2;

/**
 * Real Subject
 */
public class EBookServiceImpl implements EBookService {

    @Override
    public void rent(EBook eBook) {
        System.out.println("rent : " + eBook.getTitle());
    }

    @Override
    public void returnEBook(EBook eBook) {
        System.out.println("return: " + eBook.getTitle());
    }
}
