<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="in.berbin.model.*"%>
    <%@page import="in.berbin.daoimpl.TrainDaoImpl"%>
      <%@page import="in.berbin.daoimpl.UserDaoImpl"%>
    <%@page import="java.time.LocalDate"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  <%--   <% TrainDaoImpl trainDao=new TrainDaoImpl();
    UserDaoImpl userDao=new UserDaoImpl();
     Users userData=(Users)session.getAttribute("userdata");
     //to get train details
     int trainid=Integer.parseInt(request.getParameter("traindetails"));
     
     session.setAttribute("presenttrain", trainid);
     Trains trainModel=trainDao.findTrainsDetailsUsingID(trainid);
     Users userModel=userDao.getUserDetailsById(userData.getUserId());
     %> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ticket booking</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <style>
   /*   body{
    background: url(https://images.squarespace-cdn.com/content/v1/5a3bb03b4c326d76de73ddaa/1622559786569-F4UVF7274QAKJHWD00UM/The_Common_Wanderer_india_train_travel_tips-17_1.jpg?format=1500w);
    background-size: cover;
    filter: blur();
    
    
} */
       
        input{
            border-top: none;
            border-left: none;
            border-right: none;
            background:transparent;
            outline: none;
        
        }
        .trainDetails {
    width: 1000px;
    box-shadow: 0px 0px 14px 0px #d9d9d9;
    padding: 10px;
    margin: 3% auto;
    height: 530px;
}   
.trainDetails label{
margin-bottom:30px;
}

 
        </style>
</head>
<body>
<form action="booking" onkeyup="check()">
	<div class="trainDetails row">
	<centre><h3 class=text-center">BOOK YOUR TICKET</h3><br></centre>
	<c:set var="trainModel" scope="session" value="${presenttrain}"/>
		<div class="col-sm-6"><label>Train Name :</label>${trainModel.getTrainName()}</div>
		
		<div class="col-sm-6"><label>Train Number :</label>${trainModel. getTrainNumber()}</div>
		<div class="col-sm-12"><label>Train Class :</label>${trainModel.getTrainClass()}</div>
		<div class="col-sm-6"><label>Train Source :</label>${trainModel.getTrainSource()}</div>
		<div class="col-sm-6"><label>Train Destination :</label>${trainModel.getTrainDestination()}</div>
		
		<div class="col-sm-6"><label>Departure Time :</label>${trainModel.getTrainDepartureTime()}</div>
		<div class="col-sm-6"><label>Arrival Time :</label>${trainModel. getTrainArraivalTime()}</div>
		<div class="col-sm-12"><label>Available Seat :</label>${trainModel.getTotalseat()}</div>
		<div class="col-sm-12"><label>Seat Count :</label>
		<input type="number" name="seatcount"  id="Numberseat" min="0" max="6" placeholder="6 No's" required></div>
		<div class="col-sm-12"><label>Total Price :</label>
		<input type="text" name="totalprice" id="totalprice" placeholder="" readonly="readonly" required></div>
		
		 
		<div class="col-sm-4"></div><button class="btn btn-primary">Book Tickets</button>
		<button type="reset" class="btn btn-warning">Reset</button></div>
	
		
	</div>
</form>
	<div class="col-sm-6"></div><a href="userHomePage.jsp"><button class="btn btn-danger">Back</button></a></div>
</body>

<script type="text/javascript">

function check(){


var numberSeats=document.getElementById('Numberseat');
var price=document.getElementById('totalprice');


var count=numberSeats.value;
console.log(count);

numberSeats.value=count;
price.value=${trainModel.getTicketPrice()}*count;

}



</script>

</html>