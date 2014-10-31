package com.somnus.designPatterns.responsibility;

import java.util.ArrayList;
import java.util.List;
import com.somnus.designPatterns.responsibility.web.Request;
import com.somnus.designPatterns.responsibility.web.Response;

public class FilterChain implements Filter
{
	private List<Filter> filters = new ArrayList<Filter>();
	
	private int index = 0;
	
	public FilterChain addFilter(Filter filter)
	{
		this.filters.add(filter);
		
		return this;
	}
	
	public void doFilter(Request request,Response response,FilterChain chain)
	{
		if(index == filters.size()) 
		{
			//J2EE中的filter同理，判断完所有的过滤器请求完毕，才会执行servlet中的方法
			System.out.println("执行完了所有的过滤请求或者没有配置过滤，才会直接获得【请求】："+request.getMsg());
			return;
		}
		else
		{
			Filter filter = filters.get(index);
			index++;
			filter.doFilter(request,response,chain);
		}
		index--;
		if(index == 0) 
		{
			System.out.println("所有的过滤器执行完，返回处理的【响应】:"+response.getMsg());
			return;
		}
	}
}
