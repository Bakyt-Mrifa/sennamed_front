package kg.sennamed.sennamedFront.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import kg.sennamed.sennamedFront.http.LoginHttpRequest;
import kg.sennamed.sennamedFront.models.Account;
import kg.sennamed.sennamedFront.models.User;
import kg.sennamed.sennamedFront.models.enums.Role;
import kg.sennamed.sennamedFront.services.StageService;

import java.io.IOException;

public class LoginCtrl {
    private StageService stageService = new StageService();
    private User user = new User();
    private String path;

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
        user = LoginHttpRequest.INSTANCE.getUserObject(account);
        System.out.println(user + " User!");


        if (user.getRole().equals(Role.admin)) {
            path = "/layout/AdminForm.fxml";
            System.out.println("Вы администратор!"); //тест
            btnLogin.getScene().getWindow().hide();
            stageService.showForm("SennaMed :: Пользователь  - " + user.getName(), path);
        }

        if (user.getRole().equals(Role.operator)) {
            path = "/layout/CustomerManagementForm.fxml";
            System.out.println("Вы оператор!");
            btnLogin.getScene().getWindow().hide();
            stageService.showForm("SennaMed :: Пользователь  - " + user.getName(), path);

        }
    }


    private void onCancelBtnClicked() {
        System.exit(0);
    }


}