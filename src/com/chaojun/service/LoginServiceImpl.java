package com.chaojun.service;

import java.util.List;
import java.util.Set;

import com.chaojun.pojo.Huanhuan;
import com.chaojun.pojo.Info;
import com.chaojun.pojo.KaoheTable;
import com.chaojun.pojo.NaturalInfo;
import com.chaojun.pojo.User;
import com.chaojun.pojo.User10;

public class LoginServiceImpl implements LoginService{
	//创建Dao层过度项
	LoginDao ld=new LoginDaoImpl();
	@Override
	public User selByCODE(long CODE) {
		// TODO Auto-generated method stub
		return ld.selByCODE(CODE);
	}
	@Override
	public List<User> selAll() {
		// TODO Auto-generated method stub
		return ld.selAll();
	}
	@Override
	public int updataOne(User u) {
		// TODO Auto-generated method stub
		return ld.updataOne(u);
	}
	@Override
	public User10 selByCODE10(long CODE) {
		// TODO Auto-generated method stub
		return ld.selByCODE10(CODE);
	}
	@Override
	public List<User10> selAll10() {
		// TODO Auto-generated method stub
		return ld.selAll10();
	}
	@Override
	public int updataOne10(User10 u) {
		// TODO Auto-generated method stub
		return ld.updataOne10(u);
	}
	@Override
	public Info selByInfo(Info info) {
		// TODO Auto-generated method stub
		return ld.selByInfo(info);
	}
	@Override
	public List<KaoheTable> selByBianhao1(Info info) {
		// TODO Auto-generated method stub
		return ld.selByBianhao1(info);
	}
	@Override
	public NaturalInfo selByBianhao2(Info info) {
		// TODO Auto-generated method stub
		return ld.selByBianhao2(info);
	}
	@Override
	public Set selIds() {
		// TODO Auto-generated method stub
		return ld.selIds();
	}
	@Override
	public Huanhuan selId(long CODE) {
		// TODO Auto-generated method stub
		return ld.selId(CODE);
	}
	public static void main(String[] args) {
		LoginServiceImpl l=new LoginServiceImpl();
		l.selId(1);
	}
	@Override
	public int creatTableCopa() {
		// TODO Auto-generated method stub
		return ld.creatTableCopa();
	}
	@Override
	public int creatTableCopa10() {
		// TODO Auto-generated method stub
		return ld.creatTableCopa10();
	}
	@Override
	public User selOldByCODE(long CODE) {
		// TODO Auto-generated method stub
		return ld.selOldByCODE(CODE);
	}
	@Override
	public User10 selOld10ByCODE(long CODE) {
		// TODO Auto-generated method stub
		return ld.selByCODE10(CODE);
	}
	@Override
	public int insertCopa(User u) {
		// TODO Auto-generated method stub
		return ld.insertCopa(u);
	}
	@Override
	public int insertCopa10(User10 u) {
		// TODO Auto-generated method stub
		return ld.insertCopa10(u);
	}
}
