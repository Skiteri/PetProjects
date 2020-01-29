package com.cursovaya.objects;

import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class userTest2 {

    @Test
    public void getInfo() throws SQLException {
        user newU = new user("123", "dwd");
//        newU.setRowid(newU.getInfo());

//        System.out.println(newU.getInfo());
    }
}