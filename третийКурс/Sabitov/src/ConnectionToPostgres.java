import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionToPostgres {

    private static final String URL = "jdbc:postgresql://localhost:54111/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";

    public Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            System.out.println("not connected");
            e.printStackTrace();
        }
        return null;
    }
}
