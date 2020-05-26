import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MovingRectangle extends Rectangle implements KeyListener {

    public static final int sensitivity = 5;

    public MovingRectangle(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.fill(this);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            this.setLocation(this.x, this.y + MovingRectangle.sensitivity);
        }
        else if(e.getKeyCode() == KeyEvent.VK_UP) {
            this.setLocation(this.x, this.y - MovingRectangle.sensitivity);
        }
        else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            this.setLocation(this.x - MovingRectangle.sensitivity, this.y);
        }
        else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            this.setLocation(this.x + MovingRectangle.sensitivity, this.y);
        }
        else {

        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
