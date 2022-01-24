package in.berbin.model;

import java.time.LocalDate;
import java.util.Objects;

public class Users {
	private int userId;
	private String userName;
	private LocalDate userDob;
	private String userEmail;
	private long userMobileNumber;
	private String userGender;
	private String userPassword;
	private int userwallet;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public LocalDate getUserDob() {
		return userDob;
	}
	public void setUserDob(LocalDate userDob) {
		this.userDob = userDob;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public long getUserMobileNumber() {
		return userMobileNumber;
	}
	public void setUserMobileNumber(long userMobileNumber) {
		this.userMobileNumber = userMobileNumber;
	}
	public String getUserGender() {
		return userGender;
	}
	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public int getUserwallet() {
		return userwallet;
	}
	public void setUserwallet(int userwallet) {
		this.userwallet = userwallet;
	}
	@Override
	public int hashCode() {
		return Objects.hash(userDob, userEmail, userGender, userId, userMobileNumber, userName, userPassword,
				userwallet);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Users other = (Users) obj;
		return Objects.equals(userDob, other.userDob) && Objects.equals(userEmail, other.userEmail)
				&& Objects.equals(userGender, other.userGender) && userId == other.userId
				&& userMobileNumber == other.userMobileNumber && Objects.equals(userName, other.userName)
				&& Objects.equals(userPassword, other.userPassword) && userwallet == other.userwallet;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userDob=" + userDob + ", userEmail=" + userEmail
				+ ", userMobileNumber=" + userMobileNumber + ", userGender=" + userGender + ", userPassword="
				+ userPassword + ", userwallet=" + userwallet + "]";
	}
	public Users(int userId, String userName, LocalDate userDob, String userEmail, long userMobileNumber,
			String userGender, String userPassword, int userwallet) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userDob = userDob;
		this.userEmail = userEmail;
		this.userMobileNumber = userMobileNumber;
		this.userGender = userGender;
		this.userPassword = userPassword;
		this.userwallet = userwallet;
	}
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Users(String userName, LocalDate userDob, String userEmail, long userMobileNumber, String userGender, String userPassword) {
		// TODO Auto-generated constructor stub
		this.userName = userName;
		this.userDob = userDob;
		this.userEmail = userEmail;
		this.userMobileNumber = userMobileNumber;
		this.userGender = userGender;
		this.userPassword = userPassword;
	}

}
