package vista;

import controlador.LoginController;

import javax.swing.*;
import java.awt.*;

public class LoginView extends JFrame {
    private JTextField userField;
    private JPasswordField passField;
    private JButton loginButton;

    public LoginView() {
        setTitle("Login - Hotel");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        userField = new JTextField(15);
        passField = new JPasswordField(15);
        loginButton = new JButton("Iniciar Sesión");

        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(new JLabel("Usuario:"));
        panel.add(userField);
        panel.add(new JLabel("Contraseña:"));
        panel.add(passField);
        panel.add(new JLabel()); // vacío
        panel.add(loginButton);

        add(panel);

        // Enlazar controlador
        new LoginController(this);

        setVisible(true);
    }

    public String getUsuario() {
        return userField.getText();
    }

    public String getPassword() {
        return new String(passField.getPassword());
    }

    public JButton getLoginButton() {
        return loginButton;
    }
}
