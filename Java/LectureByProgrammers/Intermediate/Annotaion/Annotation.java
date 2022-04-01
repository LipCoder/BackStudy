package Intermediate.Annotaion;

import java.lang.reflect.Method;

public class Annotation {
    /* Annotation
       JAVA 5 부터 추가된 기능
       클래스나 메소드 위에 붙여서 사용 ex) @Override
       소스코드에 메타코드(추가정보)를 주는 것
       사용자 정의 가능 --> 커스텀 어노테이션

       사용 방법
       1. 정의
       2. 사용
       3. 실행
    */
    public static void main(String[] args) {
        MyHello hello = new MyHello();

        // getClass : 해당 객체의 클래스의 정보를 얻는다.
        // getDeclaredMethod : hello라는 이름을 가진 메서드를 가져온다.
        try {
            Method method = hello.getClass().getDeclaredMethod("hello");

            // Count100이라는 어노테이션이 적용이 되어 있는지 여부
            if(method.isAnnotationPresent(Count100.class)) {
                for(int i = 0; i < 100; i++) {
                    hello.hello();
                }
            } else {
                hello.hello();
            }
        } catch (NoSuchMethodException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
