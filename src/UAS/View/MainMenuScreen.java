/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UAS.View;


import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author JoeMaxwell
 */
public class MainMenuScreen {
     public MainMenuScreen() {
        JFrame frame = new JFrame();

        frame.setSize(250, 300);
        frame.setTitle("Menu");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton login = new JButton("Login");
        login.addActionListener(e -> {
            new MenuLogin();
            frame.dispose();
        });
        JButton regisrasi = new JButton("Registrasi");
        regisrasi.addActionListener(e -> {
            new MenuRegistrasi();
            frame.dispose();
        });
        JButton lihatData = new JButton("Lihat Data ");
        lihatData.addActionListener(e -> {

            frame.dispose();
        });
        
        

        login.setBounds(50, 50, 125, 50);
        regisrasi.setBounds(50, 125, 125, 50);
        lihatData.setBounds(50, 200, 125, 50);
        frame.add(login);
        frame.add(regisrasi);
        frame.add(lihatData);
        frame.setLayout(null);
        frame.setVisible(true);

    }
}
