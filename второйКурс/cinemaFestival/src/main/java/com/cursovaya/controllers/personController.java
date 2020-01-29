package com.cursovaya.controllers;

import com.cursovaya.objects.user;
import com.cursovaya.start.Start;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class personController implements Initializable {
    public Button exit;
    public Text login;
    public user usr;
    public TextField surname;
    public TextField name;
    public PasswordField currentPass;
    public PasswordField newPass;
    public PasswordField repeatPass;
    public Label status;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        usr = showFilmsController.getCurrent();
        System.out.println(usr.getLogin());
        login.setText(usr.getLogin());
        surname.setText(usr.getSurname());
        name.setText(usr.getName());
        status.setText(usr.getTypeUset().action());
    }

    public void saveChanges(ActionEvent actionEvent) {
    }

    public void exitClicked(ActionEvent actionEvent) throws IOException {
        Stage stage1 = (Stage) exit.getScene().getWindow();
        stage1.close();
        Stage stage = new Stage();
        stage.setTitle("Вход");
        Parent root = FXMLLoader.load(getClass().getResource("/FXML/login.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
