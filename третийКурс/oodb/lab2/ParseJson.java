import com.google.gson.Gson;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Date;

public class ParseJson {

    public static <T> T readJSON(File file, Class<T> tClass) throws IOException {
        String items = "";
        items = new String(Files.readAllBytes(file.toPath()));
        return new Gson().fromJson(items, tClass);
    }

    public static <T> String rewriteJSON(T t, File file) {
        String s = new Gson().toJson(t);
        try {
            FileWriter fileWriter = new FileWriter(file, false);
            fileWriter.write(s);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return s;
    }

    public static <T> void writeJSON(T[] item) {
        Arrays.sort(item);
    }


    public static User findObject(User[] item, int id) {
        for (User t: item){
            if (t.getId() == id) return t;
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        File file = new File("lab2/package.json");
        Item i = ParseJson.readJSON(file, Item.class);
        System.out.println(i.toString());

        User user = new User(1, "John" , new Date());
        User[] os = new User[] {new User(2, "AS", new Date()),user};
        System.out.println(ParseJson.rewriteJSON(user, new File("lab2/output.json")));
        System.out.println(ParseJson.rewriteJSON(os, new File("lab2/output.json")));

        File file1 = new File("lab2/output.json");
        User[] os3 = ParseJson.readJSON(file1, User[].class);
        Arrays.asList(os3).forEach(System.out::println);

        ParseJson.writeJSON(os3);
        Arrays.asList(os3).forEach(System.out::println);

        System.out.println(findObject(os3, 1) + " Пользователь с id 1 найлен");

    }
}
