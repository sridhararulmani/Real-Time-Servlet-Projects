package com.jsp.HotelProject;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

@WebServlet("/AddNewFoodRecipe")
public class AddNewFood extends HttpServlet {
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
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		session.saveOrUpdate(food);
		
		transaction.commit();
		session.close();
		
		resp.sendRedirect("index.jsp");
	}
}
