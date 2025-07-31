package hotelreservas.controlador;

import hotelreservas.dao.ClienteDAO;
import hotelreservas.modelo.Cliente;
import hotelreservas.vista.ClientesPanel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

public class ClientesController {
    private ClientesPanel view;
    private ClienteDAO dao;

    public ClientesController(ClientesPanel view) {
        this.view = view;
        try {
            dao = new ClienteDAO();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(view, "Error inicializando persistencia: " + e.getMessage(),
                                          "Error", JOptionPane.ERROR_MESSAGE);
        }
        cargarClientes();
        initController();
    }

    private void initController() {
        view.getAgregarBtn().addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                agregarCliente();
            }
        });
    }

    private void cargarClientes() {
        try {
            List<Cliente> lista = dao.listar();
            DefaultTableModel m = view.getModeloTabla();
            m.setRowCount(0);
            for (Cliente c : lista) {
                m.addRow(new Object[]{
                    c.getId(), c.getNombre(), c.getApellido(),
                    c.getEmail(), c.getTelefono()
                });
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(view, "Error cargando clientes: " + ex.getMessage(),
                                          "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void agregarCliente() {
        String id       = view.getIdField().getText().trim();
        String nombre   = view.getNombreField().getText().trim();
        String apellido = view.getApellidoField().getText().trim();
        String email    = view.getEmailField().getText().trim();
        String telefono = view.getTelefonoField().getText().trim();

        if (id.isEmpty() || nombre.isEmpty() || apellido.isEmpty()
         || email.isEmpty() || telefono.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Todos los campos son obligatorios.",
                                          "Validación", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Cliente c = new Cliente(id, nombre, apellido, email, telefono);
        try {
            dao.guardar(c);
            cargarClientes();
            // Limpia formulario
            view.getIdField().setText("");
            view.getNombreField().setText("");
            view.getApellidoField().setText("");
            view.getEmailField().setText("");
            view.getTelefonoField().setText("");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(view, "Error al guardar: " + ex.getMessage(),
                                          "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
