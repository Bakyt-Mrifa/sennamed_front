package kg.sennamed.sennamedFront.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import kg.sennamed.sennamedFront.http.HttpRequests;
import kg.sennamed.sennamedFront.models.Position;
import kg.sennamed.sennamedFront.services.StageService;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class PositionCtrl {
    private String path;
    private StageService stageService = new StageService();
    private int serialNum=0;
    private HttpRequests httpRequests;

    @FXML
    private TableView<Position> tbPoston;

    @FXML   
    private TableColumn<Integer,Integer> colmSN;

    @FXML
    private TableColumn<Position, String> colmPosition;

    @FXML
    private TableColumn<Position, String> colmSpeciality;

    @FXML
    private TableColumn<Position, Boolean> colmActive;

    @FXML
    private Button btnRemove;

    @FXML
    private Button btnEdit;

    @FXML
    private Button btnAdd;

    @FXML
    void OnBtnClicked(ActionEvent event) throws IOException {
        if (event.getSource().equals(btnAdd)){
            addNewPosition();
        } else if (event.getSource().equals(btnEdit)){
            editCurrentPosition();
        }else if (event.getSource().equals(btnRemove)){
            removePosition();
        }
    }



    private void removePosition() {
        ButtonType buttonTypeYes=new ButtonType("Да");
        ButtonType buttonTypeNo=new ButtonType("Отмена", ButtonBar.ButtonData.CANCEL_CLOSE);
        if (tbPoston.getSelectionModel().getSelectedItem()!=null){
            Alert message=new Alert(Alert.AlertType.CONFIRMATION);
            message.setTitle("Внимание!!!");
            message.setHeaderText("Действительно хотите удалить?");
            message.setContentText("Подтвердите действие - \"удалить должность?\"");
            message.getButtonTypes().setAll(buttonTypeYes,buttonTypeNo);
            Optional<ButtonType> result=message.showAndWait();
            if (result.get()==buttonTypeYes){
                tbPoston.getItems().removeAll(tbPoston.getSelectionModel().getSelectedItem());
            }else {
                System.out.println("The event canceled");
            }
        }




    }

    private void editCurrentPosition() {
    }

    private void addNewPosition() {

        path = "/layout/PositionEditForm.fxml";
        //btnGo.getScene().getWindow().hide();
        stageService.showForm(stageService.getAdminStage().getTitle(), path);
    }

    @FXML
    void initialize() throws IOException {

        colmSN.setCellValueFactory(new PropertyValueFactory<>("id"));
        colmPosition.setCellValueFactory(new PropertyValueFactory<>("position"));
        colmSpeciality.setCellValueFactory(new PropertyValueFactory<>("speciality"));
        colmActive.setCellValueFactory(new PropertyValueFactory<>("isActive"));

        tbPoston.setRowFactory(param -> new TableRow<Position>(){
            protected void updateItem(Position item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {

                    setStyle("-fx-control-inner-background: derive(-fx-base, 80%);");
                } else {
                    if (item.equals(false)) {//???????????????????
                        setStyle("-fx-control-inner-background: lightgrey");
                    } else {
                        setStyle("-fx-control-inner-background: derive(-fx-base, 80%);");
                    }
                }
            }
        });



        refresh();
    }
    private void refresh() throws IOException {
 /*       List<Position> positionList = (List<Position>) httpRequests.getRequests("position/getList").getObject();
        ObservableList<Position> observableList = FXCollections.observableList(positionList);
        tbPoston.setItems(observableList);
    */}


}
