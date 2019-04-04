package com.rohlik.spotify_degustator.model.spotifyModels;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.rohlik.spotify_degustator.model.paging.PagingArtists;
import com.rohlik.spotify_degustator.model.paging.PagingTracks;
import lombok.Data;

import java.util.List;

@Data
public class Album {

    @JsonProperty("album_type")
    String albumType;
    List<Artist> artists;

    @JsonProperty("available_markets")
    List<String> availableMarkets;
    List<Copyright> copyrights;

    // field external_ids is missing - not changing name of an object in the field - no idea how to do that

    @JsonProperty("external_urls")
    ExternalUrls externalUrls;
    List<String> genres;
    String href;
    String id;
    List<Image> images;
    String label;
    String name;
    int popularity;

    @JsonProperty("release_date")
    String releaseDate;

    @JsonProperty("release_date_precision")
    String releaseDatePrecision;
    PagingTracks tracks;
    String type;
    String uri;

    // simplified:
    @JsonProperty("album_group")
    String albumGroup;
    Restrictions restrictions;

    public Album() {}

    public Album(String albumType, List<Artist> artists, List<String> availableMarkets, List<Copyright> copyrights, ExternalUrls externalUrls, List<String> genres, String href, String id, List<Image> images, String label, String name, int popularity, String releaseDate, String releaseDatePrecision, PagingTracks tracks, String type, String uri) {
        this.albumType = albumType;
        this.artists = artists;
        this.availableMarkets = availableMarkets;
        this.copyrights = copyrights;
        this.externalUrls = externalUrls;
        this.genres = genres;
        this.href = href;
        this.id = id;
        this.images = images;
        this.label = label;
        this.name = name;
        this.popularity = popularity;
        this.releaseDate = releaseDate;
        this.releaseDatePrecision = releaseDatePrecision;
        this.tracks = tracks;
        this.type = type;
        this.uri = uri;
    }

    public Album(String albumType, List<Artist> artists, List<String> availableMarkets, ExternalUrls externalUrls, String href, String id, List<Image> images, String name, String releaseDate, String releaseDatePrecision, String type, String uri, String albumGroup, Restrictions restrictions) {
        this.albumGroup = albumGroup;
        this.albumType = albumType;
        this.artists = artists;
        this.availableMarkets = availableMarkets;
        this.externalUrls = externalUrls;
        this.href = href;
        this.id = id;
        this.images = images;
        this.name = name;
        this.releaseDate = releaseDate;
        this.releaseDatePrecision = releaseDatePrecision;
        this.restrictions = restrictions;
        this.type = type;
        this.uri = uri;
    }
}
