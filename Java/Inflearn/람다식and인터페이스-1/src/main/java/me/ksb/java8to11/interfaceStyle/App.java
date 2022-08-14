package src.main.java.me.ksb.java8to11.interfaceStyle;

public class App {
    public static void main(String[] args) {
        Foo foo = new DefaultFoo("ksb");
        foo.printName();
        foo.printNameUpperCase();

        Foo.printAnything();
    }
}
