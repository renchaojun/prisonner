package com.chaojun.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Id
 */
@WebServlet("/login")
public class loginServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		//设置响应编码格式
		resp.setContentType("text/html; charset=utf-8");
		
		String str=(String)req.getAttribute("str")==null?"":(String)req.getAttribute("str");
		resp.getWriter().write("<html>");
    	resp.getWriter().write("<head>");
    	resp.getWriter().write("</head>");
    	resp.getWriter().write("<body>");
    	//处理错误
    	resp.getWriter().write("<font color='red' size='20px'>"+str+"</font>");
    	resp.getWriter().write("<form action='main' method='get'>");
    	resp.getWriter().write("编号：<input type='text' name='CODE' value=''/><br/>");
    	resp.getWriter().write("<input type='submit' value='查找'/><br/>");
    	resp.getWriter().write("</form>");
    	resp.getWriter().write("</body>");
    	resp.getWriter().write("</html>");
	}

}
