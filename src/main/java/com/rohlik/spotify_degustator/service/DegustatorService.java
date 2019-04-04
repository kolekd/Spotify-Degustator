package com.rohlik.spotify_degustator.service;

import com.rohlik.spotify_degustator.model.spotifyModels.Track;
import com.rohlik.spotify_degustator.storage.LocalStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DegustatorService {

    LocalStorage localStorage;

    @Autowired
    public DegustatorService(LocalStorage localStorage) {
        this.localStorage = localStorage;
    }


    // TODO
    public List<Track> generatePlaylist(
            //  albums, singles and shit
    ) {
        List<Track> trackList = new ArrayList<>();

        //  Generate random tracks

        return trackList;
    }

}
