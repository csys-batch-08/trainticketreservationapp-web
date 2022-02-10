
package com.berbin.dao;

import java.sql.SQLException;
import java.util.List;

import com.berbin.model.Users;

public interface UserDAO {
	public Users loginUser(long userMobileNumber );
	
	
	public boolean signUpUser(Users userModel);
	
	public void update (Users userModule) throws ClassNotFoundException, SQLException;
	   
	   public List<Users> showAllUsers();
	   
	   public Users findUserDetails(long userMobileNumber);
	   
		public boolean updateWallet(int updatedWallet, long userMobileNumber);
		
		public Users getUserDetailsById(int userId);
		
		public boolean checkUser(long userMobileNumber );
		
		
}	

