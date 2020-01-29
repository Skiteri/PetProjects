package com.cursovaya.helpler;

import com.cursovaya.objects.categories;
import com.cursovaya.objects.connection;
import com.cursovaya.objects.user;
import javafx.fxml.FXML;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class categoryUtilsTest {

    @Before
    public void init(){
        try {
            connection.connect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findCategory() throws SQLException {
        categories a = categoryUtils.findCategory(2);
        System.out.println(a.getRowid() + " " + a.getName());
    }

    @Test
    public void getInfo() {
        System.out.println(categoryUtils.getInfo("SELECT * From categories;").get(0).getRowid());
    }
}