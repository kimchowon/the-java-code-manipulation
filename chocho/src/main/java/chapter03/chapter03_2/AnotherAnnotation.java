package chapter03.chapter03_2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
@Inherited
public @interface AnotherAnnotation {

    // default가 없으면 어노테이션 선언시 직접 값을 매번 입력해야함. 안 주면 에러
    String name() default "chovly";

    int age() default 30;

    // 값을 하나만 받을 때 유용
    String value() default "princess bubblegum";
}
