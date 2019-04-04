package com.rohlik.spotify_degustator.model.spotifyModels;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.security.Key;
import java.util.List;

@Data
public class Track {

    String id;
    String name;
    Album album;
    List<Artist> artists;

    @JsonProperty("available_markets")
    String[] availableMarkets;

    @JsonProperty("disc_number")
    int discNumber;

    @JsonProperty("duration_ms")
    int durationMs;
    boolean explicit;

    @JsonProperty("external_ids")
    KeyValueObject externalIds;

    @JsonProperty("external_urls")
    KeyValueObject externalUrls;
    String href;

    @JsonProperty("is_playable")
    boolean isPlayable;

    @JsonProperty("linked_from")
    TrackLink linkedFrom;
    Restrictions restrictions;
    int popularity;

    @JsonProperty("preview_url")
    String previewUrl;

    @JsonProperty("track_number")
    int trackNumber;

    String type;
    String uri;

    public Track() {}

    public Track(String id, String name, Album album, List<Artist> artists, String[] availableMarkets, int discNumber, int durationMs, boolean explicit, KeyValueObject externalIds, KeyValueObject externalUrls, String href, boolean isPlayable, TrackLink linkedFrom, Restrictions restrictions, int popularity, String previewUrl, int trackNumber, String type, String uri) {
        this.id = id;
        this.name = name;
        this.album = album;
        this.artists = artists;
        this.availableMarkets = availableMarkets;
        this.discNumber = discNumber;
        this.durationMs = durationMs;
        this.explicit = explicit;
        this.externalIds = externalIds;
        this.externalUrls = externalUrls;
        this.href = href;
        this.isPlayable = isPlayable;
        this.linkedFrom = linkedFrom;
        this.restrictions = restrictions;
        this.popularity = popularity;
        this.previewUrl = previewUrl;
        this.trackNumber = trackNumber;
        this.type = type;
        this.uri = uri;
    }
}
