/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectsukses.Controllers.DAODataUser;

import java.sql.*;
import java.util.*;
import projectsukses.Implements.DataImplement;
import projectsukses.Models.DataFinance;
import projectsukses.Views.*;

/**
 *
 * @author ACER NITRO
 */
public class DataUserDAO implements DataImplement{
    Connection koneksi;
    Statement kalimat;

    private final String dbUrl = "jdbc:mysql://localhost/projectpbo";
    private final String user = "root";
    private final String pass = "";
    

    final String select = "SELECT * FROM datauser";
//    final String ambilid = "SELECT * FROM `datauser` where id_pengguna = ";
    final String insert = "INSERT INTO `datauser` (`nama`, `keterangan`, `harga`, `tanggal`, `kategori`, `catatan`) "
            + "VALUES (?, ?, ?, ?, ?, ?)";
    final String update = "update datauser set nama = ?, keterangan = ?,harga = ?, tanggal= ?, kategori = ?, catatan= ?"
            + "WHERE id_datauser=?"; 
    final String delete = "delete from datauser where id_datauser = ?";
    
    public DataUserDAO(){
        try {
            koneksi = DriverManager.getConnection(dbUrl, user, pass);
        } catch (SQLException e) {
            System.out.println("koneksi gagal");
        }
    }

    @Override
    public void delete(int id) {
        PreparedStatement statement = null;
        try{
            statement = koneksi.prepareStatement(delete);
            statement.setInt(1, id);
            statement.executeUpdate();
        }catch(SQLException ex){
            System.out.println("Koneksi DB gagal");
        }
    }


    @Override
    public List<DataFinance> getAll() {
        List<DataFinance> df = null;
        try{
            df = new ArrayList<DataFinance>();
            koneksi = DriverManager.getConnection(dbUrl, user, pass);
            kalimat = koneksi.createStatement();
            ResultSet rs = kalimat.executeQuery(select);
            while(rs.next()){
                DataFinance datap = new DataFinance();
                datap.setId_datauser(Integer.parseInt(rs.getString("id_datauser")));
                datap.setNama(rs.getString("nama"));
                datap.setKeterangan(rs.getString("keterangan"));
                datap.setHarga(Integer.parseInt(rs.getString("harga")));
                datap.setTanggal(rs.getString("tanggal"));
                datap.setKategori(rs.getString("kategori"));
                datap.setCatatan(rs.getString("catatan"));
                df.add(datap);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return df;
    }

    @Override
    public void insert(DataFinance p) {
        PreparedStatement statement = null;
        try{
            statement = koneksi.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, p.getNama());
            statement.setString(2, p.getKeterangan());
            statement.setString(3, String.valueOf(p.getHarga()));
            statement.setString(4, p.getTanggal());
            statement.setString(5, p.getKategori());
            statement.setString(6, p.getCatatan());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            while(rs.next()){
                p.setId_datauser(rs.getInt(1));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }       

    @Override
    public void update(DataFinance p) {
        PreparedStatement statement = null;
        try{
            statement = koneksi.prepareStatement(update);
            statement.setString(1, p.getNama());
            statement.setString(2, p.getKeterangan());
            statement.setString(3, String.valueOf(p.getHarga()));
            statement.setString(4, p.getTanggal());
            statement.setString(5, p.getKategori());
            statement.setString(6, p.getCatatan());
            statement.setString(7, String.valueOf(p.getId_datauser()));
            statement.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
