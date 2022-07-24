package Basic;

public class OneDirArr {

    public static void main(String[] args) {
        int[] array1 = new int[100];

        array1[10] = 10;
        array1[50] = 50;


        int[] array2 = new int[]{
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10
        };

        int[] array3 = {1, 2, 3, 4};


        for(int i = 0; i < array1.length; i++) {
            System.out.println(array1[i]);
        }
    }
    


}
