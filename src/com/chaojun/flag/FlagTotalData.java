package com.chaojun.flag;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.chaojun.pojo.TotalData;
import com.chaojun.service.LoginService;
import com.chaojun.service.LoginServiceImpl;

public class FlagTotalData {
	static LoginService ls=new LoginServiceImpl();
	public FlagTotalData() {
		// TODO Auto-generated constructor stub
	}
	public static void culflag() {
		//1.选出所有的数据
		List<TotalData> list=ls.selAllByTotalDate();
		System.out.println("过滤前的数据总数目："+list.size());
		//2.过滤说谎没用的数据
		List<TotalData> listAfterFilter=list.stream()
		.filter((e)->
		{
			return Integer.parseInt(e.getShzb())<=4&&Integer.parseInt(e.getTyxzb())<=3;
		})
		.collect(Collectors.toList());
		System.out.println("过滤后的数据总数量："+listAfterFilter.size());
		//3.查看冲动性，公情绪等四个维度的数据情况：
		double [][] score=new double[listAfterFilter.size()][4];
		//标准差后计算的值
		score=culScore(listAfterFilter,score);
		//4.统计数量，并更改数据库
		int []num=new int[listAfterFilter.size()];
		for(int i=0;i<score.length;i++) {
			double max=-100;
			for(int j=0;j<score[0].length;j++) {
				if(max<score[i][j]) {
					max=score[i][j];
					num[i]=j;
				}
			}
		}
		System.out.println(Arrays.toString(num));
		//5.根新数据库
		for(int i=0;i<num.length;i++) {
			TotalData user=listAfterFilter.get(i);
			if(num[i]==0) {
				user.setMethod("以情绪管理为主题的矫正策略");
				ls.updataAData(user);
			}
			if(num[i]==1) {
				user.setMethod("以培养共情心为核心的矫正策略");
				ls.updataAData(user);
			}
			if(num[i]==2||num[i]==3) {
				user.setMethod("以认知行为治疗为核心的矫正策略");
				ls.updataAData(user);
			}
		}
	}
	
	public static double[][] culScore(List<TotalData> listAfterFilter,double [][] score) {
		int row=score.length;//数据量
		int col=score[0].length; //四个维度
		double [][]data=new double[row][col];
		for(int i=0;i<col;i++) {
			//处理冲动性
			if(i==0) {
				double[] arr1=new double[row];
				for(int j=0;j<row;j++) {
					double value = Double.parseDouble(listAfterFilter.get(j).getCdx());
					arr1[j]=value;
				}
				//数组标准查和均值
				double biaozhuncha=StandardDiviation(arr1);
				double mean=mean(arr1);
				for(int j=0;j<row;j++) {
					data[j][i]=(arr1[j]-mean)/biaozhuncha;
				}
			}
			//处理同情心
			if(i==1) {
				double[] arr1=new double[row];
				for(int j=0;j<row;j++) {
					double value = Double.parseDouble(listAfterFilter.get(j).getTqx());
					arr1[j]=value;
				}
				//数组标准查和均值
				double biaozhuncha=StandardDiviation(arr1);
				double mean=mean(arr1);
				for(int j=0;j<row;j++) {
					data[j][i]=(arr1[j]-mean)/biaozhuncha;
				}
			}
			//处理心理变态倾向
			if(i==2) {
				double[] arr1=new double[row];
				for(int j=0;j<row;j++) {
					double value = Double.parseDouble(listAfterFilter.get(j).getXlbtqx());
					arr1[j]=value;
				}
				//数组标准查和均值
				double biaozhuncha=StandardDiviation(arr1);
				double mean=mean(arr1);
				for(int j=0;j<row;j++) {
					data[j][i]=(arr1[j]-mean)/biaozhuncha;
				}
			}
			//处理犯罪思维模式
			if(i==3) {
				double[] arr1=new double[row];
				for(int j=0;j<row;j++) {
					double value = Double.parseDouble(listAfterFilter.get(j).getFzswms());
					arr1[j]=value;
				}
				//数组标准查和均值
				double biaozhuncha=StandardDiviation(arr1);
				double mean=mean(arr1);
				for(int j=0;j<row;j++) {
					data[j][i]=(arr1[j]-mean)/biaozhuncha;
				}
			}
//			System.out.println(Arrays.deepToString(data));
		}
		return data;
	}
	public static double mean(double[] x) { 
		int m=x.length;
		double sum=0;
		for(int i=0;i<m;i++){//求和
		    sum+=x[i];
		}
		double dAve=sum/m;//求平均值
		return dAve;
	}
	//标准差σ=sqrt(s^2)
	public static double StandardDiviation(double[] x) { 
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
		FlagTotalData.culflag();
	}
}
