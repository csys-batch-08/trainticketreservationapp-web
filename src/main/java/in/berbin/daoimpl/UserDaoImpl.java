package in.berbin.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import in.berbin.dao.UserDAO;
import in.berbin.model.Users;
import in.berbin.util.ConnectionUtil;

public class UserDaoImpl implements UserDAO {
	@Override
	public Users loginUser(long UserMobileNumber ) {

		String userLogin = "select user_id,user_name,user_dob,user_email,user_mobileNumber,user_gender,user_password,user_wallet from users where user_mobileNumber=?";
		Connection con;
		Users userModel = null;
		try {
			con = ConnectionUtil.getDBconnect();
			PreparedStatement pstatement = con.prepareStatement(userLogin);
			pstatement.setLong(1, UserMobileNumber);
			ResultSet rs = pstatement.executeQuery();
			rs.next();
			userModel = new Users(rs.getInt("user_id"), rs.getString("user_name"), rs.getDate("user_dob").toLocalDate(), rs.getString("user_email"), rs.getLong("user_mobileNumber"),
					rs.getString("user_gender"), rs.getString("user_password"), rs.getInt("user_wallet"));
			con.close();
			pstatement.close();
			return userModel;
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return userModel;
	}
	

	
	@Override
	public boolean signUpUser(Users userModel) {

		String insertUser = "insert into users (user_name,user_dob,user_email,user_mobilenumber,user_gender,user_password) values (?,?,?,?,?,?)";
		Connection con;
		boolean signUpFlag=true;
		try {
			con = ConnectionUtil.getDBconnect();
			PreparedStatement pstatement = con.prepareStatement(insertUser);

			pstatement.setString(1, userModel.getUserName());
			pstatement.setDate(2, java.sql.Date.valueOf(userModel.getUserDob()));
			pstatement.setString(3, userModel.getUserEmail());
			pstatement.setLong(4, userModel.getUserMobileNumber());
			pstatement.setString(5, userModel.getUserGender());
			pstatement.setString(6, userModel.getUserPassword());

			int result = pstatement.executeUpdate();
			if (result > 0) {
				return signUpFlag;
			} else {
				return signUpFlag=false;
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		 return signUpFlag;
	}

	
	
	
    @Override
	public void update (Users UserModule) throws ClassNotFoundException, SQLException {
    	
    	String update="update users set user_name=?, user_dob=?, user_mobilenumber=?, user_gender=?, user_password=? where user_email='"+UserModule.getUserEmail()+"'";
    	
    	Connection con=ConnectionUtil.getDBconnect();
		PreparedStatement ps=con.prepareStatement(update);
		
		ps.setString(1,UserModule.getUserName());
		ps.setDate(2,java.sql.Date.valueOf(UserModule.getUserDob()));
		ps.setLong(3,UserModule.getUserMobileNumber());
		ps.setString(4,UserModule.getUserGender());
		ps.setString(5, UserModule.getUserPassword());
		
		int result=ps.executeUpdate();
		ps.close();
		con.close();
    }
	
    
    @Override
	public void delete (Users UserModule) throws ClassNotFoundException, SQLException {
		
		String del="delete from users where user_id=?";
		
		Connection con=ConnectionUtil.getDBconnect();
		PreparedStatement ps=con.prepareStatement(del);
		
		ps.setInt(1, UserModule.getUserId());
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
    	PreparedStatement ps;
    	try {
			con = ConnectionUtil.getDBconnect();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	try {
			ps = con.prepareStatement(showusersquery);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Users userModel = new Users(rs.getInt("user_id"), rs.getString("user_name"), rs.getDate("user_dob").toLocalDate(), rs.getString("user_email"), rs.getLong("user_mobileNumber"),
						rs.getString("user_gender"), rs.getString("user_password"), rs.getInt("user_wallet"));
				userList.add(userModel);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return userList;
    }
    //find userId 
    @Override
	public Users findUserDetails(long UserMobileNumber) {
    	String findUserDetailsQuery="select * from users where user_mobilenumber='" + UserMobileNumber+"'";
    	Connection con = null;
    	Statement stmt = null;
    	Users userModel = null;
			try {
				con = ConnectionUtil.getDBconnect();
				stmt = con.createStatement();
				ResultSet rs=stmt.executeQuery(findUserDetailsQuery);
				if(rs.next()) {
					userModel= new Users(rs.getInt("user_id"), rs.getString("user_name"), rs.getDate("user_dob").toLocalDate(), rs.getString("user_email"), rs.getLong("user_mobileNumber"),
							rs.getString("user_gender"), rs.getString("user_password"), rs.getInt("user_wallet"));
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		return userModel;
    }
	public boolean updateWallet(int updatedWallet, int userId) {
		String wallet = "update users set user_wallet=user_wallet+? where user_id=?";

		Connection con;
		PreparedStatement pstatement;
		int result = 0;
		try {
			con =ConnectionUtil.getDBconnect();
			pstatement = con.prepareStatement(wallet);

			pstatement.setInt(1, updatedWallet);
			pstatement.setLong(2, userId);
			result = pstatement.executeUpdate();
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return result > 0;

	}
	@Override
	public Users getUserDetailsById(int userId) 
	{ 

		String getUser = "select user_id,user_name,user_dob,user_email,user_mobileNumber,user_gender,user_password,user_wallet from users where user_id=?";
		Connection con = null;
		PreparedStatement pstatement = null;
		Users userModel = null;

		try {
			con = ConnectionUtil.getDBconnect();
			pstatement = con.prepareStatement(getUser);
			pstatement.setInt(1, userId);
			ResultSet rs = pstatement.executeQuery();

			if (rs.next()) {
				userModel =  new Users(rs.getInt("user_id"), rs.getString("user_name"), rs.getDate("user_dob").toLocalDate(), rs.getString("user_email"), rs.getLong("user_mobileNumber"),
						rs.getString("user_gender"), rs.getString("user_password"), rs.getInt("user_wallet"));
			}
			con.close();
			pstatement.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
		     e.getMessage();
		}
		return userModel;

	}
	@Override
	public boolean checkUser(long userMobileNumber ) {

		String userLogin = "select user_id,user_name,user_dob,user_email,user_mobileNumber,user_gender,user_password,user_wallet from users where user_mobilenumber=" + userMobileNumber;
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
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			
		}

		return checkUserFlag;
	}
	@Override
	public boolean checkExistingUserWhileRegister(long userMobileNumber) {

		String checkUser = "select user_id,user_name,user_dob,user_email,user_mobileNumber,user_gender,user_password,user_wallet from users where user_mobilenumber	=?";
		Connection con = null;
		PreparedStatement pstatement = null;
		Users userModel;
		boolean checkUserFlag = true;
		try {
			con =  ConnectionUtil.getDBconnect();
			pstatement = con.prepareStatement(checkUser);
			pstatement.setLong(1, userMobileNumber);
			ResultSet rs = pstatement.executeQuery();

			if (rs.next()) {
				userModel =  new Users(rs.getInt("user_id"), rs.getString("user_name"), rs.getDate("user_dob").toLocalDate(), rs.getString("user_email"), rs.getLong("user_mobileNumber"),
						rs.getString("user_gender"), rs.getString("user_password"), rs.getInt("user_wallet"));
				checkUserFlag = true;
			} else {
				checkUserFlag = false;
			}
			con.close();
			pstatement.close();
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return checkUserFlag;

	}

	@Override
	public boolean updateWallet(int updatedWallet, long userMobileNumber) {
		return false;
	}

	
}



