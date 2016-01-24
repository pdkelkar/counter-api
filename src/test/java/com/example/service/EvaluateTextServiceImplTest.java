package com.example.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.model.TextSearchResult;
import com.example.model.TopSearchResult;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/evaluatetext-servlet.xml", "/spring-security.xml" })

public class EvaluateTextServiceImplTest extends EvaluateTextServiceImpl {
	
	@Test
	public void testSearchText() {
		EvaluateTextService evaluateTextService = new EvaluateTextServiceImpl();
		List<String> wordList = new ArrayList<>();
		wordList.add("dolor");
		wordList.add("trail");
		TextSearchResult textSearchResult = evaluateTextService.searchText(wordList);
		assertNotNull(textSearchResult);
	}

	@Test
	public void testSearchTopText() {
		EvaluateTextService evaluateTextService = new EvaluateTextServiceImpl();
		TopSearchResult topSearchResult = evaluateTextService.searchTopText(5);
		assertNotNull(topSearchResult);
		
	}

}
