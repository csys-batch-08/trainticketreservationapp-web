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
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException {
	    
		// DateTimeFormatter dateFormat=DateTimeFormatter.ofPattern("dd-MM-yyyy");
		
		String name=req.getParameter("fullname");
		System.out.println(name);
		String email=req.getParameter("email");
		System.out.println(email);
		long mobile=Long.parseLong(req.getParameter("mobileno"));
		System.out.println(mobile);
		String password=req.getParameter("password");
		System.out.println(password);
		LocalDate dob=LocalDate.parse(req.getParameter("dob"));
		//System.out.println(dob.format(dateFormat));
		String gender=req.getParameter("gender");
		System.out.println(gender);
		Users userModel=new Users(name,dob,email,mobile,gender,password);
		UserDaoImpl userDao=new UserDaoImpl();
		
		try {
			userDao.update(userModel);
			if(userDao!=null) {
				res.sendRedirect("login.jsp");
			}else
			{
				res.getWriter().print("Your profile not updated");
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}