package Intermediate.Util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class TimeTest {
    // Time API는 JDK8부터 가능
    // Date는 직관적이지 못하다. 
    // 외부 Joda-Time 라이브러리를 사용
    // 이 라이브러리가 JDK에 들어가게 되었다!

    public static void main(String[] args) {
        LocalDateTime timePoint = LocalDateTime.now();
        System.out.println(timePoint);

        LocalDate ld1 = LocalDate.of(2012, Month.DECEMBER, 12);
        System.out.println(ld1);

        LocalTime lt1 = LocalTime.of(17, 18);
        System.out.println(lt1);
        LocalTime lt2 = LocalTime.parse("10:15:30");
        System.out.println(lt2);

        LocalDate theDate = timePoint.toLocalDate();
        System.out.println(theDate);
        Month month = timePoint.getMonth();
        System.out.println(timePoint.getMonthValue());
        System.out.println(month.getValue());
        System.out.println(timePoint.getHour());
        System.out.println(timePoint.getMonth());
    }
}
