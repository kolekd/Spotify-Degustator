package com.rohlik.spotify_degustator.model.spotifyModels;

import lombok.Data;

@Data
public class Album {

    String id;
    String name;
    String type;

    public Album() {}

    public Album(String id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }
}
