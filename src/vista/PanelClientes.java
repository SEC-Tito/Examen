package vista;

import controlador.ClienteController;
import modelo.Cliente;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class PanelClientes extends JPanel {

    private JTextField cedulaField, nombreField, apellidoField, telefonoField;
    private JButton registrarBtn;
    private JTable tablaClientes;
    private DefaultTableModel modeloTabla;
    private ArrayList<Cliente> listaClientes;

    public PanelClientes() {
        setLayout(new BorderLayout());

        // Formulario
        JPanel formPanel = new JPanel(new GridLayout(5, 2));
        formPanel.setBorder(BorderFactory.createTitledBorder("Registrar Cliente"));

        cedulaField = new JTextField();
        nombreField = new JTextField();
        apellidoField = new JTextField();
        telefonoField = new JTextField();
        registrarBtn = new JButton("Registrar");

        formPanel.add(new JLabel("Cédula:"));
        formPanel.add(cedulaField);
        formPanel.add(new JLabel("Nombre:"));
        formPanel.add(nombreField);
        formPanel.add(new JLabel("Apellido:"));
        formPanel.add(apellidoField);
        formPanel.add(new JLabel("Teléfono:"));
        formPanel.add(telefonoField);
        formPanel.add(new JLabel(""));
        formPanel.add(registrarBtn);

        // Tabla
        String[] columnas = {"Cédula", "Nombre", "Apellido", "Teléfono"};
        modeloTabla = new DefaultTableModel(columnas, 0);
        tablaClientes = new JTable(modeloTabla);

        listaClientes = new ArrayList<>();

        add(formPanel, BorderLayout.NORTH);
        add(new JScrollPane(tablaClientes), BorderLayout.CENTER);

        // Controlador
        new ClienteController(this);
    }

    // Getters para acceder desde el controlador
    public JTextField getCedulaField() { return cedulaField; }
    public JTextField getNombreField() { return nombreField; }
    public JTextField getApellidoField() { return apellidoField; }
    public JTextField getTelefonoField() { return telefonoField; }
    public JButton getRegistrarBtn() { return registrarBtn; }
    public DefaultTableModel getModeloTabla() { return modeloTabla; }
    public ArrayList<Cliente> getListaClientes() { return listaClientes; }
}
