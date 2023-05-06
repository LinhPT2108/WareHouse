package Conponent;

import CustomSwing.ScrollBarCustom;
import DAO.BaseDAO;
import DAO.EmployeeDAO;
import DAO.ExportBillDAO;
import Entities.ExportBill;
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
import java.awt.event.WindowListener;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LinhptPC04737
 */
@SuppressWarnings("serial")
public class ExportBillUI extends javax.swing.JPanel {

    private Color bgColorA = Colors.homeColor(Colors.LEFT);
    private Color bgColorB = Colors.homeColor(Colors.RIGHT);
    private JFrame frame;

    private double totalMoney;
    private String exportID;

    private ExportBillDAO eBillDAO = new ExportBillDAO();
    private EmployeeDAO eDAO = new EmployeeDAO();
    private boolean checkShortNoExport = true;
    private boolean checkShortExported = true;
    private boolean checkShortAllExport = true;

    public ExportBillUI(JFrame f) {
        initComponents();
        init();
        setLocal();
        this.frame = f;
    }

    private void setLocal() {
        this.setOpaque(false);
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

        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        btnTypeStatus = new javax.swing.ButtonGroup();
        pnlHDNhap = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        pnlList = new javax.swing.JPanel();
        pnlFormSearch = new javax.swing.JPanel();
        btnSort = new CustomSwing.MyButton();
        txtSearch1 = new CustomSwing.MyTextField();
        btnExportBill1 = new CustomSwing.MyButton();
        spExportBill = new javax.swing.JScrollPane();
        tblExportBill = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        rdoExported = new javax.swing.JRadioButton();
        rdoNoExport = new javax.swing.JRadioButton();
        rdoAll = new javax.swing.JRadioButton();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

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
        lblTitle.setText("QUẢN LÝ HÓA ĐƠN XUẤT");
        lblTitle.setPreferredSize(new java.awt.Dimension(308, 60));
        pnlHDNhap.add(lblTitle, java.awt.BorderLayout.PAGE_START);

        pnlList.setOpaque(false);
        pnlList.setLayout(new java.awt.BorderLayout());

        pnlFormSearch.setBackground(new java.awt.Color(147, 196, 125));
        pnlFormSearch.setOpaque(false);

        btnSort.setBackground(new java.awt.Color(215, 249, 250));
        btnSort.setBorder(null);
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

        txtSearch1.setHide("Tìm theo ngày lập. VD: 03-09-2023");
        txtSearch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearch1ActionPerformed(evt);
            }
        });
        txtSearch1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearch1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearch1KeyReleased(evt);
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
                .addComponent(txtSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(89, Short.MAX_VALUE))
        );
        pnlFormSearchLayout.setVerticalGroup(
            pnlFormSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFormSearchLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFormSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSort, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExportBill1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pnlList.add(pnlFormSearch, java.awt.BorderLayout.PAGE_START);

        spExportBill.setOpaque(false);
        spExportBill.setVerticalScrollBar(new ScrollBarCustom(8));

        tblExportBill.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã HD", "Tổng tiền (VND)", "Ngày lập HD", "Trạng thái", "Người lập", "Ghi chú"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Double.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblExportBill.setOpaque(false);
        tblExportBill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblExportBillMouseClicked(evt);
            }
        });
        spExportBill.setViewportView(tblExportBill);
        if (tblExportBill.getColumnModel().getColumnCount() > 0) {
            tblExportBill.getColumnModel().getColumn(0).setMinWidth(150);
            tblExportBill.getColumnModel().getColumn(0).setMaxWidth(200);
            tblExportBill.getColumnModel().getColumn(2).setMinWidth(130);
            tblExportBill.getColumnModel().getColumn(2).setMaxWidth(150);
            tblExportBill.getColumnModel().getColumn(5).setMinWidth(110);
            tblExportBill.getColumnModel().getColumn(5).setMaxWidth(120);
        }

        pnlList.add(spExportBill, java.awt.BorderLayout.CENTER);

        jPanel1.setOpaque(false);

        btnTypeStatus.add(rdoExported);
        rdoExported.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        rdoExported.setText("Đã xuất");
        rdoExported.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoExportedActionPerformed(evt);
            }
        });

        btnTypeStatus.add(rdoNoExport);
        rdoNoExport.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        rdoNoExport.setText("Chưa xuất");
        rdoNoExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoNoExportActionPerformed(evt);
            }
        });

        btnTypeStatus.add(rdoAll);
        rdoAll.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        rdoAll.setSelected(true);
        rdoAll.setText("Tất cả");
        rdoAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoAllActionPerformed(evt);
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
                .addComponent(rdoExported)
                .addGap(18, 18, 18)
                .addComponent(rdoNoExport)
                .addContainerGap(658, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoExported)
                    .addComponent(rdoNoExport)
                    .addComponent(rdoAll))
                .addGap(12, 12, 12))
        );

        pnlList.add(jPanel1, java.awt.BorderLayout.PAGE_END);

        pnlHDNhap.add(pnlList, java.awt.BorderLayout.CENTER);

        add(pnlHDNhap, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void tblExportBillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblExportBillMouseClicked
        tblExportBill.setRowSelectionAllowed(true);
        if (evt.getClickCount() == 2) {
            ExportBill eb = eBillDAO.selectById(String.valueOf(tblExportBill.getValueAt(tblExportBill.getSelectedRow(), 0)));
            openAddProduct(frame, eb, true);
        }

    }//GEN-LAST:event_tblExportBillMouseClicked


    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_formFocusGained

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseEntered

    private void btnSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSortActionPerformed
        sortTblProduct();
    }//GEN-LAST:event_btnSortActionPerformed

    private void txtSearch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearch1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearch1ActionPerformed

    private void rdoNoExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoNoExportActionPerformed
        List<ExportBill> listEB;
        if (rdoNoExport.isSelected()) {
            listEB = eBillDAO.selectNoExportASC();
            fillTableExportBill(listEB);
            checkShortNoExport = true;
        }
    }//GEN-LAST:event_rdoNoExportActionPerformed

    private void rdoExportedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoExportedActionPerformed
        List<ExportBill> listEB;
        if (rdoExported.isSelected()) {
            listEB = eBillDAO.selectExportedASC();
            fillTableExportBill(listEB);
            checkShortExported = true;
        }
    }//GEN-LAST:event_rdoExportedActionPerformed

    private void rdoAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoAllActionPerformed
        if (rdoAll.isSelected()) {
            fillTableExportBill(eBillDAO.selectAlls());
            checkShortAllExport = true;
        }
    }//GEN-LAST:event_rdoAllActionPerformed

    private void txtSearch1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearch1KeyPressed
//        handleSearch();
    }//GEN-LAST:event_txtSearch1KeyPressed

    private void txtSearch1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearch1KeyReleased
        handleSearch();
    }//GEN-LAST:event_txtSearch1KeyReleased

    private void btnExportBill1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportBill1ActionPerformed
        ExportBill ex = getForm();
        exportID = ex.getExportID();
        openAddProduct(frame, ex, false);

    }//GEN-LAST:event_btnExportBill1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private CustomSwing.MyButton btnExportBill1;
    private CustomSwing.MyButton btnSort;
    private javax.swing.ButtonGroup btnTypeStatus;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlFormSearch;
    private javax.swing.JPanel pnlHDNhap;
    private javax.swing.JPanel pnlList;
    private javax.swing.JRadioButton rdoAll;
    private javax.swing.JRadioButton rdoExported;
    private javax.swing.JRadioButton rdoNoExport;
    private javax.swing.JScrollPane spExportBill;
    private javax.swing.JTable tblExportBill;
    private CustomSwing.MyTextField txtSearch1;
    // End of variables declaration//GEN-END:variables

    private void init() {
        fillTableExportBill(eBillDAO.selectAll());
        BaseDAO.setTable(spExportBill, tblExportBill, false, 0, 2, 3, 4, 5);
    }

    public void action(JDialog jd) {
        jd.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                // Xử lý khi JDialog bị đóng
                fillTableExportBill(eBillDAO.selectAll());
                rdoAll.setSelected(true);
                for (int i = 0; i < tblExportBill.getRowCount(); i++) {
                    if (exportID.equalsIgnoreCase(String.valueOf(tblExportBill.getValueAt(i, 0)))) {
                        tblExportBill.changeSelection(i, i, false, false);
                        tblExportBill.setRowSelectionAllowed(true);
                        break;
                    }
                }
            }
        });
    }

    public void actionPrint(JDialog jd) {
        jd.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                // Xử lý khi JDialog bị đóng
                fillTableExportBill(eBillDAO.selectAll());
                for (int i = 0; i < tblExportBill.getRowCount(); i++) {
                    if (exportID.equalsIgnoreCase(String.valueOf(tblExportBill.getValueAt(i, 0)))) {
                        tblExportBill.changeSelection(i, i, false, false);
                        tblExportBill.setRowSelectionAllowed(true);
                        break;
                    }
                }
            }
        });
    }

    public WindowListener handleExportPrint() {
        WindowListener actionPrint = new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                // Xử lý khi JDialog bị đóng
                fillTableExportBill(eBillDAO.selectAll());
                for (int i = 0; i < tblExportBill.getRowCount(); i++) {
                    if (exportID.equalsIgnoreCase(String.valueOf(tblExportBill.getValueAt(i, 0)))) {
                        tblExportBill.changeSelection(i, i, false, false);
                        tblExportBill.setRowSelectionAllowed(true);
                        System.out.println("iiiii");
                        break;
                    }
                }
            }
        };
        return actionPrint;
    }

    public void openAddProduct(JFrame frame, ExportBill exportBill, boolean checkClickTable) {
        CartProductExport ibDetailsJDialog = new CartProductExport(frame, true, exportBill, handleExportPrint(), checkClickTable);
        action(ibDetailsJDialog);
        exportID = exportBill.getExportID();
        ibDetailsJDialog.setVisible(true);
    }

    public void fillTableExportBill(List<ExportBill> ib) {
        DefaultTableModel model = (DefaultTableModel) tblExportBill.getModel();
        model.setRowCount(0);
        try {
            List<ExportBill> list = ib;
            for (ExportBill e : list) {
                @SuppressWarnings("LocalVariableHidesMemberVariable")
                Object[] row = {
                    e.getExportID(),
                    e.getTotalAmount(),
                    XDateHelper.toString(e.getCreatedDate(), "dd-MM-yyyy"),
                    e.getStatusExport() == 1 ? "Đã xuất hàng" : "Chưa xuất hàng",
                    eDAO.findByID(e.getEmployeeID()).getFullName(),
                    e.getNote()
                };
                model.addRow(row);
            }
            tblExportBill.setModel(model);
        } catch (SQLException e) {
            XDialogHelper.alert(this, "Lỗi truy vấn dữ liệu !");
        }
    }

    public ExportBill getForm() {
        ExportBill ib = new ExportBill();
        try {
            ib.setExportID(BaseDAO.setExportID("DonXuatHang", "HDX", 8));
            ib.setWareHouseID(1);
            ib.setEmployeeID(Auth.user.getEmployeeID());
            ib.setTotalAmount(totalMoney);
            ib.setStatusExport(2);
            ib.setCreatedDate(XDateHelper.toDate(XDateHelper.toString(XDateHelper.nowDate()), "yyyy-MM-dd"));
        } catch (SQLException ex) {
            XDialogHelper.alert(this, 0, "Lỗi truy vấn dữ liệu !");
        }
        return ib;
    }

    private void sortTblProduct() {
        List<ExportBill> listEB;
        if (rdoNoExport.isSelected()) {
            if (checkShortNoExport) {
                listEB = eBillDAO.selectNoExportDESC();
                checkShortNoExport = !checkShortNoExport;
            } else {
                listEB = eBillDAO.selectNoExportASC();
                checkShortNoExport = !checkShortNoExport;
            }
        } else if (rdoExported.isSelected()) {
            if (checkShortExported) {
                listEB = eBillDAO.selectExportedDESC();
                checkShortExported = !checkShortExported;
            } else {
                listEB = eBillDAO.selectExportedASC();
                checkShortExported = !checkShortExported;
            }
        } else {
            if (checkShortAllExport) {
                listEB = eBillDAO.selectAllsDESC();
                checkShortAllExport = !checkShortAllExport;
            } else {
                listEB = eBillDAO.selectAlls();
                checkShortAllExport = !checkShortAllExport;
            }
        }
        fillTableExportBill(listEB);
    }

    private void handleSearch() {
        List<ExportBill> listEB = eBillDAO.selectByDate(txtSearch1.getText());
        fillTableExportBill(listEB);
    }
}
