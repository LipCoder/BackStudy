package Intermediate.Thread;

public class ThreadA {
    public static void main(String[] args) {
        ThreadB b = new ThreadB();
        b.start();

        synchronized (b) {
            try {
                System.out.println("b가 완료될때까지 기다립니다.");
                // 기다리면 ThreadB 에서 notify()를 수행할때까지 
                // main스레드는 대기한다. 
                b.wait();                
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Total is : " + b.total);
        }
    }
}
