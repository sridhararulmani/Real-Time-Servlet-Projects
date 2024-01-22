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

public class Update extends GenericServlet {
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		int itemNum = Integer.parseInt(req.getParameter("itemNum"));
		String itemNameToUpdate = req.getParameter("itemNameToUpdate");
		String itemName = req.getParameter("itemName");
		double price = Double.parseDouble(req.getParameter("price"));

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", "root");
			PreparedStatement pst = conn
					.prepareStatement("UPDATE menucard SET itemNum=? ,itemName=?, price=? WHERE itemName=?");
			pst.setInt(1, itemNum);
			pst.setString(2, itemName);
			pst.setDouble(3, price);
			pst.setString(4, itemNameToUpdate);
			int result = pst.executeUpdate();
			conn.close();
			if (result > 0) {
				String message = itemName + " Data UPdated Succesfully...!";
				req.setAttribute("m", message);
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("output.jsp");
				requestDispatcher.forward(req, res);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
