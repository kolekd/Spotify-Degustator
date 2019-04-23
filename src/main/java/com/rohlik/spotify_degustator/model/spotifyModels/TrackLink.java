package com.rohlik.spotify_degustator.model.spotifyModels;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TrackLink {

    String id;

    @JsonProperty("external_urls")
    ExternalUrls externalUrls;
    String href;
    String type;
    String uri;

    public TrackLink() {}

    public TrackLink(String id, ExternalUrls externalUrls, String href, String type, String uri) {
        this.id = id;
        this.externalUrls = externalUrls;
        this.href = href;
        this.type = type;
        this.uri = uri;
    }
}
