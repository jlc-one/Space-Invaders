package Assets;

import Main.Globals;
import Main.SpaceInvaders;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class Player extends Asset implements BitmapIcons{

    private Image bitmap;
    private Image dead;
    private ImageView imageView;
    private boolean canShoot = true;
    private boolean hasReleased = true;

    public Player(int xPos, int yPos) {
        super(new Polygon(-5, -5, -5, 5, 5, 5, 5, -5), xPos, yPos);
        getAsset().setStroke(Color.LIMEGREEN);
        InitialiseImages();
    }

    public void setCanShoot(boolean canShoot) {
        this.canShoot = canShoot;
    }

    public boolean getCanShoot() {
        return canShoot;
    }

    public void setHasReleased(boolean released) {
        hasReleased = released;
    }

    public boolean getHasReleased() {
        return hasReleased;
    }

    @Override
    public void moveX(double moveSpeed) {

        this.getAsset().setTranslateX(this.getAsset().getTranslateX() + moveSpeed);
        imageView.setTranslateX(this.getX() - 15);
    }


    @Override
    public void InitialiseImages() {
        bitmap = Bitmaps.player;
        dead = Bitmaps.typeDead;
        setImageView();
    }

    public void setImageView() {
        ImageView img = new ImageView();
        img.setFitWidth(34);
        img.setFitHeight(26);
        img.setTranslateX(getX()  - 15);
        img.setTranslateY(getY());
        if (!this.getAlive()) {
            img.setImage(dead);
        } else {
            img.setImage(bitmap);
        }
        imageView = img;
    }

    public ImageView getImageView() {
        return imageView;
    }





}
