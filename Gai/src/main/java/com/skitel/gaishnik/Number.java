package com.skitel.gaishnik;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Number {

    private String result;

    private static class NumberPattern {
        // Шаблон для номера автомобиля
        private final static List<Character> CHARS = Arrays.asList('А', 'В', 'Е', 'К', 'М', 'Н',
                'О', 'Р', 'С', 'Т', 'У', 'Х');
        private final static String REGION = "116 RUS";

        private static Number generateNum() {
            // генерирование валидного числа
            StringBuilder res = new StringBuilder(), id = new StringBuilder();
            List<Character> listForShuffeling = new ArrayList<>(CHARS);
            for (int i = 0; i < 3; i++) {
                int digit = (int) (Math.random() * 10);
                id.append(digit);
                res.append(listForShuffeling.get((int) (Math.random() * 10)));
            }
            res.insert(1, id);
            res.append(" " + REGION);

            return new Number(res.toString());
        }

        private static Number nextNumber(Number number) {
            // возращает следующий автомобильный номер
            String a = number.result;
            StringBuilder res = new StringBuilder(a);
            int digitsOfSign = Integer.parseInt(a.substring(1, 4));
            int size = CHARS.size();
            char nextChar;
//            System.out.println(digitsOfSign);
            digitsOfSign++;
            if (digitsOfSign > 999) {
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
            return new Number(res.toString());
        }

//        public static void main(String[] args) {
//            System.out.println(nextNumber(new Number("С999ХХ 116 RUS")));
//        }
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
        result = NumberPattern.generateNum().result;
    }

    public void next() {
        // следующий номер автомобиля
        if (result == null || result.equals("Нет номера")) result = "Нет номера";
        else result = NumberPattern.nextNumber(this).result;
    }

    @Override
    public String toString() {
        return result;
    }
}
