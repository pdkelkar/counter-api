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

import org.apache.log4j.Logger;
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
	
	private static final Logger	logger	= Logger.getLogger(EvaluateTextServiceImpl.class);

	/**
	 * This service method gets a list of words for which count needs to be determined
	 * It looks up entry in a Map to check if the word exists as a Key
	 * If yes, it returns the Value as the count
	 * If no, it returns zero as the count
	 */
	@Override
	public TextSearchResult searchText(List<String> searchWords) {
		logger.info("EvaluateTextServiceImpl::searchText(): Entry");
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
		logger.info("EvaluateTextServiceImpl::searchText(): Exit");
		return textSearchResult;
	}

	/**
	 * This service method gets the number of top words to search
	 * It iterates over a Map and returns the all the Keys and Values equal to to the expected count
	 */
	@Override
	public TopSearchResult searchTopText(int searchCnt) {
		logger.info("EvaluateTextServiceImpl::searchTopText(): Entry");
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
		logger.info("EvaluateTextServiceImpl::searchTopText(): Exit");
		return topSearchResult;
	}

}
