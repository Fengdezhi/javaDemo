/**   
 * Copyright © 2018 重庆普天永惠大数据科技有限公司. All rights reserved.
 * 
 * @Package: pers.feng.javaDemo.excel 
 * @author: fengdezhi   
 * @date: 2018年8月20日 上午10:13:20 
 */
package pers.feng.javaDemo.excel;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import pers.feng.baseUtils.ExcelUtils;

/** 
 * @ClassName: HandleExcelDome 
 * @Description: TODO
 * @author: fengdezhi
 * @date: 2018年8月20日 上午10:13:20  
 */
public class HandleExcelDome {
	
	public static void main(String[] args) {
	  ExcelUtils eu = new ExcelUtils();  
        
      //从第一行开始读取  
      eu.setStartReadPos(0);
      //读取sheet2
      eu.setSelectedSheetIdx(1);
        
      String src_xlspath = "C:/Users/fengd/Desktop/管明生/快慢药.xlsx";  
     //String dist_xlsPath = "D:\\2.xls";  
      List<Row> rowList = null;  
      try {  
          rowList = eu.readExcel(src_xlspath);  
        //eu.writeExcel_xls(rowList, src_xlspath, dist_xlsPath);  
      } catch (IOException e) {  
          e.printStackTrace();  
      }  
      System.out.println(rowList.size());
      
      List<SheetTwo> list = Lists.newArrayList();  
      
      //封装到对象中
      System.out.println("封装到对象中");
      for(int i=1;i<rowList.size();i++){
    	  Row obj=rowList.get(i);
    	  SheetTwo two = new SheetTwo(ExcelUtils.getCellValue(obj.getCell(0)), ExcelUtils.getCellValue(obj.getCell(1)), 
    			  ExcelUtils.getCellValue(obj.getCell(2)), ExcelUtils.getCellValue(obj.getCell(3)), 
    			  ExcelUtils.getCellValue(obj.getCell(4)), ExcelUtils.getCellValue(obj.getCell(5)), 
    			  ExcelUtils.getCellValue(obj.getCell(6)), ExcelUtils.getCellValue(obj.getCell(7)), 
    			  ExcelUtils.getCellValue(obj.getCell(8)), ExcelUtils.getCellValue(obj.getCell(9)), 
    			  ExcelUtils.getCellValue(obj.getCell(10)), ExcelUtils.getCellValue(obj.getCell(11))); 
    	  list.add(two);
      }
      
      //筛选map, key = 姓名_样本类型   value SheetOne
      System.out.println("筛选map, key = 姓名_样本类型   value SheetOne");
      Map<String,SheetOne> map = Maps.newHashMap();
      
      for (SheetTwo two : list) {
    	  String key = String.format("%s_%s", two.get姓名(), two.get样本类型());
    	  
    	  SheetOne one = null;
    	  if (map.containsKey(key)) {
    		  one = map.get(key);
    	  }
    	  
    	  if (one == null) {//如果没有，新建一个
    		  one = InitSheetOne(two);
    	  }
    	  
    	  switch (two.get项目英文缩写()) {
    	  case "X-阴阳":
    		  one.setXpert阴阳性(two.get项目值());
    		  break;
    	  case "INH":
    		  one.set快速药敏INH(two.get项目值());
    		  break;
    	  case "TX1":
    		  one.set培养_TX_TX1(two.get项目值());
    		  break;
    	  case "TX":
    		  one.set培养_TX_TX1(two.get项目值());
    		  break;
    	  case "X-RFP":
    		  one.setXpert_RIF(two.get项目值());
    		  break;
    	  case "RIF":
    		  one.set快速药敏RIF(two.get项目值());
    		  break;
    		  
    	  default:
    		  break;
    	  }
    	  
    	  map.put(key, one); //存进去
      }
      
      // 处理map，如果满足5项都有值的数据有效
      System.out.println("处理map，如果满足5项都有值的数据有效");
      List<Row> resultList = Lists.newArrayList();
      for (Map.Entry<String, SheetOne> entry : map.entrySet()) {
    	  SheetOne one = entry.getValue();
    	  if (one.isEffective()){
    		  HSSFWorkbook workbook = new HSSFWorkbook();
    		  HSSFSheet sheet = workbook.createSheet("temp");// 创建工作表(Sheet)
    		  HSSFRow row = sheet.createRow(0);// 创建行,从0开始
//    		  病人号	姓名	性别	年龄	科室	检验者	病区	样本类型	临床诊断	培养（TX/TX1)	Xpert阴阳性	Xpert-RIF	快速药敏RIF	快速药敏INH	罗氏药敏RIF	罗氏药敏INH
    		  row.createCell(0).setCellValue(one.get病人号());
    		  row.createCell(1).setCellValue(one.get姓名());
    		  row.createCell(2).setCellValue(one.get性别());
    		  row.createCell(3).setCellValue(one.get年龄());
    		  row.createCell(4).setCellValue(one.get科室());
    		  row.createCell(5).setCellValue(one.get检验者());
    		  row.createCell(6).setCellValue(one.get病区());
    		  row.createCell(7).setCellValue(one.get样本类型());
    		  row.createCell(8).setCellValue(one.get临床诊断());
    		  row.createCell(9).setCellValue(one.get培养_TX_TX1());
    		  row.createCell(10).setCellValue(one.getXpert阴阳性());
    		  row.createCell(11).setCellValue(one.getXpert_RIF());
    		  row.createCell(12).setCellValue(one.get快速药敏RIF());
    		  row.createCell(13).setCellValue(one.get快速药敏INH());
    		  
    		  resultList.add(row);
    	  }
      }
 
      
      //写入excel
      System.out.println("写入excel");
      ExcelUtils write = new ExcelUtils();  
      write.setSelectedSheetIdx(0);
      write.setOverWrite(false);
      write.setNeedCompare(false); //不需作要重复比较
      try {
		write.writeExcel_xlsx(resultList, src_xlspath, src_xlspath);
	} catch (IOException e) {
		e.printStackTrace();
	}
	      
}  
	
	//初始化SheetOne
	protected static SheetOne InitSheetOne(SheetTwo two) {
		SheetOne one = new SheetOne();
		one.set病人号(two.get病人号());
		one.set姓名(two.get姓名());
		one.set性别(two.get性别());
		one.set年龄(two.get年龄());
		one.set科室(two.get科室());
		one.set检验者(two.get检验者());
		one.set病区(two.get病区());
		one.set样本类型(two.get样本类型());
		one.set临床诊断(two.get临床诊断());
		return one;
		
	}

}
