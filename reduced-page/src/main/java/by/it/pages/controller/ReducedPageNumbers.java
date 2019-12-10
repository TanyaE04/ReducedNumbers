package by.it.pages.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.it.pages.number_pages.Names;
import by.it.pages.number_pages.ReducedPageNumber;

public class ReducedPageNumbers extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public static final String ERROR = "Error: "; 
    public ReducedPageNumbers() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str = request.getParameter(Names.PARAM);
		PrintWriter out = response.getWriter();
		try {
		String result = ReducedPageNumber.reducedPageNumbers(str);
		out.println(result);
		} catch (NumberFormatException e) {
			response.sendError(response.SC_INTERNAL_SERVER_ERROR, ERROR+e.toString());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
