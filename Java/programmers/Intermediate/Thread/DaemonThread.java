package Intermediate.Thread;

public class DaemonThread implements Runnable {
    
    @Override
    public void run() {
        while(true) {
            System.out.println("데몬 쓰레드가 실행중입니다.");

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }
    
    // 데몬 스레드
    // 데몬역할을 하는 스레드
    // 데몬이란 백그라운드 서비스로 항시 돌아가면서 서비스를 제공

    public static void main(String[] args) {
        Thread thread = new Thread(new DaemonThread());
        
        // 데몬 스레드로 설정
        thread.setDaemon(true);
        thread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("메인 쓰레드가 종료됩니다.");
    }
}
