package repository;

import com.sun.org.apache.bcel.internal.generic.ARETURN;
import model.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



import model.Produs;
import org.omg.CORBA.RepositoryIdHelper;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;


public class ClientRepository {


    public List<Produs> getAllProduse() throws SQLException {
        List<Produs> produse = new ArrayList<>();
        Connection con = MySqlCon.getConnection();
        Statement statement = null;
        try {
            statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from produs");
            while (resultSet.next()) {
                Statement statement1 = con.createStatement();
                ResultSet resultSet1 = statement1.executeQuery("select * from categorie where id= " + resultSet.getInt(2));
                Categorie categorie = new Categorie();
                if (resultSet1.next()) {
                    categorie.setId(resultSet1.getInt(1));
                    categorie.setDenumire(resultSet1.getString(2));
                }
                produse.add(new Produs(
                        resultSet.getInt("id"),
                        categorie,
                        resultSet.getString("denumire"),
                        resultSet.getInt("pret"),
                        resultSet.getInt("stoc"),
                        resultSet.getDate("garantie")
                ));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return produse;
    }


    public Users getUserName(String newUserName) throws SQLException {
        Users user = null;
        Connection con = MySqlCon.getConnection();
        Statement statement = null;
        try {
            statement = con.createStatement();

//            String sqlScript = String.format("select * from user_type where username = '%s' and password = '%s'", newUserName, newUserName);
            ResultSet resultSet = statement.executeQuery("select * from user_type where username= '" + newUserName + "'");
            if (resultSet.next()) {
                user = new Users(
                        resultSet.getInt("id"),
                        resultSet.getString("username"),
                        resultSet.getString("parola"),
                        resultSet.getString("tip_user")
                );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return user;

    }

    public Users getParola(String newParola) throws SQLException {
        Users parola = null;
        Connection con = MySqlCon.getConnection();
        Statement statement = null;
        try {
            statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from user_type where parola= '" + newParola + "'");
            if (resultSet.next()) {
                parola = new Users(
                        resultSet.getInt("id"),
                        resultSet.getString("username"),
                        resultSet.getString("parola"),
                        resultSet.getString("tip_user")
                );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return parola;

    }

    public Client getClientByNumePrenume(String newNume, String newPrenume) throws SQLException {
        Client client = null;
        Connection con = MySqlCon.getConnection();
        Statement stm = null;
        try {
            stm = con.createStatement();
            ResultSet resultSet = stm.executeQuery("select * from client where nume= '" + newNume + "' and prenume='" + newPrenume + "'");
            if (resultSet.next()) {
                // if(resultSet.next()) se foloseste atunci cand ne asteptam la un singur result
                client = new Client(
                        resultSet.getInt("id"),
                        resultSet.getString("nume"),
                        resultSet.getString("prenume"),
                        resultSet.getDate("data_nasterii")
                );
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return client;
    }

    public void addClient(String nume, String prenume, Date dataNasterii) throws SQLException {
        Connection con = MySqlCon.getConnection();
        Statement stm = con.createStatement();
        try {
            java.sql.Date newDataNasterii = new java.sql.Date(dataNasterii.getTime());
            stm.executeUpdate("insert into client(nume, prenume, data_nasterii) values (' " + nume + "' ,' " + prenume + "', '" + newDataNasterii + "' )");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        //pentru modificare/sterge select from produs where nume produs = new Nume

    }

    public List<Produs> getProdus(String denumireProdus) throws SQLException {
        List<Produs> produse = new ArrayList<>();
        Connection con = MySqlCon.getConnection();
        Statement stm = con.createStatement();
        try {
            ResultSet resultSet = stm.executeQuery("select * from produs where denumire= " + denumireProdus);
            while (resultSet.next()) {
                Statement statement1 = con.createStatement();
                ResultSet resultSet1 = statement1.executeQuery("select * from categorie where id= " + resultSet.getInt(2));
                Categorie categorie = new Categorie();
                if (resultSet1.next()) {
                    categorie.setId(resultSet1.getInt(1));
                    categorie.setDenumire(resultSet1.getString(2));
                }
                produse.add(new Produs(
                        resultSet.getInt("id"),
                        categorie,
                        resultSet.getString("denumire"),
                        resultSet.getInt("pret"),
                        resultSet.getInt("stoc"),
                        resultSet.getDate("garantie")
                ));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return produse;
    }
}