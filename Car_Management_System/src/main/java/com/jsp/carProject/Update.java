package com.jsp.carProject;

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

@WebServlet("/UpdateCar")
public class Update extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int carId = Integer.parseInt(req.getParameter("carId"));
		
		Configuration configuration = new Configuration().configure().addAnnotatedClass(Car.class);
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		Car existingCar = session.get(Car.class, carId);

		transaction.commit();
		session.close();

		req.setAttribute("existingCar", existingCar);
		RequestDispatcher dispatcher = req.getRequestDispatcher("UpdateCar.jsp");
		dispatcher.forward(req, resp);
	}
}