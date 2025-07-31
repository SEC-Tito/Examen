package hotelreservas.vista;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.ParseException;

public class ReservasPanel extends JPanel {
    private JTextField idField;
    private JComboBox<String> clienteCombo;
    private JComboBox<String> habitacionCombo;
    // Ahora JFormattedTextField con máscara ####/##/##
    private JFormattedTextField fechaEntradaField;
    private JFormattedTextField fechaSalidaField;
    private JButton agregarBtn;
    private JTable tablaReservas;
    private DefaultTableModel modeloTabla;

    public ReservasPanel() {
        setLayout(new BorderLayout());

        JPanel form = new JPanel(new GridLayout(6, 2, 5, 5));
        form.setBorder(BorderFactory.createTitledBorder("Registrar Reserva"));

        form.add(new JLabel("ID Reserva:"));
        idField = new JTextField();
        form.add(idField);

        form.add(new JLabel("Cliente (ID):"));
        clienteCombo = new JComboBox<>();
        form.add(clienteCombo);

        form.add(new JLabel("Habitación (ID):"));
        habitacionCombo = new JComboBox<>();
        form.add(habitacionCombo);

        form.add(new JLabel("Fecha Entrada (YYYY/MM/DD):"));
        try {
            MaskFormatter mf = new MaskFormatter("####/##/##");
            mf.setPlaceholderCharacter('_');
            fechaEntradaField = new JFormattedTextField(mf);
        } catch (ParseException ex) {
            fechaEntradaField = new JFormattedTextField();
        }
        form.add(fechaEntradaField);

        form.add(new JLabel("Fecha Salida (YYYY/MM/DD):"));
        try {
            MaskFormatter mf2 = new MaskFormatter("####/##/##");
            mf2.setPlaceholderCharacter('_');
            fechaSalidaField = new JFormattedTextField(mf2);
        } catch (ParseException ex) {
            fechaSalidaField = new JFormattedTextField();
        }
        form.add(fechaSalidaField);

        agregarBtn = new JButton("Agregar");
        form.add(agregarBtn);

        add(form, BorderLayout.NORTH);

        modeloTabla = new DefaultTableModel(
            new Object[]{"ID", "Cliente", "Habitación", "Entrada", "Salida"}, 0);
        tablaReservas = new JTable(modeloTabla);
        add(new JScrollPane(tablaReservas), BorderLayout.CENTER);
    }

    // Getters
    public JTextField getIdField()                    { return idField; }
    public JComboBox<String> getClienteCombo()        { return clienteCombo; }
    public JComboBox<String> getHabitacionCombo()     { return habitacionCombo; }
    public JFormattedTextField getFechaEntradaField(){ return fechaEntradaField; }
    public JFormattedTextField getFechaSalidaField() { return fechaSalidaField; }
    public JButton getAgregarBtn()                    { return agregarBtn; }
    public DefaultTableModel getModeloTabla()         { return modeloTabla; }
}
