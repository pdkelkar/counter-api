/**
 * 
 */
package com.example.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Service;

import com.example.model.TextSearchResult;
import com.example.model.TopSearchResult;
import com.example.util.EvaluateTextUtil;

/**
 * @author Priyadarshan
 *
 */

@Service("evaluateTextService")
public class EvaluateTextServiceImpl implements EvaluateTextService {

	@Override
	public TextSearchResult searchText(List<String> searchWords) {
		TextSearchResult textSearchResult = new TextSearchResult();
		List<Map<String,Integer>> list = new ArrayList<>();
		for(String searchWord:searchWords){
			Map<String,Integer> map = new HashMap<>();
			if(EvaluateTextUtil.getTask1Map().containsKey(searchWord)){
				map.put(searchWord, EvaluateTextUtil.getTask1Map().get(searchWord));
			}else{
				map.put(searchWord, 0);
			}
			list.add(map);
		}
		textSearchResult.setCounts(list);
		return textSearchResult;
	}

	@Override
	public TopSearchResult searchTopText(int searchCnt) {
		TopSearchResult topSearchResult = new TopSearchResult();
		Map<Integer, List<String>> topSearchMap = new TreeMap<>(Collections.reverseOrder());
		for (Map.Entry<Integer, List<String>> entry : EvaluateTextUtil.getTask2Map().entrySet()) {
			if(searchCnt > 0){
				int key = entry.getKey();
				List<String> value = entry.getValue();			
				topSearchMap.put(key,value);
				searchCnt--;
			}
		}
		topSearchResult.setTopSearchMap(topSearchMap);
		return topSearchResult;
	}

}
