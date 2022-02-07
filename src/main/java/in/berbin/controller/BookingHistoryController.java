package in.berbin.controller;

import java.io.IOException;
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
import in.berbin.model.Users;

@WebServlet("/BookingHistoryController")
public class BookingHistoryController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
	     try {
			HttpSession session=request.getSession();
   Users userData=(Users) session.getAttribute("userdata");
   BookingDetailsDaoImpl bookingDetailsDao=new BookingDetailsDaoImpl();
   List<BookingDetails> bookingDetailsModel=bookingDetailsDao.getBookingDetailsForPresentUser(userData);
   for (int i=1; i<bookingDetailsModel.size(); i++) {  	
  	BookingDetails book = bookingDetailsModel.get(i);   	  
  	}
   session.setAttribute("currentttt", bookingDetailsModel);
   //response.sendRedirect("bookingHistory.jsp");
   RequestDispatcher req = request.getRequestDispatcher("bookingHistory.jsp");
			req.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}

	}

	
}
