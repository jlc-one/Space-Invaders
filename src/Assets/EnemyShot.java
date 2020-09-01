package Assets;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

public class EnemyShot extends Asset{

    private int shotType;
    private Polygon asset;
    private boolean addedToScreen;
    private int penetrance;


    public EnemyShot(double xPos, double yPos, int shotType) {
        super(new Polygon(), xPos, yPos);
        this.shotType = shotType;
        overwriteAsset(setProperties(shotType, xPos, yPos));
        addedToScreen = false;
        getAsset().setStrokeWidth(0);
        getAsset().setFill(Color.WHITE);

    }

    public void decrementPenetrance() {
        --penetrance;
    }

    public int getPenetrance() {
        return penetrance;
    }

    private Polygon setProperties(int shotType, double xPos, double yPos) {
        if (shotType == 0) {
            penetrance = 1;
            return EnemyShotPolygons.getType0(xPos, yPos);
        } else if (shotType == 1) {
            penetrance = 2;
            return EnemyShotPolygons.getType1(xPos, yPos);
        } else {
            penetrance = 2;
            return EnemyShotPolygons.getType2(xPos, yPos);
        }
    }

    public void updatePolygon() {
        if (shotType == 0) {
            overwriteAsset(EnemyShotPolygons.getType0(getX(), getY()));

        } else if (shotType == 1) {

            overwriteAsset(EnemyShotPolygons.getType1(getX(), getY()));
        } else {

            overwriteAsset(EnemyShotPolygons.getType2(getX(), getY()));
        }
    }


}
