<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Train</title>
</head>
    <style>
       body{
    background: url(Assests/adminhome.jpg);
    background-size: cover;
    filter: blur();   
}
       *{
        margin: 0;
        padding: 0;
        box-sizing: border-box;
        font-family: Arial, Helvetica, sans-serif;
        }
        #addtrains{
            border: 1px solid black;
            height: 85px;
            background-color:  rgb(238, 241, 241);
           
        }
        #addtrains ul li {
            list-style: none;
            display: inline-block;
            padding: 30px;
            padding-left: 170px;
            }
        a{
            text-decoration: none;
        }
          body{
    background: url(images/lgbackground.jpg);
    background-size: cover;
    filter: blur();
    
}
.addtrain{
    background-color:rgb(238, 241, 241);
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
    box-shadow: 0 0 5px 5px  rgba(141, 133, 128, 0.849);

}
.Entertrdetails{
    
    padding-left: 0px;
    
}
input{
    border-top: none;
    border-left: none;
    border-right: none;
    background:transparent;
    outline: none;

}
.buttonadd{
    height: 35px;
    width: 80px;
    background-color: rgb(127, 127, 221);
    outline: none;
    border: none;
}
.buttonadd:hover{
    background-color: rgb(247, 112, 112);
}
#addtr{
    margin-right: 80px;
    position: relative;
    top: 20px;
}
#addtrres{
    margin-right: 80px;
    position: relative;
    top: 20px;
}
.addtrain input::target-text{
    height: 40px;
    
}

.addtrain inout{
position: relative;
left: 30px;
}
        
    </style>
</head>
<body>
    <div id="addtrains">
        <ul>
            <li><a href="AdminHome.jsp">Profile</a></li>
            <li><a href="AddTrain.jsp">Add Train</a></li>            
            <li><a href="TrainList.jsp">Train list</a></li>            
            <li><a href="UserList.jsp">User list</a></li>
            <li><a href="BookingList.jsp">Booking list</a></li>
        </ul>
    </div>
    <div class="addtrain">
        <form action="addtrainpage">
        <h2 class="Entertrdetails">Enter Train Details</h2>
        <table id="logintable">
            
            
            <tr>
               <th><label for="trainname">Train Name:</label>
               <td>
                <input type="text" name="trainname" id="trainname" Pattern ="[Aa-Zz ( )]" placeholder="Enter Train Name" required><br><br></th>
       
            </tr>
            <tr>
                <th><label for="trainclass">Train Class:</label>
                    <td>
                <input type="text" name="trainclass" id="trclass" pattern="[a-zA-Z]+" placeholder="Enter train class" required><br><br></th>
                         </td>
            </tr>
            <tr>
                <th>
                    <label  for="trainnumber">Train Number:</label>
                      <td>
                   
              <input type="number" name="trainnumber" id="trnumber"  pattern="[0-9]" placeholder="Enter trainnumber" required><br><br>
                     </td>
                </th>
            </tr>
           
                <tr>
                    <th>
                        <label for="trainsource">Train Source:</label>
                              <td>
                        <input type="text" name="trainsource" id="trainsource" pattern="[a-zA-Z]+" placeholder="Enter train source" required><br><br>
                           </td>
                    </th>
                </tr>
                <tr>
                    <th>
                        <label for="traindestination">Train Destination:</label>
                                <td>
                        <input type="text" name="traindestination" id="trdestination" pattern="[a-zA-Z]+" placeholder="Enter train destination" required><br><br>
                                </td>
                    </th>
                </tr>
                <tr>
                    <th>
                        <label for="traindeparturetime">Train Departure Time:</label>
                            <td>
                        <input type="datetime-local" name="traindeparturetime" id="trdestime" placeholder="Enter detination time" required><br><br>
                                 </td>
                    </th>
                </tr>
                <tr>
                    <th>
                        <label for="trainarrivaltime">Train Arrival Time:</label>
                           <td>
                        <input type="datetime-local" name="trainarrivaltime" id="trarrtime" placeholder="Enter arrival time" required><br><br>
                                             </td>
                    </th>
                </tr>
                <tr>
                    <th>
                        <label for="totalseat">Total Seat:</label>
                           <td>
                        <input type="number" name="totalseat" id="trtotalseat" min="0" placeholder="Enter total seat" required><br><br>
                                             </td>
                    </th>
                </tr>
                <tr>
                    <th>
                        <label for="ticketprice">Ticket Price:</label>
                             <td>
                        <input type="number" name="ticketprice" id="trticketprice" min="0" placeholder="Enter ticket price" required><br><br>
                                              </td>
                    </th>
                </tr>
                <br>
                <tr>
               <th> <button class="buttonadd" id="addtr" type="submit">Submit</button></th>
               <th> <button class="buttonadd"id="addtrres" type="reset">Reset</button></th>
            </tr>
        </table>
    
    	</form>
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
</script>
</html>