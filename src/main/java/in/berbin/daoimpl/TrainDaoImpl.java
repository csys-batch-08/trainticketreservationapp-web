package in.berbin.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import in.berbin.model.Trains;
import in.berbin.util.CloseConnection;
import in.berbin.util.ConnectionUtil;

public class TrainDaoImpl {

	public void insertTrain(Trains trainmodule) {
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
		String inserttrainquery = "insert into trains (train_name,train_class,train_number,train_source,train_destination,train_departure_time,train_arraival_time,total_seat,ticket_price) values (?,?,?,?,?,?,?,?,?)";
		Connection con=null;
		PreparedStatement ps=null;
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

			 ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			CloseConnection.close(ps, con);
		}
	}

	public void updatetrain(Trains trainmodule) {
		String updatetrainquery = "update trains set  train_name=?, train_class=?, train_source=?, train_destination=?,train_departure_time=?,train_arraival_time=?, total_seat=?,ticket_price=? where train_number=?";
		try {
			Connection con = ConnectionUtil.getDBconnect();

			PreparedStatement ps = con.prepareStatement(updatetrainquery);
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
		    ps.executeUpdate();
			ps.close();
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void deletetrain(Trains trainmodule) {
		String deletetrainquery = "delete from trains where train_number=?";
		try {
			Connection con = ConnectionUtil.getDBconnect();
			PreparedStatement ps = con.prepareStatement(deletetrainquery);
			ps.setInt(1, trainmodule.getTrainNumber());
			ps.executeUpdate();
			ps.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// to show all trains
	public List<Trains> showAllTrains() {
		List<Trains> trainList = new ArrayList<Trains>();
		String listquery = "select train_id,train_name,train_class,train_number,train_source,train_destination,train_departure_time,train_arraival_time,total_seat,ticket_price from trains";
		Connection con = null;
		PreparedStatement ps;
		try {
			con = ConnectionUtil.getDBconnect();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			ps = con.prepareStatement(listquery);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Trains trainModel = new Trains(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4),
						rs.getString(5), rs.getString(6), rs.getTimestamp(7).toLocalDateTime(),
						rs.getTimestamp(8).toLocalDateTime(), rs.getInt(9), rs.getInt(10));
				trainList.add(trainModel);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return trainList;

	}

//to find train id
	public int findTrainId(Trains trainModel) {
		String findTrainIdQuery = "select train_id from trains where train_number = " + trainModel.getTrainNumber();
		Connection con = null;
		try {
			con = ConnectionUtil.getDBconnect();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Statement stmt = null;
		int trainId = 0;
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			ResultSet rs = stmt.executeQuery(findTrainIdQuery);
			if (rs.next()) {				
				trainId = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return trainId;
	}

	// to find train details
	public Trains findTrainDetailsUsingTrainNumber(int trainNumber) {
		String findTrainDetails = "select train_name,train_class,train_number,train_source,train_destination,train_departure_time,train_arraival_time,total_seat,ticket_price from trains where train_number = " + trainNumber;
		Connection con = null;
		Trains trainModel1 = null;
		Statement ps = null;

		try {
			con = ConnectionUtil.getDBconnect();
			ps = con.createStatement();

			ResultSet rs = ps.executeQuery(findTrainDetails);
			while (rs.next()) {
				trainModel1 = new Trains(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getString(6), rs.getTimestamp(7).toLocalDateTime(), rs.getTimestamp(8).toLocalDateTime(),
						rs.getInt(9), rs.getInt(10));

			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return trainModel1;

	}

	// to search train
	public List<Trains> searchTrain(LocalDate DepartureDate, String source, String destination)
			throws ClassNotFoundException, SQLException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

		LocalDate ld = LocalDate();

		String findTrain = "select train_name,train_class,train_number,train_source,train_destination,train_departure_time,train_arraival_time,total_seat,ticket_price from trains where to_char(train_departure_time,'yyyy-mm-dd')='" + DepartureDate
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
//to show all train and select on user's wish date

	public List<Trains> searchAllTrain(String source, String destination) throws ClassNotFoundException, SQLException {
		String findTrain = "select train_name,train_class,train_number,train_source,train_destination,train_departure_time,train_arraival_time,total_seat,ticket_price from trains where train_source='" + source + "' and train_destination='"
				+ destination + "'";
		Connection con = null;
		Statement stmt = null;
		Trains trainModel;
		List<Trains> trainsearchList = new ArrayList<Trains>();

		con = ConnectionUtil.getDBconnect();
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(findTrain);
		while (rs.next()) {
			trainModel = new Trains(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
					rs.getString(6), rs.getTimestamp(7).toLocalDateTime(), rs.getTimestamp(8).toLocalDateTime(),
					rs.getInt(9), rs.getInt(10));
			trainsearchList.add(trainModel);

		}

		return trainsearchList;
	}

	public boolean updateSeatCount(Trains trainModel) {

		String updateSeat = "update trains set total_seat=? where train_id=?";
		Connection con;

		try {
			con = ConnectionUtil.getDBconnect();
			PreparedStatement pstatement = con.prepareStatement(updateSeat);

			pstatement.setInt(1, trainModel.getTotalseat());
			pstatement.setInt(2, trainModel.getTrainId());
			pstatement.executeUpdate();
			con.close();
			pstatement.close();
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	// traindetails using id

	public Trains findTrainsDetailsUsingID(int trainId) {
		String getTrain = "select train_name,train_class,train_number,train_source,train_destination,train_departure_time,train_arraival_time,total_seat,ticket_price from trains where train_id=?";
		Connection con = null;
		PreparedStatement pstatement = null;
		Trains trainModel = null;

		try {
			con = ConnectionUtil.getDBconnect();
			pstatement = con.prepareStatement(getTrain);
			pstatement.setInt(1, trainId);
			ResultSet rs = pstatement.executeQuery();

			if (rs.next()) {
				trainModel = new Trains(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getString(6), rs.getTimestamp(7).toLocalDateTime(), rs.getTimestamp(8).toLocalDateTime(),
						rs.getInt(9), rs.getInt(10));

			}
			con.close();
			pstatement.close();
		} catch (ClassNotFoundException e) {
			e.getMessage();
			System.out.println("classnot found");
		} catch (SQLException e) {
			e.getMessage();
			System.out.println("sql exception");
		}

		return trainModel;
	}

}