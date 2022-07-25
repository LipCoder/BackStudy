package src.main.java.me.ksb.java8to11;

/**
 * 함수형 인터페이스
 */
@FunctionalInterface
public interface RunSomething {

    int doIt(int number);

    /**
     * 함수형 인터페이스는 추상 메서드가 하나만 있어야 한다.
     */
//    void doItAgain();

    static void printName() {
        System.out.println("Seungboem");
    }

    default void printAge() {
        System.out.println("40");
    }
}
