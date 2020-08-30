package Assets;


import Main.Globals;
import javafx.geometry.Point2D;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;

abstract class Asset {

    private Point2D movement;
    private boolean alive;
    private boolean toRemove;
    private Polygon asset;


    public Asset(Polygon polygon, double xPos, double yPos) {

        this.asset = polygon;
        this.asset.setTranslateX(xPos);
        this.asset.setTranslateY(yPos);
        this.alive = true;
        this.toRemove = false;
        this.movement = new Point2D(0,0);
    }

    public void setToRemove() {
        toRemove = true;
    }

    public boolean getToRemove() {
        return toRemove;
    }

    public Polygon getAsset() {
        return asset;
    }

    public boolean getAlive() {
        return alive;
    }

    public void setAlive(Boolean status) {
        this.alive = status;
    }

    public void moveX(double moveSpeed) {
        this.asset.setTranslateX(this.asset.getTranslateX() + moveSpeed);
    }

    public void moveY(double moveSpeed) {
        this.asset.setTranslateY(this.asset.getTranslateY() + moveSpeed);
    }

    public double getX() {
        return asset.getTranslateX();
    }

    public double getY() {
        return asset.getTranslateY();
    }

    public boolean detectCollision(Asset other) {
        Shape collisionArea = Shape.intersect(this.asset, other.getAsset());
        return collisionArea.getBoundsInLocal().getWidth() != -1;
    }

    public boolean boundaryLeft() {
        if (this.getAsset().getTranslateX() < Globals.sidePadding) {
            return false;
        }

        return true;
    }

    public boolean boundaryRight() {
        if (this.getAsset().getTranslateX() > Globals.WIDTH - Globals.sidePadding) {
            return false;
        }
        return true;
    }

}
