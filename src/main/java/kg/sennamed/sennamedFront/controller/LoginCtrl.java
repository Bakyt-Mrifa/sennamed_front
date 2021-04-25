package kg.sennamed.sennamedFront.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import kg.sennamed.sennamedFront.models.User;

import java.net.URL;
import java.util.ResourceBundle;


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
    void onBtnCliced(ActionEvent event) {
       if (event.getSource().equals(btnLogin)) {
           onLoginButton();
       } else if (event.getSource().equals(btnCancel)) {
           noCancelClicked();
       }
   }

    private void onLoginButton() {
       User user = new User();
       user.setUserName(txtLogin.getText());
       user.setUserPassword(txtPassword.getText());

    }

    private void noCancelClicked() {
       System.exit(0);
    }

}
