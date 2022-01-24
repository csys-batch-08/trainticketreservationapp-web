package in.berbin.controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import in.berbin.*;
import in.berbin.controller.*;
import in.berbin.daoimpl.*;
import in.berbin.model.*;
import in.berbin.util.*;



@WebServlet("/TicketCancelling")
public class TicketCancellingController extends HttpServlet {



public void service(HttpServletRequest req, HttpServletResponse res) {
HttpSession session = req.getSession();
//calling Dao
BookingDetailsDaoImpl bookTicketsDao = new BookingDetailsDaoImpl();
TrainDaoImpl trainDao = new TrainDaoImpl();
UserDaoImpl userDao = new UserDaoImpl();
BookingDetailsDaoImpl bookingDetailsDao=new BookingDetailsDaoImpl();
//getting user data
Users userData = (Users) session.getAttribute("userdata");

Users userModel1 = userDao.getUserDetailsById(userData.getUserId());
System.out.println("user details : "+userModel1);

// giving pnr number to cancel
long pnrNumber =Long.parseLong(req.getParameter("cancelpnr"));
//to find booked ticket details
BookingDetails booking = bookTicketsDao.findBookedTicketsDetails(pnrNumber);

//to update seat count and user wallet(refund)
Trains train = trainDao.findTrainsDetailsUsingID(booking.getTrainid());
int fine = (booking.getTotalPrice()/100)*10;
int refund = booking.getTotalPrice() - fine;
int refundTotalAmount = userModel1.getUserwallet()+refund;

boolean book = bookTicketsDao.cancelTicket(userModel1, booking, train, refundTotalAmount);

if(book==true) {
	System.out.println("cancel");
}
else {
	System.out.println("invalid");
}

try {
session.setAttribute("userHome", "cancelationsucess");
res.sendRedirect("UserHomePage.jsp");
} catch (IOException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
}
}
