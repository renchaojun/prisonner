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
import com.chaojun.pojo.TotalData;
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
		
		String CODE=req.getParameter("CODE");
		System.out.println("罪犯编号为："+CODE);
		
		LoginService ls=new LoginServiceImpl();
		TotalData u=ls.selByCODE(CODE+"");//newcopa查找犯人
		//获取webapps的路径
		String path=req.getSession().getServletContext().getRealPath("");
//		System.out.println(path);
		if(u!=null) {
			//响应
			resp.getWriter().write(CreatJson.createJson(u,path));
			logger.debug("找到犯人，编号为："+u.getZf_bh());
			return;
		}else {
			resp.getWriter().write(new JSONObject().put("state", 404).toString());
			logger.debug("找犯人编号"+CODE+"失败");
			return;
		}
	}

}
