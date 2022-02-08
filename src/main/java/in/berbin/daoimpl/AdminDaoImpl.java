package in.berbin.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.berbin.dao.AdminDAO;
import in.berbin.model.Admins;
import in.berbin.util.ConnectionUtil;

public class AdminDaoImpl implements AdminDAO{

	@Override
	public Admins adminLogin(String adminEmailId)  {
	String loginadmin="select admin_id,admin_name,admin_mobilenumber,admin_password,admin_email from admins where admin_email=?";

	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	Admins adminmodule=null;
	try {
		con =ConnectionUtil.getDBconnect();
	    ps=con.prepareStatement(loginadmin);
	    ps.setString(1, adminEmailId);
		rs=ps.executeQuery();
		
		if(rs.next()) {
			adminmodule=new Admins(rs.getString(2),rs.getLong(3),rs.getString(4),rs.getString(5));
		}
		
	} catch (SQLException e) {
		System.out.println(e.getMessage());
	}
	finally {
		ConnectionUtil.close(ps, con, rs);
	}
	
	return adminmodule;
}

@Override
public boolean checkadmin(String adminEmailId)  {
	 
	String loginadmin="select admin_id,admin_name,admin_mobilenumber,admin_password,admin_email from admins from admins where admin_email=?";
	Connection con = null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	boolean checkAdminFlag=false;
	try {
		con = ConnectionUtil.getDBconnect();
		ps=con.prepareStatement(loginadmin);
		ps.setString(1, adminEmailId);
		rs=ps.executeQuery(loginadmin);		
		if(rs.next()) {
			checkAdminFlag= true;
		}	
	}  catch (SQLException e) {
		System.out.println(e.getMessage());
	}
	finally {
		ConnectionUtil.close(ps, con, rs);
	}
	return checkAdminFlag;
}



}