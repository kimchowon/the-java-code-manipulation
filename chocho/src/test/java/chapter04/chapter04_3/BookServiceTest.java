package chapter04.chapter04_3;

import chapter04.chapter04_1.Book;
import chapter04.chapter04_1.BookService;
import chapter04.chapter04_1.BookServiceImpl;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.InvocationHandlerAdapter;
import org.junit.jupiter.api.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static net.bytebuddy.matcher.ElementMatchers.named;

class BookServiceTest {

    @Test
    public void di_cglib() {
        MethodInterceptor handler = new MethodInterceptor() {
            chapter04.chapter04_3.BookService bookService = new chapter04.chapter04_3.BookService();

            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws InvocationTargetException, IllegalAccessException {

                // 1.실제 서비스만 수행
                // return method.invoke(bookService, objects);

                // 2.실제 서비스 전후에 프록시 로직 수행
                /*System.out.println("Start");
                Object invoke = method.invoke(bookService, objects);
                System.out.println("End");
                return invoke;*/

                // 3.특정 메소드에만 프록시 로직 적용
                if (method.getName().equals("rent")) {
                    System.out.println("Start");
                    Object invoke = method.invoke(bookService, objects);
                    System.out.println("End");
                    return invoke;
                }
                return method.invoke(bookService, objects);
            }
        };

        BookServiceImpl bookService = (BookServiceImpl) Enhancer.create(BookServiceImpl.class, handler);

        Book book = new Book("달러구트 꿈 백화점");
        bookService.rent(book);
        bookService.returnEBook(book);
    }

    @Test
    public void di_bytebuddy() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<? extends chapter04.chapter04_3.BookService> proxyClass = new ByteBuddy()
                .subclass(chapter04.chapter04_3.BookService.class)
                .method(named("rent")).intercept(InvocationHandlerAdapter.of(new InvocationHandler() {

                    chapter04.chapter04_3.BookService bookService = new chapter04.chapter04_3.BookService();
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        return method.invoke(bookService, args);
                    }

                }))
                .make()
                .load(BookService.class.getClassLoader())
                .getLoaded();

        chapter04.chapter04_3.BookService bookService = proxyClass.getConstructor(null).newInstance();

        Book book = new Book("달러구트 꿈 백화점");
        bookService.rent(book);
        bookService.returnEBook(book);
    }
}