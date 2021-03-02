package service;

import model.Client;
import model.Produs;
import repository.ClientRepository;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class ServiciiClient {
    ClientRepository rep = new ClientRepository();

    public boolean createNewAccount(String nume, String prenume, Date dataNasterii) throws SQLException {
        Client client = rep.getClientByNumePrenume(nume, prenume);
        if(client != null){
            return false;
        } else{
            rep.addClient(nume, prenume, dataNasterii);
        }
        return true;
    }
    public List<Produs> searchProductByDenumire(String denumire) throws SQLException {
        List<Produs> produse = rep.getProdusByDenumire(denumire);
          return produse;
    }
    public List<Produs> searchProductByCategorie(int idCategorie) throws SQLException {
        List<Produs> produse = rep.getProdusByCategorie(idCategorie);
        return produse;
    }

    // logica o punem in servicii - in repository facem query in baza de date si apoi folosim datele in servicii
    //unde ..
}
