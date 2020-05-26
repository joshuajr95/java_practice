import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyPracticeFrame {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        final MyPanel panel = new MyPanel();
        panel.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    panel.moveRectangle(0, -1*MyPanel.sensitivity);
                }
                else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    panel.moveRectangle(0, MyPanel.sensitivity);
                }
                else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
                    panel.moveRectangle(-1*MyPanel.sensitivity, 0);
                }
                else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    panel.moveRectangle(MyPanel.sensitivity, 0);
                }
                else {

                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });


        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setVisible(true);
    }

}
