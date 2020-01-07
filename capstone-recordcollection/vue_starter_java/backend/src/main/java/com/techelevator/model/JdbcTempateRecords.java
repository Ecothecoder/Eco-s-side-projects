package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;


@Component
public class JdbcTempateRecords implements RecordCollectionDao{
	
	private JdbcTemplate jdbcTemplate;
    public JdbcTempateRecords(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

	@Override
	public List<RecordCollection> getAllRecords() {
		List<RecordCollection> resultList = new ArrayList<>();
		String sql = "Select id, title, artist, genre, yearReleased, lengthInMin, imgUrl From album";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
		while (result.next()) {
			RecordCollection fP = new RecordCollection();
			fP.setId(result.getInt("id"));
			fP.setTitle(result.getString("title"));
			fP.setArtist(result.getString("artist"));
			fP.setGenre(result.getString("genre"));
			fP.setYearReleased(result.getInt("yearReleased"));
			fP.setLengthInMin(result.getInt("lengthInMin"));
			fP.setImgUrl(result.getString("imgUrl"));
			resultList.add(fP);
		}
		return resultList;
	}

	@Override
	public RecordCollection getOneRecords(int id) {
		RecordCollection fP = new RecordCollection();
		String sql = "Select title, artist, genre, yearReleased, lengthInMin, imgUrl From album where id = ?";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sql, id);
		while (result.next()) {
			fP.setId(id);
			fP.setTitle(result.getString("title"));
			fP.setArtist(result.getString("artist"));
			fP.setGenre(result.getString("genre"));
			fP.setYearReleased(result.getInt("yearReleased"));
			fP.setLengthInMin(result.getInt("lengthInMin"));
			fP.setImgUrl(result.getString("imgUrl"));
		}
		return fP;
	}
}
