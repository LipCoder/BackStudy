package Intermediate.Thread;

public class ThreadExam2 {
    
    public static void main(String[] args) {
        MyThread2 t1 = new MyThread2("*");
        MyThread2 t2 = new MyThread2("-");

        // Runnable은 start() 메서드가 없음
        // 그래서 Thread 객체를 만들어줘야함
        Thread thread1 = new Thread(t1);
        Thread thread2 = new Thread(t2);

        thread1.start();
        thread2.start();

        System.out.println("main end!!!!!");
    }
}
