<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Update user</title>
<style>
body {
	background: url(Assests/Defaultbg.jpg);
	background-size: cover;
	filter: blur();
}

.signup {
	background-color: rgb(238, 241, 241);
	margin-left: 120px;
	margin-top: 5px;
	height: 480px;
	width: 500px;
	text-align: center;
	position: absolute;
	left: 310px;
	top: 50px;
	padding-left: 40px;
	padding-top: 20px;
	box-shadow: 0 0 5px 5px rgba(141, 133, 128, 0.849);
}

.SignUphere {
	padding-left: 0px;
}

input {
	border-top: none;
	border-left: none;
	border-right: none;
	background: transparent;
	outline: none;
}

.buttonsignup {
	height: 35px;
	width: 80px;
	background-color: rgb(127, 127, 221);
	outline: none;
	border: none;
}

.buttonsignup:hover {
	background-color: rgb(247, 112, 112);
}

#subsignup {
	margin-right: 80px;
	position: relative;
	top: 20px;
}

#ressignup {
	margin-right: 80px;
	position: relative;
	top: 20px;
}

.signup input::target-text {
	height: 40px;
}
</style>

</head>
<body>
	<div class="signup">
		<form action="updateuser">
			<h2 class="SignUphere">Update Here!!</h2>
			<table id="logintable">



				<tr>
					<th id="name"><label for="fullname">FullName:</label>
					<td><input type="text" name="fullname" id="fullname"
						placeholder="Enter your FullName" pattern="[A-Za-z]{3,20}"
						autofocus="autofocus" value="${param.Username}" required><br>
					<br>
					</th>
					</td>
				</tr>
				<tr>
					<th id="dob"><label for="regage">DOB:</label>
					<td><input type="date" name="dob" value="${param.Userdob}"
						id="regage"><br>
					<br>
					</th>
					</td>
				</tr>
				<tr>
					<th id="email"><label for="regemail">Email:</label>
					<td><input type="email" name="email" id="regemail"
						value="${param.Usermailid}" readonly><br>
					<br></td>
					</th>
				</tr>

				<tr>
					<th id="password"><label for="regpswd">Password:</label>
					<td><input type="password" name="password" id="regpswd"
						pattern="[a-zA-Z0-9@#]{8,16}" required><br>
					<br></td>
					</th>
				</tr>

				<tr>
					<th id="number"><label for="regmobilenum">MobileNo:</label>
					<td><input type="tel" name="mobileno" id="regmobilenum"
						value="${param.Usermobileno}" readonly><br>
					<br></td>
					</th>
				</tr>
				<tr>
					<th id="gender"><label for="reggender">Gender:</label>
					<td><input type="radio" name="gender" id="reggender"
						value="Male" required><label for="">Male</label> <input
						type="radio" name="gender" id="reggender" value="Female" required><label
						for="">Female</label></td>
					</th>
				</tr>

				<tr>
					<th id="sub">
						<button class="buttonsignup" id="subsignup" type="submit">Submit</button>
					</th>

				</tr>
			</table>
		</form>
		<a href="UserHomePageController"><button type="submit"
				class="buttonsignup">Back to HomePage</button></a>
	</div>
</body>

</html>