package com.project.music_app.repository;

import com.project.music_app.models.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Songrepository extends JpaRepository<Song,Long> {
}
