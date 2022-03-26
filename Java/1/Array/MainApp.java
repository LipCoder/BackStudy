import java.util.Arrays;

public class MainApp {
    public static void main(String[] args) {
        int[] arr = new int[] {100, 90, 80, 70, 60, 50};
        int[] newArr = new int[arr.length * 2];
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(newArr));

        // 배열을 복사        
        // (원본, 위치, 복사본, 위치, 몇개) 
        System.arraycopy(arr, 0, newArr, 0, arr.length);

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(newArr));
    }
}