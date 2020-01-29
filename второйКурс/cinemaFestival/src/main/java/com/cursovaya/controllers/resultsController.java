package com.cursovaya.controllers;

import com.cursovaya.helpler.categoryUtils;
import com.cursovaya.helpler.filmUtils;
import com.cursovaya.objects.categories;
import com.cursovaya.objects.film;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class resultsController implements Initializable {

    private ObservableList<categories> Data = FXCollections.observableArrayList();

    @FXML
    private TableView<categories> catalog;

    @FXML
    private TableColumn<categories, String> filmList;

@FXML
    public Label nameFilm;

@FXML
    public Label votes;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        votes.setText("0");
        nameFilm.setText("Номинации");
        Data = categoryUtils.getInfo("SELECT * From categories;");
        filmList.setCellValueFactory(new PropertyValueFactory<>("name"));
        catalog.setItems(Data);
        catalog.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showFilm(newValue));
    }

    private void showFilm(categories cat){
        try {
            film a = filmUtils.getInfo("select * from film where votes = (select max(votes) from film where category = " +
                    cat.getRowid() + ");").get(0);
        nameFilm.setText(a.getName());
        votes.setText(a.getVotes().toString());
        } catch (Exception e){
            nameFilm.setText("Нет победителя");
            votes.setText("0");
        }
    }
}
