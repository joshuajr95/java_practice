import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyPractice extends JPanel implements KeyListener {

    private Rectangle rectangle;

    public KeyPractice() {
        rectangle = new Rectangle(0, 0, 50, 50);
        addKeyListener(this);
    }

    public void paint(Graphics g) {
        //setSize(500, 500);
        //super.paintComponents();
        Graphics2D g2 = (Graphics2D) g;
        g2.fill(rectangle);
    }

    @Override
    public void keyTyped(KeyEvent event) {

    }

    @Override
    public void keyPressed(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.VK_RIGHT) {
            rectangle.setLocation(rectangle.x + 3, rectangle.y);
        }
        else if (event.getKeyCode() == KeyEvent.VK_LEFT) {
            rectangle.setLocation(rectangle.x - 3, rectangle.y);
        }
        else if(event.getKeyCode() == KeyEvent.VK_UP) {
            rectangle.setLocation(rectangle.x, rectangle.y - 3);
        }
        else if (event.getKeyCode() == KeyEvent.VK_DOWN) {
            rectangle.setLocation(rectangle.x, rectangle.y + 3);
        }
        else {

        }
        //System.out.print("key press received");
        //this.getContentPane().removeAll();
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent event) {

    }

    /*public static void main(String[] args) {
        KeyPractice keyPractice = new KeyPractice();
        keyPractice.setSize(500, 500);
        keyPractice.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        keyPractice.setVisible(true);
    }*/
}
