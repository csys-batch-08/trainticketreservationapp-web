package com.berbin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.berbin.daoimpl.BookingDetailsDaoImpl;
import com.berbin.model.BookingDetails;
import com.berbin.model.Users;

@WebServlet("/BookingHistoryController")
public class BookingHistoryController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)  {
	 
	     try {
			HttpSession session=request.getSession();
   Users userData=(Users) session.getAttribute("userdata");
   BookingDetailsDaoImpl bookingDetailsDao=new BookingDetailsDaoImpl();
   List<BookingDetails> bookingDetailsModel=bookingDetailsDao.getBookingDetailsForPresentUser(userData);
   for (int i=1; i<bookingDetailsModel.size(); i++) {  	
  	BookingDetails book = bookingDetailsModel.get(i);   	  
  	}
   session.setAttribute("currentttt", bookingDetailsModel);
   RequestDispatcher req = request.getRequestDispatcher("bookingHistory.jsp");
			req.forward(request, response);
		} catch (ServletException | IOException e) {
			System.out.println(e.getMessage());
		}

	}

	
}
