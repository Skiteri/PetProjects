package com.cursovaya.objects;

import com.cursovaya.interfaces.workWithDb;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class categories implements workWithDb {

    private Integer rowid;
    private String name;


    public categories(){
    }

    public categories(Integer rowid, String name) {
        this.rowid = rowid;
        this.name = name;
    }

    public Integer getRowid() {
        return rowid;
    }

    public void setRowid(Integer rowid) {
        this.rowid = rowid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void addInfo() throws SQLException {

    }

    @Override
    public void removeInfo() {

    }

    @Override
    public ArrayList<categories> getInfo(String query) throws SQLException {
        /*
        вернуть список
         */
         ArrayList<categories> list = new ArrayList<categories>();
         connection.setStat(connection.getConn().prepareStatement(query));
         ResultSet a = connection.getStat().executeQuery();
         while (a.next()){
             list.add(new categories(a.getInt("rowid"), a.getString("name_category")));
         }
         return list;
    }

    @Override
    public boolean isItExist(String query) throws SQLException {
        return false;
    }

    @Override
    public String getArtefact() {
        return null;
    }

}
