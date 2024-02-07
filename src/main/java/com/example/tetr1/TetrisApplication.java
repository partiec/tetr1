package com.example.tetr1;

import com.example.tetr1.templates.Template;
import com.example.tetr1.templates.Template_T;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.effect.Light;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TetrisApplication extends Application {
    List<Rec> downers = new ArrayList<>();
    List<Rec> freezers = new ArrayList<>();
    int baseX = (Const.WIDTH_RECT / 2) * Const.PXL;
    int baseY = 0;
    Template template;

    @Override
    public void start(Stage stage) throws IOException {

        // Создание Панели
        // 1. Создаем белую панель
        // 2. На ней рисуем гориз и верт линии
        // 3. Возвращаем ее
        AnchorPane root = getAnchorPane();


        // Новая Фигура
        // На каждой итерации происходит следующее:
        // 1. Создание 1 rec
        // 2. Установка ему координат, размеров, цвета
        // 3. Помещаем rec в downers
        // 4. Помещаем rec на панель
        newFigure(root, downers, baseX, baseY);


        // Создаем  и запускаем таймер--------
        AnimationTimer at = new AnimationTimer() {

            // handle() запускается на КАЖДОМ КАДРЕ !!!
            @Override
            public void handle(long l) {

                // downer : downers с конца
                for (int i = downers.size() - 1; i >= 0; i--) {
                    //координаты
                    Rec downer = downers.get(i);
                    downer.setDirection(Direction.DOWN);
                    int x = (int) downer.getX();
                    int y = (int) downer.getY();

                    // увеличиваем координаты
                    if (downer.getDirection() == Direction.LEFT) {
                        x -= Const.PXL;
                        downer.setX(x);
                        System.out.println("left");
                    }
                    if (downer.getDirection() == Direction.RIGHT) {
                        x += Const.PXL;
                        downer.setX(x);
                    }
                    if (downer.getDirection() == Direction.UP) {
                        //rotation figure
                    }
                    if (downer.getDirection() == Direction.DOWN) {
                        // down figure
                    }

                    y++;
                    downer.setY(y);

                    //  Устанавливаем локаторы
                    Locator downLocator = new Locator();
                    downLocator.setX(x);
                    downLocator.setY(y + Const.PXL);


                    // если нащупал дно
                    if (downLocator.getY() == Const.HEIGHT_PXL) {
                        // переводим downers во freezers
                        // downers очищаем
                        // newFigure() заполняет downers
                        freezers.addAll(downers);
                        downers.clear();
                        newFigure(root, downers, baseX, baseY);

                        break;
                    }

                    // если нащупал freezer
                    // freezer : freezers c конца
                    for (int j = freezers.size() - 1; j >= 0; j--) {
                        Rec freezer = freezers.get(j);

                        if (downLocator.getY() == freezer.getY() && downLocator.getX() == freezer.getX()) {//нащупал

                            // переводим downers во freezers
                            // downers очищаем
                            // newFigure() заполняет downers
                            freezers.addAll(downers);
                            downers.clear();
                            newFigure(root, downers, baseX, baseY);

                            break;

                        }
                    }


                }


            }

        };
        at.start();
        //-----------------------/

        Scene scene = new Scene(root, Const.WIDTH_PXL, Const.HEIGHT_PXL);
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                Direction direction = null;
                int correction = 0;
                if (keyEvent.getCode() == KeyCode.LEFT) {
                    direction = Direction.LEFT;
                    correction = -Const.PXL;
                }
                if (keyEvent.getCode() == KeyCode.RIGHT) {
                    direction = Direction.RIGHT;
                    correction = Const.PXL;
                }
                if (keyEvent.getCode() == KeyCode.UP) {
                    direction = Direction.UP;
                }
                if (keyEvent.getCode() == KeyCode.DOWN) {
                    direction = Direction.DOWN;
                }


                for (Rec rec : downers) {
                    rec.setDirection(direction);
                    int newX = (int) (rec.getX() + correction);
                    rec.setX(newX);
                }

            }
        });
        stage.setTitle("Tetris MalYsha!");
        stage.setScene(scene);
        stage.show();
    }

    // Новая Фигура
    // На каждой итерации происходит следующее:
    // 1. Создание 1 rec
    // 2. Установка ему координат, размеров, цвета
    // 3. Помещаем rec в downers
    // 4. Помещаем rec на панель
    private void newFigure(AnchorPane root, List<Rec> downers, int baseX, int baseY) {
        template = MyService.chooseTemplate();
        for (int i = 0; i < template.matrix_1().length; i++) {
            for (int j = 0; j < template.matrix_1().length; j++) {

                if (template.matrix_1()[i][j] == 1) {

                    Rec rec = new Rec();

                    rec.setX(baseX + (j * Const.PXL));
                    rec.setY(baseY + (i * Const.PXL));
                    rec.setWidth(Const.PXL);
                    rec.setHeight(Const.PXL);
                    rec.setFill(Color.DARKMAGENTA);
                    rec.setStroke(Color.GRAY);

                    downers.add(rec);
                    root.getChildren().add(rec);
                }
            }
        }
    }


    // Создание Панели
    // 1. Создаем белую панель
    // 2. На ней рисуем гориз и верт линии
    // 3. Возвращаем ее
    private static AnchorPane getAnchorPane() {
        // pane

        AnchorPane root = new AnchorPane();
        root.setBackground(Background.fill(Color.WHITE));

        // lines coordinates
        int x1 = 0;
        int y1 = 0;
        int x2 = 0;
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

        return root;
    }

    public static void main(String[] args) {
        launch();
    }
}