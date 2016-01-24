package com.example.util;

import static org.junit.Assert.assertNotNull;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.util.EvaluateTextUtil;

/**
 * @author Priyadarshan
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/evaluatetext-servlet.xml", "/spring-security.xml" })

public class EvaluateTextUtilTest {

	@Test
	public void testReadFileAsString() {
		String result=EvaluateTextUtil.readFileAsString();
		assertNotNull(result);
	}

	@Test
	public void testGetUniqueTokenSet() {
		Set<String> tokenSet = EvaluateTextUtil.getUniqueTokenSet("The quick brown fox jumps over the lazy dog many times");
		assertNotNull(tokenSet);
	}

	@Test
	public void testGetTask1Map() {
		Map<String,Integer> task1Map = EvaluateTextUtil.getTask1Map();
		assertNotNull(task1Map);
	}

	@Test
	public void testGetTask2Map() {
		Map<Integer,List<String>> task2Map = EvaluateTextUtil.getTask2Map();
		assertNotNull(task2Map);
	}

}
