package frontend;

import backend.*;

public class TestBackend {
    public static void main(String[] args) {
        Kategori kat1 = new Kategori("Novel", "Koleksi buku novel");
        Kategori kat2 = new Kategori("Referensi", "Buku referensi ilmiah");
        Kategori kat3 = new Kategori("Komik", "Komik anak-anak");
        // test insert
        kat1.save();
        kat2.save();
        kat3.save();
        // test update
        kat2.setKeterangan("Koleksi buku referensi ilmiah");
        kat2.save();
        // test delete
        kat3.delete();
        // test select all
        for(Kategori k : new Kategori().getAll()) {
            System.out.println("Nama: " + k.getNama() + ", Ket: " + k.getKeterangan());
        }
        // test search
        for(Kategori k : new Kategori().search("ilmiah")) {
            System.out.println("Nama: " + k.getNama() + ", Ket: " + k.getKeterangan());
        }
        
        Anggota anggota1 = new Anggota("Rio", "Malang", "081234");
        Anggota anggota2 = new Anggota("Tri", "Surabaya", "085678");
        Anggota anggota3 = new Anggota("Prayogo", "Tulungagung", "084321");

        anggota1.save();
        anggota2.save();
        anggota3.save();

        for(Anggota a : new Anggota().getAll()) {
            System.out.println("Nama: " + a.getNama() + ", Alamat: " + a.getAlamat());
        }
    }
}