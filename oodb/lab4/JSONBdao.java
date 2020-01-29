import com.google.gson.Gson;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class JSONBdao extends DAO<Item> {
    @Override
    List<Item> load() throws SQLException {
        String pStr = "";
        PreparedStatement statement = connection.prepareStatement("select contentb from jtest"); //TODO
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            pStr = resultSet.getString("contentb");  //TODO
            System.out.println(pStr);
        }
        statement.close();
        Gson gson = new Gson();
        Item[] clst = gson.fromJson(pStr, Item[].class);
        statement = connection.prepareStatement("select contentb->0 as c from jtest "); //TODO
        resultSet = statement.executeQuery();
        while (resultSet.next()){
            pStr = resultSet.getString("c"); //TODO
//            System.out.println(pStr);
        }
        return Arrays.asList(clst);
    }

    @Override
    void save(List<Item> list) throws SQLException {
        if (list != null && list.size() > 0){
            Gson gson = new Gson();
            String listAsJson = gson.toJson(list);
            PreparedStatement statement = connection.prepareStatement("insert into jtest (content, contentb) values (cast(? as json), cast(? as jsonb))"); //TODO
            statement.setString(1, listAsJson);
            statement.setString(2, listAsJson);
            statement.executeUpdate();
            closeStatement();
        }
    }

    @Override
    List<Item> find(int id) throws SQLException {
        String pStr = "";
        statement = connection.prepareStatement("select contentb from jtest where (id = cast(? as int))"); //TODO
        statement.setString(1, String.valueOf(id));
        resultSet = statement.executeQuery();
        while (resultSet.next()){
            pStr = resultSet.getString("contentb"); //TODO
            System.out.println(pStr);
        }
        closeConnection();
        Gson gson = new Gson();
        Item[] clst = gson.fromJson(pStr, Item[].class);
        statement = connection.prepareStatement("select contentb->0 as c from jtest "); //TODO
        resultSet = statement.executeQuery();
        while (resultSet.next()){
            pStr = resultSet.getString("c");
            System.out.println(pStr);
        }
        return Arrays.asList(clst);
    }
}
