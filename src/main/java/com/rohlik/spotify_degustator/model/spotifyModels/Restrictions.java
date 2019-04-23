package com.rohlik.spotify_degustator.model.spotifyModels;

import lombok.Data;

@Data
public class Restrictions {

    String reason;

    public Restrictions() {}

    public Restrictions(String reason) {
        this.reason = reason;
    }
}
