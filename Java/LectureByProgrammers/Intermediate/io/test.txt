package Intermediate.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CharTest2 {
    public static void main(String[] args) {
        BufferedReader br = null;
        PrintWriter pw = null;
        try {
            br = new BufferedReader(new FileReader("Intermediate/io/CharTest2.java"));        

            // PrintWriter는 안에 Writer를 매개변수로 생성하지 않아도 사용할 수 있다.
            pw = new PrintWriter(new FileWriter("Intermediate/io/test.txt"));
            String line = null;
            while((line = br.readLine()) != null) {
                pw.println(line);
            }

        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        } finally {
            // 오픈한 파일은 반드시 닫아준다.
            pw.close();
            try {
                br.close();
            } catch (IOException e) {
                //TODO: handle exception
                e.printStackTrace();
            }
        }
    }
}
