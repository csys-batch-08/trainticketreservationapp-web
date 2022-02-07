package in.berbin.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.berbin.dao.UserDAO;
import in.berbin.model.Users;
import in.berbin.util.ConnectionUtil;

public class UserDaoImpl implements UserDAO {
	@Override
	public Users loginUser(long userMobileNumber ) {

		String userLogin = "select user_id,user_name,user_dob,user_email,user_mobileNumber,user_gender,user_password,user_wallet from users where user_mobileNumber=?";
		Connection con = null;
		PreparedStatement ps = null;
		Users userModel = null;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.getDBconnect();
		    ps = con.prepareStatement(userLogin);
		    ps.setLong(1, userMobileNumber);
		    rs = ps.executeQuery();
			rs.next();
			userModel = new Users(rs.getInt("user_id"), rs.getString("user_name"), rs.getDate("user_dob").toLocalDate(), rs.getString("user_email"), rs.getLong("user_mobileNumber"),
					rs.getString("user_gender"), rs.getString("user_password"), rs.getInt("user_wallet"));
			con.close();
			ps.close();
			return userModel;
		} catch ( SQLException e) {
			System.out.println(e.getMessage());
		} 
		finally {
			ConnectionUtil.close(ps,con,rs);
		}

		return userModel;
	}
	

	
	@Override
	public boolean signUpUser(Users userModel) {

		String insertUser = "insert into users (user_name,user_dob,user_email,user_mobilenumber,user_gender,user_password) values (?,?,?,?,?,?)";
		Connection con = null;
		PreparedStatement ps = null;
		boolean signUpFlag=true;
		try {
			con = ConnectionUtil.getDBconnect();
		    ps = con.prepareStatement(insertUser);

		    ps.setString(1, userModel.getUserName());
		    ps.setDate(2, java.sql.Date.valueOf(userModel.getUserDob()));
		    ps.setString(3, userModel.getUserEmail());
		    ps.setLong(4, userModel.getUserMobileNumber());
		    ps.setString(5, userModel.getUserGender());
		    ps.setString(6, userModel.getUserPassword());

			int result = ps.executeUpdate();
			if (result > 0) {
				return signUpFlag;
			} else {
				return signUpFlag=false;
			}
		} catch ( SQLException e) {
			System.out.println(e.getMessage());
		} 
		finally {
			ConnectionUtil.close(ps, con);
		}
		 return signUpFlag;
	}

	
	
	
    @Override
	public void update (Users userModule)  {
    	
    	String update="update users set user_name=?, user_dob=?, user_mobilenumber=?, user_gender=?, user_password=? where user_email=?";
    	Connection con = null;
    	PreparedStatement ps = null;
    	 try {
			con=ConnectionUtil.getDBconnect();
			 ps=con.prepareStatement(update);
			
			ps.setString(1,userModule.getUserName());
			ps.setDate(2,java.sql.Date.valueOf(userModule.getUserDob()));
			ps.setLong(3,userModule.getUserMobileNumber());
			ps.setString(4,userModule.getUserGender());
			ps.setString(5, userModule.getUserPassword());
			ps.setString(6, userModule.getUserEmail());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
    	 finally {
    		 ConnectionUtil.close(ps, con);
    	 }
    }
	
    
    @Override
	public void delete (Users userModule) throws ClassNotFoundException, SQLException {
		
		String del="delete from users where user_id=?";
		
		Connection con=ConnectionUtil.getDBconnect();
		PreparedStatement ps=con.prepareStatement(del);
		
		ps.setInt(1, userModule.getUserId());
		int res=ps.executeUpdate();
		ps.close();
		con.close();		
	}
    

    @Override
	public List<Users> showAllUsers()
    {
    	List<Users> userList = new ArrayList<Users>();
    	String showusersquery="select user_id,user_name,user_dob,user_email,user_mobileNumber,user_gender,user_password,user_wallet from users";
    	Connection con = null;
    	PreparedStatement ps=null;
    	ResultSet rs= null;
    	try {
    		con = ConnectionUtil.getDBconnect();
			ps = con.prepareStatement(showusersquery);
			rs=ps.executeQuery();
			while(rs.next())
			{
				Users userModel = new Users(rs.getInt("user_id"), rs.getString("user_name"), rs.getDate("user_dob").toLocalDate(), rs.getString("user_email"), rs.getLong("user_mobileNumber"),
						rs.getString("user_gender"), rs.getString("user_password"), rs.getInt("user_wallet"));
				userList.add(userModel);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
    	finally {
    		ConnectionUtil.close(ps, con ,rs);
    	}
    	return userList;
    }
    //find userId 
    @Override
	public Users findUserDetails(long userMobileNumber) {
    	String findUserDetailsQuery="select user_id,user_name,user_dob,user_email,user_mobileNumber,user_gender,user_password,user_wallet from users where user_mobilenumber=?";
    	Connection con = null;
    	PreparedStatement ps=null;
    	ResultSet rs= null;
    	Users userModel = null;
			try {
				con = ConnectionUtil.getDBconnect();
				ps = con.prepareStatement(findUserDetailsQuery);
				ps.setLong(1, userMobileNumber);
			    rs=ps.executeQuery();
				if(rs.next()) {
					userModel= new Users(rs.getInt("user_id"), rs.getString("user_name"), rs.getDate("user_dob").toLocalDate(), rs.getString("user_email"), rs.getLong("user_mobileNumber"),
							rs.getString("user_gender"), rs.getString("user_password"), rs.getInt("user_wallet"));
				}
			}  catch (SQLException e) {
				e.printStackTrace();
			}
		finally {
			ConnectionUtil.close(ps, con, rs);
		}
		return userModel;
    }
	public boolean updateWallet(int updatedWallet, int userId) {
		String wallet = "update users set user_wallet=user_wallet+? where user_id=?";

		Connection con=null;
		PreparedStatement ps=null;
		int result = 0;
		try {
			con =ConnectionUtil.getDBconnect();
			ps = con.prepareStatement(wallet);

			ps.setInt(1, updatedWallet);
			ps.setLong(2, userId);
			result = ps.executeUpdate();
		}  catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		finally {
			ConnectionUtil.close(ps, con);
		}
		return result > 0;

	}
	@Override
	public Users getUserDetailsById(int userId) 
	{ 
		String getUser = "select user_id,user_name,user_dob,user_email,user_mobileNumber,user_gender,user_password,user_wallet from users where user_id=?";
		Connection con = null;
		PreparedStatement ps = null;
		Users userModel = null;
		ResultSet rs =null;
		try {
			con = ConnectionUtil.getDBconnect();
			ps = con.prepareStatement(getUser);
			ps.setInt(1, userId);
			rs = ps.executeQuery();
			if (rs.next()) {
				userModel =  new Users(rs.getInt("user_id"), rs.getString("user_name"), rs.getDate("user_dob").toLocalDate(), rs.getString("user_email"), rs.getLong("user_mobileNumber"),
						rs.getString("user_gender"), rs.getString("user_password"), rs.getInt("user_wallet"));
			}
		}  catch (SQLException e) {
		     e.getMessage();
		}
		finally {
			ConnectionUtil.close(ps,con,rs);
		}
		return userModel;

	}
	@Override
	public boolean checkUser(long userMobileNumber ) {

		String userLogin = "select * from users where user_mobilenumber=" + userMobileNumber;
		Connection con;
		boolean checkUserFlag = true;
		try {
			con = ConnectionUtil.getDBconnect();
			PreparedStatement pstatement = con.prepareStatement(userLogin);

			int i = pstatement.executeUpdate(userLogin);
			if (i > 0) {
				checkUserFlag = true;
			} else {
				checkUserFlag = false;
			}
		}  catch (SQLException e) {
			System.out.println(e.getMessage());
			
		}

		return checkUserFlag;
	}
	

	@Override
	public boolean updateWallet(int updatedWallet, long userMobileNumber) {
		return false;
	}





	
}



