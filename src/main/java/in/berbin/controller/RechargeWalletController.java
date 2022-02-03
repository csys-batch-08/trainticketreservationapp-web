package in.berbin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.berbin.daoimpl.UserDaoImpl;
import in.berbin.model.Users;
@WebServlet("/RechargeWalletController")
public class RechargeWalletController extends HttpServlet {
 @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	   HttpSession session2=req.getSession();
        Users userData=(Users)session2.getAttribute("userdata");
       UserDaoImpl userDao=new UserDaoImpl();
         Users userModel=userDao.getUserDetailsById(userData.getUserId());
        
         int amountEntered=Integer.parseInt(req.getParameter("ammounttoaddinwallet"));
         System.out.println(amountEntered);
         int totalAmount=amountEntered+userData.getUserwallet();
         userDao.updateWallet(amountEntered,userData.getUserId() );
       
         
         Users userModel1=new Users(userModel.getUserId(),userModel.getUserName(),userModel.getUserDob(),userModel.getUserEmail(),
       		  userModel.getUserMobileNumber(),userModel.getUserGender(),userModel.getUserPassword(),totalAmount);
         session2.setAttribute("userdata2", userModel1);
    
 		RequestDispatcher rd = req.getRequestDispatcher("amountaddsucessfully.jsp");
 		rd.forward(req, resp);
     
       
}
	
	
}
