package Basic;

/**
 * 
 * foreach는 java 1.5부터 추가된 키워드
 */
public class ForEach {
    public static void main(String[] args) {
        int[] iarr = {10, 20, 30, 40, 50};

        for(int num : iarr) {
            System.out.println(num);
        }
     }
}
