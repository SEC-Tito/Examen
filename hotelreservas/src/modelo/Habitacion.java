package modelo;

public class Habitacion {
    private int numero;
    private TipoHabitacion tipo;
    private boolean ocupada;

    public Habitacion(int numero, TipoHabitacion tipo, boolean ocupada) {
        this.numero = numero;
        this.tipo = tipo;
        this.ocupada = ocupada;
    }

    public int getNumero() { return numero; }
    public TipoHabitacion getTipo() { return tipo; }
    public boolean estaOcupada() { return ocupada; }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }
}
