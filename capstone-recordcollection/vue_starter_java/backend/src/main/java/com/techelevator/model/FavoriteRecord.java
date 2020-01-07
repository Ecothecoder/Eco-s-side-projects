package com.techelevator.model;

public class FavoriteRecord {
	private int album_id;
	private String notes;
	
	
	public int getId() {
		return album_id;
	}
	public void setId(int id) {
		this.album_id = id;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
}
