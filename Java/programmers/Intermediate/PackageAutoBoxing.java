package Intermediate;

public class PackageAutoBoxing {
    public static void main(String[] args) {
        int i = 5;                      // 객체X, 기본형
        Integer i2 = new Integer(5);    // 객체O, 참조형
        
        // 오토박싱(JDK 5 이후)
        // 자동으로 기본형 리티럴 값을 참조형 객체로 만들어준다.
        Integer i3 = 5;     // int     --> Integer
        
        // 오토언박싱
        // 자동으로 래퍼클래스를 기본형 타입으로 바꿔준다.
        int i4 = i3;        // Integer --> int

        
    }       
}
