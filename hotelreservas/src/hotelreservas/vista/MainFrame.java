package hotelreservas.vista;

import javax.swing.*;
import java.awt.*;
import hotelreservas.vista.ClientesPanel;
import hotelreservas.vista.HabitacionesPanel;
import hotelreservas.vista.ReservasPanel;

public class MainFrame extends JFrame {
    private JTabbedPane tabbedPane;
    private ClientesPanel clientesPanel;
    private HabitacionesPanel habitacionesPanel;
    private ReservasPanel reservasPanel;

    public MainFrame() {
        super("Sistema de Gestión de Hotel");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        initComponents();
        pack();
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        tabbedPane = new JTabbedPane();

        // 0) Clientes
        clientesPanel = new ClientesPanel();
        tabbedPane.addTab("Clientes", clientesPanel);

        // 1) Habitaciones
        habitacionesPanel = new HabitacionesPanel();
        tabbedPane.addTab("Habitaciones", habitacionesPanel);

        // 2) Reservas
        reservasPanel = new ReservasPanel();
        tabbedPane.addTab("Reservas", reservasPanel);

        add(tabbedPane, BorderLayout.CENTER);
    }

    public ClientesPanel getClientesPanel()       { return clientesPanel; }
    public HabitacionesPanel getHabitacionesPanel(){ return habitacionesPanel; }
    public ReservasPanel getReservasPanel()       { return reservasPanel; }
}
