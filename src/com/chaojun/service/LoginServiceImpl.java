package com.chaojun.service;

import java.util.List;
import java.util.Set;

import com.chaojun.pojo.Huanhuan;
import com.chaojun.pojo.Info;
import com.chaojun.pojo.KaoheTable;
import com.chaojun.pojo.NaturalInfo;
import com.chaojun.pojo.TotalData;
import com.chaojun.pojo.User;
import com.chaojun.pojo.User10;

public class LoginServiceImpl implements LoginService{
	//创建Dao层过度项
	LoginDao ld=new LoginDaoImpl();
	@Override
	public TotalData selByCODE(String CODE) {
		// TODO Auto-generated method stub
		return ld.selByCODE(CODE);
	}
	
	/*
	 * 下面操作全面的新的表
	 */
	@Override
	public List<TotalData> selAllByTotalDate() {
		// TODO Auto-generated method stub
		return ld.selAllByTotalDate();
	}
	@Override
	public int updataAData(TotalData u) {
		// TODO Auto-generated method stub
		return ld.updataAData(u);
	}
}
