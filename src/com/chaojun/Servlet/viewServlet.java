package com.chaojun.Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chaojun.service.LoginService;
import com.chaojun.service.LoginServiceImpl;

/**
 * Servlet implementation class viewServlet
 */
@WebServlet("/view")
public class viewServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) 
    		throws ServletException, IOException {
    	//设置请求编码格式
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		//设置响应编码格式
		resp.setContentType("application/json; charset=utf-8");
		
		LoginService ls=new LoginServiceImpl();
		Set set=new HashSet();
		set=ls.selIds();
		Object[] list=new Object[set.size()];
		int i=0;
		for(Object obj:set) {
			list[i++]=obj;
		}
		resp.getWriter().write(Arrays.toString(list));
    }

}
