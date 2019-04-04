package com.rohlik.spotify_degustator.service;

import com.rohlik.spotify_degustator.model.DegustatorAlbum;
import com.rohlik.spotify_degustator.model.DegustatorArtist;
import com.rohlik.spotify_degustator.model.spotifyModels.Album;
import com.rohlik.spotify_degustator.model.spotifyModels.Artist;
import com.rohlik.spotify_degustator.model.spotifyModels.Track;
import com.rohlik.spotify_degustator.storage.LocalStorage;
import com.rohlik.spotify_degustator.util.SafeIndex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class DegustatorService {

    LocalStorage localStorage;
    Random r = new Random();

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

    // TODO - PROGRESS
    public List<Track> generatePlaylist() {
        List<Track> trackList = new ArrayList<>();

        List<DegustatorAlbum> albums = localStorage.getArtist().getAlbums();
        List<Track> currentTracks;
        for (int i = 0; i < 20; i++) {
            currentTracks = (albums.get(
                    SafeIndex.nullPointerPreventer(r.nextInt(((albums.size()) - 0) + 1) + 0, albums)
            )).getTracks();
            trackList.add(currentTracks.get(
                    SafeIndex.nullPointerPreventer((r.nextInt((currentTracks.size()) - 0) + 1) + 0, currentTracks)
            ));
        }

        //  Generate random tracks

        System.out.println("| Generated tracklist |");
        for (int i = 0; i < trackList.size(); i++) {
            System.out.println("Track #" + (i + 1) + "  " + trackList.get(i).getName());
        }
        return trackList;
    }

}
