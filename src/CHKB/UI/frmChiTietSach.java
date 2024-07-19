/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package CHKB.UI;

import CHKB.MODAL.TheLoai;
import CHKB_DESIGN.MessageDialog;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author caoho
 */
public class frmChiTietSach extends javax.swing.JFrame {

    /**
     * Creates new form frmChiTietSach
     */
    public frmChiTietSach(String TenSach, String GiaBan, String SoLuong, String Tap, String Hinh, String ViTri, String TrangThai, String TacGia, String MaKhuyenMai, String MaTheLoai, String MaNhaXuatBan) {
        initComponents();
        txt_tenSach.setText(TenSach);
        hinhSP.setIcon(new ImageIcon(new ImageIcon(Hinh).getImage().getScaledInstance(hinhSP.getWidth(), hinhSP.getHeight(), Image.SCALE_SMOOTH)));
        txt_giaBan.setText(GiaBan);
        txt_soLuong.setText(SoLuong);
        txt_tap.setText(Tap);
        if(TrangThai.equalsIgnoreCase("Có bán"))
        {
            ckb_hienThi.setSelected(true);
        }
        txt_tacGia.setText(TacGia);
        txt_viTri.setText(ViTri);
        lbl_tl.setText(MaTheLoai);
        lbl_km.setText(MaKhuyenMai);
        lbl_nxb.setText(MaNhaXuatBan);
        this.setDefaultCloseOperation(frmChiTietSach.DISPOSE_ON_CLOSE);
    }

    private frmChiTietSach() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRoundGradient2 = new CHKB_DESIGN.PanelRoundGradient();
        panelRoundGradient1 = new CHKB_DESIGN.PanelRoundGradient();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        hinhSP = new javax.swing.JLabel();
        txt_tenSach = new CHKB_DESIGN.TextField();
        txt_giaBan = new CHKB_DESIGN.TextField();
        txt_soLuong = new CHKB_DESIGN.TextField();
        txt_tap = new CHKB_DESIGN.TextField();
        ckb_hienThi = new CHKB_DESIGN.JCheckBoxCustom();
        txt_tacGia = new CHKB_DESIGN.TextField();
        txt_viTri = new CHKB_DESIGN.TextField();
        lbl_tl = new javax.swing.JLabel();
        lbl_nxb = new javax.swing.JLabel();
        lbl_km = new javax.swing.JLabel();
        btn_huyBo = new CHKB_DESIGN.ButtonGradientRound();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Thông tin chi tiết sản phẩm");

        panelRoundGradient2.setColorEnd(new java.awt.Color(254, 254, 254));
        panelRoundGradient2.setColorStart(new java.awt.Color(254, 254, 254));
        panelRoundGradient2.setRoundBottomLeft(0);
        panelRoundGradient2.setRoundBottomRight(0);
        panelRoundGradient2.setRoundTopLeft(0);
        panelRoundGradient2.setRoundTopRight(0);

        panelRoundGradient1.setColorEnd(new java.awt.Color(153, 0, 204));
        panelRoundGradient1.setColorStart(new java.awt.Color(51, 255, 255));
        panelRoundGradient1.setRoundBottomLeft(10);
        panelRoundGradient1.setRoundBottomRight(10);
        panelRoundGradient1.setRoundTopLeft(10);
        panelRoundGradient1.setRoundTopRight(10);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Thông tin chi tiết sản phẩm");

        javax.swing.GroupLayout panelRoundGradient1Layout = new javax.swing.GroupLayout(panelRoundGradient1);
        panelRoundGradient1.setLayout(panelRoundGradient1Layout);
        panelRoundGradient1Layout.setHorizontalGroup(
            panelRoundGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundGradient1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelRoundGradient1Layout.setVerticalGroup(
            panelRoundGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundGradient1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Tên sách");

        jLabel3.setText("Giá bán");

        jLabel4.setText("Số lượng");

        jLabel5.setText("Tập");

        jLabel6.setText("Vị trí");

        jLabel7.setText("Trạng thái");

        jLabel8.setText("Tác giả");

        jLabel9.setText("Khuyến mãi");

        jLabel10.setText("Thể loại");

        jLabel11.setText("Nhà xuất bản");

        hinhSP.setBackground(new java.awt.Color(255, 255, 255));
        hinhSP.setIcon(new javax.swing.ImageIcon("D:\\mahaCode\\CongNgheJava\\QuanLyBanSach_DoAnJava_CHKB\\QuanLyBanSach_DoAnJava_CHKB\\src\\CHKB_IMAGE\\kinhTruongBo.jpg")); // NOI18N
        hinhSP.setToolTipText("");

        txt_tenSach.setEditable(false);
        txt_tenSach.setForeground(new java.awt.Color(51, 51, 51));
        txt_tenSach.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_tenSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tenSachActionPerformed(evt);
            }
        });

        txt_giaBan.setEditable(false);
        txt_giaBan.setForeground(new java.awt.Color(51, 51, 51));
        txt_giaBan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_giaBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_giaBanActionPerformed(evt);
            }
        });

        txt_soLuong.setEditable(false);
        txt_soLuong.setForeground(new java.awt.Color(51, 51, 51));
        txt_soLuong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_soLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_soLuongActionPerformed(evt);
            }
        });

        txt_tap.setEditable(false);
        txt_tap.setForeground(new java.awt.Color(51, 51, 51));
        txt_tap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_tap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tapActionPerformed(evt);
            }
        });

        ckb_hienThi.setText("Còn bán");
        ckb_hienThi.setEnabled(false);
        ckb_hienThi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckb_hienThiActionPerformed(evt);
            }
        });

        txt_tacGia.setEditable(false);
        txt_tacGia.setForeground(new java.awt.Color(51, 51, 51));
        txt_tacGia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_tacGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tacGiaActionPerformed(evt);
            }
        });

        txt_viTri.setEditable(false);
        txt_viTri.setForeground(new java.awt.Color(51, 51, 51));
        txt_viTri.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_viTri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_viTriActionPerformed(evt);
            }
        });

        lbl_tl.setText("Thể loại");

        lbl_nxb.setText("Nhà xuất bản");

        lbl_km.setText("Không");

        btn_huyBo.setText("Đóng form");
        btn_huyBo.setColor1(new java.awt.Color(255, 0, 153));
        btn_huyBo.setColor2(new java.awt.Color(204, 0, 51));
        btn_huyBo.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        btn_huyBo.setMauDiemCham(new java.awt.Color(255, 255, 255));
        btn_huyBo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_huyBoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRoundGradient2Layout = new javax.swing.GroupLayout(panelRoundGradient2);
        panelRoundGradient2.setLayout(panelRoundGradient2Layout);
        panelRoundGradient2Layout.setHorizontalGroup(
            panelRoundGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundGradient2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRoundGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRoundGradient1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelRoundGradient2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(hinhSP, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(panelRoundGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRoundGradient2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(panelRoundGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelRoundGradient2Layout.createSequentialGroup()
                                        .addGroup(panelRoundGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(panelRoundGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel11))
                                        .addGap(10, 10, 10)
                                        .addGroup(panelRoundGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txt_tenSach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRoundGradient2Layout.createSequentialGroup()
                                                .addGroup(panelRoundGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(txt_tap, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                                    .addComponent(txt_giaBan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(panelRoundGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(panelRoundGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(ckb_hienThi, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txt_soLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addComponent(txt_tacGia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txt_viTri, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(panelRoundGradient2Layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addGroup(panelRoundGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lbl_nxb, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(lbl_tl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                                    .addGroup(panelRoundGradient2Layout.createSequentialGroup()
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(11, 11, 11)
                                        .addComponent(lbl_km, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRoundGradient2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_huyBo, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(226, 226, 226)))))
                .addContainerGap())
        );
        panelRoundGradient2Layout.setVerticalGroup(
            panelRoundGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundGradient2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelRoundGradient1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelRoundGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelRoundGradient2Layout.createSequentialGroup()
                        .addGroup(panelRoundGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_tenSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(panelRoundGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_giaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_soLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(panelRoundGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelRoundGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txt_tap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ckb_hienThi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(10, 10, 10)
                        .addGroup(panelRoundGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_tacGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(panelRoundGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_viTri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(panelRoundGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_tl, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelRoundGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_nxb, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelRoundGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_km, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_huyBo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRoundGradient2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(hinhSP, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRoundGradient2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRoundGradient2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_tenSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tenSachActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tenSachActionPerformed

    private void txt_giaBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_giaBanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_giaBanActionPerformed

    private void txt_soLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_soLuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_soLuongActionPerformed

    private void txt_tapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tapActionPerformed

    private void ckb_hienThiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckb_hienThiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ckb_hienThiActionPerformed

    private void txt_tacGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tacGiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tacGiaActionPerformed

    private void txt_viTriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_viTriActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_viTriActionPerformed

    private void btn_huyBoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_huyBoActionPerformed
        MessageDialog luaChon = new MessageDialog(this);
        luaChon.showMessage("Thông báo", "Bạn có chắc chắn muốn đóng form!");
        if(luaChon.getMessageType()== MessageDialog.MessageType.OK)
        {
            this.dispose();
        }
    }//GEN-LAST:event_btn_huyBoActionPerformed

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
            java.util.logging.Logger.getLogger(frmChiTietSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmChiTietSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmChiTietSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmChiTietSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmChiTietSach().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private CHKB_DESIGN.ButtonGradientRound btn_huyBo;
    private CHKB_DESIGN.JCheckBoxCustom ckb_hienThi;
    private javax.swing.JLabel hinhSP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lbl_km;
    private javax.swing.JLabel lbl_nxb;
    private javax.swing.JLabel lbl_tl;
    private CHKB_DESIGN.PanelRoundGradient panelRoundGradient1;
    private CHKB_DESIGN.PanelRoundGradient panelRoundGradient2;
    private CHKB_DESIGN.TextField txt_giaBan;
    private CHKB_DESIGN.TextField txt_soLuong;
    private CHKB_DESIGN.TextField txt_tacGia;
    private CHKB_DESIGN.TextField txt_tap;
    private CHKB_DESIGN.TextField txt_tenSach;
    private CHKB_DESIGN.TextField txt_viTri;
    // End of variables declaration//GEN-END:variables
}
