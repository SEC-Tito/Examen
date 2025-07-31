package hotelreservas.vista;

import javax.swing.*;
import java.awt.*;

/**
 * Ventana de login para el sistema de reservas.
 */
public class LoginFrame extends JFrame {
    private JTextField userField;
    private JPasswordField passField;
    private JButton loginBtn;

    public LoginFrame() {
        setTitle("Login - Hotel");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        initComponents();
        pack();
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);

        JLabel userLbl = new JLabel("Usuario:");
        gbc.gridx = 0; gbc.gridy = 0;
        add(userLbl, gbc);

        userField = new JTextField(15);
        gbc.gridx = 1; gbc.gridy = 0;
        add(userField, gbc);

        JLabel passLbl = new JLabel("Contraseña:");
        gbc.gridx = 0; gbc.gridy = 1;
        add(passLbl, gbc);

        passField = new JPasswordField(15);
        gbc.gridx = 1; gbc.gridy = 1;
        add(passField, gbc);

        loginBtn = new JButton("Ingresar");
        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2;
        add(loginBtn, gbc);
    }

    public JTextField getUserField() { return userField; }
    public JPasswordField getPassField() { return passField; }
    public JButton getLoginBtn() { return loginBtn; }
}
