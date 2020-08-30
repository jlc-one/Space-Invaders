package Main;

import Logic.EnemyTracking;
import javafx.scene.text.Font;

import java.io.IOException;
import java.io.InputStream;

public class Globals {

    public static Font font = Font.loadFont("File:graphics/PressStart2P-Regular.ttf", 22);



    public static Font getFont() {
        return font;
    }

    //window size
    final public static short WIDTH = 672;
    final public static short HEIGHT = 768;

    //common
    public static float volume = 0.3f;


    //player settings
    final public static float playerMoveSpeed = 3f; //3
    final public static short sidePadding = 40;
    final public static short bottomPadding = 110;
    final public static short playerShotSpeed = -15;
    final public static short topPadding = 90;

    //enemy settings
    final public static short enemyMovementPerFrame = 4; //4
    final public static short enemySidePadding = 76;
    final public static short enemyMovementDown = 20;
    final public static short enemyVertSpacing = 50;
    final public static short enemyHozSpacing = 45;
    final public static short enemyProjectileSpeed = 5;


}
