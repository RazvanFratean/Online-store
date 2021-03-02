package interfataGrafica;

import model.Client;
import model.Produs;
import model.Users;
import repository.ClientRepository;
import service.ServiciiClient;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;
import javax.swing.text.TabExpander;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaginaPrincipala  implements ActionListener {
    int categorie;
    String denumire;

    private JFrame frame = new JFrame();
    private Panel header = new Panel();
    private Panel body = new Panel();
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
    private JButton cautareMenu = new JButton("Cauta produs");
    private JTextField denumireItem = new JTextField();
    private JMenu contMenu = new JMenu("Contul meu");
    private JMenuItem conectItem = new JMenuItem("Conecteaza-te");
    private JMenuItem creareContItem = new JMenuItem("Creare cont nou");
    private JMenu dateContactMenu = new JMenu("Despre noi");
    private JTable table;
    private DefaultTableModel model;


    public PaginaPrincipala() throws SQLException {
        try
        {
            //Set the required look and feel
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
            //Update the component tree - associate the look and feel with the given frame.
            SwingUtilities.updateComponentTreeUI(frame);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        ServiciiClient srv = new ServiciiClient();
        frame.setTitle("Depozitul de IT");
        frame.setSize(1500, 900);
        frame.setLayout(null);
        frame.setBackground(Color.blue);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.add(header);
        header.setBounds(5, 0, 1500, 100);
        header.setLayout(null);
        header.add(text);
        text.setBackground(Color.blue);
        text.setSize(600, 100);
        text.setHorizontalAlignment(JTextField.CENTER);
        text.setFont(new Font("SansSerif", Font.PLAIN, 20));
        header.add(label);
        label.setBounds(600, 0, 700, 100);
//        frame.add(body);
//        body.setBounds(5, 100, 1500, 600);
//        body.setLayout(null);
        submenu1.add(firstItem);
        submenu1.add(secondItem);
        menu.add(submenu1);
        menu.add(thirdItem);
        submenu2.add(forthItem);
        submenu2.add(fifthItem);
        menu.add(submenu2);
        mb.add(menu);
        mb.add(cautareMenu);
        mb.add(denumireItem);
        contMenu.add(conectItem);
        contMenu.add(creareContItem);
        mb.add(contMenu);
        mb.add(dateContactMenu);
        frame.setJMenuBar(mb);
        frame.add(body);
        body.setBounds(5, 100, 1500, 600);
        body.setLayout(null);
        //create table
        table = new JTable(50, 6);
        model = (DefaultTableModel) table.getModel();
        table.setDefaultEditor(Object.class, null);
        table.getColumnModel().getColumn(0).setHeaderValue("Id Produs");
        table.getColumnModel().getColumn(1).setHeaderValue("Categorie");
        table.getColumnModel().getColumn(2).setHeaderValue("Denumire");
        table.getColumnModel().getColumn(3).setHeaderValue("Pret");
        table.getColumnModel().getColumn(4).setHeaderValue("Stoc");
        table.getColumnModel().getColumn(5).setHeaderValue("Garantie");
        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(0, 0, 1430, 800);
        body.add(scroll);
        table.setModel(model);
        table.setVisible(true);
        tabelProduse();
        conectItem.addActionListener(this);
        creareContItem.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreateNewAccount newAccount = new CreateNewAccount();
                newAccount.showNewAccount();
            }
        });

        firstItem.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                categorie = 1;
                try {
                    srv.searchProductByCategorie(categorie);
                    table.setVisible(false);
                    table.setVisible(true);
                    tabelProduseByCategorie();

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        secondItem.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                categorie = 2;
                try {
                    srv.searchProductByCategorie(categorie);
                    table.setVisible(false);
                    table.setVisible(true);
                    tabelProduseByCategorie();

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        thirdItem.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                categorie = 3;
                try {
                    srv.searchProductByCategorie(categorie);
                    table.setVisible(false);
                    table.setVisible(true);
                    tabelProduseByCategorie();

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        cautareMenu.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                denumire = denumireItem.getText().toUpperCase();
                try {
                    srv.searchProductByDenumire(denumire);
                    table.setVisible(false);
                    table.setVisible(true);
                    tabelProduseByDenumire();

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

    }

    public static void main(String[] args) throws SQLException {
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

    public void tabelProduse() throws SQLException {
        ClientRepository rep = new ClientRepository();
        List<Produs> produse = rep.getAllProduse();
        if (produse.size() <= model.getRowCount()) {

            for (int i = 0; i < produse.size(); i++) {
                model.setValueAt(produse.get(i).getId(), i, 0);
                model.setValueAt(produse.get(i).getIdCategorie().getDenumire(), i, 1);
                model.setValueAt(produse.get(i).getDenumire(), i, 2);
                model.setValueAt(produse.get(i).getPret(), i, 3);
                model.setValueAt(produse.get(i).getStoc(), i, 4);
                model.setValueAt(produse.get(i).getGarantie(), i, 5);
            }
            for (int j = produse.size(); j < model.getRowCount(); j++) {
                model.setValueAt("", j, 0);
                model.setValueAt("", j, 1);
                model.setValueAt("", j, 2);
                model.setValueAt("", j, 3);
                model.setValueAt("", j, 4);
                model.setValueAt("", j, 5);
            }

        }
    }

    public void tabelProduseByCategorie() throws SQLException {
        ClientRepository rep = new ClientRepository();
        List<Produs> produse = rep.getProdusByCategorie(categorie);
        if (produse.size() <= model.getRowCount()) {

            for (int i = 0; i < produse.size(); i++) {
                model.setValueAt(produse.get(i).getId(), i, 0);
                model.setValueAt(produse.get(i).getIdCategorie().getDenumire(), i, 1);
                model.setValueAt(produse.get(i).getDenumire(), i, 2);
                model.setValueAt(produse.get(i).getPret(), i, 3);
                model.setValueAt(produse.get(i).getStoc(), i, 4);
                model.setValueAt(produse.get(i).getGarantie(), i, 5);
            }
            for (int j = produse.size(); j < model.getRowCount(); j++) {
                model.setValueAt("", j, 0);
                model.setValueAt("", j, 1);
                model.setValueAt("", j, 2);
                model.setValueAt("", j, 3);
                model.setValueAt("", j, 4);
                model.setValueAt("", j, 5);
            }

        }
    }
    public void tabelProduseByDenumire() throws SQLException {
        ClientRepository rep = new ClientRepository();
        List<Produs> produse = rep.getProdusByDenumire(denumire);
        if (produse.size() <= model.getRowCount()) {

            for (int i = 0; i < produse.size(); i++) {
                model.setValueAt(produse.get(i).getId(), i, 0);
                model.setValueAt(produse.get(i).getIdCategorie().getDenumire(), i, 1);
                model.setValueAt(produse.get(i).getDenumire(), i, 2);
                model.setValueAt(produse.get(i).getPret(), i, 3);
                model.setValueAt(produse.get(i).getStoc(), i, 4);
                model.setValueAt(produse.get(i).getGarantie(), i, 5);
            }
            for (int j = produse.size(); j < model.getRowCount(); j++) {
                model.setValueAt("", j, 0);
                model.setValueAt("", j, 1);
                model.setValueAt("", j, 2);
                model.setValueAt("", j, 3);
                model.setValueAt("", j, 4);
                model.setValueAt("", j, 5);
            }

        }
    }
}

