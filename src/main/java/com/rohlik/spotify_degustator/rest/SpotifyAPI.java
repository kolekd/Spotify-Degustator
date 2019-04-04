package com.rohlik.spotify_degustator.rest;


import com.rohlik.spotify_degustator.model.spotifyModels.Paging;
import com.rohlik.spotify_degustator.model.spotifyModels.Artist;
import com.rohlik.spotify_degustator.storage.LocalStorage;
import com.rohlik.spotify_degustator.service.SpotifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/spotify")
public class SpotifyAPI {

    SpotifyService spotifyService;
    LocalStorage localStorage;

    @Autowired
    public SpotifyAPI(SpotifyService spotifyService, LocalStorage localStorage) {
        this.spotifyService = spotifyService;
        this.localStorage = localStorage;
    }


    @PostMapping("/auth")
    public ResponseEntity authorize() {
        spotifyService.authorize();
        return ResponseEntity.ok("Authorization successful: Token retrieved.");
    }

    @GetMapping("/artists/{id}")
    public Artist getArtist(@PathVariable String id) {
        return spotifyService.getArtist(id);
    }

    @GetMapping("/albums/{id}")
    public Paging getTrack(@PathVariable String id) {
        return spotifyService.getAlbumsByArtist(id);
    }

    // TODO
    @GetMapping("/search-artists/{name}")
    public List<Artist> searchArtists(@PathVariable String name) {
        return spotifyService.searchArtist(name);
    }

}
