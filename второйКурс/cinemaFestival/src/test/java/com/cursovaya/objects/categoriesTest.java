package com.cursovaya.objects;

import javafx.collections.ObservableList;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class categoriesTest {

    static categories a;

    @BeforeClass
    public static void initCon() throws SQLException {
        a = new categories();
    }

    @Test
    public void connectToDb() throws SQLException {
//        ArrayList<categories> b = a.getInfo();
//        b.forEach(n -> System.out.println(n.getName()));
    }
}