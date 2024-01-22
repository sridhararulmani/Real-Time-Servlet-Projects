package com.jsp.HotelProject;

import java.io.IOException;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;
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

@WebServlet("/UpdateDetails")
public class SaveUpdateFoodData extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int foodCode = Integer.parseInt(req.getParameter("foodCode"));
		String foodName = req.getParameter("foodName");
		int foodPrice = Integer.parseInt(req.getParameter("foodPrice"));

		Food food = new Food();
		food.setFoodCode(foodCode);
		food.setFoodName(foodName);
		food.setFoodPrice(foodPrice);

		Configuration configuration = new Configuration().configure().addAnnotatedClass(Food.class);
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		session.update(food);

		Query<Food> query = session.createQuery("FROM Food");
		List<Food> foods = query.list();

		transaction.commit();
		session.close();

		req.setAttribute("foodList", foods);
		RequestDispatcher dispatcher = req.getRequestDispatcher("DisplayMenuCard.jsp");
		dispatcher.forward(req, resp);
	}
}
