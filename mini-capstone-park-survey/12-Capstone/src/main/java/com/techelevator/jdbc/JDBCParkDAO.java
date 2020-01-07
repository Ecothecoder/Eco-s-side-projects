package com.techelevator.jdbc;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.Park;
import com.techelevator.ParkDAO;

@Component
public class JDBCParkDAO implements ParkDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCParkDAO(BasicDataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public Park getParkByCode(String parkCode) {
		Park park = new Park();
		String sql = "SELECT * "
				+ "FROM park "
				+ "WHERE parkcode = ?";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, parkCode);
		
		while (results.next()) {
			park = mapRowsToPark(results);
		}
		
		return park;
	}

	public List<Park> getListOfAllParks() {
		List<Park> listOfParks = new LinkedList<>();
		String sql = "SELECT * FROM park";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		
		while (results.next()) {
			Park newPark = mapRowsToPark(results);
			listOfParks.add(newPark);
		}
		
		return listOfParks;
		
	}

	private Park mapRowsToPark(SqlRowSet results) {
		Park newPark = new Park();
		newPark.setParkCode(results.getString("parkcode"));
		newPark.setParkName(results.getString("parkname"));
		newPark.setState(results.getString("state"));
		newPark.setAcreage(results.getInt("acreage"));
		newPark.setElevation(results.getInt("elevationinfeet"));
		newPark.setMilesOfTrail(results.getDouble("milesoftrail"));
		newPark.setNumberOfCampsites(results.getInt("numberofcampsites"));
		newPark.setClimate(results.getString("climate"));
		newPark.setYearFounded(results.getInt("yearfounded"));
		newPark.setAnnualVisitorCount(results.getInt("annualvisitorcount"));
		newPark.setInspirationalQuote(results.getString("inspirationalquote"));
		newPark.setInspirationalQuoteSource(results.getString("inspirationalquotesource"));
		newPark.setParkDescription(results.getString("parkdescription"));
		newPark.setEntryFee(results.getInt("entryfee"));
		newPark.setNumberOfAnimalSpecies(results.getInt("numberofanimalspecies"));
		return newPark;
	}
}
