package hotelreservas.controlador;

import hotelreservas.dao.HabitacionDAO;
import hotelreservas.modelo.Habitacion;
import hotelreservas.modelo.TipoHabitacion;
import hotelreservas.vista.HabitacionesPanel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.List;

public class HabitacionesController {
    private HabitacionesPanel view;
    private HabitacionDAO dao;

    public HabitacionesController(HabitacionesPanel view) {
        this.view = view;
        try {
            dao = new HabitacionDAO();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(view,
                "Error inicializando persistencia: " + e.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
        }
        cargarHabitaciones();
        initController();
    }

    private void initController() {
        view.getAgregarBtn().addActionListener((ActionEvent e) -> agregarHab());
    }

    private void cargarHabitaciones() {
        try {
            List<Habitacion> lista = dao.listar();
            DefaultTableModel m = view.getModeloTabla();
            m.setRowCount(0);
            for (Habitacion h : lista) {
                m.addRow(new Object[]{
                    h.getId(),
                    h.getNumero(),
                    h.getTipo().name(),
                    h.isDisponible()
                });
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(view,
                "Error cargando habitaciones: " + ex.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void agregarHab() {
        String id    = view.getIdField().getText().trim();
        String numS  = view.getNumeroField().getText().trim();
        String tipoS = (String) view.getTipoCombo().getSelectedItem();
        boolean disp = view.getDisponibleChk().isSelected();

        if (id.isEmpty() || numS.isEmpty()) {
            JOptionPane.showMessageDialog(view,
                "ID y Número son obligatorios.",
                "Validación", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int numero;
        try {
            numero = Integer.parseInt(numS);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(view,
                "Número debe ser un entero.",
                "Validación", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Habitacion h = new Habitacion(id, numero, TipoHabitacion.valueOf(tipoS), disp);
        try {
            dao.guardar(h);
            cargarHabitaciones();
            view.getIdField().setText("");
            view.getNumeroField().setText("");
            view.getDisponibleChk().setSelected(true);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(view,
                "Error al guardar: " + ex.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
