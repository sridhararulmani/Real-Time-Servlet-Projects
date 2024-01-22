package com.jsp.carProject;

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

//for servlet mapping short cut
@WebServlet("/AddNewCar")
public class AddCar extends HttpServlet {
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

		session.save(car);
		transaction.commit();
		session.close();

		resp.sendRedirect("index.jsp");
	}
}
