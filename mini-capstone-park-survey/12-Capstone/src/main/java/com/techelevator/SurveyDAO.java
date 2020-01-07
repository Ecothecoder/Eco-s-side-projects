package com.techelevator;

import java.util.List;

public interface SurveyDAO {
	
	public void createNewSurvey(Survey survey);
	public List<Park> getListOfFavorites();
}
