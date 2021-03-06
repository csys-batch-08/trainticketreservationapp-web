<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">

<title>Login Page</title>
<style>
body {
	background: url(Assests/loginpage.jpg.jpg);
	background-size: cover;
	filter: blur();
}

div, img {
	s width: 20px;
	height: 25px;
}

div, input {
	height: 30px;
	width: 200px;
	border-top: none;
	border-left: none;
	border-right: none;
	outline: none;
	background: transparent;
	position: absolute;
}

.login {
	margin-left: 120px;
	margin-top: 50px;
	height: 420px;
	width: 300px;
	padding-left: 40px;
	padding-top: 20px;
	background-color: rgb(238, 241, 241);
	border-radius: 30px;
	position: absolute;
	left: 400px;
	top: 50px;
	box-shadow: 0 0 5px 5px rgba(141, 133, 128, 0.849);
}

.pngtitle {
	margin-left: 100px;
}

.loginhere {
	margin-left: 60px;
}

#trainpng {
	border-radius: 50%;
	border: 1px solid black;
	height: 70px;
	width: 60px;
}

#buttonlogin {
	margin-left: 80px;
}

button {
	height: 35px;
	width: 80px;
	background-color: rgb(127, 127, 221);
	outline: none;
	border: none;
	*/
}

table, th {
	border-spacing: 5px;
}

button:hover {
	background-color: rgb(247, 112, 112);
}

a:hover {
	background-color: rgb(247, 112, 112);
}

a {
	text-decoration: none;
}

#signup {
	border: 2px solid black;
	font-weight: bolder;
	font-size: 20px;
}

.trainmarquee {
	width: 250px;
	height: 100px;
}


#errorMsg{
margin-left: 40%;
}
</style>
</head>
<body>
	
	<div class="login">
		<form action="loginusers">
			<img id="trainpng" class="pngtitle" src="Assests/logintrainicon.jpg"
				alt="">
			<h2 class="loginhere">LogIn Here!!</h2>
			<table id="logintable">
				<tr>
					<th id="icons"><img src="Assests/usericon.png" alt=""></th>
					<th id="logincre"><input type="text" name="logincredentials"
						placeholder="Enter your Mobile Number" onkeyup="hideMsg()"
						required><br>
					<br></th>
				</tr>
				<tr>
					<th id="pass"><img src="Assests/passwordicon.png" alt=""></th>
					<th id="password"><input type="password" name="password"
						pattern="[a-zA-Z0-9@#]{8,16}" placeholder="Enter your Password"
						onkeyup="hideMsg()" required><br>
					<br></th>
				</tr>

			</table>

			<button class="btn btn-primary btn-block" id="buttonlogin">Login</button>
			<br>
			<br> <label for="signup">Don't have an account ? </label> <a
				id="signup" href="signup.jsp">SignUp</a>

			<c:if test="${errors!=null}">
				
					<h2 id="errorMsg">${errors}</h2>
				
			</c:if>
			<c:remove var="errors" scope="session" />
		</form>
	</div>
	<script type="text/javascript">
		function hideMsg() {
			document.getElementById("errorMsg").style.visibility = "hidden";

		}
	</script>

</body>
</html>