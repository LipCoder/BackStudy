package Intermediate.Thread;

/*
공유객체 : 여러 스레드가 같이 공유하는 객체(데이터)

                 공유객체
----------------------------------------
|   Thread   |   Thread   |   Thread   |

*/

public class MusicBox {
    
    // * synchronized(동기화 키워드)
    // synchronized를 통해 공유객체의 동기화를 준다.
    // 모니터링 락, 임계영역 관리
    // - 동기화 메서드
    // 해당 메서드가 모두 끝날때 까지 다른 스레드들은 대기한다.
    public synchronized void playMusicA() {
        for(int i = 0; i < 10; i++) {
            System.out.println("신나는 음악!!!");

            try {
                Thread.sleep((int)(Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }   
    }

    public synchronized void playMusicB() {
        for(int i = 0; i < 10; i++) {
            System.out.println("슬픈 음악!!!");

            try {
                Thread.sleep((int)(Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }   
    }

    public void playMusicC() {
        for(int i = 0; i < 10; i++) {
           
            // - 동기화 블럭
            // 블럭으로 설정하여 해당 지역만 동기화를 수행할 수도 있다.
            synchronized (this) {
                System.out.println("카페 음악!!!");
            }

            try {
                Thread.sleep((int)(Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }   
    }
}
