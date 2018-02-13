package com.biyao.common.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Author: hxs
 * @Description:
 * @Date:on 2017/9/8
 */
public class UserFilter implements Filter {


	public void doFilter(ServletRequest arg0, ServletResponse arg1,FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		String targetURL = request.getRequestURI();
		HttpSession session = request.getSession(true);

		//对url进行拦截过滤
		if (targetURL.indexOf("allBook") == -1 && targetURL.indexOf("bookDetail") == -1 && targetURL.indexOf("loginAction") == -1
				&& targetURL.indexOf("searchByCondition") == -1 && targetURL.indexOf("searchBooks") == -1
				&& targetURL.indexOf("login.jsp") == -1 && targetURL.indexOf("register.jsp") == -1) {
			if (session.getAttribute("currentUser") == null) {
				((HttpServletResponse) arg1).sendRedirect(request.getContextPath()+"/system/allBook");
				return;
			}
		}
		chain.doFilter(arg0, arg1);
	}

	public void destroy() {}

	public void init(FilterConfig arg0) throws ServletException {}

}
