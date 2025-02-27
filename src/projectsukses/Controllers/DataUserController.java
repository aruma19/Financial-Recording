/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectsukses.Controllers;

import java.util.List;
import projectsukses.Controllers.DAODataUser.DataUserDAO;
import projectsukses.Implements.DataImplement;
import projectsukses.Models.*;
import projectsukses.Views.*;

/**
 *
 * @author ACER NITRO
 */

public class DataUserController {
    TabelUser view;
    TabelData piew;
    DataImplement implement;
    List<DataFinance> df;

    public DataUserController(TabelUser view) {
        this.view = view;
        implement = new DataUserDAO();
        df = implement.getAll();
    }
    
    public DataUserController(TabelData piew) {
        this.piew = piew;
        implement = new DataUserDAO();
        df = implement.getAll();
    }
    
//    public DataUserController(TabelData piew) {
//        this.piew = piew;
//        implement = new DataUserDAO();
//        df = implement.getAll();
//    }
    
    public void showViewDataUser(){
        MainAdmin mv = new MainAdmin();
        mv.setVisible(true);
        mv.setLocationRelativeTo(null);  
    }

    
    public void isiTabel(){
        df = implement.getAll();
        UserTabelModel utb = new UserTabelModel(df);   
        view.getTbUser().setModel(utb);
    }
    
    public void insert(){
        DataFinance df = new DataFinance();
        df.setNama(view.getTfInputNama().getText());
        df.setKeterangan(view.getTfInputKeterangan().getText());
        df.setHarga(Integer.parseInt(view.getTfInputHarga().getText()));
        df.setTanggal(view.getTfInputTanggal().getText());
        df.setKategori(view.getTfInputKategori().getText());
        df.setCatatan(view.getTfInputCatatan().getText());
        implement.insert(df);
    }
    
    public void update(){
        DataFinance df = new DataFinance();
        df.setNama(view.getTfInputNama().getText());
        df.setKeterangan(view.getTfInputKeterangan().getText());
        df.setHarga(Integer.parseInt(view.getTfInputHarga().getText()));
        df.setTanggal(view.getTfInputTanggal().getText());
        df.setKategori(view.getTfInputKategori().getText());
        df.setCatatan(view.getTfInputCatatan().getText());
        df.setId_datauser(Integer.parseInt(view.getTfInputId().getText()));
        implement.update(df);
    }
    
    public void delete(){
        int id_datauser = Integer.parseInt(view.getTfInputId().getText());
        implement.delete(id_datauser);
    }
}
