//package com.testmain;
//
//import java.sql.SQLException;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.Date;
//import java.util.List;
//import java.util.Scanner;
//
//import in.berbin.daoimpl.AdminDaoImpl;
//import in.berbin.daoimpl.BookingDetailsDaoImpl;
//import in.berbin.daoimpl.TrainDaoImpl;
//import in.berbin.daoimpl.UserDaoImpl;
//import in.berbin.model.BookingDetails;
//import in.berbin.model.Trains;
//import in.berbin.model.Users;
//
//public class TrainTicketReservationTestMain {
//	public static void main(String args []) throws ClassNotFoundException, SQLException, ParseException {
//	UserDaoImpl ud=new UserDaoImpl();
//	TrainDaoImpl td=new TrainDaoImpl();
//	AdminDaoImpl adao=new AdminDaoImpl();
//	
//	BookingDetailsDaoImpl bDao= new BookingDetailsDaoImpl();
//	BookingDetails bookingDetailsModel=new BookingDetails();
//	 SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
//	 DateTimeFormatter format=DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
//	 DateTimeFormatter dateFormat=DateTimeFormatter.ofPattern("dd-MM-yyyy");
//	
//	Scanner scan=new Scanner(System.in);
//	
//	boolean boo;
//	while(boo=true) {
//	
//	System.out.println("select the operation:  ");
//	System.out.println("1.To login \t");
//	System.out.println("2.To Register \t");
//	System.out.println("3.To update user details \t");
//	System.out.println("4.To delete the user \t");
//	System.out.println("5.To Add train \t");
//	System.out.println("6.To update train \t");
//	System.out.println("7.To show all trains");
//	System.out.println("8.To show all users");
//	System.out.println("9.To delete train");
//	System.out.println("10. To find train id");
//	int choice=scan.nextInt();
//	scan.nextLine();
//	
//	switch(choice)  {
//
//	case 1: 
//		//System.out.println("Enter your mobile number");
//			//long UserMobileNumber=Long.parseLong(scan.nextLine());
//			long UserMobileNumber=0;
//			boolean mobileflag=true;
//			do {
//			System.out.println("enter usermobile");
//			String tempMobile=scan.nextLine();
//			if(tempMobile.matches("[6-9][0-9]{9}"))
//			{
//				UserMobileNumber=Long.parseLong(tempMobile);
//			mobileflag=false;
//			}
//			else
//			System.out.println("Invalid Mobile Number");
//			}while(mobileflag);
//			String password = null;
//			boolean flagpswd = true;
//			do {
//			System.out.println("enter password");
//			password = scan.nextLine();
//			if (password.matches(
//			"^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,15}$")) {
//			flagpswd = false;
//			//System.out.println(password);
//			
//			Users userModel=ud.findUserDetails(UserMobileNumber);
//			
//			System.out.println("1. Search and book train");
//			System.out.println("2. To cancel your Ticket");
//			System.out.println("3. To get invoice");
//			System.out.println("4.To see booking details");
//			System.out.println("5.To add money in wallet");
//			System.out.println("To check balance");
//			System.out.println("Enter the choice number to proceed : ");
//			int userChoice=scan.nextInt();
//			scan.nextLine();
//			switch(userChoice) {
////			
//			case 1:
//			//to search train
//			System.out.println("to see all trains");
//			System.out.println("Enter the source location");
//			String source=scan.nextLine();
//			System.out.println("Enter destination location");
//			String destination=scan.nextLine();
//			List<Trains>searchAllTrain=td.searchAllTrain(source, destination);
//			for(int i=0;i<searchAllTrain.size();i++) {
//				System.out.println(searchAllTrain.get(i));
//			}
//		
////		
//			//to book ticket
//			System.out.println("Enter the train train number that want to book");
//			int trainNoofselectedTrain=Integer.parseInt(scan.nextLine());
//			Trains trainModel=new Trains();
//			trainModel = td.findTrainDetailsUsingTrainNumber(trainNoofselectedTrain);
//			System.out.println(trainModel);
//			
//			System.out.println("enter the no of person");
//			int bookTicketCount = Integer.parseInt(scan.nextLine());
//			System.out.println("select the class");
//			System.out.println("Select 1 for Non AC / 2 for  AC");
//			
//			
//			int classChoice=Integer.parseInt(scan.nextLine());
//			int bookTotalPrice=0;
//			if(classChoice==1) {
//				
//				bookTotalPrice=(trainModel.getTicketPrice())*bookTicketCount;
//			}
//			else {
//				
//				bookTotalPrice=(trainModel.getTicketPrice()+200)*bookTicketCount;
//			}
//			
//			System.out.println("Total price:"+bookTotalPrice);
//			// to get current object
//			userModel = ud.getUserDetailsById(userModel.getUserId());
//			System.out.println("Current balance in your wallet is : " + userModel.getUserWallet());
//
//			System.out.println("To confirm booking type yes");
//			String confirmation = scan.nextLine().toLowerCase();
//
//			
//				if (confirmation.equals("yes")) {
//					// to get current object
//					userModel = ud.getUserDetailsById(userModel.getUserId());
//					// to check whether wallet is having that much amount to book
//					if (userModel.getUserWallet() >= bookTotalPrice) {
//				
//						
//						//to reduce seat according to seat count given by user
//						trainModel = td.findTrainDetailsUsingTrainNumber(trainNoofselectedTrain);
//						int reducedTrainSeat=trainModel.getTotalseat()-bookTicketCount;
//						trainModel.setTotalseat(reducedTrainSeat);											
//						td.updateSeatCount(trainModel);
//						
//						LocalDate departureDate=trainModel.getTrainDepartureTime().toLocalDate();
//
//						bookingDetailsModel = new BookingDetails(userModel, trainModel,departureDate, bookTicketCount,
//								bookTotalPrice);
//						//to insert
//						boolean result = bDao.bookTicket(userModel,trainModel, bookingDetailsModel);
//						int yourPnrNumber;
//						if (result == true) {
//							// to reduce wallet amount according to ticket amount
//							int updatedBalanceAfterBooking = userModel.getUserWallet()- bookTotalPrice;
//							ud.updateWallet(updatedBalanceAfterBooking,userModel.getUserMobileNumber());
//							System.out.println("Booked successfully");
//						} else { //
//							System.out.println("Money is Not updated...something went wrong");
//						}
//						yourPnrNumber = bDao.findPnrNumber(userModel,bookingDetailsModel);
//						System.out.println("Your booking PNR number is : "+ yourPnrNumber);
//						System.out.println("please remember your PNR number");
//					}
//					else {
//						System.out.println("Insufficient balance....please recharge");
//
//						System.out.println("Press 9 to recharge your wallet now");
//						int rechargeWalletChoiceAfterInsufficient = scan.nextInt();
//						if (rechargeWalletChoiceAfterInsufficient == 9) {
//							// System.out.println("Your current Balance is : "+userModel.getUserWallet());
//							System.out.println(
//									"Enter the amount to be add to your wallet");
//							int addedAmountInBooking = scan.nextInt();
//							int totalAmountInBooking = addedAmountInBooking+ userModel.getUserWallet();
//							userModel = ud.getUserDetailsById(userModel.getUserId());
//							
//							// userModel.setUserWallet(totalAmountInBooking);
//							boolean resultWallet = ud.updateWallet(totalAmountInBooking, userModel.getUserMobileNumber());
//							if (resultWallet == true) {
//								System.out.println("update successfully");
//								// System.out.println("Your current balance is : "+userModel.getUserWallet());
//							} else {
//								System.out.println("please give correct value (not booked)");
//								
//							}
//						
//						
//					
//				}
//					
//				
//				else {
//					System.out.println(
//							"Booking was not confirmed...Hurry up!! Only few seats are left");
//				}
//					}}
//				else {
//					System.out.println(" seats are not available...please go for other options");
//				
//				}
//				break;
//				
//			case 2 :
//				System.out.println("To Cancel your ticket");
//				System.out.println("Enter your PNR Number");
//				int cancelPnrNumber;
//				
//					cancelPnrNumber = scan.nextInt();
//					
//					bookingDetailsModel = bDao.findBookedTicketsDetails(cancelPnrNumber);
//					System.out.println(bookingDetailsModel);
//					if(bookingDetailsModel.getTicketStatus().equals("BOOKED")) {
//						
//				
//					
//					//to update (+) bus seats according to user booking
//					//TrainModel trainModel = new TrainModel();
//					trainModel = td.findTrainsDetailsUsingID(bookingDetailsModel.getTrainmodel().getTrainId());
//					int addedTrainSeat= bookingDetailsModel.getTrainmodel().getTotalseat()+bookingDetailsModel.getTicketCount();
//					trainModel.setTotalseat(addedTrainSeat);											
//					td.updateSeatCount(trainModel);
//					
//					//refund process
//					int amountRefund = userModel.getUserWallet()+ bookingDetailsModel.getTotalPrice();
//					System.out.println("The ticket amount " + bookingDetailsModel.getTotalPrice()+ " is refunded to your wallet successfully");
//					ud.updateWallet(amountRefund, userModel.getUserMobileNumber());
//					
//					// to update refund amount to the wallet
//					userModel = ud.getUserDetailsById(userModel.getUserId());
//					
//					// userModel.setUserWallet(amountRefund);
//					boolean cancelResult = bDao.cancelTicket(userModel,bookingDetailsModel);
//					if (cancelResult == true) {
//						System.out.println("Ticket Cancelled successfully ");
//						System.out.println("Your current Available balance is : "+ userModel.getUserWallet());
//					} else {
//						System.out.println("Ticket cancellation  failed");
//					}
//					}
//					else {
//						System.out.println("The ticket is invalid or already this ticket has been cancelled by you");
//				
//					}
//				break;
//
//			case 3:
//				System.out.println("Invoice for your ticket");
//				BookingDetails bookingDetailssModel = null;
//				System.out.println("Enter Your PNR Number");
//				int pnrNumber = (scan.nextInt());
//				bookingDetailssModel = bDao.findBookedTicketsDetails(pnrNumber);
//				trainModel = td.findTrainsDetailsUsingID(bookingDetailssModel.getTrainmodel().getTrainId());
//				
//				System.out.println("TicketNumber    : " + pnrNumber);
//				System.out.println("Name            : " + userModel.getUserName());
//				System.out.println("Date of Journey : " + trainModel.getTrainDepartureTime());
//				System.out.println("Date of Arraival : " + trainModel.getTrainArraivalTime());
//				System.out.println("Source          : " + trainModel.getTrainSource());
//				System.out.println("Destination     : " + trainModel.getTrainDestination());
//				System.out.println("Seat Count      :"  +  bookingDetailssModel.getTicketCount());
//				System.out.println("Total Price     : " + bookingDetailssModel.getTotalPrice());
//				System.out.println("Ticket  status  : " + bookingDetailsModel.getTicketStatus());
//				
//				break;
//				
//			
//	case 4:
//				
//				System.out.println(" Booking History");
//			
//				List<BookingDetails>bookingList=bDao.getBookingDetailsForCurrentUser(userModel);
//				for(int i=0;i<bookingList.size();i++) {
//					System.out.println(bookingList.get(i).toString());
//				}
//				
//			
//	case 5:
//		System.out.println("To add money in wallet");
//		System.out.println("Your current Available Balance in "
//				+ userModel.getUserMobileNumber() + "is : " + userModel.getUserWallet());
//		System.out.println("press 1 to add amount in your wallet");
//		int walletChoice = scan.nextInt();
//		if (walletChoice == 1) {
//			System.out.println("Enter the amount to be credit in your wallet: ");
//			int toAddBalance = scan.nextInt();
//			int updatedWallet = userModel.getUserWallet() + toAddBalance;
//			boolean resultWallet = ud.updateWallet(updatedWallet,userModel.getUserMobileNumber());
//			if (resultWallet == true) {
//				System.out.println("update successfully");
//				System.out.println("Your current balance is : " + updatedWallet);
//			} else {
//				System.out.println("Money is Not added");
//			}
//		} else {
//			System.out.println("enter correct choice");
//		}
//		break;
//	case 6:
//		// System.out.println("-------------To view Balance------------------");
//		userModel = ud.getUserDetailsById(userModel.getUserId());
//		System.out.println("Available Balance : " + userModel.getUserWallet());
//		break;
//			}
//			
//			
//			
//			} else {
//			System.out.println("password must have 8 to 15 characters only \n"
//			+ "contains one upper case \n" + "atleast one lower case \n"
//			+ "atleast one number  \n" + "atleast one special character \n");
//			}
//			break;
//		
//			
//			
//			}while(flagpswd);
//		Users usermodule=new Users(UserMobileNumber,password);
//			UserDaoImpl loginud=new UserDaoImpl();
//			loginud.loginUser(UserMobileNumber);
//				break;
//
//
//		
//		case 2:
//			//To Insert 
//			String userName=null;
//			boolean b=true;
//			do {
//			System.out.println("enter fullname");
//			userName=scan.nextLine();
//			if(userName.matches("[A-Za-z]{3,}"))
//			{
//			b=false;
//			}
//
//			}
//			while(b);
//			String tempAge=null;
//			boolean flag=true;
//			int age=0;
//			do {
//			System.out.println("enter age");
//			tempAge=scan.nextLine();
//			if(tempAge.matches("[0-9]{2,3}"))
//			{
//			age=Integer.parseInt(tempAge);
//			if(age>16 && age<=100)
//			flag=false;
//
//			}
//			else
//			System.out.println("Age must be greater than 16");
//			}while(flag);
//			String userMail;
//			boolean mailFlag = true;
//			do {
//			System.out.println("enter email");
//			userMail=scan.nextLine();
//			if(userMail.matches("[a-zA_z][A-Za-z0-9]+[@][a-zA-Z]+[.][A-Za-z]{2,3}") && !userMail.endsWith("medhub.com"))
//			{
//			mailFlag = false;
//			userMail = userMail.trim().toLowerCase();
//			}
//			else
//			System.out.println("email should be like abc@domain.com");
//			}while(mailFlag);
//			//long userMobilenumber=Long.parseLong(scan.nextLine());
//			long userMobilenumber=0;
//			boolean mobileflaglog=true;
//			do {
//			System.out.println("enter usermobilenumber");
//			String tempMobile=scan.nextLine();
//			if(tempMobile.matches("[6-9][0-9]{9}"))
//			{
//				userMobilenumber=Long.parseLong(tempMobile);
//			mobileflaglog=false;
//			}
//			else
//			System.out.println("Invalid Mobile Number");
//			}while(mobileflaglog);
//			String userGender =null;
//			boolean genderflag=false;
//			do {
//			System.out.println("Enter the user gender");
//			 userGender=scan.nextLine();
//			boolean flagpswdlog = true;
//			}while(genderflag);
//			String userPassword = null;
//			boolean flagpswdlog = true;
//			do {
//			System.out.println("enter password");
//			userPassword = scan.nextLine();
//			if (userPassword.matches(
//					"^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,15}$")) {
//				flagpswdlog=false;
//			
//			} else {
//			System.out.println("password must have 8 to 15 characters only \n"
//			+ "contains one upper case \n" + "atleast one lower case \n"
//			+ "atleast one number  \n" + "atleast one special character \n");
//			}
//			}while(flagpswdlog);
//			
//			Users usermodule1=new Users(userName,age,userMail,userMobilenumber,userGender,userPassword);
//			ud.insert(usermodule1);
//			break;
//			
//		case 3:
//			System.out.println("To Update user details");
//			System.out.println("Enter your emailid");
//			String userEmail1=scan.nextLine();
//			System.out.println("Enter the user name ");
//			String userName1=scan.nextLine();
//			System.out.println("Enter the user age ");
//			int userAge1=Integer.parseInt(scan.nextLine());
//			System.out.println("Enter the user mobilenumber ");
//			long userMobileNumber1=Long.parseLong(scan.nextLine());
//			System.out.println("Enter the user gender");
//			String userGender1=scan.nextLine();
//			System.out.println("Enter the user password");
//			String userPassword1=scan.nextLine();
//			
//			Users usermodule11=new Users(  userName1,userAge1,userEmail1,userMobileNumber1,
//					userGender1,userPassword1);
//			ud.update(usermodule11);
//			break;
//			
//		case 4:
//			System.out.println("To Delete user");
//			System.out.println("Enter the id to delete ");
//			int userId=scan.nextInt();
//			Users usermodule2=new Users(userId);
//			ud.delete(usermodule2);
//			break;
//			
//		case 5:
//			
//			System.out.println("to insert train ");
//			System.out.println("Enter train name");
//			String trainName=scan.nextLine();
//			System.out.println("Enter train class");
//			String trainClass=scan.nextLine();
//			System.out.println("Enter train number");
//			int trainNumber=Integer.parseInt(scan.nextLine());
//			System.out.println("Enter train source");
//			String trainSource=scan.nextLine();
//			System.out.println("Enter train Destination");
//			String trainDestination=scan.nextLine();
//			System.out.println("Enter train departure time");
//			String departureDate=scan.nextLine();
//			LocalDateTime departureDateTime = LocalDateTime.parse(departureDate, format);
//			System.out.println("Enter train arraival time");
//			String arrivalDate=scan.nextLine();
//			LocalDateTime arrivalDateTime = LocalDateTime.parse(arrivalDate, format);
//					System.out.println("Enter total seat");
//			int totalSeat=Integer.parseInt(scan.nextLine());
//			System.out.println("Enter ticket price");
//			int ticketPrice=Integer.parseInt(scan.nextLine());
//			
//			Trains trainmoduleinsert=new Trains(trainName,trainClass,trainNumber,trainSource,
//		trainDestination,departureDateTime,arrivalDateTime,totalSeat,ticketPrice);
//			td.insertTrain(trainmoduleinsert);
//			
//			break;
//		case 6:
//			System.out.println("Update train details");
//
//			System.out.println("Enter train number");
//			int trainNumber1=Integer.parseInt(scan.nextLine());
//				System.out.println("Enter train name");
//				String trainName1=scan.nextLine();
//				System.out.println("Enter train class");
//				String trainClass1=scan.nextLine();				
//				System.out.println("Enter train source");
//				String trainSource1=scan.nextLine();
//				System.out.println("Enter train Destination");
//				String trainDestination1=scan.nextLine();
//				System.out.println("Enter train departure time");
//				String departureDate1=scan.nextLine();
//				LocalDateTime departureDateTime1 = LocalDateTime.parse(departureDate1, format);
//				System.out.println("Enter train arraival time");
//				String arrivalDate1=scan.nextLine();
//				LocalDateTime arrivalDateTime1 = LocalDateTime.parse(arrivalDate1, format);
//				System.out.println("Enter total seat");
//				int totalSeat1=Integer.parseInt(scan.nextLine());
//				System.out.println("Enter ticket price");
//				int ticketPrice1=Integer.parseInt(scan.nextLine());
//				Trains trainmoduleupdate=new Trains(trainName1,trainClass1,trainNumber1,trainSource1,
//						trainDestination1,departureDateTime1,arrivalDateTime1,totalSeat1,ticketPrice1);
//				td.updatetrain(trainmoduleupdate);
//				break;
//		case 7:
//			System.out.println("To view all trains");
//			TrainDaoImpl listTrains = new TrainDaoImpl();
//			List<Trains> trainList = listTrains.showAllTrains();
//			for(int i=0;i<trainList.size();i++)
//			{
//				System.out.println(trainList.get(i));
//			}
//			break;
//		case 8:
//			System.out.println("To view all users");
//			UserDaoImpl listUsers = new UserDaoImpl();
//			List<Users> userList = listUsers.showAllUsers();
//			for(int i=0;i<userList.size();i++)
//			{
//				System.out.println(userList.get(i));
//			}
//			break;
//		case 9:
//			System.out.println("To delete train");
//			System.out.println("Enter train number to delete");
//			int TrainNumber=scan.nextInt();
//			Trains trainmodule1= new Trains(TrainNumber);
//			td.deletetrain(trainmodule1);
//			break;
//		case 10:
//			System.out.println("To find train id ");
//			System.out.println("Enter train number");
//			int TrainNumber1=scan.nextInt();
//			Trains trainmodel=new Trains(TrainNumber1);
//			int trainId= td.findTrainId(trainmodel);
//			System.out.println(trainId);
//			break;		
//			
//	}
//	
//	
//
//}
//}}
