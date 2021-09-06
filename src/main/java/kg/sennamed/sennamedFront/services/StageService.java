package kg.sennamed.sennamedFront.services;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import kg.sennamed.sennamedFront.controller.PositionEditCtrl;
import kg.sennamed.sennamedFront.models.Position;

import java.io.IOException;

public class StageService {
    private static Stage stage = new Stage();
    private static Stage adminStage = new Stage();
    private static Stage testStage = new Stage();

    public static Stage getStage() {
        return stage;
    }

    public static Stage getAdminStage() {
        return adminStage;
    }

    public static Stage getTestStage() {
        return testStage;
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

    public void showTestForm(String titleName, String path) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
            loader.load();
            testStage.setScene(new Scene(loader.getRoot()));
            PositionEditCtrl controller = loader.getController();
            controller.initData(stage,new Position());
            testStage.setTitle(titleName);
            testStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
//                    refresh();
                    System.out.println("Stage closed!");
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        testStage.show();
    }
}
