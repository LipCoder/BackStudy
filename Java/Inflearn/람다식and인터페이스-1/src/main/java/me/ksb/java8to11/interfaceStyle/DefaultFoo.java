package src.main.java.me.ksb.java8to11.interfaceStyle;

public class DefaultFoo implements Foo, Bar {

    String name;

    public DefaultFoo(String name) {
        this.name = name;
    }

    @Override
    public void printName() {
        System.out.println(this.name);
    }

    /**
     * Foo, Bar에 동일한 기본 메서드를 가지고 있는 경우
     * 컴파일러는 어떤 것을 사용해야 할지 알 수 없다.
     * 그러므로 하위 클래스에 직접 오버라이딩 해야한다.
     */
    @Override
    public void printNameUpperCase() {

    }

    @Override
    public String getName() {
        return this.name;
    }
}
