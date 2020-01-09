package com.chaojun.Servlet;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.json.JSONObject;

import com.chaojun.Utils.CreatJson;
import com.chaojun.flag.Flag;
import com.chaojun.pojo.Huanhuan;
import com.chaojun.pojo.Info;
import com.chaojun.pojo.KaoheTable;
import com.chaojun.pojo.NaturalInfo;
import com.chaojun.pojo.User;
import com.chaojun.pojo.User10;
import com.chaojun.service.LoginService;
import com.chaojun.service.LoginServiceImpl;
import com.mysql.cj.xdevapi.JsonArray;

/**
 * Servlet implementation class mainServlet
 */
@WebServlet("/main")
public class mainServlet extends HttpServlet {
	private Logger logger=Logger.getLogger(mainServlet.class);
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置请求编码格式
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		//设置响应编码格式
		resp.setContentType("application/json; charset=utf-8");
		
		long CODE=Integer.parseInt(req.getParameter("CODE"));
		System.out.println("编号为："+CODE);
		
		LoginService ls=new LoginServiceImpl();
		Info info=new Info();
		
		User u=ls.selByCODE(CODE);//newcopa查找犯人
		if(u!=null) {
			info.setSubtableid(u.getCODE()); //用id查基本信息
			info=ls.selByInfo(info);
		}
		
		
		User10 u2=ls.selByCODE10(CODE);
		if(u2!=null) {
			info.setSubtableid(u2.getCODE());
			info=ls.selByInfo(info);
		}
		Huanhuan h=ls.selId(CODE);
    	//根据info查两个表
		List<KaoheTable>  kaohe=ls.selByBianhao1(info);
		NaturalInfo naturalinfo=ls.selByBianhao2(info);
//		if(kaohe!=null) {
//			System.out.println(kaohe.toString());
//		}
//		if(naturalinfo!=null) {
//			System.out.println(naturalinfo.toString());
//		}
		
		//获取webapps的路径
		String path=req.getSession().getServletContext().getRealPath("");
//		System.out.println(path);
		if(u!=null &&u2!=null) {
			logger.debug("注意！"+u.getCODE()+"重复啦！");
		}
		if(u!=null) {
			//响应
			resp.getWriter().write(CreatJson.createJson(u,path,kaohe,naturalinfo));
			logger.debug("找到犯人，编号为："+u.getCODE());
			return;
		}else if(u2!=null){
			//响应
			resp.getWriter().write(CreatJson.createJson(u2,path,kaohe,naturalinfo));
			logger.debug("找到犯人，编号为："+u2.getCODE());
			return;
		}else if(h!=null){
			resp.getWriter().write(CreatJson.createJson(h, path));
			logger.debug("找到犯人，编号为："+h.编号);
			return;
		}else {
			//新的表查不到，试着查旧的表
			if(u==null){
				u=ls.selOldByCODE(CODE); 
				if(u!=null) {
					u=getMethod(u);
					info.setSubtableid(u.getCODE()); //用id查基本信息
					info=ls.selByInfo(info);
					kaohe=ls.selByBianhao1(info);
					naturalinfo=ls.selByBianhao2(info);
					resp.getWriter().write(CreatJson.createJson(u,path,kaohe,naturalinfo));
					ls.insertCopa(u);
					logger.debug("找到新犯人，更新表，编号为："+u.getCODE());
					return;
				}
			}
			//新的表查不到，试着查旧的表
			if(u2==null){
				u2=ls.selOld10ByCODE(CODE);
				if(u2!=null) {
					u2=getMethod(u2);
					if(u2!=null) {
						info.setSubtableid(u2.getCODE()); //用id查基本信息
						info=ls.selByInfo(info);
						kaohe=ls.selByBianhao1(info);
						naturalinfo=ls.selByBianhao2(info);
						resp.getWriter().write(CreatJson.createJson(u,path,kaohe,naturalinfo));
						ls.insertCopa10(u2);
						logger.debug("找到新犯人，更新表，编号为："+u2.getCODE());
						return;
					}
				}
			}
//			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
//			req.setAttribute("str", "没有这个犯人信息！");
//			req.getRequestDispatcher("/login").forward(req, resp);
			resp.getWriter().write(new JSONObject().put("state", 404).toString());
			logger.debug("找犯人编号"+CODE+"失败");
			return;
		}
	}
	public User getMethod(User u) {
		if(u.getL_S()>4 && u.getS_S()>3) {
			return u;
		}
		double []scorearr=Flag.read("/tmp/arr.txt");
		double[] biaozhunchaarr=Flag.read("/tmp/biaozhunchaarr.txt");
		double[] meanarr=Flag.read("/tmp/meanarr.txt");
		double [] value=new double[4];
		if(u.getPD4_S()>=scorearr[0]) {
			//list2.get(i)对象有冲动性标签,算分数 （x-mean）/标准差
			u.setChongdongScore((u.getPD4_S()-meanarr[0])/biaozhunchaarr[0]);
		}
		if(u.getPD8_S()>=scorearr[1]) {
			//list2.get(i)对象有冲动性标签,算分数 （x-mean）/标准差
			u.setGongqingScore((u.getPD8_S()-meanarr[1])/biaozhunchaarr[1]);
		}
		if(u.getPD12_S()>=scorearr[2]) {
			//list2.get(i)对象有冲动性标签,算分数 （x-mean）/标准差
			u.setRenzhiScore1((u.getPD12_S()-meanarr[2])/biaozhunchaarr[2]);
		}
		if(u.getPD13_S()>=scorearr[3]) {
			//list2.get(i)对象有冲动性标签,算分数 （x-mean）/标准差
			u.setRenzhiScore1((u.getPD13_S()-meanarr[3])/biaozhunchaarr[3]);
		}
		double []score=new double[4];
		score[0]=u.getChongdongScore();
		score[1]=u.getGongqingScore();
		score[2]=u.getRenzhiScore1();
		score[3]=u.getRenzhiScore2();
		double max=0;
		int maxIndex=0;
		for(int i=0;i<4;i++) {
			if(score[i]>max) {
				max=score[i];
				maxIndex=i;
			}
		}
		if(max!=0) {
			if(maxIndex==0) {
			u.setMethod("以情绪管理为主题的矫正策略");
		}else if(maxIndex==1) {
			u.setMethod("以培养共情心为核心的矫正策略");
		}else if(maxIndex==2 || maxIndex==3) {
			u.setMethod("以认知行为治疗为核心的矫正策略");
		}
		}else {
			u.setMethod("无");
		}
		return u;
	}
	public User10 getMethod(User10 u) {
		if(u.getL_S()>4 && u.getS_S()>3) {
			return u;
		}
		double []scorearr=Flag.read("/tmp/arr2.txt");
		double[] biaozhunchaarr=Flag.read("/tmp/biaozhunchaarr2.txt");
		double[] meanarr=Flag.read("/tmp/meanarr2.txt");
		double [] value=new double[4];
		if(u.getPD6_S()>=scorearr[0]) {
			//list2.get(i)对象有冲动性标签,算分数 （x-mean）/标准差
			u.setChongdongScore((u.getPD6_S()-meanarr[0])/biaozhunchaarr[0]);
		}
		if(u.getPD3_S()>=scorearr[1]) {
			//list2.get(i)对象有冲动性标签,算分数 （x-mean）/标准差
			u.setGongqingScore((u.getPD3_S()-meanarr[1])/biaozhunchaarr[1]);
		}
		if(u.getPD11_S()>=scorearr[2]) {
			//list2.get(i)对象有冲动性标签,算分数 （x-mean）/标准差
			u.setRenzhiScore1((u.getPD11_S()-meanarr[2])/biaozhunchaarr[2]);
		}
		if(u.getPD12_S()>=scorearr[3]) {
			//list2.get(i)对象有冲动性标签,算分数 （x-mean）/标准差
			u.setRenzhiScore1((u.getPD12_S()-meanarr[3])/biaozhunchaarr[3]);
		}
		double []score=new double[4];
		score[0]=u.getChongdongScore();
		score[1]=u.getGongqingScore();
		score[2]=u.getRenzhiScore1();
		score[3]=u.getRenzhiScore2();
		double max=0;
		int maxIndex=0;
		for(int i=0;i<4;i++) {
			if(score[i]>max) {
				max=score[i];
				maxIndex=i;
			}
		}
		if(max!=0) {
			if(maxIndex==0) {
			u.setMethod("以情绪管理为主题的矫正策略");
		}else if(maxIndex==1) {
			u.setMethod("以培养共情心为核心的矫正策略");
		}else if(maxIndex==2 || maxIndex==3) {
			u.setMethod("以认知行为治疗为核心的矫正策略");
		}
		}else {
			u.setMethod("无");
		}
		return u;
	}
}
