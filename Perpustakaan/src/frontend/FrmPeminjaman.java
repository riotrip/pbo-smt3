/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frontend;

import backend.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author ASUS
 */
public class FrmPeminjaman extends javax.swing.JFrame {

    /**
     * Creates new form FrmPeminjaman
     */
    public FrmPeminjaman() {
        initComponents();
        tampilkanDataPeminjaman();
        kosongkanForm();
        
        txtTanggalPinjam.setText(getCurrentDate());
    }
    
    private String getCurrentDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(new Date());
    }
    
    private boolean isValidDate(String dateStr) {
        try {
<<<<<<< HEAD
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            formatter.setLenient(false); 
            formatter.parse(dateStr); 
=======
            // Format tanggal yyyy-MM-dd
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            formatter.setLenient(false); // Non-lenient untuk memastikan validitas tanggal
            formatter.parse(dateStr);    // Coba parsing tanggal
>>>>>>> fe3010e150e04d78158d09a1dcd29734545fecc9
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private void kosongkanForm() {
        txtIdPeminjaman.setText("0");
        txtIdAnggota.setText("");
        txtIdBuku.setText("");
<<<<<<< HEAD
        txtTanggalPinjam.setText(getCurrentDate()); 
=======
        txtTanggalPinjam.setText(getCurrentDate()); // Isi dengan current date
>>>>>>> fe3010e150e04d78158d09a1dcd29734545fecc9
        txtTanggalKembali.setText("");
        lblNamaAnggota.setText("Nama Anggota");
        lblJudulBuku.setText("Judul Buku");

<<<<<<< HEAD
        txtIdAnggota.setEnabled(true);
        txtIdBuku.setEnabled(true);
        txtTanggalKembali.setEnabled(false); 
=======
        // Default: semua field aktif (untuk peminjaman)
        txtIdAnggota.setEnabled(true);
        txtIdBuku.setEnabled(true);
        txtTanggalKembali.setEnabled(false); // Disable pengembalian secara default
>>>>>>> fe3010e150e04d78158d09a1dcd29734545fecc9
    }
    
    private void tampilkanDataPeminjaman() {
        String[] kolom = {"ID Peminjaman", "ID Pegawai", "Nama Anggota", "Judul Buku", "Tanggal Pinjam", "Tanggal Pengembalian"};
        ArrayList<Peminjaman> list = new Peminjaman().getAll();
        Object rowData[] = new Object[6];

        tblPeminjaman.setModel(new DefaultTableModel(new Object[][]{}, kolom));

        for (Peminjaman p : list) {
            rowData[0] = p.getIdPeminjaman();
            rowData[1] = p.getIdPegawai();
            rowData[2] = p.getAnggota().getNama();
            rowData[3] = p.getBuku().getJudul();
            rowData[4] = p.getTanggalPinjam();
            rowData[5] = p.getTanggalKembali();
            ((DefaultTableModel) tblPeminjaman.getModel()).addRow(rowData);
        }
    }

    private void cariAnggota() {
        int idAnggota = Integer.parseInt(txtIdAnggota.getText());
        Anggota anggota = new Anggota().getById(idAnggota);
        if (anggota != null) {
            lblNamaAnggota.setText(anggota.getNama());
        } else {
            lblNamaAnggota.setText("Anggota tidak ditemukan");
        }
    }

    private void cariBuku() {
        int idBuku = Integer.parseInt(txtIdBuku.getText());
        Buku buku = new Buku().getById(idBuku);
        if (buku != null) {
            lblJudulBuku.setText(buku.getJudul());
        } else {
            lblJudulBuku.setText("Buku tidak ditemukan");
        }
    }

    private void simpanPeminjaman() {
        Peminjaman p = new Peminjaman();
        p.setIdPeminjaman(Integer.parseInt(txtIdPeminjaman.getText()));
<<<<<<< HEAD
        p.setIdPegawai(1);
=======
        p.setIdPegawai(1); // Contoh: Pegawai admin default
>>>>>>> fe3010e150e04d78158d09a1dcd29734545fecc9
        p.setAnggota(new Anggota().getById(Integer.parseInt(txtIdAnggota.getText())));
        p.setBuku(new Buku().getById(Integer.parseInt(txtIdBuku.getText())));
        p.setTanggalPinjam(txtTanggalPinjam.getText());
        p.save();

<<<<<<< HEAD
=======
        // Refresh tabel dan kosongkan form
>>>>>>> fe3010e150e04d78158d09a1dcd29734545fecc9
        tampilkanDataPeminjaman();
        kosongkanForm();
    }

    private void simpanPengembalian() {
        String tanggalPengembalian = txtTanggalKembali.getText();

<<<<<<< HEAD
        if (!isValidDate(tanggalPengembalian)) {
            JOptionPane.showMessageDialog(this, "Tanggal pengembalian harus dalam format YYYY-MM-DD.");
=======
        // Validasi format tanggal
        if (!isValidDate(tanggalPengembalian)) {
            JOptionPane.showMessageDialog(this, "Tanggal pengembalian harus dalam format yyyy-MM-dd.");
>>>>>>> fe3010e150e04d78158d09a1dcd29734545fecc9
            return;
        }

        int id = Integer.parseInt(txtIdPeminjaman.getText());
        Peminjaman p = new Peminjaman().getById(id);
        if (p != null) {
            p.setTanggalKembali(tanggalPengembalian);
            p.save();
            tampilkanDataPeminjaman();
            kosongkanForm();
            JOptionPane.showMessageDialog(this, "Buku berhasil dikembalikan.");

<<<<<<< HEAD
=======
            // Disable tombol setelah pengembalian selesai
>>>>>>> fe3010e150e04d78158d09a1dcd29734545fecc9
            btnSimpanPengembalian.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(this, "Peminjaman tidak ditemukan.");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtIdPeminjaman = new javax.swing.JTextField();
        txtIdAnggota = new javax.swing.JTextField();
        txtIdBuku = new javax.swing.JTextField();
        txtTanggalPinjam = new javax.swing.JTextField();
        txtTanggalKembali = new javax.swing.JTextField();
        lblNamaAnggota = new javax.swing.JLabel();
        lblJudulBuku = new javax.swing.JLabel();
        btnSimpanPeminjaman = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPeminjaman = new javax.swing.JTable();
        btnCariBuku = new javax.swing.JButton();
        btnCariAnggota = new javax.swing.JButton();
        btnSimpanPengembalian = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("ID Peminjaman");

        jLabel3.setText("ID Anggota");

        jLabel4.setText("ID Buku");

        jLabel5.setText("Tanggal Pinjam");

        jLabel6.setText("Tanggal Kembali");

        txtIdPeminjaman.setEnabled(false);
        txtIdPeminjaman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdPeminjamanActionPerformed(evt);
            }
        });

        txtTanggalPinjam.setEnabled(false);

        lblNamaAnggota.setText("Nama");

        lblJudulBuku.setText("Judul");

        btnSimpanPeminjaman.setText("Simpan");
        btnSimpanPeminjaman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanPeminjamanActionPerformed(evt);
            }
        });

        tblPeminjaman.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblPeminjaman.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPeminjamanMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblPeminjaman);

        btnCariBuku.setText("Cari");
        btnCariBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariBukuActionPerformed(evt);
            }
        });

        btnCariAnggota.setText("Cari");
        btnCariAnggota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariAnggotaActionPerformed(evt);
            }
        });

        btnSimpanPengembalian.setText("Kembalikan");
        btnSimpanPengembalian.setEnabled(false);
        btnSimpanPengembalian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanPengembalianActionPerformed(evt);
            }
        });

        jLabel7.setText("YYYY-MM-DD");

        jLabel8.setText("YYYY-MM-DD");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSimpanPeminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSimpanPengembalian))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNamaAnggota, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtIdPeminjaman, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                                        .addComponent(txtIdAnggota)
                                        .addComponent(txtIdBuku)
                                        .addComponent(txtTanggalPinjam)
                                        .addComponent(txtTanggalKembali))
                                    .addComponent(lblJudulBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnCariBuku, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCariAnggota, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtIdPeminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtIdAnggota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCariAnggota)))
                .addGap(9, 9, 9)
                .addComponent(lblNamaAnggota)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtIdBuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCariBuku)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblJudulBuku)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTanggalPinjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTanggalKembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpanPeminjaman)
                    .addComponent(btnSimpanPengembalian))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdPeminjamanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdPeminjamanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdPeminjamanActionPerformed

    private void btnSimpanPeminjamanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanPeminjamanActionPerformed
        // TODO add your handling code here:
        simpanPeminjaman();
    }//GEN-LAST:event_btnSimpanPeminjamanActionPerformed

    private void btnCariAnggotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariAnggotaActionPerformed
        // TODO add your handling code here:
        cariAnggota();
    }//GEN-LAST:event_btnCariAnggotaActionPerformed

    private void btnCariBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariBukuActionPerformed
        // TODO add your handling code here:
        cariBuku();
    }//GEN-LAST:event_btnCariBukuActionPerformed

    private void tblPeminjamanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPeminjamanMouseClicked
        // TODO add your handling code here:
<<<<<<< HEAD
        int selectedRow = tblPeminjaman.getSelectedRow(); 
        DefaultTableModel model = (DefaultTableModel) tblPeminjaman.getModel();

=======
        int selectedRow = tblPeminjaman.getSelectedRow(); // Ambil baris yang dipilih
        DefaultTableModel model = (DefaultTableModel) tblPeminjaman.getModel();

        // Ambil data dari tabel
>>>>>>> fe3010e150e04d78158d09a1dcd29734545fecc9
        int idPeminjaman = Integer.parseInt(model.getValueAt(selectedRow, 0).toString());
        String tanggalPengembalian = model.getValueAt(selectedRow, 5) != null
                ? model.getValueAt(selectedRow, 5).toString()
                : "";

<<<<<<< HEAD
=======
        // Isi data ke form
>>>>>>> fe3010e150e04d78158d09a1dcd29734545fecc9
        txtIdPeminjaman.setText(String.valueOf(idPeminjaman));
        txtTanggalKembali.setText(tanggalPengembalian);

        if (tanggalPengembalian.isEmpty()) {
<<<<<<< HEAD
            btnSimpanPengembalian.setEnabled(true);
            txtTanggalKembali.setEnabled(true);

            txtIdAnggota.setEnabled(false);
            txtIdBuku.setEnabled(false);
        } else {
=======
            // Jika buku belum dikembalikan, aktifkan tombol Simpan Pengembalian
            btnSimpanPengembalian.setEnabled(true);
            txtTanggalKembali.setEnabled(true);

            // Disable semua field kecuali tanggalPengembalian
            txtIdAnggota.setEnabled(false);
            txtIdBuku.setEnabled(false);
        } else {
            // Jika buku sudah dikembalikan, disable tombol dan semua field
>>>>>>> fe3010e150e04d78158d09a1dcd29734545fecc9
            btnSimpanPengembalian.setEnabled(false);
            txtTanggalKembali.setEnabled(false);
            txtIdAnggota.setEnabled(false);
            txtIdBuku.setEnabled(false);
        }
    }//GEN-LAST:event_tblPeminjamanMouseClicked

    private void btnSimpanPengembalianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanPengembalianActionPerformed
        // TODO add your handling code here:
<<<<<<< HEAD
        if (txtTanggalKembali.isEnabled()) { 
=======
        if (txtTanggalKembali.isEnabled()) { // Hanya berlaku saat pengembalian
>>>>>>> fe3010e150e04d78158d09a1dcd29734545fecc9
            simpanPengembalian();
        }
    }//GEN-LAST:event_btnSimpanPengembalianActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmPeminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPeminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPeminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPeminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPeminjaman().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCariAnggota;
    private javax.swing.JButton btnCariBuku;
    private javax.swing.JButton btnSimpanPeminjaman;
    private javax.swing.JButton btnSimpanPengembalian;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblJudulBuku;
    private javax.swing.JLabel lblNamaAnggota;
    private javax.swing.JTable tblPeminjaman;
    private javax.swing.JTextField txtIdAnggota;
    private javax.swing.JTextField txtIdBuku;
    private javax.swing.JTextField txtIdPeminjaman;
    private javax.swing.JTextField txtTanggalKembali;
    private javax.swing.JTextField txtTanggalPinjam;
    // End of variables declaration//GEN-END:variables
}
