package com.skitel.gaishnik;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
public class Number {

    private String result;

    private static class NumberPattern {
        // Шаблон для номера автомобиля
        private static final List<Character> CHARS = Arrays.asList('А', 'В', 'Е', 'К', 'М', 'Н',
                'О', 'Р', 'С', 'Т', 'У', 'Х');
        private static final String REGION = "116 RUS";

        static String generateNum() {
            // генерирование валидного числа
            StringBuilder res = new StringBuilder(), id = new StringBuilder();
            List<Character> listForShuffeling = new ArrayList<>(CHARS);
            for (int i = 0; i < 3; i++) {
                Collections.shuffle(listForShuffeling);
                int digit = (int) (Math.random() * 10);
                id.append(digit);
                res.append(listForShuffeling.get(0));
            }
            res.insert(1, id);
            res.append(" " + REGION);
            return res.toString();
        }

        static String nextNumber(String a) {
            // возращает следующий автомобильный номер
            StringBuilder res = new StringBuilder(a);
            int digitsOfSign = Integer.parseInt(a.substring(1, 4));
            int size = CHARS.size();
            char nextChar;
//            System.out.println(digitsOfSign);
            digitsOfSign++;
            if (digitsOfSign > 999) {
                // добавить проверку на кириллицу
                char fifthChar = res.charAt(5);
                if (fifthChar == 'Х') {
                    char fourthChar = res.charAt(4);
                    if (fourthChar == 'Х') {
                        char firstChar = res.charAt(0);
//                        System.out.println(firstChar);
                        if (firstChar == 'Х') throw new RuntimeException("Number is bigger than available");
                        nextChar = CHARS.get((CHARS.indexOf(firstChar) + 1) % size); //остаток от деления на длину превращает из "X" - "A"
                        res.replace(0, 1, String.valueOf(nextChar));
                    }
                    nextChar = CHARS.get((CHARS.indexOf(fourthChar) + 1) % size); //остаток от деления на длину превращает из "X" - "A"
                    res.replace(4, 5, String.valueOf(nextChar));
                }
                nextChar = CHARS.get((CHARS.indexOf(fifthChar) + 1) % size); //остаток от деления на длину превращает из "X" - "A"
                res.replace(5, 6, String.valueOf(nextChar));
//                System.out.println(CHARS.indexOf(fifthChar));
                digitsOfSign %= 1000;
            }

            String s = String.format("%03d", digitsOfSign);
            res.replace(1, 4, s);
            return res.toString();
        }

        public static void main(String[] args) {
            String s = generateNum();
            System.out.println(nextNumber("С999ХХ 116 RUS"));
            System.out.println(s);
        }
    }

    public Number() {
    }
    
    Number(String result) {
        this.result = result;
//        if (!isResultValid()) throw new RuntimeException("Cannot parse number");
    }

//    private boolean isResultValid() {
//        // проверка номера на валидность
//        return true;
//    }


    public void random() {
        // случайный номер автомобиля
        result = NumberPattern.generateNum();
    }

    public void next() {
        // следующий номер автомобиля
        if (result == null || result.equals("Нет номера")) result = "Нет номера";
        else result = NumberPattern.nextNumber(this.result);
    }

    @Override
    public String toString() {
        return result;
    }
}
