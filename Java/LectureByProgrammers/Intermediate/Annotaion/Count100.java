package Intermediate.Annotaion;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// 어노테이션 선언부

// JVM이 실행시에 감시할 수 있게 해줌.
@Retention(RetentionPolicy.RUNTIME)
public @interface Count100 {
    
}
