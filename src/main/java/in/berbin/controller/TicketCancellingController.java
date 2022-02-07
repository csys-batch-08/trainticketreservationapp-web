package in.berbin.controller;

import java.io.IOException;

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

@WebServlet("/TicketCancelling")
public class TicketCancellingController extends HttpServlet {
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = req.getSession();
//calling Dao
		BookingDetailsDaoImpl bookTicketsDao = new BookingDetailsDaoImpl();
		TrainDaoImpl trainDao = new TrainDaoImpl();
		UserDaoImpl userDao = new UserDaoImpl();
//getting user data
		Users userData = (Users) session.getAttribute("userdata");
		Users userModel1 = userDao.getUserDetailsById(userData.getUserId());
// giving pnr number to cancel
		long pnrNumber = Long.parseLong(req.getParameter("cancelpnr"));
//to find booked ticket details
		BookingDetails booking = bookTicketsDao.findBookedTicketsDetails(pnrNumber);
//to update seat count and user wallet(refund)
		Trains train = trainDao.findTrainsDetailsUsingID(booking.getTrainid());
		int fine = (booking.getTotalPrice() / 100) * 10;
		int refund = booking.getTotalPrice() - fine;
		int refundTotalAmount = userModel1.getUserwallet() + refund;
		boolean book = bookTicketsDao.cancelTicket(userModel1, booking, train, refundTotalAmount);
		if (book == true) {
			System.out.println("cancel");
		} else {
			System.out.println("invalid");
		}

		try {
			session.setAttribute("userHome", "cancelationsucess");
			res.sendRedirect("UserHomePageController");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
