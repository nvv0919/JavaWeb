package view;

import CSDL.HoSoKH;
import DBEngine.DBEngine;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static view.ScreenKH.HoSoDat;

public final class ScreenAdmin extends javax.swing.JFrame {
    static Connection con;
    private int selectedIndex;
    private final DefaultTableModel hoSoKHTableModel = new DefaultTableModel(new Object[]{"MaKH", "TenKh", "NgaySinh", "GioiTinh", "CCCD", "DanToc","DiaChiTT"}, 0);
    HoSoKH x;
    static String name;
    static ArrayList<HoSoKH> HoSoKH = new ArrayList<>();
    
    public ScreenAdmin() {
        initComponents();
        LoadDataToArrayList();
        LoadDataArrayListToTable();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btHienThiTT1 = new javax.swing.JButton();
        txtMaKH = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbKH = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        sxTheoTen = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btHienThiTT = new javax.swing.JButton();
        txtMaKH1 = new javax.swing.JTextField();

        btHienThiTT1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btHienThiTT1.setText("Hiển thị thông tin đất");
        btHienThiTT1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btHienThiTT1ActionPerformed(evt);
            }
        });

        txtMaKH.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản Lý Đất Đai");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Quản lý khách hàng");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(304, 304, 304)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(336, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        tbKH.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbKH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã KH", "Tên Khách Hàng", "Ngày Sinh", "Giới tính", "CCCD", "Dân Tộc", "Địa chỉ thường chú"
            }
        ));
        tbKH.setToolTipText("");
        tbKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbKHMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbKH);

        jButton4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton4.setText("Thoát");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        sxTheoTen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        sxTheoTen.setText("Sắp xếp theo tên");
        sxTheoTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sxTheoTenActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton3.setText("Sắp xếp theo MaKH");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        btHienThiTT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btHienThiTT.setText("Hiển thị thông tin đất");
        btHienThiTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btHienThiTTActionPerformed(evt);
            }
        });

        txtMaKH1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(txtMaKH1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(btHienThiTT)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sxTheoTen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addContainerGap(84, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(sxTheoTen)
                    .addComponent(jButton3)
                    .addComponent(btHienThiTT)
                    .addComponent(txtMaKH1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void LoadDataToArrayList() {
        HoSoDat.clear();
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlydatdai?useSSL=false", "root", "123456");
            String caulenh = "SELECT * FROM hosokh";
            PreparedStatement ps = con.prepareStatement(caulenh);
            ResultSet rs= ps.executeQuery();
            String MaKH,TenKH,NgaySinh,GioiTinh,CCCD,DanToc,DiaChiTT;
            while (rs.next()) {
                MaKH = rs.getString(1);
                TenKH = rs.getString(2);
                NgaySinh = rs.getString(3);
                GioiTinh = rs.getString(4);
                CCCD = rs.getString(5);
                DanToc = rs.getString(6);
                DiaChiTT = rs.getString(7);
                HoSoKH hoSoKH = new HoSoKH(MaKH, TenKH, NgaySinh, GioiTinh, CCCD, DanToc, DiaChiTT);
                HoSoKH.add(hoSoKH);
            }
            ps.close();
            con.close();
        } catch (Exception e) {
        }
    }

    public void LoadDataArrayListToTable() {
        DefaultTableModel hosokhModel = (DefaultTableModel) tbKH.getModel();
        hosokhModel.setRowCount(0);
        for (HoSoKH x : HoSoKH) {
            hosokhModel.addRow(new Object[]{x.getMaKH(),x.getTenKH(),x.getNgaySinh(),x.getGioiTinh(),x.getCCCD(),x.getDanToc(),x.getDiaChiTT()});
        }
    }
    private void btHienThiTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btHienThiTTActionPerformed
        selectedIndex = tbKH.getSelectedRow();
        if(selectedIndex == -1){
            JOptionPane.showMessageDialog(new JFrame(), "Vui Lòng chọn khách hàng trong bảng");
        }else{
            try {
                String makh = txtMaKH1.getText();
                ScreenView scview = new ScreenView(makh);
                scview.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(ScreenAdmin.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ScreenAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btHienThiTTActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        login login = new login();
        login.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed
    private static int pos = 0;
    public void View(){
        x = HoSoKH.get(pos);
        this.txtMaKH1.setText(x.getMaKH());
    }
    private void tbKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbKHMouseClicked
        pos = this.tbKH.getSelectedRow();
        View(); 
    }//GEN-LAST:event_tbKHMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        clickCount++;
        if (clickCount % 2 == 0) {
            Collections.sort(HoSoKH, (a, b) -> a.getMaKH().compareTo(b.getMaKH()));
        } else {
            Collections.sort(HoSoKH, (a, b) -> b.getMaKH().compareTo(a.getMaKH()));
        }
        LoadDataArrayListToTable(); 
    }//GEN-LAST:event_jButton3ActionPerformed
    int clickCount = 0;
    private void sxTheoTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sxTheoTenActionPerformed
        clickCount++;
        if (clickCount % 2 == 0) {
            Collections.sort(HoSoKH, (a, b) -> a.getTenKH().compareTo(b.getTenKH()));
        } else {
            Collections.sort(HoSoKH, (a, b) -> b.getTenKH().compareTo(a.getTenKH()));
        }
        LoadDataArrayListToTable();        
    }//GEN-LAST:event_sxTheoTenActionPerformed

    private void btHienThiTT1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btHienThiTT1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btHienThiTT1ActionPerformed
    public String goiMaKH(){
        String makh = txtMaKH1.getText();
        return makh;
    }
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
            java.util.logging.Logger.getLogger(ScreenAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ScreenAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ScreenAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ScreenAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ScreenAdmin().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btHienThiTT;
    private javax.swing.JButton btHienThiTT1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton sxTheoTen;
    private javax.swing.JTable tbKH;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtMaKH1;
    // End of variables declaration//GEN-END:variables

}
