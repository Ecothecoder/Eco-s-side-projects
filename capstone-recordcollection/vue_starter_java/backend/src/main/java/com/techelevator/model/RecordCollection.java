package com.techelevator.model;

public class RecordCollection {
	private String title;
	private int id;
	private String artist;
	private String genre;
	private int yearReleased;
	private int lengthInMin;
	private String imgUrl;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getYearReleased() {
		return yearReleased;
	}
	public void setYearReleased(int yearReleased) {
		this.yearReleased = yearReleased;
	}
	public int getLengthInMin() {
		return lengthInMin;
	}
	public void setLengthInMin(int lengthInMin) {
		this.lengthInMin = lengthInMin;
	}

}
