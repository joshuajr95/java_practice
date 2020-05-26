import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {

    public static final int sensitivity = 5;

    Rectangle rectangle;

    public MyPanel() {
        this.rectangle = new Rectangle(0, 0, 50, 50);
    }

    public void moveRectangle(int deltaX, int deltaY) {
        rectangle.setLocation(rectangle.x + deltaX, rectangle.y + deltaY);
        repaint();
    }

    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.fill(rectangle);
    }
}
