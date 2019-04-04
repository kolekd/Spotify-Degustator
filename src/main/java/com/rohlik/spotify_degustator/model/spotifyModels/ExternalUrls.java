package com.rohlik.spotify_degustator.model.spotifyModels;

import lombok.Data;

@Data
public class ExternalUrls {

    String spotify;

    public ExternalUrls(String spotify) {
        this.spotify = spotify;
    }

    public ExternalUrls() {
    }
}
