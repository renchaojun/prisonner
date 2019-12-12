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
	public User selByCODE(long CODE) {
		SqlSession session = factory.openSession();
		User u=session.selectOne("a.b.selByCODE",CODE);
		if(u!=null) {
			session.commit();
		}else {
			session.rollback();
		}
		session.close();
		return u;
	}

	@Override
	public List<User> selAll() {
		SqlSession session = factory.openSession();
		
		List list=session.selectList("a.b.selAll");
		if(list!=null) {
			session.commit();
		}else {
			session.rollback();
		}
		session.close();
		return list;
	}

	@Override
	public int updataOne(User u) {
		SqlSession session = factory.openSession();
		int index=session.update("a.b.updataOne",u);
		if(index==1) {
			session.commit();
		}else {
			session.rollback();
		}
		session.close();
		return index;
	}

	@Override
	public User10 selByCODE10(long CODE) {
		SqlSession session = factory.openSession();
		User10 u=session.selectOne("a.b.selByCODE10",CODE);
		if(u!=null) {
			session.commit();
		}else {
			session.rollback();
		}
		session.close();
		return u;
	}

	@Override
	public List<User10> selAll10() {
		SqlSession session = factory.openSession();
		List list=session.selectList("a.b.selAll10");
		if(list!=null) {
			session.commit();
		}else {
			session.rollback();
		}
		session.close();
		return list;
	}

	@Override
	public int updataOne10(User10 u) {
		SqlSession session = factory.openSession();
		int index=session.update("a.b.updataOne10",u);
		if(index==1) {
			session.commit();
		}else {
			session.rollback();
		}
		session.close();
		return index;
	}

	@Override
	public Info selByInfo(Info info) {
		SqlSession session = factory.openSession();
		Info newInfo=session.selectOne("a.b.selByInfo",info);
		session.commit();
		session.close();
		return newInfo;
	}

	@Override
	public List<KaoheTable> selByBianhao1(Info info) {
		SqlSession session = factory.openSession();
		List<KaoheTable> people=session.selectList("a.b.selByBianhao1",info);
		session.commit();
		session.close();
		return people;
	}

	@Override
	public NaturalInfo selByBianhao2(Info info) {
		SqlSession session = factory.openSession();
		NaturalInfo people=session.selectOne("a.b.selByBianhao2",info);
		session.commit();
		session.close();
		return people;
	}

	@Override
	public Set selIds() {
		SqlSession session = factory.openSession();
		List list=session.selectList("a.b.selIds1");
		List list2=session.selectList("a.b.selIds1");
		session.commit();
		session.close();
		Set set=new HashSet(list);
		set.addAll(list2);
		return set;
	}

	@Override
	public Huanhuan selId(long CODE) {
		SqlSession session = factory.openSession();
		Huanhuan p=new Huanhuan();
		p.编号=CODE;
		p=session.selectOne("a.b.selId",p);
		session.commit();
		session.close();
		return p;
	}
	
}
