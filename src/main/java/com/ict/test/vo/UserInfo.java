package com.ict.test.vo;

import org.apache.ibatis.type.Alias;

@Alias("ui")
public class UserInfo {
	Integer uinum;
	String uiname;
	String uiid;
	String uipwd;
	String uidesc;
	public UserInfo() {}
	public UserInfo(Integer uinum, String uiname, String uiid, String uipwd, String uidesc) {
		super();
		this.uinum = uinum;
		this.uiname = uiname;
		this.uiid = uiid;
		this.uipwd = uipwd;
		this.uidesc = uidesc;
	}
	public Integer getUinum() {
		return uinum;
	}
	public void setUinum(Integer uinum) {
		this.uinum = uinum;
	}
	public String getUiname() {
		return uiname;
	}
	public void setUiname(String uiname) {
		this.uiname = uiname;
	}
	public String getUiid() {
		return uiid;
	}
	public void setUiid(String uiid) {
		this.uiid = uiid;
	}
	public String getUipwd() {
		return uipwd;
	}
	public void setUipwd(String uipwd) {
		this.uipwd = uipwd;
	}
	public String getUidesc() {
		return uidesc;
	}
	public void setUidesc(String uidesc) {
		this.uidesc = uidesc;
	}
	@Override
	public String toString() {
		return "UserInfo [uinum=" + uinum + ", uiname=" + uiname + ", uiid=" + uiid + ", uipwd=" + uipwd + ", uidesc="
				+ uidesc + "]";
	}
	
	
}
