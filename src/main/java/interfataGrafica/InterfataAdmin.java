package interfataGrafica;


import javax.swing.*;
import java.awt.*;

public class InterfataAdmin {
    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel();
    private JPanel header = new JPanel();
    private JButton adaugareButton = new JButton("Adauga produs nou");
    private JButton stergereButton = new JButton("Sterge produs");
    private JButton modificareButton = new JButton("Modifica produs");
    private JMenuBar mb = new JMenuBar();
    private JTextField text = new JTextField("Administrare baza de date");

    public InterfataAdmin() {
        frame.setTitle("Administrator");
        frame.setSize(1500, 950);
        frame.setLayout(null);
        frame.setBackground(Color.blue);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.add(header);
        header.setBounds(5, 0, 1500, 100);
        header.setLayout(null);
        header.add(text);
        text.setBackground(Color.gray);
        text.setSize(1500, 100);
        text.setHorizontalAlignment(JTextField.CENTER);
        text.setFont(new Font("SansSerif", Font.PLAIN, 60));
        text.setEditable(false);
        adaugareButton.setBounds(0,10,500,80);
        stergereButton.setBounds(500,10,500,80);
        modificareButton.setBounds(1000,10,500,80);
        mb.add(adaugareButton);
        mb.add(stergereButton);
        mb.add(modificareButton);
        mb.setPreferredSize(new Dimension(1500,80));
        frame.setJMenuBar(mb);
        panel.setBounds(0,100,1500,800);
        panel.add(mb);
        frame.add(panel);
    }
}
