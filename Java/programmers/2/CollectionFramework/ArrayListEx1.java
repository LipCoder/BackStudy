import java.util.ArrayList;
import java.util.Collections;

public class ArrayListEx1 {
    public static void main(String[] args) {
        ArrayList list1 = new ArrayList(10);
        list1.add(new Integer(5));
        list1.add(new Integer(4));
        list1.add(new Integer(2));
        list1.add(new Integer(0));
        list1.add(new Integer(1));
        list1.add(new Integer(3));

        ArrayList list2 = new ArrayList(list1.subList(1, 4));
        print(list1, list2);

        Collections.sort(list1);
        Collections.sort(list2);
        print(list1, list2);

        System.out.println("list1.containsAll(list2):" + list1.containsAll(list2));
        System.out.println();

        list2.add("B");
        list2.add("C");

        list2.add(3, "A");
        print(list1, list2);

        list2.add(3, "AA");
        print(list1, list2);

        // 겹치는 부분만 남기고 나머지는 삭제한다.
        System.out.println("list1.retainAll(list2):" + list1.retainAll(list2));
        System.out.println();

        print(list1, list2);

        // list2에 list1이 포함된 객체들을 삭제한다.
        // 거꾸로 순회를 도는 이유 : 증가하면서 순회를 도는 경우,
        // 삭제될때마다 빈공간이 생겨 나머지 요소들이 자리이동을
        // 하기 때문에 올바른 결과를 얻을 수 없다.
        for(int i = list2.size() - 1; i >= 0; i--) {
            if(list1.contains(list2.get(i)))
                list2.remove(i);
        }
        print(list1, list2);
    }

    static void print(ArrayList list1, ArrayList list2) {
        System.out.println("list1:" + list1);
        System.out.println("list2:" + list2);
        System.out.println();
    }
}
