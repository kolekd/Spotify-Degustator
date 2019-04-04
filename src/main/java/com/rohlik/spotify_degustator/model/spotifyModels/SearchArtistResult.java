package com.rohlik.spotify_degustator.model.spotifyModels;

import com.rohlik.spotify_degustator.model.paging.PagingArtists;
import lombok.Data;

@Data
public class SearchArtistResult {

    PagingArtists artists;

    public SearchArtistResult() {}

    public SearchArtistResult(PagingArtists artists) {
        this.artists = artists;
    }
}
