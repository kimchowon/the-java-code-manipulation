package me.chocho;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;
import java.util.Set;

/**
 * @Magic 어노테이션이 붙어있는 클래스를 처리하여 새로운 클래스를 만들 수 있는 프로세서
 */
public class MagicMojaProcessor extends AbstractProcessor {

    /**
     * 어떤 어노테이션을 처리할 것인지 정의
     * @return
     */
    @Override
    public Set<String> getSupportedAnnotationTypes() {
        return Set.of(Magic.class.getName());
    }

    /**
     * 해당 프로세서를 통해 생성되는 소스 코드의 버전
     * @return
     */
    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }

    /**
     * 어노테이션을 처리
     * @param annotations
     * @param roundEnv
     * @return
     */
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        return false;
    }
}
