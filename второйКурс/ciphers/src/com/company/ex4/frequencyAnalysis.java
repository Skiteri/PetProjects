package com.company.ex4;

import com.company.main.Cipher;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class frequencyAnalysis extends Cipher {

    int right; // количество правильно найденных букв
    Hashtable<Character, Double> freq_file = new Hashtable();
    Hashtable<Character, Double> freq_text = new Hashtable();
    Hashtable<Character, Character> instr; // создаем словарь по частотному анализу
    FileInputStream file;
    Hashtable<Character, Character>  initialHash; //словарь для зашифровки

    public void setInitialHash(Hashtable<Character, Character> initialHash) {
        this.initialHash = initialHash;
    }

    public frequencyAnalysis(FileInputStream file) {
        this.file = file;
    }

    private Hashtable<Character, Character> instruct() {
        /*
         создать новый Hashtable вида символ:символ
          */
        Hashtable<Character, Character> a = new Hashtable<Character, Character>();
        while (!freq_file.isEmpty()) {
            double max_file = freq_file.values().stream().max(Double::compare).get();
            double max_text = freq_text.values().stream().max(Double::compare).get();
            Character b = freq_file.keySet().stream().filter(n -> freq_file.get(n) == max_file).findFirst().get();
            Character c = freq_text.keySet().stream().filter(n -> freq_text.get(n) == max_text).findFirst().get();
//            System.out.println(max_file + " " + max_text + " " + b + " " + c);
            a.put(c, b);
            freq_file.remove(b);
            freq_text.remove(c);
        }
        return a;
    }

    String decrypt(FileInputStream current) throws FileNotFoundException {
        String newText = "";
        int count = 50000;
        int increas_number = 50000;
        Scanner c = new Scanner(System.in); // системынй ввод
        String temporary = file_helper.read(current);
//            Arrays.asList(text).stream().filter(n -> Character.isLetter(n)).forEach(n -> System.out.println(n));
        boolean is_right = false, text_is_over = false; // Закончен?
        Hashtable<Character, Double> a = analyzHelper.count_freq_file(file);


        while (count <= temporary.length()) {
            freq_file = new Hashtable<>(a);
            String local = temporary.substring(0, count);// надо счиатсь с файла

            file_helper.rewrite(local, "re.txt");
            FileInputStream text = new FileInputStream("resourses/re.txt");

            freq_text = analyzHelper.count_freq_file(text);
            instr = instruct();
            newText = analyzHelper.translate(instr, "re.txt"); // расшифровывает файл с помощью hashtable символ:символ
            System.out.println(instr + "new");
            double count_mistakes = analyzHelper.calculate_mistakes(initialHash, instr);
            graphic.addGraph(count, count_mistakes);
            if (count == temporary.length()){
                break;
            }
            text_is_over = (count + increas_number >= temporary.length());
            count = text_is_over ? temporary.length() : count + increas_number;

        }
        file_helper.rewrite(newText, "re.txt");
        graphic.draw();

        System.out.print("Исследования завершены \nТекст переведен правильно?: ");
        is_right = analyzHelper.researh(instr);

        return newText;
    }




    @Override
    public String decrypt(char[] text) {
        return null;
    }

    @Override
    public String encrypt(char[] text) {
        return null;
    }
}