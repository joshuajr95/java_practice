import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class NewMyFrame extends Frame {

    public NewMyFrame() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                //dispose();
                System.exit(0);
            }
        });
        this.setSize(420, 420);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        NewMyFrame frame = new NewMyFrame();

    }
}
