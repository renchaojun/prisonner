package com.chaojun.flag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.chaojun.pojo.User10;
import com.chaojun.service.LoginService;
import com.chaojun.service.LoginServiceImpl;

public class Flag2 {
	public static double mean(int[] x) { 
		int m=x.length;
		double sum=0;
		for(int i=0;i<m;i++){//求和
		    sum+=x[i];
		}
		double dAve=sum/m;//求平均值
		return dAve;
	}
	//标准差σ=sqrt(s^2)
	public static double StandardDiviation(int[] x) { 
		int m=x.length;
		double sum=0;
		for(int i=0;i<m;i++){//求和
		    sum+=x[i];
		}
		double dAve=sum/m;//求平均值
		double dVar=0;
		for(int i=0;i<m;i++){//求方差
			dVar+=(x[i]-dAve)*(x[i]-dAve);
		}
		return Math.sqrt(dVar/m);	
	}
	public static void main(String[] args) {
		LoginService ls=new LoginServiceImpl();
		List<User10> list=ls.selAll10();
		List<User10> list2=new ArrayList<User10>();
		for(User10 u:list) {
			if(u.getL_S()<=4 && u.getS_S()<=3) {
			list2.add(u);
			}
		}
		double biaozhuncha;
		double mean;
		int []arr1=new int[list2.size()];
		int bound=(int) Math.round(list2.size()*0.27);
		
		//1.查看冲动性PD6_S的数据
		Collections.sort(list2,new Comparator<User10>() {
			@Override
			public int compare(User10 o1, User10 o2) {
				// TODO Auto-generated method stub
				return o2.getPD6_S()-o1.getPD6_S();
			}
		});
		//把数据全部给arr数组
		for(int i=0;i<list2.size();i++) {
			arr1[i]=list2.get(i).getPD6_S();
		}
		//数组标准查和均值
		biaozhuncha=StandardDiviation(arr1);
		mean=mean(arr1);
		//计算是否有标签，有标签set标准化的值
		for(int i=0;i<list2.size();i++) {
			if(list2.get(i).getPD6_S()>=arr1[bound]) {
				//list2.get(i)对象有冲动性标签,算分数 （x-mean）/标准差
				list2.get(i).setChongdongScore((list2.get(i).getPD6_S()-mean)/biaozhuncha);
			}
		}
		
		
		//2.查看公情绪PD3_S的数据
		Collections.sort(list2,new Comparator<User10>() {
			@Override
			public int compare(User10 o1, User10 o2) {
				// TODO Auto-generated method stub
				return o2.getPD3_S()-o1.getPD3_S();
			}
		});
		//把数据全部给arr数组
		for(int i=0;i<list2.size();i++) {
			arr1[i]=list2.get(i).getPD3_S();
		}
		//数组标准查和均值
		biaozhuncha=StandardDiviation(arr1);
		mean=mean(arr1);
		//计算是否有标签，有标签set标准化的值
		for(int i=0;i<list2.size();i++) {
			if(list2.get(i).getPD3_S()>=arr1[bound]) {
				//list2.get(i)对象有冲动性标签,算分数 （x-mean）/标准差
				list2.get(i).setGongqingScore((list2.get(i).getPD3_S()-mean)/biaozhuncha);
			}
		}
		
		//3.查看公情绪PD11_S的数据
		Collections.sort(list2,new Comparator<User10>() {
			@Override
			public int compare(User10 o1, User10 o2) {
				// TODO Auto-generated method stub
				return o2.getPD11_S()-o1.getPD11_S();
			}
		});
		//把数据全部给arr数组
		for(int i=0;i<list2.size();i++) {
			arr1[i]=list2.get(i).getPD11_S();
		}
		//数组标准查和均值
		biaozhuncha=StandardDiviation(arr1);
		mean=mean(arr1);
		//计算是否有标签，有标签set标准化的值
		for(int i=0;i<list2.size();i++) {
			if(list2.get(i).getPD11_S()>=arr1[bound]) {
				//list2.get(i)对象有冲动性标签,算分数 （x-mean）/标准差
				list2.get(i).setRenzhiScore1((list2.get(i).getPD11_S()-mean)/biaozhuncha);
			}
		}	

		
		//4.查看公情绪PD12_S的数据
		Collections.sort(list2,new Comparator<User10>() {
			@Override
			public int compare(User10 o1, User10 o2) {
				// TODO Auto-generated method stub
				return o2.getPD12_S()-o1.getPD12_S();
			}
		});
		//把数据全部给arr数组
		for(int i=0;i<list2.size();i++) {
			arr1[i]=list2.get(i).getPD12_S();
		}
		//数组标准查和均值
		biaozhuncha=StandardDiviation(arr1);
		mean=mean(arr1);
		//计算是否有标签，有标签set标准化的值
		for(int i=0;i<list2.size();i++) {
			if(list2.get(i).getPD12_S()>=arr1[bound]) {
				//list2.get(i)对象有冲动性标签,算分数 （x-mean）/标准差
				list2.get(i).setRenzhiScore2((list2.get(i).getPD12_S()-mean)/biaozhuncha);
			}
		}	
		
		
		//输出每个用户的情况
		double []score=new double[4];
		//统计数量   输出：611,934,643,572,1063
		int i0=0;
		int i1=0;
		int i2=0;
		int i3=0;
		int i4=0;
		for(User10 u:list2){
//			System.out.println("正在运行");
			score[0]=u.getChongdongScore();
			score[1]=u.getGongqingScore();
			score[2]=u.getRenzhiScore1();
			score[3]=u.getRenzhiScore2();
			double max=0;
			int maxIndex=0;
			for(int i=0;i<4;i++) {
				if(score[i]>max) {
					max=score[i];
					maxIndex=i;
				}
			}
			//统计数量
			if(max!=0) {
				if(maxIndex==0) {
					i0=i0+1;
				}else if(maxIndex==1) {
					i1=i1+1;
				}else if(maxIndex==2) {
					i2=i2+1;
				}else if(maxIndex==3) {
					i3=i3+1;
				}
			}else {
				i4=i4+1;
			}
			
			if(max!=0) {
				if(maxIndex==0) {
				u.setMethod("以情绪管理为主题的矫正策略");
				}else if(maxIndex==1) {
					u.setMethod("以培养共情心为核心的矫正策略");
				}else if(maxIndex==2 || maxIndex==3) {
					u.setMethod("以认知行为治疗为核心的矫正策略");
				}
			}else {
				u.setMethod("无");
			}
			ls.updataOne10(u);
		}
		System.out.println(i0+","+i1+","+i2+","+i3+","+i4);
	}
}
