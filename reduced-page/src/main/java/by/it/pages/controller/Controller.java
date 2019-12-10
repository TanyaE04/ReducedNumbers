package by.it.pages.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.it.pages.number_pages.Names;
import by.it.pages.number_pages.ReducedPageNumber;

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Controller() { super(); }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String str = request.getParameter(Names.PARAM);
		String reducedForm = ReducedPageNumber.reducedPageNumbers(str);
		request.setAttribute(Names.REDUCED_FORM, reducedForm);
		request.getRequestDispatcher(Names.RESULT_PAGE).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
