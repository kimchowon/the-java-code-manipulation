package me.chocho;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.TypeElement;
import java.util.Set;

/**
 * @Magic 어노테이션이 붙어있는 클래스를 처리하여 새로운 클래스를 만들 수 있는 프로세서
 */
public class MagicMojaProcessor extends AbstractProcessor {
    
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        return false;
    }
}
