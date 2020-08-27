package Assets;

import Main.Globals;
import Main.SpaceInvaders;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class Player extends Asset implements BitmapIcons{

    private Image bitmap;
    private boolean canShoot = true;

    public Player(int xPos, int yPos) {
        super(new Polygon(-5, -5, -5, 5, 5, 5, 5, -5), xPos, yPos);
        getAsset().setStroke(Color.LIMEGREEN);
    }

    public void setCanShoot(boolean canShoot) {
        this.canShoot = canShoot;
    }

    public boolean getCanShoot() {
        return canShoot;
    }



    @Override
    public void setImage(Image image) {

    }

    @Override
    public Image getImage() {
        return bitmap;
    }



}
