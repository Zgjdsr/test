package com.test.entity;

public class UserRoleEntity {
	private int id;
	private int uid;
	private int rid;
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
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	@Override
	public String toString() {
		return "UserRole [id=" + id + ", uid=" + uid + ", rid=" + rid + "]";
	}
	
}
