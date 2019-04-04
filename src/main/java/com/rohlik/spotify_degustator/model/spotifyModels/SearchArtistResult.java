package com.rohlik.spotify_degustator.model.spotifyModels;

import lombok.Data;

import java.util.List;

@Data
public class SearchArtistResult {

    Paging artists;

    public SearchArtistResult() {}

    public SearchArtistResult(Paging artists) {
        this.artists = artists;
    }
}
