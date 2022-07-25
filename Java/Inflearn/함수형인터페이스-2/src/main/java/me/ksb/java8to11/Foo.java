package src.main.java.me.ksb.java8to11;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Foo {

    public static void main(String[] args) {

        /**
         * 새로운 함수를 정의하지 않아도, 함수형 인터페이스를 사용할 수 있다.
         * 왜냐하면 이미 java가 제공해주는 키워드가 있기 때문이다.
         *
         * Function<T, R>
         *     T 타입을 받아 R 타입을 리턴하는 함수 인터페이스
         *     - R apply(T t)
         *     함수 조합용 메서드
         *     - andThen
         *     - compose
         *
         * BiFunction<T, U, R>
         *     값을 두개 받는다.
         *
         * Consumer<T>
         *     리턴 타입이 없다.
         *     - accept(T t)
         *
         * Supplier<T>
         *     받는 인자가 없음
         *     - T get
         *
         * Predicate<T>
         *     boolean 타입으로 리턴
         *     - test(T t)
         *     함수 조합용 메소드
         *     - And
         *     - Or
         *     - Negate
         *
         * UnaryOperator<T>
         *     리턴과 받는 인자가 같음
         *     Function<Integer, Integer> == UnaryOperator<Integer>
         *
         * BinaryOperator<T>
         *     리턴과 받는 2가지 인자가 모두 같음
         *     Function<Integer, Integer, Integer> == BinaryOperator<Integer>
         *
         */
        Function<Integer, Integer> plus10 = (i) -> i + 10;
        Function<Integer, Integer> multiply2 = (i) -> i * 2;

//        Plus10 plus10 = new Plus10();
//        System.out.println(plus10.apply(1));

        /**
         * High-Order function
         *
         * +10.compose.*2
         *
         * i
         *      1. * 2
         *      2. + 10
         * result
         */
        // (i * 2) + 10
        System.out.println(plus10.compose(multiply2).apply(10));

        Function<Integer, Integer> multiply2AndPlus10 = plus10.compose(multiply2);
        System.out.println(multiply2AndPlus10.apply(10));   // 30

        /**
         * andThen
         *
         * +10.andThen.*2
         * i
         *          1. + 10
         *          2. * 2
         * result
         */
        System.out.println(plus10.andThen(multiply2).apply(10));      // 40


        Consumer<Integer> printT = (i) -> System.out.println(i);
        printT.accept(10);

        Predicate<String> startsWithKeesun = (s) -> s.startsWith("keesun");
        Predicate<Integer> isEven = (i) -> i%2 == 0;
    }
}
