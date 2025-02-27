/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectsukses.Controllers;

import projectsukses.Models.User;
import projectsukses.Views.*;

/**
 *
 * @author ACER NITRO
 */
public class MainUserController {

    void showMainUserPage(User user) {
        MainUser db = new MainUser();
        db.setVisible(true);
        db.setLocationRelativeTo(null);  
    }
    
}
