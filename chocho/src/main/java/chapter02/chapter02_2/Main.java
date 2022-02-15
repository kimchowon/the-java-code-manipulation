package chapter02.chapter02_2;


import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.FixedValue;

import java.io.File;
import java.io.IOException;

import static net.bytebuddy.matcher.ElementMatchers.named;

public class Main {

    public static void main(String[] args) {

        // 실행 순서 1
        try {
            String path =
                    "/Users/kimchowon/IdeaProjects/Inflearn/the-java-code-manipulation/chocho/target/classes/";

            new ByteBuddy().redefine(Moja.class)
                    .method(named("pullOut")).intercept(FixedValue.value("Rabbit!"))
                    .make().saveIn(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 실행 순서 2
       // System.out.println("MOJA IN " + new Moja().pullOut());
    }
}
