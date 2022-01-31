<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>cancel ticket</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<div class="container-fluid">
<form action="TicketCancelling">
   <input type="hidden" name="cancelpnr" id="" value="${param.pnrnumber}">
   <center>
   <br><br><br><br>
   <h4>To Confirm Cancellation Press OK(10% of totalprice will be deduced)</h4><br><br>
   <button class="btn btn-danger btn-block"  type="submit">OK</button><br><br>
  
   </center>
   </div>
   </form>
    <button  class="btn btn-primary btn-block" <a href="userHomePage.jsp"></a>>Back to Home<</button>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</html>
 