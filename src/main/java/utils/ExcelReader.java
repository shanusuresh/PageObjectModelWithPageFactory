package utils;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;

public class ExcelReader {


    public static String[][] readFile(String sheetName) throws IOException, InvalidFormatException {

        /**
         * Workbook -> Sheets -> Row -> Column --> cells -->CEll value(STring, numeric, Formula,
         */
        //File stream
        File file = new File("src/main/resources/Testdata.xlsx");

        //Opening the workbook
        XSSFWorkbook workbook = new XSSFWorkbook(file);
//        XSSFSheet sheet = workbook.getSheetAt(0); -- Use index
        //If I want to use sheet name

        XSSFSheet sheet = workbook.getSheet(sheetName);
//        XSSFRow row = sheet.getRow(rowNum);
//        String cellData = row.getCell(colNum).getStringCellValue();

        int startRow = 1;
        int startCol = 1;

        //Get rows count
        int totalRows = sheet.getLastRowNum();
        //Get column count
        int totalCols = sheet.getRow(0).getLastCellNum();
        System.out.println("Total rows: " + totalRows);
        System.out.println("Total cols: " + totalCols);

        String[][] data = new String[totalRows][totalCols];
        /**
         * Loop through the rows
         */
        //i=1 coz first row is header
        for(int i=1;i<=totalRows;i++){
            //loop thro columns
            for(int j=0;j<totalCols;j++){
                String value= sheet.getRow(i).getCell(j).getStringCellValue();
                data[i-1][j]=value;
                System.out.println("Value is: "+value);

            }
        }
        workbook.close();
        return data;
    }
}
