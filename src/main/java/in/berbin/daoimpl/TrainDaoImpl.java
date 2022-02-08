package in.berbin.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import in.berbin.model.Trains;
import in.berbin.util.ConnectionUtil;

public class TrainDaoImpl {

	public boolean insertTrain(Trains trainmodule) {
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
		String inserttrainquery = "insert into trains (train_name,train_class,train_number,train_source,train_destination,train_departure_time,train_arraival_time,total_seat,ticket_price) values (?,?,?,?,?,?,?,?,?)";
		Connection con = null;
		PreparedStatement ps = null;
		int i=0;
		try {
			con = ConnectionUtil.getDBconnect();
			ps = con.prepareStatement(inserttrainquery);
			ps.setString(1, trainmodule.getTrainName());
			ps.setString(2, trainmodule.getTrainClass());
			ps.setInt(3, trainmodule.getTrainNumber());
			ps.setString(4, trainmodule.getTrainSource());
			ps.setString(5, trainmodule.getTrainDestination());
			Timestamp departureDateTime = Timestamp.valueOf(trainmodule.getTrainDepartureTime());
			ps.setTimestamp(6, departureDateTime);
			Timestamp arrivalDateTime = Timestamp.valueOf(trainmodule.getTrainArraivalTime());
			ps.setTimestamp(7, arrivalDateTime);
			ps.setInt(8, trainmodule.getTotalseat());
			ps.setInt(9, trainmodule.getTicketPrice());

	       i=ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			ConnectionUtil.close(ps, con);
		}
		return i>0;
	}

	public boolean updatetrain(Trains trainmodule) {
		String updatetrainquery = "update trains set  train_name=?, train_class=?, train_source=?, train_destination=?,train_departure_time=?,train_arraival_time=?, total_seat=?,ticket_price=? where train_number=?";
		int i=0;
		Connection con =null;
		PreparedStatement ps =null;
		try {
		    con = ConnectionUtil.getDBconnect();
		    ps = con.prepareStatement(updatetrainquery);
			ps.setString(1, trainmodule.getTrainName());
			ps.setString(2, trainmodule.getTrainClass());
			ps.setString(3, trainmodule.getTrainSource());
			ps.setString(4, trainmodule.getTrainDestination());
			Timestamp departureDateTime = Timestamp.valueOf(trainmodule.getTrainDepartureTime());
			ps.setTimestamp(5, departureDateTime);
			Timestamp arrivalDateTime = Timestamp.valueOf(trainmodule.getTrainArraivalTime());
			ps.setTimestamp(6, arrivalDateTime);
			ps.setInt(7, trainmodule.getTotalseat());
			ps.setInt(8, trainmodule.getTicketPrice());
			ps.setLong(9, trainmodule.getTrainNumber());
			i=ps.executeUpdate();
			ps.close();
			con.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			ConnectionUtil.close(ps, con);
		}
		return i>0;
	}

	// to show all trains
	public List<Trains> showAllTrains() {
		List<Trains> trainList = new ArrayList<>();
		String listquery = "select train_id,train_name,train_class,train_number,train_source,train_destination,train_departure_time,train_arraival_time,total_seat,ticket_price from trains";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.getDBconnect();
		
		
			ps = con.prepareStatement(listquery);
		    rs = ps.executeQuery();
			while (rs.next()) {
				Trains trainModel = new Trains(rs.getInt("train_id"), rs.getString("train_name"),
						rs.getString("train_class"), rs.getInt("train_number"), rs.getString("train_source"),
						rs.getString("train_destination"), rs.getTimestamp("train_departure_time").toLocalDateTime(),
						rs.getTimestamp("train_arraival_time").toLocalDateTime(), rs.getInt("total_seat"),
						rs.getInt("ticket_price"));
				trainList.add(trainModel);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		finally {
			ConnectionUtil.close(ps,con,rs);
		}
		return trainList;
	}

//to find train id
	public int findTrainId(Trains trainModel) {
		String findTrainIdQuery = "select train_id from trains where train_number =?";
		Connection con = null;
		int trainId = 0;
		PreparedStatement ps=null;
		try {
			con = ConnectionUtil.getDBconnect();
		    ps=con.prepareStatement(findTrainIdQuery);
		    ps.setInt(1,trainModel.getTrainNumber());		
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				trainId = rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		finally {
			ConnectionUtil.close(ps, con);
		}
		return trainId;
	}

	// to find train details
	public Trains findTrainDetailsUsingTrainNumber(int trainNumber) {
		String findTrainDetails = "select train_id,train_name,train_class,train_number,train_source,train_destination,train_departure_time,train_arraival_time,total_seat,ticket_price from trains where train_number =?";
		Connection con = null;
		Trains trainModel1 = null;
		PreparedStatement ps = null;
		ResultSet rs=null;

		try {
			con = ConnectionUtil.getDBconnect();
			ps = con.prepareStatement(findTrainDetails);
			ps.setInt(1,trainNumber);
			
			rs = ps.executeQuery(findTrainDetails);
			while (rs.next()) {
				trainModel1 = new Trains(rs.getInt("train_id"), rs.getString("train_name"), rs.getString("train_class"),
						rs.getInt("train_number"), rs.getString("train_source"), rs.getString("train_destination"),
						rs.getTimestamp("train_departure_time").toLocalDateTime(),
						rs.getTimestamp("train_arraival_time").toLocalDateTime(), rs.getInt("total_seat"),
						rs.getInt("ticket_price"));
			}
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			ConnectionUtil.close(ps,con,rs);
		}
		return trainModel1;
	}

	// to search train
	// to search train
//	public List<Trains> searchTrain(LocalDate DepartureDate, String source, String destination)
//			throws ClassNotFoundException, SQLException {
//		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
//
//		LocalDate ld = LocalDate();
//
//		String findTrain = "select train_id,train_name,train_class,train_number,train_source,train_destination,train_departure_time,train_arraival_time,total_seat,ticket_price from trains where to_char(train_departure_time,'yyyy-mm-dd')=? and train_source=? and train_destination=?";
//
//		Trains trainModel;
//		List<Trains> trainsearchList = new ArrayList<Trains>();
//
//		Connection con = ConnectionUtil.getDBconnect();
//		PreparedStatement pstatement = con.prepareStatement(findTrain);
//		pstatement.setDate(1, java.sql.Date.valueOf(DepartureDate));
//		pstatement.setString(2, source);
//		pstatement.setString(3, destination);
//		ResultSet rs = pstatement.executeQuery();
//
//		while (rs.next()) {
//			trainModel = new Trains(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
//					rs.getString(6), rs.getTimestamp(7).toLocalDateTime(), rs.getTimestamp(8).toLocalDateTime(),
//					rs.getInt(9), rs.getInt(10));
//			trainsearchList.add(trainModel);
//
//		}
//		return trainsearchList;
//
//	}

	// to search train
	public List<Trains> searchTrain(LocalDate DepartureDate, String source, String destination)
			throws ClassNotFoundException, SQLException {

		LocalDate ld = LocalDate();

		String findTrain = "select train_id,train_name,train_class,train_number,train_source,train_destination,train_departure_time,train_arraival_time,total_seat,ticket_price from trains where to_char(train_departure_time,'yyyy-mm-dd')='" + DepartureDate
				+ "' and train_source='" + source + "' and train_destination='" + destination + "'";

		Trains trainModel;
		List<Trains> trainsearchList = new ArrayList<Trains>();

		Connection con = ConnectionUtil.getDBconnect();
		PreparedStatement pstatement = con.prepareStatement(findTrain);

		ResultSet rs = pstatement.executeQuery();

		while (rs.next()) {
			trainModel = new Trains(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
					rs.getString(6), rs.getTimestamp(7).toLocalDateTime(), rs.getTimestamp(8).toLocalDateTime(),
					rs.getInt(9), rs.getInt(10));
			trainsearchList.add(trainModel);

		}
		return trainsearchList;

	}

	private LocalDate LocalDate() {
		return null;
	}

	public boolean updateSeatCount(Trains trainModel) {

		String updateSeat = "update trains set total_seat=? where train_id=?";
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ConnectionUtil.getDBconnect();
			 ps = con.prepareStatement(updateSeat);
			 ps.setInt(1, trainModel.getTotalseat());
			 ps.setInt(2, trainModel.getTrainId());
			 ps.executeUpdate();
		} catch ( SQLException e) {
			System.out.println(e.getMessage());
		} 
		finally {
			ConnectionUtil.close(ps, con);
		}
		return false;
	}

	// traindetails using id
	public Trains findTrainsDetailsUsingID(int trainId) {
		String getTrain = "select train_id,train_name,train_class,train_number,train_source,train_destination,train_departure_time,train_arraival_time,total_seat,ticket_price from trains where train_id=?";
		Connection con = null;
		PreparedStatement ps = null;
		Trains trainModel = null;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.getDBconnect();
			ps = con.prepareStatement(getTrain);
			ps.setInt(1, trainId);
		    rs = ps.executeQuery();
			if (rs.next()) {
				trainModel = new Trains(rs.getInt("train_id"), rs.getString("train_name"), rs.getString("train_class"),
						rs.getInt("train_number"), rs.getString("train_source"), rs.getString("train_destination"),
						rs.getTimestamp("train_departure_time").toLocalDateTime(),
						rs.getTimestamp("train_arraival_time").toLocalDateTime(), rs.getInt("total_seat"),
						rs.getInt("ticket_price"));
			}
			con.close();
			ps.close();
		} catch ( SQLException e) {
			e.getMessage();
			System.out.println("classnot found");
		} 
		finally {
			ConnectionUtil.close(ps, con, rs);
		}
		return trainModel;
	}
}