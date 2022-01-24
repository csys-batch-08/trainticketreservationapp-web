package in.berbin.model;


import java.time.LocalDate;
import java.util.Objects;

public class BookingDetails {

private Users usermodel;
private Trains trainModel;
private int trainid;
private long pnrNumber;
private LocalDate journeyDate;
private LocalDate bookingDate;
private int ticketCount;
//private String seatNo;
private int totalPrice;
private String ticketStatus;
private int userId;







public BookingDetails() {
	super();
	// TODO Auto-generated constructor stub
}



public BookingDetails(Users usermodel, int trainid, LocalDate journeyDate,
		 int ticketCount, int totalPrice
		) {
	super();
	this.usermodel = usermodel;
	this.trainid = trainid;
	this.journeyDate = journeyDate;
	this.ticketCount = ticketCount;
	this.totalPrice = totalPrice;

}












public BookingDetails(Users usermodel, int trainid, long pnrNumber, LocalDate journeyDate, LocalDate bookingDate,
		int ticketCount, int totalPrice, String ticketStatus) {
	super();
	this.usermodel = usermodel;
	this.trainid = trainid;
	this.pnrNumber = pnrNumber;
	this.journeyDate = journeyDate;
	this.bookingDate = bookingDate;
	this.ticketCount = ticketCount;
	this.totalPrice = totalPrice;
	this.ticketStatus = ticketStatus;
}

public BookingDetails(int userId, int trainid, long pnrNumber, LocalDate journeyDate, LocalDate bookingDate,
		int ticketCount, int totalPrice, String ticketStatus) {
	super();
	this.userId = userId;
	this.trainid = trainid;
	this.pnrNumber = pnrNumber;
	this.journeyDate = journeyDate;
	this.bookingDate = bookingDate;
	this.ticketCount = ticketCount;
	this.totalPrice = totalPrice;
	this.ticketStatus = ticketStatus;
}



public BookingDetails(Users usermodel, Trains trainModel, long pnrNumber, LocalDate journeyDate, LocalDate bookingDate,
		int ticketCount, int totalPrice, String ticketStatus) {
	super();
	this.usermodel = usermodel;
	this.trainModel = trainModel;
	this.pnrNumber = pnrNumber;
	this.journeyDate = journeyDate;
	this.bookingDate = bookingDate;
	this.ticketCount = ticketCount;
	this.totalPrice = totalPrice;
	this.ticketStatus = ticketStatus;
}



public BookingDetails(Users usermodel, int trainid, long pnrNumber, LocalDate journeyDate, int ticketCount,
		int totalPrice) {
	super();
	this.usermodel = usermodel;
	this.trainid = trainid;
	this.pnrNumber = pnrNumber;
	this.journeyDate = journeyDate;
	this.ticketCount = ticketCount;
	this.totalPrice = totalPrice;
}



public BookingDetails(Users userModel2, Trains trainModel ,long pnrnumber, LocalDate journeyDate, int ticketCount, int totalPrice) {
	// TODO Auto-generated constructor stub
	this.usermodel=userModel2;
	this.trainModel=trainModel;
	this.pnrNumber=pnrnumber;
	this.journeyDate=journeyDate;
	this.ticketCount=ticketCount;
	this.totalPrice=totalPrice;
}



public Trains getTrainModel() {
	return trainModel;
}



public void setTrainModel(Trains trainModel) {
	this.trainModel = trainModel;
}



public Users getUsermodel() {
	return usermodel;
}



public void setUsermodel(Users usermodel) {
	this.usermodel = usermodel;
}







public int getUserId() {
	return userId;
}



public void setUserId(int userId) {
	this.userId = userId;
}



public int getTrainid() {
	return trainid;
}



public void setTrainid(int trainid) {
	this.trainid = trainid;
}



public long getPnrNumber() {
	return pnrNumber;
}



public void setPnrNumber(long pnrNumber) {
	this.pnrNumber = pnrNumber;
}



public LocalDate getJourneyDate() {
	return journeyDate;
}



public void setJourneyDate(LocalDate journeyDate) {
	this.journeyDate = journeyDate;
}



public LocalDate getBookingDate() {
	return bookingDate;
}



public void setBookingDate(LocalDate bookingDate) {
	this.bookingDate = bookingDate;
}



public int getTicketCount() {
	return ticketCount;
}



public void setTicketCount(int ticketCount) {
	this.ticketCount = ticketCount;
}



public int getTotalPrice() {
	return totalPrice;
}



public void setTotalPrice(int totalPrice) {
	this.totalPrice = totalPrice;
}



public String getTicketStatus() {
	return ticketStatus;
}



public void setTicketStatus(String ticketStatus) {
	this.ticketStatus = ticketStatus;
}



@Override
public String toString() {
	return "BookingDetailsModel [usermodel=" + usermodel + ", trainmodel=" + trainid + ", pnrNumber=" + pnrNumber
			+ ", journeyDate=" + journeyDate + ", bookingDate=" + bookingDate + ", ticketCount=" + ticketCount
			+ ", totalPrice=" + totalPrice + ", ticketStatus=" + ticketStatus + "]";
}



@Override
public int hashCode() {
	return Objects.hash(bookingDate, journeyDate, pnrNumber, ticketCount, ticketStatus, totalPrice, trainid,
			usermodel);
}





}
