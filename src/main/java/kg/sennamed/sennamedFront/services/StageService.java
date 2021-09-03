package kg.sennamed.sennamedFront.services;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import kg.sennamed.sennamedFront.controller.PositionCtrl;

import java.io.IOException;

public class StageService {
    private static Stage stage = new Stage();
    private static Stage adminStage = new Stage();

    public static Stage getStage() {
        return stage;
    }

    public static Stage getAdminStage() {
        return adminStage;
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

    public void showAdminForm(String userName, String path) { // /layout/MainForm.fxml
        try {
            Parent root = FXMLLoader.load(getClass().getResource(path));
            adminStage.setScene(new Scene(root));
            adminStage.setTitle(userName);
            adminStage.show();
//            adminStage.getIcons().add(new Image(this.getClass().getResource("layout.img/sennamedLogo.jpg").toString()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showTestForm(String titleName, String path) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
            loader.load();
            stage.setScene(new Scene(loader.getRoot()));
            PositionCtrl controller = loader.getController();
            controller.initData(stage, new Users());
            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    refresh();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        stage.show();
    }
}
