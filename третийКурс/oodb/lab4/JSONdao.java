import com.google.gson.Gson;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class JSONdao extends DAO<Item> {
    @Override
    List<Item> load() throws SQLException {
        String pStr = "";
        statement = connection.prepareStatement("select content from jtest"); //TODO
        resultSet = statement.executeQuery();
        while (resultSet.next()){
            pStr = resultSet.getString("content"); //TODO
        }
        Gson gson = new Gson();
        Item[] clst = gson.fromJson(pStr, Item[].class);
        statement = connection.prepareStatement("select content->0 as c from jtest "); //TODO
        resultSet = statement.executeQuery();
        while (resultSet.next()){
            resultSet.getString("c");
        }
        closeStatement();
        return Arrays.asList(clst);
    }

    @Override
    void save(List<Item> list) throws SQLException {
        if (list != null && list.size() > 0){
            long startJSON = System.nanoTime();
            Gson gson = new Gson();
            String itemAsJson = gson.toJson(list);
            statement = connection.prepareStatement("insert into jtest (content, contentb) values (cast(? as json), cast(? as jsonb))"); //TODO
            statement.setString(1, itemAsJson);
            statement.setString(2, null);
            statement.executeUpdate();
            closeStatement();
            System.out.println("Время на json = " + (System.nanoTime() - startJSON));
            long startJSONB = System.nanoTime();
            statement = connection.prepareStatement("insert into jtest (content, contentb) values (cast(? as json), cast(? as jsonb))"); //TODO
            statement.setString(1, null);
            statement.setString(2, itemAsJson);
            statement.executeUpdate();
            statement.close();
            System.out.println("Время на jsonb = " + (System.nanoTime() - startJSONB));
        }
    }

    @Override
    List<Item> find(int id) throws SQLException {
        String pStr = "";
        statement = connection.prepareStatement("select content from jtest where (id = cast(? as int))"); //TODO
        statement.setString(1, String.valueOf(id));
        resultSet = statement.executeQuery();
        while (resultSet.next()){
            pStr = resultSet.getString("content"); //TODO
        }
        closeStatement();
        Gson gson = new Gson();
        Item[] clst = gson.fromJson(pStr, Item[].class);
        statement = connection.prepareStatement("select content->0 as c from jtest ");  //TODO
        resultSet = statement.executeQuery();
        while (resultSet.next()){
            pStr = resultSet.getString("c"); //TODO
        }
        return Arrays.asList(clst);
    }
}
