package in.berbin.controller;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.berbin.daoimpl.BookingDetailsDaoImpl;
import in.berbin.daoimpl.TrainDaoImpl;
import in.berbin.daoimpl.UserDaoImpl;
import in.berbin.model.BookingDetails;
import in.berbin.model.Trains;
import in.berbin.model.Users;

/**
 * Servlet implementation class BookingHistoryController
 */
@WebServlet("/BookingHistoryController")
public class BookingHistoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookingHistoryController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	 
	     HttpSession session=request.getSession();
         DateTimeFormatter formatter =
         DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
         HttpSession session2=request.getSession();
   Users userData=(Users) session2.getAttribute("userdata");
   UserDaoImpl userDao=new UserDaoImpl();
    BookingDetailsDaoImpl bookingDetailsDao=new BookingDetailsDaoImpl();
    List<BookingDetails> bookingDetailsModel=bookingDetailsDao.getBookingDetailsForPresentUser(userData);
    for (int i=1; i<bookingDetailsModel.size(); i++) {  	
   	BookingDetails book = bookingDetailsModel.get(i);   	  
   	}
   session.setAttribute("currentttt", bookingDetailsModel);
   response.sendRedirect("bookingHistory.jsp");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
