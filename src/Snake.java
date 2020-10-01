import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Snake extends JPanel {

    public Snake(Graphics g, int size) {
        this.g = g;
        this.size = size;
    }

    public void create() {
        int i;

        for(i = 0; i < this.size; i++) {
            bodies.add(new Body(Window.WIDTH/2 + (i * Body.SIZE), Window.HEIGHT/2, Color.decode("#0F9B0D")));
        }
    }

    public void draw() {
        int i;

        for (i = 0; i < bodies.size(); i++) {
            Body b = bodies.get(i);

            g.setColor(b.getColor());
            g.fillRect(b.getPosX(), b.getPosY(), Body.SIZE, Body.SIZE);
        }
    }

    public void move() {
        int i;
        int y;
        int x;

        for(i = bodies.size() - 1; i > 0; i--) {
            Body b = bodies.get(i-1);
            x = b.getPosX();
            y = b.getPosY();
            b = bodies.get(i);
            b.setPosX(x);
            b.setPosY(y);
        }

        Body head = bodies.get(0);

        switch (direction) {
            case 1 :
                head.moveUp();
                break;
            case 2 :
                head.moveDown();
                break;
            case 3 :
                head.moveRight();
                break;
            case 4 :
                head.moveLeft();
                break;
        }
    }

    public void refresh() {
        g.setColor(Color.black);
        g.fillRect(0, 0, Window.WIDTH, Window.HEIGHT);

        draw();

        Font font = new Font("Deja Vu Sans Mono", Font.BOLD, 20);
        g.setFont(font);
        g.setColor(Color.white);
        g.drawString("Score : " + Window.player.getScore(), 10, 50);

        Font font2 = new Font("Deja Vu Sans Mono", Font.BOLD, 20);
        g.setFont(font);
        g.setColor(Color.white);
        g.drawString("Niveau " + Window.player.getLevel(), 250, 50);

        if(Window.isOver()){
            Font overfont = new Font("Deja Vu Sans Mono", Font.BOLD, 60);
            g.setFont(overfont);
            g.setColor(Color.RED);
            g.drawString("GAME OVER !", Window.WIDTH/6, Window.HEIGHT/2);
        }
    }

    public void collide() {
        int i;
        for(i = 1; i < bodies.size() ; i++) {
            Body head = bodies.get(0);
            Body body = bodies.get(i);

            if((head.getPosX() == body.getPosX()) && (head.getPosY() == head.getPosY())) {
                System.out.println("dans le snake");
                Window.setOver(true);
            }
        }
    }
    public int getPosX() {
        return this.posX;
    }

    public int getPosY() {
        return this.posY;
    }

    public int getDirection() {
        return this.direction;
    }

    public int getSkSize() {
        return size;
    }

    public Graphics getG() {
        return g;
    }

    public ArrayList<Body> getBodies() {
        return bodies;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void afficheBodies() {
        System.out.println(bodies);
    }

    private Graphics g;
    private int posX;
    private int posY;
    private int direction = 4;
    private int size;
    ArrayList<Body> bodies = new ArrayList<>();
}


