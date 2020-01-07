package com.techelevator;

import java.util.List;

public interface ParkDAO {
	
	public List<Park> getListOfAllParks();

	public Park getParkByCode(String parkCode);
}
