package com.cursovaya.controllers;

import com.cursovaya.helpler.userUtils;
import com.cursovaya.objects.user;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class loginController implements Initializable {
    @FXML
    private TextField TextField1;
    @FXML
    private TextField TextField2;
    @FXML
    private Hyperlink HyperLink1;
    @FXML
    private Button buttonAction1;

    @FXML
    public void logined(ActionEvent actionEvent) throws SQLException, IOException {
        /*
        при нажатие кнопки войти проверяется связка логин-пароля, если все верно перейти
         */
        user current = new user(TextField1.getText(), TextField2.getText());

            if (current.isItExist("SELECT login, pass from user " +
                        "where login = ? and pass = ?;")){
                Stage stage1 = (Stage) buttonAction1.getScene().getWindow();
                stage1.close();

                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(filmController.class.getResource("/FXML/showFilms.fxml"));
                BorderPane page = loader.load();

                Stage stage = new Stage();
                stage.setTitle("Фестиваль фильмов");
                Scene scene = new Scene(page);
                stage.setScene(scene);
                stage.initModality(Modality.WINDOW_MODAL);
                stage.initOwner(null);

                showFilmsController films = loader.getController();
                current = userUtils.findUser(current.getLogin());
                films.setCurrent(current);

                stage.show();


            }
    }

    @FXML
    public void cancelAction(ActionEvent actionEvent) {
        /*
        при нажатии кнопки "отмена", отчистить поля логина и пароля
         */
        TextField1.clear();
        TextField2.clear();
    }

    @FXML
    public void signUpAction(ActionEvent actionEvent) throws IOException {
        /*
        при нажатии кнопки "отмена", отчистить поля логина и пароля
         */
        Stage stage1 = (Stage) HyperLink1.getScene().getWindow();
        stage1.close();
        Stage stage = new Stage();
        stage.setTitle("Регистрация");
        Parent root = FXMLLoader.load(getClass().getResource("/FXML/signUp.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void initialize(URL location, ResourceBundle resources) {

    }
}
