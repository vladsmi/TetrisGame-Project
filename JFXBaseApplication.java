package com.jfxbase.oopjfxbase;
import com.jfxbase.oopjfxbase.utils.ApplicationHandler;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class JFXBaseApplication extends Application {

    @Override
    public void start(Stage stage) {
        ApplicationHandler.getInstance().startApplication(stage);
        stage.setTitle("TETRIS");
        stage.getIcons().add(new Image(JFXBaseApplication.class.getResourceAsStream("/tetris-logo.bmp")));
        DBConnection.connect();
    }

    public static void main(String[] args) {
        launch();
    }
}