package de.jefrickel.spielwiese.fx.spielwiesefx;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;

import java.util.List;

public class HelloApplication extends Application {

    private static final List<List<Integer>> coordinates = List.of(List.of(108, 71), List.of(321, 161), List.of(126, 232), List.of(232, 52), List.of(269, 250), List.of(108, 71));

    private final Group root = new Group();

    @Override
    public void start(Stage stage) {
        AnimationTimer timer = new MyTimer();
        timer.start();
        Scene scene = new Scene(this.root, 600, 300);
        stage.setTitle("Drawing an arc through a path");
        stage.setScene(scene);
        stage.show();
    }

    private class MyTimer extends AnimationTimer {

        private static int counter = 0;
        private static long lastUpdate;

        @Override
        public void start() {
            lastUpdate = System.nanoTime();
            super.start();
        }

        @Override
        public void handle(long now) {
            if (now - lastUpdate < 1_000_000_000.0) {
                return;
            }

            Path path = new Path();
            var start = coordinates.get(counter);
            var finish = coordinates.get((counter + 1) % coordinates.size());
            MoveTo moveTo = new MoveTo(start.get(0), start.get(1));
            LineTo line = new LineTo(finish.get(0), finish.get(1));
            path.getElements().add(moveTo);
            path.getElements().add(line);
            root.getChildren().add(path);

            if (++counter >= coordinates.size()) {
                stop();
            }

            lastUpdate = System.nanoTime();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}