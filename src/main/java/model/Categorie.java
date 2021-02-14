package model;

public class Categorie {
    private int id;
    private String denumire;

    public Categorie() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public Categorie(int id, String denumire) {
        this.id = id;
        this.denumire = denumire;
    }
}
