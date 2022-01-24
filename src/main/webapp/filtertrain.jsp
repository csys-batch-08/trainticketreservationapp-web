<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.time.format.DateTimeFormatter"%>

<%@page import="java.util.ArrayList"%>
<%@page import="in.berbin.daoimpl.TrainDaoImpl"%>
<%@page import="java.time.LocalDate"%>
<%-- <%@page import="com.trainticketreservation.model.*"%> --%>
<%@page import="in.berbin.model.*"%>
<%@page import="java.util.*"%>
<%  DateTimeFormatter formatter =
     DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% 
    DateTimeFormatter format=DateTimeFormatter.ofPattern("dd-MM-yyyy");
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    String source=request.getParameter("sourcelocation");
      String destination=request.getParameter("destinationlocation");
      String dateStr = String.valueOf(request.getParameter("date"));
      
      LocalDate date1=LocalDate.parse(dateStr);
      TrainDaoImpl trainDao=new TrainDaoImpl();
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<title>Filtertrain</title>
<style>
        *{
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: Arial, Helvetica, sans-serif;
         }
        /*  legend{
             border: 1px solid black;
             height: 33px;
             width: 170px;
             padding: 5px;
             border-radius: 10px;
             background-color: rgb(113, 99, 177);
         }
         legend h3{
             margin-left: 7px;
         } */
         table,tr,th,td{
             text-align: center;
             border: 1px solid black;
             width: 1200px;
             height: 60px;
             border: none;
             margin-left: 15px;
         }
         th{
             background-color: rgb(113, 99, 177);
             color: white;
         }
         #outerlinetable{
             border: 1px solid rgb(32, 32, 32);
             padding: 20px;
         }
         #fieldsettable{
             padding: 40px;
             margin-left: 2px;
             
         }
         /* #forcontent{
            border: 1px solid rgb(32, 32, 32);
             padding: 20px;
             border-bottom: none;
             border-radius: 10px 10px 0px 0px;
             height: 20px;
             background-color:rgb(113, 99, 177);
             color: white;
             margin-top: -15px;
         } */
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
         #busId{
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
         #busId:hover{
            background-color:rgb(113, 99, 177);
         }
        </style>
</head>
<body>
    <form action="ticketBooking.jsp">
        <div>
            <fieldset id="fieldsettable">
              <!--   <legend><h3>Trains</h3></legend> -->
           
                <div id="forcontent">
                      <ul id="forcontentinlist">
                       <%--  <li><h4><%=source %></h4></li>
                        <li><p>to</p></li>
                        <li><h4><%=destination %></h4></li>
                        <li><p>Journey Date :</p></li>
                        <li><h4><%=dateStr %></h4></li> --%>
                        
                    </ul>
                </div>
                <div id="outerlinetable">
                    <table>
                        
                   <% 
                   
                   List<Trains> filteredTrains= new ArrayList<Trains>(); 
                   
                   List<Trains> filtered=trainDao.searchTrain(date1, source, destination);
                   %>
                   
                   <table border="2" id="alltrains">
<h1><b>Train List</b></h1>
<thead>
<tr>
<th>No</th>
<th>Train Name</th>
<th>Train Class</th>
<th>Train Number</th>
<th>Train Source</th>
<th>Train Destination</th>
<th>Departure time</th>
<th>Arrival Time</th>
<th>Total Seat</th>
<th>Ticket Price</th>
<th>To Book</th>
</tr>
</thead>
<br>
<br>
<tbody>
<%
int i = 0;
for (Trains showTrain : filtered) {
i++;
%>
<tr>
<td><%=i%></td>
<td><%= showTrain.getTrainName()%></td>
<td><%= showTrain.getTrainClass()%></td>
<td> <%= showTrain.getTrainNumber()%></td>
<td> <%= showTrain.getTrainSource()%></td>
<td> <%= showTrain.getTrainDestination()%></td>
<td> <%= showTrain.getTrainDepartureTime().format(formatter)%></td>
<td> <%= showTrain.getTrainArraivalTime().format(formatter)%></td>
<td> <%= showTrain.getTotalseat()%></td>
<td> <%= showTrain.getTicketPrice()%></td>
<td> <button id="trainId" name="traindetails" class="btn btn-primary btn-block" value="<%=showTrain.getTrainId()%>">Book</button></td>

</tr>
<%
}
%>
                   
</table></table></div></fieldset></div></form><br><br> 
<center> 
<a href="UserHomePage.jsp"><button class="btn btn-outline-primary">Back to HomePage</button></a> 
</center>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>               
</body>

</html>