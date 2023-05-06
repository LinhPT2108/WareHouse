package Conponent;

import CustomSwing.ScrollBarCustom;
import DAO.BaseDAO;
import DAO.ImportBillDAO;
import DAO.ImportBillDetailsDAO;
import DAO.ProductDAO;
import DAO.StatisticalDAO;
import DAO.UnitDAO;
import Entities.ImportBill;
import Entities.ImportBilldetails;
import Entities.Product;
import Entities.Unit;
import Helper.XDateHelper;
import Helper.XDialogHelper;
import Helper.XShareHelper;
import java.awt.Color;
import java.awt.Image;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LinhptPC04737
 */
@SuppressWarnings("serial")
public class CartProductImport extends javax.swing.JDialog {

    private ProductDAO pDAO = new ProductDAO();
    private UnitDAO uDAO = new UnitDAO();
    private ImportBillDetailsDAO ibDDAO = new ImportBillDetailsDAO();
    private ImportBillDAO iBillDAO = new ImportBillDAO();
    private List<ImportBilldetails> list = new ArrayList<>();
    private List<Product> listP;
    private ImportBill importBill;
    private boolean checkClickTable;
    private DecimalFormat formatterVND = new DecimalFormat("###,###");

    public CartProductImport(java.awt.Frame parent, boolean modal, ImportBill importBill, boolean checkClickTable) {
        super(parent, modal);
        this.importBill = importBill;
        this.checkClickTable = checkClickTable;
        initComponents();
        init();
        this.setLocationRelativeTo(parent);
        this.setResizable(false);
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
        btnImportProduct = new javax.swing.JButton();
        pnlDetailProduct = new javax.swing.JPanel();
        myLable1 = new CustomSwing.MyLable();
        myLable2 = new CustomSwing.MyLable();
        myLable3 = new CustomSwing.MyLable();
        jLabel4 = new javax.swing.JLabel();
        jdcManufacturingDate = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jdcExpiryDate = new com.toedter.calendar.JDateChooser();
        txtProductID = new javax.swing.JTextField();
        txtProductName = new javax.swing.JTextField();
        txtUnit = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtQuantityBox = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        txtQuantityInBox = new javax.swing.JSpinner();
        lblProductImg = new javax.swing.JLabel();
        btnInsert = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        txtPrice = new javax.swing.JTextField();
        myLable4 = new CustomSwing.MyLable();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtNote = new javax.swing.JTextArea();
        btnDelete1 = new javax.swing.JButton();
        txtSearch = new CustomSwing.MyTextField();
        lblTotalMoney = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        lblTitleProduct1 = new javax.swing.JLabel();
        lblTotal1 = new javax.swing.JLabel();
        txtPay = new CustomSwing.MyTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Quản lý nhập hàng");

        spProduct.setVerticalScrollBar(new ScrollBarCustom(12));

        tblProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Mã SP", "Tên SP"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
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
        }

        lblTitleProduct.setBackground(new java.awt.Color(163, 172, 168));
        lblTitleProduct.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        lblTitleProduct.setForeground(new java.awt.Color(255, 102, 102));
        lblTitleProduct.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitleProduct.setText("Danh sách sản phẩm");
        lblTitleProduct.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        btnImportProduct.setBackground(new java.awt.Color(8, 129, 91));
        btnImportProduct.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        btnImportProduct.setForeground(new java.awt.Color(255, 255, 255));
        btnImportProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/check-mark.png"))); // NOI18N
        btnImportProduct.setText("Nhập hàng");
        btnImportProduct.setIconTextGap(12);
        btnImportProduct.setPreferredSize(new java.awt.Dimension(135, 35));
        btnImportProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportProductActionPerformed(evt);
            }
        });

        pnlDetailProduct.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlDetailProduct.setForeground(new java.awt.Color(255, 102, 102));

        myLable1.setText("Mã SP:");

        myLable2.setText("Tên SP:");

        myLable3.setText("Đơn vị tính:");

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel4.setText("Ngày sản xuất");

        jdcManufacturingDate.setDate(new java.util.Date(1679212547000L));
        jdcManufacturingDate.setDateFormatString("dd-MM-yyyy");
        jdcManufacturingDate.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel6.setText("Hạn sử dụng");

        jdcExpiryDate.setDate(new java.util.Date(1679212547000L));
        jdcExpiryDate.setDateFormatString("dd-MM-yyyy");
        jdcExpiryDate.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

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
        jLabel5.setText("Số lượng thùng");

        txtQuantityBox.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtQuantityBox.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10000, 1));
        txtQuantityBox.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                txtQuantityBoxStateChanged(evt);
            }
        });
        txtQuantityBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtQuantityBoxMouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel7.setText("Số lượng trong thùng");

        txtQuantityInBox.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N

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

        txtPrice.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        txtPrice.setDisabledTextColor(new java.awt.Color(0, 51, 204));

        myLable4.setText("Đơn giá SP (VND):");

        jLabel8.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel8.setText("Ghi chú hóa đơn:");

        txtNote.setColumns(20);
        txtNote.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtNote.setRows(5);
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

        javax.swing.GroupLayout pnlDetailProductLayout = new javax.swing.GroupLayout(pnlDetailProduct);
        pnlDetailProduct.setLayout(pnlDetailProductLayout);
        pnlDetailProductLayout.setHorizontalGroup(
            pnlDetailProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetailProductLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDetailProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDetailProductLayout.createSequentialGroup()
                        .addComponent(jScrollPane3)
                        .addContainerGap())
                    .addComponent(jLabel8)
                    .addComponent(myLable1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlDetailProductLayout.createSequentialGroup()
                        .addGroup(pnlDetailProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(myLable2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtProductID, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtProductName, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(myLable3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlDetailProductLayout.createSequentialGroup()
                                .addComponent(jdcManufacturingDate, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jdcExpiryDate, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlDetailProductLayout.createSequentialGroup()
                                .addGroup(pnlDetailProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtQuantityBox, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(pnlDetailProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(pnlDetailProductLayout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(65, 65, 65))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDetailProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtQuantityInBox, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel7))))
                            .addComponent(myLable4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnlDetailProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlDetailProductLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(lblProductImg, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDetailProductLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlDetailProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnInsert, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                                    .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnDelete1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(22, 22, 22))))))
        );
        pnlDetailProductLayout.setVerticalGroup(
            pnlDetailProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetailProductLayout.createSequentialGroup()
                .addComponent(myLable1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(pnlDetailProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                        .addGroup(pnlDetailProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlDetailProductLayout.createSequentialGroup()
                                .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnlDetailProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jdcManufacturingDate, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jdcExpiryDate, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlDetailProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlDetailProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtQuantityBox, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtQuantityInBox, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8))
                    .addGroup(pnlDetailProductLayout.createSequentialGroup()
                        .addComponent(lblProductImg, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        lblTotal.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        lblTotal.setText("Tổng Tiền: ");
        lblTotal.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        lblTitleProduct1.setBackground(new java.awt.Color(163, 172, 168));
        lblTitleProduct1.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        lblTitleProduct1.setForeground(new java.awt.Color(255, 102, 102));
        lblTitleProduct1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitleProduct1.setText("Chi tiết Sản Phẩm");
        lblTitleProduct1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        lblTotal1.setBackground(new java.awt.Color(163, 172, 168));
        lblTotal1.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        lblTotal1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTotal1.setText("Thanh toán:");
        lblTotal1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        txtPay.setForeground(new java.awt.Color(0, 51, 204));
        txtPay.setHide("Tiền đã thanh toán...");
        txtPay.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPayFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPayFocusLost(evt);
            }
        });
        txtPay.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPayKeyReleased(evt);
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
                            .addComponent(spCart, javax.swing.GroupLayout.DEFAULT_SIZE, 734, Short.MAX_VALUE)
                            .addComponent(spProduct, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pnlDetailProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTitleProduct1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTotal1)
                                    .addComponent(lblTotal))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTotalMoney)
                                    .addComponent(txtPay, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnImportProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13)))
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
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTotal, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblTotalMoney))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblTotal1)
                                    .addComponent(txtPay, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btnImportProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnImportProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportProductActionPerformed
        handleImportBill();
    }//GEN-LAST:event_btnImportProductActionPerformed

    private void txtQuantityBoxStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_txtQuantityBoxStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQuantityBoxStateChanged

    private void txtQuantityBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtQuantityBoxMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQuantityBoxMouseClicked

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
        listP = pDAO.selectByKeyword(txtSearch.getText());
        for (int i = 0; i < tblCart.getRowCount(); i++) {
            for (Product product : listP) {
                if (product.getProductName().equalsIgnoreCase(String.valueOf(tblCart.getValueAt(i, 1)))) {
                    listP.remove(product);
                    break;
                }
            }
        }
        fillToTableTP(listP);
    }//GEN-LAST:event_txtSearchKeyReleased

    private void tblProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductMouseClicked
        if (!checkClickTable) {
            tblProduct.setRowSelectionAllowed(true);
            if (evt.getClickCount() == 2) {
                fillToForm(String.valueOf(tblProduct.getValueAt(tblProduct.getSelectedRow(), 0)));
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

    private void txtPayKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPayKeyReleased
        try {
            if (checkClickTable) {
                if (txtPay.getText().trim().length() > 0) {
                    double pay = Double.parseDouble(txtPay.getText());
                    if (pay < 0) {
                        String pri = txtPay.getText();
                        XDialogHelper.alert(this, 0, "Số tiền lớn hơn hoặc bằng 0 !");
                        txtPay.setText(pri.substring(0, pri.length() - 1));
                    } else if (pay > (totalMoney(tblCart) - importBill.getTotalPay())) {
                        String pri = txtPay.getText();
                        XDialogHelper.alert(this, 0, "Số tiền vượt quá số tiền còn nợ: " + String.valueOf(formatterVND.format((totalMoney(tblCart) - importBill.getTotalPay())) + " VND"));
                        txtPay.setText(pri.substring(0, pri.length() - 1));
                    }
                }
            } else {
                if (txtPay.getText().trim().length() > 0) {
                    double pay = Double.parseDouble(txtPay.getText());
                    if (pay < 0) {
                        String pri = txtPay.getText();
                        XDialogHelper.alert(this, 0, "Số tiền lớn hơn hoặc bằng 0 !");
                        txtPay.setText(pri.substring(0, pri.length() - 1));
                    } else if (pay > totalMoney(tblCart)) {
                        String pri = txtPay.getText();
                        XDialogHelper.alert(this, 0, "Số tiền vượt quá tổng tiền !");
                        txtPay.setText(pri.substring(0, pri.length() - 1));
                    }
                }
            }
        } catch (NumberFormatException e) {
            String pri = txtPay.getText();
            XDialogHelper.alert(this, 0, "Thanh toán phải là số lớn hơn hoặc bằng 0 !");
            txtPay.setText(pri.substring(0, pri.length() - 1));
        }
    }//GEN-LAST:event_txtPayKeyReleased

    private void txtPayFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPayFocusLost
        if (!checkClickTable) {
            if (txtPay.getText().trim().length() == 0) {
                txtPay.setText("0");
            }
        }
    }//GEN-LAST:event_txtPayFocusLost

    private void txtPayFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPayFocusGained
        txtPay.setText("");
    }//GEN-LAST:event_txtPayFocusGained

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
    private javax.swing.JButton btnImportProduct;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane3;
    private com.toedter.calendar.JDateChooser jdcExpiryDate;
    private com.toedter.calendar.JDateChooser jdcManufacturingDate;
    private javax.swing.JLabel lblProductImg;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTitleCart;
    private javax.swing.JLabel lblTitleProduct;
    private javax.swing.JLabel lblTitleProduct1;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblTotal1;
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
    private javax.swing.JTextArea txtNote;
    private CustomSwing.MyTextField txtPay;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtProductID;
    private javax.swing.JTextField txtProductName;
    private javax.swing.JSpinner txtQuantityBox;
    private javax.swing.JSpinner txtQuantityInBox;
    private CustomSwing.MyTextField txtSearch;
    private javax.swing.JTextField txtUnit;
    // End of variables declaration//GEN-END:variables

    private void init() {
        listP = pDAO.selectAll();
        if (checkClickTable) {
            list = ibDDAO.selectByHD(importBill.getImportBillID());
            fillToTableCart(list);
            btnImportProduct.setText("Cập nhật");
        } else {
            txtPay.setEnabled(false);
            btnImportProduct.setText("Nhập hàng");
        }
        fillToTableTP(listP);
        BaseDAO.setTable(spProduct, tblProduct, false, 0);
        BaseDAO.setTable(spCart, tblCart, false, 0, 2);
        spProduct.setViewportBorder(BorderFactory.createEmptyBorder());
        spCart.setViewportBorder(BorderFactory.createEmptyBorder());
        btnDelete.setEnabled(false);
        btnUpdate.setEnabled(false);
        btnInsert.setEnabled(false);
        txtPrice.setEnabled(false);
        txtQuantityBox.setEnabled(false);
        txtQuantityInBox.setEnabled(false);
        jdcExpiryDate.setEnabled(false);
        jdcManufacturingDate.setEnabled(false);
        btnImportProduct.setEnabled(checkClickTable);
        txtNote.setEnabled(checkClickTable);
        txtSearch.setBorder(BorderFactory.createEmptyBorder(1, 6, 1, 6));
        txtPay.setBorder(BorderFactory.createEmptyBorder(1, 6, 1, 6));
        txtQuantityBox.setForeground(Color.BLUE);
        txtQuantityInBox.setForeground(Color.BLUE);
        Image IconApp = new ImageIcon(this.getClass().getResource("/Image/invoice.png")).getImage();
        if (IconApp != null) {
            this.setIconImage(IconApp);
        }
    }

    public void fillToTableTP(List<Product> listProduct) {
        DefaultTableModel model = (DefaultTableModel) tblProduct.getModel();
        model.setRowCount(0);
        if (listProduct != null) {
            for (Product p : listProduct) {
                Object[] row = {
                    p.getProductID(),
                    p.getProductName()
                };
                model.addRow(row);
            }
        }
        tblProduct.setModel(model);
    }

    public void fillToTableCart(List<ImportBilldetails> listI) {
        DefaultTableModel model = (DefaultTableModel) tblCart.getModel();
        model.setRowCount(0);
        int i = 0;
        if (listI != null) {
            for (ImportBilldetails importBilldetails : listI) {
                i += 1;
                importBilldetails.setImportBillDetailsID(i);
                Object[] row = {
                    importBilldetails.getImportBillDetailsID(),
                    pDAO.selectById(importBilldetails.getProductID()).getProductName(),
                    importBilldetails.getTotalQuantity(),
                    importBilldetails.getTotalAmount(),
                    importBilldetails.getIntoMoney()
                };
                model.addRow(row);
            }
        }
        tblCart.setModel(model);
        lblTotalMoney.setText(String.valueOf(formatterVND.format(totalMoney(tblCart))) + " VND");
        btnImportProduct.setEnabled(tblCart.getRowCount() > 0);
        if(totalMoney(tblCart)>0){
            txtPay.setEnabled(true);
        }
        if (checkClickTable) {
            txtNote.setText(importBill.getNote());
            txtPay.setHide("Còn nợ: " +String.valueOf(formatterVND.format(totalMoney(tblCart)-importBill.getTotalPay())) + " VND");
        }
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
        clearForm();
        Product p = pDAO.selectById(idProduct);
        txtProductID.setText(p.getProductID());
        txtProductName.setText(p.getProductName());
        txtUnit.setText(uDAO.selectByIds(p.getUnit()).getUnitName());
        lblProductImg.setIcon(XShareHelper.scaledImage(p.getImageProduct(), lblProductImg));
        btnInsert.setEnabled(true);
        txtPrice.setEnabled(true);
        txtQuantityBox.setEnabled(true);
        txtQuantityInBox.setEnabled(true);
        jdcExpiryDate.setEnabled(true);
        jdcManufacturingDate.setEnabled(true);
        txtNote.setEnabled(true);
    }

    private void fillToFormByCart() {
        for (ImportBilldetails i : list) {
            if (i.getImportBillID().equalsIgnoreCase(importBill.getImportBillID())
                    && i.getImportBillDetailsID() == Integer.parseInt(String.valueOf(tblCart.getValueAt(tblCart.getSelectedRow(), 0)))) {
                setForm(i);
                break;
            }
        }
    }

    private void setForm(ImportBilldetails d) {
        Product p = pDAO.selectById(d.getProductID());
        txtProductID.setText(p.getProductID());
        txtProductName.setText(p.getProductName());

        txtUnit.setText(uDAO.selectByIds(p.getUnit()).getUnitName());
        jdcManufacturingDate.setDate(XDateHelper.toDate(d.getManufacturingDate()));
        jdcExpiryDate.setDate(XDateHelper.toDate(d.getExpiryDate()));

        txtQuantityBox.setValue(Integer.valueOf(d.getQuantityBox() + ""));
        txtQuantityInBox.setValue(Integer.valueOf(d.getQuantityInBox() + ""));
        txtPrice.setText(d.getTotalAmount() + "");
        Product pd = pDAO.selectById(d.getProductID());
        if (pd.getImageProduct() != null) {
            lblProductImg.setToolTipText(pd.getImageProduct());
            lblProductImg.setIcon(XShareHelper.scaledImage(pd.getImageProduct(), lblProductImg));
        }
        btnDelete.setEnabled(!checkClickTable);
        btnUpdate.setEnabled(!checkClickTable);
        btnInsert.setEnabled(false);
        txtPrice.setEnabled(!checkClickTable);
        txtQuantityBox.setEnabled(!checkClickTable);
        txtQuantityInBox.setEnabled(!checkClickTable);
        jdcExpiryDate.setEnabled(!checkClickTable);
        jdcManufacturingDate.setEnabled(!checkClickTable);
        txtNote.setEnabled(true);
    }

    private ImportBilldetails getForm() {
        ImportBilldetails ibD = new ImportBilldetails();

        int quantityInBox = Integer.parseInt(txtQuantityInBox.getValue().toString()),
                quantityBox = Integer.parseInt(txtQuantityBox.getValue().toString()),
                totalQuantity = quantityBox * quantityInBox;
        double totalAmount = Double.parseDouble(txtPrice.getText());
        ibD.setImportBillID(importBill.getImportBillID());
        ibD.setProductID(txtProductID.getText());
        ibD.setQuantityInBox(quantityInBox);
        ibD.setQuantityBox(quantityBox);
        ibD.setTotalAmount(totalAmount);
        ibD.setTotalQuantity(totalQuantity);
        ibD.setIntoMoney(Double.parseDouble(totalAmount * totalQuantity + ""));
        ibD.setManufacturingDate(XDateHelper.toString(jdcManufacturingDate.getDate(), "yyyyMMdd"));
        ibD.setExpiryDate(XDateHelper.toString(jdcExpiryDate.getDate(), "yyyyMMdd"));
        ibD.setNotes("");
        return ibD;
    }

    public void insert() {
        list.add(getForm());
        if (tblProduct.getRowCount() > 0) {
            for (int i = 0; i < listP.size(); i++) {
                if (txtProductID.getText().equalsIgnoreCase(listP.get(i).getProductID())) {
                    listP.remove(i);
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
            for (int i = 0; i < list.size(); i++) {
                if (txtProductID.getText().equalsIgnoreCase(list.get(i).getProductID())) {
                    if (XDialogHelper.confirm(this, "Bạn có chắc là muốn xóa ?")) {
                        list.remove(i);
                        fillToTableCart(list);
                        clearForm();
                        XDialogHelper.alert(this, 1, "Xóa thành công !");

                        listP = pDAO.selectAll();
                        for (int ie = 0; ie < tblCart.getRowCount(); ie++) {
                            for (Product product : listP) {
                                if (product.getProductName().equalsIgnoreCase(String.valueOf(tblCart.getValueAt(ie, 1)))) {
                                    listP.remove(product);
                                    break;
                                }
                            }
                        }
                        fillToTableTP(listP);
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
        txtQuantityBox.setValue(0);
        txtQuantityInBox.setValue(0);
        lblProductImg.setIcon(null);
        jdcManufacturingDate.setDate(XDateHelper.nowDate());
        jdcExpiryDate.setDate(XDateHelper.addDays(XDateHelper.nowDate(), 120));
        btnDelete.setEnabled(false);
        btnUpdate.setEnabled(false);
        btnInsert.setEnabled(false);
        txtPrice.setEnabled(false);
        txtQuantityBox.setEnabled(false);
        txtQuantityInBox.setEnabled(false);
        jdcExpiryDate.setEnabled(false);
        jdcManufacturingDate.setEnabled(false);
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

        Date manu = jdcManufacturingDate.getDate();
        Date expi = jdcExpiryDate.getDate();

        if (manu.compareTo(XDateHelper.nowDate()) > 0) {
            XDialogHelper.alert(this, 0, "Ngày sản xuất phải nhỏ hơn ngày hiện tại !");
            jdcManufacturingDate.requestFocus();
            return false;
        }

        if (expi.compareTo(manu) < 0) {
            XDialogHelper.alert(this, 0, "HSD phải lớn hơn NSX !");
            return false;
        }

        try {
            int mount = Integer.parseInt(txtQuantityBox.getValue().toString());
            if (mount <= 0) {
                XDialogHelper.alert(this, 0, "Số lượng thùng phải là số nguyên lớn hơn 0 !");
                txtQuantityBox.requestFocus();
                return false;
            }
        } catch (NumberFormatException e) {
            XDialogHelper.alert(this, 0, "Số lượng thùng phải là số nguyên lớn hơn 0 !");
            txtQuantityBox.requestFocus();
            return false;
        }
        try {
            int mount = Integer.parseInt(txtQuantityInBox.getValue().toString());
            if (mount <= 0) {
                XDialogHelper.alert(this, 0, "Số lượng SP trong thùng phải là số nguyên lớn hơn 0 !");
                txtQuantityInBox.requestFocus();
                return false;
            }
        } catch (NumberFormatException e) {
            XDialogHelper.alert(this, 0, "Số lượng SP trong thùng phải là số nguyên lớn hơn 0 !");
            txtQuantityInBox.requestFocus();
            return false;
        }
        return true;
    }

    private void handleImportBill() {
        try {
            if (checkClickTable) {
                importBill.setNote(txtNote.getText());
                String pay = "".equals(txtPay.getText())? "0": txtPay.getText();
                if (!txtPay.getText().equals(String.valueOf(formatterVND.format(importBill.getTotalPay())) + " VND")) {
                    if ((importBill.getTotalPay() + Double.valueOf(pay)) == 0) {
                        importBill.setPayMentStatusID("3");
                    } else if ((importBill.getTotalPay() + Double.valueOf(pay)) < totalMoney(tblCart)) {
                        importBill.setPayMentStatusID("2");
                    } else {
                        importBill.setPayMentStatusID("1");
                    }
                    importBill.setTotalPay(importBill.getTotalPay() + Double.valueOf(pay));
                }
                iBillDAO.update(importBill);
            } else {
                importBill.setNote(txtNote.getText());
                String pay = "".equals(txtPay.getText())?"0":txtPay.getText();
                importBill.setTotalPay(Double.valueOf(pay));
                if (Double.parseDouble(pay) == 0) {
                    importBill.setPayMentStatusID("3");
                } else if (Double.parseDouble(pay) < totalMoney(tblCart)) {
                    importBill.setPayMentStatusID("2");
                } else {
                    importBill.setPayMentStatusID("1");
                }
                iBillDAO.insert(importBill);
                for (ImportBilldetails ib : list) {
                    ibDDAO.insert(ib);
                }
                XDialogHelper.alert(this, 1, "Nhập hàng thành công !");

            }
            this.dispose();
        } catch (NumberFormatException e) {
            System.out.println(e);
            XDialogHelper.alert(this, 0, "Nhập hàng thất bại !");
        }
    }
}
