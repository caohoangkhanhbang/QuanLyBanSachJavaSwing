
package CHKB.UI;

import CHKB_DESIGN.MessageDialog;
//import CHKB_DESIGN.MessageDialogOneOption;
import CHKB_DESIGN.ThongBao;
import CHKB_DESIGN.TableCustom;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author caoho
 */
public class NewJFrame1 extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame1
     */
    public NewJFrame1() {
        initComponents();
        TableCustom.apply(jScrollPane1, TableCustom.TableType.DEFAULT);
        testData(jTable1);;
    }
    
    private void testData(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.addRow(new Object[]{1, "Chai", "Beverages", 18, true});
        model.addRow(new Object[]{2, "Chang", "Beverages", 19, false});
        model.addRow(new Object[]{3, "Aniseed Syrup", "Beverages", 18, 39});
        model.addRow(new Object[]{4, "Chef Anton's Cajun Seasoning", "Beverages", 19, 39});
        model.addRow(new Object[]{5, "Chef Anton's Gumbo Mix", "Beverages", 18, 39});
        model.addRow(new Object[]{6, "Grandma's Boysenberry Spread", "Beverages", 19, 39});
        model.addRow(new Object[]{7, "Uncle Bob's Organic Dried Pears", "Beverages", 18, 39});
        model.addRow(new Object[]{8, "Northwoods Cranberry Sauce", "Beverages", 19, 39});
        model.addRow(new Object[]{9, "Mishi Kobe Niku", "Beverages", 18, 39});
        model.addRow(new Object[]{10, "Ikura", "Beverages", 19, 39});
        model.addRow(new Object[]{11, "Queso Cabrales", "Beverages", 18, 39});
        model.addRow(new Object[]{12, "Queso Manchego La Pastora", "Beverages", 19, 39});
        model.addRow(new Object[]{13, "Konbu", "Beverages", 18, 39});
        model.addRow(new Object[]{14, "Tofu", "Seafood", 19, 39});
        model.addRow(new Object[]{15, "Genen Shouyu", "Seafood", 18, 39});
        model.addRow(new Object[]{16, "Pavlova", "Seafood", 19, 39});
        model.addRow(new Object[]{17, "Alice Mutton", "Seafood", 18, 39});
        model.addRow(new Object[]{18, "Carnarvon Tigers", "Seafood", 19, 39});
        model.addRow(new Object[]{19, "Teatime Chocolate Biscuits", "Seafood", 19, 39});
        model.addRow(new Object[]{20, "Sir Rodney's Marmalade", "Seafood", 19, 39});
        model.addRow(new Object[]{21, "Sir Rodney's Scones", "Seafood", 19, 39});
        model.addRow(new Object[]{22, "Gustaf's Knäckebröd", "Seafood", 19, 39});
        model.addRow(new Object[]{23, "Tunnbröd", "Seafood", 19, 39});
        model.addRow(new Object[]{24, "Guaraná Fantástica", "Seafood", 19, 39});
        model.addRow(new Object[]{25, "NuNuCa Nuß-Nougat-Creme", "Seafood", 19, 39});
        model.addRow(new Object[]{26, "Gumbär Gummibärchen", "Seafood", 19, 39});
        model.addRow(new Object[]{27, "Schoggi Schokolade", "Seafood", 19, 39});
        model.addRow(new Object[]{28, "Rössle Sauerkraut", "Seafood", 19, 39});
        model.addRow(new Object[]{29, "Thüringer Rostbratwurst", "Seafood", 19, 39});
        model.addRow(new Object[]{30, "Nord-Ost Matjeshering", "Seafood", 19, 39});
        model.addRow(new Object[]{31, "Gorgonzola Telino", "Seafood", 19, 39});
        model.addRow(new Object[]{32, "Mascarpone Fabioli", "Seafood", 19, 39});
        model.addRow(new Object[]{33, "Geitost", "Seafood", 19, 39});
        model.addRow(new Object[]{34, "Sasquatch Ale", "Seafood", 19, 39});
        model.addRow(new Object[]{35, "Steeleye Stout", "Seafood", 19, 39});
        model.addRow(new Object[]{36, "Inlagd Sill", "Seafood", 19, 39});
        model.addRow(new Object[]{37, "Gravad lax", "Seafood", 19, 39});
        model.addRow(new Object[]{38, "Côte de Blaye", "Seafood", 19, 39});
        model.addRow(new Object[]{39, "Chartreuse verte", "Seafood", 19, 39});
        model.addRow(new Object[]{40, "Boston Crab Meat", "Seafood", 19, 39});
        model.addRow(new Object[]{41, "Jack's New England Clam Chowder", "Seafood", 19, 39});
        model.addRow(new Object[]{42, "Singaporean Hokkien Fried Mee", "Seafood", 19, 39});
        model.addRow(new Object[]{43, "Ipoh Coffee", "Seafood", 19, 39});
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tableCustom1 = new CHKB_DESIGN.TableCustom();
        tableCustom2 = new CHKB_DESIGN.TableCustom();
        tableCustom3 = new CHKB_DESIGN.TableCustom();
        tableCustom4 = new CHKB_DESIGN.TableCustom();
        jButton1 = new javax.swing.JButton();
        roundPanelBorderBottom1 = new CHKB_DESIGN.RoundPanelBorderBottom();
        thongbao = new CHKB_DESIGN.ButtonGradientRound();
        roundPanelBorderBottom2 = new CHKB_DESIGN.RoundPanelBorderBottom();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        card1 = new CHKB_DESIGN.Card();
        panelRoundGradient11 = new CHKB_DESIGN.PanelRoundGradient();
        panelRoundGradient12 = new CHKB_DESIGN.PanelRoundGradient();
        lblHienthi5 = new javax.swing.JLabel();
        txt_userName4 = new javax.swing.JLabel();
        materialTabbed1 = new CHKB_DESIGN.MaterialTabbed();
        panelRoundGradient1 = new CHKB_DESIGN.PanelRoundGradient();
        panelRoundGradient2 = new CHKB_DESIGN.PanelRoundGradient();
        panelRoundGradient3 = new CHKB_DESIGN.PanelRoundGradient();
        panelRoundGradient4 = new CHKB_DESIGN.PanelRoundGradient();
        panelRoundGradient5 = new CHKB_DESIGN.PanelRoundGradient();
        jButton2 = new javax.swing.JButton();
        buttonGradientRound1 = new CHKB_DESIGN.ButtonGradientRound();
        buttonGradientRound2 = new CHKB_DESIGN.ButtonGradientRound();
        combobox1 = new CHKB_DESIGN.Combobox();
        comboBoxSuggestion2 = new CHKB_DESIGN.ComboBoxSuggestion();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPanetl = new javax.swing.JScrollPane();
        tbl_infotl = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Show Message");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        roundPanelBorderBottom1.setBackground(new java.awt.Color(255, 255, 255));
        roundPanelBorderBottom1.setRound(40);

        javax.swing.GroupLayout roundPanelBorderBottom1Layout = new javax.swing.GroupLayout(roundPanelBorderBottom1);
        roundPanelBorderBottom1.setLayout(roundPanelBorderBottom1Layout);
        roundPanelBorderBottom1Layout.setHorizontalGroup(
            roundPanelBorderBottom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 205, Short.MAX_VALUE)
        );
        roundPanelBorderBottom1Layout.setVerticalGroup(
            roundPanelBorderBottom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 105, Short.MAX_VALUE)
        );

        thongbao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CHKB_IMAGE/remove.png"))); // NOI18N
        thongbao.setText("Hiện thông báo");
        thongbao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thongbaoActionPerformed(evt);
            }
        });

        roundPanelBorderBottom2.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

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

        javax.swing.GroupLayout roundPanelBorderBottom2Layout = new javax.swing.GroupLayout(roundPanelBorderBottom2);
        roundPanelBorderBottom2.setLayout(roundPanelBorderBottom2Layout);
        roundPanelBorderBottom2Layout.setHorizontalGroup(
            roundPanelBorderBottom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE)
        );
        roundPanelBorderBottom2Layout.setVerticalGroup(
            roundPanelBorderBottom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanelBorderBottom2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 53, Short.MAX_VALUE))
        );

        panelRoundGradient12.setColorEnd(new java.awt.Color(0, 102, 102));
        panelRoundGradient12.setColorStart(new java.awt.Color(102, 0, 102));

        lblHienthi5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblHienthi5.setForeground(new java.awt.Color(255, 255, 255));
        lblHienthi5.setFocusable(false);
        lblHienthi5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblHienthi5.setIconTextGap(10);

        txt_userName4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_userName4.setForeground(new java.awt.Color(255, 255, 255));
        txt_userName4.setText("Sys as sysdba");
        txt_userName4.setFocusable(false);
        txt_userName4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        txt_userName4.setIconTextGap(10);

        javax.swing.GroupLayout panelRoundGradient12Layout = new javax.swing.GroupLayout(panelRoundGradient12);
        panelRoundGradient12.setLayout(panelRoundGradient12Layout);
        panelRoundGradient12Layout.setHorizontalGroup(
            panelRoundGradient12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundGradient12Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(lblHienthi5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelRoundGradient12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_userName4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelRoundGradient12Layout.setVerticalGroup(
            panelRoundGradient12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundGradient12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHienthi5, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_userName4, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );

        materialTabbed1.setForeground(new java.awt.Color(255, 255, 255));
        materialTabbed1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        javax.swing.GroupLayout panelRoundGradient1Layout = new javax.swing.GroupLayout(panelRoundGradient1);
        panelRoundGradient1.setLayout(panelRoundGradient1Layout);
        panelRoundGradient1Layout.setHorizontalGroup(
            panelRoundGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 437, Short.MAX_VALUE)
        );
        panelRoundGradient1Layout.setVerticalGroup(
            panelRoundGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 106, Short.MAX_VALUE)
        );

        materialTabbed1.addTab("tab1", panelRoundGradient1);

        javax.swing.GroupLayout panelRoundGradient2Layout = new javax.swing.GroupLayout(panelRoundGradient2);
        panelRoundGradient2.setLayout(panelRoundGradient2Layout);
        panelRoundGradient2Layout.setHorizontalGroup(
            panelRoundGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 437, Short.MAX_VALUE)
        );
        panelRoundGradient2Layout.setVerticalGroup(
            panelRoundGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 106, Short.MAX_VALUE)
        );

        materialTabbed1.addTab("tab2", panelRoundGradient2);

        javax.swing.GroupLayout panelRoundGradient3Layout = new javax.swing.GroupLayout(panelRoundGradient3);
        panelRoundGradient3.setLayout(panelRoundGradient3Layout);
        panelRoundGradient3Layout.setHorizontalGroup(
            panelRoundGradient3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 437, Short.MAX_VALUE)
        );
        panelRoundGradient3Layout.setVerticalGroup(
            panelRoundGradient3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 106, Short.MAX_VALUE)
        );

        materialTabbed1.addTab("tab3", panelRoundGradient3);

        javax.swing.GroupLayout panelRoundGradient4Layout = new javax.swing.GroupLayout(panelRoundGradient4);
        panelRoundGradient4.setLayout(panelRoundGradient4Layout);
        panelRoundGradient4Layout.setHorizontalGroup(
            panelRoundGradient4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 437, Short.MAX_VALUE)
        );
        panelRoundGradient4Layout.setVerticalGroup(
            panelRoundGradient4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 106, Short.MAX_VALUE)
        );

        materialTabbed1.addTab("tab4", panelRoundGradient4);

        javax.swing.GroupLayout panelRoundGradient5Layout = new javax.swing.GroupLayout(panelRoundGradient5);
        panelRoundGradient5.setLayout(panelRoundGradient5Layout);
        panelRoundGradient5Layout.setHorizontalGroup(
            panelRoundGradient5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 437, Short.MAX_VALUE)
        );
        panelRoundGradient5Layout.setVerticalGroup(
            panelRoundGradient5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 106, Short.MAX_VALUE)
        );

        materialTabbed1.addTab("tab5", panelRoundGradient5);

        javax.swing.GroupLayout panelRoundGradient11Layout = new javax.swing.GroupLayout(panelRoundGradient11);
        panelRoundGradient11.setLayout(panelRoundGradient11Layout);
        panelRoundGradient11Layout.setHorizontalGroup(
            panelRoundGradient11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundGradient11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelRoundGradient12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(panelRoundGradient11Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(materialTabbed1, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );
        panelRoundGradient11Layout.setVerticalGroup(
            panelRoundGradient11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundGradient11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelRoundGradient12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(materialTabbed1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        jButton2.setText("jButton2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        buttonGradientRound1.setText("buttonGradientRound1");

        buttonGradientRound2.setText("buttonGradientRound2");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jScrollPanetl.setBackground(new java.awt.Color(255, 255, 255));

        tbl_infotl.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_infotl.setPreferredSize(new java.awt.Dimension(30, 80));
        jScrollPanetl.setViewportView(tbl_infotl);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(roundPanelBorderBottom2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(thongbao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(33, 33, 33)
                                        .addComponent(buttonGradientRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 284, Short.MAX_VALUE)
                                        .addComponent(buttonGradientRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(card1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(roundPanelBorderBottom1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(302, 302, 302)
                        .addComponent(jButton2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRoundGradient11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addComponent(combobox1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(comboBoxSuggestion2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(148, 148, 148)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPanetl, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(248, 248, 248))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPanetl, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(136, 136, 136)
                            .addComponent(comboBoxSuggestion2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(117, 117, 117)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(combobox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(177, 177, 177)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRoundGradient11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(card1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(roundPanelBorderBottom1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(roundPanelBorderBottom2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(27, 27, 27)
                                    .addComponent(thongbao, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(buttonGradientRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(3, 3, 3)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton1)
                                .addComponent(buttonGradientRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(4, 4, 4)
                            .addComponent(jButton2)
                            .addGap(117, 117, 117)))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        MessageDialog obj = new MessageDialog(this);
        obj.showMessage("Delete your account ?", "All data will lose if you press ok button\nYou can restore any time within 30 days start from now.");
        if (obj.getMessageType() == MessageDialog.MessageType.OK) {
            System.out.println("User click ok");
        } else {
            System.out.println("User click cancel");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void thongbaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thongbaoActionPerformed

        ThongBao thongBao = new ThongBao(this);
        thongBao.showMessage("Thông báo", "Namo tassa bhagavato arahato samma sambuddhasa. Đảnh lễ Thế tôn ngài là bậc"
                + "Ứng cúng, Chánh biến tri, Minh hạnh túc, Thiện thệ, Thế gian giải, Vô thượng sĩ, Điều ngự trượng phu"
                + ", Thiên nhân sư, Phật, Thế tôn.");
        if (thongBao.getMessageType() == ThongBao.MessageType.OK) {
            System.out.println("User click ok");
        }
        
    }//GEN-LAST:event_thongbaoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ThongBao f = new ThongBao(this);
        f.showMessage("Thông báo", "Lỗi thì bỏ đi!");
        
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(NewJFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private CHKB_DESIGN.ButtonGradientRound buttonGradientRound1;
    private CHKB_DESIGN.ButtonGradientRound buttonGradientRound2;
    private CHKB_DESIGN.Card card1;
    private CHKB_DESIGN.ComboBoxSuggestion comboBoxSuggestion2;
    private CHKB_DESIGN.Combobox combobox1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPanetl;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblHienthi5;
    private CHKB_DESIGN.MaterialTabbed materialTabbed1;
    private CHKB_DESIGN.PanelRoundGradient panelRoundGradient1;
    private CHKB_DESIGN.PanelRoundGradient panelRoundGradient11;
    private CHKB_DESIGN.PanelRoundGradient panelRoundGradient12;
    private CHKB_DESIGN.PanelRoundGradient panelRoundGradient2;
    private CHKB_DESIGN.PanelRoundGradient panelRoundGradient3;
    private CHKB_DESIGN.PanelRoundGradient panelRoundGradient4;
    private CHKB_DESIGN.PanelRoundGradient panelRoundGradient5;
    private CHKB_DESIGN.RoundPanelBorderBottom roundPanelBorderBottom1;
    private CHKB_DESIGN.RoundPanelBorderBottom roundPanelBorderBottom2;
    private CHKB_DESIGN.TableCustom tableCustom1;
    private CHKB_DESIGN.TableCustom tableCustom2;
    private CHKB_DESIGN.TableCustom tableCustom3;
    private CHKB_DESIGN.TableCustom tableCustom4;
    private javax.swing.JTable tbl_infotl;
    private CHKB_DESIGN.ButtonGradientRound thongbao;
    private javax.swing.JLabel txt_userName4;
    // End of variables declaration//GEN-END:variables
}