package com.berbin.controller;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.berbin.daoimpl.TrainDaoImpl;
import com.berbin.model.Trains;

@WebServlet("/addtrainpage")
public class AddTrainController extends HttpServlet {

	@Override
	public void service(HttpServletRequest req,HttpServletResponse res) {
	String trainname=req.getParameter("trainname");
	String trainclass=req.getParameter("trainclass");
	int trainnumber=Integer.parseInt(req.getParameter("trainnumber"));
	String trainsource=req.getParameter("trainsource");
	String traindestination=req.getParameter("traindestination");
	LocalDateTime traindeparture=LocalDateTime.parse(req.getParameter("traindeparturetime"));
	LocalDateTime trainarraival=LocalDateTime.parse(req.getParameter("trainarrivaltime"));
	int totalseat=Integer.parseInt(req.getParameter("totalseat"));
	int ticketprice=Integer.parseInt(req.getParameter("ticketprice"));
	Trains trainModel=new Trains(trainname,trainclass,trainnumber,trainsource,traindestination,traindeparture,trainarraival,totalseat,ticketprice);
	TrainDaoImpl TrainDao=new TrainDaoImpl();
	boolean result=TrainDao.insertTrain(trainModel);
	if(result) {
		try {
			res.sendRedirect("adminHome.jsp");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}else {
		try {
			res.getWriter().print("Train is not added!");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	}
	
}