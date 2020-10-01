import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {

    public void paintComponent(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        Font font = new Font("Deja Vu Sans Mono", Font.BOLD, 20);
        g.setFont(font);
        g.setColor(Color.white);
        g.drawString("Score : " + Window.player.getScore(), 10, 29);
    }
}
