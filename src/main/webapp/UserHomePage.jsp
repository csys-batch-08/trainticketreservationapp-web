

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "in.berbin.controller.*"%>
    <%@page import="in.berbin.model.Users" %>
    <%@page import="in.berbin.daoimpl.UserDaoImpl" %>
    <%@page import="javax.servlet.http.HttpSession" %>
    <%HttpSession session1=request.getSession();
      Users userData=(Users)session1.getAttribute("userdata");
      System.out.println(userData);%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UserHomePage</title>

<style>
body{
background-image :url(Assests/userhomepage.jpg);
background-size: cover;
filter: blur();
background-repeat: no-repeat;
background-size: cover;

}
    *{
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    font-family: Arial, Helvetica, sans-serif;
    }
    
    ul,li{
        list-style: none;
    display: inline;
    margin-left: 24px;
    padding: 0px;
    padding-left: 45px;
    position: relative;
    top: 15px;
       
    }
    #nav{
        border: 1px solid blanchedalmond ;
        height: 90px;
        background-color:black;
        color:blanchedalmond;
        width:100%;
            border: none;
        
    }
    
    #nav a{
        text-decoration: none;
        font-size: 25px;
        color:blanchedalmond;
    font-weight: bold;
    font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif
    margin-left:60px;
    }
    a:hover {
  background-color:darkgoldenrod;
  height: 35px;
  border-radius: 10px;
 

}
    #signlink {
        display: flex;
        margin-left: 540px;
    }


    .dropdown .dropbtn {
        font-size: 20px;  
        border: none;
        outline: none;
        color: rgb(113, 99, 177);
    }
    .dropbtn{
        font-size: 20px;  
        border: none;
        outline: none;
    }

    .dropdown-content {
        display: none;
        position: absolute;
        background-color: #f9f9f9;
        min-width: 160px;

    }

    .dropdown-content a {
        float: none;
        color: black;
        padding: 12px 16px;
        text-decoration: none;
        display: block;
    }

    .dropdown-content a:hover {
        background-color: #ddd;
    }

    .dropdown:hover .dropdown-content {
        display: block;
    }
   
   
    input{
        height: 30px;
        width: 220px;
        border-top: none;
        border-left: none;
        border-right: none;
        outline: none;
    }
    input,type{
        font-size: 20px;
        padding-top: 5px;
        padding-left: 30px;
        margin-left: -8px;
    }
    span{
        font-size: larger;
    }
    table,tr,td{
        padding: 0px;
        border-spacing: 0px;
    }
    #searchlocation{
        padding: 40px;
        border: 1px solid black;
        color:black;
        border-radius: 0px;
        height: 350px;
        width: 300px;
        position: absolute;
          top: 142px;
    left: 225px;
        background-color:white;
            margin-left: -70px;
    margin-top: 35px;
      
    }.fromto{
        border: 0.100px solid black;
        width: 200px;
        height: 90px;
        font-size: 20px;
        padding: 10px;
        margin-top: 0px;
        border-radius: 0%;
    }
    #searchbutton{
        height: 40px;
        width: 200px;
        margin-top: 21px;
        margin-left: 1px;
        color: white;
        background-color: blue;
        border: none;
        border-radius: 0px;
        cursor: pointer;
    }
    #username{
        font-size: larger;
        margin-right: 40px;
        float: right;
    }
    .fromto input{
        width: 195px;
    }
    .fromto ::placeholder{
        width: 170px;
        font-size: 16px;
    }
    #logo{
    width: 105px;
    position: absolute;
    left: 0px;
    top: -41px;
    margin-left: -20px;
}
</style>
</head>


<body>

    <div id="nav">
        <ul>
          
         <!--    <li><a href="Searchtrain.jsp">Train</a></li> -->
          <img id="logo" src="Assests/trainlogo.png">
            <li><a href="AboutUs.jsp">About us</a></li>
            <li><a href="UpdateUser.jsp?Username=<%=userData.getUserName()%>&Userdob=<%=userData.getUserDob()%>&Usermailid=<%=userData.getUserEmail()%>
            &Usermobileno=<%=userData.getUserMobileNumber()%>">Update Profile</a></li>
            <li><a href="ManageWallet.jsp">Manage Wallet</a></li>
            <li>  <a href="BookingHistory.jsp">Bookings</a></li>
              <li>  <a href="logout11">Logout</a></li>
<li> <div id="username"><label for="username">
     Hello _ <%=userData.getUserName() %></label></div>
<%System.out.println(userData.getUserName()); %> 
    </li>
            


    <form action="filtertrain.jsp">
        <div id="searchlocation">
            <table>
                <tr>
                    <td><div class="fromto">
                        <span>DESTINATION</span><br>
                        <input name="destinationlocation"  id="destinationlocation" placeholder="To" list = "destination">
                            <datalist id = "destination">
                            <option value="madurai">Madurai</option>
                            <option value="chennai">Chennai</option>
                            <option value="nagercoil">Nagercoil</option>
                             <option value="bangalore">Bangalore</option>
                              <option value="thiruvananthapuram">Thiruvananthapuram</option>
                                <option value="thoothukudi">Thoothukudi</option>
                                 <option value="kuzhithurai">Kuzhithurai</option>
                            </datalist></div></td >
                    <tr><div class="fromto">
                        <span>SOURCE</span><br>
                        <input name="sourcelocation" id="sourcelocation" placeholder="From" list = "source">
                        <datalist id = "source">
                        <option value="madurai">Madurai</option>
                        <option value="chennai">Chennai</option>
                        <option value="nagercoil">Nagercoil</option>
                        <option value="bangalore">Bangalore</option>
                        <option value="thiruvananthapuram">Thiruvananthapuram</option>
                           <option value="thoothukudi">Thoothukudi</option>
                            <option value="kuzhithurai">Kuzhithurai</option>
                        </datalist></div></td>
                    <td><div class="fromto">
                        <span>DATE</span><br>
                        <input type="date" id="datefield" name="date"></div></tr>
                </tr>
            </table>
            <button type="submit"  onclick="return validate()" id="searchbutton"><h2>SEARCH</h2></button>

        </div>
        </form>
    </div>
   
    
</body>
     <script type="text/javascript">
var today = new Date();
var dd = today.getDate();
var mm = today.getMonth()+1; 
var yyyy = today.getFullYear();
if(dd<10){
  dd='0'+dd
} 
if(mm<10){
  mm='0'+mm
} 

today = yyyy+'-'+mm+'-'+dd;
document.getElementById("datefield").setAttribute("min", today);

function validate(){
    var from=document.getElementById("sourcelocation");
    var to=document.getElementById("destinationlocation");
    if(from.value.trim()==to.value.trim()){
    alert("please enter valid source and destination");
        return false;
    }
    else{
    return true;
    }
}
</script>

</html>
