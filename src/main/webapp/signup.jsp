<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SignUp</title>
    <style>
    body{
    background: url(Assests/Defaultbg.jpg);
    background-size: cover;
    filter: blur();
    
}
.signup{
    background-color:rgb(238, 241, 241);
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
    box-shadow: 0 0 5px 5px  rgba(141, 133, 128, 0.849);

}
.SignUphere{
    
    padding-left: 0px;
    
}
input{
    border-top: none;
    border-left: none;
    border-right: none;
    background:transparent;
    
    
}
.buttonsignup{
    height: 35px;
    width: 80px;
    background-color: rgb(127, 127, 221);
    outline: none;
    border: none;
    margin-left:10px;
}
.buttonsignup:hover{
    background-color: rgb(247, 112, 112);
}
#subsignup{
    margin-right: 130px;
    position: relative;
    top: 20px;
}
#ressignup{
       margin-right: 80px;
    position: relative;
    top: 26px;
}
.signup input::target-text{
    height: 40px;
    
}
    </style>
   
</head>
<body>
<div class="signup">
    <form action="signuppage">
    <h2 class="SignUphere">Sign Up!!</h2>
    <table id="logintable">
        
        
        <tr>
       
           <th><label for="fullname">FullName:</label></th>
            <td>
            <input type="text" name="fullname" id="fullname" placeholder="Enter your FullName" pattern="[A-Za-z]{3,40}"  required><br><br>
            </td>
        </tr>
        <tr>
            <th><label for="regage">DOB:</label></th>
            <td>           
            <input type="date" name="dob"   id="dob" required ><br><br>
            </td>
        </tr>
        <tr>
            
                <th><label  for="regemail">Email:</label></th>
                <td>
                <input type="email" name="email" id="regemail" pattern="[a-z][a-z0-9_.]+@[a-z0-9.]+[.][a-z]+" placeholder="Enter your MailID" required><br><br>
           </td>  
        </tr>
       
            <tr>
               
                     <th><label for="regpswd">Password:</label> </th>
                     <td>
                    <input type="password" name="password" id="regpswd" placeholder="Enter your Password" pattern="[a-zA-Z0-9@#]{8,16}" required><br><br>
                    </td>
               
            </tr>
            
            <tr>
               
                    <th> <label for="regmobilenum">MobileNo:</label></th>
                    <td>
                    <input type="tel" name="mobileno" id="regmobilenum" pattern="[6-9]{1}[0-9]{9}" maxlength="10" placeholder="Enter your MobileNumber" required><br><br>
                </td>
            </tr>
            <tr>
              
                      <th><label for="reggender">Gender:</label></th>
                      <td>
                    <input  type="radio"name="gender" id="reggender" value="Male" required><label  for="">Male</label>
                    <input  type="radio" name="gender"id="reggender" value="Female" required><label  for="">Female</label>
                    </td>
            </tr>
            
            <tr>
           <th> <button class="buttonsignup" id="subsignup" type="submit">Submit</button></th>
           <th> <button class="buttonsignup"id="ressignup" type="reset">Reset</button></th>
        </tr>
    </table>
    <%String errorMsg=(String)session.getAttribute("registerMessage");
        if(errorMsg!=null){%>
        <h4 id="errormsg"><%=errorMsg %></h4>
        <%}
        session.removeAttribute("registerMessage");%> 
</form>
</div>
<script type="text/javascript">
     
    today();
    function today(){
        var today = new Date();
        var dd = String(today.getDate()).padStart(2, '0');
        var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
        var yyyy = today.getFullYear();
        var yyyy1= today.getFullYear()-90;
    mindate =yyyy1 + '-' + mm + '-'+ dd  ;
    maxdate =yyyy + '-' + mm + '-'+ dd  ;
    document.getElementById("dob").setAttribute("max",maxdate);
    document.getElementById("dob").setAttribute("min",mindate);
    }
    </script>
</body>

</html>