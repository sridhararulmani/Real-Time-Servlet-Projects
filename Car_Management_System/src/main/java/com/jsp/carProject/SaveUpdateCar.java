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
@WebServlet("/saveUpdateCar")
public class SaveUpdateCar extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int carId = Integer.parseInt(req.getParameter("carId"));
		String carModel = req.getParameter("carModel");
		String carBrand = req.getParameter("carBrand");
		int carPrice = Integer.parseInt(req.getParameter("carPrice"));

		Car car = new Car();
		car.setCarId(carId);
		car.setCarModel(carModel);
		car.setCarBrand(carBrand);
		car.setCarPirce(carPrice);

		Configuration configuration = new Configuration().configure().addAnnotatedClass(Car.class);
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		session.update(car);
		
		Query<Car> query = session.createQuery("FROM Car");
		List<Car> cars = query.list();
		
		transaction.commit();
		session.close();
		
		req.setAttribute("carList", cars);
		RequestDispatcher requestDispatcher=req.getRequestDispatcher("DisplayAllCars.jsp");
		requestDispatcher.forward(req, resp);
	}
}
