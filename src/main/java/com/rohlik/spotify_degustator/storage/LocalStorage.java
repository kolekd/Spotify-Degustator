package com.rohlik.spotify_degustator.storage;

import com.rohlik.spotify_degustator.model.DegustatorAlbum;
import com.rohlik.spotify_degustator.model.DegustatorArtist;
import com.rohlik.spotify_degustator.model.spotifyModels.Album;
import com.rohlik.spotify_degustator.model.spotifyModels.Artist;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class LocalStorage {

    private String token;
    private DegustatorArtist artist;

    public LocalStorage() {}

    public DegustatorArtist saveArtist(Artist artist, List<DegustatorAlbum> degustatorAlbums) {
        log.info("Saving artist ID: " + artist.getId());

        DegustatorArtist degustatorArtist = new DegustatorArtist(
                artist.getId(), artist.getName(), degustatorAlbums
        );

        setArtist(degustatorArtist);
        log.info("Saved artist ID: " + degustatorArtist.getId());

        return degustatorArtist;
    }


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public DegustatorArtist getArtist() {
        return artist;
    }

    public void setArtist(DegustatorArtist artist) {
        this.artist = artist;
    }
}
