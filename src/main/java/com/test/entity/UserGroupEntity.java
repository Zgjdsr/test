package com.test.entity;

public class UserGroupEntity {
	private int id;
	private int uid;
	private int gid;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	@Override
	public String toString() {
		return "UserGroup [id=" + id + ", uid=" + uid + ", gid=" + gid + "]";
	}
	

}
