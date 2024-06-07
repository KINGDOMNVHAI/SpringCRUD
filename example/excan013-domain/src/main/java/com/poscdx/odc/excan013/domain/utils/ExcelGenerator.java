package com.poscdx.odc.excan013.domain.utils;

import com.poscdx.odc.excan013.domain.entity.ExcanCandidate;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;
import org.apache.poi.xssf.usermodel.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class ExcelGenerator {
    private List<ExcanCandidate> listCandidate;
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private final int rowStart = 0;

    public ExcelGenerator(List<ExcanCandidate> listCandidate) {
        this.listCandidate = listCandidate;
        this.workbook = new XSSFWorkbook();
    }

    private void setBordersToMergedCells(CellRangeAddress rangeAddress) {
        RegionUtil.setBorderTop(BorderStyle.THIN, rangeAddress, this.sheet);
        RegionUtil.setBorderLeft(BorderStyle.THIN, rangeAddress, this.sheet);
        RegionUtil.setBorderRight(BorderStyle.THIN, rangeAddress, this.sheet);
        RegionUtil.setBorderBottom(BorderStyle.THIN, rangeAddress, this.sheet);
    }

    private void setMerge(int numRow, int untilRow, int numCol, int untilCol, boolean border) {
        CellRangeAddress cellMerge = new CellRangeAddress(numRow, untilRow, numCol, untilCol);
        this.sheet.addMergedRegion(cellMerge);
        if (border) {
            setBordersToMergedCells(cellMerge);
        }
    }

    private CellStyle createCellStyle(short color, boolean isBold) {
        CellStyle style = this.workbook.createCellStyle();
        XSSFFont font = this.workbook.createFont();
        if (isBold) {
            font.setBold(true);
        }
        font.setFontHeight(11);
        style.setFont(font);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderRight(BorderStyle.THIN);
        style.setRightBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderTop(BorderStyle.THIN);
        style.setTopBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderLeft(BorderStyle.THIN);
        style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        style.setWrapText(true);
        style.setFillForegroundColor(color);
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        return style;
    }

    private CellStyle createCellStyle(int red, int blue, int green, boolean isBold) {
        XSSFCellStyle style = this.workbook.createCellStyle();
        XSSFColor color = new XSSFColor(new java.awt.Color(red, blue, green));
        style.setFillForegroundColor(color);
        style.setFillBackgroundColor(color);
        XSSFFont font = this.workbook.createFont();
        if (isBold) {
            font.setBold(true);
        }
        font.setFontHeight(11);
        style.setFont(font);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderRight(BorderStyle.THIN);
        style.setRightBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderTop(BorderStyle.THIN);
        style.setTopBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderLeft(BorderStyle.THIN);
        style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        style.setWrapText(true);
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        return style;
    }

    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        Cell cell = row.createCell(columnCount);
        if (value == null) {
            cell.setCellValue("");
        } else if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        } else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }

    private void writeHeaderLine() {
        this.sheet = this.workbook.createSheet("Candidate list");
        this.sheet.setColumnWidth(0, 9 * 256);
        this.sheet.setColumnWidth(1, 9 * 256);
        this.sheet.setColumnWidth(2, 16 * 256);
        this.sheet.setColumnWidth(3, 15 * 256);
        for (int i = 4; i < 8; i++) {
            this.sheet.setColumnWidth(i, 9 * 256);
        }
        this.sheet.setColumnWidth(8, 20 * 256);
        this.sheet.setColumnWidth(9, 15 * 256);
        this.sheet.setColumnWidth(10, 15 * 256);
        this.sheet.setColumnWidth(11, 12 * 256);
        this.sheet.setColumnWidth(12, 14 * 256);
        this.sheet.setColumnWidth(13, 23 * 256);
        this.sheet.setColumnWidth(14, 11 * 256);
        this.sheet.setColumnWidth(15, 17 * 256);
        this.sheet.setColumnWidth(16, 12 * 256);
        this.sheet.setColumnWidth(17, 13 * 256);
        this.sheet.setColumnWidth(18, 9 * 256);
        this.sheet.setColumnWidth(19, 9 * 256);

        CellStyle greenStyle = this.createCellStyle(198, 224, 180, true);
        CellStyle blueStyle = this.createCellStyle(217, 225, 242, true);
        CellStyle yellowStyle = this.createCellStyle(255, 242, 204, true);

        Row row1 = this.sheet.createRow(this.rowStart);
        createCell(row1, 0, "순번\nNo", greenStyle);
        createCell(row1, 1, "위치\nPosition", greenStyle);
        createCell(row1, 2, "부서\nDepartment", greenStyle);
        createCell(row1, 3, "원천\nSource", greenStyle);
        createCell(row1, 4, "지원자\nFull name", blueStyle);
        createCell(row1, 5, "연락처\nEmail", blueStyle);
        createCell(row1, 6, "전화 번호\nPhone number", blueStyle);
        createCell(row1, 7, "위치\nLocation", blueStyle);
        createCell(row1, 8, "대학\nUni", blueStyle);
        createCell(row1, 9, "경력년수\nYear of experience", blueStyle);
        createCell(row1, 10, "경험\nExperience", blueStyle);
        createCell(row1, 11, "기대한 급여\nExpect Salary", blueStyle);
        createCell(row1, 12, "시작일 예상\nExpect start day", blueStyle);
        createCell(row1, 13, "면접 일정\nInterview day", yellowStyle);
        createCell(row1, 14, "면접시간\nInterview time", yellowStyle);
        createCell(row1, 15, "면접관\nInterviewer", yellowStyle);
        createCell(row1, 16, "결과\nInterview Result", yellowStyle);
        createCell(row1, 17, "검사 결과\nTest result", yellowStyle);
        createCell(row1, 18, "결과\nResult", yellowStyle);
        createCell(row1, 19, "메모\nNote", yellowStyle);
    }

    private void writeDataLines() {
        int rowCount = this.rowStart + 1;
        CellStyle style = this.createCellStyle(IndexedColors.WHITE.getIndex(), false);
        int no = 1;
        for (ExcanCandidate item : this.listCandidate) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
            createCell(row, columnCount++, no++, style);
            createCell(row, columnCount++, item.getPositionName(), style);
            createCell(row, columnCount++, item.getDepartmentName(), style);
            createCell(row, columnCount++, item.getLinkRefer(), style);
            createCell(row, columnCount++, item.getName(), style);
            createCell(row, columnCount++, item.getEmail(), style);
            createCell(row, columnCount++, item.getPhone(), style);
            createCell(row, columnCount++, item.getAddress(), style);
            createCell(row, columnCount++, item.getUniversityName(), style);
            createCell(row, columnCount++, item.getYearOfExperienceName(), style);
            createCell(row, columnCount++, item.getSkill(), style);
            createCell(row, columnCount++, item.getExpectSalary(), style);
            createCell(row, columnCount++, item.getExpectStartDate(), style);
            String interviewDate = "";
            String interviewTime = "";
            if (item.getInterviewDate() != null) {
                DateFormat interviewDateFormat = new SimpleDateFormat("MM/dd/yyyy");
                DateFormat interviewTimeFormat = new SimpleDateFormat("hh:mm");
                interviewDate = interviewDateFormat.format(item.getInterviewDate());
                interviewTime = interviewTimeFormat.format(item.getInterviewDate());
            }
            createCell(row, columnCount++, interviewDate, style);
            createCell(row, columnCount++, interviewTime, style);
            createCell(row, columnCount++, item.getInterviewerName(), style);
            createCell(row, columnCount++, item.getInterviewResultName(), style);
            createCell(row, columnCount++, item.getScore(), style);
            createCell(row, columnCount++, null, style);
            createCell(row, columnCount, item.getDesc(), style);
        }
    }

    public void generateExcelFile(HttpServletResponse response) throws IOException {
        writeHeaderLine();
        writeDataLines();
        ServletOutputStream outputStream = response.getOutputStream();
        this.workbook.write(outputStream);
        this.workbook.close();
        outputStream.close();
    }
}
