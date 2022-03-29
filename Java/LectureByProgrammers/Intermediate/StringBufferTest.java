package Intermediate;

public class StringBufferTest {
    public static void main(String[] args) {
        
        // 아무 값도 가지지 않은 StringBuffer 생성
        // StringBuffer는 String과 다르게 가변성 특징을 가진다.
        // String을 자주 사용하면 힙 메모리의 남발로 문제가 생길 수 있다.
        // 이를 해결하기 위해 Java는 StringBuffer 클래스를 제공한다.
        StringBuffer sb = new StringBuffer();
        sb.append("hello");
        sb.append(" ");
        sb.append("world");

        System.out.println(sb.toString());

        // 자기 자신을 반환 
        StringBuffer sb2 = new StringBuffer();
        StringBuffer sb3 = sb2.append("hello");
        if(sb2 == sb3) 
            System.out.println("sb2 == sb3");

        // 메서드 체이닝
        // 이러한 특성을 이용하여 메서드를 연속으로 호출할 수 있다.
        sb3.append(" ").append("world").append("!");
        System.out.println(sb3.toString());
    }
}
