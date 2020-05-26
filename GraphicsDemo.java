import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class GraphicsDemo extends JPanel {


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.BLACK);

        Graphics2D g2D = (Graphics2D) g;
        g2D.setColor(Color.BLUE);
        g2D.setStroke(new BasicStroke(20));
        g2D.drawLine(0, 0, 400, 400);
        g2D.setFont(new Font("Comic Sans", Font.ITALIC, 25));
        g2D.setColor(Color.GREEN);
        g2D.drawString("Hello there.", 100, 100);
        g2D.fillRect(100, 400, 100, 100);

        g2D.setColor(Color.CYAN);
        g2D.fillOval(300, 100, 100, 100);


    }

}
