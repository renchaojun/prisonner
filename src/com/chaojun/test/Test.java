package com.chaojun.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.chaojun.pojo.User;
import com.chaojun.service.LoginService;
import com.chaojun.service.LoginServiceImpl;

public class Test {
	
	public static void main(String[] args) throws IOException {
		LoginService ls=new LoginServiceImpl();
		User u = ls.selByCODE(70621);
		System.out.println(u);
		
		List<User> l=ls.selAll();
		System.out.println(l.size());
	}
}
