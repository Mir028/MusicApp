package com.project.music_app.service;

import com.project.music_app.models.Playlist;
import com.project.music_app.models.Song;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PlaylistService {
    List<Playlist> getAllPlaylists();
    Playlist getPlaylistById(Long id);
    Playlist savePlaylist(String name, List<Song> songs);
    void deletePlaylist(Playlist playlist);
}
