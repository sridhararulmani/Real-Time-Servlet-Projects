package com.jsp.HotelProject;

import java.io.IOException;
import java.util.List;

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
import org.hibernate.query.Query;

@WebServlet("/DisplayMenuCard")
public class DisplayAllFoodsInMenuCard extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Configuration configuration = new Configuration().configure().addAnnotatedClass(Food.class);
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		Query<Food> query = session.createQuery("FROM Food");
		List<Food> foods = query.list();

		transaction.commit();
		session.close();

		req.setAttribute("foodList", foods);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("DisplayMenuCard.jsp");
		requestDispatcher.forward(req, resp);
	}
}
