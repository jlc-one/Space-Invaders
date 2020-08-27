package Assets;

import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

public class EnemyShot extends Asset{

    private short shotType;
    private Polygon asset;

    public EnemyShot(Polygon polygon, double xPos, double yPos, short shotType) {
        super(polygon, xPos, yPos);

        this.shotType = shotType;
        setPolygon();
    }

    private void setPolygon() {
        if (shotType == 0) {

        } else if (shotType == 1) {

        } else {
            
        }
    }


}
