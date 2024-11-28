/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import java.util.ArrayList;
import java.sql.*;

public class Anggota {
    private int idAnggota;
    private String nama;
    private String alamat;
    private String telepon;

    public int getIdAnggota() {
        return idAnggota;
    }

    public void setIdAnggota(int idAnggota) {
        this.idAnggota = idAnggota;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    public Anggota() {
    }

    public Anggota( String nama, String alamat, String telepon) {
        this.nama = nama;
        this.alamat = alamat;
        this.telepon = telepon;
    }
    
    public Anggota getById(int id) {
        Anggota anggota = new Anggota();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM anggota WHERE idanggota = " + id + ";");
        try {
            while (rs.next()) {
                anggota = new Anggota();
                anggota.setIdAnggota(rs.getInt("idanggota"));
                anggota.setNama(rs.getString("nama"));
                anggota.setAlamat(rs.getString("alamat"));
                anggota.setTelepon(rs.getString("telepon"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return anggota;
    }
    
    public ArrayList<Anggota> getAll() {
        ArrayList<Anggota> listAnggota = new ArrayList<>();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM anggota");
        try {
            while (rs.next()) {
                Anggota anggota01 = new Anggota();
                anggota01.setIdAnggota(rs.getInt("idanggota"));
                anggota01.setNama(rs.getString("nama"));
                anggota01.setAlamat(rs.getString("alamat"));
                anggota01.setTelepon(rs.getString("telepon"));
                listAnggota.add(anggota01);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listAnggota;
    }

    public ArrayList<Anggota> search(String keyword) {
        ArrayList<Anggota> listAnggota = new ArrayList<>();
        String sql = "SELECT * FROM anggota WHERE " +
                     "nama LIKE '%" + keyword + "%' " +
                     "OR alamat LIKE '%" + keyword + "%'";
        ResultSet rs = DBHelper.selectQuery(sql);
        try {
            while (rs.next()) {
                Anggota anggota01 = new Anggota();
                anggota01.setIdAnggota(rs.getInt("idanggota"));
                anggota01.setNama(rs.getString("nama"));
                anggota01.setAlamat(rs.getString("alamat"));
                anggota01.setTelepon(rs.getString("telepon"));
                listAnggota.add(anggota01);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listAnggota;
    }

    public void save() {
        if (getById(idAnggota).getIdAnggota()== 0) {
            String SQL = "INSERT INTO anggota (nama, alamat, telepon) VALUES (" +
                         "'" + this.nama + "', " +
                         "'" + this.alamat + "', " +
                         "'" + this.telepon + "' )";
            this.idAnggota = DBHelper.insertQueryGetId(SQL);
        } else {
            String SQL = "UPDATE anggota SET " +
             "nama = '" + this.nama + "', " +
             "alamat = '" + this.alamat + "', " +  
             "telepon = '" + this.telepon + "' " +
             "WHERE idanggota = " + this.idAnggota;
            DBHelper.executeQuery(SQL);
        }
    }

    public void delete(){
        String SQL = "DELETE FROM anggota WHERE idanggota = '" + this.idAnggota + "'";
        DBHelper.executeQuery(SQL);
    }
}
