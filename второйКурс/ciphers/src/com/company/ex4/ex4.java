package com.company.ex4;

import com.company.ex2.simpleReplacementCipher;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Hashtable;

public class ex4 {
    public static void startEx() throws FileNotFoundException {
    /*
    сначала создадим объект расшифровки frequcency...
     */
        FileInputStream file = new FileInputStream("resourses/P.txt");
        frequencyAnalysis freq = new frequencyAnalysis(file);
     /*
     из 2 задания возьмем словарь, который генерируется случайным образом
      */
        simpleReplacementCipher cipher = new simpleReplacementCipher();
        Hashtable<Character, Character> instr = cipher.key;

        String decryptedText = analyzHelper.translate(instr, "Original.txt"); // зашифруем текст
        file_helper.rewrite(decryptedText,"DecryptedText.txt" );//запишем в файл

        freq.setInitialHash(instr);// пероначальный словарь из обычного текста в зашифрованный
        FileInputStream file1 = new FileInputStream("resourses/DecryptedText.txt");
        System.out.println(freq.decrypt(file1));
    }
}
