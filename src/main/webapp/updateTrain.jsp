<%@page import="javax.websocket.Session"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update train</title>
</head>
<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: Arial, Helvetica, sans-serif;
}

#addtrains {
	border: 1px solid black;
	height: 85px;
	background-color: rgb(238, 241, 241);
}

#addtrains ul li {
	list-style: none;
	display: inline-block;
	padding: 30px;
	padding-left: 170px;
}

a {
	text-decoration: none;
}

body {
	background: url(images/lgbackground.jpg);
	background-size: cover;
	filter: blur();
}

.addtrain {
	background-color: rgb(238, 241, 241);
	margin-left: 120px;
	margin-top: 5px;
	height: 550px;
	width: 500px;
	text-align: center;
	position: absolute;
	left: 310px;
	top: 100px;
	padding-left: 40px;
	padding-top: 20px;
	box-shadow: 0 0 5px 5px rgba(141, 133, 128, 0.849);
}

.Entertrdetails {
	padding-left: 0px;
}

input {
	border-top: none;
	border-left: none;
	border-right: none;
	background: transparent;
	outline: none;
}

.buttonadd {
	height: 35px;
	width: 80px;
	background-color: rgb(127, 127, 221);
	outline: none;
	border: none;
}

.buttonadd:hover {
	background-color: rgb(247, 112, 112);
}

#addtr {
	margin-right: -48px;
	position: relative;
	top: 20px; # addtrres { margin-right : 80px;
	position: relative;
	top: 20px;
}

.addtrain input::target-text {
	height: 40px;
}

.addtrain inout {
	position: relative;
	left: 30px;
}
</style>
</head>
<body>
	<div id="addtrains">
		<ul>
			<li><a href="adminHome.jsp">Profile</a></li>
			<li><a href="addTrain.jsp">Add Train</a></li>
			<li><a href="TrainListController">Train list</a></li>
			<li><a href="UserListController">User list</a></li>
			<li><a href="BookingListForAdmin">Booking list</a></li>
		</ul>
	</div>
	<div class="addtrain">
		<form action="updatetrainpage">
			<h2 class="Entertrdetails">Update Train Details</h2>
			<table id="logintable">

				<c:if test="${updateerror!=null}">
					<h3 id="errorMsg">${updateerror}</h3>
				</c:if>
				<c:remove var="lowbalance" scope="session" />
				<tr>
					<th><label for="trainname">Train Name:</label>
					<td><input type="text" name="trainname" id="trainname"
						Pattern="[Aa-Zz ( )]" value="${param.TrainName}" required><br>
						<br>
					</th>
					</td>
				</tr>
				<tr>
					<th><label for="trainclass">Train Class:</label>
					<td><input type="text" name="trainclass" id="trclass"
						pattern="[a-z A-Z]{2,8}" value="${param.TrainClass}"><br>
						<br>
					</th>
					</td>
				</tr>
				<tr>
					<th><label for="trainnumber">Train Number:</label>
					<td><input type="number" name="trainnumber" id="trnumber"
						pattern="[0-9]" value="${param.TrainNumber}"
						placeholder="Enter trainnumber" readonly="readonly"
						required="required"><br> <br></td>
					</th>
				</tr>

				<tr>
					<th><label for="trainsource">Train Source:</label>
					<td><input type="text" name="trainsource" id="trainsource"
						value="${param.source}"><br> <br></td>
					</th>
				</tr>
				<tr>
					<th><label for="traindestination">Train Destination:</label>
					<td><input type="text" name="traindestination"
						id="trdestination" value="${param.destination}"
						placeholder="Enter train destination"><br> <br></td>
					</th>
				</tr>
				<tr>
					<th><label for="traindeparturetime">Train Departure
							Time:</label>
					<td><input type="datetime-local" name="traindeparturetime"
						id="trdestime" value="${param.Departuretrain}"><br> <br></td>

					</th>
				</tr>
				<tr>
					<th><label for="trainarrivaltime">Train Arrival Time:</label>
					<td><input type="datetime-local" name="trainarrivaltime"
						id="trarrtime" value="${param.Arrival}"
						placeholder="Enter arrival time"><br> <br></td>
					</th>
				</tr>
				<tr>
					<th><label for="totalseat">Total Seat:</label>
					<td><input type="number" name="totalseat" id="trtotalseat"
						min="0" value="${param.totalseat}" placeholder="Enter total seat"><br>
						<br></td>
					</th>
				</tr>
				<tr>
					<th><label for="ticketprice">Ticket Price:</label>
					<td><input type="number" name="ticketprice" id="trticketprice"
						min="0" value="${param.ticketprice}"
						placeholder="Enter ticket price"><br> <br></td>
					</th>
				</tr>
				<br>
				<tr>
					<th>
						<button class="buttonadd" id="addtr" type="submit">Submit</button>
					</th>
				</tr>
			</table>

		</form>
		<a href="adminHome.jsp"><button type="submit" id="addtrres"
				class="buttonadd" id="addtrres">Back to HomePage</button></a>
</body>
</html>