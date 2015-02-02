/**
 * @author 许彬
 */
package com.lt.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * @author 许彬
 *
 */
@WebFilter(filterName="authorityFilter", urlPatterns={"/*"}, initParams={@WebInitParam(name="encoding", value="UTF-8")})
public class AuthorityFilter implements Filter {
	
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
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		String encoding = this.filterConfig.getInitParameter("encoding");
		
		arg0.setCharacterEncoding(encoding);
		
		arg2.doFilter(arg0, arg1);
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		this.filterConfig = arg0;
	}

}
