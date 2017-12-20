/*
* Гурьевских В.Г.
*
* (Task1) Реализовать простейшую хеш-функцию. На вход функции подаётся строка, на выходе сумма кодов символов.
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainClass {
    public static void main(String[] args){
        Task1();
    }

    private static void Task1() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter string:");
        try {
            String str = br.readLine();
            System.out.println("Hash: " +CreateHashFromString(str));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int CreateHashFromString(String str) {
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            sum += str.charAt(i);
        }
        return sum;
    }
}
