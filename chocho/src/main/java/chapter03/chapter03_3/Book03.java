package chapter03.chapter03_3;

public class Book03 {

    public static String A = "A";

    private String B = "B";

    public Book03() {
    }

    public Book03(String b) {
        B = b;
    }

    private void C() {
        System.out.println("C");
    }

    public int D(int left, int right) {
        return left + right;
    }
}
