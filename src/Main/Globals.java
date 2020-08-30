package Main;

import javafx.scene.text.Font;

import java.io.IOException;
import java.io.InputStream;

public class Globals {

    public static Font font = Font.loadFont("File:graphics/PressStart2P-Regular.ttf", 22);

    public static Font getFont() {
        return font;
    }

    //window size
    final public static int WIDTH = 672;
    final public static int HEIGHT = 768;

    //common


    //player settings
    final public static double playerMoveSpeed = 3; //3
    final public static int sidePadding = 40;
    final public static int bottomPadding = 120;
    final public static int playerShotSpeed = -15;
    final public static int topPadding = 90;

    //enemy settings
    final public static int enemyMovementPerFrame = 4; //4
    final public static int enemySidePadding = 76;
    final public static int enemyMovementDown = 20;
    final public static int enemyVertSpacing = 50;
    final public static int enemyHozSpacing = 45;


}
