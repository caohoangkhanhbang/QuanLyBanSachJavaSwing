/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package CHKB.UI;

import CHKB.DAO.CHKB_KhuyenMaiManipulation;
import CHKB.DAO.CHKB_NhaXuatBanManipulation;
import CHKB.DAO.CHKB_SachManipulation;
import CHKB.DAO.CHKB_TheLoaiManipulation;
import CHKB.DAO.ConnectionToDatabase;
import CHKB.MODAL.KhuyenMai;
import CHKB.MODAL.NhaXuatBan;
import CHKB.MODAL.TheLoai;
import CHKB_DESIGN.MessageDialog;
import CHKB_DESIGN.ThongBao;
import java.awt.Color;
import java.awt.Image;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author caoho
 */
public class frmThemThanhVien extends javax.swing.JFrame {

    ConnectionToDatabase con;
    String duongDanAnh = "";
    /**
     * Creates new form frmThemSanPham
     */
    public frmThemThanhVien() throws SQLException {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(frmThemThanhVien.DISPOSE_ON_CLOSE);
        con = new ConnectionToDatabase();
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateChooserNS = new com.raven.datechooser.DateChooser();
        panelRoundGradient2 = new CHKB_DESIGN.PanelRoundGradient();
        panelRoundGradient1 = new CHKB_DESIGN.PanelRoundGradient();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_hoTen = new CHKB_DESIGN.TextField();
        txt_soDienThoai = new CHKB_DESIGN.TextField();
        txt_ngaySinh = new CHKB_DESIGN.TextField();
        btn_them = new CHKB_DESIGN.ButtonGradientRound();
        btn_huyBo = new CHKB_DESIGN.ButtonGradientRound();
        cbb_gioiTinh = new CHKB_DESIGN.ComboBoxSuggestion();
        txt_email = new CHKB_DESIGN.TextField();
        jLabel6 = new javax.swing.JLabel();
        txt_diaChi = new CHKB_DESIGN.TextField();
        jLabel9 = new javax.swing.JLabel();

        dateChooserNS.setDateFormat("dd/MM/yyyy");
        dateChooserNS.setTextRefernce(txt_ngaySinh);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Thêm thành viên");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        setType(java.awt.Window.Type.POPUP);

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
        jLabel1.setText("Thêm thành viên");

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
        jLabel2.setText("Họ và tên");

        jLabel3.setText("Số điện thoại");

        jLabel5.setText("Ngày sinh");

        jLabel8.setText("Giới tính");

        txt_hoTen.setForeground(new java.awt.Color(51, 51, 51));
        txt_hoTen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_hoTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_hoTenActionPerformed(evt);
            }
        });

        txt_soDienThoai.setForeground(new java.awt.Color(51, 51, 51));
        txt_soDienThoai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_soDienThoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_soDienThoaiActionPerformed(evt);
            }
        });

        txt_ngaySinh.setForeground(new java.awt.Color(51, 51, 51));
        txt_ngaySinh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_ngaySinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ngaySinhActionPerformed(evt);
            }
        });

        btn_them.setText("Tạo thành viên");
        btn_them.setColor1(new java.awt.Color(51, 255, 255));
        btn_them.setColor2(new java.awt.Color(0, 255, 153));
        btn_them.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        btn_them.setMauDiemCham(new java.awt.Color(255, 255, 255));
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });

        btn_huyBo.setText("Hủy bỏ");
        btn_huyBo.setColor1(new java.awt.Color(255, 0, 153));
        btn_huyBo.setColor2(new java.awt.Color(204, 0, 51));
        btn_huyBo.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        btn_huyBo.setMauDiemCham(new java.awt.Color(255, 255, 255));
        btn_huyBo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_huyBoActionPerformed(evt);
            }
        });

        cbb_gioiTinh.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nam", "Nữ", " " }));
        cbb_gioiTinh.setToolTipText("");
        cbb_gioiTinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbb_gioiTinhActionPerformed(evt);
            }
        });

        txt_email.setForeground(new java.awt.Color(51, 51, 51));
        txt_email.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_emailActionPerformed(evt);
            }
        });

        jLabel6.setText("Email");

        txt_diaChi.setForeground(new java.awt.Color(51, 51, 51));
        txt_diaChi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_diaChi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_diaChiActionPerformed(evt);
            }
        });

        jLabel9.setText("Địa chỉ");

        javax.swing.GroupLayout panelRoundGradient2Layout = new javax.swing.GroupLayout(panelRoundGradient2);
        panelRoundGradient2.setLayout(panelRoundGradient2Layout);
        panelRoundGradient2Layout.setHorizontalGroup(
            panelRoundGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundGradient2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRoundGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRoundGradient1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelRoundGradient2Layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addGroup(panelRoundGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel9))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRoundGradient2Layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(panelRoundGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_email, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbb_gioiTinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_soDienThoai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_hoTen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_ngaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_diaChi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(101, 101, 101))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRoundGradient2Layout.createSequentialGroup()
                .addContainerGap(252, Short.MAX_VALUE)
                .addComponent(btn_them, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82)
                .addComponent(btn_huyBo, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(184, 184, 184))
        );
        panelRoundGradient2Layout.setVerticalGroup(
            panelRoundGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundGradient2Layout.createSequentialGroup()
                .addGroup(panelRoundGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRoundGradient2Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addGroup(panelRoundGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_hoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelRoundGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_soDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelRoundGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_ngaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelRoundGradient2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelRoundGradient1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRoundGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbb_gioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRoundGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRoundGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_diaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(panelRoundGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_them, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_huyBo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRoundGradient2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRoundGradient2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_hoTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_hoTenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_hoTenActionPerformed

    private void txt_soDienThoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_soDienThoaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_soDienThoaiActionPerformed

    private void txt_ngaySinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ngaySinhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ngaySinhActionPerformed

    private void btn_huyBoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_huyBoActionPerformed
        MessageDialog luaChon = new MessageDialog(this);
        luaChon.showMessage("Thông báo", "Bạn có chắc chắn muốn hủy!");
        if(luaChon.getMessageType()== MessageDialog.MessageType.OK)
        {
//            frmLogin f = new frmLogin();
            this.dispose();
//            f.setVisible(true);
        }
    }//GEN-LAST:event_btn_huyBoActionPerformed

    
    
    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        if(kiemTraRong() == false) {
            ThongBao tb = new ThongBao(this);
            tb.showMessage("Thông báo!", "Vui lòng nhập đúng và đầy đủ nội dung để thêm!");
        } else {
            String hoTen = txt_hoTen.getText().trim();
            String sdt = txt_soDienThoai.getText().trim();
            String ngaySinh = txt_ngaySinh.getText().trim();
            String gioiTinh = (String) cbb_gioiTinh.getSelectedItem();
            String email = txt_email.getText().trim();
            String diaChi = txt_diaChi.getText().trim();

            String sql = "set dateformat dmy insert into ThanhVien (HoTen, SoDienThoai, NgaySinh, GioiTinh, Email, DiaChi, Diem, GiamGia) values(N'" + hoTen + "','" + sdt + "','" + ngaySinh + "', N'" + gioiTinh + "', N'" + email + "', N'" + diaChi + "', 0, '0')";
            ConnectionToDatabase con = new ConnectionToDatabase();
            try {
                if (con.ThemXoaSua(sql) >= 1) {
                    ThongBao tb = new ThongBao(this);
                    tb.showMessageSetIcon("Thông báo!", "Thêm thành công!", "/CHKB_IMAGE/successful.png");
                    this.dispose();
                }
            } catch (SQLException ex) {
                Logger.getLogger(frmThemThanhVien.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btn_themActionPerformed

    private void cbb_gioiTinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbb_gioiTinhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbb_gioiTinhActionPerformed

    private void txt_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_emailActionPerformed

    private void txt_diaChiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_diaChiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_diaChiActionPerformed
    
    
    public boolean kiemTraRong()
    {
        String hoTen = txt_hoTen.getText().trim();
        String sdt = txt_soDienThoai.getText().trim();
        String ngaySinh = txt_ngaySinh.getText().trim();
        String gioiTinh = (String) cbb_gioiTinh.getSelectedItem();
        String email = txt_email.getText().trim();
        String diaChi = txt_diaChi.getText().trim();
        
        boolean kq = true;
        if(hoTen.length()<1 || sdt.length() < 1 || ngaySinh.length()<1 || email.length() < 1 || diaChi.length()<1)
        {
            kq = false;
        }
        if (con.kiemTraSo(sdt) == false) {
            ThongBao tb = new ThongBao(this);
            tb.showMessage("Thông báo!", "Số điện thoại không hợp lệ vui lòng nhập lại");
            kq = false;
        }
          if (con.ktEmail(email) == false) {
            ThongBao tb = new ThongBao(this);
            tb.showMessage("Thông báo!", "Email không hợp lệ vui lòng nhập lại");
            kq = false;
        }
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//        LocalDate localDate = LocalDate.parse(txt_ngaySinh.getText(), formatter);
////        LocalDate localDate2 = LocalDate.parse(txt_ngayKT.getText(), formatter);
//        long daysBetween = ChronoUnit.DAYS.between(localDate2, localDate);
        
//        if(daysBetween<0)
//        {
//            ThongBao tb = new ThongBao(this);
//            tb.showMessage("Thông báo!", "Thời gian khuyến mãi không hợp lệ!\nVui lòng xem lại ngày bắt đầu và kết thúc phải lớn hơn hoặc bằng 1 ngày!!!");
//            kq = false;
//        }
        return kq;
    }
    
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
            java.util.logging.Logger.getLogger(frmThemThanhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmThemThanhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmThemThanhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmThemThanhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new frmThemThanhVien().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(frmThemThanhVien.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private CHKB_DESIGN.ButtonGradientRound btn_huyBo;
    private CHKB_DESIGN.ButtonGradientRound btn_them;
    private CHKB_DESIGN.ComboBoxSuggestion cbb_gioiTinh;
    private com.raven.datechooser.DateChooser dateChooserNS;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private CHKB_DESIGN.PanelRoundGradient panelRoundGradient1;
    private CHKB_DESIGN.PanelRoundGradient panelRoundGradient2;
    private CHKB_DESIGN.TextField txt_diaChi;
    private CHKB_DESIGN.TextField txt_email;
    private CHKB_DESIGN.TextField txt_hoTen;
    private CHKB_DESIGN.TextField txt_ngaySinh;
    private CHKB_DESIGN.TextField txt_soDienThoai;
    // End of variables declaration//GEN-END:variables
}