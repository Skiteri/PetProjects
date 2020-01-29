package com.cursovaya.interfaces;

import com.cursovaya.objects.film;
import com.cursovaya.objects.user;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.ArrayList;

public interface workWithDb<T> {

    void addInfo() throws SQLException; // добавить информацию в базу данных

    void removeInfo(); // удалить информацию

    ArrayList<film> getInfo(String query) throws SQLException;

    boolean isItExist(String query) throws SQLException; // существует ли информация об объекте в базе данных

    String getArtefact();
}
