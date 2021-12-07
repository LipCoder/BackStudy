package CommonMethod.item12;

public class ToStringTest {
    private final String name;
    private final int age;
    private String hobby = "";

    public void setHobby(String val) {
        hobby = val;
    }

    @Override public String toString() {
        return String.format("[Test] name: %s, age: %d, hobby: %s\n", name, age, hobby);
    } 

    public ToStringTest(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
