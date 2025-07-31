package hotelreservas.dao;

import hotelreservas.modelo.Cliente;
import java.nio.file.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO para persistencia de Clientes en archivo de texto.
 */
public class ClienteDAO {
    private static final String RUTA = "data/clientes.txt";

    public ClienteDAO() throws IOException {
        Path dir = Paths.get("data");
        if (!Files.exists(dir)) {
            Files.createDirectory(dir);
        }
        Path file = Paths.get(RUTA);
        if (!Files.exists(file)) {
            Files.createFile(file);
        }
    }

    public void guardar(Cliente cliente) throws IOException {
        String linea = String.join(",",
            cliente.getId(),
            cliente.getNombre(),
            cliente.getApellido(),
            cliente.getEmail(),
            cliente.getTelefono()
        );
        Files.write(
            Paths.get(RUTA),
            (linea + System.lineSeparator()).getBytes(),
            StandardOpenOption.APPEND
        );
    }

    public List<Cliente> listar() throws IOException {
        List<Cliente> lista = new ArrayList<>();
        List<String> lineas = Files.readAllLines(Paths.get(RUTA));
        for (String linea : lineas) {
            String[] datos = linea.split(",");
            if (datos.length == 5) {
                Cliente c = new Cliente(
                    datos[0], datos[1], datos[2], datos[3], datos[4]
                );
                lista.add(c);
            }
        }
        return lista;
    }
}
