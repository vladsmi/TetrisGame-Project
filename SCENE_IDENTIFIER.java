package com.jfxbase.oopjfxbase.utils.enums;

public enum SCENE_IDENTIFIER {
    HELLO("hello-view.fxml"),
    LOG_IN("log-in-view.fxml"),
    SIGN_IN("sign-in-view.fxml"),
    GAME("game-view.fxml");

    public final String label;

    SCENE_IDENTIFIER(String label) {
        this.label = label;
    }
}
