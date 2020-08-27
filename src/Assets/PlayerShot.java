package Assets;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class PlayerShot extends Asset{



    public PlayerShot(double xPos, double yPos) {
        super(new Polygon(-1,-5,1,-5,1,5,-1,5), xPos, yPos);
        getAsset().setStrokeWidth(0);
        getAsset().setFill(Color.LIME);
    }


}
