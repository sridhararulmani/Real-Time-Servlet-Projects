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

@WebServlet("/DeleteCar")
public class DeleteCar extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int carId = Integer.parseInt(req.getParameter("carId"));

		Configuration configuration = new Configuration().configure().addAnnotatedClass(Car.class);
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

//		Find the Car Object
		Car car = session.get(Car.class, carId);

//		Delete the Car Object
		session.delete(car);
		
//		Fetch the updated list of Car Object
		Query<Car> query = session.createQuery("FROM Car");
		List<Car> cars = query.list();
		
		transaction.commit();
		session.close();

		req.setAttribute("carList", cars);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("DisplayAllCars.jsp");
		requestDispatcher.forward(req, resp);
	}
}
