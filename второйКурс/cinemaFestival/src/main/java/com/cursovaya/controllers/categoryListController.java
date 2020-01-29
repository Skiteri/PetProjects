package com.cursovaya.controllers;

import com.cursovaya.helpler.categoryUtils;
import com.cursovaya.helpler.filmUtils;
import com.cursovaya.objects.categories;
import com.cursovaya.objects.film;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class categoryListController implements Initializable {


    private ObservableList<categories> Data = FXCollections.observableArrayList();
    private ObservableList<film> DataFilm = FXCollections.observableArrayList();


    public Label nameCat;
    public TableView<categories> CatalogTable;
    public TableColumn<categories,String> catalogId;
    public TableView<film> filmCat;
    public TableColumn<film,String> filmId;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        showFilm(null);
        Data = categoryUtils.getInfo("SELECT * From categories;");
        catalogId.setCellValueFactory(new PropertyValueFactory<>("name"));
        CatalogTable.setItems(Data);
        CatalogTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showFilm(newValue));
    }
    private void showFilm(categories current){
        if (current != null){
            nameCat.setText(current.getName());
            DataFilm = filmUtils.getInfo("Select * from film where category = " + current.getRowid() + ";");
            filmId.setCellValueFactory(new PropertyValueFactory<>("name"));
            filmCat.setItems(DataFilm);
        }
    }
}
