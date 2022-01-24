package in.berbin.dao;

import java.util.List;

import in.berbin.model.Admins;

public interface AdminDAO {

	public Admins adminLogin(String AdminEmailId);
	public boolean checkadmin(String AdminEmailId);
	public void updateAdmin (Admins AdminModel);
	public List<Admins> viewAdmin();
}