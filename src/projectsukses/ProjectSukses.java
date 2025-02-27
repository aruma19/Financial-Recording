/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectsukses;

import projectsukses.Controllers.*;
import projectsukses.Views.*;

/**
 *
 * @author ACER NITRO
 */

public class ProjectSukses {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        LoginController loginController = new LoginController();
        loginController.showViewLoginAdmin();

//        LoginController loginController = new LoginController();
//        loginController.showViewLoginUser();

//        ChoiceController choiceController = new ChoiceController();
//        choiceController.showViewChoice();
         
    }
    
}
