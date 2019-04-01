package com.rohlik.spotify_degustator.model;

import lombok.Data;

@Data
public class Followers {

    String href;
    int total;

    public Followers(String href, int total) {
        this.href = href;
        this.total = total;
    }

    public Followers() {
    }
}
