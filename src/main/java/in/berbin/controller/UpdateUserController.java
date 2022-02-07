package in.berbin.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.berbin.daoimpl.UserDaoImpl;
import in.berbin.model.Users;
@WebServlet("/updateuser")
public class UpdateUserController extends HttpServlet {
	@Override
	public void service(HttpServletRequest req,HttpServletResponse res) {		
		String name=req.getParameter("fullname");
		String email=req.getParameter("email");
		long mobile=Long.parseLong(req.getParameter("mobileno"));
		String password=req.getParameter("password");
		LocalDate dob=LocalDate.parse(req.getParameter("dob"));
		String gender=req.getParameter("gender");
		Users userModel=new Users(name,dob,email,mobile,gender,password);
		UserDaoImpl userDao=new UserDaoImpl();		
		userDao.update(userModel);
		if(userDao!=null) {
			try {
				res.sendRedirect("index.jsp");
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
}