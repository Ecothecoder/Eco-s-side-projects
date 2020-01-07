package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcTemplatePlaylist implements playlistDao {

	private JdbcTemplate jdbcTemplate;

	public JdbcTemplatePlaylist(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<PlaylistItem> getAllPlaylists(User u) {
		List<PlaylistItem> playlists = new ArrayList<>();
		String sqlString = "select playlist_contents.album_id, playlist_names.playlist_id, album.imgUrl, "
				+ "playlist_name from playlist_names JOIN playlist_contents "
				+ "ON playlist_contents.playlist_id = playlist_names.playlist_id "
				+ "JOIN album ON album.id = playlist_contents.album_id " + "where playlist_names.user_id = ?";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sqlString, u.getId());
		while (result.next()) {
			PlaylistItem play = new PlaylistItem();
			play.setPlaylist_id(result.getInt("playlist_id"));
			play.setPlaylist_name(result.getString("playlist_name"));
			play.setAlbumId(result.getInt("album_id"));
			play.setImg(result.getString("imgUrl"));
			playlists.add(play);
		}
		return playlists;
	}

	@Override
	public List<PlaylistItem> getPlaylistIdforSeth(User u){
		List<PlaylistItem> playlists = new ArrayList<>();
		String sqlString = "select playlist_id, playlist_name from playlist_names where user_id = ?";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sqlString, u.getId());
		while (result.next()) {
			PlaylistItem play = new PlaylistItem();
			play.setPlaylist_id(result.getInt("playlist_id"));
			play.setPlaylist_name(result.getString("playlist_name"));
			playlists.add(play);
		}
		return playlists;
	}
	
	@Override
	public List<PlaylistItem> getPlaylistInsidesforSeth(int potato){
		List<PlaylistItem> playlists = new ArrayList<>();
		String sqlString = "select album.title, album.artist, album.imgUrl, album.id from playlist_contents "
				+ "JOIN album ON album.id = playlist_contents.album_id "
				+ "where playlist_contents.playlist_id = ?";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sqlString, potato);
		while (result.next()) {
			PlaylistItem play = new PlaylistItem();
			play.setTitle(result.getString("title"));
			play.setArtist(result.getString("artist"));
			play.setImg(result.getString("imgUrl"));
			play.setAlbumId(result.getInt("id"));
			playlists.add(play);
		}
		return playlists;
	}
	
	
	@Override
	public void addPlaylist(User u, String mambo) {
		String sql = "INSERT INTO playlist_names(user_id, playlist_name) values(?, ?)";
		jdbcTemplate.update(sql, u.getId(), mambo);
	}

	@Override
	public void deletePlaylist(int apple) {
		String sqlString = "delete from playlist_contents where playlist_id = ?; "
				+ "delete from playlist_names where playlist_id = ?";
		jdbcTemplate.update(sqlString, apple, apple);
	}

	@Override
	public void changePlaylistName(PlaylistItem better, String name) {
		String sqlString = "update playlist_names set playlist_name = ? where playlist_id = ?";
		jdbcTemplate.update(sqlString, name, better.getPlaylist_id());
	}

	@Override
	public void addAlbum(PlaylistItem ok, int album) {
		String sqlString = "insert into playlist_contents values(?,?)";
		jdbcTemplate.update(sqlString, ok.getPlaylist_id(), album);
	}

	@Override
	public void deleteAlbum(int  ok, int album) {
		String sqlString = "delete from playlist_contents where playlist_id = ? and album_id = ?";
		jdbcTemplate.update(sqlString, ok, album);
	}
}
