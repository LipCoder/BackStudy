package CommonMethod.item12;

public class MainApp {
    public static void main(String[] args) {
        ToStringTest t = new ToStringTest("김승범", 30);
        t.setHobby("책읽기");
        System.out.println(t.toString());
    }
}
