package kg.sennamed.sennamedFront.controller;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import kg.sennamed.sennamedFront.http.HttpRequests;
import kg.sennamed.sennamedFront.http.PositionHttpRequest;

import kg.sennamed.sennamedFront.models.Position;
import kg.sennamed.sennamedFront.services.StageService;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class PositionCtrl {
    private Stage stage;
    private Position position;
    private String path;
    private StageService stageService = new StageService();
    private int serialNum = 0;
    private HttpRequests httpRequests = new HttpRequests();
    private PositionHttpRequest positionHttpRequest;


    @FXML
    private TableView<Position> tbPoston;

    @FXML
    private TableColumn<Integer, Long> colmSN;

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
        if (event.getSource().equals(btnAdd)) {
            addNewPosition();
        } else if (event.getSource().equals(btnEdit)) {
            editCurrentPosition();
        } else if (event.getSource().equals(btnRemove)) {
            removePosition();
        }
    }


    private void removePosition() throws IOException {
        ButtonType buttonTypeYes = new ButtonType("Да");
        ButtonType buttonTypeNo = new ButtonType("Отмена", ButtonBar.ButtonData.CANCEL_CLOSE);
        if (tbPoston.getSelectionModel().getSelectedItem() != null) {
            Alert message = new Alert(Alert.AlertType.CONFIRMATION);
            message.setTitle("Внимание!!!");
            message.setHeaderText("Действительно хотите удалить?");
            message.setContentText("Подтвердите действие - \"удалить должность?\"");
            message.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);
            Optional<ButtonType> result = message.showAndWait();
            if (result.get() == buttonTypeYes) {
                System.out.println("Deleted: "+tbPoston.getSelectionModel().getSelectedItem());
               Position posit=tbPoston.getSelectionModel().getSelectedItem();
                System.out.println(posit);
                positionHttpRequest.INSTANCE.removePosition(posit);
            } else {
                System.out.println("The event canceled");
            }
        }


    }

    private void editCurrentPosition() {

    }

    private void addNewPosition() {

        path = "/layout/PositionEditForm.fxml";
        //btnGo.getScene().getWindow().hide();
        stageService.showTestForm(stageService.getAdminStage().getTitle(), path);
        }


    @FXML
    void initialize() throws IOException {

        initData();
        initTableView();


       /*ObservableList <Position> observableList=FXCollections.observableArrayList(positionHttpRequest.INSTANCE.getPositionList());

        tbPoston.setItems(observableList);*/
        /*tbPositon.setRowFactory(param -> new TableRow<Position>(){
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


*/
        //refresh();
    }

    public void initTableView() throws IOException {
        List <Position> positions=FXCollections.observableArrayList(positionHttpRequest.INSTANCE.getPositionList());
        tbPoston.setItems(FXCollections.observableArrayList(positions));
        System.out.println(positions);
    }

    private void initData() {
        colmSN.setCellValueFactory(new PropertyValueFactory<>("id"));
        colmPosition.setCellValueFactory(new PropertyValueFactory<>("position"));
        colmSpeciality.setCellValueFactory(new PropertyValueFactory<>("speciality"));
        colmActive.setCellValueFactory(new PropertyValueFactory<>("active"));
    }

    public void refresh() throws IOException {
        List<Position> positionList = positionHttpRequest.INSTANCE.getPositionList();
        System.out.println("init Data: "+positionList);
        ObservableList<Position> observableList = FXCollections.observableList(positionList);
        System.out.println("OL: "+observableList);
        tbPoston.setItems(observableList);
    }


}
