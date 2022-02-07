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
import javax.servlet.http.HttpSession;

import in.berbin.daoimpl.BookingDetailsDaoImpl;
import in.berbin.model.BookingDetails;

@WebServlet("/BookingListForAdmin")
public class BookingListForAdmin extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		  try {
			BookingDetailsDaoImpl bookingDao=new BookingDetailsDaoImpl();
			  List<BookingDetails> allBookings=new ArrayList<BookingDetails>();
			  allBookings=bookingDao.showAllBookings();
			  HttpSession session=request.getSession();
			  session. setAttribute("AllReservation",allBookings);		 		 
			    RequestDispatcher rd=request.getRequestDispatcher("reservationlist.jsp");
			    rd.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}


}
