/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.GroupLayout;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.DefaultIndexedColorMap;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author pc
 */
public class XExcelHelper {

    XSSFWorkbook workbook;

    private Font setFont(XSSFWorkbook workB, int size, boolean isBold) {
        Font fontCell = workB.createFont();
        fontCell.setBold(isBold);
        fontCell.setFontHeightInPoints((short) size);
        return fontCell;
    }

    private XSSFCellStyle setStyle(boolean isBold, boolean isAlighnmentCenter, int size, int... Rgb) {

        // Tạo kích thước chữ và in đậm cho hàng đầu tiên
        XSSFCellStyle CellStyle = workbook.createCellStyle();
        CellStyle.setFont(setFont(workbook, size, isBold));

        // đặt màu nền cho hàng đầu tiên    
        CellStyle.setFillForegroundColor(new XSSFColor(new byte[]{(byte) Rgb[0], (byte) Rgb[1], (byte) Rgb[2]}, new DefaultIndexedColorMap()));
        CellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        return borderCell(CellStyle, isAlighnmentCenter);
    }

    private XSSFCellStyle borderCell(XSSFCellStyle cell, boolean isAlignmentCenter) {
        if (isAlignmentCenter) {
            cell.setAlignment(HorizontalAlignment.CENTER);
        }
        cell.setBorderBottom(BorderStyle.THIN);
        cell.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        cell.setBorderLeft(BorderStyle.THIN);
        cell.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        cell.setBorderRight(BorderStyle.THIN);
        cell.setRightBorderColor(IndexedColors.BLACK.getIndex());
        cell.setBorderTop(BorderStyle.THIN);
        cell.setTopBorderColor(IndexedColors.BLACK.getIndex());
        return cell;
    }

    public void exportExcel(JFrame jframe, JTable table, String titleSheet, int rowDouble) {
        workbook = new XSSFWorkbook();
        // Tạo sheet mới với tên "Danh sách Sản Phẩm"
        XSSFSheet sheet = workbook.createSheet("Danh Sách " + titleSheet);

        // Lấy model của JTable
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        // Tạo header row
        XSSFRow headerRow = sheet.createRow(0);

        // Thêm cột STT vào sheet
        headerRow.createCell(0).setCellValue("STT");

        //tạo các cột tiêu đề và định dạng
        for (int i = 0; i < table.getColumnCount(); i++) {
            XSSFCell cell = headerRow.createCell(i + 1);
            cell.setCellValue(table.getColumnName(i));
            cell.setCellStyle(setStyle(true, true, 22, 165, 232, 106));
        }
        headerRow.getCell(0).setCellStyle(setStyle(true, true, 22, 165, 232, 106));

        // Ghi dữ liệu từ model của JTable sang sheet Excel
        for (int i = 0; i < model.getRowCount(); i++) {
            XSSFRow dataRow = sheet.createRow(i + 1);
            dataRow.createCell(1).setCellValue(model.getValueAt(i, 0).toString());
            dataRow.createCell(0).setCellValue(i + 1);
            for (int j = 0; j < model.getColumnCount(); j++) {
                XSSFCell cell = dataRow.createCell(j + 1);
                if (j == rowDouble) {
                    cell.setCellValue(Double.parseDouble(model.getValueAt(i, j).toString()));
                } else {
                    cell.setCellValue(model.getValueAt(i, j).toString());
                }
                cell.setCellStyle(setStyle(false, false, 14, 255, 255, 255));
            }
            dataRow.getCell(0).setCellStyle(setStyle(false, true, 14, 255, 255, 255));
        }

        // Bật autofit cho tất cả các cột
        for (int i = 0; i <= model.getColumnCount(); i++) {
            sheet.autoSizeColumn(i);
        }

        // Lưu file Excel
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Lưu file Excel");
        int userSelection = fileChooser.showSaveDialog(jframe);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            String filePath = fileToSave.getAbsolutePath() + ".xlsx";
            try {
                try ( FileOutputStream fileOut = new FileOutputStream(filePath)) {
                    workbook.write(fileOut);
                }
                JOptionPane.showMessageDialog(jframe, "Đã xuất file Excel thành công!\n Đường dẫn File: " + fileToSave);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(jframe, "Lỗi khi xuất file Excel!");
            }
        }
    }
}
