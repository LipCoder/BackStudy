package src.main.java.me.ksb.java8to11.functional;

import java.util.function.*;

public class Lambda {

    public static void main(String[] args) {
        Supplier<Integer> get10 = () -> 10;

        BinaryOperator<Integer> sum = (a, b) -> a + b;

        /**
         * 변수 캡처
         */
        Lambda lambda = new Lambda();
        lambda.run();
    }

    private void run() {
        /**
         * 변수 캡처
         * 메소드 내부에 정의한 변수 및 메서드
         */
        int baseNumber = 10;

        // 로컬 클래스
        // 쉐도잉이 일어남 --> 별도의 Scope로 인해 기존 값을 가린다.
        class LocalClass {
            void printBaseNumber() {
                int baseNumber = 11;
                System.out.println(baseNumber); // 11
            }
        }

        // 익명 클래스
        // 쉐도잉이 일어남 --> 별도의 Scope로 인해 기존 값을 가린다.
        Consumer<Integer> integerConsumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer baseNumber) {
                System.out.println(baseNumber); // parameter의 baseNumber이다.
            }
        };
    
        // 람다
        // 쉐도잉이 일어나지 않음 --> 이미 같은 Scope으로 같은 변수명을 사용할 수 없다.
        IntConsumer printInt = (i) -> {
            System.out.println(i + baseNumber);
        };

        printInt.accept(10);

        // final 처럼 쓰고 있는데 변수를 변경할 수 없다.
//        baseNumber++;
    }
}
