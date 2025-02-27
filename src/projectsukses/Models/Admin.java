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
public class Admin {
    private int NIP;
    private String username;
    private String password;
    private String email;
    Connection connect; 
    Statement statement;
    boolean isLoggedIn=false;

    public Admin(String username, String password) {
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
        try{
            connect = DriverManager.getConnection("jdbc:mysql://localhost/projectpbo", "root", "");
            statement = connect.createStatement();
            //PEMERIKSAAN DATA LOGIN MAHASISWA.
            String query = "SELECT * FROM `admin` WHERE `username` ='"+username+"' AND `password` ='"+password+"'";
            
            ResultSet rs = statement.executeQuery(query);
            System.out.println(query);
            while(rs.next()){
                System.out.println(rs.getString("username")+" - " + rs.getString("password"));
                if(rs.getString("username").equals(username) && 
                        rs.getString("password").equals(password)){
                    isLoggedIn = true;
                }
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return isLoggedIn;
        
    }

}