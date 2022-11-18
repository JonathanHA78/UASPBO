/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UAS.View;

import UAS.Controller.DatabaseController;
import UAS.Model.User;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author JoeMaxwell
 */
public class MenuLogin {

    public MenuLogin() {
        JFrame frame = new JFrame("Login");
        frame.setSize(500, 400);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        String pathFoto = "C:\\Users\\JoeMaxwell\\Downloads\\Android_O_Preview_Logo.png";

        ImageIcon iconFoto = new ImageIcon(new ImageIcon(pathFoto).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));

        JLabel pasFoto = new JLabel();
        pasFoto.setIcon(iconFoto);
        pasFoto.setBounds(20, 20, 50, 50);
        frame.add(pasFoto);

        JLabel iconTitle = new JLabel("O APP");
        iconTitle.setBounds(25, 70, 75, 30);
        frame.add(iconTitle);

        JLabel title = new JLabel("Login");
        title.setBounds(197, 50, 200, 50);
        title.setFont(new Font("Sans", Font.CENTER_BASELINE, 32));
        frame.add(title);

        JLabel username = new JLabel("Username");
        username.setBounds(155, 110, 75, 25);
        JTextField inputUsername = new JTextField();
        inputUsername.setBounds(155, 135, 175, 25);
        frame.add(username);
        frame.add(inputUsername);

        JLabel password = new JLabel("Password");
        password.setBounds(155, 170, 75, 25);
        JPasswordField inputPassword = new JPasswordField();
        inputPassword.setBounds(155, 195, 175, 25);
        frame.add(password);
        frame.add(inputPassword);

        JButton back = new JButton("Back to menu");
        back.setBounds(25, 325, 150, 25);
        frame.add(back);
        back.addActionListener(e -> {
            frame.dispose();
            new MainMenuScreen();
        });

        JButton login = new JButton("Login");
        login.setBounds(205, 235, 75, 25);
        frame.add(login);
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = inputUsername.getText();
                String password = new String(inputPassword.getPassword());
                String warning = "Terdapat input yang masih kosong";
                if (username.equals("") || password.equals("")) {
                    JOptionPane.showMessageDialog(null, warning, "Peringatan", JOptionPane.WARNING_MESSAGE);
                } else {
                    warning = "Gagal Login";
                    DatabaseController db = new DatabaseController();
                    ArrayList<User> users = db.getAllUsers();
                    int i = 0;
                    boolean found = false;
                    boolean passwordCheck = false;
                    while (i < users.size() && !found) {
                        if (users.get(i).getUserName().equals(username)) {
                            found = true;
                            if (password.equals(users.get(i).getPassword())) {
                                passwordCheck = true;
                            } else {
                                warning = "Gagal Login";
                            }
                        } else {
                            i++;
                        }
                    }
                    if (passwordCheck) {
                        new MainMenuUser();
                        frame.dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, warning, "Peringatan", JOptionPane.WARNING_MESSAGE);
                    }
                }

            }
        });

    }

    public static void main(String[] args) {
        new MenuLogin();
    }
}
