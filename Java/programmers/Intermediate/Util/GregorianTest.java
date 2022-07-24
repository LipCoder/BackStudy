package Intermediate.Util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class GregorianTest {
    public static void main(String[] args) {
        Date now = new Date();
        Calendar cal = GregorianCalendar.getInstance();
        Date now2 = cal.getTime();

        long diff = now.getTime() - now2.getTime();
        System.out.println(diff);
    }
}
