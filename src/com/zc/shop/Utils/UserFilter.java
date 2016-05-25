package com.zc.shop.Utils;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class UserFilter
 */

public class UserFilter implements Filter {

    /**
     * Default constructor. 
     */
    public UserFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		Object user = req.getSession().getAttribute("user");
		if(user == null){
			//获取请求地址
			  StringBuffer path = req.getRequestURL();
	            // 获得请求中的参数
	            String queryString = req.getQueryString();
	            // 预防空指针
	            if (queryString == null) {
	                queryString = "";
	            }
	            // 拼凑得到登陆之前的地址
	            String realPath = path + "?" + queryString;
	            // 存入session，方便调用
	            req.getSession().setAttribute("prePage", realPath);
	           //重定向到登录页面
	            res.sendRedirect("userLogin.jsp");
		}else{
			
		// pass the request along the filter chain
		chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
