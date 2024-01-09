package com.jfxbase.oopjfxbase.controllers;

import com.jfxbase.oopjfxbase.JFXBaseApplication;
import com.jfxbase.oopjfxbase.TetrisGame;
import com.jfxbase.oopjfxbase.utils.SceneController;
import com.jfxbase.oopjfxbase.utils.enums.SCENE_IDENTIFIER;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.Objects;

import static com.jfxbase.oopjfxbase.DBConnection.conn;
import static com.jfxbase.oopjfxbase.controllers.SignInView.account;


public class LogInView extends SceneController {

    @FXML
    private TextField userLogInField;
    @FXML
    private PasswordField passLogInField;
    @FXML
    private Label logInErrorLabel;

    @FXML
    private void logInButtonClick() {
        String user = userLogInField.getText();
        if (Objects.equals(user, "")) {
            logInErrorLabel.setVisible(true);
        }
        String pass = passLogInField.getText();
        String selectQuery = "SELECT password FROM accounts WHERE username = ?";
        String selectQuery2 = "SELECT highscore FROM accounts WHERE username = ?";
        try (PreparedStatement preparedStatement = conn.prepareStatement(selectQuery2)) {
            preparedStatement.setString(1, user);
            try (ResultSet result = preparedStatement.executeQuery()) {
                if (result.next()){
                    if (result.getInt("highscore") != 0) {
                        account.setHighScore(result.getInt("highscore"));
                    }
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        try (PreparedStatement preparedStatement = conn.prepareStatement(selectQuery)) {
            preparedStatement.setString(1, user);
            try (ResultSet result = preparedStatement.executeQuery()) {
                if (result.next()) {
                    if (Objects.equals(pass, result.getString("password"))) {
                        account.setUsername(userLogInField.getText());
                        TetrisGame tetrisGame = new TetrisGame();
                        tetrisGame.startTetris((Stage) logInErrorLabel.getScene().getWindow());
                        logInErrorLabel.setVisible(false);
                    } else {
                        logInErrorLabel.setVisible(true);
                    }
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
        @FXML
    protected void onBackToHelloClick() {
        logInErrorLabel.setVisible(false);
        this.changeScene(SCENE_IDENTIFIER.HELLO);
    }

}
