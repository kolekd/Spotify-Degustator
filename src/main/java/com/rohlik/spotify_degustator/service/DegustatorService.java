package com.rohlik.spotify_degustator.service;

import com.rohlik.spotify_degustator.model.DegustatorAlbum;
import com.rohlik.spotify_degustator.model.DegustatorArtist;
import com.rohlik.spotify_degustator.model.spotifyModels.Album;
import com.rohlik.spotify_degustator.model.spotifyModels.Artist;
import com.rohlik.spotify_degustator.model.spotifyModels.Track;
import com.rohlik.spotify_degustator.storage.LocalStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class DegustatorService {

    LocalStorage localStorage;

    @Autowired
    public DegustatorService(LocalStorage localStorage) {
        this.localStorage = localStorage;
    }

    public ResponseEntity checkTokenPresence() {
        if((!(localStorage.getToken() == null) && localStorage.getToken().length() > 0)) {
            return ResponseEntity.ok("Token present.");
        } return ResponseEntity.ok("No token present.");
    }

    public String checkToken() {
        return localStorage.getToken();
    }

    public DegustatorArtist checkSavedArtist() {
        return localStorage.getArtist();
    }

    // TODO
    public List<Track> generatePlaylist() {
        List<Track> trackList = new ArrayList<>();

//        Random r = new Random();
//        r.nextInt((max - min) + 1) + min;
        //  Generate random tracks

        return trackList;
    }

}
