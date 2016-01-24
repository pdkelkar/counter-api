package com.example.service;

import java.util.List;

import com.example.model.TextSearchResult;
import com.example.model.TopSearchResult;

public interface EvaluateTextService {
	
	public TextSearchResult searchText(List<String> searchWords);
	
	public TopSearchResult searchTopText(int searchCnt);

}
