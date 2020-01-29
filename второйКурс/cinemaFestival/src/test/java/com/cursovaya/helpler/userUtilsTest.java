package com.cursovaya.helpler;

import com.cursovaya.objects.connection;
import com.cursovaya.objects.user;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class userUtilsTest {

    @Test
    public void findUser() throws SQLException {
        connection.connect();
        user a = userUtils.findUser(17);
        System.out.println(a.getLogin());
    }
}