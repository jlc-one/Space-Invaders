package Assets;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

public class EnemyShot extends Asset{

    private int shotType;
    private Polygon asset;
    private boolean addedToScreen;

    public EnemyShot(double xPos, double yPos, int shotType) {
        super(new Polygon(-1,-5,1,-5,1,5,-1,5), xPos, yPos);

        this.shotType = shotType;
        addedToScreen = false;
        getAsset().setStrokeWidth(0);
        getAsset().setFill(Color.WHITE);
        //setPolygon();
    }


    public Polygon getPoly() {
        addedToScreen = true;
        return getAsset();
    }

    public boolean getAddedToScreen() {
        return addedToScreen;
    }

    private void setPolygon() {
        if (shotType == 0) {

        } else if (shotType == 1) {

        } else {
            
        }
    }


}
