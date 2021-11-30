package ObjectCreateDestory.item7;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public Object pop() {
        if (size == 0)
            throw new EmptyStackException();
        return elements[--size];    // 메모리 누수 발생!!
    }

    // pop을 제대로 구현한 코드
    public Object popRightWay() {
        if (size == 0)
            throw new EmptyStackException();
        Object result = elements[--size];
        elements[size] = null;    // 다 쓴 참조 해제
        return result;
    }

    // 원소를 위한 공간을 적어도 하나 이상 확보
    // 배열의 크기를 늘려야 할 경우 대략 두 배씩 늘림
    private void ensureCapacity() {
        if(elements.length == size) 
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }
}
