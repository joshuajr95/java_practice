import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class EvenMoreKeyPractice extends JPanel {

    public static final int SENSITIVITY = 5;
    public static final int FRAME_RATE = 100;
    public static final int ANIMATION_PAUSE = 1000/FRAME_RATE;

    private Rectangle rectangle;
    public int yVelocity = 0;
    public int xVelocity = 0;

    public EvenMoreKeyPractice() {
        rectangle = new Rectangle(0, 0, 50, 50);
    }

    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.fill(rectangle);
    }

    public void moveRectangle() {
        rectangle.setLocation(rectangle.x + xVelocity, rectangle.y + yVelocity);
    }

    public void start() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(!Thread.interrupted()) {
                    try {
                        moveRectangle();
                        repaint();
                        Thread.sleep(ANIMATION_PAUSE);
                    }
                    catch (InterruptedException e) {
                        System.out.print("Animation thread interrupted");
                    }
                }
            }
        }).start();
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame();

        final EvenMoreKeyPractice keyPractice = new EvenMoreKeyPractice();

        // get the input map to add input keystrokes
        InputMap inputMap = keyPractice.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, false), "Move Up");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, false), "Move Down");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, false), "Move Left");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, false), "Move Right");

        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, true), "Move Up Release");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, true), "Move Down Release");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, true), "Move Left Release");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, true), "Move Right Release");


        // get the action map to add actions corresponding to the input keystrokes
        ActionMap actionMap = keyPractice.getActionMap();

        actionMap.put("Move Up", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                keyPractice.yVelocity = -1*EvenMoreKeyPractice.SENSITIVITY;
            }
        });

        actionMap.put("Move Up Release", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                keyPractice.yVelocity = 0;
            }
        });

        actionMap.put("Move Down", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                keyPractice.yVelocity = EvenMoreKeyPractice.SENSITIVITY;
            }
        });

        actionMap.put("Move Down Release", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                keyPractice.yVelocity = 0;
            }
        });

        actionMap.put("Move Left", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                keyPractice.xVelocity = -1*EvenMoreKeyPractice.SENSITIVITY;
            }
        });

        actionMap.put("Move Left Release", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                keyPractice.xVelocity = 0;
            }
        });

        actionMap.put("Move Right", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                keyPractice.xVelocity = EvenMoreKeyPractice.SENSITIVITY;
            }
        });

        actionMap.put("Move Right Release", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                keyPractice.xVelocity = 0;
            }
        });

        keyPractice.start();

        frame.add(keyPractice);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }



}
