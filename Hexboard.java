package comp1110.ass2;

import javafx.animation.*;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.VBoxBuilder;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by Jieming on 2015/9/25.
 */
public class Hexboard extends Application {

    Stage window;
    Scene scene, scene1;

    String game = "";
    String crannies;
    String nooks;
    String start;
    String end;
    private Timeline timeline;
    private Label timerLabel = new Label();
    private DoubleProperty timeSeconds = new SimpleDoubleProperty();
    private Duration time = Duration.ZERO;
    static int now;
    int ministepnum;
    int[] x;
    private IntegerProperty Score=new SimpleIntegerProperty();
    public Hexboard() {

        HexGame xxx = new HexGame();
        game = xxx.toString();

        crannies = game.substring(0, 18);

        nooks = game.substring(18, 90);

        this.start = xxx.start;

        this.end = xxx.end;

        now = Integer.valueOf(start);
        x = xxx.minimalPath(game, Integer.valueOf(start), Integer.valueOf(end));

        ministepnum = x.length-1;

    }


    private IntegerProperty clickCounter = new SimpleIntegerProperty(this, "clickCounter");

    public ArrayList<String> Nextmove(int from) {
        Move mmm = new Move();
        ArrayList<String> nextmove = mmm.move(game, from);
        return nextmove;
    }

    public ArrayList<String> Nextmove() {
        Move mmm = new Move();
        ArrayList<String> nextmove = mmm.move(game, Integer.valueOf(start));
        return nextmove;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        window = primaryStage;

        System.out.println("This is c " + crannies);
        System.out.println("This is n " + nooks);
        System.out.println("This is s " + start);

        Label label3 = new Label("Welcome to our HexGame !!!");

        Button button1 = new Button("START!");

        button1.setOnAction(event -> {
            window.setScene(scene);
        });

        VBox layout3 = new VBox(20);
        layout3.getChildren().addAll(label3, button1);
        scene1 = new Scene(layout3, 300, 300);

        primaryStage.setTitle("Board");

        Button button2 = new Button("PLAY A NEW GAME !");
        button2.setTranslateX(800);
        button2.setTranslateY(900);

        Label labelt = new Label();

        ChoiceBox choiceBox = new ChoiceBox(
                FXCollections.observableArrayList(
                        "Easy", "Medium", "Difficult")
        );
        //choiceBox.getSelectionModel().selectFirst();
        choiceBox.getSelectionModel().selectedItemProperty()
                .addListener((ObservableValue observable,
                              Object oldValue, Object newValue) -> {
                    labelt.setText((String) newValue);
                    labelt.setTextFill(Color.WHITE);
                    //System.out.println(label1.getText());
                    if (labelt.getText() == "Easy") {
                        Hexboard hex = new Hexboard();
                        try {
                            hex.start(primaryStage);
                            while (ministepnum > 4) {
                                Hexboard hex1 = new Hexboard();
                                hex1.start(primaryStage);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        //window.setScene(scene1);
                    }
                    if (labelt.getText() == "Medium") {
                        Hexboard hex = new Hexboard();
                        try {
                            hex.start(primaryStage);
                            while ((ministepnum > 9) || (ministepnum < 5)) {
                                Hexboard hex1 = new Hexboard();
                                hex1.start(primaryStage);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        //window.setScene(scene1);
                    }
                    if (labelt.getText() == "Difficult") {
                        Hexboard hex = new Hexboard();
                        try {
                            hex.start(primaryStage);
                            while (ministepnum > 9) {
                                Hexboard hex1 = new Hexboard();
                                hex1.start(primaryStage);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        //window.setScene(scene1);
                    }
                });
        layout3.getChildren().addAll(choiceBox, labelt);





        button2.setOnAction(event -> {
            window.setScene(scene1);
            Hexboard hex = new Hexboard();
            try {
                hex.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
            choiceBox.setValue(null);
        });


        Group root1 = new Group();
        root1.getChildren().add(button2);
        scene = new Scene(root1, 1200, 1200);
        primaryStage.setScene(scene);
        String[] num_idx = {"169", "170", "171", "172", "173", "174", "175", "176", "177",
                "216", "127", "128", "129", "130", "131", "132", "133", "134", "178",
                "215", "168", "091", "092", "093", "094", "095", "096", "097", "135", "179",
                "214", "167", "126", "061", "062", "063", "064", "065", "066", "098", "136", "180",
                "213", "166", "125", "090", "037", "038", "039", "040", "041", "067", "099", "137", "181",
                "212", "165", "124", "089", "060", "019", "020", "021", "022", "042", "068", "100", "138", "182",
                "211", "164", "123", "088", "059", "036", "007", "008", "009", "023", "043", "069", "101", "139", "183",
                "210", "163", "122", "087", "058", "035", "018", "001", "002", "010", "024", "044", "070", "102", "140", "184",
                "209", "162", "121", "086", "057", "034", "017", "006", "000", "003", "011", "025", "045", "071", "103", "141", "185",
                "208", "161", "120", "085", "056", "033", "016", "005", "004", "012", "026", "046", "072", "104", "142", "186",
                "207", "160", "119", "084", "055", "032", "015", "014", "013", "027", "047", "073", "105", "143", "187",
                "206", "159", "118", "083", "054", "031", "030", "029", "028", "048", "074", "106", "144", "188",
                "205", "158", "117", "082", "053", "052", "051", "050", "049", "075", "107", "145", "189",
                "204", "157", "116", "081", "080", "079", "078", "077", "076", "108", "146", "190",
                "203", "156", "115", "114", "113", "112", "111", "110", "109", "147", "191",
                "202", "155", "154", "153", "152", "151", "150", "149", "148", "192",
                "201", "200", "199", "198", "197", "196", "195", "194", "193"};


        double x1 = 330.0; //hextop_x_offset
        double y1 = 110.0; //hextop_y_offset
        double l = 25.0;
        double a = l * Math.sqrt(3.0);
        double[] hextop_x = new double[217];
        double[] hextop_y = new double[217];


        Button btn1 = new Button();//create a button
        btn1.setText("Are you ready?");



        btn1.setTranslateX(10);
        btn1.setTranslateY(10);
        root1.getChildren().add(btn1);


        for (int i = 0; i < 9; i++) {
            hextop_x[i] = x1 + i * (a + 2);
            hextop_y[i] = y1;
        }
        for (int i = 9; i < 19; i++) {
            hextop_x[i] = x1 - 0.5 * a + (i - 9) * (a + 2) - 1;
            hextop_y[i] = y1 + 1.5 * l + 2;
        }
        for (int i = 19; i < 30; i++) {
            hextop_x[i] = x1 - 1.0 * a + (i - 19) * (a + 2) - 2;
            hextop_y[i] = y1 + 3.0 * l + 4;
        }
        for (int i = 30; i < 42; i++) {
            hextop_x[i] = x1 - 1.5 * a + (i - 30) * (a + 2) - 3;
            hextop_y[i] = y1 + 4.5 * l + 6;
        }
        for (int i = 42; i < 55; i++) {
            hextop_x[i] = x1 - 2.0 * a + (i - 42) * (a + 2) - 4;
            hextop_y[i] = y1 + 6.0 * l + 8;
        }
        for (int i = 55; i < 69; i++) {
            hextop_x[i] = x1 - 2.5 * a + (i - 55) * (a + 2) - 5;
            hextop_y[i] = y1 + 7.5 * l + 10;
        }
        for (int i = 69; i < 84; i++) {
            hextop_x[i] = x1 - 3.0 * a + (i - 69) * (a + 2) - 6;
            hextop_y[i] = y1 + 9.0 * l + 12;
        }
        for (int i = 84; i < 100; i++) {
            hextop_x[i] = x1 - 3.5 * a + (i - 84) * (a + 2) - 7;
            hextop_y[i] = y1 + 10.5 * l + 14;
        }
        for (int i = 100; i < 117; i++) {
            hextop_x[i] = x1 - 4.0 * a + (i - 100) * (a + 2) - 8;
            hextop_y[i] = y1 + 12.0 * l + 16;
        }
        for (int i = 117; i < 133; i++) {
            hextop_x[i] = x1 - 3.5 * a + (i - 117) * (a + 2) - 7;
            hextop_y[i] = y1 + 13.5 * l + 18;
        }
        for (int i = 133; i < 148; i++) {
            hextop_x[i] = x1 - 3.0 * a + (i - 133) * (a + 2) - 6;
            hextop_y[i] = y1 + 15.0 * l + 20;
        }
        for (int i = 148; i < 162; i++) {
            hextop_x[i] = x1 - 2.5 * a + (i - 148) * (a + 2) - 5;
            hextop_y[i] = y1 + 16.5 * l + 22;
        }
        for (int i = 162; i < 175; i++) {
            hextop_x[i] = x1 - 2.0 * a + (i - 162) * (a + 2) - 4;
            hextop_y[i] = y1 + 18.0 * l + 24;
        }
        for (int i = 175; i < 187; i++) {
            hextop_x[i] = x1 - 1.5 * a + (i - 175) * (a + 2) - 3;
            hextop_y[i] = y1 + 19.5 * l + 26;
        }
        for (int i = 187; i < 198; i++) {
            hextop_x[i] = x1 - 1.0 * a + (i - 187) * (a + 2) - 2;
            hextop_y[i] = y1 + 21 * l + 28;
        }
        for (int i = 198; i < 208; i++) {
            hextop_x[i] = x1 - 0.5 * a + (i - 198) * (a + 2) - 1;
            hextop_y[i] = y1 + 22.5 * l + 30;
        }
        for (int i = 208; i < 217; i++) {
            hextop_x[i] = x1 - 0.0 * a + (i - 208) * (a + 2) - 0;
            hextop_y[i] = y1 + 24 * l + 32;
        }
        double[] hexcen_x = hextop_x;
        double[] hexcen_y = new double[217];
        for (int k = 0; k < 217; k++) {
            hexcen_y[k] = hextop_y[k] + l;
        }

        HashMap<Polygon, Integer> map = new HashMap<>();



        for (int i = 0; i < 217; i++) {
            Polygon polygon1 = new Polygon();
            double[] pp = {hextop_x[i], hextop_y[i],
                    hextop_x[i] + 0.5 * a, hextop_y[i] + 0.5 * l,
                    hextop_x[i] + 0.5 * a, hextop_y[i] + 1.5 * l,
                    hextop_x[i], hextop_y[i] + 2 * l,
                    hextop_x[i] - 0.5 * a, hextop_y[i] + 1.5 * l,
                    hextop_x[i] - 0.5 * a, hextop_y[i] + 0.5 * l,};
            for (int j = 0; j < 12; j++) {
                polygon1.getPoints().addAll(pp[j]);
            }
            polygon1.setFill(Color.LIGHTBLUE);

            map.put(polygon1, Integer.valueOf(num_idx[i]));


            Label label4 = new Label("CONGRATULATIONS!!!");


            VBox layout4 = new VBox(20);
            Scene scene2 = new Scene(layout4, 500, 500);
            layout4.getChildren().addAll(label4);
            final Animation hitAnimation= SequentialTransitionBuilder.create().node(polygon1)
                    .children(
                            RotateTransitionBuilder.create()
                                    .fromAngle(0)
                                    .toAngle(1260)
                                    .duration(Duration.millis(800)).build()
                            //TranslateTransitionBuilder.create()
                            //.byY(1000).duration(Duration.millis(800)).build()
                    )
                    .build();

            polygon1.setOnMouseClicked(new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent event) {


                    String s = Integer.toString(map.get(polygon1));
                    if (s.length() == 2) {
                        s = "0" + s;
                    } else if (s.length() == 1) {
                        s = "00" + s;
                    }

                    //
                  //  System.out.println("this is to find the one" + Nextmove(now));

                    if (Nextmove(now).contains(s)) {
                        //System.out.println(Nextmove(map.get(polygon1)));

                        if (s.equals(end)) {

                            window.setScene(scene2);

                        }

                        polygon1.setFill(Color.RED);
                        polygon1.setCursor(Cursor.CLOSED_HAND);
                        hitAnimation.play();
                        now = map.get(polygon1);


                        polygon1.setOnMouseExited(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {

                                System.out.println("really Mouse exited!");
                                polygon1.setFill(Color.GREEN);

                            }
                        });
                        final Text clickLabel = new Text();

                        final VBox hud = VBoxBuilder.create().children(clickLabel).translateX(50)
                                .translateY(60).build();
                        clickCounter.set(clickCounter.get() + 1);
                        clickLabel.textProperty().bind(Bindings.concat(("Steps:"), clickCounter));
                        root1.getChildren().add(hud);
                    }


                    System.out.println("this is the number poligon ");

                }
            });

            root1.getChildren().add(polygon1);
        }


        EventHandler next = new EventHandler() {
            @Override
            public void handle(Event event) {
                event.consume();
            }
        };

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
        root1.getChildren().add(vb);

        primaryStage.setTitle("FX Timer");
        primaryStage.setScene(scene);
        // Configure the Label
        // Bind the timerLabel text property to the timeSeconds property
        timerLabel.textProperty().bind(timeSeconds.asString());
        timerLabel.setTextFill(Color.BLUE);
        timerLabel.setStyle("-fx-font-size: 2em;");

        // Create and configure the Button

/*
        Button timer_button2 = new Button();
        timer_button2.setText("Restart");
        timer_button2.setOnAction(e -> {
            time = Duration.ZERO;
            timeline.play();
            timerLabel.setTextFill(Color.BLUE);
        });
        root1.getChildren().add(timer_button2);
*/

        final Text BasicalScore=new Text();
        BasicalScore.setTranslateX(800);
        BasicalScore.setTranslateY(75);
        BasicalScore.textProperty().bind(Score.asString("BasicalScore: 1000"));
        root1.getChildren().addAll(BasicalScore);

        final Text ExtraScore=new Text();
        ExtraScore.setTranslateX(800);
        ExtraScore.setTranslateY(175);
        ExtraScore.textProperty().bind(Score.asString("ExtraScore: 1000"));
        root1.getChildren().addAll(ExtraScore);



        //btn1.setText("Start");
        btn1.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                btn1.setText("Game start! Minimal Step is:" + ministepnum);
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
                                            ExtraScore.textProperty().bind(Score.asString("ExtraScore: 0"));
                                            //Label label = new Label("Show your answer!");
                                            //root1.getChildren().add(label);
                                        }
                                        if (time.greaterThan(Duration.seconds(2.0))) {
                                            timerLabel.setTextFill(Color.RED);
                                            ExtraScore.setFill(Color.RED);
                                        }

                                    }

                                })

                );
                timeline.setCycleCount(Timeline.INDEFINITE);
                timeline.play();

            }


        });
        vb.getChildren().addAll( timerLabel);




        for (int j = 0; j < 217; j++) {
            Label label1 = new Label(num_idx[j]);
            label1.setFont(Font.font("Tahoma", FontWeight.NORMAL, 10));
            label1.setTranslateX(hextop_x[j] - 8);
            label1.setTranslateY(hextop_y[j] + 0.7 * l + 1);
            root1.getChildren().add(label1);
        }


        for (int i = 0; i < 217; i++) {
            if (start.equals(num_idx[i])) {
                Circle begin = new Circle(15);

                begin.setTranslateX(hexcen_x[i]);
                begin.setTranslateY(hexcen_y[i]);
                begin.setOpacity(0.5);
                begin.setFill(Color.RED);
                root1.getChildren().add(begin);
            }
        }

        for (int i = 0; i < 217; i++) {
            if (end.equals(num_idx[i])) {
                Circle begin = new Circle(15);

                begin.setTranslateX(hexcen_x[i]);
                begin.setTranslateY(hexcen_y[i]);
                begin.setOpacity(0.5);
                begin.setFill(Color.BLUE);
                root1.getChildren().add(begin);
            }
        }

        Circle start_i = new Circle(15);
        start_i.setTranslateX(20);
        start_i.setTranslateY(900);
        start_i.setOpacity(0.5);
        start_i.setFill(Color.RED);
        root1.getChildren().add(start_i);

        Label start_label = new Label("Start");
        start_label.setTranslateX(40);
        start_label.setTranslateY(890);
        start_label.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        root1.getChildren().add(start_label);

        Circle end_i = new Circle(15);
        end_i.setTranslateX(20);
        end_i.setTranslateY(940);
        end_i.setOpacity(0.5);
        end_i.setFill(Color.BLUE);
        root1.getChildren().add(end_i);

        Label end_label = new Label("End");
        end_label.setTranslateX(40);
        end_label.setTranslateY(930);
        end_label.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        root1.getChildren().add(end_label);


        String nook = nooks;
        double[] nook1 = new double[8];
        char[] ori_dic = {'A', 'B', 'C', 'D', 'E', 'F'};
        String[] nook_num = new String[18];
        char[] ori_char = new char[18];
        for (int s = 0; s < 18; s++) {
            nook_num[s] = "" + nook.charAt(4 * s) + nook.charAt(4 * s + 1) + nook.charAt(4 * s + 2);
        }
        for (int s = 0; s < 18; s++) {
            ori_char[s] = nook.charAt(4 * s + 3);
        }

        for (int ss = 0; ss < 18; ss++) {
            for (int jj = 0; jj < 217; jj++) {
                if (nook_num[ss].equals(num_idx[jj])) {
                    if (ori_char[ss] == 'A') {
                        nook1[0] = hexcen_x[jj] - 0.5 * a;
                        nook1[1] = hexcen_y[jj] + 0.5 * l;
                        nook1[2] = hexcen_x[jj] - 0.5 * a;
                        nook1[3] = hexcen_y[jj] - 0.5 * l;
                        nook1[4] = hexcen_x[jj];
                        nook1[5] = hexcen_y[jj] - l;
                        nook1[6] = hexcen_x[jj] + 0.5 * a;
                        nook1[7] = hexcen_y[jj] - 0.5 * l;
                    }
                    if (ori_char[ss] == 'B') {
                        nook1[0] = hexcen_x[jj] - 0.5 * a;
                        nook1[1] = hexcen_y[jj] - 0.5 * l;
                        nook1[2] = hexcen_x[jj];
                        nook1[3] = hexcen_y[jj] - l;
                        nook1[4] = hexcen_x[jj] + 0.5 * a;
                        nook1[5] = hexcen_y[jj] - 0.5 * l;
                        nook1[6] = hexcen_x[jj] + 0.5 * a;
                        nook1[7] = hexcen_y[jj] + 0.5 * l;
                    }
                    if (ori_char[ss] == 'C') {
                        nook1[0] = hexcen_x[jj];
                        nook1[1] = hexcen_y[jj] - l;
                        nook1[2] = hexcen_x[jj] + 0.5 * a;
                        nook1[3] = hexcen_y[jj] - 0.5 * l;
                        nook1[4] = hexcen_x[jj] + 0.5 * a;
                        nook1[5] = hexcen_y[jj] + 0.5 * l;
                        nook1[6] = hexcen_x[jj];
                        nook1[7] = hexcen_y[jj] + l;
                    }
                    if (ori_char[ss] == 'D') {
                        nook1[0] = hexcen_x[jj] + 0.5 * a;
                        nook1[1] = hexcen_y[jj] - 0.5 * l;
                        nook1[2] = hexcen_x[jj] + 0.5 * a;
                        nook1[3] = hexcen_y[jj] + 0.5 * l;
                        nook1[4] = hexcen_x[jj];
                        nook1[5] = hexcen_y[jj] + l;
                        nook1[6] = hexcen_x[jj] - 0.5 * a;
                        nook1[7] = hexcen_y[jj] + 0.5 * l;
                    }
                    if (ori_char[ss] == 'E') {
                        nook1[0] = hexcen_x[jj] + 0.5 * a;
                        nook1[1] = hexcen_y[jj] + 0.5 * l;
                        nook1[2] = hexcen_x[jj];
                        nook1[3] = hexcen_y[jj] + l;
                        nook1[4] = hexcen_x[jj] - 0.5 * a;
                        nook1[5] = hexcen_y[jj] + 0.5 * l;
                        nook1[6] = hexcen_x[jj] - 0.5 * a;
                        nook1[7] = hexcen_y[jj] - 0.5 * l;
                    }
                    if (ori_char[ss] == 'F') {
                        nook1[0] = hexcen_x[jj];
                        nook1[1] = hexcen_y[jj] + l;
                        nook1[2] = hexcen_x[jj] - 0.5 * a;
                        nook1[3] = hexcen_y[jj] + 0.5 * l;
                        nook1[4] = hexcen_x[jj] - 0.5 * a;
                        nook1[5] = hexcen_y[jj] - 0.5 * l;
                        nook1[6] = hexcen_x[jj];
                        nook1[7] = hexcen_y[jj] - l;
                    }
                }
            }
            for (int jjj = 0; jjj < 3; jjj++) {
                Line line = new Line(nook1[2 * jjj], nook1[2 * jjj + 1], nook1[2 * (jjj + 1)], nook1[2 * (jjj + 1) + 1]);
                line.setFill(Color.BLACK);
                line.setStrokeWidth(3.0);
                root1.getChildren().add(line);
            }
        }

        String cranny = crannies;
        String[] cranny1 = new String[6];
        double[] cranny2 = new double[4];
        for (int i = 0; i < 6; i++) {
            cranny1[i] = "" + cranny.charAt(3 * i) + cranny.charAt(3 * i + 1) + cranny.charAt(3 * i + 2);
        }
        for (int i = 0; i < 6; i++) {
            int cra = Integer.valueOf(cranny1[i]);
            for (int j = 0; j < 217; j++) {
                if (cranny1[i].equals(num_idx[j]) && cra >= 169 && cra <= 176) {
                    cranny2[0] = hexcen_x[j] + 0.5 * a;
                    cranny2[1] = hexcen_y[j] - 0.5 * l;
                    cranny2[2] = hexcen_x[j] + 0.5 * a;
                    cranny2[3] = hexcen_y[j] + 0.5 * l;
                }
                if (cranny1[i].equals(num_idx[j]) && cra >= 177 && cra <= 184) {
                    cranny2[0] = hexcen_x[j] + 0.5 * a;
                    cranny2[1] = hexcen_y[j] + 0.5 * l;
                    cranny2[2] = hexcen_x[j];
                    cranny2[3] = hexcen_y[j] + l;
                }
                if (cranny1[i].equals(num_idx[j]) && cra >= 185 && cra <= 192) {
                    cranny2[0] = hexcen_x[j] - 0.5 * a;
                    cranny2[1] = hexcen_y[j] + 0.5 * l;
                    cranny2[2] = hexcen_x[j];
                    cranny2[3] = hexcen_y[j] + l;
                }
                if (cranny1[i].equals(num_idx[j]) && cra >= 193 && cra <= 200) {
                    cranny2[0] = hexcen_x[j] - 0.5 * a;
                    cranny2[1] = hexcen_y[j] - 0.5 * l;
                    cranny2[2] = hexcen_x[j] - 0.5 * a;
                    cranny2[3] = hexcen_y[j] + 0.5 * l;
                }
                if (cranny1[i].equals(num_idx[j]) && cra >= 201 && cra <= 208) {
                    cranny2[0] = hexcen_x[j] - 0.5 * a;
                    cranny2[1] = hexcen_y[j] - 0.5 * l;
                    cranny2[2] = hexcen_x[j];
                    cranny2[3] = hexcen_y[j] - l;
                }
                if (cranny1[i].equals(num_idx[j]) && cra >= 209 && cra <= 216) {
                    cranny2[0] = hexcen_x[j] + 0.5 * a;
                    cranny2[1] = hexcen_y[j] - 0.5 * l;
                    cranny2[2] = hexcen_x[j];
                    cranny2[3] = hexcen_y[j] - l;
                }
            }
            Line line1 = new Line(cranny2[0], cranny2[1], cranny2[2], cranny2[3]);
            line1.setFill(Color.BLACK);
            line1.setStrokeWidth(3.0);
            root1.getChildren().add(line1);

        }

        double[] bon_type1 = new double[6];
        double[] bon_type2 = new double[8];
        for (int w = 0; w < 217; w++) {
            //if (num_idx[w])
            int cc = Integer.valueOf(num_idx[w]);
            if (cc >= 170 && cc <= 176) {
                bon_type1[0] = hextop_x[w] - 0.5 * a;
                bon_type1[1] = hextop_y[w] + 0.5 * l;
                bon_type1[2] = hextop_x[w];
                bon_type1[3] = hextop_y[w];
                bon_type1[4] = hextop_x[w] + 0.5 * a;
                bon_type1[5] = hextop_y[w] + 0.5 * l;
            }
            if (cc >= 178 && cc <= 184) {
                bon_type1[0] = hextop_x[w];
                bon_type1[1] = hextop_y[w];
                bon_type1[2] = hextop_x[w] + 0.5 * a;
                bon_type1[3] = hextop_y[w] + 0.5 * l;
                bon_type1[4] = hextop_x[w] + 0.5 * a;
                bon_type1[5] = hextop_y[w] + 1.5 * l;
            }
            if (cc >= 186 && cc <= 192) {
                bon_type1[0] = hextop_x[w] + 0.5 * a;
                bon_type1[1] = hextop_y[w] + 0.5 * l;
                bon_type1[2] = hextop_x[w] + 0.5 * a;
                bon_type1[3] = hextop_y[w] + 1.5 * l;
                bon_type1[4] = hextop_x[w];
                bon_type1[5] = hextop_y[w] + 2.0 * l;
            }
            if (cc >= 194 && cc <= 200) {
                bon_type1[0] = hextop_x[w] - 0.5 * a;
                bon_type1[1] = hextop_y[w] + 1.5 * l;
                bon_type1[2] = hextop_x[w];
                bon_type1[3] = hextop_y[w] + 2.0 * l;
                bon_type1[4] = hextop_x[w] + 0.5 * a;
                bon_type1[5] = hextop_y[w] + 1.5 * l;
            }
            if (cc >= 202 && cc <= 208) {
                bon_type1[0] = hextop_x[w] - 0.5 * a;
                bon_type1[1] = hextop_y[w] + 0.5 * l;
                bon_type1[2] = hextop_x[w] - 0.5 * a;
                bon_type1[3] = hextop_y[w] + 1.5 * l;
                bon_type1[4] = hextop_x[w];
                bon_type1[5] = hextop_y[w] + 2.0 * l;
            }
            if (cc >= 210 && cc <= 216) {
                bon_type1[0] = hextop_x[w];
                bon_type1[1] = hextop_y[w];
                bon_type1[2] = hextop_x[w] - 0.5 * a;
                bon_type1[3] = hextop_y[w] + 0.5 * l;
                bon_type1[4] = hextop_x[w] - 0.5 * a;
                bon_type1[5] = hextop_y[w] + 1.5 * l;
            }
            if (cc == 169) {
                bon_type2[0] = hexcen_x[w] - 0.5 * a;
                bon_type2[1] = hexcen_y[w] + 0.5 * l;
                bon_type2[2] = hexcen_x[w] - 0.5 * a;
                bon_type2[3] = hexcen_y[w] - 0.5 * l;
                bon_type2[4] = hexcen_x[w];
                bon_type2[5] = hexcen_y[w] - l;
                bon_type2[6] = hexcen_x[w] + 0.5 * a;
                bon_type2[7] = hexcen_y[w] - 0.5 * l;
            }
            if (cc == 177) {
                bon_type2[0] = hexcen_x[w] - 0.5 * a;
                bon_type2[1] = hexcen_y[w] - 0.5 * l;
                bon_type2[2] = hexcen_x[w];
                bon_type2[3] = hexcen_y[w] - l;
                bon_type2[4] = hexcen_x[w] + 0.5 * a;
                bon_type2[5] = hexcen_y[w] - 0.5 * l;
                bon_type2[6] = hexcen_x[w] + 0.5 * a;
                bon_type2[7] = hexcen_y[w] + 0.5 * l;
            }
            if (cc == 185) {
                bon_type2[0] = hexcen_x[w];
                bon_type2[1] = hexcen_y[w] - l;
                bon_type2[2] = hexcen_x[w] + 0.5 * a;
                bon_type2[3] = hexcen_y[w] - 0.5 * l;
                bon_type2[4] = hexcen_x[w] + 0.5 * a;
                bon_type2[5] = hexcen_y[w] + 0.5 * l;
                bon_type2[6] = hexcen_x[w];
                bon_type2[7] = hexcen_y[w] + 1.0 * l;
            }
            if (cc == 193) {
                bon_type2[0] = hexcen_x[w] + 0.5 * a;
                bon_type2[1] = hexcen_y[w] - 0.5 * l;
                bon_type2[2] = hexcen_x[w] + 0.5 * a;
                bon_type2[3] = hexcen_y[w] + 0.5 * l;
                bon_type2[4] = hexcen_x[w];
                bon_type2[5] = hexcen_y[w] + 1.0 * l;
                bon_type2[6] = hexcen_x[w] - 0.5 * a;
                bon_type2[7] = hexcen_y[w] + 0.5 * l;
            }
            if (cc == 201) {
                bon_type2[0] = hexcen_x[w] - 0.5 * a;
                bon_type2[1] = hexcen_y[w] - 0.5 * l;
                bon_type2[2] = hexcen_x[w] - 0.5 * a;
                bon_type2[3] = hexcen_y[w] + 0.5 * l;
                bon_type2[4] = hexcen_x[w];
                bon_type2[5] = hexcen_y[w] + 1.0 * l;
                bon_type2[6] = hexcen_x[w] + 0.5 * a;
                bon_type2[7] = hexcen_y[w] + 0.5 * l;
            }
            if (cc == 209) {
                bon_type2[0] = hexcen_x[w];
                bon_type2[1] = hexcen_y[w] - 1.0 * l;
                bon_type2[2] = hexcen_x[w] - 0.5 * a;
                bon_type2[3] = hexcen_y[w] - 0.5 * l;
                bon_type2[4] = hexcen_x[w] - 0.5 * a;
                bon_type2[5] = hexcen_y[w] + 0.5 * l;
                bon_type2[6] = hexcen_x[w];
                bon_type2[7] = hexcen_y[w] + 1.0 * l;
            }
            for (int ww = 0; ww < 2; ww++) {
                Line line3 = new Line(bon_type1[2 * ww], bon_type1[2 * ww + 1], bon_type1[2 * (ww + 1)], bon_type1[2 * (ww + 1) + 1]);
                line3.setFill(Color.BLACK);
                line3.setStrokeWidth(3.0);
                root1.getChildren().add(line3);
            }
            for (int www = 0; www < 3; www++) {
                Line line4 = new Line(bon_type2[2 * www], bon_type2[2 * www + 1], bon_type2[2 * (www + 1)], bon_type2[2 * (www + 1) + 1]);
                line4.setFill(Color.BLACK);
                line4.setStrokeWidth(3.0);
                root1.getChildren().add(line4);
            }
        }


        int[] min_idx = new int[x.length];
        for (int i=0;i<x.length;i++){
            for (int p=0;p<217;p++){
                if (x[i]==Integer.valueOf(num_idx[p])){
                    min_idx[i] = p;
                }
            }
        }
        Button button3 = new Button(" GIVE UP ! SHOW PATH!");
        button3.setTranslateX(800);
        button3.setTranslateY(800);
        root1.getChildren().add(button3);

        button3.setOnAction(event -> {
            BasicalScore.setFill(Color.RED);
            BasicalScore.textProperty().bind(Score.asString("ExtraScore: 0"));
            for (int pp = 0; pp < x.length - 1; pp++) {
                Line min_line = new Line(hexcen_x[min_idx[pp]], hexcen_y[min_idx[pp]], hexcen_x[min_idx[pp+1]], hexcen_y[min_idx[pp+1]]);
                min_line.setStroke(Color.GREEN);
                min_line.setStrokeWidth(4.0);
                root1.getChildren().add(min_line);
            }

        });

        window.setScene(scene1);
        window.setTitle("Our game !!!");
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
