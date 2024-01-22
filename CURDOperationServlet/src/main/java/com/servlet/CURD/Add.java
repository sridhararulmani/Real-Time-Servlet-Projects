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

public class Add extends GenericServlet {
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		int itemNum = Integer.parseInt(req.getParameter("itemNum"));
		String itemName = req.getParameter("itemName");
		double price = Double.parseDouble(req.getParameter("price"));
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", "root");
			PreparedStatement pst = conn.prepareStatement("INSERT INTO menucard VALUES(?,?,?);");
			pst.setInt(1, itemNum);
			pst.setString(2, itemName);
			pst.setDouble(3, price);
			int result = pst.executeUpdate();
			conn.close();
			if (result > 0) {
				String message = itemName+" Data Added Succesfully...!";
				req.setAttribute("m", message);
				RequestDispatcher rD = req.getRequestDispatcher("output.jsp");
				rD.forward(req, res);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}