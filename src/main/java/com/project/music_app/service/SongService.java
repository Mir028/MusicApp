package com.project.music_app.service;

import com.project.music_app.models.Song;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SongService {
    List<Song> listAllSongs();
    Song getSongById(Long id);
    Song saveSong(String name, String Artist, int duration);
    void deleteSong(Song song);
    List<Song> getAllSongsByIds(List<Long> songIds);
}
