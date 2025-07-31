package hotelreservas.main;

import hotelreservas.vista.LoginFrame;
import hotelreservas.controlador.LoginController;
import javax.swing.SwingUtilities;

/**
 * Punto de entrada de la aplicación.
 */
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginFrame loginView = new LoginFrame();
            // Enlazamos el controlador de login
            new LoginController(loginView);
            loginView.setVisible(true);
        });
    }
}
