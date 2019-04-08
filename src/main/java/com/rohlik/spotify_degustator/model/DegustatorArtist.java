package com.rohlik.spotify_degustator.model;

import com.rohlik.spotify_degustator.model.spotifyModels.Album;
import com.rohlik.spotify_degustator.model.spotifyModels.Track;
import lombok.Data;

import java.util.List;

@Data
public class DegustatorArtist {

    String id;
    String name;
    List<DegustatorAlbum> albums;
    List<Track> allTracks;

    public DegustatorArtist() {}

    public DegustatorArtist(String id, String name, List<Track> allTracks) {
        this.id = id;
        this.name = name;
        this.allTracks = allTracks;
    }
}
