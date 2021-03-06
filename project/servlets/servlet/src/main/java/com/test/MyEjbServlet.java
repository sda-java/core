package com.test;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.LibraryPersistentBeanLocal;
import myEjb.MySecondBean;
import myEjb.MyTestRemote;

@WebServlet("/MyEjbServlet")
public class MyEjbServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@EJB(beanName = "myEjb1")
	private MyTestRemote myTestRemote;

	@EJB(beanName = "myEjb2")
	private MyTestRemote myTestRemote2;

	@EJB
	private MySecondBean mySecondBean;

	@EJB
	private LibraryPersistentBeanLocal libraryPersistentBeanLocal;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().append("Test\n");

		try {
			resp.getWriter().append(myTestRemote.say("zzzzzz"));
		} catch (Exception e) {
			resp.getWriter().append(e.getMessage());
		}

		resp.getWriter().append("\n");

		try {
			resp.getWriter().append(myTestRemote2.say("zzzzzz2222"));
		} catch (Exception e) {
			resp.getWriter().append(e.getMessage());
		}

		resp.getWriter().append("\n");

		try {
			resp.getWriter().append("state: " + mySecondBean.getState());
		} catch (Exception e) {
			resp.getWriter().append(e.getMessage());
		}

		try {
			resp.getWriter().append("books count: " + libraryPersistentBeanLocal.getBooks().size());
		} catch (Exception e) {
			resp.getWriter().append(e.getMessage());
		}

		resp.getWriter().flush();
	}
}
