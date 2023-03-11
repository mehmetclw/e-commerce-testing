package com.ecommerce.utility.excel;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.poi.ss.usermodel.*;

import java.io.*;
import java.util.*;

/*
 * This is a utility class for reading from writing to Excel files.
 */
public class ExcelUtil {

    private Sheet workSheet;
    private Workbook workBook;
    private String path;

    public ExcelUtil(String path, String sheetName) {
        this.path = path;
        try {
            FileInputStream excelFile = new FileInputStream(path);
            workBook = WorkbookFactory.create(excelFile);
            workSheet = workBook.getSheet(sheetName);
            // Assert.assertNotNull(workSheet, String.format("Sheet: '%s' does not exist", sheetName));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //Get the data of specific cell
    public String getCellData(int rowNum, int colNum) {
        Cell cell;
        try {
            cell = workSheet.getRow(rowNum).getCell(colNum);
            String cellData = cell.toString();
            return cellData;
        } catch (Exception e) {
            //throw new RuntimeException(e);
            return null;
        }
    }

    //This method checking the text from first column only
    public Cell searchFirstColumnCellData(String text) {
        for (Row row : workSheet) {
            Cell cell = row.getCell(5);
            String cellValue = String.valueOf(cell.getCellType());
            System.out.println("cellValue = " + cellValue);
            if (cellValue.equalsIgnoreCase("NUMERIC")) {
                System.out.println("### " + cell.getNumericCellValue());
                if (text.equals(String.valueOf(cell.getNumericCellValue())))
                    return cell;
            } else {
                System.out.println(cell.getStringCellValue());
                if (text.equals(String.valueOf(cell.getStringCellValue())))
                    return cell;
            }
        }
        return null;
    }

    //This method will search the given text from entire sheet
    public Cell searchCellData(String text) {
        for (Row row : workSheet) {
            for (Cell cell : row) {
                String cellValue = String.valueOf(cell.getCellType());
                if (cellValue.equalsIgnoreCase("NUMERIC")) {
                    if (text.equals(String.valueOf(cell.getNumericCellValue())))
                        return cell;
                } else {
                    if (text.equals(cell.getStringCellValue()))
                        return cell;
                }
            }
        }
        return null;
    }

    public String[][] getDataArray() {
        String[][] data = new String[rowCount()][columnCount()];
        for (int i = 0; i < rowCount(); i++) {
            for (int j = 0; j < columnCount(); j++) {
                String value = getCellData(i, j);
                data[i][j] = value;
            }
        }
        return data;
    }

    /**
     * Get data as a List<Map<<String, String>>,
     * key => column name
     */
    public List<Map<String, String>> getDataList() {
        // get all columns
        List<String> columns = getColumnsNames();
        // this will be returned
        List<Map<String, String>> data = new ArrayList<>();

        for (int i = 1; i < rowCount(); i++) {
            // get each row
            Row row = workSheet.getRow(i);
            // create map of the row using the column and value
            // column map key, cell value --> map value
            Map<String, String> rowMap = new HashMap<>();
            for (Cell cell : row) {
                int columnIndex = cell.getColumnIndex();
                rowMap.put(columns.get(columnIndex), cell.toString());
            }
            data.add(rowMap);
        }
        return data;
    }

    // Get column names
    public List<String> getColumnsNames() {
        List<String> columns = new ArrayList<>();

        for (Cell cell : workSheet.getRow(0)) {
            columns.add(cell.toString());
        }
        return columns;
    }

    public int columnCount() {
        return workSheet.getRow(0).getLastCellNum();
    }

    public int rowCount() {
        return workSheet.getPhysicalNumberOfRows();
    }

    public List<String> getColumnData(int columnIndex) {
        // this will be returned
        List<String> data = new ArrayList<>();
        for (int i = 1; i < rowCount(); i++) {
            // get each row
            Cell cell = workSheet.getRow(i).getCell(columnIndex);
            data.add(cell.getStringCellValue());
        }
        return data;
    }

    public boolean isSheetExist(String sheetName) {
        for (Sheet sheet : workBook) {
            if (sheet.getSheetName().equals(sheetName)) {
                return true;
            }
        }
        return false;
    }

    public void close() {
        try {
            this.workBook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //CSV FILES
    public static boolean checkIf2CSVFilesAreSame(String csvFilePath1, String csvFilePath2) {

        List<String[]> allLines1 = null;
        List<String[]> allLines2 = null;
        try (CSVReader reader1 = new CSVReader(new FileReader(csvFilePath1));
             CSVReader reader2 = new CSVReader(new FileReader(csvFilePath2))) {
            allLines1 = reader1.readAll();
            allLines2 = reader2.readAll();
        } catch (FileNotFoundException e) {
            System.out.println("File is not found");
            e.printStackTrace();
        } catch (IOException | CsvException e) {
            System.out.println("No Line");
            e.printStackTrace();
        }
        if (allLines1.size() != allLines2.size()) return false;

        for (int i = 0; i < allLines1.size(); i++) {
            if (!Arrays.equals(allLines1.get(i), allLines2.get(i))) {
                System.out.println("Test Fail in Line:" + (i + 1));
                System.out.println("Expected:");
                System.out.println(Arrays.toString(allLines1.get(i)));
                System.out.println("Actual:");
                System.out.println(Arrays.toString(allLines2.get(i)));
                return false;
            }
        }
        return true;
    }

    public String getDataFromCSV(int rowNum, int columnNum, String path) {
        String csvData = "";
        try (CSVParser parser = new CSVParser(new FileReader(path), CSVFormat.DEFAULT)) {
            List<CSVRecord> list = parser.getRecords();
            csvData = list.get(rowNum).get(columnNum);
            System.out.println("Read data: " + csvData);
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return csvData;
    }

    //Read CSV file using OPENCSV
    public String readCSV(String searchValue, String path) {
        CSVReader reader = null;
        try {
            reader = new CSVReader(new BufferedReader(new FileReader(path)));
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                // nextLine[] is an array of values from the line
                if (nextLine[0].equals(searchValue)) {
                    return nextLine[1];
                }
            }
        } catch (Exception ignored) {
        }
        return null;
    }
}