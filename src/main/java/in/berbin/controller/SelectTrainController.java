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
import in.berbin.daoimpl.UserDaoImpl;
import in.berbin.model.Trains;
import in.berbin.model.Users;

/**
 * Servlet implementation class SelectTrainController
 */
@WebServlet("/SelectTrainController")
public class SelectTrainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectTrainController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   TrainDaoImpl trainDao=new TrainDaoImpl();
		    UserDaoImpl userDao=new UserDaoImpl();
		    HttpSession session=request.getSession();
		     Users userData=(Users)session.getAttribute("userdata");
		     //to get train details
		     int trainid=Integer.parseInt(request.getParameter("traindetails"));		    		  
		     Trains trainModel=trainDao.findTrainsDetailsUsingID(trainid);
		     Users userModel=userDao.getUserDetailsById(userData.getUserId());
		     session.setAttribute("presenttrain", trainModel);		 
		     RequestDispatcher rd=request.getRequestDispatcher("ticketBooking.jsp");
		        rd.forward(request, response);
		     
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
