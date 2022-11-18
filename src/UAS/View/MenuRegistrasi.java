/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UAS.View;
import UAS.Controller.DatabaseController;
import UAS.Model.CategoryUser;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author JoeMaxwell
 */
public class MenuRegistrasi {
    public MenuRegistrasi(){
        
        JFrame frame = new JFrame("Register");
        frame.setSize(600, 475);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        JLabel title = new JLabel("Register");
        title.setBounds(225, 50, 200, 50);
        title.setFont(new Font("Sans", Font.CENTER_BASELINE, 32));
        frame.add(title);

        JLabel email = new JLabel("Email");
        email.setBounds(90, 110, 75, 25);
        JTextField inputEmail = new JTextField();
        inputEmail.setBounds(90, 135, 175, 25);
        frame.add(email);
        frame.add(inputEmail);

        JLabel username = new JLabel("Username");
        username.setBounds(90, 170, 100, 25);
        JTextField inputUsername = new JTextField();
        inputUsername.setBounds(90, 195, 175, 25);
        frame.add(username);
        frame.add(inputUsername);

        JLabel jenisKelamin = new JLabel("Jenis Kelamin");
        jenisKelamin.setBounds(90, 230, 100, 25);
        JRadioButton r1 = new JRadioButton("Male");
        r1.setBounds(90, 255, 75, 25);
        JRadioButton r2 = new JRadioButton("Female");
        r2.setBounds(165, 255, 75, 25);
        ButtonGroup bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);
        frame.add(jenisKelamin);
        frame.add(r1);
        frame.add(r2);

        JLabel password = new JLabel("Password");
        password.setBounds(320, 110, 100, 25);
        JPasswordField inputPassword = new JPasswordField();
        inputPassword.setBounds(320, 135, 175, 25);
        frame.add(password);
        frame.add(inputPassword);

        JLabel jenisPengguna = new JLabel("Jenis Pengguna");
        jenisPengguna.setBounds(320, 170, 100, 25);
        DatabaseController db = new DatabaseController();      
        ArrayList<CategoryUser> cu = db.getAllCategoryUser();
        int a = 320;
        int b = 195;
        int c = 125;
        int d = 25;
        for (int i = 0; i < cu.size(); i++) {
            JCheckBox cek = new JCheckBox(cu.get(i).getCategoryName());
            cek.setBounds(a, b, c, d);
            frame.add(cek);
            b += 20;
        }
        frame.add(jenisPengguna);

       

        JButton register = new JButton("Register");
        register.setBounds(230, 305, 120, 30);
        frame.add(register);
        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = inputUsername.getText();
                String email = inputEmail.getText();
                String password = new String(inputPassword.getPassword());
                String warning = "Data belum lengkap";
                if ("".equals(username) || "".equals(email) || "".equals(password)) {
                    JOptionPane.showMessageDialog(null, warning, "Peringatan", JOptionPane.WARNING_MESSAGE);
                } else {


//                    int i = 0;
//                    boolean exist = false;
//                    while (i < customers.size() && !exist) {
//                        if (customers.get(i).getUsername().equals(username)) {
//                            exist = true;
//                            warning = "Username telah digunakan";
//                        } else if (customers.get(i).getNama_lengkap().equals(namaLengkap)) {
//                            exist = true;
//                            warning = "Nama sudah terdaftar";
//                        } else if (customers.get(i).getEmail().equals(email)) {
//                            exist = true;
//                            warning = "Email sudah terdaftar";
//                        } else if (customers.get(i).getNoTelpon().equals(noTelepon)) {
//                            exist = true;
//                            warning = "Nomor Telepon telah digunakan";
//                        } else {
//                            i++;
//                        }
//                    }
//                    if (exist) {
//                        JOptionPane.showMessageDialog(null, warning, "Peringatan", JOptionPane.WARNING_MESSAGE);
//                    } else {
//                        Customer newCust = new Customer();
//                        newCust.setAlamat(alamat);
//                        newCust.setChatroom(new ChatRoom());
//                        newCust.setEmail(email);
//                        newCust.setKeranjang(new ArrayList<>());
//                        newCust.setNama_lengkap(namaLengkap);
//                        newCust.setNoTelpon(noTelepon);
//                        newCust.setPassword(password);
//                        newCust.setTipeuser(TipeUser.CUSTOMER);
//                        newCust.setTransaksi(new ArrayList<>());
//                        newCust.setUsername(username);
//
//                        boolean executeInsert = db.insertNewUser(newCust);
//                        if (executeInsert) {
//                            frame.dispose();
//                            JOptionPane.showMessageDialog(null, "Registrasi berhasil!");
//                            new MenuLogin();
//                        } else {
//                            JOptionPane.showMessageDialog(null, "Registrasi gagal!", "Peringatan", JOptionPane.WARNING_MESSAGE);
//                        }
//                    }

                }

            }
        });
    }
    public static void main(String[] args) {
        new MenuRegistrasi();
    }
 
    
}
