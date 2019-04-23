package com.rohlik.spotify_degustator.controller;

import com.rohlik.spotify_degustator.model.DegustatorArtist;
import com.rohlik.spotify_degustator.model.spotifyModels.Artist;
import com.rohlik.spotify_degustator.model.spotifyModels.Track;
import com.rohlik.spotify_degustator.service.DegustatorService;
import com.rohlik.spotify_degustator.service.SpotifyService;
import com.rohlik.spotify_degustator.storage.LocalStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
public class WebController {

    LocalStorage localStorage;
    SpotifyService spotifyService;
    DegustatorService degustatorService;

    private boolean hasntSearchedYet = true;

    @Autowired
    public WebController(LocalStorage localStorage, SpotifyService spotifyService, DegustatorService degustatorService) {
        this.localStorage = localStorage;
        this.spotifyService = spotifyService;
        this.degustatorService = degustatorService;
    }

    @GetMapping
    public String index(Model model) {
        List<Artist> artistList = new ArrayList<>();
        if (!(localStorage.getFoundArtists() == null)) {
            artistList.addAll(localStorage.getFoundArtists());
        }
        model.addAttribute("artists", artistList);
        model.addAttribute("first", hasntSearchedYet);
        return "index";
    }

    @GetMapping("/playlist")
    public String playlistPage(Model model) {
        List<Track> trackList = new ArrayList<>();
        DegustatorArtist artist = new DegustatorArtist();
        if (!(localStorage.getTrackList() == null) && !(localStorage.getArtist() == null)) {
            trackList.addAll(localStorage.getTrackList());
            artist = localStorage.getArtist();
        }
        model.addAttribute("tracks", trackList);
        model.addAttribute("artist", artist);
        return "playlist";
    }

    @PostMapping("/generate/{id}")
    public String getArtist(@PathVariable String id) {
        degustatorService.saveArtist(id);
        degustatorService.generatePlaylist();
        return "redirect:/playlist";
    }

    @PostMapping("/search")
    public String searchArtists(@RequestParam("search_input") String searchInput) {
        spotifyService.searchArtist(searchInput);
        hasntSearchedYet = false;
        return "redirect:/";
    }

}
