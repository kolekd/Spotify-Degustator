package com.rohlik.spotify_degustator.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Artist {

    String id;
    String name;
    List<String> genres = new ArrayList<>();
    @JsonProperty("external_urls")
    ExternalUrls externalUrls;
    Followers followers = new Followers();
    String href;
    List<Image> images = new ArrayList<>();
    int popularity;
    String type;
    String uri;

    public Artist(String id, String name, List<String> genres, ExternalUrls externalUrls, Followers followers, String href, List<Image> images, int popularity, String type, String uri) {
        this.id = id;
        this.name = name;
        this.genres = genres;
        this.externalUrls = externalUrls;
        this.followers = followers;
        this.href = href;
        this.images = images;
        this.popularity = popularity;
        this.type = type;
        this.uri = uri;
    }

    public Artist() {
    }
}
