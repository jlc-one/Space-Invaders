package Assets;

import Main.Globals;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class BunkerSegment extends Asset implements BitmapIcons{

    public BunkerSegment(double xPos, double yPos) {
        super(new Polygon(0,0,10,0,10,10,0,10), xPos, yPos);
        getAsset().setStrokeWidth(0);
        getAsset().setStroke(Globals.GREEN);
        getAsset().setFill(Globals.GREEN);

    }



    @Override
    public void InitialiseImages() {

    }
}
