package com.techelevator;

import java.util.Arrays;
import java.util.List;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import org.springframework.stereotype.Component;

@Component
public class Survey {
	private int surveyId;
	private String parkCode;

	@Email(message = "Invalid address format.")
	@NotBlank(message = "Email address is required.")
	private String emailAddress;
	private String state;
	private String activityLevel;

	public String getEmailVerification() {
		return emailVerification;
	}

	public void setEmailVerification(String emailVerification) {
		this.emailVerification = emailVerification;
	}

	private String emailVerification;

	private final String[] STATE_ARRAY = { "AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "ID", "IL",
			"IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM",
			"NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI",
			"WY" };

	@AssertTrue(message = "Email addresses do not match.")
	public boolean isEmailMatching() {
		boolean result = false;
		if (emailAddress != null) {
			result = emailAddress.equals(emailVerification);
		}
		return result;
	}

	@AssertTrue(message = "That isn't a valid state!")
	public boolean isValidState() {
		boolean result = false;
		if (state != null) {
			result = Arrays.stream(STATE_ARRAY).anyMatch(getState()::equals);
		}
		return result;
	}
	/*
	 * private ParkDAO parkDAO;
	 * 
	 * public void setParkDAO(ParkDAO parkDAO) { this.parkDAO = parkDAO; }
	 * 
	 * @AssertTrue(message = "That isn't a valid park!") public boolean
	 * isValidParkCode() {
	 * 
	 * BasicDataSource dataSource = new BasicDataSource();
	 * dataSource.setUrl("jdbc:postgresql://localhost:5432/npgeek");
	 * dataSource.setUsername("postgres"); dataSource.setPassword("postgres1");
	 * parkDAO = new JDBCParkDAO(dataSource);
	 * 
	 * boolean result = false; List<Park> listOfValidParks =
	 * parkDAO.getListOfAllParks(); if (listOfValidParks == null) { return result; }
	 * for (Park park : listOfValidParks) { if (parkCode != null &&
	 * park.getParkCode().equals(parkCode)) { result = true; } }
	 * 
	 * return result; }
	 */

	public int getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(int surveyId) {
		this.surveyId = surveyId;
	}

	public String getParkCode() {
		return parkCode;
	}

	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getActivityLevel() {
		return activityLevel;
	}

	public void setActivityLevel(String activityLevel) {
		this.activityLevel = activityLevel;
	}

	public String[] getSTATE_ARRAY() {
		return STATE_ARRAY;
	}
}
