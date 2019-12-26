package com.chaojun.service;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.chaojun.pojo.User10;

public class Dao {
	private static SqlSessionFactory factory=null;
	static {
		InputStream is=null;
		try {
			is = Resources.getResourceAsStream("mybatis.xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		factory= new SqlSessionFactoryBuilder().build(is);
		
	}
	//不存在就建新表
	public boolean creatTableUser1(String sql) {
		SqlSession session = factory.openSession();
		Connection cnn=session.getConnection();
		PreparedStatement ps=null;
		try {
			ps=cnn.prepareStatement(sql);
			ps.execute();
			session.commit();
		} catch (SQLException e) {
			session.rollback();
			return false;
		}
		return true;
	}
	//查这个人存在不存在
	public int chaFormTable(long CODE) {
		SqlSession session = factory.openSession();
		int num=session.selectOne("a.b.selByCODE",CODE);
		if(num!=0) {
			session.commit();
		}else {
			session.rollback();
		}
		session.close();
		return num;
	}
	
}
