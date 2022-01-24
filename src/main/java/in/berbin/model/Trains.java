package in.berbin.model;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;

public class Trains {
	
public Trains(int trainId, String trainName, String trainClass, int trainNumber, String trainSource,
			String trainDestination, LocalDateTime trainDepartureTime, LocalDateTime trainArraivalTime, int totalseat,
			int ticketPrice) {
		super();
		this.trainId = trainId;
		this.trainName = trainName;
		this.trainClass = trainClass;
		this.trainNumber = trainNumber;
		this.trainSource = trainSource;
		this.trainDestination = trainDestination;
		this.trainDepartureTime = trainDepartureTime;
		this.trainArraivalTime = trainArraivalTime;
		this.totalseat = totalseat;
		this.ticketPrice = ticketPrice;
		
	}
public int getTrainId() {
		return trainId;
	}
	public void setTrainId(int trainId) {
		this.trainId = trainId;
	}
	private int trainId;
private String trainName;
private String trainClass;
private int trainNumber;
private String trainSource;
private String trainDestination;
private LocalDateTime trainDepartureTime;
private LocalDateTime trainArraivalTime;
private int totalseat;
private int ticketPrice;


public String getTrainName() {
	return trainName;
}
public void setTrainName(String trainName) {
	this.trainName = trainName;
}
public String getTrainClass() {
	return trainClass;
}
public void setTrainClass(String trainClass) {
	this.trainClass = trainClass;
}
public int getTrainNumber() {
	return trainNumber;
}
public void setTrainNumber(int trainNumber) {
	this.trainNumber = trainNumber;
}
public String getTrainSource() {
	return trainSource;
}
public void setTrainSource(String trainSource) {
	this.trainSource = trainSource;
}
public String getTrainDestination() {
	return trainDestination;
}
public void setTrainDestination(String trainDestination) {
	this.trainDestination = trainDestination;
}
public LocalDateTime getTrainDepartureTime() {
	return trainDepartureTime;
}
public void setTrainDepartureTime(LocalDateTime trainDepartureTime) {
	this.trainDepartureTime = trainDepartureTime;
}
public LocalDateTime getTrainArraivalTime() {
	return trainArraivalTime;
}
public void setTrainArraivalTime(LocalDateTime trainArraivalTime) {
	this.trainArraivalTime = trainArraivalTime;
}
public int getTotalseat() {
	return totalseat;
}
public void setTotalseat(int totalseat) {
	this.totalseat = totalseat;
}
public int getTicketPrice() {
	return ticketPrice;
}
public void setTicketPrice(int ticketPrice) {
	this.ticketPrice = ticketPrice;
}
@Override
public int hashCode() {
	return Objects.hash(ticketPrice, totalseat, trainArraivalTime, trainClass, trainDepartureTime, trainDestination,
			trainId, trainName, trainNumber, trainSource);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Trains other = (Trains) obj;
	return ticketPrice == other.ticketPrice && totalseat == other.totalseat
			&& Objects.equals(trainArraivalTime, other.trainArraivalTime)
			&& Objects.equals(trainClass, other.trainClass)
			&& Objects.equals(trainDepartureTime, other.trainDepartureTime)
			&& Objects.equals(trainDestination, other.trainDestination) && trainId == other.trainId
			&& Objects.equals(trainName, other.trainName) && trainNumber == other.trainNumber
			&& Objects.equals(trainSource, other.trainSource);
}
@Override
public String toString() {
	
	DateTimeFormatter format=DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
	return "TrainModel trainId=" + trainId + ",\n trainName=" + trainName + ",\n trainClass=" + trainClass
			+ ",\n trainNumber=" + trainNumber + ",\n trainSource=" + trainSource + ",\n trainDestination=" + trainDestination
			+ ",\n trainDepartureTime=" + trainDepartureTime.format(format) + ",\n trainArraivalTime=" + trainArraivalTime.format(format) + ",\n totalseat="
			+ totalseat + ",\n ticketPrice=" + ticketPrice ;
}
public Trains(int i, String trainName, String trainClass, int trainNumber, String trainSource, String trainDestination,
		LocalDateTime trainDepartureTime, LocalDateTime trainArraivalTime, int totalseat, int ticketPrice, int j) {
	super();
	this.trainName = trainName;
	this.trainClass = trainClass;
	this.trainNumber = trainNumber;
	this.trainSource = trainSource;
	this.trainDestination = trainDestination;
	this.trainDepartureTime = trainDepartureTime;
	this.trainArraivalTime = trainArraivalTime;
	this.totalseat = totalseat;
	this.ticketPrice = ticketPrice;
}

public Trains(String trainName1, String trainClass1, String trainSource1, String trainDestination1,
		Date trainDepartureTime1, Date trainArraivalTime1, int totalSeat1, int ticketPrice1) {
	// TODO Auto-generated constructor stub
}

public Trains(String trainName, String trainClass, int trainNumber, String trainSource, String trainDestination,
		LocalDateTime trainDepartureTime, LocalDateTime trainArraivalTime, int totalseat, int ticketPrice) {
	super();
	this.trainName = trainName;
	this.trainClass = trainClass;
	this.trainNumber = trainNumber;
	this.trainSource = trainSource;
	this.trainDestination = trainDestination;
	this.trainDepartureTime = trainDepartureTime;
	this.trainArraivalTime = trainArraivalTime;
	this.totalseat = totalseat;
	this.ticketPrice = ticketPrice;
}
public Trains(int trainNumber) {
	// TODO Auto-generated constructor stu
	
	this.trainNumber = trainNumber;
}
public Trains() {
	super();
	// TODO Auto-generated constructor stub
}




}