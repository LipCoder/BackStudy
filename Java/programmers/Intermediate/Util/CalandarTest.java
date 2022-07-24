package Intermediate.Util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalandarTest {
    
    // Date에 지역화를 고려하여 보완한 클래스
    // 굉장히 많은 상수값들을 가지고 있음
    
    public static void main(String[] args) {
        // 캘린더는 추상클래스
        // getInstance()로 반환하여 사용
        // 이렇게 구현한 이유는 유연성 때문
        // 나중에 새로운 캘린더 클래스가 나오면 쉽게 대체할 수 있다.
        Calendar cal = Calendar.getInstance();
        System.out.println(cal.get(Calendar.YEAR));
        System.out.println(cal.get(Calendar.MONTH) + 1);    // '월'은 꼭 1을 더해줘야 정확
        System.out.println(cal.get(Calendar.DATE));

        System.out.println(cal.get(Calendar.HOUR));         // 12시
        System.out.println(cal.get(Calendar.HOUR_OF_DAY));  // 24시
        System.out.println(cal.get(Calendar.MINUTE));

        // 시간 추가, 빼기
        // 현재에서 원하는 시간으로 변경이 가능하다.
        cal.add(Calendar.HOUR, 5);
        System.out.println(cal.get(Calendar.HOUR));         // 12시
        System.out.println(cal.get(Calendar.HOUR_OF_DAY));  // 24시

        SimpleDateFormat ft = new SimpleDateFormat("yyyy년M월d일");
        System.out.println(ft.format(cal.getTime()));
    }
}
