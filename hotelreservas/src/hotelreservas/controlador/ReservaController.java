package hotelreservas.controlador;

import hotelreservas.dao.ReservaDAO;
import hotelreservas.dao.ClienteDAO;
import hotelreservas.dao.HabitacionDAO;
import hotelreservas.modelo.Reserva;
import hotelreservas.modelo.Cliente;
import hotelreservas.modelo.Habitacion;
import hotelreservas.vista.ReservasPanel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

public class ReservaController {
    private ReservasPanel view;
    private ReservaDAO dao;
    private List<Cliente> clientes;
    private List<Habitacion> habitaciones;

    // Patrón año/mes/día con barras
    private static final DateTimeFormatter FORMAT = 
        DateTimeFormatter.ofPattern("yyyy/MM/dd");

    public ReservaController(ReservasPanel view) {
        this.view = view;
        try {
            dao = new ReservaDAO();
            clientes     = new ClienteDAO().listar();
            habitaciones = new HabitacionDAO().listar();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(view,
                "Error de persistencia al cargar datos: " + e.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
        }
        cargarCombos();
        cargarReservas();
        initController();
    }

    private void initController() {
        view.getAgregarBtn().addActionListener(e -> agregarReserva());
    }

    private void cargarCombos() {
        DefaultComboBoxModel<String> mc = new DefaultComboBoxModel<>();
        for (Cliente c : clientes) mc.addElement(c.getId());
        view.getClienteCombo().setModel(mc);

        DefaultComboBoxModel<String> mh = new DefaultComboBoxModel<>();
        for (Habitacion h : habitaciones) mh.addElement(h.getId());
        view.getHabitacionCombo().setModel(mh);
    }

    private void cargarReservas() {
        try {
            List<Reserva> lista = dao.listar(clientes, habitaciones);
            DefaultTableModel m = view.getModeloTabla();
            m.setRowCount(0);
            for (Reserva r : lista) {
                m.addRow(new Object[]{
                    r.getId(),
                    r.getCliente().getId(),
                    r.getHabitacion().getId(),
                    r.getFechaEntrada().format(FORMAT),
                    r.getFechaSalida().format(FORMAT)
                });
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(view,
                "Error cargando reservas: " + ex.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void agregarReserva() {
        String id  = view.getIdField().getText().trim();
        String cid = (String) view.getClienteCombo().getSelectedItem();
        String hid = (String) view.getHabitacionCombo().getSelectedItem();
        String feS = view.getFechaEntradaField().getText().trim();
        String fsS = view.getFechaSalidaField().getText().trim();

        if (id.isEmpty() || cid == null || hid == null || feS.isEmpty() || fsS.isEmpty()) {
            JOptionPane.showMessageDialog(view,
                "Todos los campos son obligatorios",
                "Validación", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            LocalDate fe = LocalDate.parse(feS, FORMAT);
            LocalDate fs = LocalDate.parse(fsS, FORMAT);

            Reserva r = new Reserva(
                id,
                clientes.stream().filter(c -> c.getId().equals(cid)).findFirst().get(),
                habitaciones.stream().filter(h -> h.getId().equals(hid)).findFirst().get(),
                fe,
                fs
            );
            dao.guardar(r);
            cargarReservas();
            view.getIdField().setText("");
        } catch (DateTimeParseException ex) {
            JOptionPane.showMessageDialog(view,
                "Formato de fecha inválido. Usa YYYY/MM/DD, p.ej. 2025/12/22",
                "Error de fecha", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view,
                "Error al agregar reserva: " + ex.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
