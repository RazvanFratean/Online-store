package interfataGrafica;

import model.Produs;
import repository.ClientRepository;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class TabelProduse   {
    private JFrame frame = new JFrame();
    private JPanel panel;
    private JTable table;
    private DefaultTableModel model;



    public TabelProduse() throws SQLException {
        //set the frame characteristics
        frame.setTitle("Lista Produse");
        frame.setSize(600, 600);
        frame.setLayout(null);
        frame.setBackground(Color.blue);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        //create a panel to hold all other components
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        frame.add(panel);
        //create table
        table = new JTable(50, 6);
                model = (DefaultTableModel) table.getModel();
                panel.add(new JScrollPane(table));
                table.setDefaultEditor(Object.class, null);
        table.getColumnModel().getColumn(0).setHeaderValue("Id Produs");
        table.getColumnModel().getColumn(1).setHeaderValue("Id Categorie");
        table.getColumnModel().getColumn(2).setHeaderValue("Denumire");
        table.getColumnModel().getColumn(3).setHeaderValue("Pret");
        table.getColumnModel().getColumn(4).setHeaderValue("Stoc");
        table.getColumnModel().getColumn(5).setHeaderValue("Garantie");
        table.setModel(model);
        table.setVisible(true);
        createTabel();
    }
//
public void createTabel() throws SQLException {
    ClientRepository rep = new ClientRepository();
    List<Produs> produse = rep.getAllProduse();
    if (produse.size() <= model.getRowCount()) {

        for (int i = 0; i < produse.size(); i++) {
            model.setValueAt(produse.get(i).getId(), i, 0);
            model.setValueAt(produse.get(i).getIdCategorie().getId(), i, 1);
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