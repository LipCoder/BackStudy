package Intermediate.Util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapTest {
    // Map: 키와 값을 저장하는 자료구조
    // 키를 이용해 구분하기 때문에 키는 중복될 수 없음
    // 값은 중복이 가능하다.
    // 중복이 가능하고 순서는 없다.
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("001", "kim");
        map.put("002", "lee");
        map.put("003", "choi");

        // 삽입시 키가 중복되는 경우 기존 값을 덮어씌운다.
        map.put("001", "kang");

        System.out.println(map.size());

        System.out.println(map.get("001"));
        System.out.println(map.get("002"));

        Set<String> keys = map.keySet();

        Iterator<String> iter = keys.iterator();
        while(iter.hasNext()) {
            String key = iter.next();
            String value = map.get(key);
            System.out.println(key + ":" + value);
        }
    }
}
