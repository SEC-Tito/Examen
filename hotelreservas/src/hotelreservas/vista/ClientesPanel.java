package hotelreservas.vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ClientesPanel extends JPanel {
    private JTextField idField, nombreField, apellidoField, emailField, telefonoField;
    private JButton agregarBtn;
    private JTable tablaClientes;
    private DefaultTableModel modeloTabla;

    public ClientesPanel() {
        setLayout(new BorderLayout());

        // Formulario de registro arriba
        JPanel form = new JPanel(new GridLayout(6, 2, 5, 5));
        form.setBorder(BorderFactory.createTitledBorder("Registrar Cliente"));
        form.add(new JLabel("ID:"));
        idField = new JTextField();
        form.add(idField);
        form.add(new JLabel("Nombre:"));
        nombreField = new JTextField();
        form.add(nombreField);
        form.add(new JLabel("Apellido:"));
        apellidoField = new JTextField();
        form.add(apellidoField);
        form.add(new JLabel("Email:"));
        emailField = new JTextField();
        form.add(emailField);
        form.add(new JLabel("Teléfono:"));
        telefonoField = new JTextField();
        form.add(telefonoField);
        agregarBtn = new JButton("Agregar");
        form.add(agregarBtn);

        add(form, BorderLayout.NORTH);

        // Tabla de clientes abajo
        modeloTabla = new DefaultTableModel(
            new Object[]{"ID", "Nombre", "Apellido", "Email", "Teléfono"}, 0);
        tablaClientes = new JTable(modeloTabla);
        add(new JScrollPane(tablaClientes), BorderLayout.CENTER);
    }

    // Getters para el controlador
    public JTextField getIdField()       { return idField; }
    public JTextField getNombreField()   { return nombreField; }
    public JTextField getApellidoField() { return apellidoField; }
    public JTextField getEmailField()    { return emailField; }
    public JTextField getTelefonoField() { return telefonoField; }
    public JButton getAgregarBtn()       { return agregarBtn; }
    public DefaultTableModel getModeloTabla() { return modeloTabla; }
}
