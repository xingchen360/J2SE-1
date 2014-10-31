package com.somnus.designPatterns.responsibility.filter;

import com.somnus.designPatterns.responsibility.Filter;
import com.somnus.designPatterns.responsibility.FilterChain;
import com.somnus.designPatterns.responsibility.web.Request;
import com.somnus.designPatterns.responsibility.web.Response;

public class SensitiveFilter implements Filter
{

	public void doFilter(Request request,Response response,FilterChain chain)
	{
		String requestMsg = request.getMsg().replace("敏感词", "***");
		System.out.println("[SensitiveFilter]");
		request.setMsg(requestMsg);
		
		chain.doFilter(request, response, chain);
		
		String responseMsg = response.getMsg().replace("***", "敏感词");
		System.out.println("[SensitiveFilter]");
		response.setMsg(responseMsg);
	}

}
