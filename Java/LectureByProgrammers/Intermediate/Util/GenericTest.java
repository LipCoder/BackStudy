package Intermediate.Util;

public class GenericTest {
    public static void main(String[] args) {
        Box box = new Box();
        box.setObj(new Object());
        Object obj = box.getObj();

        box.setObj("Hello");
        // Object를 알맞게 사용하려면 꼭 형변환이 필요하다
        String str = (String)box.getObj();
        System.out.println(str);

        box.setObj(1);
        int value = (Integer)box.getObj();


        // 제너릭 사용
        BoxGeneric<Object> boxGeneric = new BoxGeneric<Object>();
        boxGeneric.setObj(new Object());
        Object obj2 = boxGeneric.getObj();

        BoxGeneric<String> boxGeneric2 = new BoxGeneric<String>();
        boxGeneric2.setObj("hello");
        String str2 = boxGeneric2.getObj();

        BoxGeneric<Integer> boxGeneric3 = new BoxGeneric<Integer>();
        boxGeneric3.setObj(1);
        int value2 = boxGeneric3.getObj();

    }
}

class Box {
    private Object obj;

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public Object getObj() {
        return obj;
    }
}

// 제너릭 사용
class BoxGeneric<E> {
    private E obj;

    public void setObj(E obj) {
        this.obj = obj;
    }

    public E getObj() {
        return obj;
    }
}