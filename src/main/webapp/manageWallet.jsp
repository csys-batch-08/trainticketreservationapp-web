<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="in.berbin.daoimpl.TrainDaoImpl"%>
        <%@page import="in.berbin.daoimpl.UserDaoImpl"%>
    
    <%@page import="in.berbin.model.*"%>
        <%@page import="javax.servlet.http.HttpSession" %>
         <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manage Wallet</title>
<style>
body{
    background: url(Assests/Defaultbg.jpg);
    background-size: cover;
    filter: blur();
    
}
.signup{
       background-color: rgb(238, 241, 241);
    margin-left: 120px;
    margin-top: 5px;
    height: 344px;
    width: 401px;
    text-align: center;
    position: absolute;
    left: 310px;
    top: 50px;
    padding-left: 40px;
    padding-top: 20px;
    box-shadow: 0 0 5px 5px rgb(141 133 128 / 85%);
}
}
.SignUphere{
    
    padding-left: 0px;
    
}
input{
    border-top: none;
    border-left: none;
    border-right: none;
    background:transparent;
    outline: none;

}
.buttonsignup{
    height: 35px;
    width: 80px;
    background-color: rgb(127, 127, 221);
    outline: none;
    border: none;
    top:1000px;
}
.buttonsignup:hover{
    background-color: rgb(247, 112, 112);
}
#subsignup{
   margin-right: -41px;
    position: relative;
    top: 16px;
}
#ressignup{
    margin-right: -90px;
    position: relative;
    top: -21px;
}
}
.signup input::target-text{
    height: 40px;
    
}

#errorMsg{
color: white;
}
</style>
</head>
<body>
<div class="signup">

		<c:if test="${lowbalance!=null}">	
			<h3 id="errorMsg" >${lowbalance}</h3>
			</c:if>
		<c:remove var="lowbalance" scope="session" />
        <form action="toAddAmount.jsp">
        <h2 class="SignUphere">Manage Wallet</h2>
        <table id="logintable">
            
          
            <tr>
                <th><label for="UserName">UserName:</label>
                <td>
                 <input type="text" name="username" value="${userModel.getUserName()}" disabled="disabled" id="username"  required><br><br></th>
                 </td>
             </tr>
            <tr>
               <th><label for="available balance">Available Balance:</label>
                   <td>
                <input type="text" name="" id="availablebalance" value="${userModel.getUserwallet()}" disabled="disabled" required><br><br></th>
                            </td>
            </tr>
            
            </tr>
           
           
        
                <br>
               <tr>
               <th> <button class="buttonsignup" id="subsignup" type="submit" >To Add Money</button></th>
          
            </tr>
        </table>
    </form>
     <a href="UserHomePageController"><button type="submit" id="ressignup" class="buttonsignup">Back to HomePage</button></a>
    </div>
</body>
</html>