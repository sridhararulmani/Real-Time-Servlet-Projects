package com.servlet.CURD;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Delete extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String itemNameToDelete = req.getParameter("itemNameToDelete");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", "root");
			PreparedStatement pst = conn.prepareStatement("DELETE FROM menucard WHERE itemName=?");
			pst.setString(1, itemNameToDelete);
			int result = pst.executeUpdate();
			conn.close();
			if (result > 0) {
				String message = itemNameToDelete + " Data Deleted Succesfully...!";
				req.setAttribute("m", message);
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("output.jsp");
				requestDispatcher.forward(req, res);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
