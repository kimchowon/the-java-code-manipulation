package me.chocho;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE) // Interface, Class, Enum 에 사용 가능
@Retention(RetentionPolicy.SOURCE) // 컴파일 시에만 사용하고 바이트 코드에서는 사용 안함.
public @interface Magic {
}
