package com.somnus.designPatterns.responsibility.filter;

import com.somnus.designPatterns.responsibility.Filter;
import com.somnus.designPatterns.responsibility.FilterChain;
import com.somnus.designPatterns.responsibility.web.Request;
import com.somnus.designPatterns.responsibility.web.Response;

public class LetterCaseFilter implements Filter
{
	public void doFilter(Request request,Response response,FilterChain chain)
	{
		String requesMsg = request.getMsg().toUpperCase();
		System.out.println("[LetterCaseFilter]");
		request.setMsg(requesMsg);
		
		chain.doFilter(request, response, chain);
		
		String responseMsg = response.getMsg().toLowerCase();
		System.out.println("[LetterCaseFilter]");
		response.setMsg(responseMsg);
	}

}
