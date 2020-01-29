import java.sql.*;
import java.util.List;
import java.util.Properties;

public abstract class DAO<T> {

    Connection connection;
    PreparedStatement statement;
    ResultSet resultSet;

    public DAO() {
        Properties props = new Properties();
        props.setProperty("user","postgres");
        props.setProperty("password","DFRJ752azY");
        props.setProperty("ssl","true");
        try {
            this.connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testuser", props);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    abstract List<T> load() throws SQLException;
    abstract void save(List<T> list) throws SQLException;
    abstract List<T> find(int id) throws SQLException;

    void closeConnection(){
        try {
            connection.close();
            if (statement != null) {
                statement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void closeStatement() {
        try {
            if (statement != null) statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    void closeRes() {
        try {
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
