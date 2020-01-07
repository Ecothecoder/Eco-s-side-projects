package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class jdbctemplateFavoriteRecord implements FavoriteRecordDao{
	
	private JdbcTemplate jdbcTemplate;
    public jdbctemplateFavoriteRecord(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

	@Override
	public List<FavoriteRecord> getFavoritesForUser(User u) {
		List<FavoriteRecord> resultList = new ArrayList<>();
		String sql = "Select album_id, notes From library WHERE user_id = ?";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sql, u.getId());
		while (result.next()) {
			FavoriteRecord fP = new FavoriteRecord();
			fP.setId(result.getInt("album_id"));
			fP.setNotes(result.getString("notes"));
			resultList.add(fP);
		}
		return resultList;
	}
	
	@Override
	public FavoriteRecord addFavoriteRecords(User u, FavoriteRecord fr){
		String sql = "INSERT INTO library (user_id, album_id) VALUES (?, ?)";
		jdbcTemplate.update(sql, u.getId(), fr.getId());
		return fr;
	}
	
	@Override 
	public void deleteFavoriteRecord(User u, int fr) {
		String sql = "delete from library where user_id = ? and album_id = ?";
		jdbcTemplate.update(sql, u.getId(), fr);
	}
	@Override
	public void updateNotesOnRecord(User u, int id, String note) {
		String sql = "update library set notes = ? where user_id = ? and album_id = ?";
		jdbcTemplate.update(sql, note, u.getId(), id);
	}
}
