package Intermediate;

public class MathTest {
    public static void main(String[] args) {
        // Math
        // 연산을 위한 클래스
        
        // 최대값, 최소값 비교
        int value1 = Math.max(5, 30);
        System.out.println(value1);

        int value2 = Math.min(5, 30);
        System.out.println(value2);

        // 절댓값
        int value3 = Math.abs(-12345);
        System.out.println(value3);

        // 랜덤값
        double value4 = Math.random();     // 0 ~ 1.0 랜덤한 실수값을 반환
        System.out.println(value4);

        // 제곱근
        double value5 = Math.sqrt(25);
        System.out.println(value5);
    }
}
