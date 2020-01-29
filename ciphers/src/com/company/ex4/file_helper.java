package com.company.ex4;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class file_helper {
    static void rewrite(String text, String file){
        // запись в файл
        try(FileWriter writer = new FileWriter("resourses/" + file, false))
        {
            // запись всей строки
            writer.write(text);
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public static String read(FileInputStream current) {
        String newText = "";
        Scanner scanner = new Scanner(current);
        while (scanner.hasNextLine()){
            newText += scanner.nextLine() + "\n";
        }
        return newText;
    }
}
