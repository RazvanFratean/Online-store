package interfataGrafica;

import model.Produs;
import repository.ClientRepository;
import service.ServiciiClient;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;

public class TabelProduse {
    private JTable table;
    private DefaultTableModel model;
    private JPanel panel;
    private JFrame frame = new JFrame();
    ServiciiClient rep = new ServiciiClient();


    public TabelProduse() throws SQLException {
    }
    public void createTable() throws SQLException{
        //set the frame characteristics
        frame.setTitle("Lista Produse");
        frame.setSize(600, 600);
        frame.setBackground(Color.lightGray);
        //create a panel to hold all other components
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        frame.add(panel);
        //create table
        table = new JTable(50, 6);
        model = (DefaultTableModel) table.getModel();
        panel.add(new JScrollPane(table));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Make the table not editable
        table.setDefaultEditor(Object.class, null);
        table.getColumnModel().getColumn(0).setHeaderValue("Adaugare produs");
        table.getColumnModel().getColumn(1).setHeaderValue("Modificare produs existent");
        table.getColumnModel().getColumn(2).setHeaderValue("Stergere produs");
        table.setModel(model);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        tabelProduse();
    }

    public void tabelProduse() throws SQLException {
        String denumire = null;
        List<Produs> produse = rep.searchProduct(denumire);
        if (produse.size() < model.getRowCount()) {
            for (int i = 0; i < produse.size(); i++) {
                model.setValueAt(produse.get(i).getId(), i, 0);
                model.setValueAt(produse.get(i).getIdCategorie(), i, 1);
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
