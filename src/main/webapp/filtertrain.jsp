<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.time.format.DateTimeFormatter"%>

<%@page import="java.util.ArrayList"%>
<%@page import="in.berbin.daoimpl.TrainDaoImpl"%>
<%@page import="java.time.LocalDate"%>
<%@page import="in.berbin.model.*"%>
<%@page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<title>Filtertrain</title>
<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: Arial, Helvetica, sans-serif;
}

table, tr, th, td {
	text-align: center;
	border: 1px solid black;
	width: 1200px;
	height: 60px;
	border: none;
	margin-left: 15px;
}

th {
	background-color: rgb(113, 99, 177);
	color: white;
}

#outerlinetable {
	border: 1px solid rgb(32, 32, 32);
	padding: 20px;
}

#fieldsettable {
	padding: 40px;
	margin-left: 2px;
}

#forcontent ul li {
	padding: 3px;
}

#forcontentinlist {
	padding: 0px;
	list-style: none;
	display: flex;
	margin-top: -8px;
}

#backlink {
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

#busId {
	height: 35px;
	width: 55px;
	outline: none;
	border: none;
	cursor: pointer;
	font-size: 15px;
	border-radius: 5px;
}

#homebutton {
	margin-left: 50%;
}

a {
	text-decoration: none;
}

#errorMsg {
	position: absolute;
	top: 350px;
	left: 560px;
}
</style>
</head>
<body>
	<form>
		<div>
			<fieldset id="fieldsettable">

				<div id="forcontent">
					<ul id="forcontentinlist">


					</ul>
				</div>
				<div id="outerlinetable">
					<table>
						<caption></caption>
					<th>
				
					
						<table border="2" id="alltrains">
							<h1>
								<strong>Train List</strong>
							</h1>
							<thead>
								<tr>
									<th id="no">No</th>
									<th id="trname">Train Name</th>
									<th id="trclass">Train Class</th>
									<th id="trname">Train Number</th>
									<th id="trsource">Train Source</th>
									<th id="trsource">Train Destination</th>
									<th id="departure">Departure time</th>
									<th id="arraival">Arrival Time</th>
									<th id="total">Total Seat</th>
									<th id=ticket>Ticket Price</th>
									<th id="book">To Book</th>
								</tr>
							</thead>
							<br>
							<br>


							<c:if test="${empty FilteredTrain}">
								<h3 id="errorMsg">No Train Available</h3>
							</c:if>


							<tbody>
								<c:set var="i" value="0" />
								<c:forEach items="${FilteredTrain}" var="filterTrainList">
									<c:set var="i" value="${i+1}" />
									<fmt:parseDate value="${filterTrainList.trainDepartureTime}"
										pattern="yyyy-MM-dd'T'HH:mm" var="departureTime" type="both" />
									<fmt:parseDate value="${filterTrainList.trainArraivalTime}"
										pattern="yyyy-MM-dd'T'HH:mm" var="arraivalTime" type="both" />
									<tr>
										<td>${i}</td>
										<td>${filterTrainList.trainName}</td>
										<td>${filterTrainList.trainClass}</td>
										<td>${filterTrainList.trainNumber}</td>
										<td>${filterTrainList.trainSource}</td>
										<td>${filterTrainList.trainDestination}</td>
										<td><fmt:formatDate value="${departureTime}"
												pattern="dd-MM-yyyy HH:mm" type="both" /></td>
										<td><fmt:formatDate value="${arraivalTime}"
												pattern="dd-MM-yyyy HH:mm" type="both" /></td>
										<td>${filterTrainList.totalseat}</td>
										<td>${filterTrainList.ticketPrice}</td>
										<td>
										<td>

											<button id="trainId" class="btn btn-primary btn-block">
												<a
													href="SelectTrainController?traindetails=${filterTrainList.trainId}">Book</a>
											</button>
										</td>
										</td>


									</tr>
								</c:forEach>
						</table>
						</th>
					</table>
				</div>
			</fieldset>
		</div>
	</form>
	<br>
	<br>

	<a href="UserHomePageController"><button
			class="btn btn-outline-primary" id="homebutton">Back to
			HomePage</button></a>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>

</html>