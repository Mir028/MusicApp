package com.project.music_app.service.impl;

import com.project.music_app.models.Playlist;
import com.project.music_app.models.Song;
import com.project.music_app.repository.PlaylistRepository;
import com.project.music_app.service.PlaylistService;
import com.project.music_app.service.SongService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlaylistServiceImpl implements PlaylistService {
    private PlaylistRepository playlistRepository;
    private SongService songService;

    public PlaylistServiceImpl(PlaylistRepository playlistRepository, SongService songService) {
        this.playlistRepository = playlistRepository;
        this.songService = songService;
    }

    @Override
    public List<Playlist> getAllPlaylists() {
        return playlistRepository.findAll();
    }

    @Override
    public Playlist getPlaylistById(Long id) {
        return playlistRepository.findById(id).orElseThrow();
    }

    @Override
    public Playlist savePlaylist(String name, List<Song> songs) {
        Playlist playlist = new Playlist(name,songs);
        playlist.setName(name);
        playlist.setSongs(songs);
        return playlistRepository.save(playlist);
    }

    @Override
    public void deletePlaylist(Playlist playlist) {
        playlistRepository.delete(playlist);
    }
}
