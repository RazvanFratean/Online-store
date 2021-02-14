package model;

import java.util.Date;

public class Produs {
    private int id;
    private Categorie idCategorie;
    private String denumire;
    private int pret;
    private int stoc;
    private Date garantie;

    public Produs() {
    }

    public Produs(int id, Categorie idCategorie, String denumire, int pret, int stoc, Date garantie) {
        this.id = id;
        this.idCategorie = idCategorie;
        this.denumire = denumire;
        this.pret = pret;
        this.stoc = stoc;
        this.garantie = garantie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Categorie getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(Categorie idCategorie) {
        this.idCategorie = idCategorie;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public int getPret() {
        return pret;
    }

    public void setPret(int pret) {
        this.pret = pret;
    }

    public int getStoc() {
        return stoc;
    }

    public void setStoc(int stoc) {
        this.stoc = stoc;
    }

    public Date getGarantie() {
        return garantie;
    }

    public void setGarantie(Date garantie) {
        this.garantie = garantie;
    }
}
