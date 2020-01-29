package com.cursovaya.helpler;

import com.cursovaya.objects.connection;
import com.cursovaya.objects.user;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class userUtils {
    public ObservableList<user> getInfo(String query) throws SQLException {
        ObservableList<user> list = FXCollections.observableArrayList();
        return list;
    }

    public static user findUser(int rowid) throws SQLException {
        String query = "select * from user where rowid = ?";
        connection.setStat(connection.getConn().prepareStatement(query));
        connection.getStat().setInt(1, rowid);
        ResultSet a = connection.getStat().executeQuery();
        a.next();
        return new user(a.getInt("rowid"),
                        a.getString("fio_f"),
                        a.getString("fio_i"),
                        a.getString("login"),
                        a.getString("pass"),
                        a.getInt("whois"),
                        a.getBoolean("isVoted"),
                        a.getBoolean("isRated"));
    }

    public static user findUser(String login) throws SQLException {
        String query = "select * from user where login = ?";
        connection.setStat(connection.getConn().prepareStatement(query));
        connection.getStat().setString(1, login);
        ResultSet a = connection.getStat().executeQuery();
        a.next();
        return new user(a.getInt("rowid"),
                a.getString("fio_f"),
                a.getString("fio_i"),
                a.getString("login"),
                a.getString("pass"),
                a.getInt("whois"),
                a.getBoolean("isVoted"),
                a.getBoolean("isRated"));
    }
}
