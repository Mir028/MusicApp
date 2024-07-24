package com.project.music_app.service;

import com.project.music_app.models.Album;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface Albumservice {
    List<Album> listAllAlbums();
    Album getAlbumById(Long id);
    Album saveAlbum(Album album);
    void deleteAlbum(Album album);
}
