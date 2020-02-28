package com.chaojun.service;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.chaojun.pojo.Huanhuan;
import com.chaojun.pojo.Info;
import com.chaojun.pojo.KaoheTable;
import com.chaojun.pojo.NaturalInfo;
import com.chaojun.pojo.TotalData;
import com.chaojun.pojo.User;
import com.chaojun.pojo.User10;
public class LoginDaoImpl<E> implements LoginDao{
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
	@Override
	public TotalData selByCODE(String CODE) {
		SqlSession session = factory.openSession();
		TotalData u=session.selectOne("total.data.selByCODE",CODE);
		if(u!=null) {
			session.commit();
		}else {
			session.rollback();
		}
		session.close();
		return u;
	}

	
	/*
	 * 下面操作全面的新的表
	 */
	public  List<TotalData> selAllByTotalDate(){
		SqlSession session = factory.openSession();
		List list=session.selectList("total.data.selAll");
		if(list!=null) {
			session.commit();
		}else {
			session.rollback();
		}
		session.close();
		return list;
	}

	@Override
	public int updataAData(TotalData u) {
		SqlSession session = factory.openSession();
		int index=session.update("total.data.updataOne",u);
		if(index==1) {
			session.commit();
		}else {
			session.rollback();
		}
		session.close();
		return index;
	}
}
