package in.berbin.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.berbin.daoimpl.TrainDaoImpl;
import in.berbin.model.Trains;


@WebServlet("/FilterTrainController")
public class FilterTrainController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {

			    String source=request.getParameter("sourcelocation");
			      String destination=request.getParameter("destinationlocation");
			      String dateStr = String.valueOf(request.getParameter("date"));
			      
			      LocalDate date1=LocalDate.parse(dateStr);
			      TrainDaoImpl trainDao=new TrainDaoImpl();		      
                  List<Trains> filteredTrains= new ArrayList<Trains>();                  
                  try {
               		List<Trains> filtered=trainDao.searchTrain(date1, source, destination);	
               		request.setAttribute("FilteredTrain",filtered);
					RequestDispatcher rd=request.getRequestDispatcher("filtertrain.jsp");
					rd.forward(request, response);
               		
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

	}

}
