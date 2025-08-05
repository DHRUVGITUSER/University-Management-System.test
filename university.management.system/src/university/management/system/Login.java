package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JTextField textFieldName;
    JPasswordField passwordField;
    JButton Login, back;

    Login() {
        setLayout(null);

        JLabel labelName = new JLabel("Username:");
        labelName.setBounds(50, 50, 100, 30);
        add(labelName);

        textFieldName = new JTextField();
        textFieldName.setBounds(150, 50, 150, 30);
        add(textFieldName);

        JLabel labelPass = new JLabel("Password:");
        labelPass.setBounds(50, 100, 100, 30);
        add(labelPass);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 100, 150, 30);
        add(passwordField);

        Login = new JButton("Login");
        Login.setBounds(50, 150, 100, 30);
        Login.setBackground(Color.BLACK);
        Login.setForeground(Color.WHITE);
        Login.addActionListener(this);
        add(Login);

        back = new JButton("Back");
        back.setBounds(200, 150, 100, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        // ✅ Image icon loaded from icon folder
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/second.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(350, 20, 200, 200);
        add(img);

        setSize(600, 300);
        setLocation(500, 250);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Login) {
            String username = textFieldName.getText();
            String password = new String(passwordField.getPassword());

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/universitymanagement", "root", "WJ28@krhps");

                // ✅ Secure SQL query
                String query = "SELECT * FROM Login WHERE username=? AND password=?";
                PreparedStatement pst = con.prepareStatement(query);
                pst.setString(1, username);
                pst.setString(2, password);

                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Login Successful");
                    new main_class().setVisible(true);
                    setVisible(false);// Close login frame
                    // Optional next screen
                    // new Dashboard().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                }

                rs.close();
                pst.close();
                con.close();

            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            }

        } else if (e.getSource() == back) {
            this.dispose(); // Close frame
        }
    }

    public static void main(String[] args) {
        new Login();
}
}