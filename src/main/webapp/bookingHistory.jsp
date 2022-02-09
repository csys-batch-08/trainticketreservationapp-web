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
<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Booking History of current user</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<style>
body {
	background: url();
	background-size: cover;
	filter: blur();
	background-repeat: no-repeat;
	background-size: cover;
}

* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: Arial, Helvetica, sans-serif;
}

legend h3 {
	margin-left: 7px;
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
	background-color: #89a832;
	color: black;
	border: shadow;
}

#outerlinetable {
	border: 1px solid rgb(32, 32, 32);
	padding: 20px;
}

#fieldsettable {
	padding: 40px;
	margin-left: 2px;
}

#forcontent {
	border: 1px solid rgb(32, 32, 32);
	padding: 20px;
	border-bottom: none;
	border-radius: 10px 10px 0px 0px;
	height: 20px;
	background-color: rgb(113, 99, 177);
	color: white;
	margin-top: -15px;
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

#trainId {
	height: 35px;
	width: 55px;
	outline: none;
	border: none;
	cursor: pointer;
	font-size: 15px;
	border-radius: 5px;
}

a {
	text-decoration: none;
}

#trainId:hover {
	background-color: rgb(113, 99, 177);
}

#list {
	margin-left: 0%;
}

#backButton {
	margin-left: 43%;
}
</style>
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.11.4/css/jquery.dataTables.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
</head>
<body>
	<form action="">
		<div>
			<fieldset id="fieldsettable">
				<legend></legend>

				<div id="outerlinetable">
					<table>
						<caption></caption>
						<th>
							<table border="2" id="alltrains">
								<caption></caption>
								<h1 id="list">
									<strong>Booking List</strong>
								</h1>
								<thead>
									<tr>
										<th id="no">No</th>
										<th id="trname">Train Name</th>
										<th id="trclass">Train Class</th>
										<th id="trname">Train Number</th>
										<th id="trsource">Train Source</th>
										<th id="trsource">Train Destination</th>
										<th id="pnr">PNR Number</th>
										<th id="journey">Journey Date</th>
										<th id="ticket">Ticket Count</th>
										<th id="departure">Departure Date</th>
										<th id="total">Total Price</th>
										<th id="ticket">Ticket Status</th>
										<th id="action">Action</th>
									</tr>
								</thead>
								<br>
								<br>
								<tbody>


									<c:forEach begin="1" items="${currentttt}" var="CurrentUser"
										varStatus="loop">

										<c:set var="i" value="0" />

										<c:set var="i" value="${i+1}" />
										<fmt:parseDate
											value="${CurrentUser.getTrainModel().getTrainDepartureTime()}"
											pattern="yyyy-MM-dd'T'HH:mm" var="departureDate" type="both" />

										<fmt:parseDate value="${CurrentUser.journeyDate}"
											pattern="yyyy-MM-dd" var="journeyDate" type="both" />
										<tr>
											<td>${loop.count}</td>
											<td>${CurrentUser.getTrainModel().getTrainName()}</td>
											<td>${CurrentUser.getTrainModel().getTrainClass()}</td>
											<td>${CurrentUser.getTrainModel().getTrainNumber()}</td>
											<td>${CurrentUser.getTrainModel().getTrainSource()}</td>
											<td>${CurrentUser.getTrainModel().getTrainDestination()}</td>
											<td>${CurrentUser.pnrNumber}</td>
											<td><fmt:formatDate value="${journeyDate}"
													pattern="dd-MM-yyyy" type="both" /></td>
											<td>${CurrentUser.ticketCount}</td>
											<td><fmt:formatDate value="${departureDate}"
													pattern="dd-MM-yyyy HH:mm" type="both" /></td>
											<td>${CurrentUser.totalPrice}</td>
											<td>${CurrentUser.ticketStatus}</td>

											<c:set var="status" value="${CurrentUser.ticketStatus}" />
											<c:set var="today" value="${TodayDate}" />
											<c:set var="departure"
												value="${CurrentUser.getTrainModel().getTrainDepartureTime()}" />
											<fmt:parseDate
												value="${CurrentUser.getTrainModel().getTrainDepartureTime()}"
												pattern="yyyy-MM-dd'T'HH:mm" var="macthDate" type="both" />
											<fmt:formatDate value="${macthDate}" var="presentdate"
												pattern="yyyy-MM-dd" type="date" />
											<c:choose>

												<c:when test="${today<presentdate}">
													<c:choose>

														<c:when
															test="${CurrentUser.ticketStatus.equals('Cancelled')}">
															<td>CANCELLED</td>

														</c:when>
														<c:otherwise>


															<td><button class="btn btn-danger">
																	<a
																		href="cancelTicket.jsp?pnrnumber=${CurrentUser.pnrNumber}">Cancel</a>
																</button></td>
														</c:otherwise>

													</c:choose>


												</c:when>
												<c:otherwise>

													<td>Journey Completed</td>


												</c:otherwise>
											</c:choose>

										</tr>
									</c:forEach>
							</table>
						</th>
					</table>
				</div>
			</fieldset>
		</div>
	</form>
	<a href="UserHomePageController"><button class="btn btn-primary"
			id="backButton">Back to HomePage</button></a>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
	<script>
		$(document).ready(function() {
			$('#alltrains').DataTable();
		});
	</script>
</body>
</html>