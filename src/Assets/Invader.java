package Assets;

import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

import javafx.scene.image.Image;
import javafx.scene.text.Text;

public class Invader extends Asset implements BitmapIcons{

    private Image bitmap;
    private short moveDirection = 1;
    private int id;
    private int score;

    private int row;
    private int col;
    private boolean toMoveDown = false;



    private int phase = 1;
    private int color = 1;
    private Image phase1white;
    private Image phase2white;
    private Image phase1green;
    private Image phase2green;
    private Image dead = Bitmaps.typeDead;
    private Image currentImage;
    public ImageView currentIV;




    public Invader(int xPos, int yPos) {
        super(new Polygon(-17, -13, -17, 13, 17, 13, 17, -13), xPos, yPos);
        getAsset().setStrokeWidth(0);

    }

    public void setId(int id) {
        this.id = id;

    }

    public int getId() {
        return id;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getCol() {
        return col;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getRow() {
        return row;
    }

    public void setToMoveDown(boolean toMoveDown) {
        this.toMoveDown = toMoveDown;
    }

    public boolean getToMoveDown() {
        return toMoveDown;
    }

    @Override
    public void moveX(double moveSpeed) {
        phase *= -1;
        setCurrentImage();
        this.getAsset().setTranslateX(this.getAsset().getTranslateX() + moveSpeed);
        currentIV.setTranslateX(this.getX());
    }

    @Override
    public void moveY(double moveSpeed) {
        this.getAsset().setTranslateY(this.getAsset().getTranslateY() + moveSpeed);
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void setMoveDirection(short moveDirection) {
        this.moveDirection = moveDirection;
    }

    public int getMoveDirection() {
        return moveDirection;
    }

    @Override
    public void InitialiseImages() {
        if (this.id < 22) {
            phase1white = Bitmaps.type1a;
            phase2white = Bitmaps.type1b;
            phase1green = Bitmaps.type1ag;
            phase2green = Bitmaps.type1bg;
        } else if (this.id < 44) {
            phase1white = Bitmaps.type2a;
            phase2white = Bitmaps.type2b;
            phase1green = Bitmaps.type2ag;
            phase2green = Bitmaps.type2bg;
        } else {
            phase1white = Bitmaps.type3a;
            phase2white = Bitmaps.type3b;
            phase1green = Bitmaps.type3ag;
            phase2green = Bitmaps.type3bg;
        }
        setCurrentImage();
        setCurrentImageView();
    }

    private Image getImage(int image) {
        switch (image) {
            case -2:
                return phase1green;
            case -1:
                return phase1white;
            case 1:
                return phase2white;
            case 2:
                return phase2green;

        }
        return dead;
    }

    private int getPhaseID() {
        return phase * color;
    }

    private void setCurrentImage() {
        this.currentImage = getImage(getPhaseID());
    }

    public ImageView getCurrentImageView() {

        return currentIV;
    }


    public void setCurrentImageView() {

        ImageView img = new ImageView();
        img.setFitWidth(34);
        img.setFitHeight(26);
        img.setTranslateX(getAsset().getTranslateX());
        img.setTranslateY(this.getY());
        if (!this.getAlive()) {
            img.setImage(dead);
        } else {
            img.setImage(currentImage);
        }
        currentIV = img;


    }
}
