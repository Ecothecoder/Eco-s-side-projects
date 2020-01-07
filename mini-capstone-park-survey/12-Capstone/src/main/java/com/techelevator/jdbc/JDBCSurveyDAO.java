package com.techelevator.jdbc;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.Park;
import com.techelevator.Survey;
import com.techelevator.SurveyDAO;

@Component
public class JDBCSurveyDAO implements SurveyDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	public JDBCSurveyDAO(BasicDataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void createNewSurvey(Survey survey) {
		
		String sql = "INSERT INTO survey_result (parkcode, emailaddress, state, activitylevel) "
				+ " VALUES (?, ?, ?, ?)";
		
		jdbcTemplate.update(sql, survey.getParkCode(), survey.getEmailAddress(), survey.getState(), survey.getActivityLevel());
	}
	
	public List<Park> getListOfFavorites() {
		List<Park> list = new LinkedList<>();
		String sql = "SELECT survey_result.parkcode, COUNT(survey_result.parkcode), park.parkname " + 
				"FROM survey_result " + 
				"JOIN park ON park.parkcode = survey_result.parkcode " + 
				"GROUP BY survey_result.parkcode,  park.parkname " + 
				"ORDER BY count DESC, park.parkname";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		
		while (results.next()) {
			Park park = new Park();
			park.setParkName(results.getString("parkname"));
			park.setParkCode(results.getString("parkcode"));
			park.setFavoriteCount(results.getInt("count"));
			list.add(park);
		}
		return list;
	}
}
