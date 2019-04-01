package com.rohlik.spotify_degustator.controller;

import com.rohlik.spotify_degustator.model.Artist;
import com.rohlik.spotify_degustator.service.SpotifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/degustator")
public class DegustatorRest {

    SpotifyService spotifyService;

    @Autowired
    public DegustatorRest(SpotifyService spotifyService) {
        this.spotifyService = spotifyService;
    }

    @PostMapping("/auth")
    public ResponseEntity authorize() {
        spotifyService.authorize();
        return ResponseEntity.ok().build();
    }

    @GetMapping("/artists/{id}")
    public Artist getArtist(@PathVariable String id) {
        return spotifyService.getArtist(id);
    }
}
