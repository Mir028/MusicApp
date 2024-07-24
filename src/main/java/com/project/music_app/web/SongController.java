package com.project.music_app.web;

import com.project.music_app.models.Song;
import com.project.music_app.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SongController {
    private final SongService songService;

    public SongController(SongService songService) {
        this.songService = songService;
    }

    @GetMapping({"/songs","/"})
    public String ShowSong(Model model){
        model.addAttribute("songs",songService.listAllSongs());
        return "index";
    }

    @GetMapping("/create")
    public String ShowCreate(){
        return "create";
    }

    @PostMapping("/create")
    public String Create(@RequestParam String name, @RequestParam String artist,
                         @RequestParam int duration){
        songService.saveSong(name, artist, duration);
        return "redirect:/songs";
    }

    @PostMapping("/songs/{id}/delete")
    public String Delete(@PathVariable Long id){
        songService.deleteSong(songService.getSongById(id));
        return "redirect:/songs";
    }
}
