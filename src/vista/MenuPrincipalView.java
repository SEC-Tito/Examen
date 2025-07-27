package vista;

import javax.swing.*;
import java.awt.*;

public class MenuPrincipalView extends JFrame {

    private JTabbedPane tabbedPane;

    public MenuPrincipalView(String rolUsuario) {
        setTitle("Sistema de Gestión de Hotel - " + rolUsuario);
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        tabbedPane = new JTabbedPane();

        // Crear paneles vacíos por ahora
        JPanel clientesPanel = new PanelClientes();

       JPanel habitacionesPanel = new PanelHabitaciones();
       
        JPanel reservasPanel = new JPanel();
        reservasPanel.add(new JLabel("Gestión de Reservas"));

        // Añadir pestañas
        tabbedPane.addTab("Clientes", clientesPanel);
        tabbedPane.addTab("Habitaciones", habitacionesPanel);
        tabbedPane.addTab("Reservas", reservasPanel);

        add(tabbedPane);
        setVisible(true);
    }
}
