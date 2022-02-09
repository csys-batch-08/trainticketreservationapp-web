package in.berbin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.berbin.daoimpl.TrainDaoImpl;
import in.berbin.model.Trains;

@WebServlet("/ToUpdateTrainController")
public class ToUpdateTrainController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		int trainId = 0;
		try {
			trainId = Integer.parseInt(req.getParameter("trainId"));
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		}
		TrainDaoImpl trainDao=new TrainDaoImpl();
		        Trains trainModel=trainDao.findTrainsDetailsUsingID(trainId);
		         if(trainModel!=null) {
		        try {
		        session.setAttribute("TrainDetails", trainModel);
		        RequestDispatcher reqDispatcher=req.getRequestDispatcher("updateTrain.jsp");
		      reqDispatcher.forward(req, res);
		} catch (IOException | ServletException e) {
			System.out.println(e.getMessage());
		}
		         }
		
	}

}
