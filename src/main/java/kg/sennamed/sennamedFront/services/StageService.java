package kg.sennamed.sennamedFront.services;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StageService {
    private static Stage stage = new Stage();

    public static Stage getStage() {
        return stage;
    }

    public void showForm(String userName, String path) { // /layout/MainForm.fxml
        try {
            Parent root = FXMLLoader.load(getClass().getResource(path));
            stage.setScene(new Scene(root));
            stage.setTitle(userName);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
