package Conponent;

import CustomSwing.MyButton;
import CustomSwing.ScrollBarCustom;
import DAO.ExportBillDetailsDAO;
import Entities.ExportDetailBill;
import Helper.XDialogHelper;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LinhptPC04737
 */
@SuppressWarnings("serial")
public class PrintBill extends javax.swing.JDialog {

    private ExportBillDetailsDAO ebDAO = new ExportBillDetailsDAO();

    public PrintBill(JFrame frame, String id, double totalMoney, String employee) {
        initComponents();
        this.setSize(1250, 720);
        init(id, totalMoney, employee);
        this.setLocationRelativeTo(frame);
        this.setTitle("Phiếu Xuất Kho");

    }

    public JPanel getPnlInfor() {
        return pnlInfor;
    }

    public void setPnlInfor(JPanel pnlInfor) {
        this.pnlInfor = pnlInfor;
    }

    public MyButton getBtnPrint() {
        return btnPrint;
    }

    public void setBtnPrint(MyButton btnPrint) {
        this.btnPrint = btnPrint;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBtn = new javax.swing.JPanel();
        btnPrint = new CustomSwing.MyButton();
        btnCancel = new CustomSwing.MyButton();
        spInfor = new javax.swing.JScrollPane();
        pnlInfor = new javax.swing.JPanel();
        tblExportDetails = new javax.swing.JTable();
        lblTitle = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblStore = new javax.swing.JLabel();
        lblStoreName = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        lblIntoMoney = new javax.swing.JLabel();
        lblTitleExporter = new javax.swing.JLabel();
        lblNameExporter = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        pnlBtn.setBackground(new java.awt.Color(186, 186, 186));
        pnlBtn.setPreferredSize(new java.awt.Dimension(100, 557));

        btnPrint.setBackground(new java.awt.Color(30, 164, 78));
        btnPrint.setForeground(new java.awt.Color(255, 255, 255));
        btnPrint.setText("Print");
        btnPrint.setColor(new java.awt.Color(30, 164, 78));
        btnPrint.setColorEntered(new java.awt.Color(46, 192, 98));
        btnPrint.setColorHover(new java.awt.Color(255, 255, 255));
        btnPrint.setColorNomal(new java.awt.Color(255, 255, 255));
        btnPrint.setColorPressed(new java.awt.Color(30, 164, 78));
        btnPrint.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        btnCancel.setBackground(new java.awt.Color(225, 72, 87));
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setText("Hủy");
        btnCancel.setColor(new java.awt.Color(225, 72, 87));
        btnCancel.setColorEntered(new java.awt.Color(225, 72, 87));
        btnCancel.setColorHover(new java.awt.Color(255, 255, 255));
        btnCancel.setColorNomal(new java.awt.Color(255, 255, 255));
        btnCancel.setColorPressed(new java.awt.Color(225, 72, 87));
        btnCancel.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBtnLayout = new javax.swing.GroupLayout(pnlBtn);
        pnlBtn.setLayout(pnlBtnLayout);
        pnlBtnLayout.setHorizontalGroup(
            pnlBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnPrint, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        pnlBtnLayout.setVerticalGroup(
            pnlBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBtnLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(595, Short.MAX_VALUE))
        );

        getContentPane().add(pnlBtn, java.awt.BorderLayout.WEST);

        spInfor.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        spInfor.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        spInfor.setVerticalScrollBar(new ScrollBarCustom(8)
        );

        pnlInfor.setBackground(new java.awt.Color(255, 255, 255));

        tblExportDetails.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        tblExportDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", "a6",  new Integer(1),  new Double(120000.0),  new Double(1440000.0), null},
                {"2", "b7",  new Integer(2),  new Double(500000.0),  new Double(500000.0), null},
                {"3", "c78",  new Integer(3),  new Double(10.0),  new Double(50.0), null},
                {"4", "d", null,  new Double(58.0),  new Double(12.0), null}
            },
            new String [] {
                "TT", "Tên sản phẩm", "Số lượng", "Đơn giá", "Thành tiền", "Ghi chú"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class, java.lang.Object.class
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
        tblExportDetails.setEnabled(false);
        tblExportDetails.setRowHeight(30);
        tblExportDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblExportDetailsMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblExportDetailsMouseReleased(evt);
            }
        });

        lblTitle.setFont(new java.awt.Font("Roboto", 1, 36)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(66, 103, 178));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("PHIẾU XUẤT KHO");

        jPanel1.setOpaque(false);

        lblStore.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        lblStore.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/rice.png"))); // NOI18N
        lblStore.setText("ART GROUP");
        lblStore.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lblStore.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblStore.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        lblStoreName.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        lblStoreName.setText("CỬA HÀNG VẬT TƯ NÔNG NGHIỆP ART GROUP");

        lblDate.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        lblDate.setText("Cần thơ, ngày ... tháng ... năm 20..");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(lblStore)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 379, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblStoreName, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblStore)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(lblStoreName)
                        .addGap(31, 31, 31)
                        .addComponent(lblDate)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblTotal.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        lblTotal.setText("Tổng tiền:");

        lblIntoMoney.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        lblIntoMoney.setForeground(new java.awt.Color(255, 51, 51));
        lblIntoMoney.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIntoMoney.setText("...");

        lblTitleExporter.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        lblTitleExporter.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitleExporter.setText("Người xuất hóa đơn");

        lblNameExporter.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        lblNameExporter.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNameExporter.setText("...");

        jLabel9.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("STT");

        jLabel10.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Tên sản phẩm");

        jLabel11.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Số lượng");

        jLabel12.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Đơn giá");

        jLabel13.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Thành tiền");

        jLabel14.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Ghi chú");

        javax.swing.GroupLayout pnlInforLayout = new javax.swing.GroupLayout(pnlInfor);
        pnlInfor.setLayout(pnlInforLayout);
        pnlInforLayout.setHorizontalGroup(
            pnlInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInforLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(pnlInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlInforLayout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblTitle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tblExportDetails, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlInforLayout.createSequentialGroup()
                        .addComponent(lblTotal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblIntoMoney, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(133, 133, 133))
                    .addGroup(pnlInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblTitleExporter, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblNameExporter, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(48, 48, 48))
        );
        pnlInforLayout.setVerticalGroup(
            pnlInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInforLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(lblTitle)
                .addGap(36, 36, 36)
                .addGroup(pnlInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel11)
                    .addComponent(jLabel9))
                .addComponent(tblExportDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotal)
                    .addComponent(lblIntoMoney))
                .addGap(47, 47, 47)
                .addComponent(lblTitleExporter)
                .addGap(104, 104, 104)
                .addComponent(lblNameExporter)
                .addGap(48, 48, 48))
        );

        if (tblExportDetails.getColumnModel().getColumnCount() > 0) {
            tblExportDetails.getColumnModel().getColumn(0).setMinWidth(50);
            tblExportDetails.getColumnModel().getColumn(0).setMaxWidth(60);
            tblExportDetails.getColumnModel().getColumn(2).setMinWidth(60);
            tblExportDetails.getColumnModel().getColumn(2).setMaxWidth(80);
            tblExportDetails.getColumnModel().getColumn(3).setMinWidth(100);
            tblExportDetails.getColumnModel().getColumn(3).setMaxWidth(110);
            tblExportDetails.getColumnModel().getColumn(4).setMinWidth(130);
            tblExportDetails.getColumnModel().getColumn(4).setMaxWidth(150);
            tblExportDetails.getColumnModel().getColumn(5).setMinWidth(160);
            tblExportDetails.getColumnModel().getColumn(5).setMaxWidth(180);
        }

        spInfor.setViewportView(pnlInfor);

        getContentPane().add(spInfor, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void tblExportDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblExportDetailsMouseClicked
        this.dispose();
    }//GEN-LAST:event_tblExportDetailsMouseClicked

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
//        handleBtnPrint(pnlInfor);
    }//GEN-LAST:event_btnPrintActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void tblExportDetailsMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblExportDetailsMouseReleased
        
    }//GEN-LAST:event_tblExportDetailsMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private CustomSwing.MyButton btnCancel;
    private CustomSwing.MyButton btnPrint;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblIntoMoney;
    private javax.swing.JLabel lblNameExporter;
    private javax.swing.JLabel lblStore;
    private javax.swing.JLabel lblStoreName;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTitleExporter;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JPanel pnlBtn;
    private javax.swing.JPanel pnlInfor;
    private javax.swing.JScrollPane spInfor;
    private javax.swing.JTable tblExportDetails;
    // End of variables declaration//GEN-END:variables

    private void init(String id, double totalMoney, String employee) {
        setTable(0, 1, 2);
        spInfor.getVerticalScrollBar().setUnitIncrement(16);
        fillToForm(id, totalMoney, employee);
        setStatus();
        this.setResizable(false);
    }

    private void setStatus() {
        int day = getCalendarNow().get(Calendar.DATE);
        int month = getCalendarNow().get(Calendar.MONTH) + 1;
        int year = getCalendarNow().get(Calendar.YEAR);
        lblDate.setText("Cần Thơ, ngày " + day + " tháng " + month + " năm " + year);
        Image IconApp = new ImageIcon(this.getClass().getResource("/Image/invoice.png")).getImage();
        if (IconApp != null) {
            this.setIconImage(IconApp);
        }
    }

    private void fillToForm(String id, double totalMoney, String employee) {
        DecimalFormat formatter = new DecimalFormat("###,###");
        DefaultTableModel model = (DefaultTableModel) tblExportDetails.getModel();
        model.setRowCount(0);
        List<ExportDetailBill> edb = ebDAO.selectByIds(id);
        try {
            lblIntoMoney.setText(String.valueOf(formatter.format(totalMoney))+ " VND");
            for (ExportDetailBill i : edb) {
                @SuppressWarnings("LocalVariableHidesMemberVariable")
                Object[] row = {
                    i.getDetailID(),
                    i.getProductName(),
                    i.getAmount(),
                    i.getPrice(),
                    i.getTotalAmount(),
                    i.getNote()
                };
                model.addRow(row);
            }
            tblExportDetails.setModel(model);
            lblNameExporter.setText(employee);
        } catch (Exception e) {
            XDialogHelper.alert(this, "Lỗi truy vấn dữ liệu !");
        }
    }

    private void setTable(int... index) {
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setHorizontalAlignment(JLabel.CENTER);
        if (index.length > 0) {
            for (int i : index) {
                tblExportDetails.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
            }
        }
    }

//    private void handleBtnPrint(JPanel panel) {
//        PrinterJob printerJob = PrinterJob.getPrinterJob();
//        printerJob.setJobName("Xuất kho");
//        printerJob.setPrintable((Graphics graphics, PageFormat pageFormat, int pageIndex) -> {
//            if (pageIndex > 0) {
//                return Printable.NO_SUCH_PAGE;
//            }
//            Graphics2D g2 = (Graphics2D) graphics;
//            g2.translate(pageFormat.getImageableX() * 2, pageFormat.getImageableY() * 2);
//            g2.scale(0.54, 0.54);
//            panel.paint(g2);
//            return Printable.PAGE_EXISTS;
//        });
//        boolean result = printerJob.printDialog();
//
//        if (result) {
//            try {
//                printerJob.print();
//            } catch (PrinterException e) {
//                XDialogHelper.alert(this, 0, "In thất bại !");
//            }
//        }
//    }

    public Calendar getCalendarNow() {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
        calendar.setTime(date);
        return calendar;
    }
}
