package in.berbin.controller;

import java.io.IOException;
import java.sql.SQLException;
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
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException {		
		String name=req.getParameter("fullname");
		String email=req.getParameter("email");
		long mobile=Long.parseLong(req.getParameter("mobileno"));
		String password=req.getParameter("password");
		LocalDate dob=LocalDate.parse(req.getParameter("dob"));
		String gender=req.getParameter("gender");
		Users userModel=new Users(name,dob,email,mobile,gender,password);
		UserDaoImpl userDao=new UserDaoImpl();		
		try {
			userDao.update(userModel);
			if(userDao!=null) {
				res.sendRedirect("index.jsp");
			}else
			{
				res.getWriter().print("Your profile not updated");
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}