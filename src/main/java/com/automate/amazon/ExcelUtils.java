package com.automate.amazon;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class ExcelUtils {
    private static XSSFWorkbook workbook;
    private static XSSFSheet sheet;
    private static XSSFRow row;
    private static XSSFCell cell;
    public String filePath;


    public ExcelUtils(String filePath) {
        this.filePath = filePath;
    }

    public static String getCellData(int rowNumber, int cellNumber) {
        // getting the cell value from rowNumber and cell Number
        cell = sheet.getRow(rowNumber).getCell(cellNumber);

        // returning the cell value as string
        return cell.toString();

    }

    public void setExcelFile(String excelFilePath, String sheetName) throws Exception {
        // Create an object of File class to open xls file
        File file = new File(excelFilePath);

        // Create an object of FileInputStream class to read excel file
        FileInputStream inputStream = new FileInputStream(file);

        // creating workbook instance that refers to .xls file
        workbook = new XSSFWorkbook(inputStream);

        // creating a Sheet object
        sheet = workbook.getSheet(sheetName);

    }

    public int getRowCountInSheet() {
        int rowcount = sheet.getLastRowNum() - sheet.getFirstRowNum();
        return rowcount;
    }


}
