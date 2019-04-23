package com.rohlik.spotify_degustator.model;

import com.rohlik.spotify_degustator.model.spotifyModels.Track;
import lombok.Data;

import java.util.List;

@Data
public class DegustatorAlbum {

    String id;
    String name;
    List<Track> tracks;

    public DegustatorAlbum() {}

    public DegustatorAlbum(String id, String name, List<Track> tracks) {
        this.id = id;
        this.name = name;
        this.tracks = tracks;
    }
}
