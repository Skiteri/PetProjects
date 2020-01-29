package com.company.ex2;

import com.company.main.Cipher;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class simpleReplacementCipher extends Cipher {

    public Hashtable<Character, Character> key = new Hashtable<>();
    static final String alphabet = "abcdefghijklmnopqrstuvwxyz";


    public simpleReplacementCipher() {
        generateKey();
    }

    public simpleReplacementCipher(File file) {
        generateKey(file);
    }

    private void generateKey(){ // сгенерировать словарь букв случайным образом
        HashSet<Character> keys = new HashSet<Character>();
        List<Character> values = new ArrayList<>();
        Collections.addAll(keys, getAlp());
        Collections.addAll(values,getAlp());
        Collections.shuffle(values);
        keys.forEach(n -> {
            key.put(n, choose_rand(values));
        });
        System.out.println(key);
    }

    private void generateKey(File file){// сгенерировать словарь букв, считывая с файла
        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNext()){
                String sc = scan.nextLine();
                String[] arr = sc.split(":");
                key.put(arr[0].charAt(0),arr[1].charAt(0));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Character choose_rand(List<Character> values){ // выбрать рандомную букву
        Iterator<Character> a = values.iterator();
        Character current = a.next();
        values.remove(current);
        return current;
    }

    public static Character[] getAlp(){ // получить алфавит
            Character[] b = new Character[26];
            int i = 0;
            for(char a = 'a'; a <= 'z'; a++){
                b[i] = a;
                i++;
            }
            return b;
    }



    @Override
    public String decrypt(char[] text) {
        String newText = "";
        char b;
        for (char a: text){
            b = key.get(a);
            newText += b;
        }
        return newText;
    }

    @Override
    public String encrypt(char[] text) { // расшифровка
        String newText = "";
        char b = ' ';
        for (char a: text){
            for (char in:key.keySet()){
                if (a == key.get(in)){
                    b = in;
                    break;
                }
            }
            newText += b;
        }
        return newText;
    }
}
