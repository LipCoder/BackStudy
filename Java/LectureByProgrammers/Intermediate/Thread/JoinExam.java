package Intermediate.Thread;

public class JoinExam {
    public static void main(String[] args) {
        MyThread5 thread = new MyThread5();
        thread.start();

        System.out.println("시작");

        // join : 해당 스레드가 모두 끝날때까지 기다린다.
        try {
            thread.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("종료!");
    }
    
}
