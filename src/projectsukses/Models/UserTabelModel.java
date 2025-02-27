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
public class UserTabelModel extends AbstractTableModel{

    List<DataFinance> df;

    public UserTabelModel(List<DataFinance> df){
        this.df = df;
    }

    @Override
    public int getRowCount() {
        return df.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){ 
            case 0 : return "ID"; 
            case 1 : return "NAMA"; 
            case 2 : return "KETERANGAN"; 
            case 3 : return "HARGA"; 
            case 4 : return "TANGGAL"; 
            case 5 : return "KATEGORI"; 
            case 6 : return "CATATAN"; 
            default : return null;
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch(column){
            case 0 : return df.get(row).getId_datauser();
            case 1 : return df.get(row).getNama(); 
            case 2 : return df.get(row).getKeterangan(); 
            case 3 : return df.get(row).getHarga(); 
            case 4 : return df.get(row).getTanggal(); 
            case 5 : return df.get(row).getKategori();
            case 6 : return df.get(row).getCatatan(); 
            default : return null;
        }
    }
    
}
