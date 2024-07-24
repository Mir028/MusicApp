package com.project.music_app.service.impl;

import com.project.music_app.models.Album;
import com.project.music_app.repository.AlbumRepository;
import com.project.music_app.service.Albumservice;

import java.util.List;

public class AlbumServiceImpl implements Albumservice {
    private AlbumRepository albumRepository;

    public AlbumServiceImpl(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @Override
    public List<Album> listAllAlbums() {
       return albumRepository.findAll();
    }

    @Override
    public Album getAlbumById(Long id) {
        return albumRepository.findById(id).orElseThrow();
    }

    @Override
    public Album saveAlbum(Album album) {
        return albumRepository.save(album);
    }

    @Override
    public void deleteAlbum(Album id) {
        albumRepository.delete(id);
    }
}
