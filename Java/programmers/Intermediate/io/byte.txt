package Intermediate.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteTest {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream("Intermediate/io/ByteTest.java");
            fos = new FileOutputStream("Intermediate/io/byte.txt");

            int readData = -1;
            while((readData = fis.read()) != -1) {
                fos.write(readData);
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
