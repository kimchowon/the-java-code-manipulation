package org.example;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class ContainerService {

    public static <T> T getObject(Class<T> classType) {
        // 1.인스턴스 생성
        T instance = createInstance(classType);

        // 2.인스턴스의 필드들 조회
        Arrays.stream(classType.getDeclaredFields()).forEach(f -> {

            // 3.필드에 붙어있는 @Inject 어노테이션을 조회
            Inject annotation = f.getAnnotation(Inject.class);

            // 4.Inject 어노테이션이 붙어있다면
            if (annotation != null) {
                Class<?> type = f.getType();

                // 5.필드의 클래스 타입으로 인스턴스 생성
                Object fieldInstance = createInstance(type);
                f.setAccessible(true);
                try {
                    // 필드에 생성한 인스턴스를 주입.
                    f.set(instance, fieldInstance);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        return instance;
    }

    public static <T> T createInstance(Class<T> classType) {

        try {
            // 해당 타입인 클래스의 디폴트 생성자로 인스턴스 생성
            return classType.getConstructor(null).newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
