/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectsukses.Controllers;

import javax.swing.plaf.OptionPaneUI;
import projectsukses.Views.Choice;
/**
 *
 * @author ACER NITRO
 */
public class ChoiceController {
    Choice choiceLogin;
    
     public void showViewChoice() {
        choiceLogin = new Choice(this);
        choiceLogin.setLocationRelativeTo(null);  
        choiceLogin.setVisible(true);
    }
    
}
