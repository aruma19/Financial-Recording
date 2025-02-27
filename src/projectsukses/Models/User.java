/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectsukses.Models;

import java.sql.*;
import javax.swing.JOptionPane;

/** 
 *
 * @author ACER NITRO
 */
public class User {
    private int id_user;
    private String username;
    private String password;
    private String email;
    Connection connect; 
    Statement statement;
    boolean isLoggedIn=false;

    public User(String username, String email, String password) {
        this.username = username;
        this.password = password;
        this.email = email;
        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost/projectpbo", "root", "");
        }catch (SQLException e) {
            System.out.println("Koneksi Gagal : " + e.getMessage());
        }
    }

    public boolean checkLogin() {
        String query = "SELECT * FROM `user` WHERE `username` = ? AND `password` = ?";
        try (PreparedStatement stmt = connect.prepareStatement(query)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    if (rs.getString("username").equals(username) && rs.getString("password").equals(password)) {
                        isLoggedIn = true;
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println("Login gagal: " + ex.getMessage());
        }
        return isLoggedIn;
        
    }

    // nambah data
    public boolean registerData() {
    String query = "INSERT INTO `user` (`username`, `email`, `password`) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connect.prepareStatement(query)) {
            statement.setString(1, username);
            statement.setString(2, email);
            statement.setString(3, password);
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("User telah berhasil registrasi!");
                return true; // Registrasi Berhasil
            } else {
                return false; // Registrasi Gagal
            }
        } catch (SQLException ex) {
            System.out.println("User gagal registrasi: " + ex.getMessage());
           
        }
         return isLoggedIn;
    }
}