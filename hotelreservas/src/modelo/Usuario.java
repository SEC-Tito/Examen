package modelo;

public abstract class Usuario {
    protected String username;
    protected String password;

    public Usuario(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public abstract String getRol();
}
