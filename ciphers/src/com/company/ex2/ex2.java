package com.company.ex2;

import java.io.File;
import java.util.Scanner;

public class ex2 {
    public static void startEx() {
        Scanner scan = new Scanner(System.in);
        simpleReplacementCipher a;
        System.out.print("Начало задания 2\nХотите загрузить файл?(введите true или false): ");
        if (scan.nextBoolean()){
            File file = new File("resourses/key.txt");
            a = new simpleReplacementCipher(file);
        } else {
            a = new simpleReplacementCipher();
        }
        System.out.println("Введите текст: ");
        String text = scan.next();
        System.out.println("Зашифрованный текст: " + a.decrypt(text.toCharArray()));
        System.out.println("Расшифрованный текст: " + a.encrypt(text.toCharArray()));
    }
}
