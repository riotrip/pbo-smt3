package backend;

import java.sql.*;
import java.util.ArrayList;

public class Peminjaman {
    private int idPeminjaman;   // ID Peminjaman
    private int idPegawai;      // ID Pegawai
    private Anggota anggota;
    private Buku buku;
    private String tanggalPinjam;
    private String tanggalKembali;

    public Peminjaman() {
    }

    // Constructor Tunggal
    public Peminjaman(int idPeminjaman, int idPegawai, Anggota anggota, Buku buku, String tanggalPinjam, String tanggalKembali) {
        this.idPeminjaman = idPeminjaman;
        this.idPegawai = idPegawai;
        this.anggota = anggota;
        this.buku = buku;
        this.tanggalPinjam = tanggalPinjam;
        this.tanggalKembali = tanggalKembali;
    }

    // Getter and Setter
    public int getIdPeminjaman() {
        return idPeminjaman;
    }

    public void setIdPeminjaman(int idPeminjaman) {
        this.idPeminjaman = idPeminjaman;
    }

    public int getIdPegawai() {
        return idPegawai;
    }

    public void setIdPegawai(int idPegawai) {
        this.idPegawai = idPegawai;
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

    // CRUD Operations
    public void save() {
        if (idPeminjaman == 0) {
            // Proses Peminjaman
            String query = "INSERT INTO peminjaman (idpegawai, idanggota, idbuku, tanggalpinjam, tanggalKembali) VALUES ("
                    + idPegawai + ", "
                    + anggota.getIdAnggota() + ", "
                    + buku.getIdbuku() + ", '"
                    + tanggalPinjam + "', NULL)";
            this.idPeminjaman = DBHelper.insertQueryGetId(query);
        } else {
            // Proses Kembali
            String query = "UPDATE peminjaman SET tanggalKembali = '" + tanggalKembali
                    + "' WHERE idpeminjaman = " + idPeminjaman;
            DBHelper.executeQuery(query);
        }
    }

    public Peminjaman getById(int id) {
        Peminjaman peminjaman = null;
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM peminjaman WHERE idpeminjaman = " + id);

        try {
            if (rs.next()) {
                peminjaman = new Peminjaman(
                        rs.getInt("idpeminjaman"),
                        rs.getInt("idpegawai"),
                        new Anggota().getById(rs.getInt("idanggota")),
                        new Buku().getById(rs.getInt("idbuku")),
                        rs.getString("tanggalpinjam"),
                        rs.getString("tanggalKembali")
                );
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
                Peminjaman peminjaman = new Peminjaman(
                        rs.getInt("idpeminjaman"),
                        rs.getInt("idpegawai"),
                        new Anggota().getById(rs.getInt("idanggota")),
                        new Buku().getById(rs.getInt("idbuku")),
                        rs.getString("tanggalpinjam"),
                        rs.getString("tanggalKembali")
                );
                listPeminjaman.add(peminjaman);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listPeminjaman;
    }

    public void delete() {
        String query = "DELETE FROM peminjaman WHERE idpeminjaman = " + this.idPeminjaman;
        DBHelper.executeQuery(query);
    }
}
