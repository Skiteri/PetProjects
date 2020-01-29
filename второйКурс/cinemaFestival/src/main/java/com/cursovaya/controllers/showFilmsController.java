package com.cursovaya.controllers;

import com.cursovaya.helpler.dynamicViews;
import com.cursovaya.objects.user;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class showFilmsController implements Initializable {

    private static user current;

    public static user getCurrent() {
        return current;
    }

    public void setCurrent(user current) {
        this.current = current;
    }

    @FXML
    private BorderPane border_pane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dynamicViews.loadBorderCenter(border_pane, "person.fxml");
    }

    @FXML
    public void show_cabinet(MouseEvent mouseEvent) {
        dynamicViews.loadBorderCenter(border_pane, "person.fxml");
    }

    @FXML
    public void show_films(MouseEvent mouseEvent){
        dynamicViews.loadBorderCenter(border_pane, "showList.fxml");
    }

    @FXML
    public void show_results(MouseEvent mouseEvent) {
        dynamicViews.loadBorderCenter(border_pane, "result.fxml");
    }

    @FXML
    public void show_categories(MouseEvent mouseEvent) {
    dynamicViews.loadBorderCenter(border_pane, "categoryList.fxml");
    }
}
