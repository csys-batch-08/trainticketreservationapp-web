package com.berbin.dao;

import com.berbin.model.Admins;

public interface AdminDAO {

	public Admins adminLogin(String AdminEmailId);
	public boolean checkadmin(String AdminEmailId);
	
}