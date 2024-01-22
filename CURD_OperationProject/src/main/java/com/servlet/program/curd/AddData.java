package com.servlet.program.curd;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AddData extends GenericServlet {
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		int districId = Integer.parseInt(req.getParameter("districId"));
		String districName = req.getParameter("districName");
		String state = req.getParameter("state");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", "root");

			PreparedStatement pstmt = conn
					.prepareStatement("INSETR INTO states VALUES (?,?,?);");
			pstmt.setInt(1, districId);
			pstmt.setString(2, districName);
			pstmt.setString(3, state);

			int result = pstmt.executeUpdate();

			PrintWriter out = res.getWriter();
			conn.close();
			if (result > 0) {
				out.print(result + " Data Updated Succesfully..!");
			} else {
				out.print("Somthing went Rong...!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}