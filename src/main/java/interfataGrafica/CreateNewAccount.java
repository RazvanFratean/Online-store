package interfataGrafica;

import repository.MySqlCon;
import repository.ClientRepository;
import service.ServiciiClient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class CreateNewAccount implements ActionListener {
    private JLabel numeLabel, prenumeLabel, dataNasterii, message;
    private JTextField numeLabel_text, prenumeLabel_text, dataNasterii_text;
    private JPanel panel;
    private JButton createAccount;

    public CreateNewAccount() {

    }

    public void showNewAccount() {
        //frame
        JFrame frame = new JFrame();
        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        // Labels
        numeLabel = new JLabel();
        numeLabel.setText("Nume :");
        numeLabel_text = new JTextField();
        prenumeLabel = new JLabel();
        prenumeLabel.setText("Prenume : ");
        prenumeLabel_text = new JTextField();
        dataNasterii = new JLabel();
        message = new JLabel();
        dataNasterii.setText("Data nasterii: ");
        dataNasterii_text = new JTextField();
        panel = new JPanel(new GridLayout(5, 1));
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.setMaximumSize(new Dimension(400, 300));
        panel.setBackground(Color.yellow);
        panel.add(numeLabel);
        panel.add(numeLabel_text);
        panel.add(prenumeLabel);
        panel.add(prenumeLabel_text);
        panel.add(dataNasterii);
        panel.add(dataNasterii_text);
        panel.add(message);
        JButton createAccount = new JButton(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    createNewAccount();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (ParseException parseException) {
                    parseException.printStackTrace();
                }
            }
        });
        panel.add(createAccount);
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.setSize(800, 800);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

    }

    public void createNewAccount() throws SQLException, ParseException {
        String newNume = numeLabel_text.getText();
        String newPrenume = prenumeLabel_text.getText();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date newDataNasterii = format.parse(dataNasterii_text.getText());
        ServiciiClient sc = new ServiciiClient();

        if (sc.createNewAccount(newNume, newPrenume, newDataNasterii)) {
            message.setText("Cont creat cu succes !");

        } else {
            message.setText("Deja aveti cont.Va rog sa va reconectati !");

        }
    }

}
