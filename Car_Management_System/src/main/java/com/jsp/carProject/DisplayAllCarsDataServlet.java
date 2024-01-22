package com.jsp.carProject;

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

@WebServlet("/DisplayAllCarDatas")
public class DisplayAllCarsDataServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Configuration configuration = new Configuration().configure().addAnnotatedClass(Car.class);
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		Query<Car> query = session.createQuery("FROM Car");
		List<Car> cars = query.list();

		transaction.commit();
		session.close();

		req.setAttribute("carList", cars);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("DisplayAllCars.jsp");
		requestDispatcher.forward(req, resp);
	}
}
