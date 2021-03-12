package com.test.entity;

public class RoleGroup {
	private int id;
	private int rid;
	private int gid;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	@Override
	public String toString() {
		return "RoleGroup [id=" + id + ", rid=" + rid + ", gid=" + gid + "]";
	}
	

}
