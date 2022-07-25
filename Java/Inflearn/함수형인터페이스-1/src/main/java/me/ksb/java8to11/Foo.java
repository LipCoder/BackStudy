package src.main.java.me.ksb.java8to11;

public class Foo {

    public static void main(String[] args) {
        // 익명 내부 클래스 (anonymous inner class)
//        RunSomething runSomething = new RunSomething() {
//            @Override
//            public void doIt() {
//                System.out.println("Hello");
//            }
//        };

        final int baseNumber = 10;
        // 람다 표현식
        RunSomething runSomething = (number) -> {
            // 외부 변수는 참조만 가능하기 때문에, Read Only이다.
            // final
            return number + baseNumber;
        };

        /**
         * # 함수형 프로그래밍을 할때 주의할 점
         *
         *      함수를 First class object로 사용할 수 있다.
         *      (함수처럼 생긴 Object)
         *      --> 이미 함수 자체가 최상위 클래스로 Object를 가진다.
         *
         *      순수 함수 (Pure function)**
         *      --> 함수 바깥의 값을 변경할 수 없음
         *
         *      고차 함수 (High-Order function)
         *      --> 함수가 함수를 매개변수로 받을 수 있고 함수를 리턴할 수도 있다.
         *
         *      불변성
         */

        System.out.println(runSomething.doIt(1));
        System.out.println(runSomething.doIt(1));
        System.out.println(runSomething.doIt(1));

        System.out.println(runSomething.doIt(2));
        System.out.println(runSomething.doIt(2));
        System.out.println(runSomething.doIt(2));

    }
}
