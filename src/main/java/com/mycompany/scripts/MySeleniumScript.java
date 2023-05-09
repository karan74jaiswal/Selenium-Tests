package com.mycompany.scripts;

import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class MySeleniumScript {
    public static void main(String[] args) throws Exception {
        // Create a new workbook
        XSSFWorkbook workbook = new XSSFWorkbook();

        // Create a new sheet in the workbook
        String sheetName = "Sheet1";
        workbook.createSheet(sheetName);

        // Create some data to write to the sheet
        String[] headers = {"Name", "Age", "Location"};
        String[][] data = {{"John", "25", "New York"},
                           {"Sarah", "32", "London"},
                           {"David", "41", "Sydney"}};

        // Write the data to the sheet
        int rowIndex = 0;
        Row headerRow = workbook.getSheet(sheetName).createRow(rowIndex++);
        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
        }

        for (int i = 0; i < data.length; i++) {
            Row row = workbook.getSheet(sheetName).createRow(rowIndex++);
            for (int j = 0; j < data[i].length; j++) {
                Cell cell = row.createCell(j);
                cell.setCellValue(data[i][j]);
            }
        }

        // Save the workbook to a file
        String fileName = "output.xlsx";
        FileOutputStream outputStream = new FileOutputStream(fileName);
        workbook.write(outputStream);
        outputStream.close();

        // Quit the browser
        // TODO: Replace with your actual Selenium script code
    }
}
