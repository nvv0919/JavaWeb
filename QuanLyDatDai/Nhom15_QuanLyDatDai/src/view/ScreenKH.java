package view;

import CSDL.HoSoDat;
import CSDL.HoSoKH;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.util.Collections;
import javax.swing.JFrame;
import static view.ScreenView.con;

public final class ScreenKH extends javax.swing.JFrame {

    static ArrayList<HoSoDat> HoSoDat = new ArrayList<>();
    static ArrayList<HoSoKH> HoSoKH = new ArrayList<>();
    HoSoDat x;
    String MaKH;
    private int selectedHoSoDatIndex = -1;
    static Connection con;
    private DefaultTableModel hoSoDatTableModel = new DefaultTableModel(new Object[]{"MaHS", "ToBanDo", "Thua", "DienTich", "DiaChiDat", "NgayMua"}, 0);

    public ScreenKH() {
        initComponents();
    }

    public ScreenKH(String MaKH) throws SQLException, ClassNotFoundException {
        initComponents();
        dodulieu(MaKH);
        LoadDataToArrayList(MaKH);
        LoadDataArrayListToTable(MaKH);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
    }

    public void dodulieu(String MaKH) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlydatdai?useSSL=false", "root", "123456");
        String caulenhsql = "SELECT * FROM hosokh WHERE MaKH = ?";
        PreparedStatement ps = con.prepareStatement(caulenhsql);
        ps.setString(1, MaKH);
        ResultSet rs = ps.executeQuery();

        try {
            if (rs.next()) {
                txtMaKH.setText(rs.getString("MaKH"));
                txtTenKH.setText(rs.getString("TenKH"));
                txtNgaySinh.setText(rs.getString("NgaySinh"));
                String gioitinh = rs.getString("GioiTinh");
                if ("Nam".equals(gioitinh)) {
                    btNam.setSelected(true);
                } else {
                    btNu.setSelected(true);
                }
                txtCCCD.setText(rs.getString("CCCD"));
                txtDanToc.setText(rs.getString("DanToc"));
                txtDiaChiTT.setText(rs.getString("DiaChiTT"));
            }
        } catch (SQLException sQLException) {
            System.out.println("Không kết lối được");
        }
        con.close();
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
        } catch (Exception e) {
        }
    }

    public void LoadDataArrayListToTable(String MaKh) {
        DefaultTableModel model = (DefaultTableModel) tbHoSoDat.getModel();
        model.setRowCount(0);
        for (HoSoDat hoSoDat : HoSoDat) {
            model.addRow(new Object[]{hoSoDat.getMaHS(), hoSoDat.getToBanDo(), hoSoDat.getThua(), hoSoDat.getDienTich(), hoSoDat.getDiaChiDat(), hoSoDat.getNgayMua()});
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        buttomXoa = new javax.swing.JMenuItem();
        buttomCapNhat = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtMaKH = new javax.swing.JTextField();
        txtTenKH = new javax.swing.JTextField();
        txtNgaySinh = new javax.swing.JTextField();
        txtCCCD = new javax.swing.JTextField();
        txtDanToc = new javax.swing.JTextField();
        txtDiaChiTT = new javax.swing.JTextField();
        btNam = new javax.swing.JRadioButton();
        btNu = new javax.swing.JRadioButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbHoSoDat = new javax.swing.JTable();
        btAdd = new javax.swing.JButton();
        btDelete = new javax.swing.JButton();
        btSxtheoHS = new javax.swing.JButton();
        btSXtheoDC = new javax.swing.JButton();
        btUpdateHS = new javax.swing.JButton();
        btFind = new javax.swing.JButton();
        txtFind = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btUpdate = new javax.swing.JButton();

        buttomXoa.setText("Xoá");
        buttomXoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttomXoaMouseClicked(evt);
            }
        });
        buttomXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttomXoaActionPerformed(evt);
            }
        });
        jPopupMenu1.add(buttomXoa);

        buttomCapNhat.setText("Cập nhật");
        buttomCapNhat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttomCapNhatMouseClicked(evt);
            }
        });
        buttomCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttomCapNhatActionPerformed(evt);
            }
        });
        jPopupMenu1.add(buttomCapNhat);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản Lý Đất Đai");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Giao diện khách hàng");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Mã Khách hàng");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Tên Khách Hàng");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Ngày Sinh");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Giới Tính");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("CCCD");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Dân Tộc");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Địa Chỉ Chi Tiết");

        txtMaKH.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtTenKH.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtNgaySinh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtCCCD.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtDanToc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtDiaChiTT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        buttonGroup1.add(btNam);
        btNam.setText("Nam");

        buttonGroup1.add(btNu);
        btNu.setText("Nữ");

        tbHoSoDat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã HS", "Tờ Bản Đồ", "Thửa", "Diện Tích", "Địa Chỉ Đất", "Ngày Mua"
            }
        ));
        tbHoSoDat.setToolTipText("");
        tbHoSoDat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbHoSoDatMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbHoSoDatMouseReleased(evt);
            }
        });
        tbHoSoDat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbHoSoDatKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbHoSoDat);

        btAdd.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btAdd.setText("Thêm hồ sơ");
        btAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddActionPerformed(evt);
            }
        });

        btDelete.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btDelete.setText("Xoá hồ sơ");
        btDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteActionPerformed(evt);
            }
        });

        btSxtheoHS.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btSxtheoHS.setText("Sắp xếp theo HS");
        btSxtheoHS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSxtheoHSActionPerformed(evt);
            }
        });

        btSXtheoDC.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btSXtheoDC.setText("Sắp xếp theo địa chỉ");
        btSXtheoDC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSXtheoDCActionPerformed(evt);
            }
        });

        btUpdateHS.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btUpdateHS.setText("Cập nhật HS");
        btUpdateHS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUpdateHSActionPerformed(evt);
            }
        });

        btFind.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btFind.setText("Tìm kiếm");
        btFind.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btFindMouseClicked(evt);
            }
        });
        btFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFindActionPerformed(evt);
            }
        });

        txtFind.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFind.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtFind.setToolTipText("");
        txtFind.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFindKeyReleased(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setText("Thoát");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btDelete, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btAdd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btSXtheoDC)
                                .addGap(18, 18, 18)
                                .addComponent(btSxtheoHS, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btUpdateHS)
                                .addGap(18, 18, 18)
                                .addComponent(txtFind)
                                .addGap(18, 18, 18)
                                .addComponent(btFind))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 639, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAdd)
                    .addComponent(btUpdateHS)
                    .addComponent(btFind)
                    .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btDelete)
                    .addComponent(btSXtheoDC)
                    .addComponent(btSxtheoHS)
                    .addComponent(jButton1))
                .addGap(0, 29, Short.MAX_VALUE))
        );

        btUpdate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btUpdate.setText("Cập nhật");
        btUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTenKH)
                            .addComponent(txtNgaySinh)
                            .addComponent(txtCCCD)
                            .addComponent(txtDanToc)
                            .addComponent(txtDiaChiTT)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btUpdate)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btNam, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btNu, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(btNam)
                            .addComponent(btNu))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtCCCD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtDanToc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDiaChiTT, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addComponent(btUpdate))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbHoSoDatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbHoSoDatMouseClicked

    }//GEN-LAST:event_tbHoSoDatMouseClicked

    private void btUpdateHSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUpdateHSActionPerformed
        int row = 0;
        String makh = txtMaKH.getText();
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlydatdai?useSSL=false", "root", "123456");
            for (int i = 0; i < tbHoSoDat.getRowCount(); i++) {
                String sql = "UPDATE `quanlydatdai`.`hosodat` SET `ToBanDo` = ?,`Thua` = ?, `DienTich` = ?, `DiaChiDat` = ?, `NgayMua` = ? WHERE (`MaHS` = ?)";
                PreparedStatement ps = con.prepareStatement(sql);
                String mahs, tobando, thua, diachi, ngaymua;
                float dientich;
                tobando = tbHoSoDat.getValueAt(i, 1).toString();
                thua = tbHoSoDat.getValueAt(i, 2).toString();
                dientich = Float.parseFloat(tbHoSoDat.getValueAt(i, 3).toString());
                diachi = tbHoSoDat.getValueAt(i, 4).toString();
                ngaymua = tbHoSoDat.getValueAt(i, 5).toString();
                mahs = tbHoSoDat.getValueAt(i, 0).toString();

                ps.setString(1, tobando);
                ps.setString(2, thua);                
                ps.setFloat(3, dientich);
                ps.setString(4, diachi);
                ps.setString(5, ngaymua);
                ps.setString(6, mahs);
                row = ps.executeUpdate();
            }
            if (row > 0) {
                JOptionPane.showMessageDialog(this, "Thông tin đất đã được cập nhật", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Cập nhật thất bại", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
            con.close();
            LoadDataToArrayList(makh);
            LoadDataArrayListToTable(makh);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btUpdateHSActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        login lg = new login();
        lg.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddActionPerformed
        String MaKH = txtMaKH.getText();
        FormThem ft;
        try {
            ft = new FormThem(MaKH);
            ft.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(ScreenKH.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ScreenKH.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btAddActionPerformed

    private void btDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteActionPerformed
        String makh = txtMaKH.getText();
        int row = tbHoSoDat.getSelectedRow();
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
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Hãy chọn hồ sơ muốn xoá", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Cap nhat that bai");
            System.out.println(row);
        }
        LoadDataArrayListToTable(makh);
    }//GEN-LAST:event_btDeleteActionPerformed

    private void btUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUpdateActionPerformed
        String makh, tenkh, ngaysinh, gioitinh, cccd, dantoc, diachi;
        makh = txtMaKH.getText();
        HoSoKH hoSoKH = new HoSoKH();
        tenkh = txtTenKH.getText();
        ngaysinh = txtNgaySinh.getText();
        gioitinh = btNam.isSelected() ? "Nam" : "Nữ";
        cccd = txtCCCD.getText();
        dantoc = txtDanToc.getText();
        diachi = txtDiaChiTT.getText();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlydatdai?useSSL=false", "root", "123456");
            String sql = "Update hosokh set TenKH = ?, NgaySinh = ?, GioiTinh = ?, CCCD = ?, DanToc = ?, DiaChiTT = ? where MaKH = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, tenkh);
            ps.setString(2, ngaysinh);
            ps.setString(3, gioitinh);
            ps.setString(4, cccd);
            ps.setString(5, dantoc);
            ps.setString(6, diachi);
            ps.setString(7, makh);

            ps.executeUpdate();

            JOptionPane.showMessageDialog(this, "tài khoản đã được cập nhật thông tin", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (HeadlessException | ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(this, "An error occurred while creating the user account: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        LoadDataToArrayList(makh);
        LoadDataArrayListToTable(makh);
    }//GEN-LAST:event_btUpdateActionPerformed
    private int clickCount = 0;
    private void btSxtheoHSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSxtheoHSActionPerformed
        
        String makh = txtMaKH.getText();
        clickCount++;
        if (clickCount % 2 == 0) {
            Collections.sort(HoSoDat, (a, b) -> a.getMaHS().compareTo(b.getMaHS()));
        } else {
            Collections.sort(HoSoDat, (a, b) -> b.getMaHS().compareTo(a.getMaHS()));
        }
        LoadDataArrayListToTable(makh);
    }//GEN-LAST:event_btSxtheoHSActionPerformed

    private void txtFindKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFindKeyReleased

    }//GEN-LAST:event_txtFindKeyReleased

    private void btFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFindActionPerformed

    }//GEN-LAST:event_btFindActionPerformed

    private void buttomXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttomXoaActionPerformed

    }//GEN-LAST:event_buttomXoaActionPerformed

    private void buttomXoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttomXoaMouseClicked

    }//GEN-LAST:event_buttomXoaMouseClicked

    private void buttomCapNhatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttomCapNhatMouseClicked

    }//GEN-LAST:event_buttomCapNhatMouseClicked

    private void buttomCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttomCapNhatActionPerformed

    }//GEN-LAST:event_buttomCapNhatActionPerformed

    private void tbHoSoDatMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbHoSoDatMouseReleased

    }//GEN-LAST:event_tbHoSoDatMouseReleased

    private void tbHoSoDatKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbHoSoDatKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tbHoSoDatKeyReleased

    private void btFindMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btFindMouseClicked
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btFindMouseClicked

    private void btSXtheoDCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSXtheoDCActionPerformed
        String makh = txtMaKH.getText();
        clickCount++;
        if (clickCount % 2 == 0) {
            Collections.sort(HoSoDat, (a, b) -> a.getDiaChiDat().compareTo(b.getDiaChiDat()));
        } else {
            Collections.sort(HoSoDat, (a, b) -> b.getDiaChiDat().compareTo(a.getDiaChiDat()));
        }
        LoadDataArrayListToTable(makh);
    }//GEN-LAST:event_btSXtheoDCActionPerformed

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
            java.util.logging.Logger.getLogger(ScreenKH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ScreenKH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ScreenKH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ScreenKH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ScreenKH().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdd;
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btFind;
    private javax.swing.JRadioButton btNam;
    private javax.swing.JRadioButton btNu;
    private javax.swing.JButton btSXtheoDC;
    private javax.swing.JButton btSxtheoHS;
    private javax.swing.JButton btUpdate;
    private javax.swing.JButton btUpdateHS;
    private javax.swing.JMenuItem buttomCapNhat;
    private javax.swing.JMenuItem buttomXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbHoSoDat;
    private javax.swing.JTextField txtCCCD;
    private javax.swing.JTextField txtDanToc;
    private javax.swing.JTextField txtDiaChiTT;
    private javax.swing.JTextField txtFind;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtTenKH;
    // End of variables declaration//GEN-END:variables
}
