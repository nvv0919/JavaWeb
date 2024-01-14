/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import CSDL.HoSoDat;
import CSDL.HoSoKH;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author ngvie
 */
public final class ScreenView extends javax.swing.JFrame {
    static ArrayList<HoSoDat> HoSoDat = new ArrayList<>();
    HoSoDat x;
    String MaKH;
    private int selectedHoSoDatIndex = -1;
    static Connection con;
    private DefaultTableModel hoSoDatTableModel = new DefaultTableModel(new Object[]{"MaHS", "ToBanDo", "Thua", "DienTich", "DiaChiDat", "NgayMua"}, 0);

    public ScreenView() {
        initComponents();
    }
    public ScreenView(String MaKH) throws SQLException, ClassNotFoundException{
        initComponents();
        LoadDataToArrayList(MaKH);
        LoadDataArrayListToTable(MaKH);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
    }

    public void LoadDataToArrayList(String MaKH) {
        HoSoDat.clear();
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlydatdai?useSSL=false", "root", "123456");
            String caulenh = "SELECT * FROM hosodat where MaKH = ?";
            PreparedStatement ps1 = con.prepareStatement(caulenh);
            ps1.setString(1, MaKH);
            ResultSet rs1 = ps1.executeQuery();
            while (rs1.next()) {
                String mahs = rs1.getString("MaHS");
                String ToBanDo = rs1.getString(3);
                String Thua = rs1.getString(4);
                Float DienTich = rs1.getFloat(5);
                String DiaChiDat = rs1.getString(6);
                String NgayMua = rs1.getString(7);
                HoSoDat hsd = new HoSoDat(mahs, MaKH, ToBanDo, Thua, DiaChiDat, NgayMua, DienTich);
                HoSoDat.add(hsd);
            }
            con.close();
        } catch (SQLException e) {
        }
    }

    public void LoadDataArrayListToTable(String MaKh) {
        DefaultTableModel model = (DefaultTableModel) tbDat.getModel();
        model.setRowCount(0);
        for (HoSoDat hoSoDat : HoSoDat) {
            model.addRow(new Object[]{hoSoDat.getMaHS(), hoSoDat.getToBanDo(), hoSoDat.getThua(), hoSoDat.getDienTich(), hoSoDat.getDiaChiDat(), hoSoDat.getNgayMua()});
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDat = new javax.swing.JTable();
        txtFind = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btSXtheoTo = new javax.swing.JButton();
        btSapXepTheoThua = new javax.swing.JButton();
        btSXtheoDC = new javax.swing.JButton();
        btXoaTT = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        btSXtheoHS = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản Lý Đất Đai");

        tbDat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Hồ sơ", "Tờ", "Thửa", "Diện Tích", "Địa Chỉ đất", "Ngày Mua"
            }
        ));
        jScrollPane1.setViewportView(tbDat);

        txtFind.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setText("Tìm kiếm");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        btSXtheoTo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btSXtheoTo.setText("Sắp xếp theo tờ");
        btSXtheoTo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btSXtheoToMouseClicked(evt);
            }
        });

        btSapXepTheoThua.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btSapXepTheoThua.setText("Sắp xếp theo thửa");
        btSapXepTheoThua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btSapXepTheoThuaMouseClicked(evt);
            }
        });

        btSXtheoDC.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btSXtheoDC.setText("Sắp xếp theo địa chỉ đất");
        btSXtheoDC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btSXtheoDCMouseClicked(evt);
            }
        });
        btSXtheoDC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSXtheoDCActionPerformed(evt);
            }
        });

        btXoaTT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btXoaTT.setText("Xoá thông tin");
        btXoaTT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btXoaTTMouseClicked(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton6.setText("Thoát");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        btSXtheoHS.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btSXtheoHS.setText("Sắp xếp theo hồ sơ");
        btSXtheoHS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btSXtheoHSMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 751, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btSapXepTheoThua, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btXoaTT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btSXtheoHS, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btSXtheoTo, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(356, 356, 356)
                                .addComponent(jButton6))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btSXtheoDC)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btSXtheoTo)
                            .addComponent(btSXtheoHS)
                            .addComponent(btSXtheoDC))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btSapXepTheoThua)
                            .addComponent(btXoaTT))
                        .addGap(0, 22, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton6)))
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("DANH SÁCH CÁC THỬA ĐẤT CỦA KHÁCH HÀNG");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        HoSoDat.clear();
        try {
            String find = txtFind.getText();
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlydatdai?useSSL=false", "root", "123456");
            String caulenh = "SELECT * FROM hosodat WHERE (MaHS LIKE ?) or (ToBanDo LIKE ?) or (DiaChiDat LIKE ?) OR (Thua = ?)";
            PreparedStatement ps = con.prepareStatement(caulenh);
            ps.setString(1, "%" + find + "%");
            ps.setString(2, "%" + find + "%");
            ps.setString(3, "%" + find + "%");
            ps.setString(4, find);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String mahs = rs.getString("MaHS");
                String ToBanDo = rs.getString(3);
                String Thua = rs.getString(4);
                Float DienTich = rs.getFloat(5);
                String DiaChiDat = rs.getString(6);
                String NgayMua = rs.getString(7);
                HoSoDat hsd = new HoSoDat(mahs, MaKH, ToBanDo, Thua, DiaChiDat, NgayMua, DienTich);
                HoSoDat.add(hsd);
            }
            con.close();
            LoadDataArrayListToTable(MaKH);
        } catch (SQLException e) {
        }
    }//GEN-LAST:event_jButton1MouseClicked

    private void btSXtheoDCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSXtheoDCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btSXtheoDCActionPerformed
    private int clickCount;
    private void btSXtheoDCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSXtheoDCMouseClicked
        ScreenAdmin SA = new ScreenAdmin();
        String makh = SA.goiMaKH();
        clickCount++;
        if (clickCount % 2 == 0) {
            Collections.sort(HoSoDat, (a, b) -> a.getDiaChiDat().compareTo(b.getDiaChiDat()));
        } else {
            Collections.sort(HoSoDat, (a, b) -> b.getDiaChiDat().compareTo(a.getDiaChiDat()));
        }
        LoadDataArrayListToTable(makh);
    }//GEN-LAST:event_btSXtheoDCMouseClicked

    private void btSXtheoToMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSXtheoToMouseClicked
        ScreenAdmin SA = new ScreenAdmin();
        String makh = SA.goiMaKH();
        clickCount++;
        if (clickCount % 2 == 0) {
            Collections.sort(HoSoDat, (a, b) -> a.getToBanDo().compareTo(b.getToBanDo()));
        } else {
            Collections.sort(HoSoDat, (a, b) -> b.getToBanDo().compareTo(a.getToBanDo()));
        }
        LoadDataArrayListToTable(makh);
    }//GEN-LAST:event_btSXtheoToMouseClicked

    private void btSXtheoHSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSXtheoHSMouseClicked
        ScreenAdmin SA = new ScreenAdmin();
        String makh = SA.goiMaKH();
        clickCount++;
        if (clickCount % 2 == 0) {
            Collections.sort(HoSoDat, (a, b) -> a.getMaHS().compareTo(b.getMaHS()));
        } else {
            Collections.sort(HoSoDat, (a, b) -> b.getMaHS().compareTo(a.getMaHS()));
        }
        LoadDataArrayListToTable(makh);
    }//GEN-LAST:event_btSXtheoHSMouseClicked

    private void btSapXepTheoThuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSapXepTheoThuaMouseClicked
        ScreenAdmin SA = new ScreenAdmin();
        String makh = SA.goiMaKH();
        clickCount++;
        if (clickCount % 2 == 0) {
            Collections.sort(HoSoDat, (a, b) -> a.getThua().compareTo(b.getThua()));
        } else {
            Collections.sort(HoSoDat, (a, b) -> b.getThua().compareTo(a.getThua()));
        }
        LoadDataArrayListToTable(makh);
    }//GEN-LAST:event_btSapXepTheoThuaMouseClicked

    private void btXoaTTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btXoaTTMouseClicked
        ScreenAdmin SA = new ScreenAdmin();
        String makh = SA.goiMaKH();
        int row = tbDat.getSelectedRow();
        HoSoDat removedHoSoDat = HoSoDat.remove(row);
        String maHS = removedHoSoDat.getMaHS();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlydatdai?useSSL=false", "root", "123456");
            String caulenhsql = "DELETE FROM hosodat WHERE MaHS = ?";
            PreparedStatement ps = con.prepareStatement(caulenhsql);
            ps.setString(1, maHS);
            row = ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Xoá thành công!", "Success", JOptionPane.INFORMATION_MESSAGE);
            ps.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Cap nhat that bai");
            System.out.println(row);
        }
        LoadDataArrayListToTable(makh);
    }//GEN-LAST:event_btXoaTTMouseClicked

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
            java.util.logging.Logger.getLogger(ScreenView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ScreenView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ScreenView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ScreenView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ScreenView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btSXtheoDC;
    private javax.swing.JButton btSXtheoHS;
    private javax.swing.JButton btSXtheoTo;
    private javax.swing.JButton btSapXepTheoThua;
    private javax.swing.JButton btXoaTT;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbDat;
    private javax.swing.JTextField txtFind;
    // End of variables declaration//GEN-END:variables
}
