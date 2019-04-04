package com.rohlik.spotify_degustator.model.spotifyModels;

import lombok.Data;

import java.util.List;

@Data
public class SearchArtistResult {

    List<Artist> artists;

    public SearchArtistResult() {}

    public SearchArtistResult(List<Artist> artists) {
        this.artists = artists;
    }
}
