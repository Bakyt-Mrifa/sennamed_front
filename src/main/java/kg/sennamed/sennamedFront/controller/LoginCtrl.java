package kg.sennamed.sennamedFront.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import kg.sennamed.sennamedFront.http.LoginHttpRequest;
import kg.sennamed.sennamedFront.models.Account;
import kg.sennamed.sennamedFront.models.Role;
import kg.sennamed.sennamedFront.models.User;

import java.io.IOException;

public class LoginCtrl {

    @FXML
    private TextField txtLogin;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private Button btnLogin;

    @FXML
    private Button btnCancel;

    @FXML
    private ImageView imgViewLogo;

    @FXML
    void onBtnCliced(ActionEvent event) throws IOException {
        if (event.getSource().equals(btnLogin)) {
            onLoginButtonClicked();
        } else if (event.getSource().equals(btnCancel)) {
            onCancelBtnClicked();
        }
    }

    private void onLoginButtonClicked() throws IOException {


        Account account = new Account();
        account.setLogin(txtLogin.getText().trim());
        account.setPassword(txtPassword.getText().trim());
        System.out.println(account);
        User user = LoginHttpRequest.INSTANCE.getUserObject(account);
        System.out.println(user + " User!");


        if (user.getRole().equals(Role.admin)) {
            String path = "/layout/AdminForm.fxml";
            System.out.println("Вы администратор!"); //тест
            btnLogin.getScene().getWindow().hide();
            showForm(user.getName(), path);
        }

        if (user.getRole().equals(Role.operator)) {
            String path = "/layout/CustomerManagementForm.fxml";
            System.out.println("Вы оператор!");
            btnLogin.getScene().getWindow().hide();
            showForm(user.getName(), path);

        }
    }

    private void showForm(String userName, String path) { // /layout/MainForm.fxml
        Stage stage = new Stage();
        try {
            Parent root = FXMLLoader.load(getClass().getResource(path));
            stage.setScene(new Scene(root));
            stage.setTitle("SennaMed :: Пользователь  - " + userName);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void onCancelBtnClicked() {
        System.exit(0);
    }


}