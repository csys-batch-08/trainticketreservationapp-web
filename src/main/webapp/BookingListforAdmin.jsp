<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="in.berbin.model.Trains"%>
    <%@page import="java.util.*"%>
         <%@page import="in.berbin.model.BookingDetails"%>
    <%@page import="java.time.format.DateTimeFormatter"%>
            <%@page import="in.berbin.daoimpl.TrainDaoImpl"%>
            <%@page import="in.berbin.daoimpl.BookingDetailsDaoImpl"%>
           <%  DateTimeFormatter formatter =
     DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");%>
            
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<title>BookingList For Admin</title>
</head>
    <style>
       *{
        margin: 0;
        padding: 0;
        box-sizing: border-box;
        font-family: Arial, Helvetica, sans-serif;
        }
        #bookinglist{
            border: 1px solid black;
            height: 85px;
            background-color:  rgb(238, 241, 241);
           
        }
        #bookinglist ul li {
            list-style: none;
            display: inline-block;
            padding: 30px;
            padding-left: 170px;
            }
        a{
            text-decoration: none;
        }
    </style>
</head>
<body>
    <div id="bookinglist">
        <ul>
            <li><a href="AdminHome.jsp">Profile</a></li>
            <li><a href="AddTrain.jsp">Add Train</a></li>            
            <li><a href="TrainList.jsp">Train list</a></li>            
            <li><a href="UserList.jsp">User list</a></li>
           
        </ul>
        <%BookingDetailsDaoImpl bookingDao=new BookingDetailsDaoImpl();
List<BookingDetails> allBookings=new ArrayList<BookingDetails>();
allBookings=bookingDao.showAllBookings();%> 
   <table border="2" id="alltrains" class="table table-striped table-hover">
<h1><b><centre>Booking List</centre></b></h1>
<thead>
<tr>
<th>No</th>
<th>UserID</th>
 <th >Train ID</th>
<th>PNR NUMBER</th>
<th>Booking Date</th>
<th>Journey Date</th>
<th>Ticket count</th>
<th>Ticket Price</th>
<th>Ticket Status</th>

</tr>
</thead>
<br>
<br>
<tbody>
<%
int i = 0;
for (BookingDetails showBooking : allBookings) {
i++;
%> 

<tr>
<td><%=i%></td>
<td><%=showBooking.getUserId()%></td> 
<td><%= showBooking.getTrainid()%></td>
<td><%=showBooking.getPnrNumber()%></td>
<td> <%=showBooking.getBookingDate()%></td>
<td> <%=showBooking.getJourneyDate()%></td>
<td> <%=showBooking.getTicketCount()%></td>
<td> <%=showBooking.getTotalPrice()%></td>
<td> <%=showBooking.getTicketStatus()%></td>   
  </tr>
<%
  }
%>      
    </div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</html>