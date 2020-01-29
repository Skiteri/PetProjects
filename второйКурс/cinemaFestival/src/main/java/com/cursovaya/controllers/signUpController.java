package com.cursovaya.controllers;

import com.cursovaya.interfaces.whois;
import com.cursovaya.objects.user;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class signUpController implements Initializable {

    private user current;

    public TextField FirstName;
    public TextField LastName;
    public TextField Login;
    public PasswordField Password;
    public PasswordField repeatPassword;
    public CheckBox isChosen;
    public Button closeButton;
    public Button signUpButtonSignUp;

    public void initialize(URL location, ResourceBundle resources) {

    }
@FXML
    public void handleButtonAction1(ActionEvent actionEvent) throws SQLException, IOException {
    current = new user(Login.getText(), Password.getText());
    boolean isExist = current.isItExist("SELECT * FROM user where login = ?"),
            checkPass = Password.getText().equals(repeatPassword.getText());
//        System.out.println(checkPass);
    if (Login.getText().equals("")){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Ошибка");
        alert.setHeaderText("Сообщение об ошибке");
        alert.setContentText("Введите логин");
        alert.showAndWait();
    } else if (!checkPass){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Ошибка");
        alert.setHeaderText("Сообщение об ошибке");
        alert.setContentText("Введенные пароли не совпадают");
        alert.showAndWait();
    } else if (isExist){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Ошибка");
        alert.setHeaderText("Сообщение об ошибке");
        alert.setContentText("Пользователь с таким логином уже существует");
        alert.showAndWait();
    } else if (Password.getText().equals("")){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Ошибка");
        alert.setHeaderText("Сообщение об ошибке");
        alert.setContentText("Введите пароль");
        alert.showAndWait();
    } else if (isChosen.isSelected()) {

        current.setName(FirstName.getText());
        current.setSurname(LastName.getText());
        current.setTypeUset(whois.participant);

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(filmController.class.getResource("/FXML/film.fxml"));
        VBox page = loader.load();

        Stage stage = new Stage();
        stage.setTitle("Фильм");
        Scene scene = new Scene(page);
        stage.setScene(scene);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(null);

        filmController films = loader.getController();
        films.setStage(stage);
        films.setUsr(current);

        stage.showAndWait();

        handleButtonAction2(actionEvent);

    } else
        {
            if (FirstName.getText() != "") {
            current.setName(FirstName.getText());
            }
        if (LastName.getText() != "") {
            current.setSurname(LastName.getText());
        }
        current.setTypeUset(whois.guest);
        current.addInfo();
        Alert alert = new Alert(Alert.AlertType.NONE);
        alert.setTitle("Регистрация");
        alert.setContentText("Пользователь зарегистрирован");
        alert.getDialogPane().getButtonTypes().add(ButtonType.OK);
        alert.showAndWait();
        handleButtonAction2(actionEvent);
        }
    }
@FXML
    public void handleButtonAction2(ActionEvent actionEvent) throws IOException {
        Stage stage1 = (Stage) closeButton.getScene().getWindow();
        stage1.close();
        Stage stage = new Stage();
        stage.setTitle("Вход");
        Parent root = FXMLLoader.load(getClass().getResource("/FXML/login.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

//    public boolean
}
