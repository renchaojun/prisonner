package com.chaojun.pojo;
/*
 * `zf_bh` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '罪犯编号',
  `zffxdw` varchar(255) DEFAULT NULL COMMENT '罪犯服刑单位',
  `zfxm` varchar(255) DEFAULT NULL COMMENT '罪犯姓名',
  `zfxb` varchar(255) DEFAULT NULL COMMENT '罪犯性别',
  `csrq` varchar(255) DEFAULT NULL COMMENT '出生日期',
  `xq` varchar(255) DEFAULT NULL COMMENT '刑期',
  `fzcs` varchar(255) DEFAULT NULL COMMENT '犯罪次数',
  `whcd` varchar(255) DEFAULT NULL COMMENT '文化程度',
  `fzlx` varchar(255) DEFAULT NULL COMMENT '犯罪类型',
  `bqzy` varchar(255) DEFAULT NULL COMMENT '捕前职业',
  `mz` varchar(255) DEFAULT NULL COMMENT '民族',
  `bqmm` varchar(255) DEFAULT NULL COMMENT '捕前政治面貌',
  `hyzk` varchar(255) DEFAULT NULL COMMENT '婚姻状况',
  `bqzylb` varchar(255) DEFAULT NULL COMMENT '捕前职业类别',
  `bqzj` varchar(255) DEFAULT NULL COMMENT '捕前职级',
  `bqzc` varchar(255) DEFAULT NULL COMMENT '捕前职称',
  `sxzy` varchar(255) DEFAULT NULL COMMENT '所学专业',
  `tc` varchar(255) DEFAULT NULL COMMENT '特长',
  `zjxy` varchar(255) DEFAULT NULL COMMENT '宗教信仰',
  `dptt` varchar(255) DEFAULT NULL COMMENT '党派团体',
  `bqzw` varchar(255) DEFAULT NULL COMMENT '捕前职务',

 */
public class TotalData {
	String zf_bh;
	String zffxdw;
	String zfxm;
	String zfxb;
	String csrq;
	String xq;
	String fzcs;
	String whcd;
	String fzlx;
	String bqzy;
	String mz;
	String bqmm;
	String hyzk;
	String bqzylb;
	String bqzj;
	String bqzc;
	String sxzy;
	String tc;
	String zjxy;
	String dptt;
	String bqzw;
	/*
	 * shzb` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '说谎指标',
  `tyxzb` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '同一性指标',
  `nwq` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '内外倾',
  `qxwdx` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '情绪稳定性',
  `tzx` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '同众性',
  `cdx` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '冲动性',
  `gjx` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '攻击性',
  `bfx` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '报复性',
  `xrg` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '信任感',
  `tqx` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '同情心',
  `zxx` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '自信心',
  `jlg` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '焦虑感',
  `chx` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '聪慧性',
  `xlbtqx` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '心理变态倾向',
  `fzswms` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '犯罪思维模式',
  `method` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `plan` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,

	 */
	String shzb;
	String tyxzb;
	String nwq;
	String qxwdx;
	String tzx;
	String cdx;
	String gjx;
	String bfx;
	String xrg;
	String tqx;
	String zxx;
	String jlg;
	String chx;
	String xlbtqx;
	String fzswms;
	String method;
	String plan;
	@Override
	public String toString() {
		return "TotalData [zf_bh=" + zf_bh + ", zffxdw=" + zffxdw + ", zfxm=" + zfxm + ", csrq=" + csrq + ", xq=" + xq
				+ ", fzcs=" + fzcs + ", whcd=" + whcd + ", fzlx=" + fzlx + ", bqzy=" + bqzy + ", mz=" + mz + ", bqmm="
				+ bqmm + ", hyzk=" + hyzk + ", bqzylb=" + bqzylb + ", bqzj=" + bqzj + ", bqzc=" + bqzc + ", sxzy="
				+ sxzy + ", tc=" + tc + ", zjxy=" + zjxy + ", dptt=" + dptt + ", bqzw=" + bqzw + ", shzb=" + shzb
				+ ", tyxzb=" + tyxzb + ", nwq=" + nwq + ", qxwdx=" + qxwdx + ", tzx=" + tzx + ", cdx=" + cdx + ", gjx="
				+ gjx + ", bfx=" + bfx + ", xrg=" + xrg + ", tqx=" + tqx + ", zxx=" + zxx + ", jlg=" + jlg + ", chx="
				+ chx + ", xlbtqx=" + xlbtqx + ", fzswms=" + fzswms + ", method=" + method + ", plan=" + plan + "]";
	}
	public TotalData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getZf_bh() {
		return zf_bh;
	}
	public void setZf_bh(String zf_bh) {
		this.zf_bh = zf_bh;
	}
	public String getZffxdw() {
		return zffxdw;
	}
	public void setZffxdw(String zffxdw) {
		this.zffxdw = zffxdw;
	}
	public String getZfxm() {
		return zfxm;
	}
	public void setZfxm(String zfxm) {
		this.zfxm = zfxm;
	}
	public String getCsrq() {
		return csrq;
	}
	public void setCsrq(String csrq) {
		this.csrq = csrq;
	}
	public String getXq() {
		return xq;
	}
	
	public String getZfxb() {
		return zfxb;
	}
	public void setZfxb(String zfxb) {
		this.zfxb = zfxb;
	}
	public void setXq(String xq) {
		this.xq = xq;
	}
	public String getFzcs() {
		return fzcs;
	}
	public void setFzcs(String fzcs) {
		this.fzcs = fzcs;
	}
	public String getWhcd() {
		return whcd;
	}
	public void setWhcd(String whcd) {
		this.whcd = whcd;
	}
	public String getFzlx() {
		return fzlx;
	}
	public void setFzlx(String fzlx) {
		this.fzlx = fzlx;
	}
	public String getBqzy() {
		return bqzy;
	}
	public void setBqzy(String bqzy) {
		this.bqzy = bqzy;
	}
	public String getMz() {
		return mz;
	}
	public void setMz(String mz) {
		this.mz = mz;
	}
	public String getBqmm() {
		return bqmm;
	}
	public void setBqmm(String bqmm) {
		this.bqmm = bqmm;
	}
	public String getHyzk() {
		return hyzk;
	}
	public void setHyzk(String hyzk) {
		this.hyzk = hyzk;
	}
	public String getBqzylb() {
		return bqzylb;
	}
	public void setBqzylb(String bqzylb) {
		this.bqzylb = bqzylb;
	}
	public String getBqzj() {
		return bqzj;
	}
	public void setBqzj(String bqzj) {
		this.bqzj = bqzj;
	}
	public String getBqzc() {
		return bqzc;
	}
	public void setBqzc(String bqzc) {
		this.bqzc = bqzc;
	}
	public String getSxzy() {
		return sxzy;
	}
	public void setSxzy(String sxzy) {
		this.sxzy = sxzy;
	}
	public String getTc() {
		return tc;
	}
	public void setTc(String tc) {
		this.tc = tc;
	}
	public String getZjxy() {
		return zjxy;
	}
	public void setZjxy(String zjxy) {
		this.zjxy = zjxy;
	}
	public String getDptt() {
		return dptt;
	}
	public void setDptt(String dptt) {
		this.dptt = dptt;
	}
	public String getBqzw() {
		return bqzw;
	}
	public void setBqzw(String bqzw) {
		this.bqzw = bqzw;
	}
	public String getShzb() {
		return shzb;
	}
	public void setShzb(String shzb) {
		this.shzb = shzb;
	}
	public String getTyxzb() {
		return tyxzb;
	}
	public void setTyxzb(String tyxzb) {
		this.tyxzb = tyxzb;
	}
	public String getNwq() {
		return nwq;
	}
	public void setNwq(String nwq) {
		this.nwq = nwq;
	}
	public String getQxwdx() {
		return qxwdx;
	}
	public void setQxwdx(String qxwdx) {
		this.qxwdx = qxwdx;
	}
	public String getTzx() {
		return tzx;
	}
	public void setTzx(String tzx) {
		this.tzx = tzx;
	}
	public String getCdx() {
		return cdx;
	}
	public void setCdx(String cdx) {
		this.cdx = cdx;
	}
	public String getGjx() {
		return gjx;
	}
	public void setGjx(String gjx) {
		this.gjx = gjx;
	}
	public String getBfx() {
		return bfx;
	}
	public void setBfx(String bfx) {
		this.bfx = bfx;
	}
	public String getXrg() {
		return xrg;
	}
	public void setXrg(String xrg) {
		this.xrg = xrg;
	}
	public String getTqx() {
		return tqx;
	}
	public void setTqx(String tqx) {
		this.tqx = tqx;
	}
	public String getZxx() {
		return zxx;
	}
	public void setZxx(String zxx) {
		this.zxx = zxx;
	}
	public String getJlg() {
		return jlg;
	}
	public void setJlg(String jlg) {
		this.jlg = jlg;
	}
	public String getChx() {
		return chx;
	}
	public void setChx(String chx) {
		this.chx = chx;
	}
	public String getXlbtqx() {
		return xlbtqx;
	}
	public void setXlbtqx(String xlbtqx) {
		this.xlbtqx = xlbtqx;
	}
	public String getFzswms() {
		return fzswms;
	}
	public void setFzswms(String fzswms) {
		this.fzswms = fzswms;
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
	

}
