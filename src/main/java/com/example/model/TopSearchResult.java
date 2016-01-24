package com.example.model;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TopSearchResult implements Serializable {

	private static final long serialVersionUID = -1838741960242768868L;

	private Map<Integer,List<String>> topSearchMap = new TreeMap<>(Collections.reverseOrder());

	public Map<Integer,List<String>> getTopSearchMap() {
		return topSearchMap;
	}

	public void setTopSearchMap(Map<Integer,List<String>> topSearchMap) {
		this.topSearchMap = topSearchMap;
	}

}
