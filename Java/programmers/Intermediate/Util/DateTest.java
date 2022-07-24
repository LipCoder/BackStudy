package Intermediate.Util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
    // 최초로 만들어진 만큼 지역화가 고려되어 있지 않음
    // Since JDK 1.0
    // Deprecated 되어 있기 때문에 사용시 취소선이 그어진다
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date.toString());

        // 사용자가 원하는 방식으로 시간을 표현할 수 있다.
        // zzz : time zone
        // a : am/pm
        SimpleDateFormat ft = new SimpleDateFormat("yyyy.MM.dd 'at' hh:mm:ss a zzz");

        System.out.println(ft.format(date));
        System.out.println(date.getTime());         // 현재 시간을 Long 타입으로 표현

        long today = System.currentTimeMillis();    // 시스템의 현재 시간을 Long 타입으로 표현
        System.out.println(today);

        System.out.println(today - date.getTime());
    }
}
