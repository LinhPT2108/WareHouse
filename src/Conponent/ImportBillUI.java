package Conponent;

import CustomSwing.ScrollBarCustom;
import DAO.BaseDAO;
import DAO.EmployeeDAO;
import DAO.ImportBillDAO;
import Entities.ExportBill;
import Entities.ImportBill;
import Helper.XDateHelper;
import Helper.XDialogHelper;
import Model.Colors;
import Utils.Auth;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pc
 */
@SuppressWarnings("serial")
public class ImportBillUI extends javax.swing.JPanel {

    private Color bgColorA = Colors.homeColor(Colors.LEFT);
    private Color bgColorB = Colors.homeColor(Colors.RIGHT);
    private JFrame frame;

    private ImportBillDAO iBillDAO = new ImportBillDAO();
    private EmployeeDAO elDAO = new EmployeeDAO();

    private String importID;
    
    private boolean checkPayed = false;
    private boolean checkPaying = false;
    private boolean checkNoPay = false;
    private boolean checkAll = false;
    

    public ImportBillUI(JFrame f) {
        initComponents();
        init();
        this.setOpaque(false);
        this.frame = f;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        GradientPaint paint = new GradientPaint(0, 0, bgColorA, getWidth(), getHeight(), bgColorB);
        g2.setPaint(paint);
        g2.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgpStatus = new javax.swing.ButtonGroup();
        pnlHDNhap = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        pnlList = new javax.swing.JPanel();
        pnlFormSearch = new javax.swing.JPanel();
        txtFind = new CustomSwing.MyTextField();
        btnSort = new CustomSwing.MyButton();
        btnExportBill1 = new CustomSwing.MyButton();
        spImportBill = new javax.swing.JScrollPane();
        tblImportBill = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        rdoAll = new javax.swing.JRadioButton();
        rdoPayed = new javax.swing.JRadioButton();
        rdoPaying = new javax.swing.JRadioButton();
        rdoNoPay = new javax.swing.JRadioButton();

        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
        });
        setLayout(new java.awt.BorderLayout());

        pnlHDNhap.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        pnlHDNhap.setOpaque(false);
        pnlHDNhap.setLayout(new java.awt.BorderLayout());

        lblTitle.setFont(new java.awt.Font("Roboto", 1, 28)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(66, 103, 178));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("QUẢN LÝ HÓA ĐƠN NHẬP");
        lblTitle.setPreferredSize(new java.awt.Dimension(308, 60));
        pnlHDNhap.add(lblTitle, java.awt.BorderLayout.PAGE_START);

        pnlList.setOpaque(false);
        pnlList.setLayout(new java.awt.BorderLayout());

        pnlFormSearch.setBackground(new java.awt.Color(147, 196, 125));
        pnlFormSearch.setOpaque(false);

        txtFind.setHide("Nhập mã hóa đơn cần tìm...");
        txtFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFindActionPerformed(evt);
            }
        });
        txtFind.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFindKeyReleased(evt);
            }
        });

        btnSort.setBackground(new java.awt.Color(215, 249, 250));
        btnSort.setForeground(new java.awt.Color(0, 51, 51));
        btnSort.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/sort (1).png"))); // NOI18N
        btnSort.setText("Sắp xếp theo mã hóa đơn");
        btnSort.setColor(new java.awt.Color(215, 249, 250));
        btnSort.setColorEntered(new java.awt.Color(157, 234, 238));
        btnSort.setColorHover(new java.awt.Color(0, 51, 51));
        btnSort.setColorNomal(new java.awt.Color(0, 51, 51));
        btnSort.setColorPressed(new java.awt.Color(215, 249, 250));
        btnSort.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        btnSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSortActionPerformed(evt);
            }
        });

        btnExportBill1.setBackground(new java.awt.Color(215, 249, 250));
        btnExportBill1.setForeground(new java.awt.Color(0, 51, 51));
        btnExportBill1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/add-button.png"))); // NOI18N
        btnExportBill1.setText("Tạo hóa đơn");
        btnExportBill1.setColor(new java.awt.Color(215, 249, 250));
        btnExportBill1.setColorBordered(new java.awt.Color(255, 255, 255));
        btnExportBill1.setColorEntered(new java.awt.Color(157, 234, 238));
        btnExportBill1.setColorHover(new java.awt.Color(0, 51, 51));
        btnExportBill1.setColorNomal(new java.awt.Color(0, 51, 51));
        btnExportBill1.setColorPressed(new java.awt.Color(215, 249, 250));
        btnExportBill1.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        btnExportBill1.setIconTextGap(12);
        btnExportBill1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportBill1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlFormSearchLayout = new javax.swing.GroupLayout(pnlFormSearch);
        pnlFormSearch.setLayout(pnlFormSearchLayout);
        pnlFormSearchLayout.setHorizontalGroup(
            pnlFormSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFormSearchLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(btnExportBill1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(btnSort, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(89, Short.MAX_VALUE))
        );
        pnlFormSearchLayout.setVerticalGroup(
            pnlFormSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFormSearchLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFormSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExportBill1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSort, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pnlList.add(pnlFormSearch, java.awt.BorderLayout.PAGE_START);

        spImportBill.setOpaque(false);
        spImportBill.setVerticalScrollBar(new ScrollBarCustom());

        tblImportBill.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MÃ HD", "NGƯỜI LẬP", "TỔNG TIỀN (VND)", "TRẠNG THÁI", "TIỀN ĐÃ TRẢ (VND)", "NGÀY LẬP"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Double.class, java.lang.Object.class, java.lang.Double.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblImportBill.setOpaque(false);
        tblImportBill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblImportBillMouseClicked(evt);
            }
        });
        spImportBill.setViewportView(tblImportBill);
        if (tblImportBill.getColumnModel().getColumnCount() > 0) {
            tblImportBill.getColumnModel().getColumn(0).setMinWidth(150);
            tblImportBill.getColumnModel().getColumn(0).setMaxWidth(200);
            tblImportBill.getColumnModel().getColumn(4).setResizable(false);
        }

        pnlList.add(spImportBill, java.awt.BorderLayout.CENTER);

        pnlHDNhap.add(pnlList, java.awt.BorderLayout.CENTER);

        jPanel1.setOpaque(false);

        bgpStatus.add(rdoAll);
        rdoAll.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        rdoAll.setSelected(true);
        rdoAll.setText("Tất cả");
        rdoAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoAllActionPerformed(evt);
            }
        });

        bgpStatus.add(rdoPayed);
        rdoPayed.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        rdoPayed.setText("Đã thanh toán");
        rdoPayed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoPayedActionPerformed(evt);
            }
        });

        bgpStatus.add(rdoPaying);
        rdoPaying.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        rdoPaying.setText("Đang thanh toán");
        rdoPaying.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoPayingActionPerformed(evt);
            }
        });

        bgpStatus.add(rdoNoPay);
        rdoNoPay.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        rdoNoPay.setText("Chưa thanh toán");
        rdoNoPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoNoPayActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(rdoAll)
                .addGap(18, 18, 18)
                .addComponent(rdoPayed)
                .addGap(18, 18, 18)
                .addComponent(rdoPaying)
                .addGap(18, 18, 18)
                .addComponent(rdoNoPay)
                .addContainerGap(383, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoPayed)
                    .addComponent(rdoPaying)
                    .addComponent(rdoAll)
                    .addComponent(rdoNoPay))
                .addGap(12, 12, 12))
        );

        pnlHDNhap.add(jPanel1, java.awt.BorderLayout.PAGE_END);

        add(pnlHDNhap, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void tblImportBillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblImportBillMouseClicked
        if (evt.getClickCount() == 2) {
            ImportBill importBill = iBillDAO.selectById(String.valueOf(tblImportBill.getValueAt(tblImportBill.getSelectedRow(), 0)));
            openAddProduct(frame, importBill, true);
        }
    }//GEN-LAST:event_tblImportBillMouseClicked


    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_formFocusGained

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseEntered

    private void txtFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFindActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFindActionPerformed

    private void btnSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSortActionPerformed
        sortTblProduct();
    }//GEN-LAST:event_btnSortActionPerformed

    private void txtFindKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFindKeyReleased
        // TODO add your handling code here:
        this.fillTableImportBill(iBillDAO.selectByKey(txtFind.getText()));
    }//GEN-LAST:event_txtFindKeyReleased

    private void btnExportBill1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportBill1ActionPerformed
        ImportBill ex = getForm();
        importID = ex.getImportBillID();
        openAddProduct(frame, ex, false);
    }//GEN-LAST:event_btnExportBill1ActionPerformed

    private void rdoPayedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoPayedActionPerformed
        List<ImportBill> listIB;
        if (rdoPayed.isSelected()) {
            listIB = iBillDAO.selectPayedASC();
            fillTableImportBill(listIB);
            checkPayed = true;
        }
    }//GEN-LAST:event_rdoPayedActionPerformed

    private void rdoPayingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoPayingActionPerformed
        List<ImportBill> listIB;
        if (rdoPaying.isSelected()) {
            listIB = iBillDAO.selectPayingASC();
            fillTableImportBill(listIB);
            checkPaying = true;
        }
    }//GEN-LAST:event_rdoPayingActionPerformed

    private void rdoAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoAllActionPerformed
        List<ImportBill> listIB;
        if (rdoAll.isSelected()) {
            listIB = iBillDAO.selectAllASC();
            fillTableImportBill(listIB);
            checkAll = true;
        }
    }//GEN-LAST:event_rdoAllActionPerformed

    private void rdoNoPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoNoPayActionPerformed
        List<ImportBill> listIB;
        if (rdoNoPay.isSelected()) {
            listIB = iBillDAO.selectNoPayASC();
            fillTableImportBill(listIB);
            checkNoPay = true;
        }
    }//GEN-LAST:event_rdoNoPayActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgpStatus;
    private CustomSwing.MyButton btnExportBill1;
    private CustomSwing.MyButton btnSort;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlFormSearch;
    private javax.swing.JPanel pnlHDNhap;
    private javax.swing.JPanel pnlList;
    private javax.swing.JRadioButton rdoAll;
    private javax.swing.JRadioButton rdoNoPay;
    private javax.swing.JRadioButton rdoPayed;
    private javax.swing.JRadioButton rdoPaying;
    private javax.swing.JScrollPane spImportBill;
    private javax.swing.JTable tblImportBill;
    private CustomSwing.MyTextField txtFind;
    // End of variables declaration//GEN-END:variables

    private void init() {
        fillTableImportBill(iBillDAO.selectAll());
        BaseDAO.setTable(spImportBill, tblImportBill, false, 0, 1, 3, 5);

    }

    void action(JDialog jd) {
        jd.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                // Xử lý khi JDialog bị đóng

                fillTableImportBill(iBillDAO.selectAll());
                rdoAll.setSelected(true);
                for (int i = 0; i < tblImportBill.getRowCount(); i++) {
                    if (importID.equalsIgnoreCase(String.valueOf(tblImportBill.getValueAt(i, 0)))) {
                        tblImportBill.changeSelection(i, i, false, false);
                        break;
                    }
                }
            }
        });
    }

//    public void openImportDetailsJDialog(JFrame frame, String detailsID, String importID, int index) {
//        ImportBillDetailUI ibDetailsJDialog = new ImportBillDetailUI(frame, true, detailsID, importID, index);
//        action(ibDetailsJDialog);
//        ibDetailsJDialog.setVisible(true);
//    }
    public void openAddProduct(JFrame frame, ImportBill importBill, boolean checkClicktable) {
        CartProductImport ibDetailsJDialog = new CartProductImport(frame, true, importBill, checkClicktable);
        action(ibDetailsJDialog);
        importID = importBill.getImportBillID();
        ibDetailsJDialog.setVisible(true);
    }

    private void fillTableImportBill(List<ImportBill> ib) {
        DefaultTableModel model = (DefaultTableModel) tblImportBill.getModel();
        model.setRowCount(0);
        try {
            List<ImportBill> list = ib;
            for (ImportBill i : list) {
                String status;
                if (null == i.getPayMentStatusID()) {
                    status = "Chưa thanh toán";
                } else status = switch (i.getPayMentStatusID()) {
                    case "1" -> "Đã thanh toán";
                    case "2" -> "Đang thanh toán";
                    default -> "Chưa thanh toán";
                };
                @SuppressWarnings("LocalVariableHidesMemberVariable")
                Object[] row = {
                    i.getImportBillID(),
                    elDAO.findByID(i.getEmployeeID()).getFullName(),
                    i.getTotalAmount(),
                    status,
                    i.getTotalPay(),
                    XDateHelper.toString(i.getCreateDate(), "dd-MM-yyy")
                };
                model.addRow(row);
            }
            tblImportBill.setModel(model);
        } catch (SQLException e) {
            XDialogHelper.alert(this, 0, "Lỗi truy vấn dữ liệu !");
        }
    }

    private ImportBill getForm() {
        ImportBill ib = new ImportBill();
        try {
            ib.setImportBillID(BaseDAO.setExportID("DonNhapHang", "HDN", 8));
            ib.setWareHouseID("1");
            ib.setPayMentStatusID("");
            ib.setEmployeeID(Auth.user.getEmployeeID());
            ib.setTotalAmount(0.0);
            ib.setTotalPay(0.0);
            ib.setNote("");
            ib.setCreateDate(XDateHelper.toDate(XDateHelper.toString(XDateHelper.nowDate()), "yyyy-MM-dd"));
            ib.setCreatedBy(Auth.user.getEmployeeID());

        } catch (SQLException ex) {
            XDialogHelper.alert(this, 0, "Lỗi truy vấn dữ liệu !");
        }
        return ib;
    }
    
    private void sortTblProduct() {
        List<ImportBill> listIB;
        if (rdoNoPay.isSelected()) {
            if (checkNoPay) {
                listIB = iBillDAO.selectNoPayDESC();
                checkNoPay = !checkNoPay;
            } else {
                listIB = iBillDAO.selectNoPayASC();
                checkNoPay = !checkNoPay;
            }
        } else if (rdoPayed.isSelected()) {
            if (checkPayed) {
                listIB = iBillDAO.selectPayedDESC();
                checkPayed = !checkPayed;
            } else {
                listIB = iBillDAO.selectPayedASC();
                checkPayed = !checkPayed;
            }
        } else if (rdoPaying.isSelected()) {
            if (checkPaying) {
                listIB = iBillDAO.selectPayingDESC();
                checkPaying = !checkPaying;
            } else {
                listIB = iBillDAO.selectPayingASC();
                checkPaying = !checkPaying;
            }
        } else {
            if (checkAll) {
                listIB = iBillDAO.selectAllDESC();
                checkAll = !checkAll;
            } else {
                listIB = iBillDAO.selectAllASC();
                checkAll = !checkAll;
            }
        }
        fillTableImportBill(listIB);
    }
}
