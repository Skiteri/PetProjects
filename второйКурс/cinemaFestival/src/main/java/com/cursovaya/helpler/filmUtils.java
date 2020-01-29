package com.cursovaya.helpler;

import com.cursovaya.objects.connection;
import com.cursovaya.objects.film;
import com.cursovaya.objects.user;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class filmUtils{

     public static ObservableList<film> getInfo(String query) {
         try {
             ObservableList<film> list = FXCollections.observableArrayList();
             connection.setStat(connection.getConn().prepareStatement(query));
             ResultSet a = connection.getStat().executeQuery();
             while (a.next()){
                 list.add(new film(a.getInt("rowid"),
                                    a.getString("film_name"),
                                    userUtils.findUser(a.getInt("user_id")),
                                    categoryUtils.findCategory(a.getInt("category")),
                                    a.getInt("Rate"),
                                    a.getInt("votes"),
                                    a.getString("describe"),
                                    a.getInt("userVoted")));
             }
             return list;
         } catch (SQLException e) {
             return null;
         }
     }

     public static void addVoice(film a, user user){
         try{
             String query = "UPDATE `film` SET `votes` = ? WHERE rowid = ?;";
             connection.setStat(connection.getConn().prepareStatement(query));
             int b = a.getVotes() + 1;
             connection.getStat().setInt(1,b);
             connection.getStat().setInt(2,a.getRowid());
             connection.getStat().executeUpdate();
             query = "UPDATE `user` SET `isVoted` = ? WHERE rowid = ?;";
             connection.setStat(connection.getConn().prepareStatement(query));
             connection.getStat().setInt(1, 1);
             connection.getStat().setInt(2, user.getRowid());
             connection.getStat().executeUpdate();
         } catch (SQLException e){

         }
     }
}
