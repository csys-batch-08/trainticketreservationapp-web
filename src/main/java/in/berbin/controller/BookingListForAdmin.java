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
import javax.servlet.http.HttpSession;

import in.berbin.daoimpl.BookingDetailsDaoImpl;
import in.berbin.model.BookingDetails;

/**
 * Servlet implementation class BookingListForAdmin
 */
@WebServlet("/BookingListForAdmin")
public class BookingListForAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookingListForAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		  DateTimeFormatter formatter =	 DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
		  BookingDetailsDaoImpl bookingDao=new BookingDetailsDaoImpl();
		  List<BookingDetails> allBookings=new ArrayList<BookingDetails>();
		  allBookings=bookingDao.showAllBookings();
		  System.out.println(allBookings);
		  HttpSession session=request.getSession();
		  session. setAttribute("AllReservation",allBookings);		 		 
	        RequestDispatcher rd=request.getRequestDispatcher("reservationlist.jsp");
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
