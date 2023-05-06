package Conponent;

import CustomSwing.ScrollBarCustom;
import DAO.BaseDAO;
import DAO.ExportBillDAO;
import DAO.ExportBillDetailsDAO;
import DAO.ProductDAO;
import DAO.UnitDAO;
import Entities.ExportBill;
import Entities.ExportDetailBill;
import Entities.Product;
import Helper.XDialogHelper;
import Helper.XShareHelper;
import Utils.Auth;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LinhptPC04737
 */
@SuppressWarnings("serial")
public class CartProductExport extends javax.swing.JDialog {

    private ProductDAO pDAO = new ProductDAO();
    private UnitDAO uDAO = new UnitDAO();
    private ExportBillDetailsDAO ebDDAO = new ExportBillDetailsDAO();
    private ExportBillDAO eBillDAO = new ExportBillDAO();
    private List<ExportDetailBill> list = new ArrayList<>();
    private List<Object[]> listP;
    private List<Object[]> listExpiry;
    private ExportBill exportBill;
    private PrintBill printBill;
    private JFrame _this;
    private WindowListener acPrint;

    private double productPrice = 0;
    private int productAmount = 0;
    private boolean checkClickTable;

    public CartProductExport(java.awt.Frame parent, boolean modal, ExportBill exportBill, WindowListener acPrint, boolean checkClickTable) {
        super(parent, modal);
        this._this = (JFrame) parent;
        this.acPrint = acPrint;
        this.exportBill = exportBill;
        this.checkClickTable = checkClickTable;
        initComponents();
        init();
        this.setLocationRelativeTo(parent);
    }

    public PrintBill getPrintBill() {
        return printBill;
    }

    public void setPrintBill(PrintBill printBill) {
        this.printBill = printBill;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        spProduct = new javax.swing.JScrollPane();
        tblProduct = new javax.swing.JTable();
        lblTitle = new javax.swing.JLabel();
        lblTitleCart = new javax.swing.JLabel();
        spCart = new javax.swing.JScrollPane();
        tblCart = new javax.swing.JTable();
        lblTitleProduct = new javax.swing.JLabel();
        btnPrintBill = new javax.swing.JButton();
        pnlDetailProduct = new javax.swing.JPanel();
        myLable1 = new CustomSwing.MyLable();
        myLable2 = new CustomSwing.MyLable();
        myLable3 = new CustomSwing.MyLable();
        txtProductID = new javax.swing.JTextField();
        txtProductName = new javax.swing.JTextField();
        txtUnit = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        lblProductImg = new javax.swing.JLabel();
        btnInsert = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        myLable4 = new CustomSwing.MyLable();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtNote = new javax.swing.JTextArea();
        btnDelete1 = new javax.swing.JButton();
        txtPrice = new CustomSwing.MyTextField();
        txtAmount = new CustomSwing.MyTextField();
        txtSearch = new CustomSwing.MyTextField();
        lblTotalMoney = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        lblTitleProduct1 = new javax.swing.JLabel();
        btnDone = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Quản lý nhập hàng");

        spProduct.setVerticalScrollBar(new ScrollBarCustom(12));

        tblProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã SP", "Tên SP", "SL Còn Lại"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductMouseClicked(evt);
            }
        });
        spProduct.setViewportView(tblProduct);
        if (tblProduct.getColumnModel().getColumnCount() > 0) {
            tblProduct.getColumnModel().getColumn(0).setMinWidth(100);
            tblProduct.getColumnModel().getColumn(0).setMaxWidth(110);
            tblProduct.getColumnModel().getColumn(2).setMinWidth(130);
            tblProduct.getColumnModel().getColumn(2).setMaxWidth(140);
        }

        lblTitle.setBackground(new java.awt.Color(163, 172, 168));
        lblTitle.setFont(new java.awt.Font("Roboto", 1, 28)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(66, 103, 178));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("THÊM SẢN PHẨM ");
        lblTitle.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        lblTitleCart.setBackground(new java.awt.Color(163, 172, 168));
        lblTitleCart.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        lblTitleCart.setForeground(new java.awt.Color(255, 102, 102));
        lblTitleCart.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitleCart.setText("Giỏ Hàng");
        lblTitleCart.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        tblCart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Tên SP", "Tổng SL", "Đơn Giá (VND)", "Thành Tiền (VND)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCartMouseClicked(evt);
            }
        });
        spCart.setViewportView(tblCart);
        if (tblCart.getColumnModel().getColumnCount() > 0) {
            tblCart.getColumnModel().getColumn(0).setMinWidth(40);
            tblCart.getColumnModel().getColumn(0).setMaxWidth(50);
            tblCart.getColumnModel().getColumn(2).setMinWidth(80);
            tblCart.getColumnModel().getColumn(2).setMaxWidth(100);
            tblCart.getColumnModel().getColumn(4).setMinWidth(160);
            tblCart.getColumnModel().getColumn(4).setMaxWidth(160);
        }

        lblTitleProduct.setBackground(new java.awt.Color(163, 172, 168));
        lblTitleProduct.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        lblTitleProduct.setForeground(new java.awt.Color(255, 102, 102));
        lblTitleProduct.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitleProduct.setText("Danh sách sản phẩm");
        lblTitleProduct.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        btnPrintBill.setBackground(new java.awt.Color(8, 129, 91));
        btnPrintBill.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        btnPrintBill.setForeground(new java.awt.Color(255, 255, 255));
        btnPrintBill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/invoice.png"))); // NOI18N
        btnPrintBill.setText("Xuất hóa đơn");
        btnPrintBill.setIconTextGap(12);
        btnPrintBill.setPreferredSize(new java.awt.Dimension(135, 35));
        btnPrintBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintBillActionPerformed(evt);
            }
        });

        pnlDetailProduct.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlDetailProduct.setForeground(new java.awt.Color(255, 102, 102));

        myLable1.setText("Mã SP:");

        myLable2.setText("Tên SP:");

        myLable3.setText("Đơn vị tính:");

        txtProductID.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        txtProductID.setForeground(new java.awt.Color(0, 51, 204));
        txtProductID.setDisabledTextColor(new java.awt.Color(0, 51, 204));
        txtProductID.setEnabled(false);

        txtProductName.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        txtProductName.setForeground(new java.awt.Color(0, 51, 204));
        txtProductName.setDisabledTextColor(new java.awt.Color(0, 51, 204));
        txtProductName.setEnabled(false);

        txtUnit.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        txtUnit.setForeground(new java.awt.Color(0, 51, 204));
        txtUnit.setDisabledTextColor(new java.awt.Color(0, 51, 204));
        txtUnit.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel5.setText("Số lượng");

        lblProductImg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnInsert.setBackground(new java.awt.Color(2, 66, 2));
        btnInsert.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        btnInsert.setForeground(new java.awt.Color(255, 255, 255));
        btnInsert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/add-button.png"))); // NOI18N
        btnInsert.setText("Thêm vào giỏ");
        btnInsert.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInsert.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnInsert.setPreferredSize(new java.awt.Dimension(135, 35));
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(2, 66, 2));
        btnUpdate.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/edit.png"))); // NOI18N
        btnUpdate.setText("Cập nhật");
        btnUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdate.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnUpdate.setPreferredSize(new java.awt.Dimension(135, 35));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(2, 66, 2));
        btnDelete.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/trash.png"))); // NOI18N
        btnDelete.setText("Xóa sản phẩm");
        btnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDelete.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnDelete.setPreferredSize(new java.awt.Dimension(135, 35));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        myLable4.setText("Đơn giá SP:");

        jLabel8.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel8.setText("Ghi chú hóa đơn:");

        jScrollPane3.setHorizontalScrollBar(new ScrollBarCustom(8));
        jScrollPane3.setVerticalScrollBar(new ScrollBarCustom(8));

        txtNote.setColumns(20);
        txtNote.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtNote.setRows(5);
        txtNote.setTabSize(6);
        jScrollPane3.setViewportView(txtNote);

        btnDelete1.setBackground(new java.awt.Color(2, 66, 2));
        btnDelete1.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        btnDelete1.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/rotation.png"))); // NOI18N
        btnDelete1.setText("Làm mới");
        btnDelete1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDelete1.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnDelete1.setPreferredSize(new java.awt.Dimension(135, 35));
        btnDelete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelete1ActionPerformed(evt);
            }
        });

        txtPrice.setHide("Giá niêm yết:...");
        txtPrice.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPriceFocusLost(evt);
            }
        });
        txtPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPriceKeyReleased(evt);
            }
        });

        txtAmount.setHide("...");
        txtAmount.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtAmountFocusLost(evt);
            }
        });
        txtAmount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAmountKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout pnlDetailProductLayout = new javax.swing.GroupLayout(pnlDetailProduct);
        pnlDetailProduct.setLayout(pnlDetailProductLayout);
        pnlDetailProductLayout.setHorizontalGroup(
            pnlDetailProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetailProductLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDetailProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(myLable1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlDetailProductLayout.createSequentialGroup()
                        .addGroup(pnlDetailProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3)
                            .addComponent(myLable2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtProductID, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                            .addComponent(txtProductName, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                            .addComponent(myLable3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUnit, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                            .addComponent(myLable4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel8)
                            .addComponent(txtPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtAmount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(pnlDetailProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlDetailProductLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(lblProductImg, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDetailProductLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlDetailProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnInsert, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnDelete1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(13, 13, 13)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlDetailProductLayout.setVerticalGroup(
            pnlDetailProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetailProductLayout.createSequentialGroup()
                .addComponent(myLable1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(pnlDetailProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlDetailProductLayout.createSequentialGroup()
                        .addComponent(lblProductImg, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlDetailProductLayout.createSequentialGroup()
                        .addComponent(txtProductID, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(myLable2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtProductName, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(myLable3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(myLable4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel5)
                        .addGap(5, 5, 5)
                        .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        txtSearch.setHide("Nhập tên Sản Phẩm cần tìm");
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        lblTotalMoney.setBackground(new java.awt.Color(163, 172, 168));
        lblTotalMoney.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        lblTotalMoney.setForeground(new java.awt.Color(255, 0, 0));
        lblTotalMoney.setText(". . . ");

        lblTotal.setBackground(new java.awt.Color(163, 172, 168));
        lblTotal.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTotal.setText("Tổng Tiền: ");
        lblTotal.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        lblTitleProduct1.setBackground(new java.awt.Color(163, 172, 168));
        lblTitleProduct1.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        lblTitleProduct1.setForeground(new java.awt.Color(255, 102, 102));
        lblTitleProduct1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitleProduct1.setText("Chi tiết Sản Phẩm");
        lblTitleProduct1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        btnDone.setBackground(new java.awt.Color(164, 203, 191));
        btnDone.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        btnDone.setForeground(new java.awt.Color(0, 51, 51));
        btnDone.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/check-mark.png"))); // NOI18N
        btnDone.setText("Hoàn tất");
        btnDone.setIconTextGap(12);
        btnDone.setPreferredSize(new java.awt.Dimension(135, 35));
        btnDone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoneActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblTitleCart)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblTitleProduct)
                                .addGap(18, 18, 18)
                                .addComponent(txtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(spCart, javax.swing.GroupLayout.DEFAULT_SIZE, 731, Short.MAX_VALUE)
                            .addComponent(spProduct, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(pnlDetailProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTitleProduct1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblTotal)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblTotalMoney, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(279, 279, 279))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(btnPrintBill, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnDone, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)))
                        .addGap(12, 12, 12))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTitleProduct)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblTitleProduct1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(spProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(lblTitleCart)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spCart, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlDetailProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTotal)
                            .addComponent(lblTotalMoney))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnPrintBill, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDone, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPrintBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintBillActionPerformed
        handleExportBill();
    }//GEN-LAST:event_btnPrintBillActionPerformed

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        if (validateForm()) {
            insert();
        }
    }//GEN-LAST:event_btnInsertActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if (validateForm()) {
            update();
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        delete();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
//        listP = pDAO.selectByKeyword(txtSearch.getText());
//        for (int i = 0; i < tblCart.getRowCount(); i++) {
//            for (Product product : listP) {
//                if (product.getProductName().equalsIgnoreCase(String.valueOf(tblCart.getValueAt(i, 1)))) {
//                    listP.remove(product);
//                    break;
//                }
//            }
//        }
//        fillToTableTP(listP);
    }//GEN-LAST:event_txtSearchKeyReleased

    private void tblProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductMouseClicked
        if (!checkClickTable) {
            boolean checkExist = false;
            tblProduct.setRowSelectionAllowed(true);
            if (evt.getClickCount() == 2) {
                productAmount = Integer.parseInt(String.valueOf(tblProduct.getValueAt(tblProduct.getSelectedRow(), 2)));
                if (tblCart.getRowCount() > 0) {
                    for (int i = 0; i < tblCart.getRowCount(); i++) {
                        if (String.valueOf(tblProduct.getValueAt(tblProduct.getSelectedRow(), 1)).equalsIgnoreCase(String.valueOf(tblCart.getValueAt(i, 1)))) {
                            if (XDialogHelper.confirm(this, "Sản phẩm đã tồn tại trong giỏ hàng\n Bạn có muốn cập nhật lại số lượng ?")) {
                                txtAmount.requestFocus();
                                setForm(list.get(i));
                            }
                            checkExist = true;
                            break;
                        }
                    }
                }
                if (!checkExist) {
                    if (productAmount > 0) {
                        fillToForm(String.valueOf(tblProduct.getValueAt(tblProduct.getSelectedRow(), 0)));

                    } else {
                        XDialogHelper.alert(this, 0, "Sản phẩm tạm thời hết hàng !");
                    }
                }
            }
        }
    }//GEN-LAST:event_tblProductMouseClicked

    private void tblCartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCartMouseClicked

        tblProduct.setRowSelectionAllowed(true);
        if (evt.getClickCount() == 2) {
            fillToFormByCart();
        }
    }//GEN-LAST:event_tblCartMouseClicked

    private void btnDelete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelete1ActionPerformed
        clearForm();
    }//GEN-LAST:event_btnDelete1ActionPerformed

    private void txtPriceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPriceKeyReleased
        try {
            if (txtPrice.getText().trim().length() > 0) {
                double price = Double.parseDouble(txtPrice.getText());
                if (price < 0) {
                    XDialogHelper.alert(this, 0, "Giá phải lớn hơn hoặc bằng 0 !");
                }
            }
        } catch (NumberFormatException e) {
            String pri = txtPrice.getText();
            XDialogHelper.alert(this, 0, "Giá phải là số lớn hơn hoặc bằng 0 !");
            txtPrice.setText(pri.substring(0, pri.length() - 1));
        }
    }//GEN-LAST:event_txtPriceKeyReleased

    private void txtPriceFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPriceFocusLost
        if (Double.parseDouble(txtPrice.getText()) < productPrice) {
            XDialogHelper.alert(this, 2, "Giá bán thấp hơn giá niêm yết !");
        }
    }//GEN-LAST:event_txtPriceFocusLost

    private void txtAmountFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAmountFocusLost

    }//GEN-LAST:event_txtAmountFocusLost

    private void txtAmountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAmountKeyReleased
        try {
            if (txtAmount.getText().length() > 0) {
                if (Integer.parseInt(txtAmount.getText()) > productAmount) {
                    String amount = txtAmount.getText();
                    XDialogHelper.alert(this, 0, "Số lượng sản phẩm này chỉ còn: " + productAmount);
                    txtAmount.setText(amount.substring(0, amount.length() - 1));
                }
            }
        } catch (NumberFormatException e) {
            String amount = txtAmount.getText();
            XDialogHelper.alert(this, 0, "Số lượng phải là số lớn hơn 0 !");
            txtAmount.setText(amount.substring(0, amount.length() - 1));
        }
    }//GEN-LAST:event_txtAmountKeyReleased

    private void btnDoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoneActionPerformed
        if (checkClickTable) {
            exportBill.setNote(txtNote.getText());
            eBillDAO.update(exportBill);
        } else {
            eBillDAO.insert(exportBill);
            exportBill.setTotalAmount(totalMoney(tblCart));
            for (ExportDetailBill eb : list) {
                ebDDAO.insert(eb);
            }
            this.dispose();
        }
    }//GEN-LAST:event_btnDoneActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        java.awt.EventQueue.invokeLater(() -> {
//            CartProductImport dialog = new CartProductImport(new javax.swing.JFrame(), true, new ImportBill());
//            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                @Override
//                public void windowClosing(java.awt.event.WindowEvent e) {
//                    System.exit(0);
//                }
//            });
//            dialog.setVisible(true);
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDelete1;
    private javax.swing.JButton btnDone;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnPrintBill;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblProductImg;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTitleCart;
    private javax.swing.JLabel lblTitleProduct;
    private javax.swing.JLabel lblTitleProduct1;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblTotalMoney;
    private CustomSwing.MyLable myLable1;
    private CustomSwing.MyLable myLable2;
    private CustomSwing.MyLable myLable3;
    private CustomSwing.MyLable myLable4;
    private javax.swing.JPanel pnlDetailProduct;
    private javax.swing.JScrollPane spCart;
    private javax.swing.JScrollPane spProduct;
    private javax.swing.JTable tblCart;
    private javax.swing.JTable tblProduct;
    private CustomSwing.MyTextField txtAmount;
    private javax.swing.JTextArea txtNote;
    private CustomSwing.MyTextField txtPrice;
    private javax.swing.JTextField txtProductID;
    private javax.swing.JTextField txtProductName;
    private CustomSwing.MyTextField txtSearch;
    private javax.swing.JTextField txtUnit;
    // End of variables declaration//GEN-END:variables

    private void init() {
        listP = handleListP();
        if (checkClickTable) {
            list = ebDDAO.selectByHD(exportBill.getExportID());
            fillToTableCart(list);
        }
        fillToTableTP(listP);
        BaseDAO.setTable(spProduct, tblProduct, false, 0, 2);
        BaseDAO.setTable(spCart, tblCart, false, 0, 2);
        spProduct.setViewportBorder(BorderFactory.createEmptyBorder());
        spCart.setViewportBorder(BorderFactory.createEmptyBorder());
        btnDelete.setEnabled(false);
        btnUpdate.setEnabled(false);
        btnInsert.setEnabled(false);
        btnPrintBill.setEnabled(checkClickTable);
        txtPrice.setEnabled(false);
        txtAmount.setEnabled(false);
        txtNote.setEnabled(checkClickTable);
        btnDone.setEnabled(checkClickTable);
        txtSearch.setBorder(BorderFactory.createEmptyBorder(1, 6, 1, 6));
        Image IconApp = new ImageIcon(this.getClass().getResource("/Image/invoice.png")).getImage();
        if (IconApp != null) {
            this.setIconImage(IconApp);
        }
    }

    private List<Object[]> handleListP() {
        boolean checkAddListp = true;
        List<Object[]> listProduct = ebDDAO.getTotalProduct();
        List<Object[]> listProductExpiry = ebDDAO.getTotalProductExpiried();
        for (Object[] objects : listProductExpiry) {
            for (Object[] objects1 : listProduct) {
                if (objects[1].equals(objects1[1])) {
                    checkAddListp = false;
                    break;
                } else {
                    checkAddListp = true;
                }
            }
            if (checkAddListp) {
                listProduct.add(objects);
            }
        }
        return listProduct;
    }

    public void fillToTableTP(List<Object[]> listProduct) {
        DefaultTableModel model = (DefaultTableModel) tblProduct.getModel();
        model.setRowCount(0);
        if (listProduct != null) {
            for (Object o : listProduct) {
                model.addRow((Object[]) o);
            }
        }
        tblProduct.setModel(model);
    }

    public void fillToTableCart(List<ExportDetailBill> listI) {
        DefaultTableModel model = (DefaultTableModel) tblCart.getModel();
        model.setRowCount(0);
        int i = 0;
        if (listI != null) {
            for (ExportDetailBill ex : listI) {
                i += 1;
                ex.setDetailID(i);
                Object[] row = {
                    ex.getDetailID(),
                    pDAO.selectById(ex.getProductID()).getProductName(),
                    ex.getAmount(),
                    ex.getPrice(),
                    ex.getTotalAmount()
                };
                model.addRow(row);
            }
        }
        tblCart.setModel(model);
        DecimalFormat formatter = new DecimalFormat("###,###");
        lblTotalMoney.setText(String.valueOf(formatter.format(totalMoney(tblCart))) + " VND");
        btnPrintBill.setEnabled(tblCart.getRowCount() > 0);
        btnDone.setEnabled(tblCart.getRowCount() > 0);
    }

    private double totalMoney(JTable tblCart) {
        double totalMoney = 0;
        if (tblCart.getRowCount() > 0) {
            for (int i = 0; i < tblCart.getRowCount(); i++) {
                totalMoney += Double.parseDouble(String.valueOf(tblCart.getValueAt(i, 4)));
            }
        }
        return totalMoney;
    }

    private void fillToForm(String idProduct) {
        Product p = pDAO.selectById(idProduct);
        clearForm();
        tblProduct.setRowSelectionAllowed(true);
        productPrice = p.getProductPrice();
        txtPrice.setHide("Giá niêm yết: " + productPrice);
        txtPrice.revalidate();
        txtPrice.repaint();
        txtProductID.setText(p.getProductID());
        txtProductName.setText(p.getProductName());
        txtUnit.setText(uDAO.selectByIds(p.getUnit()).getUnitName());
        lblProductImg.setIcon(XShareHelper.scaledImage(p.getImageProduct(), lblProductImg));
        btnInsert.setEnabled(true);
        txtPrice.setEnabled(true);
        txtAmount.setEnabled(true);
        txtNote.setEnabled(true);
    }

    private void fillToFormByCart() {
        for (ExportDetailBill e : list) {
            if (e.getExportID().equalsIgnoreCase(exportBill.getExportID())
                    && e.getDetailID() == Integer.parseInt(String.valueOf(tblCart.getValueAt(tblCart.getSelectedRow(), 0)))) {
                setForm(e);
                break;
            }
        }
    }

    private void setForm(ExportDetailBill e) {
        Product p = pDAO.selectById(e.getProductID());
        txtProductID.setText(p.getProductID());
        txtProductName.setText(p.getProductName());
        txtUnit.setText(uDAO.selectByIds(p.getUnit()).getUnitName());

        txtAmount.setText(e.getAmount() + "");
        txtPrice.setText(e.getPrice() + "");
        txtNote.setText(e.getNote());
        Product pd = pDAO.selectById(e.getProductID());
        if (pd.getImageProduct() != null) {
            lblProductImg.setToolTipText(pd.getImageProduct());
            lblProductImg.setIcon(XShareHelper.scaledImage(pd.getImageProduct(), lblProductImg));
        }
        btnDelete.setEnabled(!checkClickTable);
        btnUpdate.setEnabled(!checkClickTable);
        btnInsert.setEnabled(false);
        txtPrice.setEnabled(!checkClickTable);
        txtAmount.setEnabled(!checkClickTable);
        txtNote.setEnabled(true);
    }

    public ExportDetailBill getForm() {
        ExportDetailBill ebD = new ExportDetailBill();
        int totalAmount = Integer.parseInt(txtAmount.getText());
        double price = Double.parseDouble(txtPrice.getText());
        ebD.setExportID(exportBill.getExportID());
        ebD.setProductID(txtProductID.getText());
        ebD.setPrice(price);
        ebD.setAmount(totalAmount);
        ebD.setTotalAmount(Double.parseDouble(totalAmount * price + ""));
        ebD.setNote("");
        return ebD;
    }

    public void insert() {
        list.add(getForm());
        if (tblProduct.getRowCount() > 0) {
            for (int i = 0; i < listP.size(); i++) {
                if (txtProductID.getText().equalsIgnoreCase(String.valueOf(listP.get(i)[0]))) {
//                    listP.get(i)[2] = productAmount - Integer.parseInt(txtAmount.getText());
                    fillToTableTP(listP);
                    fillToTableCart(list);
                    break;
                }
            }
        }

        for (int i = 0; i < tblCart.getRowCount(); i++) {
            if (txtProductName.getText().equalsIgnoreCase(String.valueOf(tblCart.getValueAt(i, 1)))) {
                tblCart.setRowSelectionAllowed(true);
                tblCart.changeSelection(i, i, false, false);
                break;
            }
        }
        clearForm();
    }

    public void update() {
        if (tblCart.getRowCount() > 0) {
            for (int i = 0; i < list.size(); i++) {
                if (txtProductID.getText().equalsIgnoreCase(list.get(i).getProductID())) {
                    list.remove(i);
                    list.add(getForm());
                    fillToTableCart(list);
                    clearForm();
                    XDialogHelper.alert(this, 1, "Cập nhật thành công !");
                    break;
                }
            }
        }
    }

    public void delete() {
        if (tblCart.getRowCount() > 0) {
            String id = txtProductID.getText();
            for (int i = 0; i < list.size(); i++) {
                if (id.equalsIgnoreCase(list.get(i).getProductID())) {
                    if (XDialogHelper.confirm(this, "Bạn có chắc là muốn xóa ?")) {
                        list.remove(i);
                        fillToTableCart(list);

//                        for (int j = 0; j < listP.size(); j++) {
//                            System.out.println("ab");
//                            if (id.equalsIgnoreCase(String.valueOf(listP.get(j)[0]))) {
//                                System.out.println("abch");
//                                listP.get(j)[2] = Integer.parseInt(String.valueOf(listP.get(j)[2])) + Integer.parseInt(txtAmount.getText());
//                                fillToTableTP(listP);
//                                break;
//                            }
//                        }
                        clearForm();

                        XDialogHelper.alert(this, 1, "Xóa thành công !");
                        break;
                    }
                }
            }
        }
    }

    private void clearForm() {
        txtProductID.setText("");
        txtProductName.setText("");
        txtUnit.setText("");
        txtPrice.setText("");
        txtAmount.setText("");
        txtNote.setText("");
        txtPrice.setHide("Giá niêm yết:...");
        txtPrice.revalidate();
        tblProduct.setRowSelectionAllowed(false);
        lblProductImg.setIcon(null);
        btnDelete.setEnabled(false);
        btnUpdate.setEnabled(false);
        btnInsert.setEnabled(false);
        txtPrice.setEnabled(false);
        txtAmount.setEnabled(false);
        txtNote.setEnabled(false);
    }

    private boolean validateForm() {
        try {
            double price = Double.parseDouble(txtPrice.getText());
            if (price < 0) {
                XDialogHelper.alert(this, 0, "Giá sản phẩm phải là số lớn hơn bằng 0 !");
                txtPrice.requestFocus();
                return false;
            }
        } catch (NumberFormatException e) {
            XDialogHelper.alert(this, 0, "Giá sản phẩm phải là số lớn hơn bằng 0 !");
            txtPrice.requestFocus();
            return false;
        }

        try {
            int mount = Integer.parseInt(txtAmount.getText());
            if (mount <= 0) {
                XDialogHelper.alert(this, 0, "Số lượng thùng phải là số nguyên lớn hơn 0 !");
                txtAmount.requestFocus();
                return false;
            }
        } catch (NumberFormatException e) {
            XDialogHelper.alert(this, 0, "Số lượng thùng phải là số nguyên lớn hơn 0 !");
            txtAmount.requestFocus();
            return false;
        }
        return true;
    }

    private void handleExportBill() {
        try {
            if (!checkClickTable) {
                exportBill.setNote(txtNote.getText());
                eBillDAO.insert(exportBill);
                exportBill.setTotalAmount(totalMoney(tblCart));
                for (ExportDetailBill eb : list) {
                    ebDDAO.insert(eb);
                }
            }
            this.dispose();
            printBill = new PrintBill(_this, exportBill.getExportID(), totalMoney(tblCart), Auth.user.getFullName());
            printBill.setVisible(true);
            ActionListener acP = (ActionEvent e) -> {
                if (tblCart.getRowCount() > 0) {
                    if (handleBtnPrint(printBill.getPnlInfor())) {
                        exportBill.setStatusExport(1);
                        eBillDAO.update(exportBill);
                        printBill.dispose();
                    }
                } else {
                    XDialogHelper.alert(this, JOptionPane.WARNING_MESSAGE, "Không có thông tin trong hóa đơn !");
                }
            };
            printBill.getBtnPrint().addActionListener(acP);
            printBill.addWindowListener(acPrint);
        } catch (NumberFormatException e) {
            System.out.println(e);
            XDialogHelper.alert(this, 0, "Nhập hàng thất bại !");
        }
    }

    private boolean handleBtnPrint(JPanel panel) {
        boolean check = false;
        PrinterJob printerJob = PrinterJob.getPrinterJob();
        printerJob.setJobName("Xuất kho");
        printerJob.setPrintable((Graphics graphics, PageFormat pageFormat, int pageIndex) -> {
            if (pageIndex > 0) {
                return Printable.NO_SUCH_PAGE;
            }
            Graphics2D g2 = (Graphics2D) graphics;
            g2.translate(pageFormat.getImageableX() * 2, pageFormat.getImageableY() * 2);
            g2.scale(0.54, 0.54);
            panel.paint(g2);
            return Printable.PAGE_EXISTS;
        });
        boolean result = printerJob.printDialog();

        if (result) {
            try {
                printerJob.print();
                check = true;
            } catch (PrinterException e) {
                XDialogHelper.alert(this, 0, "In thất bại !");
            }
        }
        return check;
    }
}
