package interfataGrafica;

import model.Users;
import repository.ClientRepository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Login extends JFrame implements ActionListener{
    JFrame frame;
    JPanel panel;
    JLabel userType, user_label, password_label, message;
    JComboBox userType_text;
    String[] users = {"Client","Admin"};
    JTextField userName_text;
    JPasswordField password_text;
    JButton submit;
    ClientRepository rep = new ClientRepository();
    TabelProduse graficaAdmin = new TabelProduse();

    Login() throws SQLException {
    }


    @Override
    public void actionPerformed(ActionEvent ae)  {
        String userName = userName_text.getText();
        String password = password_text.getText();

        try {
            Users user = rep.getUserName(userName);

            if (user!= null) {
                    if (userName.equals(user.getUsername()) && password.equals(user.getParola()) && user.getTipUser().equals("admin")){
                        message.setText(" Bine ati venit  " + userName + "");
                        graficaAdmin.createTable();
                        return;
                    } else if (userName.equals(user.getUsername()) && password.equals(user.getParola()) && user.getTipUser().equals("client")){
                        message.setText(" Bine ati venit  " + userName + "");
                        graficaAdmin.createTable();
                        return;
                    } else {
                        message.setText(" Invalid user.");
                        return;
                    }
            }

        } catch (SQLException ioException) {
            ioException.printStackTrace();
        }

    }
    public void showLogin(){
        //frame
        JFrame frame = new JFrame();
        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        //UserType Label
        userType = new JLabel();
        userType.setText("User Type :");
        userType_text = new JComboBox(users);
//        userType.setSelectedIndex(1);
//        userType.addActionListener();
        // Username Label
        user_label = new JLabel();
        user_label.setText("User Name :");
        userName_text = new JTextField();
        // Password Label
        password_label = new JLabel();
        password_label.setText("Password :");
        password_text = new JPasswordField();
        // Submit
        submit = new JButton("SUBMIT");
        panel = new JPanel(new GridLayout(5, 1));
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.setMaximumSize(new Dimension(500, 100));
        panel.setBackground(Color.yellow);
        panel.add(userType);
        panel.add(userType_text);
        panel.add(user_label);
        panel.add(userName_text);
        panel.add(password_label);
        panel.add(password_text);
        message = new JLabel();
        panel.add(message);
        panel.add(submit);
        // Adding the listeners to components..
        submit.addActionListener(this);
        add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.setSize(800, 800);
        frame.setVisible(true);
    }

}

