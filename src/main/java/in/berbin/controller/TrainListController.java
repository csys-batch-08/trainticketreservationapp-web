package in.berbin.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.berbin.daoimpl.TrainDaoImpl;
import in.berbin.model.Trains;

@WebServlet("/TrainListController")
public class TrainListController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response){

		try {
			TrainDaoImpl trainDao = new TrainDaoImpl();
			List<Trains> trainList = new ArrayList<>();
			trainList = trainDao.showAllTrains();
			request.setAttribute("AllTrains", trainList);
			RequestDispatcher rd = request.getRequestDispatcher("trainList.jsp");
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
}
