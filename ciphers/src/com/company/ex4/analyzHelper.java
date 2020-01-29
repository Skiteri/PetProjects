package com.company.ex4;

import com.company.ex2.simpleReplacementCipher;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class analyzHelper {

    static Hashtable<Character, Double> count_freq_file(FileInputStream current) {
        /*
        Посчитать частоту каждой буквы в тексте
        */
        Hashtable<Character, Double> freq = new Hashtable<>();
        Scanner scan = new Scanner(current);
        Arrays.stream(simpleReplacementCipher.getAlp()).forEach(n -> freq.put(n, 0.0));
        while(scan.hasNext()){
            char[] line = scan.next().toLowerCase().toCharArray();
            for (char a: line){
                if (Character.isLetter(a)) {
                    freq.put(a, freq.get(a) + 1);
                }
            }
        }
        exchangeHash(freq);
        return freq;
    }

    static Hashtable<Character, Double> exchangeHash(Hashtable<Character, Double> current){
         /*
         Перевести значение буква:(количество появлений в тексте) на буква:(процент появления)
         */
        Optional<Double> elem = current.values().stream().reduce((x, y)-> x + y);
        current.forEach((x,y) ->
                current.put(x, Double.parseDouble(String.format(Locale.US,"%(.4f",(y/elem.get()*100)))));
        return current;
    }

    static String translate(Hashtable<Character, Character> instr, String txt){
        String newText = "";
        FileInputStream file1 = null;
        try {
            file1 = new FileInputStream("resourses/" + txt);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(file1);

        while (scanner.hasNext()) {
            String a = scanner.nextLine();
            for (char b : a.toLowerCase().toCharArray()) {

                if (Character.isLetter(b)) {
                    newText += instr.get(b);
                } else {
                    newText += b;
                }
            }
            newText += "\n";
        }
        return newText;
    }


    static Hashtable<Character, Character> change(Hashtable<Character, Character> current) {
        Scanner b = new Scanner(System.in);
        System.out.print("Введите букву для замены ");
        char char1 = b.next().charAt(0); // ключ первой буквы
        System.out.print("Введите букву, которую хотите заменить ");
        char char2 = b.next().charAt(0); // значение для замены первой буквы
        char char3 = current.keySet().stream().filter(n -> current.get(n) == char1).findFirst().get(); //ищем ключ значение
        char char4 = current.keySet().stream().filter(n -> current.get(n) == char2).findFirst().get();;
        current.put(char4, ' ');
        current.put(char3, char2);
        current.put(char4, char1);
        System.out.print("Буквы " + char1 + " " + char2 + " поменялись местами\n" );
        System.out.println("Буквы " + char4 + " " + char3 + " поменялись местами\n" );
        return current;
    }

    public static boolean researh(Hashtable<Character, Character> instr) {
        Scanner c = new Scanner(System.in);
        if (c.nextBoolean()){
            return true;
        } else {
            System.out.println("Какие буквы вы хотите заменить? ");
            while (true){
                instr = analyzHelper.change(instr);
                System.out.println("Вы закончили? ");
                if (c.nextBoolean()){
                    return false;
                }
            }
        }
    }

    public static double calculate_mistakes(Hashtable<Character, Character> original, Hashtable<Character, Character> decrypted) {
        int count = (int) original.keySet().stream().filter(n -> decrypted.get(original.get(n)) == n).count();
        return Double.parseDouble(String.format(Locale.US,"%(.4f",((count / 26.0) * 100)));
    }


}