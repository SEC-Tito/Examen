package modelo;

public class Recepcionista extends Usuario {
    public Recepcionista(String username, String password) {
        super(username, password);
    }

    @Override
    public String getRol() {
        return "Recepcionista";
    }
}
