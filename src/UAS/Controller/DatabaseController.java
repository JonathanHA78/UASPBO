/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UAS.Controller;

import UAS.Model.CategoryUser;
import UAS.Model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author JoeMaxwell
 */
public class DatabaseController {
     static DatabaseHandler conn = new DatabaseHandler();

    // SELECT ALL from table users
    public ArrayList<User> getAllUsers() {
        ArrayList<User> datas = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM user";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                User data = new User();
                data.setUserId(rs.getInt("userid"));
                data.setUserName(rs.getString("userName"));
                data.setPassword(rs.getString("password"));
                data.setUserEmail(rs.getString("userEmail"));
                data.setUserGender(rs.getString("userGender"));
                CategoryUser cat = new CategoryUser();
                cat.setCategoryName(rs.getString("userCategory"));
                data.setUserCategory(cat);
                data.setUserFollowers(rs.getInt("userFollowers"));
                datas.add(data);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (datas);
    }
    
        public ArrayList<CategoryUser> getAllCategoryUser() {
        ArrayList<CategoryUser> datas = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM CategoryUser";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                CategoryUser data = new CategoryUser();
                data.setCategoryId(rs.getInt("categoryId"));
                data.setCategoryName(rs.getString("categoryName"));
                datas.add(data);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (datas);
    }
    

    // INSERT
    public boolean insertNewUser(User user) {
        conn.connect();
        String query = "INSERT INTO ktp VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
//            stmt.setString(1, user.getNIK());
//            stmt.setString(2, user.getNama());
//            stmt.setString(3, user.getTempatLahir());
//            stmt.setString(4, user.getTanggalLahir());
//            stmt.setString(5, user.getJenisKelamin());
//            stmt.setString(6, user.getGolDar());
//            stmt.setString(7, user.getAlamat());
//            stmt.setString(8, user.getRTRW());
//            stmt.setString(9, user.getKelDes());
//            stmt.setString(10, user.getKecamatan());
//            stmt.setString(11, user.getAgama());
//            stmt.setString(12, user.getStatusPerkawinan());
//            stmt.setString(13, user.getPekerjaan());
//            stmt.setString(14, user.getKewarganegaraan());
//            stmt.setString(15, user.getFoto());
//            stmt.setString(16, user.getTandaTangan());
//            stmt.setString(17, user.getBerlaku());
//            stmt.setString(18, user.getKotaPembuatan());
//            stmt.setString(19, user.getTanggalPembuatan());
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }

    

    // DELETE
    public boolean deleteUser(String nik) {
        conn.connect();

        String query = "DELETE FROM ktp WHERE nik='" + nik + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
}
