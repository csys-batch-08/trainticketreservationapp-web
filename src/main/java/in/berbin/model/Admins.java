package in.berbin.model;

import java.util.Objects;

public class Admins {
	private int adminId;
	private String adminName;
	private long adminMobileNumber;
	private String adminPassword;
	private String adminEmail;
	
	
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public long getAdminMobileNumber() {
		return adminMobileNumber;
	}
	public void setAdminMobileNumber(long adminMobileNumber) {
		this.adminMobileNumber = adminMobileNumber;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	public String getAdminEmail() {
		return adminEmail;
	}
	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}
	@Override
	public int hashCode() {
		return Objects.hash(adminEmail, adminId, adminMobileNumber, adminName, adminPassword);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Admins other = (Admins) obj;
		return Objects.equals(adminEmail, other.adminEmail) && adminId == other.adminId
				&& adminMobileNumber == other.adminMobileNumber && Objects.equals(adminName, other.adminName)
				&& Objects.equals(adminPassword, other.adminPassword);
	}
	@Override
	public String toString() {
		return "AdminModel [adminId=" + adminId + ", adminName=" + adminName + ", adminMobileNumber="
				+ adminMobileNumber + ", adminPassword=" + adminPassword + ", adminEmail=" + adminEmail + "]";
	}
	public Admins(int adminId, String adminName, long adminMobileNumber, String adminPassword, String adminEmail) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.adminMobileNumber = adminMobileNumber;
		this.adminPassword = adminPassword;
		this.adminEmail = adminEmail;
	}
	public Admins() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Admins(String adminName, long adminMobileNumber, String adminPassword, String adminEmail) {
		// TODO Auto-generated constructor stub
		this.adminName = adminName;
		this.adminMobileNumber = adminMobileNumber;
		this.adminPassword = adminPassword;
		this.adminEmail = adminEmail;
	}
	
}