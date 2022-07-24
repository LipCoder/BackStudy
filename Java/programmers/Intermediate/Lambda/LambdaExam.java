package Intermediate.Lambda;

public class LambdaExam {
    public static void main(String[] args) {
        
        // 자바는 메서드만 전달할 수 있는 방법이 없다.
        // 항상 메서드가 포함된 객체를 생성해야 사용할 수 있다.
        // 이러한 단점을 보완하고자 나온 것이 람다식이다.

        // 람다식 == 익명 메서드
        new Thread(/*new Runnable()*/ () -> {
            for(int i = 0; i < 10; i++) {
                System.out.println("hello");
            }   
        }).start();

        // 람다식 문법
        // ( 매개변수 목록 ) -> { 실행문 }
        

    }
}
