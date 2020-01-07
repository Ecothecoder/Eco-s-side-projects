package com.techelevator.model;

import java.util.List;

public class Playlist {

	//playlist id user id and name List of playlist Items 
	
	public int user_id;
	public String playlist_name;
	public List<PlaylistItem> playlistItems;
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;}
	
	public String getPlaylist_name() {
		return playlist_name;
	}
	public void setPlaylist_name(String playlist_name) {
		this.playlist_name = playlist_name;
	}

}
