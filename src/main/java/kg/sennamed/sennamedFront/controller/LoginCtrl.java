package kg.sennamed.sennamedFront.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
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
       User user = new User();
       user.setUserName(txtLogin.getText().trim());
       user.setUserPassword(txtPassword.getText().trim());
       boolean result=true; //test stage
        System.out.println(user);
      // boolean result=LoginService.INSTANCE.login(user.getUserName(),user.getUserPassword());
       if(result){
           System.out.println("Успешно!");
           btnLogin.getScene().getWindow().hide();
           showMainForm();
       }

    }

    private void showMainForm() { // /layout/MainForm.fxml
        Stage stage=new Stage();
        try {
            Parent root=FXMLLoader.load(getClass().getResource("/layout/MainForm.fxml"));
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void onCancelBtnClicked() {
       System.exit(0);
    }

}
