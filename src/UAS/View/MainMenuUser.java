/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UAS.View;

import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author JoeMaxwell
 */
public class MainMenuUser {
    public MainMenuUser(){
        JFrame frame = new JFrame("Menu User");
        frame.setSize(600, 475);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        JLabel title = new JLabel("Menu User");
        title.setBounds(225, 50, 200, 50);
        title.setFont(new Font("Sans", Font.CENTER_BASELINE, 32));
        frame.add(title);

    }
}
