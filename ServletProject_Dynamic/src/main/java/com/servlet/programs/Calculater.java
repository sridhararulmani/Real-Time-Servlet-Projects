package com.servlet.programs;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Calculater extends GenericServlet {
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		int one = Integer.parseInt(req.getParameter("one"));
		int two = Integer.parseInt(req.getParameter("two"));
		int result = one + two;
		PrintWriter out = res.getWriter();
		out.print("<h1>" + result + " </h1>");
	}
}