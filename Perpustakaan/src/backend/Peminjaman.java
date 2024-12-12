package backend;

import java.sql.*;
import java.util.ArrayList;

public class Peminjaman {
    private int idPeminjaman;
    private Anggota anggota;
    private Buku buku;
    private String tanggalPinjam;
    private String tanggalKembali;
    private boolean status; 

    public Peminjaman() {}

    public Peminjaman(Anggota anggota, Buku buku, String tanggalPinjam, String tanggalKembali, boolean status) {
        this.anggota = anggota;
        this.buku = buku;
        this.tanggalPinjam = tanggalPinjam;
        this.tanggalKembali = tanggalKembali;
        this.status = status;
    }

    public int getIdPeminjaman() {
        return idPeminjaman;
    }

    public void setIdPeminjaman(int idPeminjaman) {
        this.idPeminjaman = idPeminjaman;
    }

    public Anggota getAnggota() {
        return anggota;
    }

    public void setAnggota(Anggota anggota) {
        this.anggota = anggota;
    }

    public Buku getBuku() {
        return buku;
    }

    public void setBuku(Buku buku) {
        this.buku = buku;
    }

    public String getTanggalPinjam() {
        return tanggalPinjam;
    }

    public void setTanggalPinjam(String tanggalPinjam) {
        this.tanggalPinjam = tanggalPinjam;
    }

    public String getTanggalKembali() {
        return tanggalKembali;
    }

    public void setTanggalKembali(String tanggalKembali) {
        this.tanggalKembali = tanggalKembali;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    // CRUD Operations
    public Peminjaman getById(int id) {
        Peminjaman peminjaman = null;
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM peminjaman WHERE idpeminjaman = " + id);

        try {
            while (rs.next()) {
                peminjaman = new Peminjaman();
                peminjaman.setIdPeminjaman(rs.getInt("idpeminjaman"));
                peminjaman.setAnggota(new Anggota().getById(rs.getInt("idanggota")));
                peminjaman.setBuku(new Buku().getById(rs.getInt("idbuku")));
                peminjaman.setTanggalPinjam(rs.getString("tanggalpinjam"));
                peminjaman.setTanggalKembali(rs.getString("tanggalkembali"));
                peminjaman.setStatus(rs.getBoolean("status"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return peminjaman;
    }

    public ArrayList<Peminjaman> getAll() {
        ArrayList<Peminjaman> listPeminjaman = new ArrayList<>();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM peminjaman");

        try {
            while (rs.next()) {
                Peminjaman peminjaman = new Peminjaman();
                peminjaman.setIdPeminjaman(rs.getInt("idpeminjaman"));
                peminjaman.setAnggota(new Anggota().getById(rs.getInt("idanggota")));
                peminjaman.setBuku(new Buku().getById(rs.getInt("idbuku")));
                peminjaman.setTanggalPinjam(rs.getString("tanggalpinjam"));
                peminjaman.setTanggalKembali(rs.getString("tanggalkembali"));
                peminjaman.setStatus(rs.getBoolean("status"));

                listPeminjaman.add(peminjaman);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listPeminjaman;
    }

    public void save() {
        if (getById(idPeminjaman).idPeminjaman == 0) {
            String query = "INSERT INTO peminjaman (idanggota, idbuku, tanggalpinjam, tanggalkembali, status) VALUES ("
                    + this.getAnggota().getIdAnggota() + ", "
                    + this.getBuku().getIdbuku() + ", '"
                    + this.getTanggalPinjam() + "', '"
                    + this.getTanggalKembali() + "', "
                    + (this.getStatus() ? 1 : 0) + ")";
            this.idPeminjaman = DBHelper.insertQueryGetId(query);
        } else {
            String query = "UPDATE peminjaman SET idanggota = " + this.getAnggota().getIdAnggota()
                    + ", idbuku = " + this.getBuku().getIdbuku()
                    + ", tanggalpinjam = '" + this.getTanggalPinjam()
                    + "', tanggalkembali = '" + this.getTanggalKembali()
                    + "', status = " + (this.getStatus() ? 1 : 0)
                    + " WHERE idpeminjaman = " + this.idPeminjaman;
            DBHelper.executeQuery(query);
        }
    }

    public void delete() {
        String query = "DELETE FROM peminjaman WHERE idpeminjaman = " + this.idPeminjaman;
        DBHelper.executeQuery(query);
    }
}
