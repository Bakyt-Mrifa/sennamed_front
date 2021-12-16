package kg.sennamed.sennamedFront.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import kg.sennamed.sennamedFront.models.User;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class UserFormCtrl {
    @FXML
    private MenuItem mnItemClose;


    @FXML
    private MenuItem mnItemAdd;

    @FXML
    private MenuItem mnItemEdit;

    @FXML
    private MenuItem mnItemDict;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<User> tbUsers;

    @FXML
    private TableColumn<User, Integer> colmId;

    @FXML
    private TableColumn<User, String> colmName;

    @FXML
    private TableColumn<User, String> colmLogin;

    @FXML
    private TableColumn<User, String> colmPwd;
    @FXML
    private TableColumn<User, Integer> colmActive;

    @FXML
    void onMnItemClicked(ActionEvent event) throws IOException {
        if (event.getSource().equals(mnItemAdd)) {
            addNewUser();
        } else if (event.getSource().equals(mnItemEdit)) {
            editCurrentUser();
        } else if (event.getSource().equals(mnItemDict)) {
            showPositionForm();
        }
    }

    private void showPositionForm() {
        Stage stage = new Stage();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("positionsForm.fxml"));
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void editCurrentUser() {
    }
/*

        Stage stage=new Stage();

        try {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("UserEditForm.fxml"));
            loader.load();
            stage.setScene(new Scene(loader.getRoot()));
            UserEditFormCtrl controller =  loader.getController();
            Users user = tbUsers.getSelectionModel().getSelectedItem();
            controller.initData(stage, user);
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
*/

    private void addNewUser() {
       /* Stage stage=new Stage();

        try {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("UserEditForm.fxml"));
            loader.load();
            stage.setScene(new Scene(loader.getRoot()));
            UserEditFormCtrl controller =  loader.getController();
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
    }*/
    }
    @FXML
    void initialize() {
            initData();
        }
/*
        colmId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colmName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colmLogin.setCellValueFactory(new PropertyValueFactory<>("login"));
        colmPwd.setCellValueFactory(new PropertyValueFactory<>("pwd"));
        colmActive.setCellValueFactory(new PropertyValueFactory<>("isActive"));

        tbUsers.setRowFactory(param -> new TableRow<Users>(){
            protected void updateItem(Users item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {

                    setStyle("-fx-control-inner-background: derive(-fx-base, 80%);");
                } else {

                    if (item.getIsActive() == 0) {
                        setStyle("-fx-control-inner-background: lightgrey");
                    } else {
                        setStyle("-fx-control-inner-background: derive(-fx-base, 80%);");
                    }
                }
            }
        });

      refresh();
      }
    */


    private void initTableView() throws IOException {

    }

    private void initData() {
        colmId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colmName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colmLogin.setCellValueFactory(new PropertyValueFactory<>("login"));
        colmPwd.setCellValueFactory(new PropertyValueFactory<>("pwd"));
        colmActive.setCellValueFactory(new PropertyValueFactory<>("isActive"));
    }
    private void refresh() {
             /*   AdminServices adminServices = new AdminServicesImpl();
                List<Users> list = adminServices.findUsers();
                ObservableList<Users> observableList = FXCollections.observableList(list);
                tbUsers.setItems(observableList);*/
    }


}

