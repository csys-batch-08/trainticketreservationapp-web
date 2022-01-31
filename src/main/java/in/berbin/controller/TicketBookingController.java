package in.berbin.controller;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.berbin.daoimpl.*;
import in.berbin.model.*;
import in.berbin.dao.*;
import in.berbin.util.*;


import javax.servlet.http.HttpServlet;
@WebServlet("/booking")
public class TicketBookingController extends HttpServlet {

public void service(HttpServletRequest req,HttpServletResponse res) {
        
        HttpSession session=req.getSession();
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        TrainDaoImpl trainDao=new TrainDaoImpl();
        UserDaoImpl userDao=new UserDaoImpl();
        BookingDetailsDaoImpl bookingdetailsDao=new BookingDetailsDaoImpl();
        
        Users user=(Users)session.getAttribute("userdata");
        Users user1=userDao.getUserDetailsById(user.getUserId());
        //for low balance
        user1=userDao.getUserDetailsById(user1.getUserId());
        
        Trains trainModel=(Trains)session.getAttribute("presenttrain");

     
       
        int ticketCount=Integer.parseInt(req.getParameter("seatcount"));
        int totalPrice=Integer.parseInt(req.getParameter("totalprice"));
        
    if(user1.getUserwallet()>=totalPrice) {
     
        int updateAmountInWallet=user1.getUserwallet()-totalPrice;
        Users userModel=new Users(user1.getUserId(),user1.getUserName(),user1.getUserDob(),user1.getUserEmail(),user1.getUserMobileNumber(),
                user1.getUserGender(),user1.getUserPassword(),updateAmountInWallet);
         UserDaoImpl UserDao = new UserDaoImpl();
         userDao.updateWallet(updateAmountInWallet, user.getUserId());
      
        int updateSeatCount=trainModel.getTotalseat()-ticketCount;
        Trains trainModel1=new Trains(trainModel.getTrainId(),trainModel.getTrainName(),trainModel.getTrainClass(),trainModel.getTrainNumber(),trainModel.getTrainSource(),
        		trainModel.getTrainDestination(),trainModel.getTrainDepartureTime(),trainModel.getTrainArraivalTime(),
        		updateSeatCount,trainModel.getTicketPrice());
        TrainDaoImpl trainDao2=new TrainDaoImpl();
        trainDao2.updateSeatCount(trainModel1);
        
        
        BookingDetails bookTickets=new BookingDetails(userModel,trainModel.getTrainId(),trainModel.getTrainDepartureTime().toLocalDate(),ticketCount,totalPrice);
        boolean ticketInsertFlag=bookingdetailsDao.bookTicket(userModel, trainModel, bookTickets);
        session.setAttribute("bookticket", bookTickets);
        session.setAttribute("TrainModel", trainModel);  
        session.setAttribute("lastuserModel", userModel);
        if(ticketInsertFlag) {
            try {
                res.sendRedirect("bookedSucessful.jsp");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        
        
        
    }
    else {	
		try {
			session.setAttribute("userHome", "lowbalance");
			res.sendRedirect("toAddAmount.jsp");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
}
}
}
