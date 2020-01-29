package com.cursovaya.helpler;

import com.cursovaya.objects.connection;
import com.cursovaya.objects.film;
import javafx.collections.ObservableList;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class filmUtilsTest {


    @Before
    public void initCon(){
        try {
            connection.connect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getInfo() throws SQLException {

        ObservableList<film> a = filmUtils.getInfo("select * from film;");
        System.out.println(a.get(0).getName());
    }

    @Test
    public void addVoice() {
        film a = filmUtils.getInfo("select * from film where rowid = 3").get(0);
//        filmUtils.addVoice(a);
    }
}