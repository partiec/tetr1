package com.example.tetr1;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TetrisApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        // pane

        AnchorPane root = new AnchorPane();
        root.setBackground(Background.fill(Color.WHITE));

        // lines coordinates
        int x1 = 0;
        int x2 = 0;
        int y1 = 0;
        int y2 = 0;

        // horizontal lines
        for (int i = 1; i < Const.HEIGHT_RECT; i++) {

            x1 = 0;
            y1 += Const.PXL;

            x2 = Const.WIDTH_PXL;
            y2 = y1;

            Line line = new Line(x1, y1, x2, y2);
            line.setStrokeWidth(1);
            line.setFill(Color.GRAY);
            root.getChildren().add(line);
        }

        // vertical lines
        for (int i = 1; i < Const.WIDTH_RECT; i++) {

            x1 += Const.PXL;
            y1 = 0;

            x2 = x1;
            y2 = Const.HEIGHT_PXL;

            Line line = new Line(x1, y1, x2, y2);
            line.setStrokeWidth(1);
            line.setFill(Color.GRAY);
            root.getChildren().add(line);
        }

        // rectangle test--------
        List<Rectangle> list = new ArrayList<>();

        int rX = (Const.WIDTH_RECT / 2) * Const.PXL;
        int rY = 0;

        for (int y = 0; y < Template_UpDown.matrix_1.length; y++) {
            for (int x = 0; x < Template_UpDown.matrix_1.length; x++) {

                if (Template_UpDown.matrix_1[y][x] == 1) {

                    Rectangle rectangle = new Rectangle();

                    rectangle.setX(rX + (x * Const.PXL));
                    rectangle.setY(rY + (y * Const.PXL));
                    rectangle.setWidth(Const.PXL);
                    rectangle.setHeight(Const.PXL);
                    rectangle.setFill(Color.DARKMAGENTA);

                    list.add(rectangle);
                    root.getChildren().add(rectangle);
                }
            }
        }

        AnimationTimer at = new AnimationTimer() {
            @Override
            public void handle(long l) {

                for (Rectangle r : list){

                    int x = (int) r.getX();
                    int y = (int) r.getY();

                    y++;

                    r.setY(y);

                }
            }
        };
        at.start();
        //-----------------------/

        Scene scene = new Scene(root, Const.WIDTH_PXL, Const.HEIGHT_PXL);
        stage.setTitle("Tetris MalYsha!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}