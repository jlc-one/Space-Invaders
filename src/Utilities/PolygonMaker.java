package Utilities;


import Main.Globals;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.StrokeType;

public class PolygonMaker {
    private Polygon polygon0;


    public static Polygon getPolygon0(double xPos, double yPos) {
        Polygon polygon = new Polygon();

        int phase = (int) yPos % 4;

        if (phase % 2 == 0) {
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

    public static Polygon getPolygon1(double xPos, double yPos) {
        Polygon polygon = new Polygon();

        int phase = (int) yPos % 4;
            polygon = new Polygon(-4,0, -4,3, 0,3, 0,20, 1,20, 1,3, 5,3, 5,0);
        if (phase % 4 == 0) {

        } else if (phase % 4 == 1) {
            polygon = new Polygon(0,0, 0,5, -4,5, -4,8, 0,8, 0,20, 1,20, 1,8, 5,8, 5,5, 1,5, 1,0);
        } else if (phase % 4 == 2) {
            polygon = new Polygon(0,0, 0,10, -4,10, -4,13, 0,13, 0,20, 1,20, 1,13, 5,13, 5,10, 1,10, 1,0);
        } else {
            polygon = new Polygon(0,0, 0,17, -4,17, -4,20, 5,20, 5,17, 1,17, 1,0);
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

    public static Polygon getPolygon2(double xPos, double yPos) {
        Polygon polygon;


        int phase = (int) yPos % 64;

        if (phase < 16) {
            polygon = new Polygon(0,0, 0,20, 1,20, 1,0);
        } else if (phase < 32) {
            polygon = new Polygon(4,-2, -3,5, -3,7, 0,4, 0,12, -3, 15, -3,17, 0,14, 0,20, 1,20, 1,13, 4,10, 4,8, 1,11, 1,2, 4,0);
        } else if (phase < 48) {
            polygon = new Polygon(0,0, 0,20, 1,20, 1,0);
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
