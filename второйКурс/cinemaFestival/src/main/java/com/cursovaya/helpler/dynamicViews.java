package com.cursovaya.helpler;

import com.cursovaya.objects.user;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class dynamicViews {

    private dynamicViews(){

    }

    public static void loadBorderCenter(BorderPane borderPane, String resourses) {

        Parent dashboard = null;
        try {
            dashboard = FXMLLoader.load(new dynamicViews().getClass().getResource("/FXML/" + resourses));
            borderPane.setCenter(dashboard);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
