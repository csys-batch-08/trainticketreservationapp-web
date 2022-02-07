package in.berbin.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.berbin.daoimpl.UserDaoImpl;
import in.berbin.model.Users;

@WebServlet("/UserListController")
public class UserListController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			UserDaoImpl userDao = new UserDaoImpl();
			List<Users> userList = new ArrayList<Users>();
			userList = userDao.showAllUsers();
			request.setAttribute("AllUser", userList);
			RequestDispatcher rd = request.getRequestDispatcher("userList.jsp");
			rd.forward(request, response);
		} catch (ServletException | IOException e) {

			e.printStackTrace();
		}
	}

}
