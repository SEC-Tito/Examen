package hotelreservas.vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class HabitacionesPanel extends JPanel {
    private JTextField idField;
    private JTextField numeroField;
    private JComboBox<String> tipoCombo;
    private JCheckBox disponibleChk;
    private JButton agregarBtn;
    private JTable tablaHabitaciones;
    private DefaultTableModel modeloTabla;

    public HabitacionesPanel() {
        setLayout(new BorderLayout());

        // Formulario de registro
        JPanel form = new JPanel(new GridLayout(5,2,5,5));
        form.setBorder(BorderFactory.createTitledBorder("Registrar Habitación"));
        form.add(new JLabel("ID:"));
        idField = new JTextField();
        form.add(idField);
        form.add(new JLabel("Número:"));
        numeroField = new JTextField();
        form.add(numeroField);
        form.add(new JLabel("Tipo:"));
        tipoCombo = new JComboBox<>(new String[]{"INDIVIDUAL","DOBLE","SUITE"});
        form.add(tipoCombo);
        form.add(new JLabel("Disponible:"));
        disponibleChk = new JCheckBox();
        disponibleChk.setSelected(true);
        form.add(disponibleChk);
        agregarBtn = new JButton("Agregar");
        form.add(agregarBtn);

        add(form, BorderLayout.NORTH);

        // Tabla de habitaciones
        modeloTabla = new DefaultTableModel(
            new Object[]{"ID","Número","Tipo","Disponible"}, 0);
        tablaHabitaciones = new JTable(modeloTabla);
        add(new JScrollPane(tablaHabitaciones), BorderLayout.CENTER);
    }

    public JTextField getIdField()       { return idField; }
    public JTextField getNumeroField()   { return numeroField; }
    public JComboBox<String> getTipoCombo() { return tipoCombo; }
    public JCheckBox getDisponibleChk()  { return disponibleChk; }
    public JButton getAgregarBtn()       { return agregarBtn; }
    public DefaultTableModel getModeloTabla() { return modeloTabla; }
}
