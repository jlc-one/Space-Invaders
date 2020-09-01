package Assets;

import Main.Globals;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class EnemyShotPolygons {

    public static Polygon getType0(double xPos, double yPos) {
        Polygon polygon;

        int phase = (int) yPos % 64;

        if (phase < 32) {
            polygon = new Polygon(0, 0, 4, 4, -4, 12, 4, 20, 0, 24, 1, 24, 5, 20, -3, 12, 5, 4, 1, 0);
        } else {
            polygon = new Polygon(0, 0, -4, 4, 4, 12, -4, 20, 0, 24, -1, 24, -5, 20, 3, 12, -5, 4, -1, 0);
        }
        polygon.setTranslateX(xPos);
        polygon.setTranslateY(yPos);

        polygon.setStrokeWidth(0);
        polygon.setFill(Globals.GREEN);

        if (polygon.getTranslateY() > 570) {
            polygon.setFill(Globals.GREEN);
        } else {
            polygon.setFill(Color.WHITE);
        }

        return polygon;
    }

    public static Polygon getType1(double xPos, double yPos) {
        Polygon polygon;

        int phase = (int) yPos % 64;

        if (phase < 16) {
            polygon = new Polygon(-3,0, -3,3, 0,3, 0,20, 1,20, 1,3, 4,3, 4,0);
        } else if (phase < 32) {
            polygon = new Polygon(0,0, 0,5, -3,5, -3,8, 0,8, 0,20, 1,20, 1,8, 4,8, 4,5, 1,5, 1,0);
        } else if (phase < 48) {
            polygon = new Polygon(0,0, 0,10, -3,10, -3,13, 0,13, 0,20, 1,20, 1,13, 4,13, 4,10, 1,10, 1,0);
        } else {
            polygon = new Polygon(0,0, 0,17, -3,17, -3,20, 4,20, 4,17, 1,17, 1,0);
        }

        polygon.setTranslateX(xPos);
        polygon.setTranslateY(yPos);

        polygon.setStrokeWidth(1);
        polygon.setFill(Globals.GREEN);

        if (polygon.getTranslateY() > 570) {
            polygon.setFill(Globals.GREEN);
        } else {
            polygon.setFill(Color.WHITE);
        }

        return polygon;
    }

    public static Polygon getType2(double xPos, double yPos) {
        Polygon polygon;

        int phase = (int) yPos % 64;

        if (phase < 16) {
            polygon = new Polygon(0,0, 0,20, 1,20, 1,0, -4,0);
        } else if (phase < 32) {
            polygon = new Polygon(4,-2, -3,5, -3,7, 0,4, 0,12, -3, 15, -3,17, 0,14, 0,20, 1,20, 1,13, 4,10, 4,8, 1,11, 1,2, 4,0);
        } else if (phase < 48) {
            polygon = new Polygon(0,0, 0,20, 1,20, 1,0, -4,0);
        } else {
            polygon = new Polygon(4,-2, -3,5, -3,7, 0,4, 0,12, -3, 15, -3,17, 0,14, 0,20, 1,20, 1,13, 4,10, 4,8, 1,11, 1,2, 4,0);
            polygon.setRotate(180);
        }

        polygon.setTranslateX(xPos);
        polygon.setTranslateY(yPos);

        polygon.setStrokeWidth(0);
        polygon.setFill(Globals.GREEN);

        if (polygon.getTranslateY() > 570) {
            polygon.setFill(Globals.GREEN);
        } else {
            polygon.setFill(Color.WHITE);
        }

        return polygon;
    }
}
