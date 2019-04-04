package com.rohlik.spotify_degustator.model.spotifyModels;

import lombok.Data;

@Data
public class Copyright {

    String text;
    String type;

    public Copyright() {}

    public Copyright(String text, String type) {
        this.text = text;
        this.type = type;
    }
}
