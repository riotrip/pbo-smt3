package backend;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.ArrayList;
import java.sql.*;

public class Pegawai {
    private int idPegawai;
    private String nama, alamat, notelp, jabatan, username, password;

    public int getIdPegawai() {
        return idPegawai;
    }

    public void setIdPegawai(int idPegawai) {
        this.idPegawai = idPegawai;
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

    public String getNotelp() {
        return notelp;
    }

    public void setNotelp(String notelp) {
        this.notelp = notelp;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Pegawai() {
    }

    public Pegawai(String nama, String alamat, String notelp, String jabatan, String username, String password) {
        this.nama = nama;
        this.alamat = alamat;
        this.notelp = notelp;
        this.jabatan = jabatan;
        this.username = username;
        this.password = password;
    }

    public Pegawai getById(int id) {
        Pegawai pegawai = new Pegawai();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM pegawai WHERE idpegawai = " + id + ";");
        try {
            while (rs.next()) {
                pegawai = new Pegawai();
                pegawai.setIdPegawai(rs.getInt("idpegawai"));
                pegawai.setNama(rs.getString("nama"));
                pegawai.setAlamat(rs.getString("alamat"));
                pegawai.setNotelp(rs.getString("notelp"));
                pegawai.setJabatan(rs.getString("jabatan"));
                pegawai.setUsername(rs.getString("username"));
                pegawai.setPassword(rs.getString("password"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pegawai;
    }
    
    public ArrayList<Pegawai> getAll() {
        ArrayList<Pegawai> listPegawai = new ArrayList<>();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM pegawai");
        try {
            while (rs.next()) {
                Pegawai pegawai = new Pegawai();
                pegawai.setIdPegawai(rs.getInt("idpegawai"));
                pegawai.setNama(rs.getString("nama"));
                pegawai.setAlamat(rs.getString("alamat"));
                pegawai.setNotelp(rs.getString("notelp"));
                pegawai.setJabatan(rs.getString("jabatan"));
                pegawai.setUsername(rs.getString("username"));
                pegawai.setPassword(rs.getString("password"));
                listPegawai.add(pegawai);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listPegawai;
    }

    public ArrayList<Pegawai> search(String keyword) {
        ArrayList<Pegawai> listPegawai = new ArrayList<>();
        String sql = "SELECT * FROM pegawai WHERE " +
                     "nama LIKE '%" + keyword + "%' " +
                     "OR alamat LIKE '%" + keyword + "%'";
        ResultSet rs = DBHelper.selectQuery(sql);
        try {
            while (rs.next()) {
                Pegawai pegawai = new Pegawai();
                pegawai.setIdPegawai(rs.getInt("idpegawai"));
                pegawai.setNama(rs.getString("nama"));
                pegawai.setAlamat(rs.getString("alamat"));
                pegawai.setNotelp(rs.getString("notelp"));
                pegawai.setJabatan(rs.getString("jabatan"));
                pegawai.setUsername(rs.getString("username"));
                pegawai.setPassword(rs.getString("password"));
                listPegawai.add(pegawai);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listPegawai;
    }

    public void save() {
        if (getById(idPegawai).getIdPegawai()== 0) {
            String SQL = "INSERT INTO pegawai (nama, alamat, notelp, jabatan, username, password) VALUES (" +
                         "'" + this.nama + "', " +
                         "'" + this.alamat + "', " +
                         "'" + this.notelp + "', " + 
                         "'" + this.jabatan + "', " +
                         "'" + this.username + "', " +
                         "'" + this.password + "')";
            this.idPegawai = DBHelper.insertQueryGetId(SQL);
        } else {
            String SQL = "UPDATE pegawai SET " +
             "nama = '" + this.nama + "', " +
             "alamat = '" + this.alamat + "', " +  
             "notelp = '" + this.notelp + "' " +
             "jabatan = '" + this.jabatan + "' " +
             "username = '" + this.username + "' " +
             "password = '" + this.password + "' " +                    
             "WHERE idpegawai = " + this.idPegawai;
            DBHelper.executeQuery(SQL);
        }
    }

    public void delete(){
        String SQL = "DELETE FROM pegawai WHERE idpegawai = '" + this.idPegawai + "'";
        DBHelper.executeQuery(SQL);
    }
    
    public boolean isUsernamePasswordExist(String username, String password) {
        boolean exist = false;
        try {
            String sql = "SELECT COUNT(*) FROM pegawai WHERE username = ? AND password = ?";
            PreparedStatement stmt = DBHelper.getConnection().prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                exist = rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exist;
    }    
}
