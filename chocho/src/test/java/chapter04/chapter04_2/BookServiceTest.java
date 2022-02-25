package chapter04.chapter04_2;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class BookServiceTest {

    EBookService bookService = (EBookService) Proxy.newProxyInstance(EBookService.class.getClassLoader(),
            new Class[]{EBookService.class},
            new InvocationHandler() {
                EBookServiceImpl eBookServiceImpl = new EBookServiceImpl(); // 리얼 서브젝트

                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                    // 1.오로지 리얼 서브젝트 만의 메소드 실행.
                    // 즉, 아무것도 하지 않는 프록시
                    //return method.invoke(eBookServiceImpl, args);

                    // 2.리얼 서브젝트 오퍼레이션 전후로 특정 작업을 실행하는 프록시
                    /*System.out.println("Start");
                    Object invoke = method.invoke(eBookServiceImpl, args);
                    System.out.println("End");
                    return invoke;*/

                    // 3.리얼 서비스의 특정 메소드에만 프록시를 적용
                    if (method.getName().equals("rent")) {
                        System.out.println("Start");
                        Object invoke = method.invoke(eBookServiceImpl, args);
                        System.out.println("End");
                        return invoke;
                    }
                    return method.invoke(eBookServiceImpl, args);
                }
            });

    @Test
    public void proxy_test() {
        EBook eBook = new EBook("달러구트 꿈 백화점");
        bookService.rent(eBook);

        System.out.println();
        bookService.returnEBook(eBook);
    }
}