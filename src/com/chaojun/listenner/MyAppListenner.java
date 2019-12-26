package com.chaojun.listenner;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.chaojun.flag.Flag;
import com.chaojun.flag.Flag2;
import com.chaojun.service.LoginService;
import com.chaojun.service.LoginServiceImpl;

public class MyAppListenner implements ServletContextListener{
	public LoginService ls=new LoginServiceImpl();
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		if(ls.creatTableCopa()==1&&ls.creatTableCopa10()==1) {
			System.out.println("建表添加字段初始化成功！");
		}else {
			System.out.println("建表添加字段初始化失败！");
		}
//		new Thread(new Flag()).start();
//		new Thread(new Flag2()).start();
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}
	
}
