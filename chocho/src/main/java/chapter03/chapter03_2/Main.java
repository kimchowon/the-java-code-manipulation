package chapter03.chapter03_2;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        System.out.println("\n---<<클래스 위에 붙은 어노테이션 조회>>---");
        Arrays.stream(Book.class.getAnnotations()).forEach(System.out::println);

        System.out.println("\n---<<클래스 위에 붙은 어노테이션 조회>>---");
        Arrays.stream(MyBook.class.getAnnotations()).forEach(System.out::println);

        System.out.println("\n---<<부모 클래스 제외하고 자기 자신에게만 붙은 어노테이션 조회>>---");
        Arrays.stream(MyBook.class.getDeclaredAnnotations()).forEach(System.out::println);

        System.out.println("\n---<<필드에 붙어 있는 어노테이션들을 모두 조회>>---");
        Arrays.stream(Book.class.getDeclaredFields()).forEach(f -> {
            Arrays.stream(f.getAnnotations()).forEach(System.out::println);
        });

        System.out.println("\n---<<어노테이션 정보들을 꺼내기>>---");
        Arrays.stream(Book.class.getDeclaredFields()).forEach(f -> {
            Arrays.stream(f.getAnnotations()).forEach(a -> {
                if (a instanceof MyAnnotation) { // 특정 어노테이션만 정보를 출력
                    MyAnnotation myAnnotation = (MyAnnotation) a;
                    System.out.println("name = " + myAnnotation.name());
                    System.out.println("age = " + myAnnotation.age());
                }
            });
        });
    }
}
