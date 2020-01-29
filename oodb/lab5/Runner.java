import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class Runner {
    public static void main(String[] args) throws IOException, SQLException{

        PreparedStatement preparedStatement;
        Connection conn = setConnection();
        Item item = new Item(1, "sosiski", 12);
        String sql = "INSERT INTO ItemList (item)  VALUES (row(?,?,?))";

        preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1, item.getId());
        preparedStatement.setString(2, item.getDescription());
        preparedStatement.setInt(3, item.getPrice());

        preparedStatement.executeUpdate();
        preparedStatement.close();

    }

    private static Connection setConnection() {
        Properties props = new Properties();
        props.setProperty("user","postgres");
        props.setProperty("password","DFRJ752azY");
        props.setProperty("ssl","true");
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testuser", props);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }
}
