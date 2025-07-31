package hotelreservas.dao;

import hotelreservas.modelo.Reserva;
import hotelreservas.modelo.Cliente;
import hotelreservas.modelo.Habitacion;
import java.nio.file.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO para persistencia de Reservas en archivo de texto.
 */
public class ReservaDAO {
    private static final String RUTA = "data/reservas.txt";

    public ReservaDAO() throws IOException {
        Path dir = Paths.get("data");
        if (!Files.exists(dir)) {
            Files.createDirectory(dir);
        }
        Path file = Paths.get(RUTA);
        if (!Files.exists(file)) {
            Files.createFile(file);
        }
    }

    public void guardar(Reserva r) throws IOException {
        String linea = String.join(",",
            r.getId(),
            r.getCliente().getId(),
            r.getHabitacion().getId(),
            r.getFechaEntrada().toString(),
            r.getFechaSalida().toString()
        );
        Files.write(
            Paths.get(RUTA),
            (linea + System.lineSeparator()).getBytes(),
            StandardOpenOption.APPEND
        );
    }

    public List<Reserva> listar(List<Cliente> clientes, List<Habitacion> habitaciones) throws IOException {
        List<Reserva> lista = new ArrayList<>();
        List<String> lineas = Files.readAllLines(Paths.get(RUTA));
        for (String linea : lineas) {
            String[] datos = linea.split(",");
            if (datos.length == 5) {
                Cliente c = clientes.stream()
                                     .filter(cli -> cli.getId().equals(datos[1]))
                                     .findFirst()
                                     .orElse(null);
                Habitacion h = habitaciones.stream()
                                           .filter(hab -> hab.getId().equals(datos[2]))
                                           .findFirst()
                                           .orElse(null);
                LocalDate fe = LocalDate.parse(datos[3]);
                LocalDate fs = LocalDate.parse(datos[4]);
                Reserva res = new Reserva(datos[0], c, h, fe, fs);
                lista.add(res);
            }
        }
        return lista;
    }
}
