package Intermediate.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteTest2 {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        FileInputStream fis = null;
        FileOutputStream fos = null;

        // 512씩 읽는게 1씩 읽는것 보다 빠른 이유
        // 원래 컴퓨터는 512(얼추)바이트씩 읽어오지만
        // 1바이트씩 받는 경우 512바이트를 읽고 앞에 1바이트만 읽고 버린다.
        // 이 과정을 반복하면서 쓸데 없는 동작이 발생하기 때문에 느리다.
        try {
            fis = new FileInputStream("Intermediate/io/ByteTest.java");
            fos = new FileOutputStream("Intermediate/io/byte.txt");

            // 읽어 들인 수를 저장
            int readCount = -1;
            byte[] buffer = new byte[512];
            while((readCount = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, readCount);
            }

        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
                fos.close();
            } catch (IOException e) {
                //TODO: handle exception
                e.printStackTrace();
            }
        }
        
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }
    
}
