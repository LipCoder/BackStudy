package Intermediate.Thread;

public class TheadExam {
    public static void main(String[] args) {
        MyThread1 t1 = new MyThread1("*");
        MyThread1 t2 = new MyThread1("-");
        
        // start를 호출하지 않으면 thread는 동작하지 않는다.
        t1.start(); 
        t2.start();

        // 수행 흐름
        // main 
        //  |
        //  |
        //  |     t1
        //  |      |     t2
        //  |      |     |
        //  |      |     |

        System.out.println("main end !!!");
    }
    
}
