package chapter03.chapter03_1;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException {
        // 클래스 인스턴스를 가져오는 방법
        // 1.클래스 인스턴스의 타입으로 가져오는 방법
        Class<Book> bookClass = Book.class;

        // 2.클래스의 인스턴스로부터 가져오는 방법
        //Book book = new Book();
        //Class<? extends Book> bookClass2 = book.getClass();

        // 3.full qualified class name(FQCN) 밖에 모르는 경우
        //Class<?> bookClass3 = Class.forName("chapter03.chapter03_1.Book");

        System.out.println("\n<<---필드 가져오기--->");
        Field[] fields = bookClass.getFields();

        System.out.println("\n<<---public 접근자인 필드만 출력--->>");
        Arrays.stream(bookClass.getFields()).forEach(System.out::println);

        System.out.println("\n<<---접근 제한자 상관 없이 모든 필드를 출력--->>");
        Arrays.stream(bookClass.getDeclaredFields()).forEach(System.out::println);

        System.out.println("\n<<---필드와 필드에 정의된 값까지 출력--->>");
        Book book = new Book();
        Arrays.stream(bookClass.getDeclaredFields()).forEach(f -> {
            try {
                // 접근 지시자 제한을 무시
                f.setAccessible(true);
                System.out.printf("field = %s / value = %s\n", f, f.get(book));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });

        System.out.println("\n<<---메소드 출력--->>");
        Arrays.stream(bookClass.getMethods()).forEach(System.out::println);

        System.out.println("\n<<---생성자 출력--->>");
       Arrays.stream(bookClass.getConstructors()).forEach(System.out::println);

        System.out.println("\n<<---상위 클래스 출력--->>");
        System.out.println(MyBook.class.getSuperclass());

        System.out.println("\n<<---인터페이스 출력--->>");
        Arrays.stream(MyBook.class.getInterfaces()).forEach(System.out::println);

        System.out.println("\n<<---필드의 접근 제한자 정보 확인--->>");
        Arrays.stream(Book.class.getDeclaredFields()).forEach(f -> {
            int modifier = f.getModifiers();
            System.out.println(f);
            System.out.println(Modifier.isPrivate(modifier));
            System.out.println(Modifier.isStatic(modifier));
        });
    }
}
