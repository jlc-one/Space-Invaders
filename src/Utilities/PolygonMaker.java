package Utilities;


import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class PolygonMaker {
    private Polygon polygon0;



    public Polygon drawPolygon0(double xPos, double yPos) {
        polygon0 = new Polygon(5, 5, -5, 5, -5, -5, 5, -5);
        polygon0.setStroke(Color.WHITE);
        polygon0.setTranslateX(xPos);
        polygon0.setTranslateY(yPos);
        return  polygon0;
    }

}
