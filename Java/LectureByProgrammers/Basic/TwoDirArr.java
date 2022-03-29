package Basic;

public class TwoDirArr {
    public static void main(String[] args) {
        int[][] array1 = new int[3][4];
        array1[0][1] = 10;

        int[][] array2 = new int[3][];
        array2[0] = new int[1];
        array2[1] = new int[2];
        array2[2] = new int[3];
        array2[0][0] = 10;

        int[][] array3 = {
            {1},
            {1, 2},
            {1, 2, 3},
            {1, 2, 3, 4}
        };

        System.out.println(array3[0][0]);
    }
}
