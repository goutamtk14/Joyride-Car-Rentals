package com.joy.service;

import com.joy.entity.Cars;
import com.joy.entity.User;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.joy.dao.DaoFactory;

public class JoyService {

	public static ArrayList<Cars> searchCars(String from, String to, int fromdate, int todate, int seater) {
		
		ArrayList<Cars> allCars= DaoFactory.searchCars(from, seater);
		ArrayList<Cars> availableCars=new ArrayList<>();
		for(int i=0; i<allCars.size(); i++) {
			if(allCars.get(i).getBookedfromdate()==0) {
				availableCars.add(allCars.get(i));
			}
			else if((fromdate<allCars.get(i).getBookedfromdate() && todate<allCars.get(i).getBookedfromdate()) || (todate>allCars.get(i).getBookedtilldate() && fromdate>allCars.get(i).getBookedtilldate())) {
				availableCars.add(allCars.get(i));
			}
				
			
		}
		return availableCars;
		
	}

	public static void registerUser(String name, String dob, long dlnumber, String dlvalidity, String email,
			String password, long mobile) {
		SimpleDateFormat formatter1 = new SimpleDateFormat("MM/dd/yyyy");
		SimpleDateFormat formatter2 = new SimpleDateFormat("yyyyMMdd");
		try {
			Date newdob = formatter1.parse(dob);
			Date newdlvalidity = formatter1.parse(dlvalidity);
			dob = formatter2.format(newdob);
			dlvalidity = formatter2.format(newdlvalidity);
			int dob1 = Integer.parseInt(dob);
			int dlvalidity1 = Integer.parseInt(dlvalidity);
			DaoFactory.registerUser(name,dob1,dlnumber,dlvalidity1,email,password,mobile);
			}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static String getPassword(String email) {
		return DaoFactory.getPassword(email);
	}

	public static User getUserdata(String email) {
		return DaoFactory.getUserdata(email);
	}

	public static void bookCar(String registrationnumber, int id, int fromdate, int todate) {
		DaoFactory.bookCar(registrationnumber,id,fromdate,todate);
	}

}
