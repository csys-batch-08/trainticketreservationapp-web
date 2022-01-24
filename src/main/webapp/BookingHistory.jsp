<%@page import="java.time.LocalDateTime"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@page import="in.berbin.daoimpl.TrainDaoImpl"%>
        <%@page import="in.berbin.daoimpl.UserDaoImpl"%>
        <%@page import="in.berbin.daoimpl.BookingDetailsDaoImpl"%>
     <%@page import="java.util.*"%>
          <%@page import="java.time.LocalDate"%>
                    <%@page import="java.sql.Date"%>
          
     
    <%@page import="in.berbin.model.*"%>
        <%@page import="javax.servlet.http.HttpSession" %>
<%@page import="java.time.format.DateTimeFormatter"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Booking History of current user</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<style>
body{
    background: url();
    background-size: cover;
    filter: blur();
    background-repeat: no-repeat;
    background-size: cover;
    
}
        *{
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: Arial, Helvetica, sans-serif;
         }
         legend{
             border: 1px solid black;
             height: 33px;
             width: 170px;
             align:centre;
             padding: 5px;
             border-radius: 10px;
             background-color: rgb(113, 99, 177);
         }
         legend h3{
             margin-left: 7px;
         }
         table,tr,th,td{
             text-align: center;
             border: 1px solid black;
             width: 1200px;
             height: 60px;
             border: none;
             margin-left: 15px;
             
         }
         th{
             background-color: #89a832;
             color: black;
             border:shadow;
         }
         #outerlinetable{
             border: 1px solid rgb(32, 32, 32);
             padding: 20px;
         }
         #fieldsettable{
             padding: 40px;
             margin-left: 2px;
             
         }
         #forcontent{
            border: 1px solid rgb(32, 32, 32);
             padding: 20px;
             border-bottom: none;
             border-radius: 10px 10px 0px 0px;
             height: 20px;
             background-color:rgb(113, 99, 177);
             color: white;
             margin-top: -15px;
         }
         #forcontent ul li{
            padding: 3px;
         }
         #forcontentinlist{
             padding: 0px;
             list-style: none;
             display: flex;
             margin-top: -8px;
         }
         #backlink{
            color: black;
            border: 1px solid black;
            background-color: rgb(188, 187, 247);
            border: none;
            padding: 5px;
            height: 30px;
            width: 150px;
            margin-left: 560px;
            border-radius: 5px;
         }
         #trainId{
             height: 35px;
             width: 55px;
             outline: none;
             border: none;
             cursor: pointer;
             font-size: 15px;
             border-radius: 5px;
         }
         a{
             text-decoration: none;
         }
         #trainId:hover{
            background-color:rgb(113, 99, 177);
         }
        </style>
</head>
<body>
    <form action="">
        <div>
            <fieldset id="fieldsettable">
               <!--  <legend><h3>Booking History</h3></legend> -->
           
        
                <div id="outerlinetable">
                    <table>
                        
                    <%
                    DateTimeFormatter formatter =
                    DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
                    HttpSession session2=request.getSession();
              Users userData=(Users) session2.getAttribute("userdata");
              UserDaoImpl userDao=new UserDaoImpl();
               BookingDetailsDaoImpl bookingDetailsDao=new BookingDetailsDaoImpl();
               List<BookingDetails> bookingDetailsModel=bookingDetailsDao.getBookingDetailsForPresentUser(userData);
               
               
               %>
<table border="2" id="alltrains">
<h1><b>Booking List</b></h1>
<thead>
<tr>
<th>No</th>
<th>Train Name</th>
<th>Train Class</th>
<th>Train Number</th>
<th>Train Source</th>
<th>Train Destination</th>
<th>PNR Number</th>
<th>Journey Date</th>
<th>Ticket Count</th>
<th>Departure Date</th>
<th>Total Price</th>
<th>Ticket Status</th>
<th>Action</th>
</tr>
</thead>
<br>
<br>
<tbody>
<%


TrainDaoImpl trainDao=new TrainDaoImpl();
for (int i=1; i<bookingDetailsModel.size(); i++) {
	
	BookingDetails book = bookingDetailsModel.get(i);
	
	 Trains train= trainDao.findTrainsDetailsUsingID(book.getTrainid());

%>

<%! 

private static Date getcurrentdate()
{
	java.util.Date today = new java.util.Date();
	return new java.sql.Date(today.getTime());
}



%>



<tr>
 <td><%=i%></td> 
<td><%= train.getTrainName() %></td>
<td><%= train.getTrainClass()%></td>
<td><%= train.getTrainNumber()%></td>
<td><%= train.getTrainSource()%></td>
<td><%= train.getTrainDestination()%></td>
<td> <%= book.getPnrNumber()%></td>
<td> <%= book.getJourneyDate() %></td>
<td> <%= book.getTicketCount()%></td>
<td> <%= train.getTrainDepartureTime().format(formatter)%></td>
<%-- <td> <%= train.getTrainArraivalTime().format(formatter)%></td> --%>
<td> <%= book.getTotalPrice()%></td>
<td> <%= book.getTicketStatus()%></td>

<%
LocalDate date  = train.getTrainDepartureTime().toLocalDate();
Date loca1 = java.sql.Date.valueOf(date);
String status = book.getTicketStatus();
%>

<%
if(loca1.after(getcurrentdate())){
	%>
<% 
if(status.equalsIgnoreCase("Cancelled"))
{%>
	<td>Already Cancelled </td>
<% }

else
{%>

<td><button class="btn btn-danger" <a href="CancelTicket.jsp?pnrnumber=<%=book.getPnrNumber()%>">>Cancel</a>></button></td>

<% }
%>
<%} 
else
{
	%>
	<td>Journey Completed</td>
	
<%}

%>

</tr>
<%

}
%>
                   
</table></table></div></fieldset></div></form> 
<center>  
<a href="UserHomePage.jsp"><button class="btn btn-primary" >Back to HomePage</button></a>   
</center>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>               
</body>
</html>