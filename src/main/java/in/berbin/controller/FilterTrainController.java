package in.berbin.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.berbin.daoimpl.TrainDaoImpl;
import in.berbin.model.Trains;

/**
 * Servlet implementation class FilterTrainController
 */
@WebServlet("/FilterTrainController")
public class FilterTrainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FilterTrainController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		  DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
			   

		
			     
			    DateTimeFormatter format=DateTimeFormatter.ofPattern("dd-MM-yyyy");
			    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
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
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                  
			    
		//doGet(request, response);
	}

}
