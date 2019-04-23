package com.rohlik.spotify_degustator.storage;

import com.rohlik.spotify_degustator.model.DegustatorAlbum;
import com.rohlik.spotify_degustator.model.DegustatorArtist;
import com.rohlik.spotify_degustator.model.spotifyModels.Album;
import com.rohlik.spotify_degustator.model.spotifyModels.Artist;
import com.rohlik.spotify_degustator.model.spotifyModels.Track;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class LocalStorage {

    private String token;
    private DegustatorArtist artist;
    private List<Track> trackList;
    private List<Artist> foundArtists;
    private Settings settings = new Settings();

    public LocalStorage() {}


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

    public List<Track> getTrackList() {
        return trackList;
    }

    public void setTrackList(List<Track> trackList) {
        this.trackList = trackList;
    }

    public Settings getSettings() {
        return settings;
    }

    public void setSettings(Settings settings) {
        this.settings = settings;
    }

    public List<Artist> getFoundArtists() {
        return foundArtists;
    }

    public void setFoundArtists(List<Artist> foundArtists) {
        this.foundArtists = foundArtists;
    }
}
