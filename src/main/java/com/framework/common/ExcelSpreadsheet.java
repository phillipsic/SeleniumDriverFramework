/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.framework.common;

import com.framework.data.ExcelFile;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

/**
 *
 * @author IanPhillips
 */
public class ExcelSpreadsheet {

    static private HSSFSheet requiredWorksheet;
    private String filePathAndName;

    public ExcelSpreadsheet(ExcelFile excelConnectionDetails) throws FileNotFoundException, IOException {

        String current = System.getProperty("user.dir");
        this.filePathAndName = current + "/" + excelConnectionDetails.getFilename();

        FileInputStream fileInputStream = new FileInputStream(excelConnectionDetails.getFilename());
        HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
        HSSFSheet worksheet = workbook.getSheet(excelConnectionDetails.getSheetname());

        this.requiredWorksheet = worksheet;

    }

    public int getNumberOfExcelRows() throws IOException, InvalidFormatException {

        if (requiredWorksheet == null) {
            System.out.println("ERROR - sheet not found  : " + requiredWorksheet.getSheetName());
        }

        System.out.println("Number of rows detected : " + requiredWorksheet.getPhysicalNumberOfRows());
        return requiredWorksheet.getPhysicalNumberOfRows();
    }

    public int getNumberOfExcelColumns() throws IOException, InvalidFormatException {

        int numberOfCells = 0;
        Iterator rowIterator = requiredWorksheet.rowIterator();
        /**
         * Escape the header row *
         */
        if (rowIterator.hasNext()) {
            Row headerRow = (Row) rowIterator.next();
            //get the number of cells in the header row
            numberOfCells = headerRow.getPhysicalNumberOfCells();
        }
//        System.out.println("number of cells " + numberOfCells);
        return numberOfCells;
    }

    public List<String> getSpreadSheetAsArray() {

        List<String> cellValue = new ArrayList<String>();

// Iterate through each rows from first sheet
        Iterator<Row> rowIterator = requiredWorksheet.iterator();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();

            // For each row, iterate through each columns
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {

                Cell cell = cellIterator.next();

                switch (cell.getCellType()) {
                    case Cell.CELL_TYPE_BOOLEAN:
//                        System.out.print(cell.getBooleanCellValue() + "\t\t");
                        if (cell.getBooleanCellValue()) {
                            cellValue.add("TRUE");
                        } else {
                            cellValue.add("FALSE");
                        }

                        break;
                    case Cell.CELL_TYPE_NUMERIC:
//                        System.out.print(cell.getNumericCellValue() + "\t\t");

                        if (HSSFDateUtil.isCellDateFormatted(cell)) {
                            Format formatter = new SimpleDateFormat("yyyy-MM-dd");
                            String s = formatter.format(cell.getDateCellValue());
                            cellValue.add(s);
                        } else {
                            double value = cell.getNumericCellValue();
                            cellValue.add(Double.toString(value));
                        }

                        break;
                    case Cell.CELL_TYPE_STRING:
//                        System.out.print(cell.getStringCellValue() + "\t\t");
                        cellValue.add(cell.getStringCellValue());
                        break;
                }
            }
//            System.out.println("");
        }
        return cellValue;
    }

}
