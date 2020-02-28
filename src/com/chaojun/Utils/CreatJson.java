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
import com.chaojun.pojo.TotalData;
import com.chaojun.pojo.User;
import com.chaojun.pojo.User10;

public class CreatJson {
	public static String createJson(TotalData u,String path) {
		JSONObject obj=new JSONObject();
		obj.put("method", u.getMethod());
		if(u!=null) {
			//姓名，性别，出生日期，年龄，籍贯，婚姻状况，文化水平，罪名，方法
			obj.put("罪犯编号",u.getZf_bh());
			obj.put("罪犯服刑单位",u.getZffxdw());
			obj.put("罪犯姓名",u.getZfxm());
			obj.put("罪犯性别",u.getZfxb());
			obj.put("出生日期",u.getCsrq());
			obj.put("刑期",u.getXq());
			obj.put("犯罪次数",u.getFzcs());
			obj.put("文化程度",u.getWhcd());
			obj.put("犯罪类型",u.getFzlx());
			obj.put("捕前职业",u.getBqzy());
			obj.put("民族",u.getMz());
			obj.put("捕前政治面貌",u.getBqmm());
			obj.put("婚姻状况",u.getBqmm());
			obj.put("捕前职业类别",u.getBqmm());
			obj.put("捕前职级",u.getBqmm());
			obj.put("捕前职称",u.getBqzc());
			obj.put("所学专业",u.getSxzy());
			obj.put("特长",u.getTc());
			obj.put("宗教信仰",u.getZjxy());
			obj.put("党派团体",u.getDptt());
			obj.put("捕前职务",u.getBqzw());
			obj.put("说谎指标",u.getShzb());
			obj.put("同一性指标",u.getTyxzb());
			obj.put("内外倾",u.getNwq());
			obj.put("情绪稳定性",u.getQxwdx());
			obj.put("同众性",u.getTzx());
			obj.put("冲动性",u.getCdx());
			obj.put("攻击性",u.getGjx());
			obj.put("报复性",u.getBfx());
			obj.put("信任感",u.getXrg());
			obj.put("同情心",u.getTqx());
			obj.put("自信心",u.getZxx());
			obj.put("焦虑感",u.getJlg());
			obj.put("聪慧性",u.getChx());
			obj.put("心理变态倾向",u.getXlbtqx());
			obj.put("犯罪思维模式",u.getFzswms());
		}else {
			obj.put("状态","404");
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
	
	public static void main(String[] args) throws Exception {
//		User u =new User();
//		u.setMethod("以情绪管理为主题的矫正策略");
//		String s=CreatJson.createJson(u);
//		System.out.println(s);
		System.out.println(CreatJson.getJson("src/com/chaojun/Utils/recognition1/unit1.yaml"));
	}
}
