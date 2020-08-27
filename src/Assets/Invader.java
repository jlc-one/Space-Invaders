package Assets;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

import javafx.scene.image.Image;
import javafx.scene.text.Text;

public class Invader extends Asset implements BitmapIcons{

    private Image bitmap;
    private short moveDirection = 1;
    private int id;
    private int score;
    private Text text;
    private int row;
    private int col;
    private boolean toMoveDown = false;


    public Invader(int xPos, int yPos) {
        super(new Polygon(-10, -10, -10, 10, 10, 10, 10, -10), xPos, yPos);
        getAsset().setStroke(Color.WHITE);
    }

    public void setId(int id) {
        this.id = id;
        text = new Text(getX() + 15, getY(), "row " + String.valueOf(row) + "\n col: " + String.valueOf(col));
        text.setFill(Color.WHITE);
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
        this.getAsset().setTranslateX(this.getAsset().getTranslateX() + moveSpeed);
        this.text.setTranslateX(text.getTranslateX() + moveSpeed);
    }

    @Override
    public void moveY(double moveSpeed) {
        this.getAsset().setTranslateY(this.getAsset().getTranslateY() + moveSpeed);
        this.text.setTranslateY(text.getTranslateY() + moveSpeed);
    }


    public Text displayLabel() {
        return text;
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
    public void setImage(Image image) {
        this.bitmap = image;
    }

    public Image getImage() {
        return this.bitmap;
    }


}
