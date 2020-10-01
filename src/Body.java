import java.awt.*;

public class Body implements Movable{

    public final static int SIZE = 10;

    public Body(int x, int y, Color c) {
        this.posX = x;
        this.posY = y;
        this.color = c;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public Color getColor() {
        return color;
    }

    public int getSize () {
        return SIZE;
    }

    public int getSPEED() {
        return SPEED;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public void moveUp() {
        this.posY -= SIZE;
    }

    @Override
    public void moveDown() {
        this.posY += SIZE;
    }

    @Override
    public void moveRight() {
        this.posX += SIZE;
    }

    @Override
    public void moveLeft() {
        this.posX -= SIZE;
    }

    private int posX;
    private int posY;
    private Color color;
    public static int SPEED;
}
