package com.cursovaya.start;

import com.cursovaya.objects.connection;
import javafx.application.Application;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Application.launch(Start.class, args);
        try {
            connection.closeDB();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
