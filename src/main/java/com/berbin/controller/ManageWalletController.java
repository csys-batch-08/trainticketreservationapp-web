package com.berbin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.berbin.daoimpl.UserDaoImpl;
import com.berbin.model.Users;
@WebServlet("/ManageWalletController")
public class ManageWalletController extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp)  {
	  try {
		HttpSession session2=req.getSession();
		  Users userData=(Users)session2.getAttribute("userdata");
		  UserDaoImpl userDao=new UserDaoImpl();
		    Users userModel=userDao.getUserDetailsById(userData.getUserId());
		    req.setAttribute("userModel", userModel);       
			RequestDispatcher rd = req.getRequestDispatcher("manageWallet.jsp");
			rd.forward(req, resp);
	} catch (ServletException | IOException e) {
		System.out.println(e.getMessage());
	}
}
}
