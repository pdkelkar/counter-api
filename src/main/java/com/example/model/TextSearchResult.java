package com.example.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class TextSearchResult implements Serializable {

	private static final long serialVersionUID = 3432034455714267007L;
	
	private List<Map<String,Integer>> counts;

	public List<Map<String,Integer>> getCounts() {
		return counts;
	}

	public void setCounts(List<Map<String,Integer>> counts) {
		this.counts = counts;
	}
	

}
