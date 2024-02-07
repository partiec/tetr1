package com.example.tetr1;

import javafx.scene.control.skin.TextInputControlSkin;
import javafx.scene.shape.Rectangle;

public class Rec extends Rectangle {

    private Direction direction = Direction.DOWN;
    private boolean freez = false;

    public int locator() {
        return (int) (getY() + Const.PXL);
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public boolean isFreez() {
        return freez;
    }

    public void setFreez(boolean freez) {
        this.freez = freez;
    }
}
