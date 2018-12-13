package quanlynhahang.common;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.*;
import quanlynhahang.models.datamodels.DatBan;
import quanlynhahang.models.viewmodels.HoaDonReport;
import quanlynhahang.models.viewmodels.MonAnVM;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ExcelExport {
    private XSSFCellStyle createXSSFCellStyleForTitle(XSSFWorkbook workbook) {
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        XSSFCellStyle style = workbook.createCellStyle();
        style.setFont(font);
        return style;
    }

    public String thongKeDoanhThuThang(ArrayList<HoaDonReport> hoaDons, String fileName, String sheetName) throws IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        DecimalFormat df = new DecimalFormat("###,###.###");
        int rownum = 0;
        XSSFCell cell;
        XSSFRow row;

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFCellStyle style = createXSSFCellStyleForTitle(workbook);
        XSSFSheet sheet = workbook.createSheet(sheetName);

        row = sheet.createRow(rownum);
        cell = row.createCell(0, CellType.STRING);

        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeightInPoints((short) 25);
        XSSFCellStyle titleStyle = workbook.createCellStyle();
        titleStyle.setFont(font);

        cell.setCellStyle(titleStyle);
        cell.setCellValue(sheetName);

        rownum += 2;

        for (HoaDonReport hoaDon : hoaDons) {
            // Thông tin hóa đơn
            row = sheet.createRow(rownum);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("ID hóa đơn " + hoaDon.getMaHoaDon() + ". Email: " + hoaDon.getEmail() + ". Ngày thành toán: " + sdf.format(hoaDon.getThoiGian()));
            cell.setCellStyle(style);
            double tongDonHang = 0;
            rownum++;

            // Thông tin chi tiết hóa đơn
            for (MonAnVM monAn : hoaDon.getMonAns()) {
                row = sheet.createRow(rownum);
                // TenMonAn
                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue(monAn.getTenMonAn());

                // SoLuong
                cell = row.createCell(2, CellType.NUMERIC);
                cell.setCellValue(monAn.getSoLuong());

                // Gia
                cell = row.createCell(3, CellType.NUMERIC);
                cell.setCellValue(df.format(monAn.getGia()));

                tongDonHang += monAn.getGia();
                rownum++;
            }
            row = sheet.createRow(rownum);
            cell = row.createCell(4, CellType.STRING);
            cell.setCellValue("Tổng tiền đơn hàng: " + df.format(tongDonHang));
            cell.setCellStyle(style);
            rownum += 2;
        }

        String fullFileName = Consts.DOCUMENT_PATH + fileName + ".xlsx";
        File saveFile = new File(fullFileName);

        FileOutputStream fout = new FileOutputStream(saveFile);
        workbook.write(fout);
        workbook.close();
        fout.close();
        return fileName + ".xlsx";
    }

    public String thongKeDatBanTheoThang(ArrayList<DatBan> datBans, String fileName, String sheetName) throws IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        int rownum = 0;
        XSSFCell cell;
        XSSFRow row;

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet(sheetName);

        row = sheet.createRow(rownum);
        cell = row.createCell(0, CellType.STRING);

        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeightInPoints((short) 25);
        XSSFCellStyle titleStyle = workbook.createCellStyle();
        titleStyle.setFont(font);

        cell.setCellStyle(titleStyle);
        cell.setCellValue(sheetName);

        rownum += 2;
        row = sheet.createRow(rownum);

        // Set row header
        XSSFCellStyle headerStyle = createXSSFCellStyleForTitle(workbook);
        // Email
        cell = row.createCell(0, CellType.STRING);
        cell.setCellStyle(headerStyle);
        cell.setCellValue("Email");

        // ThoiGian
        cell = row.createCell(1, CellType.STRING);
        cell.setCellStyle(headerStyle);
        cell.setCellValue("Thời gian");

        // Ngay
        cell = row.createCell(2, CellType.STRING);
        cell.setCellStyle(headerStyle);
        cell.setCellValue("Ngày đặt");

        // SoLuongNguoi
        cell = row.createCell(3, CellType.NUMERIC);
        cell.setCellStyle(headerStyle);
        cell.setCellValue("Số lượng người");

        // GhiChu
        cell = row.createCell(4, CellType.STRING);
        cell.setCellStyle(headerStyle);
        cell.setCellValue("Ghi chú");

        // HoTen
        cell = row.createCell(5, CellType.STRING);
        cell.setCellStyle(headerStyle);
        cell.setCellValue("Tên người đặt");

        // DienThoai
        cell = row.createCell(6, CellType.STRING);
        cell.setCellStyle(headerStyle);
        cell.setCellValue("Số điện thoại");

        for (DatBan datBan : datBans) {
            row = sheet.createRow(++rownum);
            // Email
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue(datBan.getEmail());

            // ThoiGian
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue(datBan.getThoiGian());

            // Ngay
            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue(sdf.format(datBan.getNgay()));

            // SoLuongNguoi
            cell = row.createCell(3, CellType.NUMERIC);
            cell.setCellValue(datBan.getSoLuong());

            // GhiChu
            cell = row.createCell(4, CellType.STRING);
            cell.setCellValue(datBan.getGhiChu());

            // HoTen
            cell = row.createCell(5, CellType.STRING);
            cell.setCellValue(datBan.getHoTen());

            // DienThoai
            cell = row.createCell(6, CellType.STRING);
            cell.setCellValue(datBan.getSoDT());
        }
        String fullFileName = Consts.DOCUMENT_PATH + fileName + ".xlsx";
        File saveFile = new File(fullFileName);

        FileOutputStream fout = new FileOutputStream(saveFile);
        workbook.write(fout);
        workbook.close();
        fout.close();
        return fileName + ".xlsx";
    }
}