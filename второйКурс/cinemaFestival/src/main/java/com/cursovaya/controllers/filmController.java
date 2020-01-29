package com.cursovaya.controllers;

import com.cursovaya.objects.categories;
import com.cursovaya.objects.film;
import com.cursovaya.objects.user;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class filmController implements Initializable {

    private film newMovie;
    private ArrayList<categories> list;
    private user usr;
    private Stage stage;

    public void setUsr(user usr) {
        this.usr = usr;
    }

    @FXML
    public TextField filmName;
    @FXML
    public Button cancel;
    @FXML
    public Button Reg;
    @FXML
    public ChoiceBox choiceCat;
    @FXML
    public TextArea describing;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /*
        Создается фильм и заполняется choiseBox
         */
    newMovie = new film();
    newMovie.setCategories(new categories());
        try {
            list = newMovie.getCategories().getInfo("select * from categories;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        list.forEach(n -> choiceCat.getItems().add(n.getName()));
        choiceCat.setValue(list.get(0).getName());
    }

    @FXML
    public void clickReg(ActionEvent actionEvent) throws SQLException {
        /*
        Проверяется название фильма, добавляется пользователь,
         */
        if (!filmName.getText().equals("")){
            usr.addInfo();

            newMovie.setName(filmName.getText());
            newMovie.setDirector(usr);
            newMovie.setCategories(list.get(choiceCat.getSelectionModel().getSelectedIndex()));
            newMovie.setDescribing(describing.getText());
            newMovie.addInfo();

            Alert alert = new Alert(Alert.AlertType.NONE);
            alert.setTitle("Регистрация");
            alert.setContentText("Участник зарегистрирован");
            alert.getDialogPane().getButtonTypes().add(ButtonType.OK);
            alert.showAndWait();

            stage.close();
        } else
        {
            Alert alert = new Alert(Alert.AlertType.NONE);
            alert.setTitle("Название");
            alert.setContentText("Введите название фильма");
            alert.getDialogPane().getButtonTypes().add(ButtonType.OK);
            alert.showAndWait();
        }
    }

    @FXML
    public void clickCancel(ActionEvent actionEvent) {
        stage.close();
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

}
