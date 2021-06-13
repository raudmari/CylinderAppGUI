import javax.swing.*;
import java.awt.*;

public class View extends JFrame {

    public View() throws HeadlessException {
        super("Graafiline silinder");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500, 400));

        MyPanel myPanel = new MyPanel();
        add(myPanel);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);

    }
}
