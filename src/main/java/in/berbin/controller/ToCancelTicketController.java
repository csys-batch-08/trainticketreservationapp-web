package in.berbin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/ToCancelTicketController")
public class ToCancelTicketController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();
		int cancelPnr = 0;
		try {
			cancelPnr = Integer.parseInt(req.getParameter("cancelPnr"));
			session.setAttribute("cancelPnr", cancelPnr);
			  RequestDispatcher reqDispatcher=req.getRequestDispatcher("cancelTicket.jsp");
		      reqDispatcher.forward(req, res);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	

}
