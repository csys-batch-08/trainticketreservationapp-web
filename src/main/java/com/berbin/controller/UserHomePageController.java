package com.berbin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.berbin.model.Users;

@WebServlet("/UserHomePageController")
public class UserHomePageController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response){
		 try {
			HttpSession session1=request.getSession();
			  Users userData=(Users)session1.getAttribute("userdata");
			  request.setAttribute("userData", userData);
			  session1.setAttribute("userDetails", userData);
				RequestDispatcher rd = request.getRequestDispatcher("userHomePage.jsp");
				rd.forward(request, response);
		} catch (ServletException | IOException e) {
			System.out.println(e.getMessage());
		}
	}

	

}
