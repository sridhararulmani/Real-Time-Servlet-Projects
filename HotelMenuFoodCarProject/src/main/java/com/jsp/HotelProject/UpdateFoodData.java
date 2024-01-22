package com.jsp.HotelProject;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

@WebServlet("/update")
public class UpdateFoodData extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int foodCode = Integer.parseInt(req.getParameter("foodCode"));

		Configuration configuration = new Configuration().configure().addAnnotatedClass(Food.class);
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		Food existingFood = session.get(Food.class, foodCode);

		transaction.commit();
		session.close();
		
		req.setAttribute("existingFood", existingFood);
		RequestDispatcher requestDispatcher=req.getRequestDispatcher("UpdateFood.jsp");
		requestDispatcher.forward(req, resp);
	}
}
