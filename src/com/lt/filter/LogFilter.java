/**
 * 
 */
package com.lt.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * @author ra
 *
 */
@WebFilter(filterName="log", urlPatterns={"/*"})
public class LogFilter implements Filter {
	
	private FilterConfig filterConfig;

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#destroy()
	 */
	@Override
	public void destroy() {
		this.filterConfig = null;
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain arg2) throws IOException, ServletException {
		ServletContext sc = this.filterConfig.getServletContext();
		HttpServletRequest httpServletRequest = (HttpServletRequest) req;
		
		long before = System.currentTimeMillis();
		System.out.print("开始过滤：");
		String spath = httpServletRequest.getServletPath();
		System.out.print(spath);
		
		arg2.doFilter(req, res);
		long after = System.currentTimeMillis();
		System.out.print("，花费时间(毫秒)：");
		System.out.println(after - before);
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		this.filterConfig = arg0;
	}

}
