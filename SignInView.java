package com.jfxbase.oopjfxbase.controllers;

import com.jfxbase.oopjfxbase.utils.Account;
import com.jfxbase.oopjfxbase.utils.enums.SCENE_IDENTIFIER;
import com.jfxbase.oopjfxbase.utils.SceneController;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;

import static com.jfxbase.oopjfxbase.DBConnection.conn;
import static javafx.scene.paint.Color.*;



public class SignInView extends SceneController {

    @FXML
    private Label statusLabel;
    @FXML
    private DatePicker datePicker = null;
    @FXML
    private TextField userField = null;
    @FXML
    private PasswordField passField = null;
    @FXML
    private TextField mailField = null;
    @FXML
    private PasswordField repeatPassField = null;

    public static Account account = new Account();

    @FXML
    public void mailCompleted(){
        statusLabel.textFillProperty().set(BLACK);
        statusLabel.setText(null);
        statusLabel.setVisible(false);
    }

    public void getData() {
        if(datePicker.getValue() != null) {account.setBirthdate(datePicker.getValue());}
        if(userField.getText() != null) {account.setUsername(userField.getText());}
        if(mailField.getText() != null) {account.setEmail(mailField.getText());}
        if(passField.getText() != null) {account.setPassword(passField.getText());}
    }

    @FXML
    protected void backButtonAction(){
        this.changeScene(SCENE_IDENTIFIER.HELLO);
        statusLabel.textFillProperty().set(BLACK);
        statusLabel.setText(null);
        statusLabel.setVisible(false);
    }

    @FXML
    protected void saveButtonAction(){
        getData();
        if(account.getUsername().length() >= 4){
            if(account.getEmail().contains("@") && account.getEmail().contains(".com")){
                if(Objects.equals(passField.getText(), repeatPassField.getText())) {
                    String insertQuery = "INSERT INTO accounts (Username, Password, Mail, Birthdate) VALUES (?, ?, ?, ?)";
                    if (account.checkValid()) {
                        try (PreparedStatement preparedStatement = conn.prepareStatement(insertQuery)) {
                            preparedStatement.setString(1, account.getUsername());
                            preparedStatement.setString(2, account.getPassword());
                            preparedStatement.setString(3, account.getEmail());
                            preparedStatement.setDate(4, java.sql.Date.valueOf(account.getBirthdate()));
                            preparedStatement.executeUpdate();

                            userField.setText(null);
                            account.setUsername(null);
                            passField.setText(null);
                            account.setPassword(null);
                            mailField.setText(null);
                            account.setEmail(null);
                            datePicker.setValue(null);
                            account.setBirthdate(null);
                            repeatPassField.setText(null);

                            statusLabel.textFillProperty().set(GREEN);
                            statusLabel.setText("Account created successfully");
                            statusLabel.setVisible(true);


                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        statusLabel.textFillProperty().set(RED);
                        statusLabel.setText("Invalid credentials");
                        statusLabel.setVisible(true);
                    }
                }else{
                    statusLabel.textFillProperty().set(RED);
                    statusLabel.setText("Passwords must match");
                    statusLabel.setVisible(true);
                }
            }else{
                statusLabel.textFillProperty().set(RED);
                statusLabel.setText("Invalid e-mail");
                statusLabel.setVisible(true);
            }

        }else{
            statusLabel.textFillProperty().set(RED);
            statusLabel.setText("Username must be at least 4 characters long");
            statusLabel.setVisible(true);
        }


    }
}
