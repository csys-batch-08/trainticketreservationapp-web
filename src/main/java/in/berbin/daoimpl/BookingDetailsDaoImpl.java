package in.berbin.daoimpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import in.berbin.model.BookingDetails;
import in.berbin.model.Trains;
import in.berbin.model.Users;
import in.berbin.util.ConnectionUtil;

public class BookingDetailsDaoImpl {
	TrainDaoImpl tDao=new TrainDaoImpl();
	UserDaoImpl uDao=new UserDaoImpl();
public boolean bookTicket(Users userModel,Trains trainModel, BookingDetails bookingDetailsModel)
{
	String bookTicketQuery="insert into booking_details(user_id,train_id,journey_date,ticket_count,total_price)values(?,?,?,?,?)";
	Connection con;
	int result=0;
	 SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	try {
		con=ConnectionUtil.getDBconnect();
		PreparedStatement pstmt=con.prepareStatement(bookTicketQuery);
		pstmt.setInt(1, userModel.getUserId());
		pstmt.setInt(2,trainModel.getTrainId());
		pstmt.setDate(3, java.sql.Date.valueOf(trainModel.getTrainDepartureTime().toLocalDate()));
		pstmt.setInt(4,bookingDetailsModel.getTicketCount());
		pstmt.setInt(5,bookingDetailsModel.getTotalPrice());
		result=	pstmt.executeUpdate();
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return result>0;
}
	




public boolean cancelTicket(Users userModel1,BookingDetails booking,Trains train,int totalAmount) {
	
	int totalseat = booking.getTicketCount() + train.getTotalseat();
	
	String toCancel="update booking_details set ticket_status='Cancelled' where pnr_number="+booking.getPnrNumber()+"";
	String refund = "update users set user_wallet="+totalAmount+" where user_id ="+userModel1.getUserId();
	String seats = "update  TRAINS set TOTAL_SEAT="+totalseat+" where TRAIN_ID="+train.getTrainId();
	int result = 0;
	try {
		Connection con=ConnectionUtil.getDBconnect();
		PreparedStatement pstatement=con.prepareStatement(toCancel);
		PreparedStatement pstwallet=con.prepareStatement(refund);
		PreparedStatement pstseat=con.prepareStatement(seats);
		
		result = pstatement.executeUpdate();
		
		result = pstwallet.executeUpdate();
		
		result = pstseat.executeUpdate();
		
	
		
	}catch(Exception  e) {
		System.out.println(e.getMessage());
	}
	
	return result>0;
}
	





//to show booking history of particular user

public List<BookingDetails>getBookingDetailsForPresentUser(Users userModel){
	
	String Query="select*from booking_details where user_id='"+userModel.getUserId()+"'";
	Connection con;
	
	PreparedStatement pstmt;
	ResultSet rs;
	
	List<BookingDetails>bookingList=new ArrayList<BookingDetails>();
	
    try {
		con=ConnectionUtil.getDBconnect();
		pstmt=con.prepareStatement(Query);
		rs=pstmt.executeQuery();
		while(rs.next()) {
			
			BookingDetails bookingDetailsModel=new BookingDetails(userModel,rs.getInt(2),rs.getLong(3),rs.getDate(4).toLocalDate(),rs.getDate(5).toLocalDate(),rs.getInt(6),rs.getInt(7),rs.getString(8));
	
			bookingList.add(bookingDetailsModel);
			
			
			
		}
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return bookingList;

}

public int findPnrNumber(Users userModel, BookingDetails bookingDetailsModel) {
	
	String bookingPnrFinder="select pnr_number from booking_details where user_id='"+userModel.getUserId()+"' and to_char(journey_date,'yyyy-mm-dd')='"+bookingDetailsModel.getJourneyDate()+"'";
	Connection con;
	PreparedStatement pstatement;
	int bookingPnr = 0;
	try {
		con=ConnectionUtil.getDBconnect();
		pstatement=con.prepareStatement(bookingPnrFinder);
		ResultSet rs=pstatement.executeQuery();
		if(rs.next()) {
			bookingPnr=rs.getInt(1);
		}
		
	} catch (ClassNotFoundException e) {
		e.getMessage();
	} catch (SQLException e) {
		e.getMessage();
	}
	return bookingPnr;
	
}

//to find booking details
public BookingDetails findBookedTicketsDetails(long pnrNumber) {
	String findTicketDetails="select * from booking_Details where pnr_number='"+pnrNumber+"'";
	
	Connection con;
	PreparedStatement pstatement;
	ResultSet rs;
	Trains trainModel=null;
	Users userModel=null;
	BookingDetails bookingDetailsModel=null;
	try {
		con=ConnectionUtil.getDBconnect();
		pstatement=con.prepareStatement(findTicketDetails);
		rs=pstatement.executeQuery();
		
		if(rs.next()) {
			trainModel=tDao.findTrainsDetailsUsingID(rs.getInt(2));
			
			userModel=uDao.getUserDetailsById(rs.getInt(1));
			
			bookingDetailsModel=new BookingDetails(userModel,rs.getInt(2),rs.getLong(3),rs.getDate(4).toLocalDate(),rs.getDate(5).toLocalDate(),rs.getInt(6),rs.getInt(7),rs.getString(8));
			
		}	
		return bookingDetailsModel;	
	} catch (ClassNotFoundException e) {
		e.getMessage();
	} catch (SQLException e) {
		e.getMessage();
	}
	
	return bookingDetailsModel;
}

public List<BookingDetails> showAllBookings()
{
	List<BookingDetails> allBookings= new ArrayList<BookingDetails>();
	String allUserBooking="select*from booking_details";
	Connection con =null;
	PreparedStatement ps;
	Users userModel=null;
	try {
		con=ConnectionUtil.getDBconnect();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		ps=con.prepareStatement(allUserBooking);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			BookingDetails bookingDetailsModel=new BookingDetails(rs.getInt(1),rs.getInt(2),rs.getLong(3),rs.getDate(4).toLocalDate(),rs.getDate(5).toLocalDate(),rs.getInt(6),rs.getInt(7),rs.getString(8));
			allBookings.add(bookingDetailsModel);
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return allBookings;
	
}
}