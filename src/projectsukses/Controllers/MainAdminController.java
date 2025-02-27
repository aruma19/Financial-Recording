/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectsukses.Controllers;

import projectsukses.Models.Admin;
import projectsukses.Views.*;

/**
 *
 * @author ACER NITRO
 */
public class MainAdminController {

    void showMainAdminPage(Admin admin) {
        MainAdmin db = new MainAdmin();
        db.setVisible(true);
        db.setLocationRelativeTo(null);  
    }
    
}
