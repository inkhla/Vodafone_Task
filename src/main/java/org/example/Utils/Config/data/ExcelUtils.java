package org.example.Utils.Config.data;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
    static XSSFWorkbook wb;
    static XSSFSheet sheet;

    public ExcelUtils(String excelPAth, String sheetName){
        try{
            wb = new XSSFWorkbook(excelPAth);
            sheet = wb.getSheet(sheetName);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public int getRowCount(){
        int rowCount = 0;
        try{
            rowCount = sheet.getPhysicalNumberOfRows();
//            System.out.println("No of rows : " +rowCount);
        }catch (Exception exp){
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }
        return rowCount;
    }
    public void getCellDataNumber(int rowsNum, int colNum){
        try{
            double cellData = sheet.getRow(rowsNum).getCell(colNum).getNumericCellValue();
            System.out.println(cellData);
        }catch(Exception exp){
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }
    }

    public String getCellDataString(int rowNum, int colNum){
        String cellData = null ;
        try{
            cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
//            System.out.println(cellData);
        }catch(Exception exp){
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }
        return cellData;
    }
    public int getColCount(){
        int colCount = 0;
        try{
            colCount = sheet.getRow(0).getPhysicalNumberOfCells();
//            System.out.println("No of rows : " +colCount);
        }catch (Exception exp){
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }
        return colCount;
    }
}