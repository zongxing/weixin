package com.mashensoft.model.menu;

import java.util.ArrayList;
import java.util.List;

public class Button {
	private String type;
	private String name;
	private String url;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	private List<SubButton> sub_button = new ArrayList<>();
	private String key;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<SubButton> getSub_button() {
		return sub_button;
	}
	public void setSub_button(List<SubButton> sub_button) {
		this.sub_button = sub_button;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	
}
