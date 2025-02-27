/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectsukses.Models;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ACER NITRO
 */
public class UserTabel extends AbstractTableModel{
    List<DataFinance> df;

    public UserTabel(List<DataFinance> df){
        this.df = df;
    }

    @Override
    public int getRowCount() {
        return df.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){ 
            case 0 : return "USERNAME"; 
            case 1 : return "EMAIL"; 
            case 2 : return "PASSWORD"; 
            default : return null;
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch(column){
            case 0 : return df.get(row).getId_datauser();
            case 1 : return df.get(row).getNama(); 
            case 2 : return df.get(row).getKeterangan(); 
            default : return null;
        }
    }
}
