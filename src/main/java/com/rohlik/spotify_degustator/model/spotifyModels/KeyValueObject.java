package com.rohlik.spotify_degustator.model.spotifyModels;

import lombok.Data;

@Data
public class KeyValueObject {

    String key;
    String value;

    public KeyValueObject() {}

    public KeyValueObject(String key, String value) {
        this.key = key;
        this.value = value;
    }
}
