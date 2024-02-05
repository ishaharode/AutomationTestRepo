package com.webautomation.utils;

import java.io.*;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;

import org.apache.poi.xssf.usermodel.XSSFRow;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.openqa.selenium.By;

public class ExcelDriven  {

      XSSFWorkbook wb;

      XSSFSheet sheet;

      XSSFRow row;

      XSSFCell cell;

      FileInputStream fis;
      FileOutputStream out;
      public static String file;

    public ExcelDriven(String file) throws FileNotFoundException {
        this.file=file;
        fis = new FileInputStream(file);
    }


    public  String getCelldata(String file,int rownum,int col) throws IOException

    {
        fis = new FileInputStream(file);

        wb=new XSSFWorkbook(fis);

        sheet=wb.getSheetAt(0);

        row=sheet.getRow(rownum);

        cell=row.getCell(col);
        String s =cell.getStringCellValue();
        fis.close();
        return s;


    }

    public  void setCelldata(String file,String text,int rownum,int col) throws IOException

    {
        fis = new FileInputStream(file);
        wb=new XSSFWorkbook(fis);

        sheet=wb.getSheetAt(0);

        row=sheet.getRow(rownum);

        Cell cell = row.createCell(col);

        cell=row.getCell(col);

        cell.setCellValue(text);

        out = new FileOutputStream(new File(file));

        wb.write(out);
        out.close();

    }
    public int getRowCount() throws IOException {
        int rowCount=0;
        wb=new XSSFWorkbook(fis);

        sheet=wb.getSheetAt(0);

        rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum()+1;

        return rowCount;
    }

    public ArrayList<String> getColumnData(String file,int col) throws IOException {
        //fileInputStream argument
        ArrayList<String> a = new ArrayList<String>();
        fis = new FileInputStream(file);
        wb=new XSSFWorkbook(fis);
        sheet=wb.getSheetAt(0);
        int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum()+1;

        for (int i = 1; i < rowCount; i++) {

            Row row = sheet.getRow(i);

            a.add(row.getCell(col).getStringCellValue());

        }
        fis.close();
        return a;

    }

    public void cleanColumnData(String file,int col) throws IOException {
        fis = new FileInputStream(file);
        wb=new XSSFWorkbook(fis);
        sheet=wb.getSheetAt(0);
        int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum()+1;

        for (int i = 1; i < rowCount; i++) {
            Row row = sheet.getRow(i);
            Cell cell = row.getCell(col);
            if (cell != null) {
                cell.setCellValue(""); // Clear the cell value
            }
        }
        out = new FileOutputStream(new File(file));
        wb.write(out);

        fis.close();
        out.close();
        wb.close();

    }

}