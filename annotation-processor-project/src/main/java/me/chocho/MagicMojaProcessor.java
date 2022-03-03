package me.chocho;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import java.util.Set;

/**
 * @Magic 어노테이션이 붙어있는 클래스를 처리하여 새로운 클래스를 만들 수 있는 프로세서
 */
public class MagicMojaProcessor extends AbstractProcessor {

    /**
     * 어떤 어노테이션을 처리할 것인지 정의
     *
     * @return
     */
    @Override
    public Set<String> getSupportedAnnotationTypes() {
        return Set.of(Magic.class.getName());
    }

    /**
     * 해당 프로세서를 통해 생성되는 소스 코드의 버전
     *
     * @return
     */
    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }

    /**
     * 어노테이션을 처리
     *
     * @param annotations
     * @param roundEnv
     * @return
     */
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {

        // Magic 어노테이션을 가지고 있는 엘리먼트들을 모두 조회
        Set<? extends Element> elements = roundEnv.getElementsAnnotatedWith(Magic.class);

        for (Element element : elements) {

            // 어노테이션이 인터페이스에 붙어 있으면
            if (element.getKind() == ElementKind.INTERFACE) {

            } else {
                processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR,
                        "Magic annotation can not be used on " + element.getSimpleName());
            }
        }

        return true;
    }
}
