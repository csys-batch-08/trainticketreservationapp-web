<%@page import="java.time.format.DateTimeFormatter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@page import="in.berbin.model.Trains"%>
    <%@page import="java.util.*"%>
            <%@page import="in.berbin.daoimpl.TrainDaoImpl"%>
             <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
                   <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
         
            
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<title>Train List</title>
</head>
    <style>
       *{
        margin: 0;
        padding: 0;
        box-sizing: border-box;
        font-family: Arial, Helvetica, sans-serif;
        }
        #trainlist{
            border: 1px solid black;
            height: 85px;
            background-color:  rgb(238, 241, 241);
           
        }
        #trainlist ul li {
            list-style: none;
            display: inline-block;
            padding: 30px;
            padding-left: 170px;
            }
        a{
            text-decoration: none;
        }
        #alltrains table,th,tr,td{
        border: 1px solid black;
        border-collapse: collapse;
        padding: 5px;
        }
    </style>
</head>
<body>

    <div id="trainlist">
        <ul>
            <li><a href="adminHome.jsp">Home</a></li>
            <li><a href="addTrain.jsp">Add Train</a></li>            
                      
            <li><a href="UserListController">User list</a></li>
            <li><a href="BookingListForAdmin">Booking list</a></li>
        </ul>
    </div>


<table border="2" id="alltrains" class="table table-striped table-hover">
<h1><b>Train List</b></h1>
<thead>
<tr>
<th>No</th>
 <th >Train ID</th>
<th>Train Name</th>
<th>Train Class</th>
<th>Train Number</th>
<th>Train Source</th>
<th>Train Destination</th>
<th>Departure time</th>
<th>Arrival Time</th>
<th>Total Seat</th>
<th>Ticket Price</th>
<th>Action</th>

</tr>
</thead>
<br>
<br>
<tbody>

 <c:set var="i" value="0"/> 
<c:forEach items="${AllTrains}" var="trainList">
  <c:set var="i" value="${i+1}"/>
  <fmt:parseDate value="${trainList.trainDepartureTime}" pattern="yyyy-MM-dd'T'HH:mm" var="departure" type="both"/>
  <fmt:parseDate value="${trainList.trainArraivalTime}" pattern="yyyy-MM-dd'T'HH:mm" var="arraival" type="both"/>
<tr>
<td>${i}</td>
<td>${trainList.trainId}</td>
<td>${trainList.trainName}</td>
<td>${trainList.trainClass}</td>
<td>${trainList.trainNumber}</td>
<td>${trainList.trainSource}</td>
<td>${trainList.trainDestination}</td>
<td> <fmt:formatDate value="${departure}" pattern="dd-MM-yyyy HH:mm" type="both"/> </td>
<td> <fmt:formatDate value="${arraival}" pattern="dd-MM-yyyy HH:mm" type="both"/> </td>
<td>${trainList.totalseat}</td>
<td>${trainList.ticketPrice}</td>
<td><a href="updateTrain.jsp?TrainName=${trainList.trainName} &TrainClass=${trainList.trainClass}&Departuretrain=
${trainList.trainDepartureTime}&TrainNumber=${trainList.trainNumber}&Arrival=${trainList.trainArraivalTime}&source=${trainList.trainSource}
&destination=${trainList.trainDestination}&totalseat=${trainList.totalseat}&ticketprice=${trainList.ticketPrice}">Update</a>
</tr>
</c:forEach>
</tbody>
</table>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>       
</body>
</html>