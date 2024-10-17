package com.utility;

import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtility {

    Workbook workbook;
    Sheet sheet;

    static  String sheetName = "Sheet1";
  static String filePath = "D:\\New folder\\SFASheet.xlsx";


    public ExcelUtility(String filepath,String sheetName){
        try{
            FileInputStream fis = new FileInputStream(filepath);
            workbook = WorkbookFactory.create(fis);
            sheet = workbook.getSheet(sheetName);

            if (sheet==null){
                System.out.println("SFA Automation Test Data Excel"+sheetName+"not found in file");

            }


        } catch (IOException  e) {

        }


    }

    public String getCellData(int rowIndex,int columnIndex){

        if(sheet==null){
            return "Sheet not loaded correctly";
        }

        DataFormatter dataFormatter = new DataFormatter();

        Row row = sheet.getRow(rowIndex);

        if (row == null || row.getCell(columnIndex) == null){

            return "cell not found";
        }
        return dataFormatter.formatCellValue(row.getCell(columnIndex));

    }

//    public String[][] getSheet data(){
//
//        int rowCount = sheet.getPhysicalNumberOfRows();
//        int columnCount = sheet.getRow(0).getPhysicalNumberOfCells();
//        String data[][] = new String[rowCount][columnCount];
//
//        DataFormatter = new DataFormatter();
//
//        for(int i=0;i<rowCount;i++){
//            Row row = sheet.getRow(i);
//            for (int j=0;j<columnCount;j++){
//                data[i][j] = dataFormatter.formatCellValue(row.getCell(j));
//            }
//        }
//        return data;
//    }

    public void close(){
        try{
            if (workbook!=null){
                workbook.close();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {


        ExcelUtility excelUtility = new ExcelUtility(filePath,sheetName);

        String username = excelUtility.getCellData(2,2);
        String password = excelUtility.getCellData(3,2);

        System.out.println("Extracted Data:");
        System.out.println("Username" +username);
        System.out.println("Password" +password);

        excelUtility.close();


    }



}


