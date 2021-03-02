package interfataGrafica;

import javax.swing.*;
import java.awt.*;

public class InterfataClient {
    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel();

    public InterfataClient() {
        frame.setTitle("Client");
        frame.setSize(800,450);
        frame.setLayout(null);
        frame.setBackground(Color.yellow);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.add(panel);
    }
}
