package com.berbin.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.berbin.daoimpl.UserDaoImpl;
import com.berbin.exception.SignUpException;
import com.berbin.model.Users;

@WebServlet("/signuppage")
public class SignupController extends HttpServlet {

	UserDaoImpl userDao = new UserDaoImpl();

	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = req.getSession();

		String name = req.getParameter("fullname");
		String email = req.getParameter("email");
		long mobile = Long.parseLong(req.getParameter("mobileno"));
		boolean checkMobile = userDao.checkUser(mobile);
		try {
			if (!(checkMobile)) {
				String password = req.getParameter("password");
				LocalDate dob = LocalDate.parse(req.getParameter("dob"));
				String gender = req.getParameter("gender");
				Users userModel = new Users( name, dob, email, mobile, gender, password);
				UserDaoImpl userDao = new UserDaoImpl();
				boolean signUpFlag = userDao.signUpUser(userModel);
				System.out.println(signUpFlag);
				if (signUpFlag) {
					try {
						res.sendRedirect("index.jsp");
					} catch (IOException e) {
						System.out.println(e.getMessage());
					}
				} else {
					throw new SignUpException();
				}
			} else {
				throw new SignUpException();
			}
		} catch (SignUpException e) {
			session.setAttribute("registerMessage", e.getPhoneRegisterMessage());
			try {
				res.sendRedirect("signup.jsp");
			} catch (IOException e1) {
				System.out.println(e.getMessage());
			}
		}
	}
}
