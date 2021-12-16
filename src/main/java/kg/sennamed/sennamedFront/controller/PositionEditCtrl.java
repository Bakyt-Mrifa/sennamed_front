package kg.sennamed.sennamedFront.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import kg.sennamed.sennamedFront.http.PositionHttpRequest;
import kg.sennamed.sennamedFront.models.Position;
import kg.sennamed.sennamedFront.models.Result;
import kg.sennamed.sennamedFront.services.StageService;

import java.io.IOException;

public class PositionEditCtrl {
    private Stage stage;
    private Position position;
    private PositionHttpRequest positionHttpRequest;
    private Result result;

    @FXML
    private TextField txtPosition;

    @FXML
    private TextField txtSpeciality;

    @FXML
    private CheckBox chbxActive;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnCancel;

    @FXML
    void onButtonClicked(ActionEvent event) throws IOException {
        if (event.getSource().equals(btnSave)){
            onSaveButton();
         }else if (event.getSource().equals(btnCancel)){
            onCloseButton();
        }

    }

    private void onCloseButton() {
        StageService stageService=new StageService();
        stageService.getTestStage().fireEvent(new WindowEvent(stage, WindowEvent.WINDOW_CLOSE_REQUEST));

    }

    private void onSaveButton() throws IOException {
        String positionName=txtPosition.getText();
        String speciality=txtSpeciality.getText();
        boolean active=chbxActive.isSelected();

        position.setPosition(positionName);
        position.setSpeciality(speciality);
        position.setActive(active);
        positionHttpRequest.INSTANCE.savePosition(position);

        clearFields();
        PositionCtrl positionCtrl=new PositionCtrl();
        positionCtrl.initTableView();
    }


    public void initData(Stage stage, Position position){
        this.stage=stage;
        this.position=position;

        if (position.getId()!=null){
            txtPosition.setText(position.getPosition());
            txtSpeciality.setText(position.getSpeciality());
            chbxActive.setSelected(position.isActive());
        }
    }
    private void clearFields() {
        txtPosition.clear();
        txtSpeciality.clear();
        chbxActive.setSelected(false);
        txtPosition.requestFocus();
    }

}
