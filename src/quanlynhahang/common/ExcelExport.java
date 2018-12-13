package quanlynhahang.common;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import quanlynhahang.models.viewmodels.HoaDonReport;
import quanlynhahang.models.viewmodels.MonAnVM;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ExcelExport {
    private static XSSFCellStyle createHSSFCellStyleForTitle(XSSFWorkbook workbook) {
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        XSSFCellStyle style = workbook.createCellStyle();
        style.setFont(font);
        return style;
    }

    public static void thongKeDoanhThuThang(ArrayList<HoaDonReport> hoaDons, String fileName) throws IOException {
        int rowNum = 0;
        Cell cell;
        Row row;
        double tongDonHang = 0;

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFCellStyle style = createHSSFCellStyleForTitle(workbook);

        XSSFSheet sheet = workbook.createSheet();
        for (HoaDonReport hoaDon : hoaDons) {
            // Thông tin hóa đơn
            row = sheet.createRow(rowNum);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("ID hóa đơn " + hoaDon.getMaHoaDon() + ". Email: " + hoaDon.getEmail() + ". Ngày thành toán: " + hoaDon.getThoiGian());
            cell.setCellStyle(style);

            // Thông tin chi tiết hóa đơn
            rowNum++;
            for (MonAnVM monAn : hoaDon.getMonAns()) {
                row = sheet.createRow(rowNum);
                // TenMonAn
                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue(monAn.getTenMonAn());

                // SoLuong
                cell = row.createCell(2, CellType.NUMERIC);
                cell.setCellValue(monAn.getSoLuong());

                // Gia
                cell = row.createCell(3, CellType.NUMERIC);
                cell.setCellValue(monAn.getGia());

                tongDonHang += monAn.getSoLuong() * monAn.getGia();
                rowNum++;
            }
            row = sheet.createRow(rowNum);
            cell = row.createCell(4, CellType.STRING);
            cell.setCellValue("Tổng tiền đơn hàng: " + tongDonHang);
            cell.setCellStyle(style);
            rowNum += 2;
        }

        String fullFileName = "F:/BK11_12/WebProjectV6/web/assests/content/document/" + fileName + ".xlsx";
        File saveFile = new File(fullFileName);

        FileOutputStream fout = new FileOutputStream(saveFile);
        workbook.write(fout);
        workbook.close();
        fout.close();
    }
}