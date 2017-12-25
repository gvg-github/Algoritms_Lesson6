/*
* Гурьевских В.Г.
*
* (Task1) Реализовать простейшую хеш-функцию. На вход функции подаётся строка, на выходе сумма кодов символов.
* (Task2) Переписать программу, реализующее двоичное дерево поиска.
            а) Добавить в него обход дерева различными способами;
            б) Реализовать поиск в двоичном дереве поиска;
            в) *Добавить в программу обработку командной строки с помощью которой можно указывать
из какого файла считывать данные, каким образом обходить дерево
* */

import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args){

        //Реализовать простейшую хеш-функцию. На вход функции подаётся строка, на выходе сумма кодов символов.
        Task1();
        //Переписать программу, реализующее двоичное дерево поиска.
        Task2();
    }

    //Двоичное дерево поиска
    private static void Task2() {

        Scanner in = new Scanner(System.in);
        System.out.println("Select bypass metod: 1 for pre-order, 2 for in-order, 3 for post-order");
        int mode = in.nextInt();
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(3, 1);
        tree.insert(2, 2);
        tree.insert(4, 5);
        tree.print(mode);
        tree.remove(2);
        tree.remove(3);
        tree.print(mode);
        tree.remove(4);

    }

    //Реализовать простейшую хеш-функцию. На вход функции подаётся строка, на выходе сумма кодов символов.
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
