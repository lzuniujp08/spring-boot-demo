package com.lzugis.utils;

import com.lzugis.entity.City;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtil {

    public List<City> getFileContent(File excel) {
        List<City> cities = new ArrayList<>();
        if (excel.isFile() && excel.exists()) {
            try {
                String[] split = excel.getName().split("\\.");  //.是特殊字符，需要转义！！！！！
                Workbook wb = null;
                FileInputStream fis = new FileInputStream(excel);//文件流对象
                //根据文件后缀（xls/xlsx）进行判断
                if ( "xls".equals(split[1])){
                    wb = new HSSFWorkbook(fis);
                }else if ("xlsx".equals(split[1])){
                    wb = new XSSFWorkbook(fis);
                }else {
                    System.out.println("文件类型错误!");
                }

                //开始解析
                Sheet sheet = wb.getSheetAt(0);     //读取sheet 0

                int firstRowIndex = sheet.getFirstRowNum()+1;   //第一行是列名，所以不读
                int lastRowIndex = sheet.getLastRowNum();

                //遍历行
                for(int rIndex = firstRowIndex; rIndex <= lastRowIndex; rIndex++) {
                    Row row = sheet.getRow(rIndex);
                    if (row != null) {
                        int firstCellIndex = row.getFirstCellNum();
                        int lastCellIndex = row.getLastCellNum();
                        String[] values = new String[lastCellIndex];
                        for (int cIndex = firstCellIndex; cIndex < lastCellIndex; cIndex++) {   //遍历列
                            Cell cell = row.getCell(cIndex);
                            if (cell != null) {
                                values[cIndex] = cell.toString();
                            }
                        }
                        City city = new City(
                            (int) Double.parseDouble(values[1]),
                            values[0],
                            Double.parseDouble(values[2]),
                            Double.parseDouble(values[3]),
                            ""
                        );
                        cities.add(city);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return cities;
    }

    public static void main(String[] args) {
        ExcelUtil util = new ExcelUtil();
        File file = new File("D:\\code\\spring-boot-demo\\file\\capital.xls");
        List list = util.getFileContent(file);
        System.out.println(list);
    }
}
