/**
 * 
 */
package com.example.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.model.TextSearchRequest;
import com.example.model.TextSearchResult;
import com.example.model.TopSearchResult;
import com.example.service.EvaluateTextService;

/**
 * @author Priyadarshan
 *
 */

@Controller
public class EvaluateTextController {
	
	private static final Logger	logger	= Logger.getLogger(EvaluateTextController.class);
	
	@Autowired
	EvaluateTextService evaluateTextService;
	
	@RequestMapping(value="/search", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)	
	public @ResponseBody TextSearchResult searchText(@RequestBody TextSearchRequest textSearchRequest){
		logger.info("EvaluateTextController::searchText(): Entry");
		TextSearchResult textSearchResult = evaluateTextService.searchText(textSearchRequest.getSearchText());
		logger.info("EvaluateTextController::searchText(): Exit");
		return textSearchResult;
	}

	@RequestMapping(value="/top/{searchCnt}", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)	
	public @ResponseBody void topSearchText(@PathVariable Integer searchCnt, HttpServletResponse httpServletResponse) throws IOException{
		TopSearchResult topSearchResult = evaluateTextService.searchTopText(searchCnt);
		logger.info("EvaluateTextController::topSearchText(): Entry");		
		httpServletResponse.setContentType("text/csv");
		logger.info("EvaluateTextController::topSearchText(): Exit");
		httpServletResponse.getWriter().write(topSearchResult.getTopSearchMap().toString());
	}

}
 