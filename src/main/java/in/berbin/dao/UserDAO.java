
package in.berbin.dao;

import java.sql.SQLException;
import java.util.List;

import in.berbin.model.Users;

public interface UserDAO {
	public Users loginUser(long UserMobileNumber );
	
	
	public boolean signUpUser(Users userModel);
	
	public void update (Users UserModule) throws ClassNotFoundException, SQLException;
	
	   public void delete (Users UserModule) throws ClassNotFoundException, SQLException;
	   
	   public List<Users> showAllUsers();
	   
	   public Users findUserDetails(long userMobileNumber);
	   
		public boolean updateWallet(int updatedWallet, long userMobileNumber);
		
		public Users getUserDetailsById(int userId);
		
		public boolean checkUser(long userMobileNumber );
		
		public boolean checkExistingUserWhileRegister(long userMobileNumber);
		
}	

