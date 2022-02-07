package in.berbin.dao;

import in.berbin.model.Admins;

public interface AdminDAO {

	public Admins adminLogin(String AdminEmailId);
	public boolean checkadmin(String AdminEmailId);
	
}