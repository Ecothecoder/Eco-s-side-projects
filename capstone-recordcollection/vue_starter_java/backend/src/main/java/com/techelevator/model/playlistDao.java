package com.techelevator.model;

import java.util.List;

public interface playlistDao {


	List<PlaylistItem> getAllPlaylists(User u);

	void addPlaylist(User u, String mambo);

	void changePlaylistName(PlaylistItem better, String name);

	void addAlbum(PlaylistItem ok, int album);

	void deletePlaylist(int apple);

	List<PlaylistItem> getPlaylistIdforSeth(User u);

	List<PlaylistItem> getPlaylistInsidesforSeth(int potato);

	void deleteAlbum(int ok, int album);

}
