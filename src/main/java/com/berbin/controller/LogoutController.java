package com.berbin.controller;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout11")
public class LogoutController extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp)  {
	try {
		HttpSession session = req.getSession();
		session.invalidate();
		resp.sendRedirect("index.jsp");
	} catch (IOException e) {
		System.out.println(e.getMessage());
	}
}
}
