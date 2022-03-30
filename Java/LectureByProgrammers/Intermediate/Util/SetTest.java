package Intermediate.Util;

import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

public class SetTest {
    // Set: 중복 X, 순서 X
    // Interface로 구현된 Class는 HashSet과 TreeSet이 있다.
    public static void main(String[] args) {
        Set<String> set1 = new HashSet<String>();
        boolean flag1 = set1.add("kang");
        boolean flag2 = set1.add("kim");
        boolean flag3 = set1.add("kang");

        System.out.println(set1.size());

        System.out.println(flag1);
        System.out.println(flag2);
        System.out.println(flag3);
    
        Iterator<String> iter = set1.iterator();
        while(iter.hasNext()) {
            String str = iter.next();
            System.out.println(str);
        }
        
        // forEach 문을 사용한 순회 출력
        for(String str : set1) {
            System.out.println(str);
        }
    }
}
