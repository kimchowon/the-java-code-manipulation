package me.chocho;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE) // 컴파일 시에만 사용하고 바이트 코드에서는 사용 안함.
public @interface Magic {
}
