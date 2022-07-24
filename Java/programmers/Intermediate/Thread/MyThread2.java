package Intermediate.Thread;

public class MyThread2 implements Runnable {
    
    String str;
    public MyThread2(String str) {
        this.str = str;
    }

    // java는 단일 상속만 지원한다.
    // 다른 클래스를 상속받고 있다면 Runnable을 사용한다.
    @Override
    public void run() {
        for(int i = 0; i < 10; i++) {
            System.out.println(str);

            try {
                Thread.sleep((int)(Math.random() * 100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    

}
