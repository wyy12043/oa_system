package com.oa.model;

import java.util.List;

public class Menu {
	
	private int id ;
	private String text ;
	private int pid ;
	private String url ;
	private boolean checked = false;

	private List<Opt> children;

	public List<Opt> getChildren() {
		return children;
	}

	public void setChildren(List<Opt> children) {
		this.children = children;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	

}
