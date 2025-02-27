/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectsukses.Controllers;

import javax.swing.JOptionPane;
import javax.swing.plaf.OptionPaneUI;
import projectsukses.Models.Admin;
import projectsukses.Models.User;
import projectsukses.Views.LoginAdmin;
import projectsukses.Views.LoginUser;
import projectsukses.Views.RegisterUser;
    
/**
 *
 * @author ACER NITRO
 */
public class LoginController {
    LoginUser userLogin;
    LoginAdmin adminLogin;
    
     //Login user
    public void showViewLoginUser() {
        userLogin = new LoginUser(this);
        userLogin.setLocationRelativeTo(null);  
        userLogin.setVisible(true);
    }

    public void userLogin(String username, String password) {
        // Cek jika username atau password kosong
        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Username dan password tidak boleh kosong", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Membuat objek User dengan username dan password yang diberikan
        User user = new User(username,null, password);
        
        // Periksa username dan password
        if (user.checkLogin()) {
            // Jika benar, maka lanjut muncul pop up berhasil dan menuju ke page utama
            JOptionPane.showMessageDialog(null, "Berhasil Login", "Success",JOptionPane.INFORMATION_MESSAGE);
            MainUserController mainusercontroller = new MainUserController();
            mainusercontroller.showMainUserPage(user);
            userLogin.dispose(); 
        } else {
             JOptionPane.showMessageDialog(null, "Login gagal, username atau password salah", "Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //Login Admin
    public void showViewLoginAdmin() {
        adminLogin = new LoginAdmin(this);
        adminLogin.setLocationRelativeTo(null);  
        adminLogin.setVisible(true);
    }

    public void adminLogin(String username, String password) {
        // Cek jika username atau password kosong
        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Username dan password tidak boleh kosong", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Membuat objek User dengan username dan password yang diberikan
        Admin admin = new Admin(username, password);
        
        // Periksa username dan password
        if (admin.checkLogin()) {
            // Jika benar, maka lanjut muncul pop up berhasil dan menuju ke page utama
            JOptionPane.showMessageDialog(null, "Berhasil Login", "Success",JOptionPane.INFORMATION_MESSAGE);
            MainAdminController mainadmincontroller = new MainAdminController();
            mainadmincontroller.showMainAdminPage(admin);
            adminLogin.dispose(); 
        } else {
             JOptionPane.showMessageDialog(null, "Login gagal, username atau password salah", "Error",JOptionPane.ERROR_MESSAGE);
        }
    }
}
