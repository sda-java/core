package com.test;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter
public class HelloServletFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession httpSession = httpRequest.getSession(false);

		String loginURI = httpRequest.getContextPath() + "/login";

		boolean loggedIn = httpSession != null && httpSession.getAttribute("user") != null;
		boolean loginRequest = httpRequest.getRequestURI().equals(loginURI);

		if (loggedIn || loginRequest) {
			chain.doFilter(request, response);
		} else {
			httpResponse.sendRedirect(loginURI);
		}

	}

	@Override
	public void destroy() {
	}
}
