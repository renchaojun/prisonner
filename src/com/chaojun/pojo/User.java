package com.chaojun.pojo;

public class User{
	private long CODE;
	private int PD1_O;
	private int PD1_S;
	private String PD1_D;
	
	private int PD2_O;
	private int PD2_S;
	private String PD2_D;
	
	private int PD3_O;
	private int PD3_S;
	private String PD3_D;
	
	private int PD4_O;
	private int PD4_S;
	private String PD4_D;
	
	private int PD5_O;
	private int PD5_S;
	private String PD5_D;
	
	private int PD6_O;
	private int PD6_S;
	private String PD6_D;
	
	private int PD7_O;
	private int PD7_S;
	private String PD7_D;
	
	private int PD8_O;
	private int PD8_S;
	private String PD8_D;
	
	private int PD9_O;
	private int PD9_S;
	private String PD9_D;
	
	private int PD10_O;
	private int PD10_S;
	private String PD10_D;
	
	private int PD11_O;
	private int PD11_S;
	private String PD11_D;
	
	private int PD12_O;
	private int PD12_S;
	private String PD12_D;
	
	private int PD13_O;
	private int PD13_S;
	private String PD13_D;
	
	private int L_O;
	private int L_S;
	private String L_D;
	
	private int S_O;
	private int S_S;
	private String S_D;
	
	private String method;
	private String plan;
	
	private double chongdongScore=0;
	private double gongqingScore=0;
	private double renzhiScore1=0;
	private double renzhiScore2=0;
	
	public long getCODE() {
		return CODE;
	}
	public void setCODE(long cODE) {
		CODE = cODE;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getPlan() {
		return plan;
	}
	public void setPlan(String plan) {
		this.plan = plan;
	}
	
	
	@Override
	public String toString() {
		return "User [CODE=" + CODE + ", PD1_S=" + PD1_S + ", PD2_S=" + PD2_S + ", PD3_S=" + PD3_S + ", PD4_S=" + PD4_S
				+ ", PD5_S=" + PD5_S + ", PD6_S=" + PD6_S + ", PD7_S=" + PD7_S + ", PD8_S=" + PD8_S + ", PD9_S=" + PD9_S
				+ ", PD10_S=" + PD10_S + ", PD11_S=" + PD11_S + ", PD12_S=" + PD12_S + ", PD13_S=" + PD13_S + ", L_S="
				+ L_S + ", S_S=" + S_S + ", method=" + method + ", plan=" + plan +", chongdongScore="+chongdongScore+", gongqingScore="
				+gongqingScore+", renzhiScore1="+renzhiScore1+", renzhiScore2="+renzhiScore2+
				"]";
	}
	public int getPD1_O() {
		return PD1_O;
	}
	public void setPD1_O(int pD1_O) {
		PD1_O = pD1_O;
	}
	public int getPD1_S() {
		return PD1_S;
	}
	public void setPD1_S(int pD1_S) {
		PD1_S = pD1_S;
	}
	public String getPD1_D() {
		return PD1_D;
	}
	public void setPD1_D(String pD1_D) {
		PD1_D = pD1_D;
	}
	public int getPD2_O() {
		return PD2_O;
	}
	public void setPD2_O(int pD2_O) {
		PD2_O = pD2_O;
	}
	public int getPD2_S() {
		return PD2_S;
	}
	public void setPD2_S(int pD2_S) {
		PD2_S = pD2_S;
	}
	public String getPD2_D() {
		return PD2_D;
	}
	public void setPD2_D(String pD2_D) {
		PD2_D = pD2_D;
	}
	public int getPD3_O() {
		return PD3_O;
	}
	public void setPD3_O(int pD3_O) {
		PD3_O = pD3_O;
	}
	public int getPD3_S() {
		return PD3_S;
	}
	public void setPD3_S(int pD3_S) {
		PD3_S = pD3_S;
	}
	public String getPD3_D() {
		return PD3_D;
	}
	public void setPD3_D(String pD3_D) {
		PD3_D = pD3_D;
	}
	public int getPD4_O() {
		return PD4_O;
	}
	public void setPD4_O(int pD4_O) {
		PD4_O = pD4_O;
	}
	public int getPD4_S() {
		return PD4_S;
	}
	public void setPD4_S(int pD4_S) {
		PD4_S = pD4_S;
	}
	public String getPD4_D() {
		return PD4_D;
	}
	public void setPD4_D(String pD4_D) {
		PD4_D = pD4_D;
	}
	public int getPD5_O() {
		return PD5_O;
	}
	public void setPD5_O(int pD5_O) {
		PD5_O = pD5_O;
	}
	public int getPD5_S() {
		return PD5_S;
	}
	public void setPD5_S(int pD5_S) {
		PD5_S = pD5_S;
	}
	public String getPD5_D() {
		return PD5_D;
	}
	public void setPD5_D(String pD5_D) {
		PD5_D = pD5_D;
	}
	public int getPD6_O() {
		return PD6_O;
	}
	public void setPD6_O(int pD6_O) {
		PD6_O = pD6_O;
	}
	public int getPD6_S() {
		return PD6_S;
	}
	public void setPD6_S(int pD6_S) {
		PD6_S = pD6_S;
	}
	public String getPD6_D() {
		return PD6_D;
	}
	public void setPD6_D(String pD6_D) {
		PD6_D = pD6_D;
	}
	public int getPD7_O() {
		return PD7_O;
	}
	public void setPD7_O(int pD7_O) {
		PD7_O = pD7_O;
	}
	public int getPD7_S() {
		return PD7_S;
	}
	public void setPD7_S(int pD7_S) {
		PD7_S = pD7_S;
	}
	public String getPD7_D() {
		return PD7_D;
	}
	public void setPD7_D(String pD7_D) {
		PD7_D = pD7_D;
	}
	public int getPD8_O() {
		return PD8_O;
	}
	public void setPD8_O(int pD8_O) {
		PD8_O = pD8_O;
	}
	public int getPD8_S() {
		return PD8_S;
	}
	public void setPD8_S(int pD8_S) {
		PD8_S = pD8_S;
	}
	public String getPD8_D() {
		return PD8_D;
	}
	public void setPD8_D(String pD8_D) {
		PD8_D = pD8_D;
	}
	public int getPD9_O() {
		return PD9_O;
	}
	public void setPD9_O(int pD9_O) {
		PD9_O = pD9_O;
	}
	public int getPD9_S() {
		return PD9_S;
	}
	public void setPD9_S(int pD9_S) {
		PD9_S = pD9_S;
	}
	public String getPD9_D() {
		return PD9_D;
	}
	public void setPD9_D(String pD9_D) {
		PD9_D = pD9_D;
	}
	public int getPD10_O() {
		return PD10_O;
	}
	public void setPD10_O(int pD10_O) {
		PD10_O = pD10_O;
	}
	public int getPD10_S() {
		return PD10_S;
	}
	public void setPD10_S(int pD10_S) {
		PD10_S = pD10_S;
	}
	public String getPD10_D() {
		return PD10_D;
	}
	public void setPD10_D(String pD10_D) {
		PD10_D = pD10_D;
	}
	public int getPD11_O() {
		return PD11_O;
	}
	public void setPD11_O(int pD11_O) {
		PD11_O = pD11_O;
	}
	public int getPD11_S() {
		return PD11_S;
	}
	public void setPD11_S(int pD11_S) {
		PD11_S = pD11_S;
	}
	public String getPD11_D() {
		return PD11_D;
	}
	public void setPD11_D(String pD11_D) {
		PD11_D = pD11_D;
	}
	public int getPD12_O() {
		return PD12_O;
	}
	public void setPD12_O(int pD12_O) {
		PD12_O = pD12_O;
	}
	public int getPD12_S() {
		return PD12_S;
	}
	public void setPD12_S(int pD12_S) {
		PD12_S = pD12_S;
	}
	public String getPD12_D() {
		return PD12_D;
	}
	public void setPD12_D(String pD12_D) {
		PD12_D = pD12_D;
	}
	public int getPD13_O() {
		return PD13_O;
	}
	public void setPD13_O(int pD13_O) {
		PD13_O = pD13_O;
	}
	public int getPD13_S() {
		return PD13_S;
	}
	public void setPD13_S(int pD13_S) {
		PD13_S = pD13_S;
	}
	public String getPD13_D() {
		return PD13_D;
	}
	public void setPD13_D(String pD13_D) {
		PD13_D = pD13_D;
	}
	public int getL_O() {
		return L_O;
	}
	public void setL_O(int l_O) {
		L_O = l_O;
	}
	public int getL_S() {
		return L_S;
	}
	public void setL_S(int l_S) {
		L_S = l_S;
	}
	public String getL_D() {
		return L_D;
	}
	public void setL_D(String l_D) {
		L_D = l_D;
	}
	public int getS_O() {
		return S_O;
	}
	public void setS_O(int s_O) {
		S_O = s_O;
	}
	public int getS_S() {
		return S_S;
	}
	public void setS_S(int s_S) {
		S_S = s_S;
	}
	public String getS_D() {
		return S_D;
	}
	public void setS_D(String s_D) {
		S_D = s_D;
	}
	public double getChongdongScore() {
		return chongdongScore;
	}
	public void setChongdongScore(double chongdongScore) {
		this.chongdongScore = chongdongScore;
	}
	public double getGongqingScore() {
		return gongqingScore;
	}
	public void setGongqingScore(double gongqingScore) {
		this.gongqingScore = gongqingScore;
	}
	public double getRenzhiScore1() {
		return renzhiScore1;
	}
	public void setRenzhiScore1(double renzhiScore1) {
		this.renzhiScore1 = renzhiScore1;
	}
	public double getRenzhiScore2() {
		return renzhiScore2;
	}
	public void setRenzhiScore2(double renzhiScore2) {
		this.renzhiScore2 = renzhiScore2;
	}
	
	
	
	
}
