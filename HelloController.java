package com.jfxbase.oopjfxbase.controllers;

import com.jfxbase.oopjfxbase.utils.enums.SCENE_IDENTIFIER;
import com.jfxbase.oopjfxbase.utils.SceneController;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class HelloController extends SceneController {

    @FXML
    private Text helloPrompt;

    @FXML
    protected void onSignInButtonClick(){
        this.changeScene(SCENE_IDENTIFIER.SIGN_IN);
    }

    @FXML
    protected void onLogInButtonClick(){
        this.changeScene(SCENE_IDENTIFIER.LOG_IN);
    }
}