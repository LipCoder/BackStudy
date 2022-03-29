package Intermediate;

public class StringIssue {
    
    public static void main(String[] args) {
        String str1 = "hello world!";
        String str2 = str1.substring(5);
        System.out.println(str1);
        System.out.println(str2);

        String str3 = str1 + str2;
        System.out.println(str3);

        // 위 코드는 내부에서 다음과 같이 돌아감
        String str4 = new StringBuffer().append(str1).append(str2).toString();
        System.out.println(str4);

        String str5="";
        for(int i = 0; i < 100; i++) {
            // 내부적으로 String 객체가 계속해서 생성된다.
            // 반복문에 이렇게 많이 수행되면 속도에 영향이 있을 수 있다.
            str5 = str5 + "*";
        }
        System.out.println(str5);

        // String의 단점을 보완하기 위해 StringBuffer를 사용
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < 100; i++) {
            sb.append("*");
        }
        String str6 = sb.toString();
        System.out.println(str6);
    }
}