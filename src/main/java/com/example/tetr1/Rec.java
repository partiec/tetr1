package com.example.tetr1;

import javafx.scene.shape.Rectangle;

public class Rec extends Rectangle {

    private boolean freez = false;

    public int locator() {
        return (int) (getY() + Const.PXL);
    }

    public boolean isFreez() {
        return freez;
    }

    public void setFreez(boolean freez) {
        this.freez = freez;
    }
}
