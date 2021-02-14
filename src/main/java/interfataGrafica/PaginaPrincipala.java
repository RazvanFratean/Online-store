package interfataGrafica;

import com.sun.org.apache.bcel.internal.generic.NEW;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import javax.swing.text.TabExpander;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class PaginaPrincipala  implements ActionListener{
    private JFrame frame = new JFrame();
    private Panel header = new Panel();
    private Panel body = new Panel();
    private Panel bottom = new Panel();
    private JLabel label = new JLabel("", new ImageIcon("C:/Users/razvan/Downloads/computer-2982270_640.jpg"), SwingConstants.HORIZONTAL);
    private JTextField text = new JTextField("DEPOZITUL DE IT");
    private JMenuBar mb = new JMenuBar();
    private JMenu menu = new JMenu("Categorii produse");
    private JMenu submenu1 = new JMenu("Telefoane - Tablete");
    private JMenu submenu2 = new JMenu("Laptopuri - Calculatoare");
    private JMenuItem firstItem = new JMenuItem("Telefoane");
    private JMenuItem secondItem = new JMenuItem("Tablete");
    private JMenuItem thirdItem = new JMenuItem("Televizoare");
    private JMenuItem forthItem = new JMenuItem("Laptopuri");
    private JMenuItem fifthItem = new JMenuItem("Calculatoare");
    private JMenu cautareMenu = new JMenu("Cauta produs");
    private JMenu submenu3 = new JMenu("Cautare dupa denumire");
    private JMenu submenu4= new JMenu("Cautare dupa pret");
    private JMenu contMenu = new JMenu("Contul meu");
    private JMenuItem conectItem = new JMenuItem("Conecteaza-te");
    private JMenuItem creareContItem = new JMenuItem("Creare cont nou");


    public PaginaPrincipala()  {
        frame.setTitle("Depozitul de IT");
        frame.setSize(800, 450);
        frame.setLayout(null);
        frame.setBackground(Color.blue);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.add(header);
        header.setBounds(5, 0, 800, 250);
        header.setLayout(null);
        header.add(text);
        text.setBackground(Color.blue);
        text.setSize(200, 100);
        text.setHorizontalAlignment(JTextField.CENTER);
        text.setFont(new Font("SansSerif", Font.PLAIN, 20));
        header.add(label);
        label.setBounds(200, 0, 600, 100);
        frame.add(body);
        body.setBounds(5, 250, 800, 200);
        body.setLayout(null);
        body.add(mb);
        submenu1.add(firstItem);
        submenu1.add(secondItem);
        menu.add(submenu1);
        menu.add(thirdItem);
        submenu2.add(forthItem);
        submenu2.add(fifthItem);
        menu.add(submenu2);
        mb.add(menu);
        cautareMenu.add(submenu3);
        cautareMenu.add(submenu4);
        mb.add(cautareMenu);
        contMenu.add(conectItem);
        contMenu.add(creareContItem);
        mb.add(contMenu);
        frame.setJMenuBar(mb);
        conectItem.addActionListener(this);
        submenu3.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        creareContItem.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreateNewAccount newAccount = new CreateNewAccount();
                newAccount.showNewAccount();
            }
        });
    }

    public static void main(String[] args) {
            new PaginaPrincipala();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            Login log = new Login();
            log.showLogin();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
