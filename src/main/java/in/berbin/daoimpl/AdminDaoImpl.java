package in.berbin.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import in.berbin.dao.AdminDAO;
import in.berbin.model.Admins;
import in.berbin.model.Trains;
import in.berbin.model.Users;
import in.berbin.util.ConnectionUtil;

public class AdminDaoImpl implements AdminDAO{

	public Admins adminLogin(String AdminEmailId)  {
	String loginadmin="select * from admins where admin_email='"+AdminEmailId+"'";

	Connection con;
	Admins adminmodule=null;
	try {
		con =ConnectionUtil.getDBconnect();
		PreparedStatement pstatement=con.prepareStatement(loginadmin);
		ResultSet rs=pstatement.executeQuery();
		
		if(rs.next()) {
			adminmodule=new Admins(rs.getString(2),rs.getLong(3),rs.getString(4),rs.getString(5));
		}
		
	} catch (ClassNotFoundException e) {
		System.out.println(e.getMessage());
	} catch (SQLException e) {
		System.out.println(e.getMessage());
	}
	
	return adminmodule;
}

public boolean checkadmin(String AdminEmailId)  {
	 
	String loginadmin="select * from admins where admin_email='"+AdminEmailId+"'";
	Connection con;
	System.out.println(loginadmin);
	boolean checkAdminFlag=false;
	try {
		con = ConnectionUtil.getDBconnect();
		PreparedStatement ps=con.prepareStatement(loginadmin);
		ResultSet i=ps.executeQuery(loginadmin);
		
		if(i.next()) {
			checkAdminFlag= true;
		}
		
	} catch (ClassNotFoundException e) {
		System.out.println(e.getMessage());
	} catch (SQLException e) {
		System.out.println(e.getMessage());
	}
	return checkAdminFlag;
}


public void updateAdmin (Admins AdminModel) {
	
	String adminUpdate="update admins set admin_name=?,admin_MobileNumber=?, admin_password=? where admin_email='"+AdminModel.getAdminEmail()+"'";
	
	Connection con;
	try {
		con = ConnectionUtil.getDBconnect();
		PreparedStatement pstatement=con.prepareStatement(adminUpdate);
		
		pstatement.setString(1, AdminModel.getAdminName());
		pstatement.setLong(2, AdminModel.getAdminMobileNumber());
		pstatement.setString(3, AdminModel.getAdminPassword());
		
		pstatement.executeUpdate();
		System.out.println("for "+AdminModel.getAdminEmail()+ "profile is updated !!");
		pstatement.close();
		con.close();
	} catch (ClassNotFoundException e) {
		System.out.println(e.getMessage());
	} catch (SQLException e) {
		System.out.println(e.getMessage());
	}
	
}


public List<Admins> viewAdmin(){
	
	String adminView="select * from admins";
	
	Connection con;
	List<Admins> adminList=new ArrayList<Admins>();
	try {
		con = ConnectionUtil.getDBconnect();
		PreparedStatement pstatement=con.prepareStatement(adminView);
		
		ResultSet rs=pstatement.executeQuery();
		
		while(rs.next()) {
			Admins adminModel=new Admins(rs.getString(2),rs.getLong(3),rs.getString(4),rs.getString(5));
			adminList.add(adminModel);
		}
		
	} catch (ClassNotFoundException e) {
		System.out.println(e.getMessage());
	} catch (SQLException e) {
		System.out.println(e.getMessage());
	}
	
	return adminList;
	
}


}