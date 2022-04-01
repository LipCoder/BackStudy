package Intermediate.io;

import java.io.DataInputStream;
import java.io.FileInputStream;

public class ByteTest4 {
    // 파일에서 다양한 형식의 데이터 불러오기
    public static void main(String[] args) {
        // try-with-resource
        try (
                DataInputStream in = new DataInputStream(
                        new FileInputStream("Intermediate/io/data.txt"));
                ) {
            int i = in.readInt();
            boolean b = in.readBoolean();
            double d = in.readDouble();
            
            System.out.println(i);
            System.out.println(b);
            System.out.println(d);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

}
