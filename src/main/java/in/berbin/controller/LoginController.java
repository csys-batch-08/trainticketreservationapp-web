package in.berbin.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.berbin.daoimpl.AdminDaoImpl;
import in.berbin.daoimpl.UserDaoImpl;
import in.berbin.exception.LoginException;


import in.berbin.model.Admins;
import in.berbin.model.Users;


@WebServlet("/loginusers")
public class LoginController extends HttpServlet{
	public  LocalDate getdate()
	{
        LocalDate lt = LocalDate.now();
		return lt;
	}
	

public void service(HttpServletRequest req,HttpServletResponse res) {

HttpSession session=req.getSession();

String loginId=req.getParameter("logincredentials");
String password=req.getParameter("password");

AdminDaoImpl adminDao=new AdminDaoImpl();
UserDaoImpl userDao=new UserDaoImpl();
Admins adminModel;
Users userModel=new Users();
LocalDate currentdate=getdate();
session.setAttribute("TodayDate", currentdate);

//admin Login
if(loginId.endsWith("@admin.com")) {

try {

adminModel=adminDao.adminLogin(loginId);
System.out.println(adminModel);
if(adminModel!=null) {
	
try {
res.sendRedirect("adminHome.jsp");
session.setAttribute("AdminHome", "HomeSession");
} catch (IOException e) {
System.out.println(e.getMessage());
}
}


else
{
throw new LoginException();
}
}
catch(LoginException e) {

	session.setAttribute("errors", e.getMessage());
	try {
		res.sendRedirect("index.jsp");
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
}

}
else if (loginId.contains("@admin.com") == false && loginId.matches("[0-9]+") == false) {
try {
// session.setAttribute("erroruserid", "user name mismatch");
throw new LoginException();
}
catch(LoginException e) {
session.setAttribute("errors", e.getMessage());
try {
	res.sendRedirect("index.jsp");
} catch (IOException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}}

}

//userLogin
else {
boolean userCheckFlag;
long userId=Long.parseLong(loginId);

System.out.println(userId);
userCheckFlag=userDao.checkUser(userId);
try {
if(userCheckFlag) {
userModel=userDao.loginUser(userId);
System.out.println(userModel.getUserPassword());

if(userModel.getUserPassword().equals(password)) {
try {
session.setAttribute("userdata", userModel);
session.setAttribute("userHome", "loginSession");
res.sendRedirect("userHomePage.jsp");
} catch (IOException e) {
System.out.println(e.getMessage());
}
}
else
{
throw new LoginException();
}


}
else
{
throw new LoginException();
}
}
catch(LoginException e) {
	
	session.setAttribute("errors", e.getMessage());
	try {
		res.sendRedirect("index.jsp");
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
}


}
}


}