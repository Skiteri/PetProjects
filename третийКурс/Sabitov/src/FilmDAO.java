import java.sql.*;
import java.util.ArrayList;

public class FilmDAO {

    public static ArrayList<Film> getBase() {

        String sql = "SELECT id, name FROM film1";
        Statement stmt;
        ArrayList<Film> a = new ArrayList<>();
        try {
            Connection connection = new ConnectionToPostgres().getConnection();
            if (connection == null) throw new SQLException("Sql not connect");
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                a.add(new Film(rs.getInt("id"), rs.getString("name")));
                System.out.println(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return a;
    }


}
