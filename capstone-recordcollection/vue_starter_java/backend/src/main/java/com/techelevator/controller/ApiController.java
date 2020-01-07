package com.techelevator.controller;

import com.techelevator.authentication.AuthProvider;
import com.techelevator.authentication.UnauthorizedException;
import com.techelevator.model.FavoriteRecord;
import com.techelevator.model.FavoriteRecordDao;
import com.techelevator.model.PlaylistItem;
import com.techelevator.model.RecordCollection;
import com.techelevator.model.RecordCollectionDao;
import com.techelevator.model.Tracks;
import com.techelevator.model.TracksDao;
import com.techelevator.model.UserDao;
import com.techelevator.model.playlistDao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * ApiController
 */
@CrossOrigin
@RestController
@RequestMapping("/api")
public class ApiController {

	@Autowired
	private AuthProvider authProvider;

	@Autowired
	private FavoriteRecordDao favoriteRecordDao;

	@Autowired
	private RecordCollectionDao recordCollectionDao;

	@Autowired
	private TracksDao tracksDao;

	@Autowired
	private playlistDao playlistDao;
	
	@Autowired
	private UserDao UserDao;

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String authorizedOnly() throws UnauthorizedException {
		/*
		 * You can lock down which roles are allowed by checking if the current user has
		 * a role.
		 * 
		 * In this example, if the user does not have the admin role we send back an
		 * unauthorized error.
		 */
		if (!authProvider.userHasRole(new String[] { "admin" })) {
			throw new UnauthorizedException();
		}
		return "Success";
	}

	@GetMapping(path = "/library")
	public List<FavoriteRecord> getFavoritePokemon() {
		List<FavoriteRecord> result = new ArrayList<FavoriteRecord>();
		if (authProvider.getCurrentUser() != null) {
			return favoriteRecordDao.getFavoritesForUser(authProvider.getCurrentUser());
		}
		return result;
	}

	@PostMapping(path = "/library")
	public FavoriteRecord addFavoriteRecords(@RequestBody FavoriteRecord fr) {
		FavoriteRecord resultFavoritePokemon = null;
		if (authProvider.getCurrentUser() != null) {
			favoriteRecordDao.addFavoriteRecords(authProvider.getCurrentUser(), fr);
		}
		return resultFavoritePokemon;
	}

	@DeleteMapping(path = "/library/{id}")
	public void deleteBadRecord(@PathVariable int id) {
		if (authProvider.getCurrentUser() != null) {
			favoriteRecordDao.deleteFavoriteRecord(authProvider.getCurrentUser(), id);
		}
	}

	@PutMapping("/library/{id}")
	public void makeNotesForRecords(@PathVariable int id, @RequestBody String notes) {
		if (authProvider.getCurrentUser() != null) {
			favoriteRecordDao.updateNotesOnRecord(authProvider.getCurrentUser(), id, notes);
		}
	}

	@GetMapping("/records")
	public List<RecordCollection> getAllTheRecords() {
		return recordCollectionDao.getAllRecords();
	}

	@GetMapping("/records/{id}")
	public List<Tracks> getAllTracks(@PathVariable int id) {
		return tracksDao.getAllTracks(id);
	}

	@GetMapping("/album/{id}")
	public RecordCollection getAlbumsCollection(@PathVariable int id) {
		return recordCollectionDao.getOneRecords(id);
	}

	@GetMapping("/playlist")
	public List<PlaylistItem> getAllPlaylists() {
		List<PlaylistItem> result = new ArrayList<PlaylistItem>();
		if (authProvider.getCurrentUser() != null) {
			return playlistDao.getAllPlaylists(authProvider.getCurrentUser());
		}
		return result;
	}
	
	@PostMapping("/playlist")
	public PlaylistItem addNewPlaylist(@RequestBody String mambo){
		PlaylistItem result = null;
		if (authProvider.getCurrentUser() != null) {
			playlistDao.addPlaylist(authProvider.getCurrentUser(), mambo);
		}
		return result;
	}
	
	@DeleteMapping("/playlist/{id}")
	public void deleteEntirePlaylist(@PathVariable int id){
		playlistDao.deletePlaylist(id);
	}
	
	@PutMapping("/playlist")
	public void updateNameOfPlaylist(@RequestBody PlaylistItem playlist, @RequestBody String name) {
		playlistDao.changePlaylistName(playlist, name);
	}
	
	@PostMapping("/playlistInsides/{id}")
	public void addAlbumToPlaylist(@RequestBody PlaylistItem playlist, @PathVariable int id) {
		playlistDao.addAlbum(playlist, id);
	}

	@DeleteMapping("/playlistInsides/{id}")
	public void deleteAlbumToPlaylist(@RequestBody int playlist, @PathVariable int id) {
		playlistDao.deleteAlbum(playlist, id);
	}
	
	@GetMapping("/seth")
	public List<PlaylistItem> getPlaylistNames(){
		List<PlaylistItem> result = new ArrayList<PlaylistItem>();
		if (authProvider.getCurrentUser() != null) {
			return playlistDao.getPlaylistIdforSeth(authProvider.getCurrentUser());
		}
		return result;
	}
	
	@GetMapping("/seth/{id}")
	public List<PlaylistItem> getInsidesOfPlaylist(@PathVariable int id){
		return playlistDao.getPlaylistInsidesforSeth(id);
		
	}
	
	@PutMapping("/userPremium")
	public void upgradeUserToPremium() {
		UserDao.changeUserToPimping(authProvider.getCurrentUser());
	}
}