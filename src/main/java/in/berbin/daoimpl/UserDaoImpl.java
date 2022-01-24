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
	public Users loginUser(long UserMobileNumber ) {

		String userLogin = "select * from users where user_mobileNumber='" + UserMobileNumber + "'";
		Connection con;
		Users userModel = null;
		try {
			con = ConnectionUtil.getDBconnect();
			PreparedStatement pstatement = con.prepareStatement(userLogin);

			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(userLogin);

			rs.next();
			userModel = new Users(rs.getInt(1), rs.getString(2), rs.getDate(3).toLocalDate(), rs.getString(4), rs.getLong(5),
					rs.getString(6), rs.getString(7), rs.getInt(8));
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
		System.out.println(result+ " is updated !!");
		ps.close();
		con.close();
    }
	
    
    public void delete (Users UserModule) throws ClassNotFoundException, SQLException {
		
		String del="delete from users where user_id=?";
		
		Connection con=ConnectionUtil.getDBconnect();
		PreparedStatement ps=con.prepareStatement(del);
		
		ps.setInt(1, UserModule.getUserId());
		int res=ps.executeUpdate();
		System.out.println(res + "is deleted");
		ps.close();
		con.close();		
	}
    

    public List<Users> showAllUsers()
    {
    	List<Users> userList = new ArrayList<Users>();
    	String showusersquery="select*from users";
    	Connection con = null;
    	PreparedStatement ps;
    	try {
			con = ConnectionUtil.getDBconnect();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	try {
			ps = con.prepareStatement(showusersquery);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Users userModel =new Users(rs.getInt(1),rs.getString(2),rs.getDate(3).toLocalDate(),rs.getString(4),rs.getLong(5),rs.getString(6),rs.getString(7),rs.getInt(8));
				userList.add(userModel);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return userList;
    }
    //find userId 
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
					userModel=new Users(rs.getInt(1),rs.getString(2),rs.getDate(3).toLocalDate(),rs.getString(4),rs.getLong(5),rs.getString(6),rs.getString(7),rs.getInt(8));
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
	public Users getUserDetailsById(int userId) 
	{ 

		String getUser = "select * from users where user_id=?";
		Connection con = null;
		PreparedStatement pstatement = null;
		Users userModel = null;

		try {
			con = ConnectionUtil.getDBconnect();
			pstatement = con.prepareStatement(getUser);
			pstatement.setInt(1, userId);
			ResultSet rs = pstatement.executeQuery();

			if (rs.next()) {
				userModel = new Users(rs.getInt(1), rs.getString(2), rs.getDate(3).toLocalDate(), rs.getString(4), rs.getLong(5),
						rs.getString(6), rs.getString(7), rs.getInt(8));
			}
			con.close();
			pstatement.close();
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return userModel;

	}
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
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			
		}

		return checkUserFlag;
	}
	public boolean checkExistingUserWhileRegister(long userMobileNumber) {

		String checkUser = "select * from users where user_mobilenumber	=?";
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
				userModel = new Users(rs.getInt(1), rs.getString(2), rs.getDate(3).toLocalDate(), rs.getString(4), rs.getLong(5),
						rs.getString(6), rs.getString(7), rs.getInt(8));
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
		// TODO Auto-generated method stub
		return false;
	}

	
}



