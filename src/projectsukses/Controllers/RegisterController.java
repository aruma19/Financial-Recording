/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectsukses.Controllers;

import javax.swing.JOptionPane;
import javax.swing.plaf.OptionPaneUI;
import projectsukses.Models.User;
import projectsukses.Views.RegisterUser;

/**
 *
 * @author ACER NITRO
 */
public class RegisterController {
    RegisterUser registerUser;
    
    public void showViewRegister() {
        registerUser = new RegisterUser(this);
        registerUser.setLocationRelativeTo(null);  
    }
    
    public void userRegister(String username, String password, String email) {
        // Cek apakah username atau password kosong
        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Username dan password tidak boleh kosong", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        User user = new User(username, password, email);
            
        if (user.registerData()) {
            JOptionPane.showMessageDialog(null, "Berhasil menambahkan data", "Success",JOptionPane.INFORMATION_MESSAGE);
            LoginController lc = new LoginController();
            lc.showViewLoginUser();

        // Menyembunyikan tampilan registrasi
            registerUser.setVisible(false);
        } else {
            // Tampilan error ketika gagal
            JOptionPane.showMessageDialog(null, "Data sudah ada di database", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
