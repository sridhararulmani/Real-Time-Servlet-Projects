package com.servlet.programs;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Sevlet1 extends GenericServlet {
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String name = req.getParameter("s");
		PrintWriter out=res.getWriter();
		out.print("<h1>Welcom Home "+name+"!!</h1>");
	}
}
