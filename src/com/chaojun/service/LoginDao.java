package com.chaojun.service;

import java.util.List;
import java.util.Set;

import com.chaojun.pojo.Huanhuan;
import com.chaojun.pojo.Info;
import com.chaojun.pojo.KaoheTable;
import com.chaojun.pojo.NaturalInfo;
import com.chaojun.pojo.User;
import com.chaojun.pojo.User10;

public interface LoginDao {
	//根据用户id获取用户信息
	User selByCODE(long CODE);
	List<User> selAll();
	int updataOne(User u);
	
	User10 selByCODE10(long CODE);
	List<User10> selAll10();
	int updataOne10(User10 u);
	
	Info selByInfo(Info info);
	List<KaoheTable> selByBianhao1(Info info);
	NaturalInfo selByBianhao2(Info info);
	
	Set selIds();
	Huanhuan selId(long CODE);
} 
