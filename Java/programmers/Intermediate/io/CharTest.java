package Intermediate.io;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CharTest {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        try {
            line = br.readLine();
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
        System.out.println(line);
    }
    
}
