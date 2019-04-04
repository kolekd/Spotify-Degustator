package com.rohlik.spotify_degustator.model.spotifyModels;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Artist {

    @JsonProperty("external_urls")
    ExternalUrls externalUrls;
    Followers followers;
    List<String> genres;
    String href;
    String id;
    List<Image> images;
    String name;
    int popularity;
    String type;
    String uri;

    public Artist(ExternalUrls externalUrls, Followers followers, List<String> genres, String href, String id, List<Image> images, String name, int popularity, String type, String uri) {
        this.externalUrls = externalUrls;
        this.followers = followers;
        this.genres = genres;
        this.href = href;
        this.id = id;
        this.images = images;
        this.name = name;
        this.popularity = popularity;
        this.type = type;
        this.uri = uri;
    }

    public Artist(ExternalUrls externalUrls, String href, String id, String name, String type, String uri) {
        this.externalUrls = externalUrls;
        this.href = href;
        this.id = id;
        this.name = name;
        this.type = type;
        this.uri = uri;
    }

    public Artist(String name) {
        this.name = name;
    }

    public Artist() {
    }
}
