package com.cursovaya.start;

import com.cursovaya.objects.connection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Start extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        /*
        открытие сцены входа
         */
        connection.connect();
        Parent root = FXMLLoader.load(getClass().getResource("/FXML/login.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Вход");
        stage.setScene(scene);
        stage.show();
    }
}
