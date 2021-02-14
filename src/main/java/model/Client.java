package model;

import java.util.Date;

public class Client {
    private int id;
    private String nume;
    private String prenume;
    private Date dataNasterii;

    public Client() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public Date getDataNasterii() {
        return dataNasterii;
    }

    public void setDataNasterii(Date dataNasterii) {
        this.dataNasterii = dataNasterii;
    }

    public Client(int id, String nume, String prenume, Date dataNasterii) {
        this.id = id;
        this.nume = nume;
        this.prenume = prenume;
        this.dataNasterii = dataNasterii;
    }
}
