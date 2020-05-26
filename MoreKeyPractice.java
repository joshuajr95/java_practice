import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class MoreKeyPractice extends JPanel {

    public static final int sensitivity = 5;

    private Rectangle rectangle;

    public MoreKeyPractice() {
        rectangle = new Rectangle(0, 0, 100, 100);
    }

    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.fill(rectangle);
    }

    public void moveRectangle(int deltaX, int deltaY) {
        rectangle.setLocation(rectangle.x + deltaX, rectangle.y - deltaY);
        repaint();
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame();

        final MoreKeyPractice keyPractice = new MoreKeyPractice();

        // get the input map to add input keystrokes
        InputMap inputMap = keyPractice.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, false), "Move Up");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, false), "Move Down");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, false), "Move Left");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, false), "Move Right");

        /*inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, true), "Move Up Release");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, true), "Move Down Release");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, true), "Move Left Release");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, true), "Move Right Release");
        */

        // get the action map to add actions corresponding to the input keystrokes
        ActionMap actionMap = keyPractice.getActionMap();
        actionMap.put("Move Up", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                keyPractice.moveRectangle(0, MoreKeyPractice.sensitivity);
            }
        });

        actionMap.put("Move Down", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                keyPractice.moveRectangle(0, -1*MoreKeyPractice.sensitivity);
            }
        });

        actionMap.put("Move Left", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                keyPractice.moveRectangle(-1*MoreKeyPractice.sensitivity, 0);
            }
        });

        actionMap.put("Move Right", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                keyPractice.moveRectangle(MoreKeyPractice.sensitivity, 0);
            }
        });

        frame.add(keyPractice);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
