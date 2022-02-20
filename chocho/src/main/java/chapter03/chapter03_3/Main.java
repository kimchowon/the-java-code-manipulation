package chapter03.chapter03_3;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 리플렉션 API: 클래스 정보 수정 또는 실행
 */
public class Main {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchFieldException {

        Class<Book03> book03Class = Book03.class;

        System.out.println("\n<<---리플렉션을 이용하여 객체 생성하기--->>");
        System.out.println("<<---1.파라미터 없는 생성자 호출--->>");
        // 1)생성자 호출
        Constructor<Book03> constructor1 = book03Class.getConstructor(null);
        // 2)생성자로부터 객체 생성
        Book03 book1 = constructor1.newInstance();
        System.out.println(book1);

        System.out.println("\n<<---2.파라미터 있는 생성자 호출--->>");
        // 1)생성자 호출
        Constructor<Book03> constructor2 = book03Class.getConstructor(String.class);
        // 2)생성자로부터 객체 생성
        Book03 book2 = constructor2.newInstance("달러구트 꿈 백화점");
        System.out.println(book2);

        System.out.println("\n<<---필드 값 접근하기--->>");
        Field a1 = Book03.class.getDeclaredField("A");
        Object o = a1.get(null);// static 피드이기 때문에 특정 객체를 넣어줄 필요가 없다.
        System.out.println(o);

        System.out.println("\n<<---필드 값 설정하기--->>");
        Field a2 = Book03.class.getDeclaredField("A");
        a2.set(null, "AAAAA");
        System.out.println(a2.get(null));

        System.out.println("\n<<---메소드 실행하기--->>");
        System.out.println("\n<<---1.파라미터 없는 메소드--->>");
        Method c = Book03.class.getDeclaredMethod("C");
        c.setAccessible(true); // private인 경우 접근 허용
        c.invoke(book1);

        System.out.println("\n<<---2.파라미터 있는 메소드--->>");
        Method d = Book03.class.getDeclaredMethod("D", int.class, int.class);
        int sum = (int) d.invoke(book1, 4, 5);
        System.out.println(sum);
    }
}
