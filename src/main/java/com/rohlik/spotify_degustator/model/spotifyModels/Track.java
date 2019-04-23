package com.rohlik.spotify_degustator.model.spotifyModels;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.security.Key;
import java.util.List;

@Data
public class Track {

    Album album;
    List<Artist> artists;
    @JsonProperty("available_markets")
    List<String> availableMarkets;

    @JsonProperty("disc_number")
    int discNumber;

    @JsonProperty("duration_ms")
    int durationMs;
    boolean explicit;

    // field external_ids is missing - not changing name of an object in the field - no idea how to do that

    @JsonProperty("external_urls")
    ExternalUrls externalUrls;
    String href;
    String id;

    @JsonProperty("is_playable")
    boolean isPlayable;

    @JsonProperty("linked_from")
    TrackLink linkedFrom;
    Restrictions restrictions;
    String name;
    int popularity;

    @JsonProperty("preview_url")
    String previewUrl;

    @JsonProperty("track_number")
    int trackNumber;

    String type;
    String uri;

    @JsonProperty("is_local")
    boolean isLocal;

    public Track() {}

    public Track(Album album, List<Artist> artists, List<String> availableMarkets, int discNumber, int durationMs, boolean explicit, ExternalUrls externalUrls, String href, String id, boolean isPlayable, TrackLink linkedFrom, Restrictions restrictions, String name, int popularity, String previewUrl, int trackNumber, String type, String uri, boolean isLocal) {
        this.album = album;
        this.artists = artists;
        this.availableMarkets = availableMarkets;
        this.discNumber = discNumber;
        this.durationMs = durationMs;
        this.explicit = explicit;
        this.externalUrls = externalUrls;
        this.href = href;
        this.id = id;
        this.isPlayable = isPlayable;
        this.linkedFrom = linkedFrom;
        this.restrictions = restrictions;
        this.name = name;
        this.popularity = popularity;
        this.previewUrl = previewUrl;
        this.trackNumber = trackNumber;
        this.type = type;
        this.uri = uri;
        this.isLocal = isLocal;
    }

    public Track(List<Artist> artists, List<String> availableMarkets, int discNumber, int durationMs, boolean explicit, ExternalUrls externalUrls, String href, String id, boolean isPlayable, TrackLink linkedFrom, Restrictions restrictions, String name, String previewUrl, int trackNumber, String type, String uri, boolean isLocal) {
        this.artists = artists;
        this.availableMarkets = availableMarkets;
        this.discNumber = discNumber;
        this.durationMs = durationMs;
        this.explicit = explicit;
        this.externalUrls = externalUrls;
        this.href = href;
        this.id = id;
        this.isPlayable = isPlayable;
        this.linkedFrom = linkedFrom;
        this.restrictions = restrictions;
        this.name = name;
        this.previewUrl = previewUrl;
        this.trackNumber = trackNumber;
        this.type = type;
        this.uri = uri;
        this.isLocal = isLocal;
    }
}
