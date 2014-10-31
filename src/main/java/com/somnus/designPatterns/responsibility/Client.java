package com.somnus.designPatterns.responsibility;

import com.somnus.designPatterns.responsibility.filter.HtmlFilter;
import com.somnus.designPatterns.responsibility.filter.SensitiveFilter;
import com.somnus.designPatterns.responsibility.filter.LetterCaseFilter;
import com.somnus.designPatterns.responsibility.web.Request;
import com.somnus.designPatterns.responsibility.web.Response;

public class Client
{

	public static void main(String[] args)
	{
		Request request = new Request();
		request.setMsg("&lt;敏感词abcd");
		
		Response response = new Response();
		response.setMsg("<***ABC");
		
		FilterChain filterchain = new FilterChain();
		filterchain.addFilter(new HtmlFilter()).addFilter(new SensitiveFilter()).addFilter(new LetterCaseFilter());
//		FilterChain filterchain2 = new FilterChain();
//		filterchain2.addFilter(new LetterCaseFilter());
//		filterchain.addFilter(filterchain2);
		
		filterchain.doFilter(request,response,filterchain);
		
		
		
	}

}
