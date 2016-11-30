package com.test;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Book;
import entities.LibraryPersistentBeanLocal;

@WebServlet("/PersistServlet")
public class PersistServlet extends HttpServlet {
	@EJB
	private LibraryPersistentBeanLocal libraryPersistentBeanLocal;

	int id = 100;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Book book = new Book(id++, "xxxx" + id);
			libraryPersistentBeanLocal.addBook(book);
			resp.getWriter().append("book added");
		} catch (Exception e) {
			resp.getWriter().append(e.getMessage());
		}

		resp.getWriter().flush();
	}
}
