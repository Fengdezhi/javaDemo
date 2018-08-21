package pers.feng.javaDemo.excel;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import pers.feng.baseUtils.ExcelUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ExcelToRedDome {

    public static void main(String[] args) {
        ExcelUtils eu = new ExcelUtils();

        //从第一行开始读取
        eu.setStartReadPos(0);
        //读取sheet1
        eu.setSelectedSheetIdx(0);

        String src_xlspath = "C:\\Users\\MACHENIKE\\Desktop\\管明生\\快慢药0.xlsx";

        List<Row> rowList = null;
        try {
            rowList = eu.readExcel(src_xlspath);
            //eu.writeExcel_xls(rowList, src_xlspath, dist_xlsPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Map<String,String> nameMap = Maps.newHashMap();

        //获取名字，存到map中
        for(int i=1;i<rowList.size();i++){
            Row obj=rowList.get(i);
            //取名字作为key
            String key = ExcelUtils.getCellValue(obj.getCell(1));
            nameMap.put(key,"随便");
        }

        //读取宁外一个文件
        String src_xlspath1 = "C:\\Users\\MACHENIKE\\Desktop\\管明生\\2016-2017汇总 (1).xls";

        ExcelUtils target = new ExcelUtils();

        //从第一行开始读取
        target.setStartReadPos(0);
        //读取sheet1
        target.setSelectedSheetIdx(0);


        List<Row> targetList = null;
        try {
            targetList = eu.readExcel(src_xlspath1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //创建单元格样式
        Workbook workbook = ExcelUtils.threadLocal.get();
        CellStyle cellStyle = workbook.createCellStyle();

        Font font = workbook.createFont();
        font.setColor(IndexedColors.RED.getIndex());    //红色
        cellStyle.setFont(font);

//        for (int i=1;i<targetList.size();i++) {
//            Row obj=targetList.get(i);
//
//            String isKey = ExcelUtils.getCellValue(obj.getCell(6));
//            if (nameMap.containsKey(isKey)) {
//                //设置单元格字体为红色
//                HSSFCell curCell = (HSSFCell)obj.getCell(6); //第7列
//                curCell.setCellStyle(cellStyle);
//            }
//        }

        //写入excel
        Sheet sheet = workbook.getSheetAt(0);
        int t = 0;//记录最新添加的行数
        for (Row row : targetList) {
            if (row == null) continue;
            // 判断是否已经存在该数据
            int pos = new ExcelUtils().findInExcel(sheet, row);

            Row r = null;// 如果数据行已经存在，则获取后重写，否则自动创建新行。
            if (pos >= 0) {
                sheet.removeRow(sheet.getRow(pos));
                r = sheet.createRow(pos);
            } else {
                r = sheet.createRow(0 + t++);
            }

            //用于设定单元格样式
//            CellStyle newstyle = workbook.createCellStyle();

            //循环为新行创建单元格
            for (int i = row.getFirstCellNum(); i < row.getLastCellNum(); i++) {
                Cell cell = r.createCell(i);// 获取数据类型
                cell.setCellValue(ExcelUtils.getCellValue(row.getCell(i)));// 复制单元格的值到新的单元格
                // cell.setCellStyle(row.getCell(i).getCellStyle());//出错
                if (row.getCell(i) == null) continue;
//              copyCellStyle(row.getCell(i).getCellStyle(), newstyle); // 获取原来的单元格样式
                if (i == 6) {
                    String isKey = ExcelUtils.getCellValue(row.getCell(i));
                    if (nameMap.containsKey(isKey)) {
                        //设置单元格字体为红色
                        cell.setCellStyle(cellStyle);
                    }
                }

                // sheet.autoSizeColumn(i);//自动跳转列宽度
            }
        }


        try {
            // 重新将数据写入Excel中
            FileOutputStream outputStream = new FileOutputStream(src_xlspath1);
            workbook.write(outputStream);
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
