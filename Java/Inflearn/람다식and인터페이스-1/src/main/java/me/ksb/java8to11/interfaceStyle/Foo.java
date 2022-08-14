package src.main.java.me.ksb.java8to11.interfaceStyle;

import java.util.Locale;

public interface Foo {

    void printName();

    /**
     * 기본 메소드 (default)
     *
     * 나중에 모든 인스턴스에 추가할 메소드가 필요하게 되었다 가정해보자.
     * 그러면 해당 인터페이스를 상속받는 클래스는 모두 컴파일 에러를 내밷는다.
     * 이와 같은 에러를 방지하기 위해 Java8 에서는 default 메소드를 사용할 수 있다.
     */
    /**
     * @implSpec
     * 이 구현체는 getName()으로 가져온 문자열을 대문자로 바꿔 출력한다.
     */
    default void printNameUpperCase() {
        // getName() 부분.. 무슨 값이 오는지 모르기 때문에 주의해야 한다.
        // 그러므로 반드시 문서화 해야 한다.
        System.out.println(getName().toUpperCase());
    }

    // Object에서 사용하는 메서드들은 기본 메소드로 재정의가 불가능하다.
//    default String toString() {
//
//    }

    /**
     * 스태틱 메서드 (static)
     *
     * 해당 인터페이스를 상속받는 하위클래스에 인스턴스를 생성하지 않고
     * 메서드를 사용하고 싶은 경우, 스태틱 메서드를 활용할 수 있다.
     *
     */
    static void printAnything() {
        System.out.println("Foo");
    }

    String getName();
}
