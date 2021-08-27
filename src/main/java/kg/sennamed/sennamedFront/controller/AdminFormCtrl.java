package kg.sennamed.sennamedFront.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import kg.sennamed.sennamedFront.models.enums.Dictionaries;
import kg.sennamed.sennamedFront.services.StageService;

import java.io.IOException;

public class AdminFormCtrl {

    private String path;
    private StageService stageService = new StageService();

    @FXML
    private ComboBox<Dictionaries> cmbxDic;

    @FXML
    private Button btnGo;

    @FXML
    void onBtnCliced(ActionEvent event) throws IOException {
        if (event.getSource().equals(btnGo)) {
            onGoButtonClicked();
        }
    }

    private void onGoButtonClicked() {

//
        if (cmbxDic.getSelectionModel().getSelectedItem().equals(Dictionaries.CUSTOMERS)) {
            path = "/layout/CustomerManagementForm.fxml";
            btnGo.getScene().getWindow().hide();
            stageService.showForm(stageService.getStage().getTitle(), path);
        }
        if (cmbxDic.getSelectionModel().getSelectedItem().equals(Dictionaries.USERS)) {
            path = "/layout/UserManagementForm.fxml";
            btnGo.getScene().getWindow().hide();
            stageService.showForm(stageService.getStage().getTitle(), path);
        }
        if (cmbxDic.getSelectionModel().getSelectedItem().equals(Dictionaries.POSITIONS)) {
            path = "/layout/PositionForm.fxml";
            btnGo.getScene().getWindow().hide();
            stageService.showForm(stageService.getStage().getTitle(), path);
        }
    }

    @FXML
    void initialize() {

        cmbxDic.setItems(FXCollections.observableArrayList(Dictionaries.values()));
        System.out.println("value of " + cmbxDic.getItems().setAll(Dictionaries.values()));
        cmbxDic.getItems().setAll(Dictionaries.values());

    }

}
