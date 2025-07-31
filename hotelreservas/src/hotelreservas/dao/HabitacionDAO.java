package hotelreservas.dao;

import hotelreservas.modelo.Habitacion;
import hotelreservas.modelo.TipoHabitacion;
import java.nio.file.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO para persistencia de Habitaciones en archivo de texto.
 */
public class HabitacionDAO {
    private static final String RUTA = "data/habitaciones.txt";

    public HabitacionDAO() throws IOException {
        Path dir = Paths.get("data");
        if (!Files.exists(dir)) {
            Files.createDirectory(dir);
        }
        Path file = Paths.get(RUTA);
        if (!Files.exists(file)) {
            Files.createFile(file);
        }
    }

    public void guardar(Habitacion hab) throws IOException {
        String linea = String.join(",",
            hab.getId(),
            String.valueOf(hab.getNumero()),
            hab.getTipo().name(),
            String.valueOf(hab.isDisponible())
        );
        Files.write(
            Paths.get(RUTA),
            (linea + System.lineSeparator()).getBytes(),
            StandardOpenOption.APPEND
        );
    }

    public List<Habitacion> listar() throws IOException {
        List<Habitacion> lista = new ArrayList<>();
        List<String> lineas = Files.readAllLines(Paths.get(RUTA));
        for (String linea : lineas) {
            String[] datos = linea.split(",");
            if (datos.length == 4) {
                Habitacion h = new Habitacion(
                    datos[0],
                    Integer.parseInt(datos[1]),
                    TipoHabitacion.valueOf(datos[2]),
                    Boolean.parseBoolean(datos[3])
                );
                lista.add(h);
            }
        }
        return lista;
    }
}
