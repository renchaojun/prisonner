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
		
		User u=ls.selByCODE(CODE);
		if(u!=null) {
			info.setSubtableid(u.getCODE());
			info=ls.selByInfo(info);
		}
		User10 u2=ls.selByCODE10(CODE);
		if(u2!=null) {
			info.setSubtableid(u2.getCODE());
			info=ls.selByInfo(info);
		}
		Huanhuan h=ls.selId(CODE);
    	//根据info查两个表
		System.out.println();
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
		}
		else{
//			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
//			req.setAttribute("str", "没有这个犯人信息！");
//			req.getRequestDispatcher("/login").forward(req, resp);
			resp.getWriter().write(new JSONObject().put("state", 404).toString());
			logger.debug("找犯人编号"+CODE+"失败");
			return;
		}
	}
	
}
