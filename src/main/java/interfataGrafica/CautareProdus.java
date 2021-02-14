package interfataGrafica;

import javax.swing.*;
import java.awt.*;

public class CautareProdus{
    private JFrame frame = new JFrame();;
    private JPanel panel;
    private JLabel label;
    private JComboBox userType_text;

    public CautareProdus() {
        //set the frame
        frame.setSize(300,150);
        frame.setBackground(Color.YELLOW);
        //create a panel to hold the components
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        frame.add(panel);
        //
        // Username Label
        label = new JLabel();
        label.setText("Denumire produs :");
        userType_text = new JTextField();
      
    }
}
