package in.berbin.controller;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
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

/**
 * Servlet implementation class TrainListController
 */
@WebServlet("/TrainListController")
public class TrainListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TrainListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	      DateTimeFormatter formatter =	DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
	    	      TrainDaoImpl trainDao = new TrainDaoImpl();
	    	     List<Trains> trainList = new ArrayList<Trains>();
	    	     trainList = trainDao.showAllTrains();
	    	     request.setAttribute("AllTrains",trainList);
	    	     RequestDispatcher rd=request.getRequestDispatcher("trainList.jsp");
	    	     rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
