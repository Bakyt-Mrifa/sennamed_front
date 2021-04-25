package kg.sennamed.sennamedFront.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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
           System.out.println("login clicked");
       } else if (event.getSource().equals(btnCancel)) {
           System.out.println("Cancel button clicked");
       }
   }

}
