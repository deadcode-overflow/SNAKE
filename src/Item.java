import java.awt.*;
import java.util.ArrayList;

public class Item {

    public final static int SIZE = 10;
    public final static int ITEMSNB = 1;

    public Item(Graphics g) {
        this.g = g;
    }

    public Item(int x, int y, Color c) {
        this.posX = x;
        this.posY = y;
        this.color = c;
    }

    public void create(Snake snake) {
        int i;
        int randX;
        int randY;

        boolean create = true;

        while(items.size() < ITEMSNB) {


            randX = (int) (Math.random() * ((Window.WIDTH - SIZE) / Body.SIZE));
            randY = (int) (Math.random() * ((Window.HEIGHT - SIZE) / Body.SIZE));

            randX = randX * 10;
            randY = randY * 10;

            if(randY < 40) {
                randY = 40;
            }

            for(i = 0; i < snake.getBodies().size(); i++ ) {
                Body exist = snake.getBodies().get(i);

                if(randX == exist.getPosX() && randY == exist.getPosY()) {
                    create = false;
                }
            }

            if(create) {
                items.add(new Item(randX, randY, Color.red));
            }
        }
    }

    public void draw() {
        int i;

        for(i = 0; i < items.size(); i++) {
            Item itm = items.get(i);

            g.setColor(itm.color);
            g.fillOval(itm.posX, itm.posY, SIZE, SIZE);
        }
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

    public int getSize() {
        return SIZE;
    }

    public Graphics getG() {
        return g;
    }

    public ArrayList<Item> getItems() {
        return items;
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

    private Graphics g;
    private int posX;
    private int posY;
    private Color color;
    private ArrayList<Item> items = new ArrayList<>();
}
