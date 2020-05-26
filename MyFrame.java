import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    GraphicsDemo demo = new GraphicsDemo();

    public GraphicsDemo getDemo() {
        return demo;
    }

    public MyFrame() {
        this.setSize(420, 420);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(demo);
        this.setVisible(true);

    }

    public static void main(String[] args) {
        MyFrame frame = new MyFrame();

    }
}
