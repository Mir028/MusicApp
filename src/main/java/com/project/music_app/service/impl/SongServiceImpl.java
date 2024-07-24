package com.project.music_app.service.impl;

import com.project.music_app.models.Song;
import com.project.music_app.repository.Songrepository;
import com.project.music_app.service.SongService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements SongService {
    private Songrepository songrepository;

    public SongServiceImpl(Songrepository songrepository) {
        this.songrepository = songrepository;
    }

    @Override
    public List<Song> listAllSongs() {
        return songrepository.findAll();
    }

    @Override
    public Song getSongById(Long id) {
        return songrepository.findById(id).orElseThrow();
    }

    @Override
    public Song saveSong(String name, String artist, int duration) {
        Song song = new Song(name,artist,duration);
        songrepository.save(song);
        return song;
    }


    @Override
    public void deleteSong(Song song) {
        songrepository.delete(song);
    }

    @Override
    public List<Song> getAllSongsByIds(List<Long> songIds) {
        return songrepository.findAllById(songIds);
    }
}
