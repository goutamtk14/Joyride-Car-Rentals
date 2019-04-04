package com.joy.service;

import com.joy.entity.Cars;

import java.util.ArrayList;

import com.joy.dao.DaoFactory;

public class JoyService {

	public static ArrayList<Cars> searchCars(String from, String to, int fromdate, int todate, int seater) {
		return DaoFactory.searchCars(from, seater);
		
	}

}
