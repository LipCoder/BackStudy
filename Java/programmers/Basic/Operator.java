package Basic;

// 연산자 우선순위
public class Operator {
    public static void main(String[] args) {
        int a = 5;
        int b = 10;
        int c = 15;

        System.out.println((a - b) * c);

        System.out.println(a > 5 && b > 5);
        System.out.println(a > 5 || b > 5);

        System.out.println(++a - 5);
    }
}
