import java.util.*;

public class ArrayListLinkedListTest2 {
    public static void main(String[] args) {
        ArrayList al = new ArrayList(1000000);
        LinkedList ll = new LinkedList();
        add(al);
        add(ll);

        System.out.println("= 접근시간테스트 =");
        System.out.println("ArrayList :" + access(al));
        System.out.println("LinkedList :" + access(ll));
    }

    public static void add(List list) {
        for(int i = 0; i < 100000; i++) list.add(i + "");
    }

    public static long access(List list) {
        long start = System.currentTimeMillis();
        for(int i = 0 ; i < 10000; i++) list.get(i);
        long end = System.currentTimeMillis();
        return end - start;
    }
}

/*
    인덱스가 n개인 데이터 주소 = 배열 주소 + n * 타입 데이터 크기.
    둘의 장점을 조합해서 사용하는 방법도 있다.
    작업 : LinkedList
    저장 : ArrayList
*/