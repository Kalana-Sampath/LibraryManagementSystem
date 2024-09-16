package org.example.librarymanagementsystem;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginController {

    @FXML
    private Button close;

    @FXML
    private Button login_Btn;

    @FXML
    private Button minimize;

    @FXML
    private PasswordField password;

    @FXML
    private TextField userName;

    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;

    public void login() {

        String sql = "SELECT * FROM user where userName = ? and password = ?";

        connect = Database.connectDB();

        try {
            prepare = connect.prepareStatement(sql);
            prepare.setString(1, userName.getText());
            prepare.setString(2, password.getText());
            result = prepare.executeQuery();


            Alert alert;

            if (userName.getText().isEmpty() || password.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Admin Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields.");
                alert.showAndWait();
            }else
                if (result.next()) {

                }
        }catch (Exception e) {e.printStackTrace();}
    }


    @FXML
    public void minimize(){
        Stage stage = (Stage)minimize.getScene().getWindow();
        stage.setIconified(true);
    }


    @FXML
    public void exit(){
        System.exit(0);
    }
}