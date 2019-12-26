package com.chaojun.Utils;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.chaojun.pojo.UserFather;
import com.chaojun.service.Dao;

public class readExcel {
	public static Dao dao=new Dao();
	static XSSFRow row;
	public static void processExcel(String filePath,String type) {
//		UserFather u=null;
//		if(type=="baoli") {
//			u=new User1();
//		}
		File excelFile = null;
		InputStream is = null;// 输入流对象 
		excelFile = new File(filePath);  
		ArrayList<ArrayList<Object>>users=null;
		try {
			XSSFWorkbook workbook=new XSSFWorkbook(new FileInputStream(excelFile));
			XSSFSheet spreadsheet = workbook.getSheetAt(0);
		    Iterator< Row >rowIterator = spreadsheet.iterator();
		    users=new ArrayList<ArrayList<Object>>();
		    
		    while (rowIterator.hasNext()) {
		         row = (XSSFRow)rowIterator.next();
		         Iterator<Cell> cellIterator = row.cellIterator();
		         ArrayList<Object> list=new ArrayList();
		         int i=0;
		         while ( cellIterator.hasNext()) {
		            Cell cell = cellIterator.next();
		            switch (cell.getCellType()) {
		               case NUMERIC:
//		                  System.out.print(cell.getNumericCellValue() + " \t\t ");
		            	   list.add(cell.getNumericCellValue());
		            	   i++;
		                  break;
		               case STRING:
//		                  System.out.print(cell.getStringCellValue() + " \t\t ");
		            	   list.add(cell.getStringCellValue());
		            	   i++;
		                  break;
		            }
		         }
		         users.add(list);
		         System.out.println(i);
		         System.out.println(list);
		      }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//如果不存在就建表
		String jianbiao="create table if not exists prison.user1(监区 char(5) not null default '',编号 int unsigned not null primary key auto_increment ,姓名 char(4) not null default '',出生日期 char(10) not null default '0000-00-00',年龄 tinyint unsigned not null default 0,罪名 char(20) not null default '',ASPD_1 tinyint unsigned not null default 0,ASPD_2 tinyint unsigned not null default 0,ASPD_3 tinyint unsigned not null default 0,ASPD_4 tinyint unsigned not null default 0,ASPD_5 tinyint unsigned not null default 0,ASPD_6 tinyint unsigned not null default 0,ASPD_7 tinyint unsigned not null default 0,ASPD_8_1 tinyint unsigned not null default 0,ASPD_8_2 tinyint unsigned not null default 0,ASPD_8_3 tinyint unsigned not null default 0,ASPD_8_4 tinyint unsigned not null default 0,ASPD_8_5 tinyint unsigned not null default 0,ASPD_8_6 tinyint unsigned not null default 0,ASPD_8_7 tinyint unsigned not null default 0,ASPD_8_8 tinyint unsigned not null default 0,ASPD_8_9 tinyint unsigned not null default 0,ASPD_8_10 tinyint unsigned not null default 0,ASPD_8_11 tinyint unsigned not null default 0,ASPD_8_12 tinyint unsigned not null default 0,ASPD_8_13 tinyint unsigned not null default 0,ASPD_8_14 tinyint unsigned not null default 0,ASPD_8_15 tinyint unsigned not null default 0,LSRP_1 tinyint unsigned not null default 0,LSRP_2 tinyint unsigned not null default 0,LSRP_3 tinyint unsigned not null default 0,LSRP_4 tinyint unsigned not null default 0,LSRP_5 tinyint unsigned not null default 0,LSRP_6 tinyint unsigned not null default 0,LSRP_7 tinyint unsigned not null default 0,LSRP_8 tinyint unsigned not null default 0,LSRP_9 tinyint unsigned not null default 0,LSRP_10 tinyint unsigned not null default 0,LSRP_11 tinyint unsigned not null default 0,LSRP_12 tinyint unsigned not null default 0,LSRP_13 tinyint unsigned not null default 0,LSRP_14 tinyint unsigned not null default 0,LSRP_15 tinyint unsigned not null default 0,LSRP_16 tinyint unsigned not null default 0,LSRP_17 tinyint unsigned not null default 0,LSRP_18 tinyint unsigned not null default 0,LSRP_19 tinyint unsigned not null default 0,LSRP_20 tinyint unsigned not null default 0,LSRP_21 tinyint unsigned not null default 0,LSRP_22 tinyint unsigned not null default 0,LSRP_23 tinyint unsigned not null default 0,LSRP_24 tinyint unsigned not null default 0,LSRP_25 tinyint unsigned not null default 0,LSRP_26 tinyint unsigned not null default 0,BIS_1 tinyint unsigned not null default 0,BIS_2 tinyint unsigned not null default 0,BIS_3 tinyint unsigned not null default 0,BIS_4 tinyint unsigned not null default 0,BIS_5 tinyint unsigned not null default 0,BIS_6 tinyint unsigned not null default 0,BIS_7 tinyint unsigned not null default 0,BIS_8 tinyint unsigned not null default 0,BIS_9 tinyint unsigned not null default 0,BIS_10 tinyint unsigned not null default 0,BIS_11 tinyint unsigned not null default 0,BIS_12 tinyint unsigned not null default 0,BIS_13 tinyint unsigned not null default 0,BIS_14 tinyint unsigned not null default 0,BIS_15 tinyint unsigned not null default 0,BIS_16 tinyint unsigned not null default 0,BIS_17 tinyint unsigned not null default 0,BIS_18 tinyint unsigned not null default 0,BIS_19 tinyint unsigned not null default 0,BIS_20 tinyint unsigned not null default 0,BIS_21 tinyint unsigned not null default 0,BIS_22 tinyint unsigned not null default 0,BIS_23 tinyint unsigned not null default 0,BIS_24 tinyint unsigned not null default 0,BIS_25 tinyint unsigned not null default 0,BIS_26 tinyint unsigned not null default 0,IRI_1 tinyint unsigned not null default 0,IRI_2 tinyint unsigned not null default 0,IRI_3 tinyint unsigned not null default 0,IRI_4 tinyint unsigned not null default 0,IRI_5 tinyint unsigned not null default 0,IRI_6 tinyint unsigned not null default 0,IRI_7 tinyint unsigned not null default 0,IRI_8 tinyint unsigned not null default 0,IRI_9 tinyint unsigned not null default 0,IRI_10 tinyint unsigned not null default 0,IRI_11 tinyint unsigned not null default 0,IRI_12 tinyint unsigned not null default 0,IRI_13 tinyint unsigned not null default 0,IRI_14 tinyint unsigned not null default 0,IRI_15 tinyint unsigned not null default 0,IRI_16 tinyint unsigned not null default 0,IRI_17 tinyint unsigned not null default 0,IRI_18 tinyint unsigned not null default 0,IRI_19 tinyint unsigned not null default 0,IRI_20 tinyint unsigned not null default 0,IRI_21 tinyint unsigned not null default 0,IRI_22 tinyint unsigned not null default 0,IRI_23 tinyint unsigned not null default 0,IRI_24 tinyint unsigned not null default 0,IRI_25 tinyint unsigned not null default 0,IRI_26 tinyint unsigned not null default 0,IRI_27 tinyint unsigned not null default 0,IRI_28 tinyint unsigned not null default 0,IPAS_1 tinyint unsigned not null default 0,IPAS_2 tinyint unsigned not null default 0,IPAS_3 tinyint unsigned not null default 0,IPAS_4 tinyint unsigned not null default 0,IPAS_5 tinyint unsigned not null default 0,IPAS_6 tinyint unsigned not null default 0,IPAS_7 tinyint unsigned not null default 0,IPAS_8 tinyint unsigned not null default 0,IPAS_9 tinyint unsigned not null default 0,IPAS_10 tinyint unsigned not null default 0,IPAS_11 tinyint unsigned not null default 0,IPAS_12 tinyint unsigned not null default 0,IPAS_13 tinyint unsigned not null default 0,IPAS_14 tinyint unsigned not null default 0,IPAS_15 tinyint unsigned not null default 0,IPAS_16 tinyint unsigned not null default 0,IPAS_17 tinyint unsigned not null default 0,IPAS_18 tinyint unsigned not null default 0,IPAS_19 tinyint unsigned not null default 0,IPAS_20 tinyint unsigned not null default 0,EMBU_1_F tinyint unsigned not null default 0,EMBU_1_M tinyint unsigned not null default 0,EMBU_2_F tinyint unsigned not null default 0,EMBU_2_M tinyint unsigned not null default 0,EMBU_3_F tinyint unsigned not null default 0,EMBU_3_M tinyint unsigned not null default 0,EMBU_4_F tinyint unsigned not null default 0,EMBU_4_M tinyint unsigned not null default 0,EMBU_5_F tinyint unsigned not null default 0,EMBU_5_M tinyint unsigned not null default 0,EMBU_6_F tinyint unsigned not null default 0,EMBU_6_M tinyint unsigned not null default 0,EMBU_7_F tinyint unsigned not null default 0,EMBU_7_M tinyint unsigned not null default 0,EMBU_8_F tinyint unsigned not null default 0,EMBU_8_M tinyint unsigned not null default 0,EMBU_9_F tinyint unsigned not null default 0,EMBU_9_M tinyint unsigned not null default 0,EMBU_10_F tinyint unsigned not null default 0,EMBU_10_M tinyint unsigned not null default 0,EMBU_11_F tinyint unsigned not null default 0,EMBU_11_M tinyint unsigned not null default 0,EMBU_12_F tinyint unsigned not null default 0,EMBU_12_M tinyint unsigned not null default 0,EMBU_13_F tinyint unsigned not null default 0,EMBU_13_M tinyint unsigned not null default 0,EMBU_14_F tinyint unsigned not null default 0,EMBU_14_M tinyint unsigned not null default 0,EMBU_15_F tinyint unsigned not null default 0,EMBU_15_M tinyint unsigned not null default 0,EMBU_16_F tinyint unsigned not null default 0,EMBU_16_M tinyint unsigned not null default 0,EMBU_17_F tinyint unsigned not null default 0,EMBU_17_M tinyint unsigned not null default 0,EMBU_18_F tinyint unsigned not null default 0,EMBU_18_M tinyint unsigned not null default 0,EMBU_19_F tinyint unsigned not null default 0,EMBU_19_M tinyint unsigned not null default 0,EMBU_20_F tinyint unsigned not null default 0,EMBU_20_M tinyint unsigned not null default 0,EMBU_21_F tinyint unsigned not null default 0,EMBU_21_M tinyint unsigned not null default 0,DDTT_1 tinyint unsigned not null default 0,DDTT_2 tinyint unsigned not null default 0,DDTT_3 tinyint unsigned not null default 0,DDTT_4 tinyint unsigned not null default 0,DDTT_5 tinyint unsigned not null default 0,DDTT_6 tinyint unsigned not null default 0,DDTT_7 tinyint unsigned not null default 0,DDTT_8 tinyint unsigned not null default 0,DDTT_9 tinyint unsigned not null default 0,DDTT_10 tinyint unsigned not null default 0,DDTT_11 tinyint unsigned not null default 0,DDTT_12 tinyint unsigned not null default 0,DDTT_13 tinyint unsigned not null default 0,DDTT_14 tinyint unsigned not null default 0,DDTT_15 tinyint unsigned not null default 0,DDTT_16 tinyint unsigned not null default 0,DDTT_17 tinyint unsigned not null default 0,DDTT_18 tinyint unsigned not null default 0,DDTT_19 tinyint unsigned not null default 0,DDTT_20 tinyint unsigned not null default 0,DDTT_21 tinyint unsigned not null default 0,DDTT_22 tinyint unsigned not null default 0,DDTT_23 tinyint unsigned not null default 0,DDTT_24 tinyint unsigned not null default 0,DDTT_25 tinyint unsigned not null default 0,DDTT_26 tinyint unsigned not null default 0,DDTT_27 tinyint unsigned not null default 0,DDTT_28 tinyint unsigned not null default 0,DDTT_29 tinyint unsigned not null default 0,DDTT_30 tinyint unsigned not null default 0,DDTT_31 tinyint unsigned not null default 0,DDTT_32 tinyint unsigned not null default 0,CTQ_1 tinyint unsigned not null default 0,CTQ_2 tinyint unsigned not null default 0,CTQ_3 tinyint unsigned not null default 0,CTQ_4 tinyint unsigned not null default 0,CTQ_5 tinyint unsigned not null default 0,CTQ_6 tinyint unsigned not null default 0,CTQ_7 tinyint unsigned not null default 0,CTQ_8 tinyint unsigned not null default 0,CTQ_9 tinyint unsigned not null default 0,CTQ_10 tinyint unsigned not null default 0,CTQ_11 tinyint unsigned not null default 0,CTQ_12 tinyint unsigned not null default 0,CTQ_13 tinyint unsigned not null default 0,CTQ_14 tinyint unsigned not null default 0,CTQ_15 tinyint unsigned not null default 0,CTQ_16 tinyint unsigned not null default 0,CTQ_17 tinyint unsigned not null default 0,CTQ_18 tinyint unsigned not null default 0,CTQ_19 tinyint unsigned not null default 0,CTQ_20 tinyint unsigned not null default 0,CTQ_21 tinyint unsigned not null default 0,CTQ_22 tinyint unsigned not null default 0,CTQ_23 tinyint unsigned not null default 0,CTQ_24 tinyint unsigned not null default 0,CTQ_25 tinyint unsigned not null default 0,CTQ_26 tinyint unsigned not null default 0,CTQ_27 tinyint unsigned not null default 0,CTQ_28 tinyint unsigned not null default 0,CTQ_29 tinyint unsigned not null default 0,MCAA_1 tinyint unsigned not null default 0,MCAA_2 tinyint unsigned not null default 0,MCAA_3 tinyint unsigned not null default 0,MCAA_4 tinyint unsigned not null default 0,MCAA_5 tinyint unsigned not null default 0,MCAA_6 tinyint unsigned not null default 0,MCAA_7 tinyint unsigned not null default 0,MCAA_8 tinyint unsigned not null default 0,MCAA_9 tinyint unsigned not null default 0,MCAA_10 tinyint unsigned not null default 0,MCAA_11 tinyint unsigned not null default 0,MCAA_12 tinyint unsigned not null default 0,MCAA_13 tinyint unsigned not null default 0,MCAA_14 tinyint unsigned not null default 0,MCAA_15 tinyint unsigned not null default 0,MCAA_16 tinyint unsigned not null default 0,MCAA_17 tinyint unsigned not null default 0,MCAA_18 tinyint unsigned not null default 0,MCAA_19 tinyint unsigned not null default 0,MCAA_20 tinyint unsigned not null default 0,MCAA_21 tinyint unsigned not null default 0,MCAA_22 tinyint unsigned not null default 0,MCAA_23 tinyint unsigned not null default 0,MCAA_24 tinyint unsigned not null default 0,MCAA_25 tinyint unsigned not null default 0,MCAA_26 tinyint unsigned not null default 0,MCAA_27 tinyint unsigned not null default 0,MCAA_28 tinyint unsigned not null default 0,MCAA_29 tinyint unsigned not null default 0,MCAA_30 tinyint unsigned not null default 0,MCAA_31 tinyint unsigned not null default 0,MCAA_32 tinyint unsigned not null default 0,MCAA_33 tinyint unsigned not null default 0,MCAA_34 tinyint unsigned not null default 0,MCAA_35 tinyint unsigned not null default 0,MCAA_36 tinyint unsigned not null default 0,MCAA_37 tinyint unsigned not null default 0,MCAA_38 tinyint unsigned not null default 0,MCAA_39 tinyint unsigned not null default 0,MCAA_40 tinyint unsigned not null default 0,MCAA_41 tinyint unsigned not null default 0,MCAA_42 tinyint unsigned not null default 0,MCAA_43 tinyint unsigned not null default 0,MCAA_44 tinyint unsigned not null default 0,MCAA_45 tinyint unsigned not null default 0,MCAA_46 tinyint unsigned not null default 0,MCAA_F1_1 tinyint unsigned not null default 0,MCAA_F1_2 tinyint unsigned not null default 0,MCAA_F1_3 tinyint unsigned not null default 0,MCAA_F1_4 tinyint unsigned not null default 0,MCAA_F1_5 tinyint unsigned not null default 0,MCAA_F2_1 tinyint unsigned not null default 0,MCAA_F2_2 tinyint unsigned not null default 0,MCAA_F2_3 tinyint unsigned not null default 0,MCAA_F2_4 tinyint unsigned not null default 0,MCAA_F2_5 tinyint unsigned not null default 0,MCAA_F3_1 tinyint unsigned not null default 0,MCAA_F3_2 tinyint unsigned not null default 0,MCAA_F3_3 tinyint unsigned not null default 0,MCAA_F3_4 tinyint unsigned not null default 0,MCAA_F3_5 tinyint unsigned not null default 0,MCAA_F4_1 tinyint unsigned not null default 0,MCAA_F4_2 tinyint unsigned not null default 0,MCAA_F4_3 tinyint unsigned not null default 0,MCAA_F4_4 tinyint unsigned not null default 0,MCAA_F4_5 tinyint unsigned not null default 0,COPE_1 tinyint unsigned not null default 0,COPE_2 tinyint unsigned not null default 0,COPE_3 tinyint unsigned not null default 0,COPE_4 tinyint unsigned not null default 0,COPE_5 tinyint unsigned not null default 0,COPE_6 tinyint unsigned not null default 0,COPE_7 tinyint unsigned not null default 0,COPE_8 tinyint unsigned not null default 0,COPE_9 tinyint unsigned not null default 0,COPE_10 tinyint unsigned not null default 0,COPE_11 tinyint unsigned not null default 0,COPE_12 tinyint unsigned not null default 0,COPE_13 tinyint unsigned not null default 0,COPE_14 tinyint unsigned not null default 0,COPE_15 tinyint unsigned not null default 0,COPE_16 tinyint unsigned not null default 0,COPE_17 tinyint unsigned not null default 0,COPE_18 tinyint unsigned not null default 0,COPE_19 tinyint unsigned not null default 0,COPE_20 tinyint unsigned not null default 0,COPE_21 tinyint unsigned not null default 0,COPE_22 tinyint unsigned not null default 0,COPE_23 tinyint unsigned not null default 0,COPE_24 tinyint unsigned not null default 0,COPE_25 tinyint unsigned not null default 0,COPE_26 tinyint unsigned not null default 0,COPE_27 tinyint unsigned not null default 0,COPE_28 tinyint unsigned not null default 0, method char(30) not null default '',plan char(50) not null default '') charset utf8;";	
		dao.creatTableUser1(jianbiao);
		//查编号不在就插入这个数据
		for(int i=0;i<users.size();i++) {
			ArrayList<Object>list=users.get(i);
			int index=dao.chaFormTable((long)list.get(1));
			if(index==0) {
				//插入数据
			}
		}
	}
	public static void main(String[] args) {
//		readExcel.processExcel("/home/chaojun/桌面/工作簿1.xlsx", "baoli");
	}
}
