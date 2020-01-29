package com.company.ex1;

import com.company.main.Cipher;

import java.util.Scanner;

public class ex1 {
    public static void startEx(){
        System.out.println("Начало задания 1");
        Scanner s = new Scanner(System.in);
        System.out.print("Введите текст: ");
        String text = s.nextLine();
        System.out.print("Введите шаг шифрования: ");
        Cipher ceasar = new ceasar(s.nextInt());
        System.out.println("Зашифрованный текст: " + ceasar.decrypt(text.toLowerCase().toCharArray()));
        System.out.println("Расшифрованный текст: " + ceasar.encrypt(text.toLowerCase().toCharArray()));
    }
}
