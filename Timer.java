package comp1110.ass2;

/**
 * Created by Jieming on 2015/10/4.
 */
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Scanner;

public class Timer extends Application {

    private Timeline timeline;
    private Label timerLabel = new Label();
    private DoubleProperty timeSeconds = new SimpleDoubleProperty();
    private Duration time = Duration.ZERO;




    @Override
    public void start(Stage primaryStage) {

        // Setup the Stage and the Scene (the scene graph)
        StackPane root = new StackPane();
        Scene scene = new Scene(root, 300, 250);

        // Create and configure VBox
        // gap between components is 20
        VBox vb = new VBox(20);
        // center the components within VBox
        vb.setAlignment(Pos.CENTER);
        // Make it as wide as the application frame (scene)
        vb.setPrefWidth(scene.getWidth());
        // Move the VBox down a bit
        vb.setLayoutY(30);
        // Add the button and timerLabel to the VBox
        //vb.getChildren().addAll(button, timerLabel, splitTimerLabel);

        // Add the VBox to the root component
        root.getChildren().add(vb);

        primaryStage.setTitle("FX Timer");
        primaryStage.setScene(scene);
        // Configure the Label
        // Bind the timerLabel text property to the timeSeconds property
        timerLabel.textProperty().bind(timeSeconds.asString());
        timerLabel.setTextFill(Color.BLUE);
        timerLabel.setStyle("-fx-font-size: 2em;");

        // Create and configure the Button
        Button timer_button1 = new Button();
        timer_button1.setText("Start");
        timer_button1.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {

                    timeline = new Timeline(
                            new KeyFrame(Duration.millis(100),
                                    new EventHandler<ActionEvent>() {
                                        @Override
                                        public void handle(ActionEvent t) {
                                            Duration duration = ((KeyFrame) t.getSource()).getTime();
                                            time = time.add(duration);
                                            //splitTime = splitTime.add(duration);
                                            timeSeconds.set(time.toSeconds());
                                            //splitTimeSeconds.set(splitTime.toSeconds());
                                            if (time.equals(Duration.seconds(5.0))) {
                                                timeline.stop();
                                                //time = Duration.INDEFINITE;
                                                Label label = new Label("Game over!");
                                                root.getChildren().add(label);
                                            }
                                            if (time.greaterThan(Duration.seconds(2.0))) {
                                                timerLabel.setTextFill(Color.RED);
                                            }

                                        }

                                    })

                    );
                    timeline.setCycleCount(Timeline.INDEFINITE);
                    timeline.play();

                }



        });

        Button timer_button2 = new Button();
        timer_button2.setText("Restart");
        timer_button2.setOnAction(e -> {
            time = Duration.ZERO;
            timerLabel.setTextFill(Color.BLUE);
        });
        root.getChildren().add(timer_button2);

        vb.getChildren().addAll(timer_button1, timerLabel);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        launch(args);
    }
}
