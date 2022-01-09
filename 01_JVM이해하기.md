# 1.자바, JVM, JDK, JRE

자바가 뭔지, JVM/JDK/JRE가 각각 뭔지 이해해보자. 

<img src="https://user-images.githubusercontent.com/52793122/148692157-cb9e5576-6d9c-4241-8595-c0e27ed85084.png"  width="600" height="300"/>


## JVM(Java Virtual Machine)

- 자바 가상 머신으로 자바 바이트 코드를(.class) OS에 특화된 코드로 변환하여 실행해준다.
    - 자바 바이트 코드: 자바 가상 머신이 이해할 수 있는 언어로 변환된 자바 소스 코드
    - 자바 바이트 코드 보는 방법
        
        1.자바 파일 생성
        
        ```bash
        $vi HelloJava.java
        
        public class HelloJava{
                public static  void main(String[] args) {
                        System.out.println("Hello Java");
                }
        }
        ```
        
        2.자바 컴파일
        - 자바 가상 머신 사양을 충족하는 바이트 코드(.class) 생성
        
        ```bash
        $javac HelloJava.java
        
        $ls
        HelloJava.class	HelloJava.java
        ```
        
        3.바이트 코드 확인
        
        class 파일은 바이너리 파일이라서 사람이 이해하기 쉽지 않다. 
        
        - javap : 바이너리 코드를 어셈블리 코드로 변환
        - -c 옵션: 바이트 코드를 출력
        
        ```bash
        $javap -c HelloJava
        
        Compiled from "HelloJava.java"
        public class HelloJava {
          public HelloJava();
            Code:
               0: aload_0
               1: invokespecial #1                  // Method java/lang/Object."<init>":()V
               4: return
        
          public static void main(java.lang.String[]);
            Code:
               0: getstatic     #7                  // Field java/lang/System.out:Ljava/io/PrintStream;
               3: ldc           #13                 // String Hello Java
               5: invokevirtual #15                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
               8: return
        }
        ```
        
    - 자바 파일 → 자바 바이트 코드 → OS에 특화된 코드
    - 자바 바이트 코드를 JVM의 인터프리터, JIT 컴파일러 등이 실행하여 OS에 맞는 머신코드(머신이 이해할 수 있는 코드)로 변경한다.
- 바이트 코드를 실행하는 표준이자 구현체이다.
    - 구현체는 어떤 회사가 만드냐에 따라 다양하다.
    - JVM 벤더들: 오라클, 아마존, Azul ..
- 특정 플랫폼에 종속적이다.
    - 자바 코드를 네이티브 코드로 바꿔서 실행해야 하는데 이 네이티브 코드가 OS에 맞춰서 실행되어야 하기 때문에

# JRE(Java Runtime Environment)

- JVM + 라이브러리
- 자바 애플리케이션을 실행할 수 있도록 구성된 배포판
    - JVM은 홀로 제공되지 않는다. 최소한의 배포 단위가 JRE이다.
- JVM과 핵심 라이브러리 및 자바 런타임 환경에서 사용하는 프로퍼티 세팅이나 리소스 파일을 가지고 있다.
- 개발 관련 도구는 포함하지 않는다.
    - javac 등은 JDK에서 제공

# JDK(Java Development Kit)

- JRE + 개발에 필요한 툴
- 소스 코드를 작성할 때 자바 언어는 플랫폼에 독립적
- 오라클은 자바 11부터는 JDK만 제공하며 JRE를 따로 제공하지 않는다.

# 자바

- 프로그래밍 언어
- JDK에 들어있는 자바 컴파일러(javac)를 사용하여 바이트 코드(.class)로 컴파일 할 수 있다.
- 오라클에서 만든 Oracle JDK 11 버전부터 상용으로 사용할 때는 자바 유료화이다.
    - 그 외 다른 벤더에서 만들었거나 버전이 다르다면 모두 아직까지는 무료이다.

# JVM 언어

- JVM 기반으로 동작하는 프로그래밍 언어
    - 최초의 JVM은 원래 자바 언어만을 지원하기 위해 만들어졌는데, 사실상 자바 언어와 직접적인 연관 관계가 있는게 아니라 중간에 (.class)파일만 있으면 실행이 가능하다. 때문에 자바 언어와 의존성이 타이트하지 않다.
    - 즉, 어떤 다른 프로그래밍 언어로 코딩을 하더라도 컴파일 햇을 때 클래스 파일이나 자바 파일을 만들어 주기만 하면 JVM을 사용하여 애플리케이션을 실행할 수가 있다.
- 클로저, 그루비, JRuby, Jython, Kotlin, Scala ...