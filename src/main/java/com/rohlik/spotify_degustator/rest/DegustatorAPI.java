package com.rohlik.spotify_degustator.rest;

import com.rohlik.spotify_degustator.model.DegustatorArtist;
import com.rohlik.spotify_degustator.model.spotifyModels.Track;
import com.rohlik.spotify_degustator.service.DegustatorService;
import com.rohlik.spotify_degustator.storage.LocalStorage;
import com.rohlik.spotify_degustator.storage.Settings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/degustator")
public class DegustatorAPI {

    DegustatorService degustatorService;
    LocalStorage localStorage;

    @Autowired
    public DegustatorAPI(DegustatorService degustatorService, LocalStorage localStorage) {
        this.degustatorService = degustatorService;
        this.localStorage = localStorage;
    }


    @GetMapping("/token-check-presence")
    public ResponseEntity checkTokenPresence() {
        return degustatorService.checkTokenPresence();
    }

    @GetMapping("/token-check")
    public String checkToken() {
        return degustatorService.checkToken();
    }

    @GetMapping("/artist-check")
    public DegustatorArtist checkSavedArtist() {
        return degustatorService.checkSavedArtist();
    }

    @GetMapping("/settings-check")
    public Settings checkSetting() {
        return degustatorService.checkSettings();
    }

    @GetMapping("/save/{id}")
    public DegustatorArtist getArtistAndAlbums(@PathVariable String id) {
        return degustatorService.saveArtist(id);
    }

    @GetMapping("/generate-playlist")
    public List<Track> generatePlaylist() {
        return degustatorService.generatePlaylist();
    }

}
