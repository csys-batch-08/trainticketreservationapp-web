<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="in.berbin.model.Trains"%>
    <%@page import="java.util.*"%>
         <%@page import="in.berbin.model.BookingDetails"%>
    <%@page import="java.time.format.DateTimeFormatter"%>
            <%@page import="in.berbin.daoimpl.TrainDaoImpl"%>
            <%@page import="in.berbin.daoimpl.BookingDetailsDaoImpl"%>
               <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
         
            
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
            <li><a href="adminHome.jsp">Profile</a></li>
            <li><a href="addTrain.jsp">Add Train</a></li>            
            <li><a href="TrainListController">Train list</a></li>            
            <li><a href="UserListController">User list</a></li>
           
        </ul>
        
   <table border="2" id="alltrains" class="table table-striped table-hover">
<h1><b><centre>Booking List</centre></b></h1>
<thead>
 <c:if test="${not empty AllReservation}">
 

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
<c:set var="i" value="0"/> 
<c:forEach items="${AllReservation}" var="bookingList">
  <c:set var="i" value="${i+1}"/>

<tr>
<td>${i}</td>
<td>${bookingList.userId}</td> 
<td>${bookingList.trainid}</td>
<td>${bookingList.pnrNumber}</td>
<td>${bookingList.bookingDate}</td>
<td>${bookingList.journeyDate}</td>
<td>${bookingList.ticketCount}</td>
<td>${bookingList.totalPrice}</td>
<td>${bookingList.ticketStatus}</td>   
  </tr>
</c:forEach>  
</c:if>   
    </div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</html>