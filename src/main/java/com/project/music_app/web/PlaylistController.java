package com.project.music_app.web;

import com.project.music_app.models.Playlist;
import com.project.music_app.models.Song;
import com.project.music_app.service.PlaylistService;
import com.project.music_app.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PlaylistController {
    private final PlaylistService playlistService;
    private final SongService songService;

    public PlaylistController(PlaylistService playlistService, SongService songService) {
        this.playlistService = playlistService;
        this.songService = songService;
    }

    @GetMapping("/playlist")
    public String showPlaylist(Model model){
        model.addAttribute("playlist", playlistService.getAllPlaylists());
        return "playlist";
    }

    @GetMapping("/createplay")
    public String showCreate(Model model){
        model.addAttribute("songs",songService.listAllSongs());
        return "createplay";
    }

    @PostMapping("/createplay")
    public String CreatePlay(@RequestParam String name, @RequestParam List<Long> songs){
        List<Song> songList = songService.getAllSongsByIds(songs);
        playlistService.savePlaylist(name, songList);
        return "redirect:/playlist";
    }

    @GetMapping("/playlist/{id}")
    public String viewPlaylist(@PathVariable Long id, Model model) {
        Playlist playlist = playlistService.getPlaylistById(id);
        model.addAttribute("songs",playlist.getSongs());
        model.addAttribute("playlist", playlist);
        return "details";
    }
}
