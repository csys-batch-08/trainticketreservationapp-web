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
<title>Admin home</title>
</head>
<style>
body {
	background: url(Assests/adminhome.jpg);
	background-size: cover;
	filter: blur();
}

#logo {
	width: 105px;
	position: absolute;
	left: 0px;
	top: -41px;
	margin-left: -20px;
}
</style>
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">
			<a class="navbar-brand" id="logo" href="Assests/trainlogo.png"
				alt="Could'nt load"></a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="collapsibleNavbar">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link" href="adminHome.jsp">Home</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="addTrain.jsp">Add
							Train</a></li>
					<li class="nav-item"><a class="nav-link"
						href="TrainListController">Train List</a></li>
					<li class="nav-item"><a class="nav-link"
						href="UserListController">User List</a></li>
					<li class="nav-item"><a class="nav-link"
						href="BookingListForAdmin">Booking list</a></li>
					<li class="nav-item"><a class="nav-link" href="index.jsp">LogOut</a>
					</li>
				</ul>
			</div>
		</div>
	</nav>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>