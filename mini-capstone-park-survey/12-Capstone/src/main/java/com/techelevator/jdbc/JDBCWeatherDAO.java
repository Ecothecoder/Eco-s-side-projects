package com.techelevator.jdbc;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.Park;
import com.techelevator.Weather;
import com.techelevator.WeatherDAO;

@Component
public class JDBCWeatherDAO implements WeatherDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	public JDBCWeatherDAO(BasicDataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public Map<Integer, Weather> getWeatherForPark(String parkCode) {
		Map<Integer, Weather> weatherMap = new HashMap<Integer,Weather>();
		String sql = "SELECT * "
				+ "FROM weather " 
				+ "WHERE parkcode = ?";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, parkCode);
		
		while(results.next()) {
			Weather weather = new Weather();
			weather.setFiveDayForecast(results.getInt("fivedayforecastvalue"));
			weather.setLow(results.getInt("low"));
			weather.setHigh(results.getInt("high"));
			weather.setForecast(results.getString("forecast"));
			weatherMap.put(weather.getFiveDayForecast(), weather);
		}
		
		return weatherMap;
	}
}
