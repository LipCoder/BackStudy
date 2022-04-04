package Intermediate.Lambda;

public class CompareExam {
    // Compare를 받아들여 인터페이스를 이용
    public static void exec(Compare compare) {
        int k = 10;
        int m = 20;
        int value = compare.compareTo(k, m);
        System.out.println(value);
    }

    public static void main(String[] args) {
        exec((i, j) -> {
            return i - j; // 구현부
        });
    }
}
