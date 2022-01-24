package in.berbin.dao;

import java.util.List;

import in.berbin.model.BookingDetails;
import in.berbin.model.Trains;
import in.berbin.model.Users;

public interface BookinDetailsDAO {
	public boolean bookTicket(Users userModel,Trains trainModel, BookingDetails bookingDetailsModel);
	public boolean cancelTicket(Users userModel1,BookingDetails booking,Trains train);
	public List<BookingDetails>getBookingDetailsForCurrentUser(Users userModel);
	public int findPnrNumber(Users userModel, BookingDetails bookingDetailsModel);
	public BookingDetails findBookedTicketsDetails(long pnrNumber);
	public List<BookingDetails> showAllBookings();
	
}