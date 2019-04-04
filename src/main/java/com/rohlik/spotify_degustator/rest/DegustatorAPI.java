package com.rohlik.spotify_degustator.rest;

import com.rohlik.spotify_degustator.model.spotifyModels.Track;
import com.rohlik.spotify_degustator.service.DegustatorService;
import com.rohlik.spotify_degustator.storage.LocalStorage;
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


    @GetMapping("/token-check")
    public ResponseEntity checkToken() {
        if((!(localStorage.getToken() == null) && localStorage.getToken().length() > 0)) {
            return ResponseEntity.ok("Token present.");
        } return ResponseEntity.ok("No token present.");
    }

    // TODO
    @PostMapping("/generate-playlist")
    public List<Track> generatePlaylist() {
        return degustatorService.generatePlaylist();
    }

}
