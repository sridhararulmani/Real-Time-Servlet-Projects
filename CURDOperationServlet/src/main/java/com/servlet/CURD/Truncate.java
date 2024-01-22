package com.servlet.CURD;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Truncate extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", "root");
			PreparedStatement pst = conn.prepareStatement("TRUNCATE TABLE menucard;");
			int result = pst.executeUpdate();
			conn.close();
			
			String message = "All the data from Table Cleared Succesfully...!";
			req.setAttribute("m", message);
			RequestDispatcher rs = req.getRequestDispatcher("output.jsp");
			rs.forward(req, res);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
