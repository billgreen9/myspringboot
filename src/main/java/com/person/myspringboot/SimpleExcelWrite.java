package com.person.myspringboot;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SimpleExcelWrite{
    
    public static void main(String[] args) throws IOException {
        
        //第一步创建workbook  
        HSSFWorkbook wb = new HSSFWorkbook();  
          
        //第二步创建sheet  
        HSSFSheet sheet = wb.createSheet("测试");  
          
        //第三步创建行row:添加表头0行  
        HSSFRow row = sheet.createRow(0);  
        HSSFCellStyle  style = wb.createCellStyle();      
        //style.setAlignment(HSSFCellStyle.ALIGN_CENTER);  //居中  
          
          
        //第四步创建单元格  
        HSSFCell cell = row.createCell(0); //第一个单元格  
        cell.setCellValue("姓名");  
        cell.setCellStyle(style);  
        
        cell = row.createCell(1);         //第二个单元格     
        cell.setCellValue("年龄");  
        cell.setCellStyle(style);  
          
       
        //第五步插入数据  
       
        for (int i = 0; i < 5; i++) {  
            //创建行  
            row = sheet.createRow(i+1);  
            //创建单元格并且添加数据  
            row.createCell(0).setCellValue("aa"+i);  
            row.createCell(1).setCellValue(i);  
            
        }  
          
        //第六步将生成excel文件保存到指定路径下  
        try {  
            FileOutputStream fout = new FileOutputStream("d:\\a.xlsx");  
            wb.write(fout);  
            fout.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
          
        creat2007Excel();
        System.out.println("Excel文件生成成功...");  
    }  
    
    
    /**  
     * 创建2007版Excel文件  
     *   
     * @throws IOException  
     */  
    public static void creat2007Excel() throws IOException{  
        // HSSFWorkbook workBook = new HSSFWorkbook();// 创建 一个excel文档对象  
        XSSFWorkbook workBook = new XSSFWorkbook();  
        XSSFSheet sheet = workBook.createSheet();// 创建一个工作薄对象  
  
        XSSFRow row = sheet.createRow(0);// 创建一个行对象  
  
       XSSFCell cell = row.createCell(0);
       cell.setCellValue("hello");
       
       cell = row.createCell(1);
       cell.setCellValue(16);
  
      
  
        // 文件输出流  
  
        FileOutputStream os = new FileOutputStream("d:/style_2007.xlsx");  
  
        workBook.write(os);// 将文档对象写入文件输出流  
  
        os.close();// 关闭文件输出流
      
       
    }  
      

        
    }