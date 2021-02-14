package model;

import java.util.Date;

public class Comanda {
    private int id;
    private Produs idProdus;
    private Date dataComanda;
    private Client idClient;

    public Comanda() {
    }

    public Comanda(int id, Produs idProdus, Date dataComanda, Client idClient) {
        this.id = id;
        this.idProdus = idProdus;
        this.dataComanda = dataComanda;
        this.idClient = idClient;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Produs getIdProdus() {
        return idProdus;
    }

    public void setIdProdus(Produs idProdus) {
        this.idProdus = idProdus;
    }

    public Date getDataComanda() {
        return dataComanda;
    }

    public void setDataComanda(Date dataComanda) {
        this.dataComanda = dataComanda;
    }

    public Client getIdClient() {
        return idClient;
    }

    public void setIdClient(Client idClient) {
        this.idClient = idClient;
    }
}
