package com.company.ex1;

import com.company.main.Cipher;

public class ceasar extends Cipher {

    private int shift;

    public ceasar(int shift) throws ArithmeticException{
        if (shift < 1 || shift > 26) throw new ArithmeticException("Введите число меньше 26 и больше 0");
        this.shift = shift;
    }

    @Override
    public String decrypt(char[] text){
        String newText = "";
        for (int i = 0; i < text.length; i++) {
            int ascII = (int) text[i];
            if (ascII > 96 && ascII < 124 ) {
                ascII = (ascII + shift - 19) % 26 + 97;
                newText = newText + (char) ascII;
            } else {
                newText = newText + text[i];
            }
        }
        return newText;
    }

    @Override
    public String encrypt(char[] text){
        String newText = "";
        for (int i = 0; i < text.length; i++) {
            int ascII = (int) text[i];
            if (ascII > 96 && ascII < 124 ) {
            ascII = (ascII - shift - 19) % 26 + 97;
            newText = newText + (char) ascII;
            } else {
                newText = newText + text[i];
            }
        }
        return newText;
    }
}
