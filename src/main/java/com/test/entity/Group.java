package com.test.entity;

public class Group {
	private int id;
	private String groupname;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGroupname() {
		return groupname;
	}
	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}
	@Override
	public String toString() {
		return "Group [id=" + id + ", groupname=" + groupname + "]";
	}
	
}
