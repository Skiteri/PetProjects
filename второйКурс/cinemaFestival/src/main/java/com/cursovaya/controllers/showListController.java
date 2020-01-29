package com.cursovaya.controllers;

import com.cursovaya.helpler.filmUtils;
import com.cursovaya.objects.film;
import com.cursovaya.objects.user;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.ResourceBundle;

public class showListController implements Initializable {


    private ObservableList<film> Data = FXCollections.observableArrayList();
    private film selectedFilm;
    private user usr;

    @FXML
    private TableView<film> CatalogTable;

    @FXML
    private TableColumn<film, String> filmId;

    @FXML
    private Label filmName;

    @FXML
    private Label category;

    @FXML
    public TextArea describe;

    @FXML
    private ComboBox<Integer> mark;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        usr = showFilmsController.getCurrent();
        Data = filmUtils.getInfo("Select * from film;");
        filmId.setCellValueFactory(new PropertyValueFactory<>("name"));
        CatalogTable.setItems(Data);
        showFilm(null);
        CatalogTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showFilm(newValue)
        );

        ObservableList<Integer> s = FXCollections.observableArrayList();
        Collections.addAll(s,1,2,3,4,5,6,7,8,9,10);
        mark.setItems(s);
    }

    private void showFilm(film a){
        if (a != null){
            selectedFilm = a;
            filmName.setText(a.getName());
            category.setText(a.getCategories().getName());
            describe.setText(a.getDescribing());
            mark.setVisible(true);
        } else {
            filmName.setText("Выберите фильм");
            category.setText("");
            describe.setText("");
            mark.setVisible(false);
        }
    }

    @FXML
    public void addVoice(ActionEvent actionEvent) {
        if (!usr.isVoted()) {
            filmUtils.addVoice(selectedFilm, usr);
            usr.setVoted(true);
        }
    }
}
