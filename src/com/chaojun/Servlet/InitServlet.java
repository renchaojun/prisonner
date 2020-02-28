package com.chaojun.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chaojun.flag.Flag;
import com.chaojun.flag.Flag2;
import com.chaojun.flag.FlagTotalData;

/**
 * Servlet implementation class InitServlet
 */
@WebServlet("/init")
public class InitServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		Flag.culflag();
//		Flag2.culflag();
		FlagTotalData.culflag();
		//设置请求编码格式
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		//设置响应编码格式
		resp.setContentType("text/html; charset=utf-8");
		resp.getWriter().write("初始化完成！");
	}

}
