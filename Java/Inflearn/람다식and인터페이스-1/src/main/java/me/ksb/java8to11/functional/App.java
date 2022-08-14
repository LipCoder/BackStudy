package src.main.java.me.ksb.java8to11.functional;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class App {
    public static void main(String[] args) {
        // 기존
        Function<Integer, String> intToString = (i) -> "number";

        /**
         * 메소드 레퍼런스
         * (::)
         */
        UnaryOperator<String> hi = Greeting::hi;

        Greeting greeting = new Greeting();
        UnaryOperator<String> hello = greeting::hello;
        System.out.println(hello.apply("seoung boem"));

        Supplier<Greeting> newGreeting = Greeting::new;     // 기본 생성자 호출
        Greeting newInst = newGreeting.get();

        // 입력값을 받는 경우
        Function<String, Greeting> seoungBoemGreeting       // 문자열 설정 생성자 호출
                = Greeting::new;
        Greeting seoungBoem = seoungBoemGreeting.apply("seoungBoem");
        System.out.println(seoungBoem.getName());


        String[] names = {"keesun", "whiteship", "toby"};
//        Arrays.sort(names, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return 0;
//            }
//        });

        // Comparator는 함수형 인터페이스로 람다로 대체 가능하다.
//        Arrays.sort(names, (o1, o2) -> 0);
        /**
         * 메소드 레퍼런스를 사용할 수도 있다.
         * compareToIgnoreCase(other) {
         *      // this와 other를 비교한다.
         * }
         */
        Arrays.sort(names, String::compareToIgnoreCase);
        System.out.println(Arrays.toString(names));

    }
}
