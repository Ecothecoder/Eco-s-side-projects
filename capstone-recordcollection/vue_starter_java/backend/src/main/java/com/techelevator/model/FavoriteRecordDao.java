package com.techelevator.model;

import java.util.List;

public interface FavoriteRecordDao {

	List<FavoriteRecord> getFavoritesForUser(User u);
	
	FavoriteRecord addFavoriteRecords(User u, FavoriteRecord fr);

	void deleteFavoriteRecord(User u, int fr);

	void updateNotesOnRecord(User u, int id, String note);

}
