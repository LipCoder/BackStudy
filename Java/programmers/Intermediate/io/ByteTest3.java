package Intermediate.io;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class ByteTest3 {
    
    public static void main(String[] args) {
        // try-with-resource
        // close 처리를 할 필요 없음
        // Exception이 발생하지 않았다면 자동으로 close()
        try(
                // 여러 타입의 OutputStream
                // 여기서는 File 
                DataOutputStream out = new DataOutputStream(new FileOutputStream("Intermediate/io/data.text"));
                ) {
            out.writeInt(100);          // 4byte, 정수형저장
            out.writeBoolean(true);     // 1byte, 논리형저장
            out.writeDouble(50.5);      // 8byte, 실수형저장
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
