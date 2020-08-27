package Main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

import Assets.Invader;
import Assets.Player;
import Assets.PlayerShot;
import Logic.EnemyBoundLogic;
import Logic.EnemyTracking;
import Logic.Score;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class SpaceInvaders extends Application {


    public static void main(String[] args) {

        System.out.println("Hello, world!");
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        EnemyTracking enemyTracking = new EnemyTracking();
        ArrayList<Invader> invaders = enemyTracking.getInvaders();


        Player player = new Player(Globals.WIDTH / 2, Globals.HEIGHT - Globals.bottomPadding);
        Score score = new Score();

        Pane pane = new Pane();
        pane.setPrefSize(Globals.WIDTH, Globals.HEIGHT);
        BackgroundFill background = new BackgroundFill(Color.BLACK, null, null);
        pane.setBackground(new Background(background));

        Scene scene = new Scene(pane);


        pane.getChildren().add(player.getAsset());
        invaders.forEach(invader -> pane.getChildren().add(invader.getAsset()));
        //invaders.forEach(invader -> pane.getChildren().add(invader.displayLabel()));


        Map<KeyCode, Boolean> pressedKeys = new HashMap();

        scene.setOnKeyPressed(event -> {
            pressedKeys.put(event.getCode(), Boolean.TRUE);
        });

        scene.setOnKeyReleased(event -> {
            pressedKeys.put(event.getCode(), Boolean.FALSE);
        });

        PlayerShot[] playerShot = new PlayerShot[1];


        new AnimationTimer() {
            @Override
            public void handle(long now) {

                if (pressedKeys.getOrDefault(KeyCode.LEFT, Boolean.FALSE) || pressedKeys.getOrDefault(KeyCode.A, Boolean.FALSE)) {
                    if (player.boundaryLeft()) {
                        player.moveX(Globals.playerMoveSpeed * -1);
                    }
                }
                if (pressedKeys.getOrDefault(KeyCode.RIGHT, Boolean.FALSE) || pressedKeys.getOrDefault(KeyCode.D, Boolean.FALSE)) {
                    if (player.boundaryRight()) {
                        player.moveX(Globals.playerMoveSpeed);
                    }
                }
                if (pressedKeys.getOrDefault(KeyCode.SPACE, Boolean.FALSE) && player.getCanShoot()) {
                    PlayerShot shot = new PlayerShot(player.getAsset().getTranslateX(), player.getAsset().getTranslateY());
                    player.setCanShoot(false);
                    playerShot[0] = shot;
                    pane.getChildren().add(shot.getAsset());
                }

                enemyTracking.moveNextInvader();

                //Handle player projectiles
                if (playerShot[0] != null) {
                    playerShot[0].moveY(-6);
                    if (playerShot[0].getY() < 0) {
                        player.setCanShoot(true);
                        pane.getChildren().remove(playerShot[0].getAsset());
                        playerShot[0].setAlive(false);
                    } else {
                        invaders.forEach(invader -> {
                            if (invader.detectCollision(playerShot[0])) {
                                pane.getChildren().remove(playerShot[0].getAsset());
                                invader.setAlive(false);
                                player.setCanShoot(true);
                                playerShot[0].setAlive(false);
                                score.addToScore(invader.getScore());
                            }
                        });
                    }
                    if (!playerShot[0].getAlive()) {
                        playerShot[0] = null;
                    }
                }


                //remove dead invaders
                invaders.stream()
                        .filter(invader -> !invader.getAlive())
                        .forEach(invader -> pane.getChildren().remove(invader.getAsset()));



                //System.out.println("Left most: " + EnemyBoundLogic.leftColumnCalculate(invaders) + "  Right most: " + EnemyBoundLogic.rightColumnCalculate(invaders) + "  Bottom most: " + EnemyBoundLogic.bottomRowCalculate(invaders));



            }
        }.start();

        stage.setTitle("Space Invaders!");
        stage.setScene(scene);
        stage.show();

    }

}
