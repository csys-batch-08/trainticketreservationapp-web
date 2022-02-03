package in.berbin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.berbin.model.Users;

/**
 * Servlet implementation class UserHomePageController
 */
@WebServlet("/UserHomePageController")
public class UserHomePageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 HttpSession session1=request.getSession();
	      Users userData=(Users)session1.getAttribute("userdata");
	      request.setAttribute("userData", userData);
			RequestDispatcher rd = request.getRequestDispatcher("userHomePage.jsp");
			rd.forward(request, response);
	}

	

}
