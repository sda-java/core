package com.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/HelloServlet2", initParams = @WebInitParam(name = "myparm0", value = "ddffddf"))
public class HelloServlet2 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().println("hello in servlet 2");
		// req.getRequestDispatcher("").include(request, response);

		// req.setAttribute("aaaaa", o);
		// req.getSession(true).setAttribute(name, value);
		/// req.getPara
		// getServletContext().getDefaultSessionTrackingModes()
		// req.getSession(true).

	}
}
