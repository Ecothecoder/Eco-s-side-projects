package com.techelevator;

import java.util.Map;

public interface WeatherDAO {

	public Map<Integer, Weather> getWeatherForPark(String parkCode);
}
