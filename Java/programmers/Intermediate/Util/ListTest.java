package Intermediate.Util;

import java.util.ArrayList;
import java.util.List;

public class ListTest {
    // List: 배열과 비슷하다.
    // 배열은 한 번 생성하면 크기변경이 불가능
    // List의 경우 크기변경이 가능
    // 데이터 중복이 가능하고 순서가 있다.

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("kim");
        list.add("kang");
        list.add("kim");

        System.out.println(list.size());

        // 순서가 있기 때문에 index 접근이 가능하다.
        for(int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            System.out.println(str);
        }
    }
}
