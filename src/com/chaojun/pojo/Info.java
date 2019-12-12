package com.chaojun.pojo;

public class Info {
	private long tablecode;
	private String clientinfoid;
	private long subtableid;
	@Override
	public String toString() {
		return "Info [tablecode=" + tablecode + ", clientinfoid=" + clientinfoid + ", subtableid=" + subtableid + "]";
	}
	public Info(long tablecode, String clientinfoid, long subtableid) {
		super();
		this.tablecode = tablecode;
		this.clientinfoid = clientinfoid;
		this.subtableid = subtableid;
	}
	public Info() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getTablecode() {
		return tablecode;
	}
	public void setTablecode(long tablecode) {
		this.tablecode = tablecode;
	}
	public String getClientinfoid() {
		return clientinfoid;
	}
	public void setClientinfoid(String clientinfoid) {
		this.clientinfoid = clientinfoid;
	}
	public long getSubtableid() {
		return subtableid;
	}
	public void setSubtableid(long subtableid) {
		this.subtableid = subtableid;
	}
	
	
}
