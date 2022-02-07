package in.berbin.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.berbin.model.BookingDetails;
import in.berbin.model.Trains;
import in.berbin.model.Users;
import in.berbin.util.ConnectionUtil;

public class BookingDetailsDaoImpl {
	TrainDaoImpl tDao = new TrainDaoImpl();
	UserDaoImpl uDao = new UserDaoImpl();

	public boolean bookTicket(Users userModel, Trains trainModel, BookingDetails bookingDetailsModel) {
		String bookTicketQuery = "insert into booking_details(user_id,train_id,journey_date,ticket_count,total_price)values(?,?,?,?,?)";
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			con = ConnectionUtil.getDBconnect();
			ps = con.prepareStatement(bookTicketQuery);
			ps.setInt(1, userModel.getUserId());
			ps.setInt(2, trainModel.getTrainId());
			ps.setDate(3, java.sql.Date.valueOf(trainModel.getTrainDepartureTime().toLocalDate()));
			ps.setInt(4, bookingDetailsModel.getTicketCount());
			ps.setInt(5, bookingDetailsModel.getTotalPrice());
			result = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(ps, con);
		}
		return result > 0;
	}

	public boolean cancelTicket(Users userModel1, BookingDetails booking, Trains train, int totalAmount) {

		int totalseat = booking.getTicketCount() + train.getTotalseat();

		String toCancel = "update booking_details set ticket_status='Cancelled' where pnr_number=?";
		String refund = "update users set user_wallet=? where user_id =?";
		String seats = "update  TRAINS set TOTAL_SEAT=? where TRAIN_ID=?";
		int result = 0;
		Connection con = null;
		PreparedStatement pstatement = null;
		PreparedStatement pstwallet = null;
		PreparedStatement pstseat = null;

		try {
			con = ConnectionUtil.getDBconnect();
			pstatement = con.prepareStatement(toCancel);
			pstatement.setLong(1, booking.getPnrNumber());
			pstwallet = con.prepareStatement(refund);
			pstwallet.setInt(1, totalAmount);
			pstwallet.setInt(2, userModel1.getUserId());
			pstseat = con.prepareStatement(seats);
			pstseat.setInt(1, totalseat);
			pstseat.setInt(2, train.getTrainId());
			result = pstatement.executeUpdate();
			result = pstwallet.executeUpdate();
			result = pstseat.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				con.close();
				pstatement.close();
				pstwallet.close();
				pstseat.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result > 0;
	}
//to show booking history of particular user

	public List<BookingDetails> getBookingDetailsForPresentUser(Users userModel) {
		String Query = "select t.TRAIN_ID,  t.TRAIN_NAME,t. TRAIN_CLASS,t.TRAIN_NUMBER, t.TRAIN_SOURCE,t.TRAIN_DESTINATION,t.TRAIN_DEPARTURE_TIME,"
				+ "t.TRAIN_ARRAIVAL_TIME, t. TOTAL_SEAT, t.TICKET_PRICE, b.USER_ID,  b.PNR_NUMBER, b.JOURNEY_DATE,b.BOOKING_DATE,"
				+ "b.TICKET_COUNT, b.TOTAL_PRICE,b.TICKET_STATUS from booking_details b inner join trains t on b.train_id=t.train_id where b.user_id=?";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<BookingDetails> bookingList = new ArrayList<>();

		try {
			con = ConnectionUtil.getDBconnect();
			ps = con.prepareStatement(Query);
			ps.setInt(1, userModel.getUserId());
			rs = ps.executeQuery();
			while (rs.next()) {
				Trains trains = new Trains(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4),
						rs.getString(5), rs.getString(6), rs.getTimestamp(7).toLocalDateTime(),
						rs.getTimestamp(8).toLocalDateTime(), rs.getInt(9), rs.getInt(10));
				BookingDetails bookingDetailsModel = new BookingDetails(userModel, trains, rs.getLong(12),
						rs.getDate(13).toLocalDate(), rs.getDate(14).toLocalDate(), rs.getInt(15), rs.getInt(16),
						rs.getString(17));
				bookingList.add(bookingDetailsModel);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(ps, con, rs);
		}
		return bookingList;

	}

//to find booking details
	public BookingDetails findBookedTicketsDetails(long pnrNumber) {
		String findTicketDetails = "select user_id,train_id,pnr_number,journey_date,booking_date,ticket_count,total_price,ticket_status from booking_Details where pnr_number=?";

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Trains trainModel = null;
		Users userModel = null;
		BookingDetails bookingDetailsModel = null;
		try {
			con = ConnectionUtil.getDBconnect();
			ps = con.prepareStatement(findTicketDetails);
			ps.setLong(1, pnrNumber);
			rs = ps.executeQuery();

			if (rs.next()) {
				trainModel = tDao.findTrainsDetailsUsingID(rs.getInt(2));

				userModel = uDao.getUserDetailsById(rs.getInt(1));

				bookingDetailsModel = new BookingDetails(userModel, rs.getInt(2), rs.getLong(3),
						rs.getDate(4).toLocalDate(), rs.getDate(5).toLocalDate(), rs.getInt(6), rs.getInt(7),
						rs.getString(8));

			}
			return bookingDetailsModel;
		} catch (SQLException e) {
			e.getMessage();
		} finally {
			ConnectionUtil.close(ps, con, rs);
		}

		return bookingDetailsModel;
	}

	public List<BookingDetails> showAllBookings() {
		List<BookingDetails> allBookings = new ArrayList<>();
		String allUserBooking = "select user_id,train_id,pnr_number,journey_date,booking_date,ticket_count,total_price,ticket_status from booking_details";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.getDBconnect();
			ps = con.prepareStatement(allUserBooking);
			rs = ps.executeQuery();
			while (rs.next()) {
				BookingDetails bookingDetailsModel = new BookingDetails(rs.getInt(1), rs.getInt(2), rs.getLong(3),
						rs.getDate(4).toLocalDate(), rs.getDate(5).toLocalDate(), rs.getInt(6), rs.getInt(7),
						rs.getString(8));
				allBookings.add(bookingDetailsModel);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(ps, con, rs);
		}
		return allBookings;

	}
}