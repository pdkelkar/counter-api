/**
 * 
 */
package com.example.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.example.constant.EvaluateTextConstant;
/**
 * @author Priyadarshan
 *
 */
public class EvaluateTextUtil {
	
	private static Map<String,Integer> task1Map = new HashMap<> ();
	private static Map<Integer,List<String>> task2Map = new TreeMap<>(Collections.reverseOrder());
	
	static{
		buildTask1Map();
		buildTask2Map();
	}
		
	public static String readFileAsString(){
		String myFileStr = null ;
		Resource resource = new ClassPathResource(EvaluateTextConstant.FILE_NAME);		
		File file;
		try {
			file = resource.getFile();
			myFileStr = FileUtils.readFileToString(file);
			myFileStr = StringUtils.replaceEach(myFileStr, new String[]{",",".",";"}, new String[]{"","",""});
		} catch (IOException e) {
			System.err.println(e);
		}
		return myFileStr;
	}

	public static Set<String> getUniqueTokenSet(String myFileStr){
		Set<String> tokenSet = new TreeSet<>();
		Scanner scanner = new Scanner(myFileStr);
		while(scanner.hasNext()){
			tokenSet.add(scanner.next());
		}
		scanner.close();
		return tokenSet;
	}

	private static void buildTask1Map(){
		String myFileStr = readFileAsString();
		Set<String> tokenSet = getUniqueTokenSet (myFileStr);
		for(String token:tokenSet){
			Pattern p = Pattern.compile("\\b"+token+"\\b");
			Matcher m = p.matcher(myFileStr);
			int cnt = 0;
			while(m.find()){
			    cnt++;
			}
			task1Map.put(token, cnt);
		}
	}
	
	private static void buildTask2Map(){
		for (Map.Entry<String, Integer> entry : task1Map.entrySet()) {
			String key = entry.getKey();
		    Integer value = entry.getValue();
			List<String> tokenList = new ArrayList<>();
		    if(task2Map.containsKey(value)){
		    	List<String> task2List = (ArrayList<String>) task2Map.get(value);
		    	task2List.add(key);
		    	task2Map.put(value, task2List);
		    }else{
		    	tokenList.add(key);
		    	task2Map.put(value, tokenList);
		    }
		}		
	}
	
	public static Map<String,Integer> getTask1Map() {
		return task1Map;
	}

	public static Map<Integer,List<String>> getTask2Map() {
		return task2Map;
	}
}
