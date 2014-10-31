package com.somnus.designPatterns.responsibility;

import com.somnus.designPatterns.responsibility.web.Request;
import com.somnus.designPatterns.responsibility.web.Response;

public interface Filter
{
	public void doFilter(Request request,Response response,FilterChain chain);
}
