package in.berbin.dao;

import java.time.LocalDate;
import java.util.List;

import in.berbin.model.Trains;

public interface TrainDAO {
	 public void insertTrain(Trains trainmodule);
	 public void updatetrain(Trains trainmodule);
	 public void deletetrain(Trains trainmodule);
	 public List<Trains> showAllTrains();
	 public int findTrainId(Trains trainModel);
	 public   Trains findTrainDetailsUsingTrainNumber(int trainNumber);
	 public List<Trains>searchTrain(LocalDate givenDepartureDate,String source,String destination);
	 public List<Trains>searchAllTrain(String source,String destination);
	 public void updateSeatCount(Trains trainModel);
	 public Trains findTrainsDetailsUsingID(int trainId) ;

}