package com.example.model;

import java.io.Serializable;
import java.util.List;

public class TextSearchRequest implements Serializable {

	private static final long serialVersionUID = 6290858470091078696L;
	private List<String> searchText;
	public List<String> getSearchText() {
		return searchText;
	}
	public void setSearchText(List<String> searchText) {
		this.searchText = searchText;
	}
	
}
