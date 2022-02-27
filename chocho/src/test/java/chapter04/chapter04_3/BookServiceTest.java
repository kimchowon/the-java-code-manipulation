package chapter04.chapter04_3;

import chapter04.chapter04_1.Book;
import chapter04.chapter04_1.BookServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class BookServiceTest {

    @Test
    public void di() {
        MethodInterceptor handler = new MethodInterceptor() {
            BookServiceImpl bookService = new BookServiceImpl();

            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws InvocationTargetException, IllegalAccessException {

                return method.invoke(bookService, objects);
            }
        };

        BookServiceImpl bookService = (BookServiceImpl) Enhancer.create(BookServiceImpl.class, handler);

        Book book = new Book("달러구트 꿈 백화점");
        bookService.rent(book);
        bookService.returnEBook(book);
    }
}