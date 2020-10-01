import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Window extends JFrame implements KeyListener {

    public final static int  WIDTH = 600;
    public final static int HEIGHT = 600;
    public final static Player player = new Player();
    private static boolean over = false;


    public Window() {

        this.setTitle("Snake - Rétro - v1.0.0");
        this.setSize(defaultWIDTH,defaultHEIGHT);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(Color.RED);
        this.setContentPane(panel);
        this.setVisible(true);


        addKeyListener(this);
        requestFocusInWindow();

        snake = new Snake(this.getGraphics(),3);
        item = new Item(this.getGraphics());

        start();
    }

    private void start() {
        boolean modifier = false;
        snake.create();

        while(!over) {

            snake.refresh();
            item.create(snake);
            snake.draw();
            item.draw();
            snake.move();

            collide();

            try {
                if(player.getScore() < 5){
                    Thread.sleep( 400 / 2);
                }
                else {
                    Thread.sleep(400 / (2 * (player.getScore() / 5)));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public  void collide() {
        int i;
        Body head = snake.getBodies().get(0);

        for (i = 0 ; i < item.getItems().size(); i++) {
            Body lastPos = snake.bodies.get(snake.bodies.size() - 1);
            Item checkItems = item.getItems().get(i);

            if( (checkItems.getPosX() == head.getPosX()) && (checkItems.getPosY() == head.getPosY()) ) {
                item.getItems().remove(i);
                snake.bodies.add(new Body((lastPos.getPosX()) + Body.SIZE, 0,Color.decode("#0F9B0D")));
                player.setScore(player.getScore() + 1);
                player.setLevel();
            }
        }

        //snake.collide(); //collision avec corps du snake

        if(head.getPosX() < -1) {
            System.out.println("dans le window 1");
            over = true;
        }

        if(head.getPosY() < 20) {
            System.out.println("dans le window 2");
            over = true;
        }

        if(head.getPosX() > this.getWidth() - Body.SIZE) {
            System.out.println("dans le window 3");
            over = true;
        }

        if(head.getPosY() > this.getHeight() - Body.SIZE) {
            System.out.println("dans le window 4");
            over = true;
        }

        if(over) {
            panel.repaint();
            snake.refresh();
            snake.draw();
            item.draw();
            System.out.println("Oh non Game Over ! Ton snake est mort =(");
            System.out.println("Ton score : " + player.getScore());
            this.setVisible(true);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int touche = e.getKeyCode();

        switch (touche) {
            case KeyEvent.VK_UP :
                if(snake.getDirection() != 2) {
                    snake.setDirection(1);
                    break;
                }
            case KeyEvent.VK_DOWN :
                if(snake.getDirection() != 1) {
                    snake.setDirection(2);
                    break;
                }
            case KeyEvent.VK_RIGHT :
                if(snake.getDirection() != 4) {
                    snake.setDirection(3);
                    break;
                }
            case KeyEvent.VK_LEFT :
                if(snake.getDirection() != 3) {
                    snake.setDirection(4);
                    break;
                }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //touche appuyée
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //touche relachée
    }

    public static void setOver(boolean isOver) {
        over = isOver;
    }

    public static boolean isOver() {
        return over;
    }

    public int defaultWIDTH = 600;
    public int defaultHEIGHT = 600;
    Snake snake;
    Item item;
    Panel panel = new Panel();
}
