package vista;

import controlador.HabitacionController;
import modelo.Habitacion;
import modelo.TipoHabitacion;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class PanelHabitaciones extends JPanel {

    private JTextField numeroField;
    private JComboBox<TipoHabitacion> tipoCombo;
    private JCheckBox ocupadaCheck;
    private JButton registrarBtn;
    private JTable tablaHabitaciones;
    private DefaultTableModel modeloTabla;
    private ArrayList<Habitacion> listaHabitaciones;

    public PanelHabitaciones() {
        setLayout(new BorderLayout());

        // Formulario
        JPanel formPanel = new JPanel(new GridLayout(4, 2));
        formPanel.setBorder(BorderFactory.createTitledBorder("Registrar Habitación"));

        numeroField = new JTextField();
        tipoCombo = new JComboBox<>(TipoHabitacion.values());
        ocupadaCheck = new JCheckBox("¿Ocupada?");
        registrarBtn = new JButton("Registrar");

        formPanel.add(new JLabel("Número:"));
        formPanel.add(numeroField);
        formPanel.add(new JLabel("Tipo:"));
        formPanel.add(tipoCombo);
        formPanel.add(new JLabel(""));
        formPanel.add(ocupadaCheck);
        formPanel.add(new JLabel(""));
        formPanel.add(registrarBtn);

        // Tabla
        String[] columnas = {"Número", "Tipo", "Estado"};
        modeloTabla = new DefaultTableModel(columnas, 0);
        tablaHabitaciones = new JTable(modeloTabla);

        listaHabitaciones = new ArrayList<>();

        add(formPanel, BorderLayout.NORTH);
        add(new JScrollPane(tablaHabitaciones), BorderLayout.CENTER);

        // Controlador
        new HabitacionController(this);
    }

    public JTextField getNumeroField() { return numeroField; }
    public JComboBox<TipoHabitacion> getTipoCombo() { return tipoCombo; }
    public JCheckBox getOcupadaCheck() { return ocupadaCheck; }
    public JButton getRegistrarBtn() { return registrarBtn; }
    public DefaultTableModel getModeloTabla() { return modeloTabla; }
    public ArrayList<Habitacion> getListaHabitaciones() { return listaHabitaciones; }
}
