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

public interface LoginDao {
	//根据用户id获取用户信息
	TotalData selByCODE(String CODE);
	/*
	 * 下面操作全面的新的表
	 */
	List<TotalData> selAllByTotalDate();
	int updataAData(TotalData u);
} 
