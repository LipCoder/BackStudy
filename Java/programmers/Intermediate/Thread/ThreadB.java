package Intermediate.Thread;

public class ThreadB extends Thread {
    int total;

    public void run() {
        synchronized (this) {
            for(int i = 0; i < 5; i++) {
                System.out.println(i + "를 더합니다.");
                total += i;

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            // notify를 하면 현재 스레드를 기다리는(wait())
            // 스레드의 대기가 풀린다.
            notify();
        }
    }
}