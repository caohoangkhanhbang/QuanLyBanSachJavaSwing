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
public class frmThemNhaXuatBan extends javax.swing.JFrame {

    ConnectionToDatabase con;
    String duongDanAnh = "";
    /**
     * Creates new form frmThemSanPham
     */
    public frmThemNhaXuatBan() throws SQLException {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(frmThemNhaXuatBan.DISPOSE_ON_CLOSE);
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
        txt_nxb = new CHKB_DESIGN.TextField();
        btn_them = new CHKB_DESIGN.ButtonGradientRound();
        btn_huyBo = new CHKB_DESIGN.ButtonGradientRound();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Thêm thể loại");
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
        jLabel1.setText("Thêm nhà xuất bản");

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
        jLabel2.setText("Tên nhà xuất bản");

        txt_nxb.setForeground(new java.awt.Color(51, 51, 51));
        txt_nxb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_nxb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nxbActionPerformed(evt);
            }
        });

        btn_them.setText("Thêm");
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

        javax.swing.GroupLayout panelRoundGradient2Layout = new javax.swing.GroupLayout(panelRoundGradient2);
        panelRoundGradient2.setLayout(panelRoundGradient2Layout);
        panelRoundGradient2Layout.setHorizontalGroup(
            panelRoundGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundGradient2Layout.createSequentialGroup()
                .addGroup(panelRoundGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRoundGradient2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelRoundGradient1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelRoundGradient2Layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addGroup(panelRoundGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelRoundGradient2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_nxb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(panelRoundGradient2Layout.createSequentialGroup()
                                .addComponent(btn_them, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(228, 228, 228)
                                .addComponent(btn_huyBo, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 66, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelRoundGradient2Layout.setVerticalGroup(
            panelRoundGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundGradient2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelRoundGradient1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(panelRoundGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_nxb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(panelRoundGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_them, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_huyBo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
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

    private void txt_nxbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nxbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nxbActionPerformed

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
         String tenNhaXuatBan = txt_nxb.getText().trim();
        if(tenNhaXuatBan.isEmpty()) {
            ThongBao tb = new ThongBao(this);
            tb.showMessage("Thông báo!", "Vui lòng nhập đúng và đầy đủ nội dung để thêm!");
        } else {
            String sql = "insert into NhaXuatBan(TenNhaXuatBan) values(N'"+tenNhaXuatBan+"')";
            ConnectionToDatabase con = new ConnectionToDatabase();
            try {
                if (con.ThemXoaSua(sql) >= 1) {
                    ThongBao tb = new ThongBao(this);
                    tb.showMessageSetIcon("Thông báo!", "Thêm thành công!", "/CHKB_IMAGE/successful.png");
                    this.dispose();
                }
            } catch (SQLException ex) {
                Logger.getLogger(frmThemNhaXuatBan.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btn_themActionPerformed
    
    
 
    
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
            java.util.logging.Logger.getLogger(frmThemNhaXuatBan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmThemNhaXuatBan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmThemNhaXuatBan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmThemNhaXuatBan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new frmThemNhaXuatBan().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(frmThemNhaXuatBan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private CHKB_DESIGN.ButtonGradientRound btn_huyBo;
    private CHKB_DESIGN.ButtonGradientRound btn_them;
    private com.raven.datechooser.DateChooser dateChooserNS;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private CHKB_DESIGN.PanelRoundGradient panelRoundGradient1;
    private CHKB_DESIGN.PanelRoundGradient panelRoundGradient2;
    private CHKB_DESIGN.TextField txt_nxb;
    // End of variables declaration//GEN-END:variables
}