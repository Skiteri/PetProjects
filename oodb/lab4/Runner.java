import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        init();
    }

    private static void init() {
        JSONdao jsoNdao = new JSONdao();
        JSONBdao jsonBdao = new JSONBdao();
        List<Item> a = new ArrayList<>() {{
            add(new Item(1 , "Tort", 12));
            add(new Item(2,"Cake", 14));
        }};

        try {
            jsoNdao.save(a);
            jsonBdao.save(a);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void findById(){
        try {
            long start = System.nanoTime();
            JSONBdao jsonBdao = new JSONBdao();
            jsonBdao.find(2);
            System.out.println(System.nanoTime() - start);
            jsonBdao.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void findByIdJJSONB(){
        try {
            long start = System.nanoTime();
            JSONdao jsoNdao = new JSONdao();
            jsoNdao.find(2);
            System.out.println(System.nanoTime() - start);
            jsoNdao.closeConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
