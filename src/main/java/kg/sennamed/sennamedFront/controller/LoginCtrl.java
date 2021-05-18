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
import kg.sennamed.sennamedFront.services.LoginService;

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


        //  btnLogin.getScene().getWindow().hide();

        Account account = new Account();
        account.setLogin(txtLogin.getText().trim());
        account.setPassword(txtPassword.getText().trim());
        System.out.println(account);
        User user = LoginHttpRequest.INSTANCE.getUserObject(account);
        System.out.println(user + " USer!");


        if (user.getRole().equals(Role.admin)) {
            System.out.println("Вы администратор!");
            btnLogin.getScene().getWindow().hide();
            showMainForm(user.getName());

            /*if (user.is) {
                Alert message = new Alert(Alert.AlertType.ERROR);
                message.setHeaderText("Ошибка авторизации");
                message.setContentText("Пользователь не активен, обратитесь к администратору");
                message.showAndWait();
            }
            if (admin) {
                showMainForm(account.getLogin());
            }
            if (user) {
                showUserForm();
            }*/


        }
    }

    private void showMainForm(String userName) { // /layout/MainForm.fxml
        Stage stage = new Stage();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/layout/MainForm.fxml"));
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