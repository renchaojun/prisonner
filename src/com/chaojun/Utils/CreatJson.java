package com.chaojun.Utils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

import com.chaojun.pojo.Huanhuan;
import com.chaojun.pojo.KaoheTable;
import com.chaojun.pojo.NaturalInfo;
import com.chaojun.pojo.User;
import com.chaojun.pojo.User10;

public class CreatJson {
	
	public static Map edu=new HashMap<String,String >();
	public static Map sex=new HashMap<String, String>();
	public static Map hunyin=new HashMap<String, String>();
	static {
		hunyin.put("10", "未婚");
		hunyin.put("20", "已婚");
		hunyin.put("21", "初婚");
		hunyin.put("22", "再婚");
		hunyin.put("23", "复婚");
		hunyin.put("30", "丧偶");
		hunyin.put("40", "离婚");
		hunyin.put("90", "未说明");
		sex.put("0", "未知性别");
		sex.put("1", "男");
		sex.put("2", "女");
		sex.put("3", "未说明性别");
		edu.put("11", "博士研究生毕业");
		edu.put("12", "博士研究生结业");
		edu.put("13", "博士研究生肄业");
		edu.put("14", "硕士研究生毕业");
		edu.put("15", "硕士研究生结业");
		edu.put("16", "硕士研究生肄业");
		edu.put("17", "研究生班");
		edu.put("18", "研究生班");
		edu.put("19", "研究生班");
		edu.put("20", "大学本科");
		edu.put("21", "大学本科");
		edu.put("22", "大学本科");
		edu.put("23", "大学本科");
		edu.put("28", "大学本科");
		edu.put("30", "大学专科");
		edu.put("31", "大学专科");
		edu.put("32", "大学专科");
		edu.put("33", "大学专科");
		edu.put("40", "中等职业教育");
		edu.put("91", "中等师范学校");
		edu.put("92", "中等师范学校");
		edu.put("93", "中等师范学校");
		edu.put("41", "中等专科");
		edu.put("44", "职业高中");
		edu.put("45", "职业高中");
		edu.put("46", "职业高中");
		edu.put("47", "技工学校");
		edu.put("48", "技工学校");
		edu.put("49", "技工学校");
		edu.put("60", "普通高中");
		edu.put("61", "普通高中");
		edu.put("62", "普通高中");
		edu.put("63", "普通高中");
		edu.put("70", "初中");
		edu.put("71", "初中");
		edu.put("73", "初中");
		edu.put("80", "小学");
		edu.put("81", "小学");
		edu.put("83", "小学");
		edu.put("90", "其他");
		edu.put("98", "半文盲");
		edu.put("99", "文盲");
	}
	public static String createJson(User u,String path,List<KaoheTable> kaohe,NaturalInfo natural) {
		JSONObject obj=new JSONObject();
		obj.put("method", u.getMethod());
		if(natural!=null) {
			//姓名，性别，出生日期，年龄，籍贯，婚姻状况，文化水平，罪名，方法
			if(natural.XM!=null) {
			obj.put("姓名",natural.XM);
			}else {obj.put("姓名","None");}
			
			obj.put("性别",sex.getOrDefault(natural.XB, "None"));
			
			if(natural.CSRQ!=null)obj.put("出生日期",natural.CSRQ);else obj.put("出生日期","None");
			
			obj.put("年龄","None");
			obj.put("罪名","None");
			obj.put("籍贯","None");
			obj.put("文化水平",edu.getOrDefault(natural.BQWHCD, "None"));
			obj.put("婚姻状况",hunyin.getOrDefault(natural.HYZK, "None"));
		}else {
			obj.put("年龄","None");
			obj.put("罪名","None");
			obj.put("籍贯","None");
			obj.put("姓名","None");
			obj.put("性别","None");
			obj.put("出生日期","None");
			obj.put("婚姻状况","None");
			obj.put("文化水平","None");
		}
		if(u.getMethod().equals("以情绪管理为主题的矫正策略")) {
			try {
				obj.put("plan", CreatJson.getJson(path+"/impulsive/unit1.yaml"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(u.getMethod().equals("以培养共情心为核心的矫正策略")) {
			JSONObject []arr=new JSONObject[2];
			try {
				arr[0]= CreatJson.getJson(path+"/epathy/unit1.yaml");
				arr[1]= CreatJson.getJson(path+"/epathy/unit2.yaml");
			} catch (Exception e) {
				e.printStackTrace();
			}
			obj.put("plan", arr);
		}else if(u.getMethod().equals("以认知行为治疗为核心的矫正策略")) {
			
			try {
				obj.put("plan", CreatJson.getJson(path+"/recognition1/unit1.yaml"));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else 
//			if(u.getMethod().equals("无")||u.getMethod()==null){
			{
			obj.put("plan", "无");
			}
//			}
		return obj.toString();
	}
	public static String createJson(User10 u,String path,List<KaoheTable> kaohe,NaturalInfo natural){
		JSONObject obj=new JSONObject();
		obj.put("method", u.getMethod());
		if(natural!=null) {
			//姓名，性别，出生日期，年龄，籍贯，婚姻状况，文化水平，罪名，矫正策略，矫正方案
			if(natural.XM!=null) {
			obj.put("姓名",natural.XM);
			}else {obj.put("姓名","None");}
			
			obj.put("性别",sex.getOrDefault(natural.XB, "None"));
			
			if(natural.CSRQ!=null)obj.put("出生日期",natural.CSRQ);else obj.put("出生日期","None");
			
			obj.put("年龄","None");
			obj.put("罪名","None");
			obj.put("籍贯","None");
			obj.put("文化水平",edu.getOrDefault(natural.BQWHCD, "None"));
			obj.put("婚姻状况",hunyin.getOrDefault(natural.HYZK, "None"));
		}else {
			obj.put("年龄","None");
			obj.put("罪名","None");
			obj.put("籍贯","None");
			obj.put("姓名","None");
			obj.put("性别","None");
			obj.put("出生日期","None");
			obj.put("婚姻状况","None");
			obj.put("文化水平","None");
		}
		if(u.getMethod().equals("以情绪管理为主题的矫正策略")) {
			try {
				obj.put("plan", CreatJson.getJson(path+"/impulsive/unit1.yaml"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(u.getMethod().equals("以培养共情心为核心的矫正策略")) {
			JSONObject []arr=new JSONObject[2];
			try {
				arr[0]= CreatJson.getJson(path+"/epathy/unit1.yaml");
				arr[1]= CreatJson.getJson(path+"/epathy/unit2.yaml");
			} catch (Exception e) {
				e.printStackTrace();
			}
			obj.put("plan", arr);
		}else if(u.getMethod().equals("以认知行为治疗为核心的矫正策略")) {
			
			try {
				obj.put("plan", CreatJson.getJson(path+"/recognition1/unit1.yaml"));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else 
//			if(u.getMethod().equals("无")||u.getMethod()==null){
			{
			obj.put("plan", "无");
			}
//			}
		return obj.toString();
	}
	public static JSONObject getJson(String filePath) throws Exception{
		InputStream is = new FileInputStream(filePath);
		StringBuffer buffer=new StringBuffer();
        String line; // 用来保存每行读取的内容
        BufferedReader reader = new BufferedReader(new InputStreamReader(is,"utf-8"));
        line = reader.readLine(); // 读取第一行
        while (line != null) { // 如果 line 为空说明读完了
            buffer.append(line); // 将读到的内容添加到 buffer 中
            buffer.append("\n"); // 添加换行符
            line = reader.readLine(); // 读取下一行
        }
        reader.close();
        is.close();
		String ymlStr=buffer.toString().replaceAll("“", "").replaceAll("”", "");
//		System.out.println(ymlStr);
//		DumperOptions doptions=new DumperOptions();
//		doptions.setAllowUnicode(false);
		Yaml yaml=new Yaml();
		Map<String, Object>map=(Map<String, Object>)yaml.load(ymlStr);
		JSONObject jsonObject=new JSONObject(map);
		return jsonObject;
	}
	public static String createJson(Huanhuan h,String path) {
		JSONObject obj=new JSONObject();
			obj.put("method",h.矫正策略);
			//姓名，性别，出生日期，年龄，籍贯，婚姻状况，文化水平，罪名，方法
			obj.put("姓名","None");
			obj.put("性别",h.性别);
			obj.put("出生日期", h.出生日期);
			obj.put("年龄",h.年龄);
			obj.put("罪名",h.罪名);
			obj.put("籍贯",h.籍贯);
			obj.put("文化水平",h.文化水平);
			obj.put("婚姻状况","None");
			if(h.矫正策略.equals("以情绪管理为主题的矫正策略")) {
				try {
					obj.put("plan", CreatJson.getJson(path+"/impulsive/unit1.yaml"));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if(h.矫正策略.equals("以培养共情心为核心的矫正策略")) {
				JSONObject []arr=new JSONObject[2];
				try {
					arr[0]= CreatJson.getJson(path+"/epathy/unit1.yaml");
//					System.out.println(arr[0]);
					arr[1]= CreatJson.getJson(path+"/epathy/unit2.yaml");
				} catch (Exception e) {
					e.printStackTrace();
				}
				obj.put("plan", arr);
			}else if(h.矫正策略.equals("以认知行为治疗为核心的矫正策略")) {
				try {
					obj.put("plan", CreatJson.getJson(path+"/recognition1/unit1.yaml"));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else {
				obj.put("plan", "无");
			}
			return obj.toString();
		}
	public static void main(String[] args) throws Exception {
//		User u =new User();
//		u.setMethod("以情绪管理为主题的矫正策略");
//		String s=CreatJson.createJson(u);
//		System.out.println(s);
		System.out.println(CreatJson.getJson("src/com/chaojun/Utils/recognition1/unit1.yaml"));
	}
}
