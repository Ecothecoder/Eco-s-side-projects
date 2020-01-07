package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcTemplateTracks implements TracksDao {
	
	private JdbcTemplate jdbcTemplate;
    public JdbcTemplateTracks(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

	@Override
	public List<Tracks> getAllTracks(int id) {
		List<Tracks> resultList = new ArrayList<>();
		String sql = "Select track_id, title From track WHERE album_id = ? ";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sql, id);
		while (result.next()) {
			Tracks fP = new Tracks();
			fP.setTrackId(result.getInt("track_id"));
			fP.setTitleString(result.getString("title"));
			resultList.add(fP);
		}
		return resultList;
	}

	

}
