package com.mashensoft.model.menu;

import java.util.ArrayList;
import java.util.List;

public class SubButton {
	private String type;
	private String name;
	private String url;
	private List<String> sub_button = new ArrayList<>();
	private String key;


	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<String> getSub_button() {
		return sub_button;
	}

	public void setSub_button(List<String> sub_button) {
		this.sub_button = sub_button;
	}

}
