package com.rohlik.spotify_degustator.rest;


import com.rohlik.spotify_degustator.model.DegustatorArtist;
import com.rohlik.spotify_degustator.model.paging.PagingParent;
import com.rohlik.spotify_degustator.model.spotifyModels.Artist;
import com.rohlik.spotify_degustator.model.spotifyModels.Track;
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

    @GetMapping("/artist/{id}")
    public Artist getArtist(@PathVariable String id) {
        return spotifyService.getArtist(id);
    }

    @GetMapping("/artist/{id}/albums")
    public PagingParent getAlbumsByArtist(@PathVariable String id) {
        return spotifyService.getAlbumsByArtist(id);
    }

    @GetMapping("/track/{id}")
    public Track getTrack(@PathVariable String id) {
        return spotifyService.getTrack(id);
    }

    @GetMapping("/album/{id}/tracks")
    public List<Track> getTracksFromAlbum(@PathVariable String id) {
        return spotifyService.getTracksFromAlbum(id);
    }

    @GetMapping("/artist-and-album/{id}")
    public DegustatorArtist getArtistAndAlbums(@PathVariable String id) {
        return spotifyService.getArtistAndAlbums(id);
    }

    @GetMapping("/search-artists/{name}")
    public List<Artist> searchArtists(@PathVariable String name) {
        return spotifyService.searchArtist(name);
    }

}
