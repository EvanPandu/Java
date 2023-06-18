/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package evanshoes;
import java.sql.*;

import javax.swing.table.DefaultTableModel;

import evanshoes.config.MyConfig;
import evanshoes.models.Produk;

/**
 *
 * @author Evan
 */
public class MainFrame extends javax.swing.JFrame {
    private int totalBelanja = 0;
    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        loadData();
        
         // Membuat objek DBController dengan konfigurasi dari myConfig
    }

    private void loadData() {
        // Konfigurasi koneksi database
        String url = "jdbc:mysql://localhost:3306/rb_produk";
        String username = "root";
        String password = "";
    
        // Koneksi ke database
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            // Statement untuk menjalankan query
            Statement stmt = conn.createStatement();
    
            // Query untuk mengambil data dari tabel
            String query = "SELECT * FROM rb_tabel";
    
            // Eksekusi query dan ambil hasilnya
            ResultSet rs = stmt.executeQuery(query);
    
            // Buat model tabel
            DefaultTableModel model = (DefaultTableModel) tableDatabase.getModel();
    
            // Hapus semua baris yang ada di tabel
            model.setRowCount(0);
    
            // Loop melalui hasil query dan tambahkan data ke dalam model tabel
            while (rs.next()) {
                int id = rs.getInt("ID");
                String nama = rs.getString("Nama");
                long harga = rs.getLong("Harga");
                int stock = rs.getInt("Stock");
    
                // Tambahkan data ke dalam baris baru pada model tabel
                model.addRow(new Object[]{id, nama, harga, stock});
            }
    
            // Tutup statement dan result set
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDatabase = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        textFieldNamaBarang = new javax.swing.JTextField();
        textFieldHargaBarang = new javax.swing.JTextField();
        textFieldStockBarang = new javax.swing.JTextField();
        buttonTambah = new javax.swing.JButton();
        buttonHapus = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        textFieldTotalBelanja = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        textFieldUangAnda = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        textFieldKembalian = new javax.swing.JTextField();
        buttonBayar = new javax.swing.JButton();
        buttonTambahKeranjang = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        jLabel1.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        jLabel1.setText("Evan");

        jLabel2.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Shoes");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(245, 245, 245)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        tableDatabase.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nama", "Harga", "Stock"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Long.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableDatabase);

        jLabel3.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nama Barang  :");

        jLabel4.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Harga Barang :");

        jLabel5.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Stock Barang :");

        textFieldHargaBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldHargaBarangActionPerformed(evt);
            }
        });

        textFieldStockBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldStockBarangActionPerformed(evt);
            }
        });

        buttonTambah.setBackground(new java.awt.Color(153, 153, 153));
        buttonTambah.setText("TAMBAH");
        buttonTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String nama = textFieldNamaBarang.getText();
                String hargaStr = textFieldHargaBarang.getText();
                String stockStr = textFieldStockBarang.getText();

                long harga = Long.parseLong(hargaStr);
                int stock = Integer.parseInt(stockStr);

                String url = "jdbc:mysql://localhost:3306/rb_produk";
                String username = "root";
                String password = "";

                try (Connection conn = DriverManager.getConnection(url, username, password)) {
                    String query = "INSERT INTO rb_tabel (Nama, Harga, Stock) VALUES (?, ?, ?)";
                    PreparedStatement pstmt = conn.prepareStatement(query);
                    pstmt.setString(1, nama);
                    pstmt.setLong(2, harga);
                    pstmt.setInt(3, stock);
                    pstmt.executeUpdate();
                    pstmt.close();

                    // Mengosongkan field setelah menambahkan produk
                    textFieldNamaBarang.setText("");
                    textFieldHargaBarang.setText("");
                    textFieldStockBarang.setText("");

                    // Memuat ulang data
                    loadData();
                } catch (SQLException e) {
                    e.printStackTrace();
                }            }
        });

        buttonHapus.setText("HAPUS");
        buttonHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                    // Mendapatkan indeks baris yang dipilih
                    int selectedRow = tableDatabase.getSelectedRow();

                    if (selectedRow != -1) {
                        // Mendapatkan nilai ID pada kolom "ID" di baris yang dipilih
                        int id = (int) tableDatabase.getValueAt(selectedRow, 0);

                        // Konfigurasi koneksi database
                        String url = "jdbc:mysql://localhost:3306/rb_produk";
                        String username = "root";
                        String password = "";

                        // Koneksi ke database
                        try (Connection conn = DriverManager.getConnection(url, username, password)) {
                            // Statement untuk menjalankan query
                            Statement stmt = conn.createStatement();

                            // Query untuk menghapus data dari tabel berdasarkan ID
                            String query = "DELETE FROM rb_tabel WHERE ID = " + id;

                            // Eksekusi query
                            int affectedRows = stmt.executeUpdate(query);

                            if (affectedRows > 0) {
                                // Hapus baris dari model tabel
                                DefaultTableModel model = (DefaultTableModel) tableDatabase.getModel();
                                model.removeRow(selectedRow);
                            }
                            // Tutup statement
                            stmt.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }            
                }
        });

        jLabel6.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Total Belanja :");

        textFieldTotalBelanja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldTotalBelanjaActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Uang Anda     :");

        textFieldUangAnda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldUangAndaActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Kembalian     :");

        buttonBayar.setBackground(new java.awt.Color(255, 0, 0));
        buttonBayar.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        buttonBayar.setText("BAYAR");
        buttonBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String input = textFieldUangAnda.getText();
                try {
                    int number = Integer.parseInt(input);
                    int totalKembalian = number - totalBelanja;
                    if (totalKembalian < 0){
                        textFieldKembalian.setText("Uang anda tidak cukup");
                    } else {
                        textFieldKembalian.setText(String.valueOf("RP. " + totalKembalian));
                    }

                } catch (NumberFormatException ex) {
                    // Tangani kesalahan jika String tidak dapat diubah menjadi integer
                        textFieldKembalian.setText("Inputan Hanya Berupa Angka");
                }
            }
        });

        buttonTambahKeranjang.setBackground(new java.awt.Color(153, 153, 153));
        buttonTambahKeranjang.setText("Tambah Keranjang");
        buttonTambahKeranjang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                int selectedRow = tableDatabase.getSelectedRow();

                if (selectedRow != -1) {
                    try {
                        // Mendapatkan data stok pada kolom "Stok" di baris yang dipilih
                        int stock = (int) tableDatabase.getValueAt(selectedRow, 3);
                        if (stock > 0) {
                            // Mengurangi stok dengan 1
                            stock--;

                            // Memperbarui stok di dalam tabel
                            tableDatabase.setValueAt(stock, selectedRow, 3);

                            // Mendapatkan ID barang dari kolom "ID" di baris yang dipilih
                            int id = (int) tableDatabase.getValueAt(selectedRow, 0);

                            // Menghubungkan ke database
                            String url = "jdbc:mysql://localhost:3306/rb_produk";
                            String username = "root";
                            String password = "";
                            Connection connection = DriverManager.getConnection(url, username, password);

                            // Update stok di database
                            String query = "UPDATE rb_tabel SET stock = ? WHERE id = ?";
                            PreparedStatement statement = connection.prepareStatement(query);
                            statement.setInt(1, stock);
                            statement.setInt(2, id);
                            statement.executeUpdate();

                            // Lakukan sesuatu dengan stok yang telah diperbarui

                            // Menutup koneksi ke database
                            statement.close();
                            connection.close();
                        } else {
                            System.out.println("Stok barang kosong");
                        }

                        double hargaBarang = Double.parseDouble(tableDatabase.getValueAt(selectedRow, 2).toString());

                        // Menambahkan harga barang ke total belanjaan
                        totalBelanja += hargaBarang;

                        // Memperbarui label atau field yang menampilkan total belanjaan
                        textFieldTotalBelanja.setText(String.valueOf("Rp. " + totalBelanja));
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(textFieldNamaBarang))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(textFieldHargaBarang))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(textFieldStockBarang)))
                        .addGap(12, 12, 12))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(buttonTambahKeranjang, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(buttonTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                                .addComponent(buttonHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45))))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textFieldTotalBelanja)
                    .addComponent(textFieldUangAnda)
                    .addComponent(textFieldKembalian, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
                .addGap(78, 78, 78)
                .addComponent(buttonBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(textFieldNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4))
                            .addComponent(textFieldHargaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(textFieldStockBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonTambahKeranjang)))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(textFieldTotalBelanja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(textFieldUangAnda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(textFieldKembalian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textFieldHargaBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldHargaBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldHargaBarangActionPerformed

    private void buttonTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTambahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonTambahActionPerformed

    private void buttonHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHapusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonHapusActionPerformed

    private void textFieldUangAndaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldUangAndaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldUangAndaActionPerformed

    private void textFieldStockBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldStockBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldStockBarangActionPerformed

    private void textFieldTotalBelanjaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldTotalBelanjaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldTotalBelanjaActionPerformed

    private void buttonTambahKeranjangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTambahKeranjangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonTambahKeranjangActionPerformed

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonBayar;
    private javax.swing.JButton buttonHapus;
    private javax.swing.JButton buttonTambah;
    private javax.swing.JButton buttonTambahKeranjang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableDatabase;
    private javax.swing.JTextField textFieldHargaBarang;
    private javax.swing.JTextField textFieldKembalian;
    private javax.swing.JTextField textFieldNamaBarang;
    private javax.swing.JTextField textFieldStockBarang;
    private javax.swing.JTextField textFieldTotalBelanja;
    private javax.swing.JTextField textFieldUangAnda;
    // End of variables declaration//GEN-END:variables
}
