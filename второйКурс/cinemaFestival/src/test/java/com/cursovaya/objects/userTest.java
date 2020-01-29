package com.cursovaya.objects;

import com.cursovaya.interfaces.whois;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.SQLException;

public class userTest {

    static user a;

    @BeforeClass
    public static void init(){
        a = new user();
    }

    @Test
    public void add() throws SQLException {
//        a.setPass("1234");
//        a.setLogin("142");
//        a.setName("eq");
////        a.setSurname("saad");
//        a.setTypeUset(whois.guest);
//        a.addInfo();

    }
}