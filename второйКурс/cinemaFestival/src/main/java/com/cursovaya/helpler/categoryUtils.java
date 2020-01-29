package com.cursovaya.helpler;

import com.cursovaya.objects.categories;
import com.cursovaya.objects.connection;
import com.cursovaya.objects.film;
import com.cursovaya.objects.user;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class categoryUtils {
    public static ObservableList<categories> getInfo(String query) {
        try {
            ObservableList<categories> list = FXCollections.observableArrayList();
            connection.setStat(connection.getConn().prepareStatement(query));
            ResultSet a = connection.getStat().executeQuery();
            while (a.next()) {
                list.add(new categories(a.getInt("rowid"),
                        a.getString("name_category")));
            }
            return list;
        } catch (SQLException e) {
            return null;
        }
    }
    public static categories findCategory(int rowid) throws SQLException {
        String query = "select * from categories where rowid = ?;";
        connection.setStat(connection.getConn().prepareStatement(query));
        connection.getStat().setInt(1, rowid);
        ResultSet s = connection.getStat().executeQuery();
        if (s.next())
        return new categories(s.getInt("rowid"),
                s.getString("name_category"));
        else return null;
    }
}
