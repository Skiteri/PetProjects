package com.cursovaya.objects;

import javafx.collections.ObservableList;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class filmTest {
    private static film a;

    @BeforeClass
    public static void initCon() throws SQLException {
        a = new film();
    }

    @Test
    public void addInfo() throws SQLException {
//        a.setName("ge");
//        categories b = new categories();
//        b.setName("rteg");
//        b.setRowid(11);
//        a.setCategories(b);
////        a.setDirector();
//        a.addInfo();
    }
}