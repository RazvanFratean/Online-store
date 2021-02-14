package model;

public class Users {
    private int id;
    private String username;
    private String parola;
    private String tipUser;

    public Users() {
    }

    public Users(int id, String username, String parola, String tipUser) {
        this.id = id;
        this.username = username;
        this.parola = parola;
        this.tipUser = tipUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public String getTipUser() {
        return tipUser;
    }

    public void setTipUser(String tipUser) {
        this.tipUser = tipUser;
    }
}
