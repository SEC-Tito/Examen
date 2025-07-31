package hotelreservas.modelo;

/**
 * Representa una habitación del hotel.
 */
public class Habitacion {
    private String id;
    private int numero;
    private TipoHabitacion tipo;
    private boolean disponible;

    public Habitacion() {}

    public Habitacion(String id, int numero, TipoHabitacion tipo, boolean disponible) {
        this.id = id;
        this.numero = numero;
        this.tipo = tipo;
        this.disponible = disponible;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }
    public TipoHabitacion getTipo() { return tipo; }
    public void setTipo(TipoHabitacion tipo) { this.tipo = tipo; }
    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }
}
