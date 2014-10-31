package com.somnus.designPatterns.responsibility.filter;

import com.somnus.designPatterns.responsibility.Filter;
import com.somnus.designPatterns.responsibility.FilterChain;
import com.somnus.designPatterns.responsibility.web.Request;
import com.somnus.designPatterns.responsibility.web.Response;

public class HtmlFilter implements Filter
{
	public void doFilter(Request request,Response response,FilterChain chain)
	{
		String requesMsg = request.getMsg().replace("&lt;", "<").replace("&gt;", ">");
		System.out.println("[HtmlFilter]");
		request.setMsg(requesMsg);
		if (request.getMsg().endsWith("c")) return;
		chain.doFilter(request, response, chain);
		
		String responseMsg = response.getMsg().replace("<", "&lt;").replace(">", "&gt;");
		System.out.println("[HtmlFilter]");
		response.setMsg(responseMsg);
	}

}
