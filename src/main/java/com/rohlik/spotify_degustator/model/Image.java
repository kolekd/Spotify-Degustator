package com.rohlik.spotify_degustator.model;

import lombok.Data;

@Data
public class Image {

    String url;
    int height;
    int width;

    public Image(String url, int height, int width) {
        this.url = url;
        this.height = height;
        this.width = width;
    }

    public Image() {
    }
}
