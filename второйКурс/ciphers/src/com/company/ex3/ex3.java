package com.company.ex3;


import com.company.ex1.ceasar;

import java.util.Scanner;

public class ex3 {
    public static void startEx() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Начало задания 3\nВведите текст: ");
        String text = scanner.next();
        System.out.println("\nПервоначальный текст: " + text);
        ceasar ceasar;
        for (int i = 1; i < 26; i++){
            ceasar = new ceasar(i);
            System.out.println("Расшифрованный текст " + i + ": " + ceasar.encrypt(text.toCharArray()));
        }
    }
}
