package model;

public class CosCumparaturi {
    private int id;
    private Client idClient;
    private Produs idProdus;
    private int cantitate;

    public CosCumparaturi() {
    }

    public CosCumparaturi(int id, Client idClient, Produs idProdus, int cantitate) {
        this.id = id;
        this.idClient = idClient;
        this.idProdus = idProdus;
        this.cantitate = cantitate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Client getIdClient() {
        return idClient;
    }

    public void setIdClient(Client idClient) {
        this.idClient = idClient;
    }

    public Produs getIdProdus() {
        return idProdus;
    }

    public void setIdProdus(Produs idProdus) {
        this.idProdus = idProdus;
    }

    public int getCantitate() {
        return cantitate;
    }

    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }
}
